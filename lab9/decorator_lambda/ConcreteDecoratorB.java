public class ConcreteDecoratorB extends Decorator {

    public ConcreteDecoratorB(Decorator d)
    {
        super(d);
        behavior = (String s) -> "<h1>" + s + "</h1>";
    }
}
