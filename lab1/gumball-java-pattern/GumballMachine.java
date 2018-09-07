/**
* The Gumball Machine class implements an application that
* could sells gumballs to customers. 
*
* There are 3 types of gumball machine:
* 1. Gumballs sells at 25 cents, only accept quarter.
* 2. Gumballs sells at 50 cents, only accept quarter.
* 3. Gumballs sells at 50 cents, accept kind of coins.

*
* @author  Jinzhou Tao
*/

public class GumballMachine {
 
	State soldOutState;
	State readyState;
	State hasCoinState;
	State soldState;
    State state;
    CoinChecker coinChecker;

    private int gumballNum = 0;
    private int gumballPrice = 0;
    private int insertedCoin = 0;
    private int maximumCoin = 0;
 
    /**
     * Create an specfic type of gumball machine by specificy the
     * type parameter of the constructor. Invalid type input would
     * result in fallback to default type 1.
     * 
     */
	public GumballMachine(int gumballNum, int type) {
        this.soldOutState = new SoldOutState(this);
        this.readyState = new ReadyState(this);
        this.hasCoinState = new HasCoinState(this);
        this.soldState = new SoldState(this);
        this.coinChecker = new CoinChecker(type);
        this.state = readyState;

        this.gumballNum = gumballNum;
        switch (type) {
            case 2:
                this.gumballPrice = 50;
                this.maximumCoin = 50;
                this.coinChecker = new CoinChecker(1);
                break;
            
            case 3:
                this.gumballPrice = 50;
                this.maximumCoin = 0;
                this.coinChecker = new CoinChecker(2);
                break;
            default:
                System.out.println("Unknown gumball machine type.");
                System.out.println("Default type 1 gumball machine created.");
            case 1:
                this.gumballPrice = 25;
                this.maximumCoin = 25;
                this.coinChecker = new CoinChecker(1);
                break;
        }
    }

    public GumballMachine(int gumballNum) {
        this(gumballNum, 1);
    }
 
	public void insertCoin(int coin) {
        if (coinChecker.check(coin)) {
            if (this.maximumCoin > 0 && this.insertedCoin + coin > this.maximumCoin) {
                System.out.println("You've inserted too many coins. Coin returned.");
            } else {
                state.insertCoin(coin);
                this.insertedCoin += coin;
            }
        }
	}
 
	public void ejectCoin() {
        state.ejectCoin();
        this.insertedCoin = 0;
	}
 
	public void turnCrank() {
		state.turnCrank();
		state.dispense();
	}

	void setState(State state) {
        this.state = state;
    }

    State getReadyState() { return this.readyState; }
    State getHasCoinState() { return this.hasCoinState; }
    State getSoldState() { return this.soldState; }
    State getSoldOutState() { return this.soldOutState; }
    
    int getCount() { return this.gumballNum; }
    int getPrice() { return this.gumballPrice; }
    int getCoin() { return this.insertedCoin; }
 
	void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        insertedCoin = insertedCoin - gumballPrice;
		gumballNum = gumballNum - 1;
	}
 
	void refill(int gumballNum) {
		this.gumballNum = gumballNum;
		this.state = readyState;
	}
 
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("\nMighty Gumball, Inc.");
		result.append("\nJava-enabled Standing Gumball Model #2004");
		result.append("\nInventory: " + gumballNum + " gumball");
		if (gumballNum != 1) {
			result.append("s");
		}
		result.append("\n");
		result.append("Machine is " + state + "\n");
		return result.toString();
	}
}
