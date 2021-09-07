import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class ShowCircle extends Application {

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		
		// Create a circle w/ properties
	    Circle circle = new Circle();
	    circle.setCenterX(100);
	    circle.setCenterY(100);
	    circle.setRadius(50);
	    circle.setStroke(Color.BLACK);
	    circle.setFill(null);
	    
	    
	 // Create a Label
	    Label itecLabel = new Label("ITEC is the best major!");	    
	    BorderPane border = new BorderPane();
	    border.setBottom(itecLabel);
	    
	    
	    
	    // Create a pane that holds the circle & Label
	    Pane mainPane = new Pane();	    
	    mainPane.getChildren().add(border);
	    mainPane.getChildren().add(circle);
	    
	    
	    // Create a scene 
	    // Put the Pane in the Scene
	    // Put the Scene in the Stage
	    Scene scene = new Scene(mainPane, 200, 200);
	    primaryStage.setTitle("ShowCircle"); // Set the stage's title
	    primaryStage.setScene(scene); // Place the scene in the stage
	    primaryStage.show(); // Display the stage
		
		
		
		
		
	}

}
