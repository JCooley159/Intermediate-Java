import java.util.Scanner;

public class TipCalculator {

	public static void main(String[] args) {
				
		Scanner input = new Scanner(System.in);
		System.out.println("What is the total of your bill?");
		double bill = input.nextDouble();
		
		System.out.println("What % did you want to tip?");
		double tip = input.nextDouble();
		tip = bill * (tip * 0.01);
		
		double totalBill = bill + tip;
		System.out.println("Your total bill comes out to $" + totalBill);
		
		
	}

}
