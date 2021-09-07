import java.util.Scanner;

public class test1codingQ3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("What is your height in inches?");
		Scanner input = new Scanner(System.in);
		double height = input.nextDouble();
		
		if ((height > 0) && (height <= 42)) {
			System.out.println("You can ride only the Carousel.");
		} else if ((height >= 43) && (height <= 52)) {
			System.out.println("You can ride the Carousel and the Bumper Cars.");
		} else {
			System.out.println("You can ride every ride in the park!");
		} 
		
		
		
		

}
