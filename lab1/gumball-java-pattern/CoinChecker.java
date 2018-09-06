import java.util.HashMap;
import java.util.Map;

public class CoinChecker {

    private Map<Integer, Boolean> allowedCoin;

    public CoinChecker(int type) {
        this.allowedCoin = new HashMap<>();
        if (type == 1) {
            this.allowedCoin.put(1, false);
            this.allowedCoin.put(5, false);
            this.allowedCoin.put(10, false);
            this.allowedCoin.put(25, true);
            this.allowedCoin.put(100, false);
        } else if (type == 2) {
            this.allowedCoin.put(1, true);
            this.allowedCoin.put(5, true);
            this.allowedCoin.put(10, true);
            this.allowedCoin.put(25, true);
            this.allowedCoin.put(100, true);
        }
    }

    public boolean check(int coin) {
        if (!this.allowedCoin.containsKey(coin)) {
            System.out.println("Invalid coin number.");
            return false;
        } else if (!this.allowedCoin.get(coin)) {
            System.out.println("This coin doesn't fit this machine. Try another one.");
            return false;
        }
        return true;
    }

}
