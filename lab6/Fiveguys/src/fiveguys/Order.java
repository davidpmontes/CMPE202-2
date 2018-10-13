package fiveguys;

import java.util.List;
import java.util.Random;

class OrderItem {
    public IComponent item;
    public int quantity;

    public OrderItem(IComponent item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }
}

enum PrintStrategy {
    RECEIPT, PACKAGING
}

public class Order {

    private static IPrintStrategy receiptStrategy = new IPrintStrategy() {

        @Override
        public StringBuilder printDetail(Order order) {
            StringBuilder out = new StringBuilder();
            out.append(String.format("Order Number: %d%n%n", order.getOrderNumber()));
            for (OrderItem i : order.getItems()) {
                out.append(String.format("%-4d%-20s%4.2f%n", i.quantity, i.item.getDescription(), i.item.getPrice()));
                IComponent subComponent = i.item.getSubComponent();
                while (subComponent != null) {
                    out.append(String.format("    %s%n", subComponent.getDescription()));
                    subComponent = subComponent.getSubComponent();
                }
            }
            out.append(String.format("%nSub. Total: %4.2f%n%n", order.getSubtotal()));
            return out;
        }

    };
    private static IPrintStrategy packagingStrategy = new IPrintStrategy() {

        @Override
        public StringBuilder printDetail(Order order) {
            return null;
        }

    };
    private List<OrderItem> items;
    private double subtotal = 0;
    private int orderNumber;
    private PrintStrategy printStrategy = PrintStrategy.RECEIPT;

    public Order() {
        Random r = new Random();
        this.orderNumber = r.nextInt(100);
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void addItem(IComponent item, int quantity) {
        items.add(new OrderItem(item, quantity));
        subtotal += item.getPrice() * quantity;
    }

    public String printOrder(PrintStrategy ps) {
        if (ps == PrintStrategy.RECEIPT)
            return receiptStrategy.printOrder(this);
        else if (ps == PrintStrategy.PACKAGING)
            return packagingStrategy.printOrder(this);
        return currentPrintStrategy.printOrder(this);
    }

    @Override
    public String toString() {
        return currentPrintStrategy.printOrder(this);
    }
}
