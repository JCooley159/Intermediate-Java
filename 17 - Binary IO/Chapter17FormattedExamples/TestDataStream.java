import java.io.*;

/**
 * 
 * @author Jeremy Cooley
 *
 */
public class TestDataStream {
  public static void main(String[] args)  {
    try { // Create an output stream for file temp.dat
      DataOutputStream output = new DataOutputStream(new FileOutputStream("peopleOUTPUT.dat"));
   
      // Write people to the file
      Person jimmy = new Person("Little Jimmy", "Jones", 1, "Bristol");
      output.writeUTF(jimmy.getFirstName());
      output.writeUTF(jimmy.getLastName());
      output.writeInt(jimmy.getIdNum());
      output.writeUTF(jimmy.getCity());
      
      
      
      Person billy = new Person("Fat Billy", "Robinson", 2, "Liverpool");
      output.writeUTF(billy.getFirstName());
      output.writeUTF(billy.getLastName());
      output.writeInt(billy.getIdNum());
      output.writeUTF(billy.getCity());
      
      
      
      Person george = new Person("Tall George", "Harris", 3, "Edinburgh");
      output.writeUTF(george.getFirstName());
      output.writeUTF(george.getLastName());
      output.writeInt(george.getIdNum());
      output.writeUTF(george.getCity());
      
      output.close();
    }
    catch (IOException e)
    {
        System.out.println("Problem writing to file- ending program");
        System.exit(0);
    }
    
    
    
    
    
    
    
    
    
    try { // Create an input stream for file temp.dat
	      DataInputStream input =
	        new DataInputStream(new FileInputStream("peopleOUTPUT.dat"));
	  
	      // Creates new Person objects before reading their info in from the file, and then prints out the fields of the new Person Objects
	   
	      Person jimmy = new Person(input.readUTF(), input.readUTF(), input.readInt(), input.readUTF());
	      System.out.println(jimmy.getFirstName() + " " + jimmy.getLastName() + " " + jimmy.getIdNum() + " " + jimmy.getCity());


	      
	      Person billy = new Person(input.readUTF(), input.readUTF(), input.readInt(), input.readUTF());
	      System.out.println(billy.getFirstName() + " " + billy.getLastName() + " " + billy.getIdNum() + " " + billy.getCity());
	      
	      
	      
	      Person george = new Person(input.readUTF(), input.readUTF(), input.readInt(), input.readUTF());
	      System.out.println(george.getFirstName() + " " + george.getLastName() + " " + george.getIdNum() + " " + george.getCity());
	      
	      
	      
	      input.close();
	    }
	catch (IOException e)
	      {
	          System.out.println("Problem readingfile- ending program");
	          System.exit(0);
	      }
    
    
    
    
    
    
    
    
    
  }
}
