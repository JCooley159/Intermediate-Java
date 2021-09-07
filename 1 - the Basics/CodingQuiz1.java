import java.util.Scanner;

public class CodingQuiz1 {

	public static void main(String[] args) {
		int number1, number2, number3;
		Scanner input = new Scanner(System.in);
		
		System.out.println("What is your first number?");
		number1 = input.nextInt();
		System.out.println("What is your second number?");
		number2 = input.nextInt();
		System.out.println("What is your third number?");
		number3 = input.nextInt();
		
		
		int sum = number1 + number2 + number3;
		int product = number1 * number2 * number3;
		System.out.println("The sum of your numbers is: " + sum + " And the product of your numbers is: " + product);
		  

	}

}
