package fiveguys;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

enum PrintStrategy {
    RECEIPT, PACKAGING
}

abstract class PrintBuilder {

    protected boolean border = true;
    protected static final int slipWidth = 36;
    protected StringBuilder out;

    public PrintBuilder() {
        this.out = new StringBuilder();
    }

    public abstract String printOrder(Order order);

    protected PrintBuilder printInfo() {
        return this.printOnCenter("FIVE GUYS")
                .printOnCenter("BURGER AND FRIES")
                .printOnCenter("STORE # CA-1294")
                .printOnCenter("5353 ALMADEN EXPY N60")
                .printOnCenter("SAN JOSE, CA 95118")
                .printOnCenter("(P) 408-274-9300")
                .printSpace();
    }

    protected PrintBuilder printHeader() {
        return this.printTime()
                .printOnCenter("FIVE GUYS");
    }

    protected PrintBuilder printDetail(Order order) {
        for (IOrderItem item : order.getItems()) {
            this.printItem(item);
            if (item instanceof Burger)
                this.printToppings(((Burger) item).getToppings());
        }
        return this;
    };

    protected PrintBuilder printOrderNumber(Order order) {
        return this.printOnLeft("Order Number: "+order.getOrderNumber());
    }

    protected PrintBuilder printCheckOut(Order order, double cash) {
        double subtotal = order.getSubtotal();
        double tax = subtotal * 0.09;
        double total = subtotal + tax;
        double change = cash - total;

        return this.printSpace()
                .padding(4).print("Sub. Total:").padding(slipWidth-23)
                .println(wrapCurrency(subtotal))
                .padding(4).print("Tax:").padding(slipWidth-16)
                .println(wrapCurrency(tax))
                .padding(4).print("Total:").padding(slipWidth-18)
                .println(wrapCurrency(total))
                .printSpace()
                .padding(4).print("Cash").padding(slipWidth-16)
                .println(wrapCurrency(cash))
                .padding(4).print("Change").padding(slipWidth-18)
                .println(wrapCurrency(change));
    }

    protected PrintBuilder printCashier() {
        return this.print("Register:")
                .print(String.format("%2d",1))
                .padding(slipWidth - 31)
                .print("Tran Seq No:")
                .println(String.format("%8d",57845))
                .printOnLeft("Cashier: Sakda* S.");
    };

    protected PrintBuilder printTime() {
        return this.printOnCenter(
                new SimpleDateFormat("MM/d/yyyy hh:mm:ss").format(new Date())
        );
    }

    protected PrintBuilder printFooter() {
        return this
                .printOnCenter("**************************")
                .printOnLeft("Don't throw away your receipt.")
                .printSpace();
    }

    protected PrintBuilder printItem(IOrderItem item) {
        return this.print(String.format("%-4d", item.getQuantity()))
                .print(String.format("%-26s",item.getDescription()))
                .println(String.format("%6.2f",item.getPrice()));
    }

    protected PrintBuilder printToppings(List<Topping> items) {
        for (Topping item: items) {
            this.printOnLeft(wrapTopping(item), 4);
        }
        return this;
    }

    protected PrintBuilder printToppings(List<Topping> items, ToppingPosition filter) {
        for (Topping item: items) {
            if (item.getPosition() == filter)
                this.printOnLeft(wrapTopping(item), 4);
        }
        return this;
    }

    protected PrintBuilder printOnCenter(String s) {
        if (s.length()>=slipWidth)
            return this.println(s);
        int pad = slipWidth - s.length();
        return this.padding(pad/2)
                .print(s)
                .padding(pad-pad/2)
                .println();
    }

    protected PrintBuilder printOnLeft(String s, int padLeft) {
        int pad = slipWidth - s.length()-padLeft;
        return this.padding(padLeft)
                .print(s)
                .padding(pad)
                .println();
    }

    protected PrintBuilder printOnLeft(String s) {
        return this.printOnLeft(s,0);
    }

    protected PrintBuilder printSpace() {
        return this.padding(slipWidth)
                .println();
    }

    private PrintBuilder padding(int space) {
        for (int i = 0; i < space; i++)
            out.append(' ');
        return this;
    }

    private PrintBuilder print(String s) {
        out.append(s);
        return this;
    }

    private PrintBuilder println() {
        if (border) out.append("  |");
        out.append('\n');
        if (border) out.append("|  ");
        return this;
    }

    private PrintBuilder println(String s) {
        out.append(s);
        return this.println();
    }

    static String wrapCurrency(double amount) {
        return String.format("%8s", String.format("$%.2f", amount));
    }

    static String wrapTopping(Topping t) {
        String format;
        switch (t.getPosition()) {
            case BOTTOM:
                format = "{{{{ %s }}}}"; break;
            case MIDDLE:
                format = "->| %s"; break;
            case TOP:
            default:
                format = "%s";
        }
        return String.format(format, t.getDescription());
    }

    @Override
    public String toString() {
        if (border) {
            out.insert(0, "|  ");
            out.insert(0,'\n');
            for (int i = 0; i < slipWidth+6 ; i++) out.insert(0,'-');
            out.delete(out.length() - 3, out.length());
            for (int i = 0; i < slipWidth+6 ; i++) out.append('-');
            out.append('\n');
        }
        return out.toString();
    }
}

public class Printer {

    private static PrintBuilder receiptBuilder = new PrintBuilder() {

        @Override
        public String printOrder(Order order) {
            out = new StringBuilder();
            return this
                    .printInfo()
                    .printHeader()
                    .printOrderNumber(order)
                    .printDetail(order)
                    .printCheckOut(order, 20)
                    .printCashier()
                    .printFooter()
                    .toString();
        }

    };

    private static PrintBuilder packagingBuilder = new PrintBuilder() {

        @Override
        public String printOrder(Order order) {
            out = new StringBuilder();
            return this
                    .printOrderNumber(order)
                    .printHeader()
                    .printDetail(order)
                    .printCashier()
                    .toString();
        }

        @Override
        protected PrintBuilder printToppings(List<Topping> topping) {
            return this
                    .printToppings(topping, ToppingPosition.TOP)
                    .printToppings(topping, ToppingPosition.MIDDLE)
                    .printToppings(topping, ToppingPosition.BOTTOM);
        }
    };

    public static void printOrder(Order order, PrintStrategy ps) {
        if (ps == PrintStrategy.RECEIPT)
            System.out.println(receiptBuilder.printOrder(order));
        else if (ps == PrintStrategy.PACKAGING)
            System.out.println(packagingBuilder.printOrder(order));
    }

}
