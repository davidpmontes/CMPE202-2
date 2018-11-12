import java.util.function.Function;

public abstract class Decorator {

    protected Function<String, String> behavior;
    protected Decorator prevDecorator;

    public Decorator(Decorator decorator) {
        this.prevDecorator = decorator;
    }

    public void setDecorator(Function<String, String> behavior) {
        this.behavior = behavior;
    }

    public String operation(String s) {
        if (prevDecorator==null)
            return behavior.apply(s);
        return behavior.apply(prevDecorator.operation(s));
    }
}