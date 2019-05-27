package ui;


import java.io.FileNotFoundException;
import java.io.IOException;

import exception.NickNameExcpetion;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.shape.Rectangle;
import model.Car;
import model.Game;
import model.Player;
import model.Truck;
import threads.ExecutionTimeThread;
import threads.GUIControlThread;
import threads.PointsThread;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;

/**
 * Clase controladora del archvio (race) fxml y de la vista
 * @author Manuel Balanta
 *
 */

public class RaceController {
	
	private Game game;
	private Car car;
	private Truck truck;
	private Player player;
	private Rectangle bodyWork; 
	private Rectangle wheelL1;
	private Rectangle wheelL2;
	private Rectangle wheelR1;
	private Rectangle wheelR2;
	private Rectangle bwTruck; 
	private Rectangle tWheelL1;
	private Rectangle tWheelL2;
	private Rectangle tWheelR1;
	private Rectangle tWheelR2;
	private Rectangle bwTruck1; 
	private Rectangle t1WheelL1;
	private Rectangle t1WheelL2;
	private Rectangle t1WheelR1;
	private Rectangle t1WheelR2;
	private Rectangle bwTruck2; 
	private Rectangle t2WheelL1;
	private Rectangle t2WheelL2;
	private Rectangle t2WheelR1;
	private Rectangle t2WheelR2;
	@FXML
	private Pane principal;
	@FXML
    private Pane lane;
	@FXML
    private Pane login;
	@FXML
	private Label lblPoints;
	@FXML
	private Label lblLifes;
	@FXML
    private Label lblControl;
	@FXML
    private Label lblTimePlayed;
	@FXML
    private Label lblInfo;
    @FXML
    private Label lblPnts;
    @FXML
    private Label lblLfs;
    @FXML
    private Label lblTitle;
    @FXML
    private Label lblTimeP;
    @FXML
    private Label lblPlayer;
    @FXML
    private Label lblNickname;
    @FXML
    private Label lblName;
    @FXML
    private TextField jtNickname;
    @FXML
    private Button btnNext;
	@FXML
	private Button btnUp;
	@FXML
	private Button btnDown;
	@FXML
	private Button btnLeft;
	@FXML
    private Button btnRight;
	@FXML
    private Button btnLoad;
	@FXML
	private Button btnPlay;
	@FXML
	private Button btnSave;
    @FXML
    private Button btnReset;
	private Tooltip ttU;
	private Tooltip ttD;
	private Tooltip ttL;
	private Tooltip ttR;
	private boolean collisioned;
	private ExecutionTimeThread ett;
	
	
	/**
	 * Método que inicializa la clase
	 */
	public void initialize() {
		game = new Game();
		initializeCar();
		generateTooltip();
		collisioned = false;
	}
	
	/**
	 * @param event
	 */
	@FXML
	public void play(ActionEvent event) {
		btnPlay.setVisible(false);
		btnPlay.setDisable(true);
		btnLoad.setVisible(false);
		btnLoad.setDisable(true);
		login.setVisible(true);
		btnNext.setVisible(true);
		jtNickname.setVisible(true);
		lblName.setVisible(true);
	}
	
