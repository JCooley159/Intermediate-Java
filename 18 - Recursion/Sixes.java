/** Class: Sixes
* @author Jeremy Cooley
* @version 1.0
* Course : ITEC 2150 Summer 2018
* Written: July 24, 2018
 *
 * This class demonstrates recursion.
 */
public class Sixes
{
	
	
	public static void main(String[] args)
	{	
		System.out.println("66776 has " + getSixes(66776) + " sixes.");
		System.out.println("123456 has " + getSixes(123456) + " sixes.");
		System.out.println("111223 has " + getSixes(111223) + " sixes.");
		System.out.println("666666 has " + getSixes(666666) + " sixes.");
		System.out.println("868686838 has " + getSixes(868686838) + " sixes.");
		System.out.println("6241 has " + getSixes(6241) + " sixes.");
		System.out.println("776 has " + getSixes(776) + " sixes.");
		
	}
	
	public static int getSixes(int num)
	{
		//Enter your code here
		String numStr = Integer.toString(num);
		
		if (numStr.length() <= 0)
		{
			return 0;
		}
		else if (numStr.length() == 1)
		{
			if (Integer.parseInt(numStr) == 6)
			{
				return 1;
			}
			else 
			{
				return 0;
			}
		}
		else if ( numStr.length() > 1 )
		{
//			int tens = numStr.length()- 1;
//			int numExp = Math.floorDiv(Integer.parseInt(numStr), (10^tens));
			char lastNum = numStr.charAt(numStr.length()-1);
			
			
			int count1 = getSixes(Integer.parseInt(numStr.substring(0, numStr.length()-1)));
			if (lastNum == '6')
			{
				count1++;
			}
			return count1;
		}
		
		return 0;
		
				
	}

}
