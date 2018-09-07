
public class HasCoinState implements State {
	GumballMachine gumballMachine;
 
	public HasCoinState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
  
	public void insertCoin(int coin) {
        System.out.printf("You inserted another coin of %d cent%s.%n", coin, coin>1?"s":"");
	}
 
	public void ejectCoin() {
		System.out.println("Coin returned.");
        gumballMachine.setState('r');
	}
 
	public void turnCrank() {
        System.out.println("You turned...");
        if (gumballMachine.getCoin()>=gumballMachine.getPrice()) {
            gumballMachine.setState('s');
        }
	}

    public void dispense() {
        System.out.println("Insufficent coin. No gumball dispensed.");
    }
 
	public String toString() {
		return "waiting for turn of crank or more coin";
	}
}