	/**
	 * 
	 * @param event
	 */
	@FXML
    void next(ActionEvent event) {
		String nickName = jtNickname.getText();
		try {
			game.validateNickname(nickName);
			lblNickname.setText(" "+nickName);
			player = new Player(nickName, 0, null);
			game.addPlayer(player);
			try {
				game.save();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			visibilityForNext();
			generateCar();
			generateMidTruck();
			generateLeftTruck();
			generateRightTruck();
			move();
			info();
			collision();
			ett = new ExecutionTimeThread(this);
			ett.setDaemon(true);
			ett.start();
			lblTimePlayed.setText(" "+ett.getMinutes()+":"+ett.getSeconds());
			PointsThread pt = new PointsThread();
			pt.setDaemon(true);
			pt.start();
			//pt.interrupt();
			/*GUIControlThread gut = new GUIControlThread(this);
			gut.setDaemon(true);
			gut.start();*/
			lblPoints.setText(" "+pt.getPoints());
			jtNickname.setText(null);
		} catch (NickNameExcpetion e1) {
			e1.printStackTrace();
		}
		
	}
	/**
	 * 
	 * @param event
	 */
	@FXML
    void load(ActionEvent event) {
		try {
			game.load();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
	/**
	 * 
	 * @param event
	 */
	@FXML
	void reset(ActionEvent event) {
		login.setVisible(true);
		btnNext.setVisible(true);
		btnNext.setDisable(false);
		jtNickname.setVisible(true);
		lblName.setVisible(true);
		collisioned = true;
		collision();
	}

	/**
	 * 
	 * @param event
	 */
	@FXML
	void save(ActionEvent event) {
		
	}
	
	/**
	 * 
	 */
	public void move() {
		moveUp();
		moveDown();
		moveRight();
		moveLeft();
	}
	
	/**
	 * 
	 */
	private void moveUp() {
		btnUp.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) { 
				if (bodyWork.getLayoutY()<=10) {
					bodyWork.setLayoutY(bodyWork.getLayoutY()+15);
					wheelL1.setLayoutY(wheelL1.getLayoutY()+15);
		  		  	wheelL2.setLayoutY(wheelL2.getLayoutY()+15);
		  		  	wheelR1.setLayoutY(wheelR1.getLayoutY()+15);
		  		  	wheelR2.setLayoutY(wheelR2.getLayoutY()+15); 
				} else {
					bodyWork.setLayoutY(bodyWork.getLayoutY()-25);
					wheelL1.setLayoutY(wheelL1.getLayoutY()-25);
					wheelL2.setLayoutY(wheelL2.getLayoutY()-25);
					wheelR1.setLayoutY(wheelR1.getLayoutY()-25);
					wheelR2.setLayoutY(wheelR2.getLayoutY()-25); 
				}
		  
			} 
		});		 
	}
	
