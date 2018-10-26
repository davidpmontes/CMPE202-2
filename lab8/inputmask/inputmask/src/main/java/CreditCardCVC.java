/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

public class CreditCardCVC implements IDisplayComponent, IKeyEventHandler
{

	private IKeyEventHandler nextHandler ;
    private String cvc = "" ;
    private static final int NUM_LEN = 3;

    public void setNext( IKeyEventHandler next) {
    	this.nextHandler = next ;
    }	

	public String display() {
        StringBuilder out = new StringBuilder();
        out.append('[');
        out.append(cvc);
        for (int i = 0; i < NUM_LEN - cvc.length(); i++) {
            out.append('*');
        }
        out.append(']');
        out.append(' ');
        return out.toString();
	}	

	public void key(String ch, int cnt) {
		if ( cnt >= 21 ) {
			if ( cnt >= 21 && cnt <= 23 )
				cvc += ch ;
			else if ( nextHandler != null )
				nextHandler.key(ch, cnt) ;
		}
		
	}	

	public void addSubComponent( IDisplayComponent c ) {
		return ; // do nothing
	}

}