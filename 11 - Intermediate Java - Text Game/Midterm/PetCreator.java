import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/** Class: PetCreator
 * 
 * @author JCool
 *
 */
		
public class PetCreator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Pet spot = new Pet("Spot", 500, "Superman");
		Pet rover = new Pet("Rover", 10, "Batman");
		Pet fish = new Pet("Fish", 7, "Aquaman");
		
		ArrayList<Pet> pets = new ArrayList<Pet>();
		pets.add(spot);
		pets.add(rover);
		pets.add(fish);
		
		// open file for writing
        ObjectOutputStream out = null;
        
        try
        {
        	out = new ObjectOutputStream(new FileOutputStream("names.dat"));
        }
        catch (FileNotFoundException fnfe)
        {
        	fnfe.printStackTrace();
        } 
        catch (IOException ioe) {
			// TODO Auto-generated catch block
			ioe.printStackTrace();
		}
        
       
        // write contents of each pet item to file
        for (Pet p : pets)
        {
            // first write the attributes common to all
            try {
				out.writeObject(p);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        }
        
        // closes output
        try {
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
