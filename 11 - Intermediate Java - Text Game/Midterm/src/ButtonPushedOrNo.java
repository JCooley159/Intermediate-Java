package src;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

	public class ButtonPushedOrNo extends Application {
	  @Override // Override the start method in the Application class
	  public void start(Stage primaryStage) {
	    // Create a scene and place a button in the scene
	   
		  Button button1 = new Button("Button 1 Pushed");
		  Label label = new Label("No button pushed");
		  button1.setOnAction((event)->
			{
				label.setText("Button 1 Pushed");
			});
		  
		  Button button2 = new Button("Button 2 Pushed");
		  
		  
		  StackPane pane = new StackPane();
		  pane.getChildren().add(button1); 
		  pane.getChildren().add(label);	
		  pane.getChildren().add(button2);
	    
	    Scene scene = new Scene(pane, 200, 200);
	    primaryStage.setTitle("Button PushedOrNo"); // Set the stage title
	    primaryStage.setScene(scene); // Place the scene in the stage
	    primaryStage.show(); // Display the stage
	  }
	  
	  /**
	   * The main method is only needed for the IDE with limited
	   * JavaFX support. Not needed for running from the command line.
	   */
	  public static void main(String[] args) {
	    launch(args);
	  }
	}

