# CMPE202 Lab9 - Lambda

## Refactoried Design Pattern 

#### Chain of Responsibility 

##### Principle
- Using Stream API with `map` function to conduct a stream style handling pipeline.
- When one of the handler caught the order (take responsibility), it would handle it and pass a null obj to the next handler.
- When handler caught a null, it means order has been handled so would pass the null forward.

##### Merit

- Data flow is more clear. 
- No need to chain handlers together
- Easy for future Configuration.

##### Core Code
```java
// Before
Handler h1 = new ConcreteHandler1() ;
Handler h2 = new ConcreteHandler2() ;
Handler h3 = new ConcreteHandler3() ;

h1.setSuccessor(h2);
h2.setSuccessor(h3);

h1.handleRequest("R2");
h1.handleRequest("R3");
h1.handleRequest("R1");
h1.handleRequest("RX");

// After
Stream steam = Stream.of("R2","R1","R3","RX");
stream.map(h1::handleRequest)
      .map(h2::handleRequest)
      .map(h3::handleRequest)
      .forEach( /* Handleing Output */ );
```

#### Decorator

##### Principle

- Using lambda function to refactor the `addBehavior` method.
- Using `Function<String, String>` to store decorator behavior.
- Using added a `setBehavior` method to enable changing decorator behavior

##### Merit

- Decorator class are more focus on its behavior, no redundant information.
- Easy to change decorator's behavior.

##### Core code
```java
// Before
public class ConcreteDecoratorA extends Decorator {

    public ConcreteDecoratorA( Component c)
    {
        super( c ) ;
    }
    
    public String operation()
    {
        addedState = super.operation() ;
        return addedBehavior( addedState ) ; 
    }
    
    private String addedBehavior(String in) {  
        return "<em>" + addedState + "</em>" ; 
    }
}

// After
public class ConcreteDecoratorA extends Decorator {

    public ConcreteDecoratorA(Decorator d)
    {
        super(d);
        behavior = (String s) -> "<em>" + s + "</em>";
    }
}


```