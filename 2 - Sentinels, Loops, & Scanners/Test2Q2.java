import java.util.Scanner;

public class Test2Q2 {

	public static void main(String[] args) {
		

		System.out.println("What state do you live in?");
		Scanner input = new Scanner(System.in);
		String state = input.next();
		
		System.out.println("What is your age?");
		int age = input.nextInt();
		
		double price;
		if (age < 2) {
			price = 0;
		} else if (age < 20) {
			price = 50;
		} else if (age < 55) {
			price = 70;
		} else {
			price = 50;
		}

		if (state.equalsIgnoreCase("Georgia")) {
			price = price / 2;
		} 
		
		input.close();
		System.out.println("Your ticket price is $" + price);
		
		
	}
	
}
