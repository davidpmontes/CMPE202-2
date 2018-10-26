/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

public class CreditCardExp implements IDisplayComponent, IKeyEventHandler
{

	private IKeyEventHandler nextHandler ;
	private String date = "" ;

    public void setNext( IKeyEventHandler next) {
    	this.nextHandler = next ;
    }	

	public String display() {
        StringBuilder out = new StringBuilder();
        out.append("[MM/YY] ");
        for (int i = 0; i < date.length(); i++) {
            if (i<=1) {
                out.setCharAt(i+1, date.charAt(i));
            } else {
                out.setCharAt(i+2, date.charAt(i));
            }
        }
        return out.toString();
	}	

	public void key(String ch, int cnt) {
		if ( cnt >= 17 && cnt <= 20  )
			date += ch ;
		else if ( nextHandler != null )
			nextHandler.key(ch, cnt) ;
	}	

	public void addSubComponent( IDisplayComponent c ) {
		return ; // do nothing
	}

}