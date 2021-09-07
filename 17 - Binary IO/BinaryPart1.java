import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Binary File In-Class Part 1 Using DataOutputStream and DataInputStream to
 * save and retrieve Person objects
 * 
 * @author cjohns25
 *
 */
public class BinaryPart1
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {

        try
        { // Create an output stream for file temp.dat
            DataOutputStream output = new DataOutputStream(
                    new FileOutputStream("people.dat"));

            // create three Person objects
            Person p1 = new Person("P1", "P2", 6, "Atlanta");
            Person p2 = new Person("P3", "P5", 7, "Macon");
            Person p3 = new Person("P6", "P8", 8, "Columbus");

            // write p1
            output.writeUTF(p1.getFirstName());
            output.writeUTF(p1.getLastName());
            output.writeInt(p1.getIdNum());
            output.writeUTF(p1.getCity());

            // write p2
            output.writeUTF(p2.getFirstName());
            output.writeUTF(p2.getLastName());
            output.writeInt(p2.getIdNum());
            output.writeUTF(p2.getCity());

            // write p3
            output.writeUTF(p3.getFirstName());
            output.writeUTF(p3.getLastName());
            output.writeInt(p3.getIdNum());
            output.writeUTF(p3.getCity());

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
            DataInputStream input = new DataInputStream(new FileInputStream(
                    "people.dat"));
            Person p1 = new Person(input.readUTF(), input.readUTF(),
                    input.readInt(), input.readUTF());
            Person p2 = new Person(input.readUTF(), input.readUTF(),
                    input.readInt(), input.readUTF());

            Person p3 = new Person(input.readUTF(), input.readUTF(),
                    input.readInt(), input.readUTF());
            System.out.println(p1);
            System.out.println(p2);
            System.out.println(p3);

        } catch (IOException e)
        {
            System.out.println("Problem readingfile- ending program");
            e.printStackTrace();
            System.exit(0);
        }

    }

}
