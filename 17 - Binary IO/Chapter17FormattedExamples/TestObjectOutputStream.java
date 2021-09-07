import java.io.*;

// NOTE :  This example demonstrates exception handling where user is not notified as to cause of exception 
// or problem - if there is a problem with output file- the program just ends.

public class TestObjectOutputStream
{
    public static void main(String[] args) throws IOException
    {
        // Create an output stream for file object.dat
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("objectOUTPUT.dat"));
       	
        // Write multiple Person objects to the file
        output.writeObject(new Person("Little Jimmy", "Jones", 1, "Bristol"));
        output.writeObject(new Person("Fat Billy", "Robinson", 2, "Liverpool"));
        output.writeObject(new Person("Tall George", "Harris", 3, "Edinburgh"));
        
        
        output.close();
    }
}
