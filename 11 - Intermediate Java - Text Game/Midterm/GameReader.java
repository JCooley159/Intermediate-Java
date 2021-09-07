import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class GameReader {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub

		// opens the dat file of courses
        ObjectInputStream gameReader = new ObjectInputStream(new FileInputStream("games.dat"));;
        
		
        try
        {
        	// can't iterate over each object in ObjectInputStream
            // b/c it doesn't implement Iterable. INSTEAD, it
            // reads each game one at a time until it reaches the
        	// end of the stream and throws an EOFException, which
        	// breaks it out of the while loop
        	
            while (true)
            {
                Game g = (Game) gameReader.readObject();
                System.out.println(g.toString());
            }
        } 
        catch (EOFException e)
        {
            // does nothing except fall out
        }
        
        gameReader.close();
		
		
		
		
	}

}
