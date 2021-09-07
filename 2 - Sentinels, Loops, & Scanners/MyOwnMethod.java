import java.util.Scanner;

public class MyOwnMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
/*		System.out.println("How many?");
		int num = input.nextInt();
		input.nextLine(); //// I hate this
*/		
		System.out.println("What message?");
		String myMessage = input.nextLine();
		
		char a = 'B';

		myPrint(myMessage);
		
	}
	
	public static void myPrint(int num) {
		for(int i = 0; i < num; i++){
			System.out.println("Welcome to my class");
		}
	}
	
	public static void myPrint(String message) {
		int num = (int) (Math.random()* 10);
		for(int i = 0; i < num; i++){
			System.out.println(message);
		}
	}
	
	public static void myPrint(int num, String message) {
		for(int i = 0; i < num; i++){
			System.out.println(message);
		}
	}

}
