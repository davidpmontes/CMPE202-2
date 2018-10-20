public class PremiumCheese extends PricedComponent {
    public PremiumCheese(String[] options) {
        super("Premium Cheese Option");
        setOptions(options);
    }

    public void setOptions(String[] options) {
        super.setOptions(options);
        this.price += options.length * 1.50;
    }

}