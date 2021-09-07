import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileProcess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String filename = "TestFile.txt";
		FileReader reader = null;
		try {
			reader = new FileReader(filename);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		Scanner input = new Scanner(reader);	
		String intString = "";
		
		while (input.hasNextLine()) 
		{
			StringTokenizer st = new StringTokenizer(input.nextLine(), " ");
			while (st.hasMoreTokens()) {
				try {
					int a = Integer.parseInt(st.nextToken()); 
					intString = intString + " " + a;
					
				} catch (NumberFormatException nfe) {
					
				} catch (NoSuchElementException nsee) {
					
				}
				 
			}
			       
		}		
		System.out.println(intString);
		input.close();
		
//		
//		
//	
//		sb.delete(lastIndex, fileName.length());
//		return sb.toString();
//		
//		
		
		
	}

}
