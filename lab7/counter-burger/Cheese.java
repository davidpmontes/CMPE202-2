public class Cheese extends PricedComponent {
    public Cheese(String[] options) {
        super("Cheese Option");
        setOptions(options);
    }

    public void setOptions(String[] options) {
        super.setOptions(options);
        this.price += (options.length - 1) * 1.00;
    }
}