package fiveguys;

enum ToppingPosition {
    TOP, MIDDLE, BOTTOM,
}

public class Topping implements ICompositeOrderItem {

    private String description;
    private ToppingPosition position;
    private Topping nextTopping;

    public Topping(String description, ToppingPosition position) {
        this.description = description;
        this.position = position;
    }

    public ToppingPosition getPosition() {
        return position;
    }

    @Override
    public Integer getQuantity() {
        return null;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public Double getPrice() {
        return null;
    }

    @Override
    public void addChild(ICompositeOrderItem component) {
        if (component instanceof Topping) {
            if (nextTopping != null) {
                component.addChild(nextTopping);
            }
            this.nextTopping = (Topping) component;
        }
    }

    @Override
    public ICompositeOrderItem getChild() {
        return nextTopping;
    }
}
