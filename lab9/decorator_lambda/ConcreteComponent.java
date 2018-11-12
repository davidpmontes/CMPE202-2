public class ConcreteComponent extends Decorator {

	public ConcreteComponent() {
		super(null);
		decoratorBehavior = (String s) -> "Hello World!";
	}

}
