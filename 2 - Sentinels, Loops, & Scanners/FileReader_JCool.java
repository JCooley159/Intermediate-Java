import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
/**Class: FileReader_JCool
 * 
 * @author Jeremy Cooley
 * @version 2.0
 * Course: ITEC 2150 Summer 2018
 * Last Updated: June 20, 2018
 *
 * This class - contains the methods called in FileReaderInterface_JCool, as well as a 
 * separate method, sameDirectory(), that is used in the writeToFile() method.
 */
public class FileReader_JCool 
{

	
	public FileReader_JCool() {}
	
	/**Method: readFile()
	 * 
	 * @param String fileName - the name of the file that will be printed to the
	 * 		console line by line
	 * 
	 * Prints a copy of the file to the console, line by line, from top to bottom.
	 */
	public void readFile(String fileName) throws FileNotFoundException 
	{
		
		FileReader reader = new FileReader(fileName);		
		Scanner input = new Scanner(reader);		
		while (input.hasNextLine()) 
		{
			System.out.println(input.nextLine());              // prints to console
		}		
		input.close();
	}
	
	/**Method: reverseRead()
	 * 
	 * @param String fileName - the name of the file that will be printed
	 * 
	 * Prints a copy of the file to the console, line by line, from bottom to top.
	 */
	public void reverseRead(String fileName) throws FileNotFoundException, IndexOutOfBoundsException
	{
		FileReader reader = new FileReader(fileName);		
		Scanner input = new Scanner(reader);
		
		
		ArrayList<String> textArray = new ArrayList<String>();
		while (input.hasNextLine()) 
		{
			textArray.add(input.nextLine());                     // prints to ArrayList
		}
		
	
		int i = textArray.size() - 1;
		while (i >= 0) 
		{
			System.out.println(textArray.get(i));                // prints to console in reverse order
			i--;
		}
	
		input.close();
	
	}
	
	
	/**Method: writeToFile()
	 * 
	 * @param String fileName - the name of the file that will be printed
	 * 
	 * Writes a copy of the file to a new file, line by line, from top to bottom, and then from bottom to top. 
	 */
	public void writeToFile(String fileName) throws FileNotFoundException
	{	
		try {
			
			System.out.println("Please enter the delimiter of your operating system:");
			Scanner input = new Scanner(System.in);
			String delim = input.next();
			System.out.println("Please enter the name of the file you want to create:\n");
			String outputFileName = input.next();
			
			String directoryString = sameDirectory(fileName, delim);
			String output_Direct_and_File = directoryString + outputFileName;
			
			System.out.println("\nThe directory and file you're creating:\n" + output_Direct_and_File + "\n");
					
			
			
			
			FileReader reader = new FileReader(fileName);
			PrintWriter writer = new PrintWriter(output_Direct_and_File);
			Scanner readScan = new Scanner(reader);	
			System.out.println("Writing your file...\n");
			while (readScan.hasNextLine()) 
			{
				writer.println(readScan.nextLine());
			}
			
			input.close();
			writer.close();
			readScan.close();
			System.out.println("File written!\n");
		}
		catch (FileNotFoundException e) {
			throw new FileMissingException("File does not exist or cannot be found");
		}
	}
	
	
	/**Method: sameDirectory()
	 * 
	 * @param String fileName - the name/location of the file that will be printed
	 * @param String delim - the location delimiter for the user's specific Operating System
	 * 
	 * This method parses through the given file/directory location and removes the
	 * original file name from the string that contains the directory/location.
	 */
	public String sameDirectory(String fileName, String delim) 
	{
		StringBuffer sb = new StringBuffer(fileName);
		int lastIndex = sb.lastIndexOf(delim);
		sb.delete(lastIndex + 1, fileName.length());
		return sb.toString();
	}
}
