import java.util.Scanner;

public class RectangleArea {

	public static void main(String[] args) {
		
		double length, width;
		Scanner input = new Scanner(System.in);
	
		System.out.println("What is the length of your rectangle?");
		length = input.nextDouble();
		System.out.println("What is the width of your rectangle?");
		width = input.nextDouble();
		double ans1 = length * width;
		System.out.println("The area of the your rectangle is " + ans1);
		  
		   		  
		   
	}

}
