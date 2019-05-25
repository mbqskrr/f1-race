package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * 
 * @author Manuel Balanta
 *
 */
public class Main extends Application{
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		
		Parent root = FXMLLoader.load(getClass().getResource("race.fxml"));
		
		Scene scene = new Scene(root);
		stage.setTitle("F1 Race");
		stage.setScene(scene);
		stage.show();
	}

}
