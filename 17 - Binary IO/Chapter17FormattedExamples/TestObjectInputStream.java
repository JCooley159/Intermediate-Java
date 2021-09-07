import java.io.*;

// NOTE This class demonstrates good exception handling

public class TestObjectInputStream
{
    public static void main(String[] args) 
//    		throws ClassNotFoundException, IOException
    {
        try
        { 
        	// Create an input stream for file object.dat
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("objectOUTPUT.dat"));

            // Read Person objects from the file
            
            Person jimmy = (Person) (input.readObject());
            Person billy = (Person) (input.readObject());
            Person george = (Person) (input.readObject());            
            
            // Print Person objects to console
            System.out.println(jimmy.getFirstName() + " " + jimmy.getLastName() + " " + jimmy.getIdNum() + " " + jimmy.getCity());
            System.out.println(billy.getFirstName() + " " + billy.getLastName() + " " + billy.getIdNum() + " " + billy.getCity());
            System.out.println(george.getFirstName() + " " + george.getLastName() + " " + george.getIdNum() + " " + george.getCity());
            
            
            input.close();
        } 
        catch (IOException i)
        {
            System.out.println("Unable to read from file");
            i.printStackTrace();
        } 
        catch (ClassNotFoundException c)
        {
            System.out.println("Object read is not a Person instance");
        }
       
    }
}
