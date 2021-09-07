import java.util.Scanner;

public class FinalQ3 {

	public static void main(String[] args) {
		

		Scanner input = new Scanner(System.in);
		System.out.println("What day is it today?");
		String day = input.next();
		System.out.println("Where would you like to go? I'll give you their open hours for today.");
		String place = input.next();
		
		System.out.println(Open_Hours(day, place));
		
	}
	
	public static String Open_Hours(String day, String place) {
		
		String openHours = "initial";
		
		if (place.equalsIgnoreCase("Atlanta")) {
			if (day.equalsIgnoreCase("Sunday")) {
				openHours = "11:00 ~ 18:00";
			} else {
				openHours = "9:00 ~ 18:00";
			}
		} else {
			if (day.equalsIgnoreCase("Sunday")) {
				openHours = "12:00 ~ 18:00";
			} else {
				openHours = "10:00 ~ 18:00";
			}
		}
		
		return "Okay, open from: " + openHours;
	}
	
	
	

}
