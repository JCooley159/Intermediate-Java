

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**Class: HW3_FileStacksQueues
 * @author Jeremy Cooley
 * @version 1.0
 * 
 * Course: ITEC 2150 Summer 2018
 * Written: July 12, 2018
 * 
 * This program will read a text file and store line in this text file in a Queue.
 * Then it will create an iterator to walk through Queue, using a recursive method to reverse 
 * each String. After reversing each String, the strings get stored in a Stack, from which
 * they are popped from the Stack and written to a file and to the console. 
 */
public class HW3_FileStacksQueues {

	/** Method: main
	 * @param String[] args
	 * @see reverseString()
	 * 
	 * Does everything the above class method describes, but passes the strings to be 
	 * reversed to the reverseString() method.
	 */
	public static void main(String[] args) throws InvalidFileNameException {


// Asks for filename or defaults to java.txt
		String filename = "java.txt";
		HW3_FileStacksQueues fsq = new HW3_FileStacksQueues();
		System.out.println("Greetings! Would you like to enter the name of the file to "
				+ "read? (Yes/No) \n If 'No', 'java.txt' will be used.");
		
		Scanner input = new Scanner(System.in);
		String yesNo = input.nextLine();
		if (yesNo.equalsIgnoreCase("yes"))
		{
			filename = input.nextLine();
		}
		System.out.println("\n");
		
// Creates FileReader and tests for exceptions		
		FileReader reader = null;
		try 
		{
			reader = new FileReader(filename);
		} catch (InvalidFileNameException ifne) {
			System.out.println(ifne.getMessage());
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		
		
// Stores each line in the text file in a Queue		
		Scanner readScan = new Scanner(reader);
		Queue<String> queue = new LinkedList<String>();
		while (readScan.hasNextLine()) 
		{
			queue.add(readScan.nextLine());     
		} 
		readScan.close();
		System.out.println("Everything's been added to a Queue.");
		
		
// Creates an Iterator to walk thru the Queue
        Iterator<String> iter = queue.iterator();
        Stack<String> strStack = new Stack<String>();
        
// Recursively reverses each string and stores in a stack
        while (iter.hasNext())
        {     	
           String reversed = fsq.reverseString(iter.next());
           strStack.push(reversed);
        }
		
        
// Prompts for a name for the output file and creates a FileWriter for it
        System.out.println("Your Strings have been reversed! What would you like to call the "
        		+ "output file?");
        input = new Scanner(System.in);
        String outputName = input.nextLine();
        System.out.println("\n");
        
        
 // Pops lines from the Stack and writes them to a file and the console 
        FileWriter writer = null;
        try 
        {
				writer = new FileWriter(outputName);        
		        while (!strStack.isEmpty())
		        {
		        	String singleStackString = strStack.pop();
		        	writer.write(singleStackString);
		        	System.out.println(singleStackString);
		        }
		        writer.close();
        } 
        catch (IOException e) 
        {			
			System.out.println("Problem with the FileWriter.");
		}
        
        System.out.println("\nTah daaaaaah! How did ya like that magic trick?! ;D");
        input.close();
       
		
	} ////////////////// END OF MAIN ///////////////////

	
	
/** Method: reverseString
 * @param String str - the string to be reversed
 * @return String - the string that has been reversed by being assembled recursively
 * 
 * Puts the last character of the input string first, and then calls itself on the remainder 
 * of the string, i.e. the first beginning of the string to the character just before the last.
 */	
	private String reverseString(String str) {
		
		if (str.length() == 0 || str.length() == 1) 
		{
			return str;
		}
		
		
	     String reversed =  str.charAt(str.length() -1) + reverseString(str.substring(0,  str.length()-1));
		
		return reversed;
	}

}
