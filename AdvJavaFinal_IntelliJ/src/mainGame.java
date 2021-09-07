// JEREMY COOLEY 12/7/2018 Adv JAVA Final

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Given the file Game.java (attached).  Write a Java class with a main that creates three instances of the Game class and writes them to a binary file named games.ser
 *      * You may use either (but not both) DataOutputStream or ObjectOutputStream
 *      *
 *      * Be sure to turn in the Game.java file along with your Java file and the games.ser file.
 */
public class mainGame
{
    public static void main(String[] args)
    {
        Game game1 = new Game(1, "BioShock", "Horror", 3);
        Game game2 = new Game(2, "Catherine", "Puzzle", 1);
        Game game3 = new Game(3, "Doom", "Shooter", 5);

        ObjectOutputStream gamesOutput;
        try
        {
            gamesOutput = new ObjectOutputStream(new FileOutputStream("games.ser"));
            gamesOutput.writeObject(game1);
            gamesOutput.writeObject(game2);
            gamesOutput.writeObject(game3);
            gamesOutput.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }


}
