package model;

/**
 * 
 * @author W-7
 *
 */

public class Car{
	
	private static final int lives = 3; 
	private int bonus;
	private int points;
	private Car next;
	private Car prev;

	/**
	 * 
	 * @param color
	 * @param bonus
	 * @param points
	 */
	public Car(String color, int bonus, int points) {
		this.bonus = bonus;
		this.points = points;
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
	
	public void save() {
		
	}

}
