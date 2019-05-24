package ui;

import javafx.event.ActionEvent;
//import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.shape.Rectangle;
import model.Game;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * 
 * @author W-7
 *
 */

public class RaceController {
	
	private Game game;
	
	@FXML
    private Pane lane;
	
	@FXML
	private Button btnPlay;
	
	@FXML
	void play(ActionEvent event) {
		double x, y;
		x = lane.getWidth()/2;
		y = lane.getHeight()/2;
		Rectangle car = new Rectangle();
		car.setFill(Color.BLUE);
		car.setLayoutX(x);
		car.setLayoutY(y);
		lane.getChildren().add(car);
		btnPlay.setVisible(false);
	}
		
	public void initialize() {
		game = new Game();
		//move();
	}
    
	public void move() {
		/*Rectangle car = new Rectangle();
		lane.getChildren().add(car);*/
	}

}
