
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

import java.util.Map;
import java.util.HashMap;

public class GumballMachine {
    private int gumballNum;
    private int gumballPrice;
    private int insertedCoin;
    private int maximumCoin;
    private Map<Integer, Boolean> allowedCoin;

    public GumballMachine(int size) {
        this(size, 1);
    }

    public GumballMachine(int size, int type) {
        this.gumballNum = size;
        this.insertedCoin = 0;
        this.allowedCoin = new HashMap<>();

        switch (type) {
        case 3:
            this.gumballPrice = 50;
            this.maximumCoin = 0;
            this.allowedCoin.put(1, true);
            this.allowedCoin.put(5, true);
            this.allowedCoin.put(10, true);
            this.allowedCoin.put(25, true);
            this.allowedCoin.put(100, true);
            break;
        case 2:
            this.gumballPrice = 50;
            this.maximumCoin = 50;
            this.allowedCoin.put(1, false);
            this.allowedCoin.put(5, false);
            this.allowedCoin.put(10, false);
            this.allowedCoin.put(25, true);
            this.allowedCoin.put(100, false);
            break;
        default:
            System.out.println("Unknown gumball machine type. Default type 1 gumball machine created.");
        case 1:
            this.gumballPrice = 25;
            this.maximumCoin = 25;
            this.allowedCoin.put(1, false);
            this.allowedCoin.put(5, false);
            this.allowedCoin.put(10, false);
            this.allowedCoin.put(25, true);
            this.allowedCoin.put(100, false);
            break;
        }
    }

    public void insertCoin(int coin) {
        if (!this.allowedCoin.containsKey(coin)) {
            System.out.println("Invalid coin number. ");
        } else if (!this.allowedCoin.get(coin)) {
            System.out.println("This coin doesn't fit this machine. Try another one.");
        } else if (this.maximumCoin > 0 && this.insertedCoin + coin > this.maximumCoin) {
            System.out.println("You've inserted too many coins. Coin returned.");
        } else {
            this.insertedCoin += coin;
        }
    }

    public void turnCrank() {
        if (this.insertedCoin >= this.gumballPrice) {
            if (this.gumballNum > 0) {
                this.gumballNum--;
                this.insertedCoin -= this.gumballPrice;
                System.out.println("Thanks for your purchase. Gumball Ejected!");
            } else {
                System.out.println("No More Gumballs! Sorry, can't return your coins.");
            }
        } else {
            System.out.println("Please insert more coin.");
        }
    }
}
