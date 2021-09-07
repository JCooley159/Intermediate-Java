
public class BankAccountTester {

	public static void main(String[] args) {
		
		BankAccount jimmy = new BankAccount("Jimmy", 5014.65, 1.27);
		BankAccount dan = new BankAccount("Dan", 18694.25, 6.54);
		BankAccount steve = new BankAccount("Steve", 365.52, 0.23);
		
		
		if (jimmy.getBalance() >= dan.getBalance() && jimmy.getBalance() >= steve.getBalance()) {
			System.out.println(jimmy.toString());
		} else if (steve.getBalance() >= dan.getBalance() && steve.getBalance() >= jimmy.getBalance()) {
			System.out.println(steve.toString());
		} else {
			System.out.println(dan.toString());
		}

	}

}
