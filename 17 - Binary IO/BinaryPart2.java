import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 * Binary In-Class Part 2- reading and writing using read/writeObject with ObjectOutputStream and ObjectInputStream
 * @author cjohns25
 *
 */
public class BinaryPart2
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        try
        { // Create an output stream for file temp.dat
            ObjectOutputStream output = new ObjectOutputStream(
                    new FileOutputStream("people2.dat"));

            // create three Person objects
            Person p1 = new Person("P1", "P2", 6, "Atlanta");
            Person p2 = new Person("P3", "P5", 7, "Macon");
            Person p3 = new Person("P6", "P8", 8, "Columbus");

            // write p1
           output.writeObject(p1);

            // write p2
           output.writeObject(p2);

            // write p3
            output.writeObject(p3);

            output.close();

        } catch (IOException e)
        {
            System.out.println("Problem writing to file- ending program");
            e.printStackTrace();
            System.exit(0);
        }

        // reopen file for reading and recreate 3 Person objects
        try
        { // Create an input stream for file temp.dat
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(
                    "people2.dat"));
            Person p1 = (Person) input.readObject();
            Person p2 = (Person) input.readObject();

            Person p3 = (Person) input.readObject();
            System.out.println(p1);
            System.out.println(p2);
            System.out.println(p3);
            input.close();

        } catch (IOException e)
        {
            System.out.println("Problem readingfile- ending program");
            e.printStackTrace();
            System.exit(0);
        } catch (ClassNotFoundException e)
        {
            
            e.printStackTrace();
        }


    }

}
