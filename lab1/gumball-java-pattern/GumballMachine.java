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
    private int maximumCoin = 0;
 
	public GumballMachine(int numberGumballs, int type) {
        this.soldOutState = new SoldOutState(this);
        this.readyState = new ReadyState(this);
        this.hasCoinState = new HasCoinState(this);
        this.soldState = new SoldState(this);
        this.coinChecker = new CoinChecker(type);
        this.state = readyState;

        this.count = numberGumballs;
        switch (type) {
            case 2:
                this.price = 50;
                this.maximumCoin = 50;
                this.coinChecker = new CoinChecker(1);
                break;
            
            case 3:
                this.price = 50;
                this.maximumCoin = 0;
                this.coinChecker = new CoinChecker(2);
                break;
            default:
                System.out.println("Unknown gumball machine type. Default type 1 gumball machine created.");
            case 1:
                this.price = 25;
                this.maximumCoin = 25;
                this.coinChecker = new CoinChecker(1);
                break;
        }

        if (type==1) {
            
        } else if (type==2) {
            
        } else {

        }
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
