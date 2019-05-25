package ui;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
//import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.shape.Rectangle;
//import model.Game;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * 
 * @author Manuel Balanta
 *
 */

public class RaceController {
	
	//private Game game;
	
	private Rectangle car; 
	private Rectangle motor;
	
	@FXML
    private Pane lane;
	
	@FXML
	private Button btnPlay;
	
	public void initialize() {
		//game = new Game();
		car = new Rectangle(95, 140);
		motor = new Rectangle(81, 57);
	}
	
	/**
	 * 
	 * @param event
	 */
	@FXML
	public void play(ActionEvent event) {
		Color randomColor = new Color(Math.random(),Math.random(),Math.random(),1);
		car.setFill(randomColor);
		motor.setFill(randomColor);
		car.setLayoutX(253);
		car.setLayoutY(520);
		motor.setLayoutX(260);
		motor.setLayoutY(463);
		lane.getChildren().add(car);
		lane.getChildren().add(motor);
		btnPlay.setVisible(false);
		car.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				car.setLayoutX(car.getLayoutX()+25);
				motor.setLayoutX(motor.getLayoutX()+25);
				
			}
		});
		motor.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				car.setLayoutX(car.getLayoutX()-25);
				motor.setLayoutX(motor.getLayoutX()-25);
			}
		});
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean touch() {
		boolean condition = false;
		if (car.getLayoutX()< 360 && car.getLayoutX() > 10) {
			condition = false;;
		}else {
			condition = true;
		}
		return condition;
	}
}
