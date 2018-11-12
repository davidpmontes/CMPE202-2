import java.util.stream.Stream;

public class Client {

    public void runTest()
    {
        Handler h1 = new ConcreteHandler1() ;
        Handler h2 = new ConcreteHandler2() ;
        Handler h3 = new ConcreteHandler3() ;

        Stream<String> stream = Stream.of("R2","R1","R3","R4");
        stream.map(h1::handleRequest)
                .map(h2::handleRequest)
                .map(h3::handleRequest)
                .forEach((String result) -> {
                    if (result!=null)
                        System.out.println("Request " + result + " is not handled!");
                });

//        System.out.println( "Sending R2...");
//        h1.handleRequest("R2");
//        System.out.println( "Sending R3...");
//        h1.handleRequest("R3");
//        System.out.println( "Sending R1...");
//        h1.handleRequest("R1");
//        System.out.println( "Sending RX...");

    }
    
    public static void main( String [] args )
    {
        Client c = new Client() ;
        c.runTest() ;
    }

}
