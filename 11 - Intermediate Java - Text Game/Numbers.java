/**
 * Class: Numbers
 * 
 * STUDENT: Jeremy Cooley
 * 
 * @author: ITEC 2150
 * @version 1.0 
 * Course: ITEC 2150 Jun 1, 2016 
 * Exception Handling
 * Purpose - class used to test understanding and handling of exceptions
 */

public class Numbers 
{
	/** Method add
	 * Add the numbers passed as parameters.  If a parameter is not a number, throws StringNotANumberException
	 * 
	 * @param a - String representing the first number
	 * @param b - String representing the second number
	 * @return int - the sum of the two numbers 
	 * @throws StringNotANumberException
	 */
	public int add(String a, String b) throws StringNotANumberException 
	{
		
		int sum = 0;
		int aInt = 0;
		int bInt = 0;
		
		try {
			aInt = Integer.parseInt(a);
			bInt = Integer.parseInt(b);
			sum = aInt + bInt;
			
		}
		catch (NumberFormatException nfe)
		{
			if (aInt == 0) {
				throw new StringNotANumberException("First is invalid");
			} else if (bInt == 0) {
				throw new StringNotANumberException("Second is invalid");
			}
			
		}
		return sum;
		
	}
}