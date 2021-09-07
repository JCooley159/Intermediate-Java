import java.util.Scanner;

public class TicketPrice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println("Please give your gender:");
		Scanner input = new Scanner(System.in);
		double price;
		String gender = input.next();
		
		System.out.println("Please enter your age:");
		int age = input.nextInt();
		
		
		if (age < 2) {
			price = 0;
			System.out.println("free");
		} else if (age <2) {
			price = 10;
		} else if (age < 65) {
			price = 20;
		} else {
			price = 10;
		}
		
		
		
		if (gender.equals("female")); {
			price = price -5;
		}
		
		input.close();
		System.out.println("you ticket price is $" + price);
	}

}
