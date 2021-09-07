import java.util.Scanner;

public class NumbersTester {

	public static void main(String[] args) throws StringNotANumberException {
		// TODO Auto-generated method stub

		Numbers numbersInstance = new Numbers();
		int sum = 0;
		boolean valid = false;
		String a = null;
		String b = null;
		Scanner input = new Scanner(System.in);
		
		while (!valid)
		{
			System.out.println("Please enter two numbers to be summed together. Hit enter in between.");
			a = input.nextLine();
			b = input.nextLine();
			
			
			try 
			{
				sum = numbersInstance.add(a, b);
				
				valid = true;
			}
			catch (StringNotANumberException snne)
			{
				snne.printStackTrace();
				System.out.print("\n");
			}
			
		}
		System.out.println(a + " + " + b + " = " + sum);
		
		input.close();
	}

}
