public class Bun extends PricedComponent {
    public Bun(String[] options) {
        super("Bun Option");
        setOptions(options);
    }

    public void setOptions(String[] options) {
        super.setOptions(options);
        for (String option : options) {
            if ("Gluten-Free Bun".equals(option))
                this.price += 1.00;
            if ("Hawaiian Bun".equals(option))
                this.price += 1.00;
            if ("Pretzel Bun".equals(option))
                this.price += 0.5;
        }
    }
}