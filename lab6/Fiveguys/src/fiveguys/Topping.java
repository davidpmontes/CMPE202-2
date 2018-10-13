package fiveguys;

enum ToppingPosition {
    TOP, MIDDLE, BOTTOM,
}

public class Topping implements IOrderItem {

    private String description;
    private ToppingPosition position;

    public Topping(String description, ToppingPosition position) {
        this.description = description;
        this.position = position;
    }

    public ToppingPosition getPosition() {
        return position;
    }

    @Override
    public String getDescription() {
        return description;
    }

}
