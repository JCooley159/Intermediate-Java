import java.util.Scanner;

public class SprBrkChallenges1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String[] numberArray = data.split("::");
		int i = 0;
		int sum = 0;
		while (i <= 2) {
			int individualValue = Integer.parseInt(numberArray[i]);
			sum = sum + individualValue;
			i++;
		}
		
		int avg = sum / 3;
		
		
		System.out.println("Okay, the sum of your numbers is: " + sum + ", And the average of your numbers is: " + avg);
		
		
		
		
	}

}
