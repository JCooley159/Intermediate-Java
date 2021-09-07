import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


/**Class: AnimalTester
 * 
 * @author Jeremy Cooley
 * @version 2.0
 * Course: ITEC 2150 Summer 2018
 * Last Updated: June 20, 2018
 *
 * This class – provides a way for users to create an ArrayList of Cats and Dogs 
 * (at random) and assign them names and number of paws. The method then writes the array
 * and a sorted version of the array to a file, "PetArrays.txt", and prints the file to 
 * the console to be able to check for accuracy.
 */
public class AnimalTester {
	
	

	public static void main(String[] args) {

		// Creates a new ArrayList, animalArray, with a size of 5 to hold all of the Animals created
		ArrayList<Animal> animalArray = new ArrayList<Animal>(5);
		
		int i = 0;
		for (i=0; i < animalArray.size(); i++) 
		{
			Scanner input = new Scanner(System.in);
			double rando = Math.random();             // 50% chance to be a Cat or Dog
			if (rando >= 0 && rando < 0.5) {
				animalArray.set(i, new Cat());
			} else if (rando >= 0.5 && rando < 1.0) {
				animalArray.set(i, new Dog());
			}
			
			
			System.out.println("Please enter the animal's name:");			
			try 
			{
				animalArray.get(i).setName(input.nextLine());  // Sets the name for the given Animal
			}
			catch (IllegalArgumentException iae) 
			{
				System.out.println(iae.getMessage());  // Throws an error if the name is not between 1 and 10 chars
			}
			
			
			System.out.println("Please enter the number of paws for " + animalArray.get(i).getName() + ":");			
			try 
			{
				animalArray.get(i).setPaws(input.nextInt());  // Sets the name for the given Animal
			}
			catch (IllegalArgumentException iae) 
			{
				System.out.println(iae.getMessage()); // Throws an error if # of paws is not between 1 and 4
			}
			input.close();
		}
		
		
		
		try 
		{
			PrintWriter writer = new PrintWriter("PetArrays.txt");
			for (i = 0; i < 5; i++)
			{
				writer.println(animalArray.get(i).toString());    // prints the unsorted array to the file
			}

			
			Collections.sort(animalArray);      // sorts the animal array by name (method 
												// in Animal class) and reassigns animalArray 
												// to itself once it's sorted			
			for (i = 0; i < 5; i++)
			{
				writer.println(animalArray.get(i).toString());      // prints the sorted array to the file
			}
			writer.close();
			
			FileReader reader = new FileReader("PetArrays.txt");
			Scanner scanner = new Scanner(reader);
			while (scanner.hasNextLine()) 
			{
				System.out.println(scanner.nextLine());              // prints to console
			}		
			scanner.close();
			
			
		} 
		catch (FileNotFoundException e) 
		{		
			System.out.println(e.getMessage());
		} 
		
		
		
		
		
		
		
		
	}

}
