

public class SoldState implements IState {
 
    GumballMachine gumballMachine;
 
    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
       
	public void insertCoin(int coin) {
		System.out.println("Please wait, we're already giving you a gumball");
	}
 
	public void ejectCoin() {
		System.out.println("Sorry, you already turned the crank");
	}
 
	public void turnCrank() {
		System.out.println("Turning twice doesn't get you another gumball!");
	}
 
	public void dispense() {
		if (gumballMachine.getCount() > 0) {
            if (gumballMachine.getCoin()==gumballMachine.getPrice()) {
                gumballMachine.setState('r');
            } else {
                gumballMachine.setState('h');
            }
            gumballMachine.releaseBall();
		} else {
			System.out.println("Oops, out of gumballs!");
			gumballMachine.setState('o');
		}
	}
 
	public String toString() {
		return "dispensing a gumball";
	}
}


