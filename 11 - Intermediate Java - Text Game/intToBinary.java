import java.util.Scanner;
/**Class: intToBinary
 * 
 * @author Jeremy Cooley
 * @version 1.0
 * Course: ITEC 2150 Summer 2018
 * Last Updated: June 21, 2018
 *
 * This class - allows the user to enter a number to be converted to a string of 
 * binary 1's and 0's.
 */
public class intToBinary {

	public static void main(String[] args)  {

		
		Scanner input = new Scanner(System.in);		
		intToBinary ibt = new intToBinary();
		boolean valid = true;
		
		while (valid) 
		{			
			System.out.println("Enter a number to be converted to binary.");
			int num = input.nextInt();
			if (num < 0) {
				break;
			} 
			
			System.out.println(ibt.toBinary(num));
			
		} 
		
		
		
		input.close();
	}
	
	/**Method: toBinary
	 * 
	 * @param n - the int to be converted to binary
	 * @return String - the binary string to be returned
	 */
	public String toBinary(int n) {
		if (n == 1) {
			return "1";
		} else if (n == 0) {
			return "0";
		} else if (n > 1) {
			int modu = n % 2;
			return (toBinary(n/2) + modu + "");
		}
		return "";
	}

}
