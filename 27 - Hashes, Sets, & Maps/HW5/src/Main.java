import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;

/**
 * Class: Main
 *
 * @author Jeremy Cooley
 * @version 1.0 Course : ITEC 3150, Fall, 2018 Written: November 16, 2018
 *
 *
 *          This class � Reads in courses from a text file and adds them to a Map
 *          based on their CRN's. Then, prints out the courses from the map based on their CRNs
 *
 */
public class Main
{


    /** Method: main()
     *
     * purpose: does what the class description says
     */
    public static void main(String[] args)
    {

        // open text file
        File courseFile = new File("courses.txt");
        // open a Scanner to read data from File
        Scanner courseReader = null;
        try
        {
            courseReader = new Scanner(courseFile);
        }
        catch (FileNotFoundException e)
        {
            System.out
                    .println("No courseList Course found- courseList is empty");
        }



        // Instantiate the HashMap
        HashMap<Integer, Course> courseHM = new HashMap<>();



        // read the file one course at a time & determine which subject
        // it is before creating an instance of the course and adding it
        // to the HashMap
        while ( courseReader != null && courseReader.hasNext() )
        {

            String category = courseReader.nextLine();
            String name = courseReader.nextLine();
            String crnString = courseReader.nextLine();
            Integer crn = Integer.parseInt(crnString);

            if ( category.equalsIgnoreCase("English") )
            {

                String level = courseReader.nextLine();
                String format = courseReader.nextLine();

                // Creates the English course & puts it in the HashMap
                English tempClass = new English(category, name, crn, level, format);
                courseHM.put(crn, tempClass);

            }
            else if ( category.equalsIgnoreCase("Math") )
            {

                String temp = courseReader.nextLine();
                boolean stem = Boolean.parseBoolean(temp);
                String format = courseReader.nextLine();

                // Creates the Math course & puts it in the HashMap
                Math tempClass = new Math(category, name, crn, stem, format);
                courseHM.put(crn, tempClass);

            }
            else if ( category.equalsIgnoreCase("History") )
            {

                String temp = courseReader.nextLine();
                boolean areaEligible = Boolean.parseBoolean(temp);
                String format = courseReader.nextLine();

                // Creates the History course & puts it in the HashMap
                History tempClass = new History(category, name, crn, areaEligible,
                        format);
                courseHM.put(crn, tempClass);

            }
            else
            {
                System.out.println("Unknown Course type " + category);
            }

        }




        // iterates through the key set of Integers
        Set<Integer> keySet = courseHM.keySet();
        for (Integer key : keySet)
        {
            Course course = courseHM.get(key);
            System.out.println(key + " : " + course.toString());
        }



    }



}
