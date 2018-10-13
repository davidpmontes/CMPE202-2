package fiveguys;

public class Toppings implements IComponent{

    private String description;
    private int position;
    private IComponent nextToppings;

    public Toppings(String description, int position) {
        this.description = description;
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Double getPrice() {
        return null;
    }

    @Override
    public void addSubComponent(IComponent component) {
        if (nextToppings != null) {
            component.addSubComponent(nextToppings);
        }
        this.nextToppings = component;
    }

    @Override
    public IComponent getSubComponent() {
        return nextToppings;
    }
}
