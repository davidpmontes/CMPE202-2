public class Burger extends PricedComponent {

    public Burger(String[] options) {
        super("Burger Option");
        setOptions(options);
    }

    public void setOptions(String[] options) {
        super.setOptions(options);
        for (String option : options) {
            if ("1/3lb.".equals(option))
                this.price += 9.00;
            if ("1/2lb.".equals(option))
                this.price += 12.00;
            if ("1lb.".equals(option))
                this.price += 18.00;
            if ("In A Bowl".equals(option))
                this.price += 1.00;
            if ("Organic Bison*".equals(option))
                this.price += 4.00;
            if ("Ahi Tuna*".equals(option))
                this.price += 4.00;
        }
    }

}
