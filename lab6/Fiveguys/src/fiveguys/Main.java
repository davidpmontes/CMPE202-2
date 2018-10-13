package fiveguys;

public class Main {

    public static void main(String[] args) {
        Order order = new Order();

        Burger burger = new Burger("LBB",5.59);
        burger.addTopping(new Topping("BACON",ToppingPosition.BOTTOM));
        burger.addTopping(new Topping("LETTUCE",ToppingPosition.TOP));
        burger.addTopping(new Topping("TOMATO",ToppingPosition.TOP));
        burger.addTopping(new Topping("G ONION",ToppingPosition.MIDDLE));
        burger.addTopping(new Topping("JALA Grilled",ToppingPosition.MIDDLE));
        Fries fries = new Fries("LTL CAJ", 2.79);

        order.addItem(burger);
        order.addItem(fries);

        System.out.println("RECEIPT:");
        Printer.printOrder(order, PrintStrategy.RECEIPT);
        System.out.println("PACKAGING SLIP:");
        Printer.printOrder(order, PrintStrategy.PACKAGING);

    }
}
