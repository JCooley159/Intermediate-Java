import java.util.Scanner;

public class TennisBallShooter {

	public int ballCount = 0;
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		loadShooter();
		Scanner input = new Scanner(System.in);
		
		System.out.println("Would you like to reload the shooter? Y/N");
		if (input.next().equalsIgnoreCase("Y")) {
			loadShooter();
		}
		
	}

	
	public void loadShooter(int balls) {
		this.ballCount = balls;
		while (ballCount != -1) {
			
			System.out.println(ballCount);
			ballCount--;
			if (ballCount == 0) {
				System.out.println("Okay, no more balls left");
				break;
			}
		}
	}
	
	public static void loadShooter() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter how many balls you want to load. If you want to exit, please type -1");
		int ballCount = input.nextInt();
		
		while (ballCount != -1) {			
			System.out.println(ballCount);
			ballCount--;
			if (ballCount == 0) {
				System.out.println("Okay, no more balls left");
				break;
			}
		}
	}
	
}
