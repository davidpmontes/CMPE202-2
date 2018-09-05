/**
* The Gumball Machine class implements an application that
* could sells gumballs to customers. 
*
* There are 3 types of gumball machine:
* 1. Gumballs sells at 25 cents, only accept quarter.
* 2. Gumballs sells at 50 cents, only accept quarter.
* 3. Gumballs sells at 50 cents, accept kind of coins.
* Create an specfic type of gumball machine by specificy the
* type parameter of the constructor
*
* @author  Jinzhou Tao
*/

public class GumballMachine {
 
	IState soldOutState;
	IState readyState;
	IState hasCoinState;
	IState soldState;
    IState state;
    CoinChecker coinChecker;

    private int count = 0;
    private int price = 0;
    private int insertedCoin = 0;
 
	public GumballMachine(int numberGumballs, int type) {
		soldOutState = new SoldOutState(this);
		readyState = new ReadyState(this);
		hasCoinState = new HasCoinState(this);
        soldState = new SoldState(this);
        coinChecker = new CoinChecker(type);

        this.count = numberGumballs;
        if (type==1) {
            this.price = 25;
        } else {
            this.price = 50;
        }

 		if (numberGumballs > 0) {
			state = readyState;
		} 
	}
 
	public void insertCoin(int coin) {
        if (coinChecker.check(coin)) {
            state.insertCoin(coin);
            this.insertedCoin += coin;
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

	void setState(char state) {
		switch (state) {
            case 'r':
                this.state = readyState;
                break;
            case 'h':
                this.state = hasCoinState;
                break;
            case 's':
                this.state = soldState;
                break;
            case 'o':
                this.state = soldOutState;
                break;
            default:
                this.state = readyState;
                break;
        }
    }
    
    int getCount() {
		return this.count;
	}

    int getPrice() {
        return this.price; 
    }

    int getCoin() {
        return this.insertedCoin; 
    }
 
	void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        insertedCoin = insertedCoin - price;
		count = count - 1;
	}
 
	void refill(int count) {
		this.count = count;
		this.state = readyState;
	}
 
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("\nMighty Gumball, Inc.");
		result.append("\nJava-enabled Standing Gumball Model #2004");
		result.append("\nInventory: " + count + " gumball");
		if (count != 1) {
			result.append("s");
		}
		result.append("\n");
		result.append("Machine is " + state + "\n");
		return result.toString();
	}
}
