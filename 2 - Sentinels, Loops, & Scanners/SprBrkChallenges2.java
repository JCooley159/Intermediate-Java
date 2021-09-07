import java.util.Scanner;

public class SprBrkChallenges2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to our company. Please choose one "
				+ "option:  1. Do you want to buy? 2. I want to exit." );
		int shopOption = input.nextInt();
		
		String cart = "";
		while (shopOption == 1) {
			System.out.println("What do you want to buy?");
			String product = input.next();
			cart = cart.toString() + product + ", and ";
			System.out.println("1. Do you want to keep buying? 2. I want to exit.");
			shopOption = input.nextInt();
		} 
		if (shopOption == 2) {
			if (cart != "") {
				System.out.println("Thanks for shopping with us! You ordered " + cart.toString() + "we will ship them to you as soon as possible.");
				
			} else {
				System.out.print("We're sorry to see you leave without buying anything, but have a good day!");
			}
		}
		
		
		
		
	}

}
