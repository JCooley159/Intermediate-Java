import java.util.Scanner;

public class PhoneNumFormatter {

	public static void main(String[] args) {

		boolean exit = true;
		Scanner input = new Scanner(System.in);
		
		
		while (exit == true) {
			
			System.out.println("Please enter your phone number. Make sure it's formatted right! Ex: 777-777-7777");
			String phoneNum = input.next();
			boolean matches = phoneNum.matches("^\\d{3}-\\d{3}-\\d{4}");
			// Dr. Kwon's version: "^[0-9]{3}-[0-9]{3}-[0-9]{4}$"
			
			if (matches == true) {
				System.out.println("Nice! Your number has been recorded correctly. The program is finished.");
				exit = false;
			} else {
				System.out.println("Wrong!!! Try again!");
			}
		}
		
		
		input.close();
	}
		
}
