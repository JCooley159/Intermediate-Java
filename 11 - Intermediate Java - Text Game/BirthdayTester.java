import java.util.LinkedList;
import java.util.Scanner;

public class BirthdayTester implements Iterator<Birthday> {

	private LinkedList<Birthday> bdList = null;
	
	public static void main(String[] args) 
	{

		BirthdayTester bdTester = new BirthdayTester();		
		bdList = new LinkedList<Birthday>();
		
		
		
		
		bdList = bdTester.addData(bdList);
		
		bdTester.printList(bdList);
		
		bdTester.findOldest(bdList);
		
		
		
		

	}
	
	
	
	
	public LinkedList<Birthday> addData(LinkedList<Birthday> bdList)
	{
		Scanner input = new Scanner(System.in);
		boolean valid = false;
		while (!valid)
		{			
			System.out.println("Enter the person's name. Enter -1 to exit.");
			
			String name = input.nextLine();
			if (name.equalsIgnoreCase("-1"))
			{
				valid = true;
				break;
			}
			
			
			Birthday bday = new Birthday();			
			try
			{
				bday.setName(name);
			}
			catch (InvalidBirthdayException ibe)
			{
				System.out.println(ibe.getMessage());
			}
			
			System.out.println("Enter the birthday (yyyymmdd)")
			int bdate = input.nextInt();
			input.nextLine();
			try
			{
				bday.setBday(name);
			}
			catch (InvalidBirthdayException ibe)
			{
				System.out.println(ibe.getMessage());
			}
			
			bdList.add(bday);
			
		}
		input.close();
		return bdList;
	}
	
	
	
	
	
	public void printList(LinkedList<Birthday> bdList)
	{ 
		for (Birthday bday : bdList)
		{
			System.out.println( bday.toString() + "\n" );
		}
	}
	
	
	
	
	
	public String findOldest(LinkedList<Birthday> bdList)
	{
		Iterator<Birthday> iter = bdList.iterator();
		Birthday oldest = new Birthday();
		while (iter.hasNext())
		{
			Birthday other = iter.next();
			int whoIsOlder = oldest.compareTo(other);
			if (whoIsOlder < 0)
			{
				// if compareTo comes back negative, we know that the second Birthday,
				// other, comes BEFORE the current oldest, and so oldest gets set to other.
				oldest = other;
			}
			
		}
		return "The oldest person in the list is " + oldest.toString();	
	
	}


}
