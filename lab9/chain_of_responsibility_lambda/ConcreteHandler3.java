public class ConcreteHandler3 implements Handler {


    private Handler successor = null;

    public String handleRequest( String request ) {
        if (request==null)
            return null;
        System.out.println( "R3 got the request...");
        if ( request.equalsIgnoreCase("R3") )
        {
            System.out.println( this.getClass().getName() + " => This one is mine!");
            return null;
        }
        return request;
//        else
//        {
//            if ( successor != null )
//                successor.handleRequest(request);
//        }

    }

    public void setSuccessor(Handler next) {
        this.successor = next ;
    }


}
