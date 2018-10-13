package fiveguys;

public class Burger implements ICompositeOrderItem {

    private String description;
    private int quantity;
    private double price;
    private Topping toppings;

    public Burger(String description, double price) {
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

    @Override
    public void addChild(ICompositeOrderItem component) {
        if (component instanceof Topping) {
            if (toppings != null) {
                component.addChild(toppings);
            }
            this.toppings = (Topping) component;
        }
    }

    @Override
    public ICompositeOrderItem getChild() {
        return toppings;
    }
}
