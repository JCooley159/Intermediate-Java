import java.util.ArrayList;
import java.util.Scanner;

public class FinalQ2 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		ArrayList<String> names = new ArrayList<String>();
		int letterCount = 0;
		int longestCount = 0;
		String longestName = null;
		
		System.out.println("Please start entering names. If you wish to exit, please type 'exit'.");
		String firstCommand = input.next();
		
		
			while (input.next().equalsIgnoreCase("exit")) {
				
				names.add(input.next());
					
		
				letterCount = letterCount + input.next().length();
				
				if (input.next().length() > longestCount) {
					longestName = input.next();
					longestCount = input.next().length();
				} 
			}
	
		double size = names.size();
		double avgLength = letterCount / size;
		System.out.println("The average length of the names you typed: " + avgLength);
		System.out.println("The longest name: " + longestName);
		input.close();
	}

	
}
