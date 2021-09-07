import java.util.Scanner;

public class test1codingQ2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		System.out.println("What is the first person's name?");
		String name1 = input.next();
		System.out.println("What is the second person's name?");
		String name2 = input.next();
		
		if (name1.length() >= name2.length()) {
			System.out.println("Okay, " + name1 + " is the longer name.");
		} else if (name1.length() == name2.length()) {
			System.out.println(name1 + " and " + name2 + "are both the same length.");
		} else {
			System.out.println("Okay, " + name2 + " is the longer name.");
		}
		
		input.close();
	}

}
