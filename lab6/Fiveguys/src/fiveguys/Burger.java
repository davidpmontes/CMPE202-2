package fiveguys;

public class Burger implements IComponent {

    private String description;
    private double price;
    private Toppings toppings;

    public Burger(String description, double price) {
        this.description = description;
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void addSubComponent(IComponent component) {
        if (component instanceof Toppings) {
            if (toppings != null) {
                component.addSubComponent(toppings);
            }
            this.toppings = (Toppings) component;
        }
    }

    @Override
    public IComponent getSubComponent() {
        return toppings;
    }
}
