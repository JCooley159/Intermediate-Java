import java.util.Scanner;

/**Class: StringRecursion
 * @author JCool
 * @version 1.0
 * Date - July 23, 2018
 *
 * This class recurses to print a string from last letter to first.
 */
public class StringRecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StringRecursion sr = new StringRecursion();
		Scanner input = new Scanner(System.in);
		boolean valid = true;
		
		
		do 
		{
			System.out.println("Please enter the word to process. Press enter to exit.");
			String str = input.nextLine();
			try 
			{
				System.out.println(sr.strRecurse(str));
			}			
			catch (InvalidStringException ise)
			{
				valid = false;
				System.out.println(ise.getMessage());
			}
			
		} while (valid == true);
		
		
		
		
		
		input.close();
		
	}
	
	/** Method: strRecurse
	 * @param str - the string to reverse/split
	 * @return str - the String  split on each line by last letter to first
	 * 
	 * Returns line by line the last letter to the first.
	 */
	public String strRecurse(String str) throws InvalidStringException
	{
		if (str.length() <= 0)
		{
			throw new InvalidStringException("\nInvalid String\n");
		}
		else if (str.length() == 1)
		{
			return str;
		}
		else if (str.length() >= 2)
		{
			return strRecurse( str.substring( 1, str.length() ) ) + "\n" + str;
			
		}
		return "";
	}
	
	
	
	

}
