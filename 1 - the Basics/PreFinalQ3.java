import java.util.Scanner;

public class PreFinalQ3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		System.out.println("What day is it today?");
		String day = input.next();
		System.out.println("Are you currently on vacation? Enter a boolean true or false.");
		boolean vacation = input.nextBoolean();
		
		System.out.println(AlarmClock(day, vacation));
		
		
	}

	
	
	public static String AlarmClock(String day, boolean vacation) {
		
	
		String alarmTime = null;
		if (vacation == true) {
			return "alarm is off";
		} else if (vacation == false) {
			switch (day) {
				case "Saturday": alarmTime = "10:00"; break;
				case "Sunday" : alarmTime = "10:00"; break;
				case "Monday" : alarmTime = "7:00"; break;
				case "Tuesday" : alarmTime = "7:00"; break;
				case "Wednesday" : alarmTime = "7:00"; break;
				case "Thursday" : alarmTime = "7:00"; break;
				case "Friday" : alarmTime = "7:00"; break;				
				default: alarmTime = "Invalid day; check your capitalization or spelling"; break;
			}
			
			return ("Your alarm is set for " + alarmTime + " today.");
		}
		
		return "error";
	}
	
		
	
	
	
}
