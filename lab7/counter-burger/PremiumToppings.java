public class PremiumToppings extends PricedComponent {
    public PremiumToppings(String[] options) {
        super("Premium Toppings Option");
        setOptions(options);
    }

    public void setOptions(String[] options) {
        super.setOptions(options);
        this.price += options.length * 1.00;
        for (String option : options) {
            if ("Marinated Tomatoes".equals(option))
                this.price += 2.00;
        }
    }

}