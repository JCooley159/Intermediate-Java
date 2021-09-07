import java.util.Scanner;

public class DrinkLogic {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Okay, you'd like to order a drink? Please enter your age: ");
		int age = input.nextInt();
		
		if (age < 21) {
			System.out.println("Sorry, you are not old enough to legally drink alcohol.");
		} else {
			System.out.println("Okay, what would you like to order?");
		}
	
	}

}
