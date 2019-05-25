package model;

/**
 * 
 * @author W-7
 *
 */

public class Car{
	
	private int lives; 
	private int points;
	private Car next;
	private Car prev;
	private String color;
	
	/**
	 * Método constructor de la clase Player
	 * @param color
	 * @param bonus
	 * @param points
	 */
	public Car(String color, int points, int lives) {
		this.lives = lives;
		this.points = points;
		this.color = color;
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
	public String getColor() {
		return color;
	}
	
	/**
	 * 
	 * @param color
	 */
	public void setColor(String color) {
		this.color = color;
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
	
	public void save() {
		
	}

}
