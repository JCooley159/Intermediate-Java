import java.util.Scanner;

public class test1codingQ4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("What day of the week is it?");
		Scanner input = new Scanner(System.in);
		String day = input.next();
		System.out.println("What speed is the car going?");
		double speed = input.nextDouble();
		
		
		
		double genSpdLim;
		double supSpdLim;	
		
		if ((day.equals("Saturday")) || (day.equals("Sunday"))) {
			genSpdLim = 65;
			supSpdLim = 85;
		} else {
			genSpdLim = 55;
			supSpdLim = 75;
		} 
		
		
		
		if ((speed >= genSpdLim) && (speed <= supSpdLim)) {
			System.out.println("A ticket for $200 will be generated.");
		} else if (speed >= supSpdLim) {
			System.out.println("A ticket for $400 will be generated.");
		} else {
			System.out.println("No ticket will be generated. Thanks for obeying the law!");
		}
		
		
		
		
	}

}
