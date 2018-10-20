public class CustomBurger extends Composite implements IPrice {
    public CustomBurger() {
        super("Build Your Own Burger");
    }

    @Override
    public Double getPrice() {
        double price = 0.0;
        for (IComposite c : composites) {
            if (c instanceof IPrice)
                price += ((IPrice) c).getPrice();
        }
        return price;
    }
}
