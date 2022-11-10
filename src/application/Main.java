package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.fxml.FXMLLoader;

/*
 * Naveen Reddy
 * C0838989
 * DEV-OPS Assignment-1
 */
public class Main extends Application {
	// Triggers the application
	@Override
	public void start(Stage primaryStage) {
		try {
			// linking XML File
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Sample.fxml"));
	        Parent root = loader.load();
            TextField textField = (TextField)root.getChildrenUnmodifiable().get(1);
            // Setting SampleController Textfield
	        SampleController.setText(textField);
	        //setting icon
	    	Image img = new Image("N:\\Lambton\\Term-3\\Devops\\JavaFX-Workspace\\CalculatorFX\\src\\application\\Images\\icon_calculator.png");
			primaryStage.getIcons().add(img);
	        Scene scene = new Scene(root);
	        // linking the css file
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	        primaryStage.setScene(scene);
	        primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	// main method
	public static void main(String[] args) {
		launch(args);
	}
}
