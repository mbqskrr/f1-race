package model;

/**
 * 
 * @author W-7
 *
 */

public class Car{
	
	private int lives;
	private int bonus;
	private int points;
	private Car next;
	private Car prev;

	/**
	 * 
	 * @param color
	 * @param lives
	 * @param bonus
	 * @param points
	 */
	public Car(String color, int lives, int bonus, int points) {
		this.lives = lives;
		this.bonus = bonus;
		this.points = points;
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
	public int getBonus() {
		return bonus;
	}

	/**
	 * 
	 * @param bonus
	 */
	public void setBonus(int bonus) {
		this.bonus = bonus;
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

}
