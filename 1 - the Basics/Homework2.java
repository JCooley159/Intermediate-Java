import java.util.Scanner;

public class Homework2 {

	public static void main(String[] args) {
		
		
		Scanner input = new Scanner(System.in);
		double price;
		String drink = null;
		
		
		System.out.println("Hi! If you would like to order a drink, please enter your age:");
		int age = input.nextInt();
		
		
		if (age >= 21 && age <= 65) {
			System.out.println("You seem to be old enough--I hope you're not lying! What drink would you like?");
			drink = input.next();
			price = 20;
			
		} else if (age > 65) {
			System.out.println("You're definitely old enough--You've earned this! What drink would you like?");
			drink = input.next();
			price = 10;
					
		} else  {
			price = 0;
			drink = "milk";
			System.out.println("I'm sorry, you're not old enough to order alcohol. Here's some milk!");
		}
		
		
		
		System.out.println("Alright, the total for your " + drink + " is going to be $" + price + ". We'll have it right out for you!");
		
		input.close();
		

	}
}
