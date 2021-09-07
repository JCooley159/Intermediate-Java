import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MirrorFile {

	public static void main(String[] args) throws IOException, FileNotFoundException {
	
		MirrorFile mf = new MirrorFile();
		FileReader reader = new FileReader("test2Input.txt");				

		FileWriter writer = new FileWriter("mirroredInput.txt");
		
		
		Scanner readScan = new Scanner(reader);
		ArrayList<String> readAL = new ArrayList<String>();
		while (readScan.hasNextLine())
		{
			readAL.add(readScan.nextLine());
		}
		
		
		
		ArrayList<String> reverseAL = mf.reverse(readAL);
		for (String line : reverseAL)
		{
			mf.write(line, writer);
		}
		
		writer.close();	
		readScan.close();
		System.out.println("Reversed and Written!");
	}

	
	
	
	
	
	public ArrayList<String> reverse(ArrayList<String> readAL) 
	{
		ArrayList<String> newAL = new ArrayList<String>();
		for (String line : readAL)
		{
			String[] words = line.split(" ");
			String newLine = "";
			for (String word : words)
			{
				char[] letters = word.toCharArray();
				String newWord = "";
				for (int i = letters.length - 1; i >= 0; i--)
				{
					newWord =  newWord + letters[i];
				}
				newLine = newLine + newWord + " ";
			}			
			newAL.add(newLine);
			
		}
		return newAL;
	}
	
	
	
	
	
	
	
	
	public void write(String line, FileWriter writer) throws IOException 
	{
			writer.write(line);
			writer.write("\n");
	}
	
	
	
	
	
}
