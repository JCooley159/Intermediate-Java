import java.awt.Insets;
import java.awt.TextField;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


@SuppressWarnings("unused")
public class ExCredJavaFX extends Application 
{
	Double subtotal = 0.00;
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		
		 
			    // Create a border gPane 
			    BorderPane bPane = new BorderPane();
			    

				
				// Create a gPane and set its properties
			    GridPane gPane = new GridPane();
			    gPane.setPrefSize(3, 3);
			    gPane.setAlignment(Pos.CENTER_LEFT);
//			    gPane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
			    gPane.setHgap(5.5);
			    gPane.setVgap(5.5);
			    
			    // A radio button with an empty string for its label
			    RadioButton rb1 = new RadioButton();			    
			    //Setting a text label
			    rb1.setText("None");
			    RadioButton rb2 = new RadioButton();
			    rb2.setText("Decaf");
			    RadioButton rb3 = new RadioButton();
			    rb3.setText("Regular");
			    
			    
			    ToggleGroup toggGrp = new ToggleGroup();
			    rb1.setToggleGroup(toggGrp);
			    rb1.setSelected(true);
			    rb2.setToggleGroup(toggGrp);
			    rb3.setToggleGroup(toggGrp);
			    
			    
			    toggGrp.selectedToggleProperty().addListener
			    	(
			    	    (ObservableValue<? extends Toggle> ov, Toggle old_toggle, 
			    	    Toggle new_toggle) -> 
			    	    {
			    	    	double coffeeCost = 0.00;
			    	        if (toggGrp.getSelectedToggle() == rb2 || toggGrp.getSelectedToggle() == rb3) 
			    	        {			    	        	
			    	        	subtotal = subtotal + 3.00;
			    	        }
			    	            
			    	    }
			    	);
			   
			    // Place nodes in the gPane
//			    gPane.add(toggGrp);
//			    GridPane.setHalignment(toggGrp, HPos.RIGHT);
			    
			    // Create a scene and place it in the stage
			    Scene scene = new Scene(gPane);
			    primaryStage.setTitle("ShowGridPane"); // Set the stage title
			    primaryStage.setScene(scene); // Place the scene in the stage
			    primaryStage.show(); // Display the stage
	}
		
		
	
}

