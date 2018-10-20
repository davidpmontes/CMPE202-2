
import java.text.DecimalFormat;
import java.util.ArrayList;

public abstract class Composite implements IComposite {

    protected ArrayList<IComposite> composites = new ArrayList<IComposite>();
    protected String description;

    public Composite(String d) {
        description = d;
    }

    public String getDescription() {
        DecimalFormat fmt = new DecimalFormat("0.00");
        StringBuilder out = new StringBuilder();
        out.append(description);
        if (this instanceof IPrice) {
            double price = ((IPrice) this).getPrice();
            out.append(' ');
            out.append(fmt.format(price));
        }
        out.append('\n');
        for (IComposite c : composites) {
            out.append(c.getDescription());
            out.append('\n');
        }
        return out.toString();
    }

    public void addChild(IComposite c) {
        composites.add(c);
    }

    public void removeChild(IComposite c) {
        composites.remove(c);
    }

    public IComposite getChild(int i) {
        return composites.get(i);
    }

}
