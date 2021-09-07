import java.util.Scanner;

public class Test2Q4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Please enter your age to test:");
		Scanner input = new Scanner(System.in);
		int age = input.nextInt();		
		
		
		System.out.println(compareTo21(age));
		input.close();
		
	}

	
	public static boolean compareTo21 (int age) {
	     if (age >= 21) {
	          return true;
	     } else {
	        return false;
	    }
	}
	
	
	
}
