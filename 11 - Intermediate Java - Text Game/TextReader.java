package files;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TextReader
{

    public static void main(String[] args)
    {
        ArrayList<String> lines = new ArrayList<String>();
        Scanner inFile = null;
        try
        {
            FileReader fr = new FileReader("test.txt");
            inFile = new Scanner(fr);
            while(inFile.hasNextLine())
            {
                lines.add(inFile.nextLine());
            }
        } 
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                inFile.close();
            }
            catch(NullPointerException npe)
            {
                
            }
        }
        
        try
        {
            PrintWriter pw = new PrintWriter("test2.txt");
            for (String line : lines)
            {
                pw.println(line);
            }
            pw.close();
        } 
        catch (FileNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        

    }

}
