import java.util.ArrayList;
import java.util.Scanner;

/**Class: CustomerTester
* @author Customer Tester
* @version 1.0
* Course : ITEC 2150 Summer 2018
* Written: July 24, 2018
*
*
* This class This class will test the Customer class
*
* Purpose: This class will test the Customer class
*/
public class CustomerTester 
{
   	
	
	public static void main(String[] args)
	{
		
		
		//Add at least five customers to an ArrayList
		ArrayList<Customer> custAL = new ArrayList<Customer>();
		Scanner input = new Scanner(System.in);
		boolean fallOut = false;
		
		System.out.println("Let's enter some Customers into your list, shall we?");
		do
		{
			System.out.println("Please enter the first and last names of the employee with a space in "
					+ "between. Or, press enter to stop.");
			String nameStr = input.nextLine();
			if (nameStr.equalsIgnoreCase(""))
			{
				fallOut = true;
				System.out.println("\nOkay, gotcha!\n");
			}
			else 
			{
				String[] names = nameStr.split(" ");
				Customer customer = new Customer(names[0], names[1]);
				custAL.add(customer);
			}
			
		} while(!fallOut);
		
		
		
		//Print the initial list
		System.out.println("Unsorted:\n");
		for (Customer c : custAL)
		{
			System.out.println(c.toString());
		}
		
		
				
		//Sort the ArrayList
		custAL.sort((cust1, cust2) -> cust1.compareTo(cust2));
		
		
		//Print the results out to the console
		System.out.println("\nSorted:\n");		
		for (Customer c : custAL)
		{
			System.out.println(c.toString());			
		}
		System.out.println("\nOkay, done!");
		
		
		
		
		input.close();
	}	
	
	
}

