public class PrintStars

{

	public static void main(String[] args)
	
	{
	
		PrintStars ss = new PrintStars();
		
		for (int index = -1; index < 6; index++)
		
		{
		
			try
			
			{
			
				System.out.println(index + "    " + ss.getStars(index));
			
			}
			
			catch (IllegalArgumentException iae)
			
			{
			
				System.out.println("IllegalArgumentException encountered");
			
			}
	
		}
	
	
	
	
	
	}



	public String getStars(int n) throws IllegalArgumentException
	{
		if (n < 0)
		{
			throw new IllegalArgumentException();
		}
		else if (n == 0)
		{
			return "*";
		}
		else if (n == 1)
		{
			return "**";
		}
		else 
		{
			return getStars(n - 1) + "" + getStars(n-1);
		}		
		
	}



}