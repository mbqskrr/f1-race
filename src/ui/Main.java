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
	
	private Stage stage;
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		
		this.stage = stage;
		
		Parent root = FXMLLoader.load(getClass().getResource("race.fxml"));
		
		Scene scene = new Scene(root);
		this.stage.setTitle("F1 Race");
		this.stage.setScene(scene);
		this.stage.show();
	}
}
