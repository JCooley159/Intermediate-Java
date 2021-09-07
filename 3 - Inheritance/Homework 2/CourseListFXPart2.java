import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * Class: MainInterface
 * 
 * @author Jeremy Cooley
 * @version 1.0 
 * 
 * Course : ITEC 3150, Fall, 2018 Written: Sept 27, 2018
 *
 * Main JavaFX Interface class - contains a CourseList, ListView 
 * and launches additional Stages to show course info
 * 
 * 
 *
 */
public class CourseListFXPart2 extends Application {

	// needs to have a field for a CourseList to pull from
	private CourseList courseList = new CourseList();
	
	
	
	/** Method: main()
	 * @author NetBeans Source Code
	 * 
	 * "The main() method is ignored in correctly deployed JavaFX application.
	 * main() serves only as fallback in case the application can not be
	 * launched through deployment artifacts, e.g., in IDEs with limited FX
	 * support. NetBeans ignores main()."
	 *
	 * Makes sense!!! (kind of)
	 *
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	
	
    /** Method: start()
     * Overrides the start() method in Application; begins a JavaFX program
     * 
     * @param primaryStage - the Stage to start/open/pull up
     */
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		
		// read in file and create library
        courseList.readFile();
        

        
        // creates a VBox with spacing of 2 between its children
        VBox primaryPane = new VBox(2);
        String courseNumStr = courseList.getCourseCount().toString();
        Label mainLabel = new Label("Courses Listed:" + courseNumStr);
        // adds the Lable to the (default) top left
        primaryPane.getChildren().add(mainLabel);
        // Creates and adds a label of the courseCount to ge the number of courses found/read
        
        
        
        // Transforms the ArrayList<Course> of courses into an Observable List
        ObservableList<Course> observableCourses = FXCollections.observableArrayList(courseList.getcourseListItems());
        // Instantiates a ListView and puts the observableCourses in it
        ListView<Course> list = new ListView<Course>();
        list.setItems(observableCourses);
        // adds the ListView below the Label
        primaryPane.getChildren().add(list);
        
        

        // make list have a selection model for when something is clicked on
        // add a listener to the selectedItemProperty to make it
        // popup info on a new stage
        list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Course>()
                {

                    public void changed(ObservableValue<? extends Course> observable,
                            Course oldValue, Course clickedCourse)
                    {
                        // pop up detail stage of selected Course object
                        Stage newStage;
                        if (clickedCourse.getCategory().equalsIgnoreCase("math"))
                        {
                            newStage = createMathStage(clickedCourse);
                        }
                        else if (clickedCourse.getCategory().equalsIgnoreCase("History"))
                        {
                            newStage = createHistoryStage(clickedCourse);
                        } 
                        else
                        {
                            newStage = createEnglishStage(clickedCourse);
                        }

                        newStage.show();
                    }
                });

        // Create a scene, put the pane in it, and place it in the stage
        Scene scene = new Scene(primaryPane, 600, 300);
        primaryStage.setTitle("Course Library"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

	}
	
	
	
	
	
    /*
     * Method to create new Stage for a English Course item
     * 
     * @param Course
     * 
     * @return Stage
     */
    private Stage createEnglishStage(Course c)
    {
        Stage stage = new Stage();
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
       
        // cast to English course
        English e = (English) c;
        // Place nodes in the pane
        pane.add(new Label("Name:"), 0, 0);
        pane.add(new Label(e.getName()), 1, 0);
        pane.add(new Label("ID:"), 0, 1);
        pane.add(new Label("" + e.getCrn()), 1, 1);
        pane.add(new Label("Format: "), 0, 2);
        pane.add(new Label(e.getFormat()), 1, 2);
        pane.add(new Label("Level: "), 0, 3);
        pane.add(new Label(e.getLevel()), 1, 3);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("English");
        return stage;
    }

    /*
     * Method to create new Stage for a Music Course item
     * 
     * @param Course
     * 
     * @return Stage
     */
    private Stage createMathStage(Course m)
    {

        Stage s = new Stage();
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);
        Math b = (Math) m;
        // Place nodes in the pane
        pane.add(new Label("Name:"), 0, 0);
        pane.add(new Label(b.getName()), 1, 0);
        pane.add(new Label("ID:"), 0, 1);
        pane.add(new Label("" + b.getCrn()), 1, 1);
        pane.add(new Label("Format:"), 0, 2);
        pane.add(new Label(b.getFormat()), 1, 2);
        pane.add(new Label("STEM?:"), 0, 3);
        pane.add(new Label(b.isStem() + " "), 1, 3);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        s.setScene(scene);
        s.setTitle("Matg");
        return s;
    }

    /*
     * Method to create new Stage for a Video Course item
     * 
     * @param Course
     * 
     * @return Stage
     */
    private Stage createHistoryStage(Course m)
    {
        Stage s = new Stage();
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);
        History b = (History) m;
        // Place nodes in the pane
        pane.add(new Label("Name:"), 0, 0);
        pane.add(new Label(b.getName()), 1, 0);
        pane.add(new Label("ID:"), 0, 1);
        pane.add(new Label("" + b.getCrn()), 1, 1);
        pane.add(new Label("Format:"), 0, 2);
        pane.add(new Label(b.getFormat()), 1, 2);

        pane.add(new Label("Area E Eligible?:"), 0, 5);
        pane.add(new Label(b.isAreaEligible() + " "), 1, 5);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        s.setScene(scene);
        s.setTitle("History");
        return s;
    }
	
	
	
	
	

}
