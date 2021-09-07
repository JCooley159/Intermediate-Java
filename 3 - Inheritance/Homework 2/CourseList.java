import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class: CourseList
 * 
 * @author Dr. Johnson
 * @author Jeremy Cooley
 * @version 1.0 Course : ITEC 3150, Fall, 2015 Written: January 18, 2012
 * 
 * 
 *          This class: This class describes CourseList used to contain the
 *          Course item CourseList. It also contains the main method which
 *          starts the program.
 * 
 *          Purpose: Methods and attributes needed to create a CourseList of
 *          Course class items. Print them, read them from a file, search for a
 *          particular id, and add a new item.
 *
 */
public class CourseList
{

    // actual CourseList data
    private ArrayList<Course> courseListItems = new ArrayList<Course>();
    private Integer courseCount = 0;
    
    
    
//////////////// Doesn't Need a Main() --> left for CourseListFXPart2
//    @Override
//    public void start(Stage primaryStage) {
//        // Create a scene and place a button in the scene
//        BorderPane borderPane = new BorderPane();
////        final Integer courseNum = courseCount;
//        String courseStr = "Courses Found: " + courseCount.toString();
//        Label countLabel = new Label(courseStr);
//        borderPane.setRight(countLabel);
//        Label courseList = new Label("CourseList");
//        borderPane.setLeft(courseList);
//        
//        // tooooooootally took this from the book's FlashText.java
//        // example, but I reeeeeaaalllly didn't wanna create another
//        // class for what I could solve with another Thread...
////        new Thread(new Runnable() 
////        {
////            @Override
////            public void run() 
////            {
////              try 
////              {
////                while (true) 
////                {
////                  if (countLabel.getText() == "0")
////                  { 
////                	  courseCount = courseNum + 1;
////                  }
////                  else
////                  {
////                	  courseCount = courseNum;;
////                  }
////        
////                  Platform.runLater(new Runnable() 
////                  {
////	                    @Override 
////	                    public void run() 
////	                    {
////	                    	 String courseStr = "Courses Found: " + courseCount.toString();
////	                    	 countLabel = new Label(courseStr);
////	                    }
////                  });
////                  
////                  Thread.sleep(500);
////                }
////              }
////              catch (InterruptedException ex) 
////              {
////              }
////            }
////          }).start();
//        
//        
//        Scene scene = new Scene(borderPane, 200, 250); // Put the pane in the scene
//        primaryStage.setTitle("Course Counter"); // Set the stage title
//        primaryStage.setScene(scene); // Put the scene in the stage
//        primaryStage.show(); // Display the stage
//
//        
//      }
//    
//    /**
//     * 
//     * Method:main()
//     * 
//     * This method is the starting point of the program. It contains the initial
//     * reading of items from the text file Course.txt and a menu for allowing
//     * user to choose various tasks.
//     * 
//     * 
//     * @param args
//     * @throws IOException 
//     * @throws ClassNotFoundException 
//     * @throws FileNotFoundException 
//     */
//    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException
//    {
//        // create courseList by reading in from text file named media.txt
//        CourseList myCourseList = new CourseList();
//        
//        myCourseList.readObjectFile();
//        myCourseList.start(primaryStage);
//        launch(args);
//
////        Scanner input = new Scanner(System.in);
////
////        System.out.println("Welcome to the Cooley University Course List");
////        boolean done = false;
////        while (!done)
////        {
////            System.out.println("Would you like to :");
////            System.out.println("  1. View contents of Client List");
////            System.out.println("  2. Search for a Course");
////            System.out.println("  3. Remove a Course");
////            System.out.println("  4.  Exit");
////            String tp = input.nextLine();
////            int userInput = Integer.parseInt(tp);
////            if (userInput == 1)
////            {
////                myCourseList.printCourseListItems();
////            } else if (userInput == 2)
////            {
////                System.out.println("Please enter Course name");
////                String id = input.nextLine();
////                Course item = myCourseList.searchByName(id);
////                if (item != null)
////                {
////                    System.out.println(item);
////                } else
////                {
////                    System.out.println("Sorry- item not found");
////                }
////            } else if (userInput == 3)
////            {
////                System.out.println("Please enter Course name");
////                String id2 = input.nextLine();
////                myCourseList.removeItem(id2);
////            } else
////            {
////                done = true;
////                // write out contents of courseList back to original file
////                myCourseList.writeFile();
////            }
////		input.close();
//
//
//    }
        
    
    
    
    /**
     * Method:readFile()
     * 
     * This method reads in file named courses.txt and populates the
     * courseListItems arrayList
     * 
     */
    public void readFile()
    {
        // open text file
        File courseFile = new File("courses.txt");
        // open a Scanner to read data from File
        Scanner courseReader = null;
        try
        {
            courseReader = new Scanner(courseFile);
        } catch (FileNotFoundException e)
        {

            System.out
                    .println("No courseList Course found- courseList is empty");

        }

        // read one course at a time
        while (courseReader != null && courseReader.hasNext())
        {

            String category = courseReader.nextLine();
            String name = courseReader.nextLine();
            String crnString = courseReader.nextLine();
            int crn = Integer.parseInt(crnString);

            if (category.equalsIgnoreCase("English"))
            {
                String level = courseReader.nextLine();

                String format = courseReader.nextLine();
                English tp = new English(category, name, crn, level, format);
                addItem(tp);

            } else if (category.equalsIgnoreCase("Math"))
            {
                String temp = courseReader.nextLine();
                boolean stem = Boolean.parseBoolean(temp);

                String format = courseReader.nextLine();

                Math tp = new Math(category, name, crn, stem, format);
                addItem(tp);

            } else if (category.equalsIgnoreCase("History"))
            {
                String temp = courseReader.nextLine();
                boolean areaEligible = Boolean.parseBoolean(temp);
                String format = courseReader.nextLine();
                History tp = new History(category, name, crn, areaEligible,
                        format);
                addItem(tp);
            } else
            {
                System.out.println("Unknown Course type " + category);
            }

        }

    }

