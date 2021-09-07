import java.util.Iterator;
import java.util.Set;

/**
 * Class: Main
 *
 * @author Jeremy Cooley
 * @version 1.0 Course : ITEC 3150, Fall, 2018 Written: November 16, 2018
 *
 *
 *          This class � instantiates Media files into a MediaHashMap,
 *          removes one, and prints the rest to the console.
 *
 *          Purpose: � This class is intended to print out multiple
 *          media objects
 *
 */
public class Main
{

    /** Method: main()
     *
     * purpose: does exactly what the class description says
     */
    public static void main(String[] args)
    {
        MediaHashMap<String, Media> mhm = new MediaHashMap<>();

        mhm.put("String1", new Media("1", "first media", ".jpeg"));
        mhm.put("String2", new Media("2", "video media", ".mp4"));
        mhm.put("String3", new Media("3", "moving image", ".gif"));


        mhm.remove("String3");

        Set<String> keySet = mhm.keySet();
        for (String key : keySet)
        {
            Media media = mhm.get(key);
            System.out.println(key + " : " + media.toString());
        }



    }

}