	/**
	 * 
	 */
	private void moveDown() {
		btnDown.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				if (bodyWork.getLayoutY()>=525) {
					bodyWork.setLayoutY(bodyWork.getLayoutY()-15);
					wheelL1.setLayoutY(wheelL1.getLayoutY()-15);
					wheelL2.setLayoutY(wheelL2.getLayoutY()-15);
					wheelR1.setLayoutY(wheelR1.getLayoutY()-15);
					wheelR2.setLayoutY(wheelR2.getLayoutY()-15);
				} else {
					bodyWork.setLayoutY(bodyWork.getLayoutY()+25);
					wheelL1.setLayoutY(wheelL1.getLayoutY()+25);
					wheelL2.setLayoutY(wheelL2.getLayoutY()+25);
					wheelR1.setLayoutY(wheelR1.getLayoutY()+25);
					wheelR2.setLayoutY(wheelR2.getLayoutY()+25);
				}
				
			}
		});
	}
	
	/**
	 * 
	 */
	private void moveRight() {
		btnRight.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				if (bodyWork.getLayoutX()>=480) {
					bodyWork.setLayoutX(bodyWork.getLayoutX()-15);
					wheelL1.setLayoutX(wheelL1.getLayoutX()-15);
					wheelL2.setLayoutX(wheelL2.getLayoutX()-15);
					wheelR1.setLayoutX(wheelR1.getLayoutX()-15);
					wheelR2.setLayoutX(wheelR2.getLayoutX()-15);
				} else {
					bodyWork.setLayoutX(bodyWork.getLayoutX()+25);
					wheelL1.setLayoutX(wheelL1.getLayoutX()+25);
					wheelL2.setLayoutX(wheelL2.getLayoutX()+25);
					wheelR1.setLayoutX(wheelR1.getLayoutX()+25);
					wheelR2.setLayoutX(wheelR2.getLayoutX()+25);
				}
			}
		});
	}
	
	/**
	 * 
	 */
	private void moveLeft() {
		btnLeft.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				if (bodyWork.getLayoutX()<=20) {
					bodyWork.setLayoutX(bodyWork.getLayoutX()+15);
					wheelL1.setLayoutX(wheelL1.getLayoutX()+15);
					wheelL2.setLayoutX(wheelL2.getLayoutX()+15);
					wheelR1.setLayoutX(wheelR1.getLayoutX()+15);
					wheelR2.setLayoutX(wheelR2.getLayoutX()+15);
				} else {
					bodyWork.setLayoutX(bodyWork.getLayoutX()-25);
					wheelL1.setLayoutX(wheelL1.getLayoutX()-25);
					wheelL2.setLayoutX(wheelL2.getLayoutX()-25);
					wheelR1.setLayoutX(wheelR1.getLayoutX()-25);
					wheelR2.setLayoutX(wheelR2.getLayoutX()-25);
				}
				
			}
		});
	}
	
	private void info() {
		car = new Car(3, bodyWork.getFill().toString(), bodyWork.getWidth(), bodyWork.getHeight());
		lblLifes.setText(" "+car.getLives());
		game.addCar(car);
	}
	
	public void generateCar() {
		  Color randomColor = new Color(Math.random(),Math.random(),Math.random(),1);
		  bodyWork.setFill(randomColor); 
		  bodyWork.setLayoutX(253);
		  bodyWork.setLayoutY(520);
		  wheelL1.setLayoutX(241); 
		  wheelL1.setLayoutY(529);
		  wheelL2.setLayoutX(242);
		  wheelL2.setLayoutY(629); 
		  wheelR1.setLayoutX(348);
		  wheelR1.setLayoutY(529); 
		  wheelR2.setLayoutX(348);
		  wheelR2.setLayoutY(629);
		  lane.getChildren().add(bodyWork); 
		  lane.getChildren().add(wheelL1);
		  lane.getChildren().add(wheelL2);
		  lane.getChildren().add(wheelR1);
		  lane.getChildren().add(wheelR2);
	}
	
	/**
	 * 
	 */
	public void generateMidTruck() {
		bwTruck = new Rectangle(95, 140); 
		tWheelL1 = new Rectangle(12, 25, Color.BLACK);
		tWheelL2 = new Rectangle(12, 25, Color.BLACK);
		tWheelR1 = new Rectangle(12, 25, Color.BLACK);
		tWheelR2 = new Rectangle(12, 25, Color.BLACK);
		Color randomColor = new Color(Math.random(),Math.random(),Math.random(),1);
		bwTruck.setFill(randomColor);
		bwTruck.setLayoutX(255);
		bwTruck.setLayoutY(14);
		tWheelL1.setLayoutX(244);
		tWheelL1.setLayoutY(122);
		tWheelL2.setLayoutX(244);
		tWheelL2.setLayoutY(21);
		tWheelR1.setLayoutX(350);
		tWheelR1.setLayoutY(122);
		tWheelR2.setLayoutX(350);
		tWheelR2.setLayoutY(21);
		lane.getChildren().add(bwTruck);
		lane.getChildren().add(tWheelL1);
		lane.getChildren().add(tWheelL2);
		lane.getChildren().add(tWheelR1);
		lane.getChildren().add(tWheelR2);
		truck = new Truck(bwTruck.getFill().toString(), bwTruck.getWidth(), bwTruck.getHeight());
	}
	
	/**
	 * 
	 */
	public void generateRightTruck() {
		bwTruck1 = new Rectangle(95, 140); 
		t1WheelL1 = new Rectangle(12, 25, Color.BLACK);
		t1WheelL2 = new Rectangle(12, 25, Color.BLACK);
		t1WheelR1 = new Rectangle(12, 25, Color.BLACK);
		t1WheelR2 = new Rectangle(12, 25, Color.BLACK);
		Color randomColor = new Color(Math.random(),Math.random(),Math.random(),1);
		bwTruck1.setFill(randomColor);
		bwTruck1.setLayoutX(463);
		bwTruck1.setLayoutY(14);
		t1WheelL1.setLayoutX(452);
		t1WheelL1.setLayoutY(122);
		t1WheelL2.setLayoutX(452);
		t1WheelL2.setLayoutY(21);
		t1WheelR1.setLayoutX(558);
		t1WheelR1.setLayoutY(122);
		t1WheelR2.setLayoutX(558);
		t1WheelR2.setLayoutY(21);
		lane.getChildren().add(bwTruck1);
		lane.getChildren().add(t1WheelL1);
		lane.getChildren().add(t1WheelL2);
		lane.getChildren().add(t1WheelR1);
		lane.getChildren().add(t1WheelR2);
		truck = new Truck(bwTruck1.getFill().toString(), bwTruck1.getWidth(), bwTruck1.getHeight());
	} 
	
	/**
	 * 
	 */
	public void generateLeftTruck() {
		bwTruck2 = new Rectangle(95, 140); 
		t2WheelL1 = new Rectangle(12, 25, Color.BLACK);
		t2WheelL2 = new Rectangle(12, 25, Color.BLACK);
		t2WheelR1 = new Rectangle(12, 25, Color.BLACK);
		t2WheelR2 = new Rectangle(12, 25, Color.BLACK);
		Color randomColor = new Color(Math.random(),Math.random(),Math.random(),1);
		bwTruck2.setFill(randomColor);
		bwTruck2.setLayoutX(45);
		bwTruck2.setLayoutY(14);
		t2WheelL1.setLayoutX(34);
		t2WheelL1.setLayoutY(122);
		t2WheelL2.setLayoutX(34);
		t2WheelL2.setLayoutY(21);
		t2WheelR1.setLayoutX(140);
		t2WheelR1.setLayoutY(122);
		t2WheelR2.setLayoutX(140);
		t2WheelR2.setLayoutY(21);
		lane.getChildren().add(bwTruck2);
		lane.getChildren().add(t2WheelL1);
		lane.getChildren().add(t2WheelL2);
		lane.getChildren().add(t2WheelR1);
		lane.getChildren().add(t2WheelR2);
		truck = new Truck(bwTruck2.getFill().toString(), bwTruck2.getWidth(), bwTruck2.getHeight());
	}
	
	public void collision(/*Rectangle r, Rectangle r1, Rectangle r2, Rectangle r3*/) {
		btnReset.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				collisioned = true;
				ett.interrupt();
			}
		});
	}
	
	private void moveTruck(Rectangle bw, Rectangle w, Rectangle w1, Rectangle w2, Rectangle w3) {
		bw.setLayoutY(bw.getLayoutY()+15);
		w.setLayoutY(w.getLayoutY()+15);
		w1.setLayoutY(w1.getLayoutY()+15);
		w2.setLayoutY(w2.getLayoutY()+15);
		w3.setLayoutY(w3.getLayoutY()+15);
	}
	
	public void initializeCar() {
		bodyWork = new Rectangle(95, 140);
		wheelL1 = new Rectangle(12, 25, Color.BLACK);
		wheelL2 = new Rectangle(12, 25, Color.BLACK);
		wheelR1 = new Rectangle(12, 25, Color.BLACK);
		wheelR2 = new Rectangle(12, 25, Color.BLACK);
	}
	
	public void generateTooltip() {
		ttU = new Tooltip();
		ttD = new Tooltip();
		ttR = new Tooltip();
		ttL = new Tooltip();
		ttU.setText("Úsalo para mover el\ncarro hacia arriba");
		ttD.setText("Úsalo para mover el\ncarro hacia abajo");
		ttR.setText("Úsalo para mover el\ncarro hacia la derecha");
		ttL.setText("Úsalo para mover el\ncarro hacia la izquierda");
		btnUp.setTooltip(ttU);
		btnDown.setTooltip(ttD);
		btnLeft.setTooltip(ttL);
		btnRight.setTooltip(ttR);
	}
	
	public void moveTruck() {
		moveTruck(bwTruck, tWheelL1, tWheelL2, tWheelR1, tWheelR2);
		moveTruck(bwTruck1, t1WheelL1, t1WheelL2, t1WheelR1, t1WheelR2);
		moveTruck(bwTruck2, t2WheelL1, t2WheelL2, t2WheelR1, t2WheelR2);
	}

	public Label getLblTimePlayed() {
		return lblTimePlayed;
	}

	public boolean isCollisioned() {
		return collisioned;
	}

	public void setCollisioned(boolean collisioned) {
		this.collisioned = collisioned;
	}

	public void visibilityForNext() {
		btnUp.setVisible(true);
		btnDown.setVisible(true);
		btnLeft.setVisible(true);
		btnRight.setVisible(true);
		lblControl.setVisible(true);
		login.setVisible(false);
		btnNext.setVisible(false);
		btnNext.setDisable(true);
		jtNickname.setVisible(false);
		lblName.setVisible(false);
		btnSave.setVisible(true);
		btnReset.setVisible(true);
	}
	
}
