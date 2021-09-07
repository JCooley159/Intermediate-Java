package files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class FileDialog
{

	public static void main(String[] args) throws FileNotFoundException
	{
		JFileChooser chooser = new JFileChooser();
		File selectedFile = null;
        try
        {
    		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
    		{
    			selectedFile = chooser.getSelectedFile();
    		}
    		
    		FileReader in = new FileReader(selectedFile);
    		
    		Scanner reader = new Scanner(in);
    		File writeFile = null;
    		if(chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
    		{
    			writeFile = chooser.getSelectedFile();
    		}
    		
    		PrintWriter pw = new PrintWriter(writeFile);
    		
    		while(reader.hasNext())
    		{
    			pw.println(reader.nextLine());
    		}
    		reader.close();
    		pw.close();
		}
		catch(NullPointerException npe)
		{
		    System.out.println(npe.getMessage());
		}
		System.exit(0);
	}

}
