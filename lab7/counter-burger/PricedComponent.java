import java.text.DecimalFormat;

public abstract class PricedComponent extends Component implements IPrice {
    protected Double price;

    public PricedComponent(String description) {
        super(description);
        this.price = 0.0;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        DecimalFormat fmt = new DecimalFormat("0.00");
        if (price>0)
            return super.getDescription() + " " + fmt.format(price);
        else
            return super.getDescription();
    }

}
