import java.util.Scanner;

public class InchesToCm {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("What measurement in Inches did you want to convert?");
		double inches = input.nextDouble();
		
		double centimeters = inches * 2.54;
		System.out.println("Your meansurement in Centimeters is:" + centimeters);
		
		input.close();
		
		
	}

}
