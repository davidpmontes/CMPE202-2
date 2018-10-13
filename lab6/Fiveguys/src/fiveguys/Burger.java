package fiveguys;

import java.util.ArrayList;
import java.util.List;

public class Burger implements IOrderItem {

    private String description;
    private int quantity;
    private double price;
    private List<Topping> toppings;

    public Burger(String description, double price) {
        this.toppings = new ArrayList<>();
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

    public void addTopping(Topping item) {
        toppings.add(item);
    }

    public List<Topping> getToppings() {
        return toppings;
    }
}
