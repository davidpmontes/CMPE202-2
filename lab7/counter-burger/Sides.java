public class Sides extends PricedComponent {

    public Sides(String[] options) {
        super("Sauce Option");
        setOptions(options);
    }

    // 1 sauce free, extra +.75
    public void setOptions(String[] options) {
        super.setOptions(options);
        this.price += options.length* 3.00;
    }

}