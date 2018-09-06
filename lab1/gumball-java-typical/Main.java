

public class Main {

	public static void main(String[] args) {

        // Test type 1 Gumball Machine
		GumballMachine gumballMachine1 = new GumballMachine(5);
		System.out.println(gumballMachine1);

		gumballMachine1.insertCoin( 25 );
        gumballMachine1.turnCrank();
        
        // Test coin over insert
		gumballMachine1.insertCoin( 25 );
		gumballMachine1.insertCoin( 25 );
        gumballMachine1.turnCrank();
        
        // Test type 2 Gumball Machine
		GumballMachine gumballMachine2 = new GumballMachine(5, 2);
		System.out.println(gumballMachine2);

        // Test for insufficient coin
        gumballMachine2.insertCoin( 25 );
		gumballMachine2.turnCrank();
		gumballMachine2.insertCoin( 25 );
        gumballMachine2.turnCrank();
        
        // Test type 3 Gumball Machine
        GumballMachine gumballMachine3 = new GumballMachine(1, 3);
        System.out.println(gumballMachine3);
        
		gumballMachine3.insertCoin( 5 );
		gumballMachine3.insertCoin( 10 );
		gumballMachine3.insertCoin( 25 );
		gumballMachine3.insertCoin( 10 );
        gumballMachine3.turnCrank();
        
        // Test insufficent gumball
        gumballMachine3.insertCoin( 100 );
        gumballMachine3.turnCrank();

        // Test inserting invalid coin
		gumballMachine2.insertCoin( 2 );
        // Test Inserting incomparable coin
        gumballMachine2.insertCoin( 5 );
        
	}
}
