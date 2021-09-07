import java.util.Scanner;

public class DisplayMinuteAndSecond {

	public static void main(String[] args) {
		
		
		Scanner input = new Scanner(System.in);
		System.out.println("How many seconds would you like to convert?");
		int totalSeconds = input.nextInt();
		
		int seconds = totalSeconds % 60;
		int minutes = (totalSeconds - seconds) / 60;
		
		System.out.println("Your input is equal to " + minutes + " minutes and " + seconds + " seconds.");

	}

}
