package fiveguys;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Order {

    private List<IOrderItem> items;
    private double subtotal = 0;
    private int orderNumber;

    public Order() {
        this.orderNumber = new Random().nextInt(100);
        this.items = new ArrayList<>();
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public List<IOrderItem> getItems() {
        return items;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void addItem(IOrderItem item) {
        items.add(item);
        subtotal += item.getPrice();
    }
}
