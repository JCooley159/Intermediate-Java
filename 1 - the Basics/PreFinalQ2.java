import java.util.Scanner;

public class PreFinalQ2 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		double x = 0;
		double sum = 0;
		double divisorCount = 0;
		
		System.out.println("Start entering the scores you want to average. If you want to exit, please type -1");
		
		while (input.nextDouble() > -1) {
		
			x = input.nextDouble();
			sum = sum + x;
			divisorCount++;
		
		}
		System.out.println("Thank you. Your average is: " + (sum/divisorCount));
	}
	
	
}
