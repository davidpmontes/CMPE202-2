/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

public class CreditCardNum implements IDisplayComponent, IKeyEventHandler
{

	private IKeyEventHandler nextHandler ;
    private String number = "" ;
    private static final int NUM_LEN = 16;

    public void setNext( IKeyEventHandler next) {
    	this.nextHandler = next ;
    }	

	public String display() {
        StringBuilder out = new StringBuilder();
        out.append("[                   ] ");
        for (int i = 0; i < number.length(); i++) {
            if (i<4) {
                out.setCharAt(i+1, number.charAt(i));
            } else if (i<8) {
                out.setCharAt(i+2, number.charAt(i));
            } else if (i<12) {
                out.setCharAt(i+3, number.charAt(i));
            } else {
                out.setCharAt(i+4, number.charAt(i));
            }
        }
        return out.toString();
	}	

	public void key(String ch, int cnt) {
		if ( cnt <= 16 )
			number += ch ;
		else if ( nextHandler != null )
			nextHandler.key(ch, cnt) ;
	}	

	public void addSubComponent( IDisplayComponent c ) {
		return ; // do nothing
	}

}