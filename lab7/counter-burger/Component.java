
public abstract class Component implements IComposite {

    private String description;
    protected String[] options;

    public Component(String description) {
        this.description = description;
    }

    public Component(String description, String[] options) {
        this(description);
        setOptions(options);
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public String getDescription() {
        String desc = "   ";
        for (int i = 0; i < options.length; i++) {
            if (i > 0)
                desc += " + " + options[i];
            else
                desc = options[i];
        }
        return desc;
    };

    public void addChild(IComposite c) {
    }

    public void removeChild(IComposite c) {
    }

    public IComposite getChild(int i) {
        return null;
    }

}
