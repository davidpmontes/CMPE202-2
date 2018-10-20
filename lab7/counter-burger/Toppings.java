public class Toppings extends PricedComponent {

    public Toppings(String[] options) {
        super("Topping Option");
        setOptions(options);
    }

    // 4 toppings free, extra +.75
    public void setOptions(String[] options) {
        super.setOptions(options);
    }

}