    /**
     * Method:readObjectFile()
     * 
     * This method reads in file named courses.dat and populates the
     * courseListItems arrayList
     * @throws IOException 
     * @throws FileNotFoundException 
     * @throws ClassNotFoundException 
     * 
     */
    public void readObjectFile() throws FileNotFoundException, IOException, ClassNotFoundException
    {
    	// opens the dat file of courses
        ObjectInputStream courseReader = new ObjectInputStream(new FileInputStream("courses.dat"));;
        
		// can't iterate over each object in ObjectInputStream
        //   b/c it doesn't implement Iterable
    	//     for (Course c : courseReader) {}
        try
        {
            // reads each course one at a time until it reaches the
        	// end of the stream and throws an EOFException, which
        	// breaks it out of the while loop
        	
            while (true)
            {
                Course c = (Course) courseReader.readObject();
                addItem(c);
            }
        } 
        catch (EOFException e)
        {
            // does nothing except fall out
        }
        
        courseReader.close();

    }
        
    /**
     * Method:writeObjectFile()
     * 
     * This method writes an object file named courses.dat with 
     * information from the course arrayList
     * 
     */
    public void writeObjectFile() throws IOException, NotSerializableException
    {
    	// open file for writing
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("courses.dat"));
        
       
        // write contents of each courseList item to file
        for (Course g : getcourseListItems())
        {
            // first write the attributes common to all
            out.writeObject(g);

        }
        out.close();

    }
        
    /**
     * Method:writeFile()
     * 
     * This method writes file named courses.txt with information 
     * from the course arrayList
     * 
     */
    public void writeFile()
    {
        PrintWriter out = null;
        // open file for writing
        try
        {
            out = new PrintWriter(new File("courses.txt"));
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        // write contents of each courseList item to file
        for (Course g : getcourseListItems())
        {
            // first write the attributes common to all
            out.println(g.getCategory());
            out.println(g.getName());
            out.println(g.getCrn());

            if (g.getCategory().equalsIgnoreCase("History"))
            {
                // cast to appropriate subclass
                History p = (History) g;
                out.println(p.isAreaEligible());
                out.println(p.getFormat());

            } else if (g.getCategory().equalsIgnoreCase("Math"))
            {
                // cast to appropriate subclass
                Math c = (Math) g;
                // write attributes specific to Math
                out.println(c.isStem());
                out.println(c.getFormat());

            } else if (g.getCategory().equalsIgnoreCase("English"))
            {
                English m = (English) g;
                out.println(m.getLevel());
                out.println(m.getFormat());

            } else
            {
                System.out.println("Unknown Course type " + g.getCategory());
            }

        }
        out.close();

    }
    
    
    
    
    
    /**
     * @return the courseListItems
     */
    public ArrayList<Course> getcourseListItems()
    {
        return courseListItems;
    }
    
    /**
     * Method:printCourseListItems()
     * 
     * This method prints the courseList items contained in the courseListItems
     * Array list. It relies on the toString method of the various Course types
     * to print the items in a user friendly format.
     * 
     * 
     */
    public void printCourseListItems()
    {
        for (int i = 0; i < courseListItems.size(); i++)
        {
            Course temp = courseListItems.get(i);
            System.out.println(temp);
        }

    }

    /**
     * Method:searchById()
     * 
     * This method looks at each item in the courseListItems array list and if
     * its idNumber attribute matches the input parameter id, that item is
     * returned to the caller. It returns null if item is not found.
     * 
     * @param name
     * 
     * @return Course
     * 
     */
    public Course searchByName(String name)
    {
        Course item = null;
        for (Course temp : courseListItems)
        {
            if (temp.getName().equalsIgnoreCase(name))
            {
                item = temp;
            }

        }
        return item;
    }

    /**
     * Method:addItem()
     * 
     * This method adds the parameter m to the courseListItems array list
     * 
     * @param m
     * 
     */
    public void addItem(Course m)
    {
        courseListItems.add(m);
        setCourseCount(getCourseCount() + 1);
    }

    /**
     * Method:removeItem()
     * 
     * This method removes the item with id from the array list
     * 
     * @param m
     * 
     */
    public void removeItem(String name)
    {
        Course g = this.searchByName(name);
        if (g != null)
        {
            courseListItems.remove(g);
        }
    }

	/**
	 * @return the courseCount
	 */
	public Integer getCourseCount() {
		return courseCount;
	}

	/**
	 * @param courseCount the courseCount to set
	 */
	public void setCourseCount(Integer courseCount) {
		this.courseCount = courseCount;
	}



}
