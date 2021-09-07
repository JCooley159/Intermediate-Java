import java.util.ArrayList;
import java.util.Scanner;

public class PreFinalQ4HouseTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		House brick = new House("4304 Yosemite Ct", 30024, "Jeremy Cooley", true, 250000, "on market");
		House wood = new House("1400 Herrington Rd", 30044, "Earle McIntosh", false, 100000, "off market");
		House stone = new House("2900 Hollywood Dr", 90210, "Morgan Freeman", true, 4000000, "pending");
		
		int x = 80000;
		Scanner input = new Scanner(System.in);
		System.out.println("You are the Buyer. What house would you like to make an offer on? Brick, Wood, or Stone");
		buyHouse = input.next();
		System.out.println("What would you like to pay for this house?");
		buyPrice = input.nextInt();
		System.out.println("You are the Seller. Would you like to accept this offer? Y/N");
		String sellerDecision = input.next();
		if (sellerDecision == "Y") {
			buyHouse.setStatus("Pending");
		} else {
			System.out.println("I'm sorry, the seller has declined your offer.");
		}
		
	}

}
