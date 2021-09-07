import java.util.Scanner;

public class PreFinalQ1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double number1, number2, number3;
		Scanner input = new Scanner(System.in);
		
		System.out.println("What is your first score?");
		number1 = input.nextDouble();
		System.out.println("What is your second score?");
		number2 = input.nextDouble();
		System.out.println("What is your third score?");
		number3 = input.nextDouble();
		
		
		double avg = (number1 + number2 + number3) / 3;
		System.out.println("The average of your numbers is: " + avg);
		  

		

	}

}
