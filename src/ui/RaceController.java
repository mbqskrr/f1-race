package ui;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.shape.Rectangle;
//import model.Game;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;


/**
 * Clase controladora del archvio (race) fxml
 * @author Manuel Balanta
 *
 */

public class RaceController {
	
	//private Game game;
	private Rectangle car; 
	private Rectangle wheelL1;
	private Rectangle wheelL2;
	private Rectangle wheelR1;
	private Rectangle wheelR2;
	@FXML
    private Pane lane;
	@FXML
	private Button btnPlay;
	@FXML
	private Label lblPoints;
	@FXML
	private Label lblLifes;
	@FXML
    private Label lblControl;
	@FXML
	private Button btnUp;
	@FXML
	private Button btnDown;
	@FXML
	private Button btnLeft;
	@FXML
    private Button btnRight;
	protected Tooltip ttU;
	protected Tooltip ttD;
	protected Tooltip ttL;
	protected Tooltip ttR;
	
	/**
	 * Método que inicializa la clase
	 */
	public void initialize() {
		//game = new Game();
		car = new Rectangle(95, 140);
		wheelL1 = new Rectangle(12, 25);
		wheelL2 = new Rectangle(12, 25);
		wheelR1 = new Rectangle(12, 25);
		wheelR2 = new Rectangle(12, 25);
		ttU = new Tooltip();
		ttD = new Tooltip();
		ttR = new Tooltip();
		ttL = new Tooltip();
		ttU.setText("Usalo para mover el\ncarro hacia arriba");
		ttD.setText("Usalo para mover el\ncarro hacia abajo");
		ttR.setText("Usalo para mover el\ncarro hacia la derecha");
		ttL.setText("Usalo para mover el\ncarro hacia la izquierda");
		btnUp.setTooltip(ttU);
		btnDown.setTooltip(ttD);
		btnLeft.setTooltip(ttL);
		btnRight.setTooltip(ttR);
	}
	
	/**
	 * 
	 * @param event
	 */
	@FXML
	public void play(ActionEvent event) {
		Color randomColor = new Color(Math.random(),Math.random(),Math.random(),1);
		car.setFill(randomColor);
		wheelL1.setFill(Color.BLACK);
		wheelL2.setFill(Color.BLACK);
		wheelR1.setFill(Color.BLACK);
		wheelR2.setFill(Color.BLACK);
		car.setLayoutX(253);
		car.setLayoutY(520);
		wheelL1.setLayoutX(241);
		wheelL1.setLayoutY(529);
		wheelL2.setLayoutX(242);
		wheelL2.setLayoutY(629);
		wheelR1.setLayoutX(348);
		wheelR1.setLayoutY(529);
		wheelR2.setLayoutX(348);
		wheelR2.setLayoutY(629);
		lane.getChildren().add(car);
		lane.getChildren().add(wheelL1);
		lane.getChildren().add(wheelL2);
		lane.getChildren().add(wheelR1);
		lane.getChildren().add(wheelR2);
		btnPlay.setVisible(false);
		btnUp.setVisible(true);
		btnDown.setVisible(true);
		btnLeft.setVisible(true);
		btnRight.setVisible(true);
		lblControl.setVisible(true);
		btnUp.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				if (car.getLayoutY()<=10) {
					car.setLayoutY(car.getLayoutY()+15);
					wheelL1.setLayoutY(wheelL1.getLayoutY()+15);
					wheelL2.setLayoutY(wheelL2.getLayoutY()+15);
					wheelR1.setLayoutY(wheelR1.getLayoutY()+15);
					wheelR2.setLayoutY(wheelR2.getLayoutY()+15);
				} else {
					car.setLayoutY(car.getLayoutY()-25);
					wheelL1.setLayoutY(wheelL1.getLayoutY()-25);
					wheelL2.setLayoutY(wheelL2.getLayoutY()-25);
					wheelR1.setLayoutY(wheelR1.getLayoutY()-25);
					wheelR2.setLayoutY(wheelR2.getLayoutY()-25);
				}
				
			}
		});
		btnDown.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				if (car.getLayoutY()>=525) {
					car.setLayoutY(car.getLayoutY()-15);
					wheelL1.setLayoutY(wheelL1.getLayoutY()-15);
					wheelL2.setLayoutY(wheelL2.getLayoutY()-15);
					wheelR1.setLayoutY(wheelR1.getLayoutY()-15);
					wheelR2.setLayoutY(wheelR2.getLayoutY()-15);
				} else {
					car.setLayoutY(car.getLayoutY()+25);
					wheelL1.setLayoutY(wheelL1.getLayoutY()+25);
					wheelL2.setLayoutY(wheelL2.getLayoutY()+25);
					wheelR1.setLayoutY(wheelR1.getLayoutY()+25);
					wheelR2.setLayoutY(wheelR2.getLayoutY()+25);
				}
				
			}
		});
		btnRight.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				if (car.getLayoutX()>=480) {
					car.setLayoutX(car.getLayoutX()-15);
					wheelL1.setLayoutX(wheelL1.getLayoutX()-15);
					wheelL2.setLayoutX(wheelL2.getLayoutX()-15);
					wheelR1.setLayoutX(wheelR1.getLayoutX()-15);
					wheelR2.setLayoutX(wheelR2.getLayoutX()-15);
				} else {
					car.setLayoutX(car.getLayoutX()+25);
					wheelL1.setLayoutX(wheelL1.getLayoutX()+25);
					wheelL2.setLayoutX(wheelL2.getLayoutX()+25);
					wheelR1.setLayoutX(wheelR1.getLayoutX()+25);
					wheelR2.setLayoutX(wheelR2.getLayoutX()+25);
				}
			}
		});
		btnLeft.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				if (car.getLayoutX()<=20) {
					car.setLayoutX(car.getLayoutX()+15);
					wheelL1.setLayoutX(wheelL1.getLayoutX()+15);
					wheelL2.setLayoutX(wheelL2.getLayoutX()+15);
					wheelR1.setLayoutX(wheelR1.getLayoutX()+15);
					wheelR2.setLayoutX(wheelR2.getLayoutX()+15);
				} else {
					car.setLayoutX(car.getLayoutX()-25);
					wheelL1.setLayoutX(wheelL1.getLayoutX()-25);
					wheelL2.setLayoutX(wheelL2.getLayoutX()-25);
					wheelR1.setLayoutX(wheelR1.getLayoutX()-25);
					wheelR2.setLayoutX(wheelR2.getLayoutX()-25);
				}
				
			}
		});
	}
	
}
