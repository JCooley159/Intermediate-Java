import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;

/**Class: Fish
 * 
 * @author Jeremy Cooley
 * @version 2.0
 * Course: ITEC 2150 Summer 2018
 * Last Updated: July 15, 2018
 *
 * This class – contains the main method to add and remove Fish from the Aquarium
 * 		as well as reading a list of Fishes from a file and printing the sorted and unsorted 
 * 		Fish List to a file
 */
public class AquariumTester {

	public static void main(String[] args) throws IOException, FishNotValidException 
	{
		/////// Instantiates the Aquarium, asks for input & output fileNames ////////
		Aquarium aquar = new Aquarium();		
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the file you want to read:");
		////// The default is: fishFile.csv
		String inFilename = input.nextLine();
		System.out.println("\nPlease enter the name of the file you want to write the "
				+ "sorted list of grown fishes to:");
		////// The default is: grownFish.csv
		String outFilename = input.nextLine();
		
		
		///// tries to create a FileReader and FileWriter with the given filenames
		FileReader reader = null;
		PrintWriter writer = null;
		Scanner readIn = null;
		try 
		{
			reader = new FileReader(inFilename);
			readIn = new Scanner(reader);
			writer = new PrintWriter(outFilename);
		} 
		catch (FileNotFoundException fnfe) 
		{
			System.out.println(fnfe.getLocalizedMessage());
		}
		
		
		
		
		
		/////////////////// adds each Fish from the input file to the Aquarium //////////
		while (readIn.hasNextLine()) 
		{
			String line = readIn.nextLine();
			try {
				Fish fishy = new Fish(line);
				fishy.setDaysInTank(0);
				aquar.addFish(fishy);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		System.out.println("\nOkay! I put all those fishies into your LinkedList!\n");
		
		//////// simulates running for 730 days ///////////
		for (int days = 0; days < 730; days++)
		{
			aquar.nextDay();
		}
		
		//////////   prints each Fish to the console & file ////////
		aquar.iter = aquar.iterator();
		while(aquar.iter.hasNext())
		{
			Fish f = aquar.iter.next();
			System.out.println(f.toString());
			writer.println(f.toString());
			
		}
		
		
		
		///// sorts the list of fish ////////
		aquar.fishes.sort((f1, f2) -> f1.compareTo(f2));
			
		
		System.out.println("\nAnd now, for the sorted list:\n");
			
			
		////// writes the sorted list to the file ////////////
		aquar.iter = aquar.iterator();
		while(aquar.iter.hasNext())
		{
			Fish f = aquar.iter.next();
			System.out.println(f.toString());
			writer.println(f.toString());
			
		}
			
			
			
		writer.close();
		reader.close();
		readIn.close();
		input.close();
	}
	
	
	
	
}
