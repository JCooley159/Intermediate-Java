import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
/**Class: FileReaderInterface_JCool
 * 
 * @author Jeremy Cooley
 * @version 2.0
 * Course: ITEC 2150 Summer 2018
 * Last Updated: June 21, 2018
 *
 * This class - allows the user to select a file, select an operation, to read or write, 
 * and then output the contents of the file to the console.
 */
public class FileReaderInterface_JCool 
{

	public static void main(String[] args) throws FileNotFoundException, NoSuchElementException {

		// A test file to use:
		// C:\Users\JCool\Documents\_GGC\Intermediate Java\src\Dog.java
		
			System.out.println("Please enter the location, name, and type of the file "
					+ "you wish to read.");
			Scanner input = new Scanner(System.in);
			String fileName = input.nextLine();
			
			
			String optionsMessage = "\n1. Read the file \n2. Read the file in Reverse \n3. Write a copy of the "
					+ "original to a new file \n4. Exit\n";
			System.out.println("\nPlease enter a number corresponding to what you would like to do:\n" + optionsMessage );
			int option = input.nextInt();
		try
		{	
			
			FileReader_JCool fr_jc = new FileReader_JCool();			
			while (option < 4) 
			{
				switch (option) 
				{
				
					case 1: fr_jc.readFile(fileName);
						System.out.println("\nCare to do anything else?\n" + optionsMessage);				
						option = input.nextInt();
						break;
						
						
					case 2: fr_jc.reverseRead(fileName);
						System.out.println("\nCare to do anything else?\n" + optionsMessage);				
						option = input.nextInt();
						break;
						
						
					case 3: fr_jc.writeToFile(fileName);
						break;
				}
				

				
			}
			
			
		}
		catch (FileNotFoundException e)
		{
			throw new FileMissingException("File does not exist or cannot be found");
		}
		catch (NoSuchElementException e)
		{
			
		}
		
		input.close();
		System.out.println("Bye!!! Have a great day!");
		System.exit(0);
		

	}
	
}
