package model;

/**
 * 
 * @author W-7
 *
 */

public class Car extends Vehicule{
	
	private int lives; 
	private int points;
	private Car next;
	private Car prev;
	
	/**
	 * Método constructor de la clase Player
	 * @param points
	 * @param lives
	 * @param color
	 * @param width
	 * @param height
	 */
	public Car(int points, int lives, String color, double width, double height) {
		super(color, width, height);
		this.lives = lives;
		this.points = points;
	}

	/**
	 * 
	 * @return
	 */
	public int getPoints() {
		return points;
	}
	
	/**
	 * 
	 * @param points
	 */
	public void setPoints(int points) {
		this.points = points;
	}

	/**
	 * 
	 * @return
	 */
	public Car getNext() {
		return next;
	}
	
	/**
	 * 
	 * @param next
	 */
	public void setNext(Car next) {
		this.next = next;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getLives() {
		return lives;
	}
	
	/**
	 * 
	 * @param lives
	 */
	public void setLives(int lives) {
		this.lives = lives;
	}
	
	/**
	 * 
	 * @return
	 */
	public Car getPrev() {
		return prev;
	}
	
	/**
	 * 
	 * @param prev
	 */
	public void setPrev(Car prev) {
		this.prev = prev;
	}
	
	@Override
	public String getColor() {
		// TODO Auto-generated method stub
		return super.getColor();
	}

	@Override
	public void setColor(String color) {
		// TODO Auto-generated method stub
		super.setColor(color);
	}

	@Override
	public double getWidth() {
		// TODO Auto-generated method stub
		return super.getWidth();
	}

	@Override
	public void setWidth(double width) {
		// TODO Auto-generated method stub
		super.setWidth(width);
	}

	@Override
	public double getHeight() {
		// TODO Auto-generated method stub
		return super.getHeight();
	}

	@Override
	public void setHeight(double height) {
		// TODO Auto-generated method stub
		super.setHeight(height);
	}

	public void save() {
		
	}

}
