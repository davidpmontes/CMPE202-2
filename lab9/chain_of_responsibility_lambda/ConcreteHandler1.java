public class ConcreteHandler1 implements Handler {

    private Handler successor = null;

	public String handleRequest( String request ) {
	    if (request==null)
	        return null;

        System.out.println( "R1 got the request...");
        if ( request.equalsIgnoreCase("R1") )
        {
            System.out.println( this.getClass().getName() + " => This one is mine!");
            return null;
        }
        return request;

	}

//	public void setSuccessor(Handler next) {
//        this.successor = next ;
//	}

}
