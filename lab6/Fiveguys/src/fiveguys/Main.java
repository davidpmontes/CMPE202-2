package fiveguys;

public class Main {

    public static void main(String[] args) {
        Order order = new Order();
        
        order.printOrder(PrintStrategy.RECEIPT);
    }
}
