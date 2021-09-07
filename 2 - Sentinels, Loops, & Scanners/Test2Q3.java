import java.util.Scanner;

public class Test2Q3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Please enter your first String");
		Scanner input = new Scanner(System.in);
		String s1 = input.next();		
		System.out.println("Please enter your second String");
		String s2 = input.next();
		
		System.out.println(sameSize(s1,s2));
		input.close();
		
	}

	
	public static boolean sameSize(String first, String second) {
	     if (first.length() == second.length()) {
	          return true;
	     } else {
	        return false;
	    }
	}
	
	
	
}
