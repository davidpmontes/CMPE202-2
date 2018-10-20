public class Sauce extends PricedComponent {

    public Sauce(String[] options) {
        super("Sauce Option");
        setOptions(options);
    }

    // 1 sauce free, extra +.75
    public void setOptions(String[] options) {
        super.setOptions(options);
        if (options.length > 1)
            this.price += (options.length - 1) * 0.50;
    }

}