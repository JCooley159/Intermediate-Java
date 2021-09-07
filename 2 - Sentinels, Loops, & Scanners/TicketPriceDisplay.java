import java.util.Scanner;

public class TicketPriceDisplay {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please enter your age to determine the ticket price: ");
		int age = input.nextInt();
		System.out.print("Please enter your gender to determine whether or not you are eligle for a discount: (M/F) ");
		String gender = input.next();
				
		if (age <= 2) {
			System.out.println("Okay, your ticket price is: FREE!");
		} else if (age <= 12) {
			if (gender.equals("male")) {
				System.out.println("Okay, your ticket price is: $10");
			} else {
				System.out.println("Okay, your ticket price is: $5.");
			}
		} else if (age <= 65) {
			if (gender.equals("male")) {
				System.out.println("Okay, your ticket price is: $20");
			} else {
				System.out.println("Okay, your ticket price is: $15.");
			}
		} else {
			if (gender.equals("male")) {
				System.out.println("Okay, your ticket price is: $10");
			} else {
				System.out.println("Okay, your ticket price is: $5.");
			}
		}
		
	}

}
