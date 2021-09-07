import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**Class: EmployeeTester
 * @author Jeremy Cooley
 * @version 2.0
 * Course: ITEC 2150 Summer 2018
 * Last Updated: May 28, 2018
 */
public class EmployeeTester {

	
	/** Method: main
	 *  Allows the user to create, interact with, and write an array of Employee objects to the console and to a file.
	 */
	public static void main(String[] args)
	{
		
		ArrayList<Employee> employeesAL = new ArrayList<>();
		boolean valid = true;
		Scanner input = new Scanner(System.in);
		
		while (valid) 
		{
				
			// obtains that names of the employee
			
			System.out.println("Please enter the first name of the employee.");
			String firstName = input.nextLine();
			System.out.println("Please enter " + firstName + "'s last name.");
			String lastName = input.nextLine();
	
					
	
			// determines what type of employee based on a random distribution and constructs fields
			// along with calculating the paycheck
//					double emplOption = Math.random();
//					if (emplOption >= 0.0 && emplOption < 0.5) 
			System.out.println("Is this employee a Manager or an Hourly?");
			String emplOption = input.nextLine();
			
			if (emplOption.equalsIgnoreCase("Manager")) 
			{
					
					// Tries to create the manager object and throws exceptions as needed
					Manager mngr  = new Manager();					
					try 					
					{
							mngr.setFirstName(firstName);							
					}
					catch (InvalidEmployeeException iee) 
					{
							System.out.println(iee.getMessage());
					}					
					try 
					{
							mngr.setLastName(lastName);							
					}
					catch (InvalidEmployeeException iee) 
					{
							System.out.println(iee.getMessage());
					}
					try 
					{
							System.out.println("What department does this Manager work in? Dev, Sales, or Management?");
							String department = input.nextLine();
							mngr.setDepartment(department);							
					}
					catch (InvalidEmployeeException iee) 
					{
							System.out.println(iee.getMessage());
					}
					try 
					{
							System.out.println("What is this Manager's annual salary?");
							
							double annualSalary = input.nextDouble();
							input.nextLine();
							mngr.setAnnualSalary(annualSalary);
							mngr.setPaycheck(mngr.calculatePaycheck());
					}
					catch (InvalidEmployeeException iee) 
					{
							System.out.println(iee.getMessage());
					}
					
					
					// finally adds the manager to the ArrayList
					employeesAL.add(mngr);
			} 
			else if (emplOption.equalsIgnoreCase("Hourly")) 
			{
					System.out.println("How many hours does this Hourly work per week?");
					double hours = input.nextDouble();
					System.out.println("How many $/hour does this Hourly make?");
					double rate = input.nextDouble();
					input.nextLine();
					
					HourlyEmployee hrly = new HourlyEmployee(firstName, lastName, hours, rate);
					hrly.setPaycheck(hrly.calculatePaycheck());
					employeesAL.add(hrly);
			}
	

			// Allows user to exit
			System.out.println("Keep entering employees? Enter 'exit' to quit or 'yes' to keep going.");
			String option = "exit";
			option = input.nextLine();
			if (option.equalsIgnoreCase("exit")) 
			{
					valid = false;
					break;
			} else if (option.equalsIgnoreCase("yes")) 
			{
					valid = true;
			}
				
				
				
				
				
				
		}
		
		
		// prints the Employee Array List to the console and a file
		System.out.println("Please enter what you want to name your file, along with the destination and extension:");
		// provides a default value to test output file with
		String outputFile = "C:\\Users\\JCool\\Documents\\_GGC\\Intermediate Java\\src\\EmployeeTesterOutput.txt"; 
		outputFile = input.nextLine();
		PrintWriter writer;
		try 
		{
			writer = new PrintWriter(outputFile);
			for (int i = 0; i < employeesAL.size(); i++) 
			{			
				System.out.println(employeesAL.get(i).toString());
				writer.println(employeesAL.get(i).toString());			
			}
			
			// Sorts the list based on First Name, in alphabetical/ascending order
			System.out.println("\n Sorted List: \n");
			writer.println("\n Sorted List: \n");
			Collections.sort(employeesAL);
			
			for (int i = 0; i < employeesAL.size(); i++) 
			{			
				System.out.println(employeesAL.get(i).toString());
				writer.println(employeesAL.get(i).toString());			
			}
			
			writer.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			input.close();
			System.out.println("\n Done and done. Bye!");
		}
		
		
		
	}

}
