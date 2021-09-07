/**Class: Recursion
 * 
 * @author Jeremy Cooley
 */
public class Recursion {

	public static void main(String[] args) {
		
		
		Recursion rec = new Recursion();
		System.out.print("'' --> ");
		System.out.println(rec.doubleCounter(""));
		System.out.print("'aa' --> ");
		System.out.println(rec.doubleCounter("aa"));
		System.out.print("'ab' --> ");
		System.out.println(rec.doubleCounter("ab"));
		System.out.print("'aaa' --> ");
		System.out.println(rec.doubleCounter("aaa"));
		System.out.print("'aabb' --> ");
		System.out.println(rec.doubleCounter("aabb"));
		System.out.print("'aaabb' --> ");
		System.out.println(rec.doubleCounter("aaabb"));
		System.out.print("'aaaabbb' --> ");
		System.out.println(rec.doubleCounter("aaaabbb"));
		
				
	}
	
	
	public int doubleCounter(String input) 
	{
		int count;
		String sub = "";
		if (input.length() <= 1)
		{
			count = 0;
		}
		else if (input.length() == 2)
		{
			char first = input.charAt(0);
			char second = input.charAt(1);
			if (first == second)
			{
				count++;
			}
		}
		else if (input.length() > 2)
		{
			count = count + doubleCounter(input.substring(1,input.length()-1));
		}
		
		return count;
	}
	
	
	

}
