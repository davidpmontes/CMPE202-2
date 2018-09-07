

public class ReadyState implements State {
    GumballMachine gumballMachine;
 
    public ReadyState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
 
	public void insertCoin(int coin) {
		System.out.printf("You inserted a coin of %d cent%s.%n", coin, coin>1?"s":"");
		gumballMachine.setState('h');
	}
 
	public void ejectCoin() {
		System.out.println("You haven't inserted a coin.");
	}
 
	public void turnCrank() {
		System.out.println("You turned, but there's no coin.");
	}
 
	public void dispense() {
		System.out.println("You need to pay first.");
	} 
 
	public String toString() {
		return "waiting for coin";
	}
}
