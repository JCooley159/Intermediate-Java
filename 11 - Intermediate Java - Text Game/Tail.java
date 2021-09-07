import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


/**Class: Tail
* @author Jeremy Cooley
* @version 1.0
* Course : ITEC 2150 Summer 2018
* Written: July 24, 2018
*
*
* This class takes the last five lines of a file and prints them to the console.
* 
* Purpose: This class takes the last five lines of a file and prints them to the console.
*/
public class Tail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		Scanner readScan = null;
		FileReader reader = null;
		boolean fallOut = true;
		ArrayList<String> fiveLines = new ArrayList<String>(0);
		
		
		

		do {
			System.out.println("\nPlease enter the name of the file you wish to get the tail of.");
			try 
			{
				String filename = input.nextLine();
				reader = new FileReader(filename);
				readScan = new Scanner(reader);
				fallOut = true;

			} 
			catch (FileNotFoundException fnfe) 
			{
				System.out.println("File not found. Try again.");
				fallOut = false;
			}

		} while (!fallOut);

		
		
		
		
		
		while (readScan.hasNextLine()) 
		{
			String line = readScan.nextLine();
			if (fiveLines.size() < 5 && fiveLines.size() >= 0) 
			{
				fiveLines.add(line);
			} 
			else if (fiveLines.size() == 5) 
			{
				fiveLines.remove(0);
				fiveLines.add(line);
			}
		}

		
		
		
		
		
		System.out.println("\nYour tail, good sir!\n");
		for (String oneLine : fiveLines) 
		{
			System.out.println(oneLine);
		}
		input.close();
		readScan.close();

	}

}
