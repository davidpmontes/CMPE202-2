public class ConcreteDecoratorA extends Decorator {

    public ConcreteDecoratorA(Decorator d)
    {
        super(d);
        behavior = (String s) -> "<em>" + s + "</em>";
    }

}
