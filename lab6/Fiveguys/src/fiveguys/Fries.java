package fiveguys;

public class Fries implements IOrderItem {

    private String description;
    private int quantity;
    private double price;

    public Fries(String description, double price) {
        this.description = description;
        this.price = price;
        this.quantity = 1;
    }

    @Override
    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public Double getPrice() {
        return price*quantity;
    }

    @Override
    public String getDescription() {
        return description;
    }

}
