package model;

/**
 * 
 * @author W-7
 *
 */

public class Car extends Vehicule implements Comparable<Car>{
	
	private int lives; 
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
	public Car(int lives, String color, double width, double height) {
		super(color, width, height);
		this.lives = lives;
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
		return super.getColor();
	}

	@Override
	public void setColor(String color) {
		super.setColor(color);
	}

	@Override
	public double getWidth() {
		return super.getWidth();
	}

	@Override
	public void setWidth(double width) {
		super.setWidth(width);
	}

	@Override
	public double getHeight() {
		return super.getHeight();
	}

	@Override
	public void setHeight(double height) {
		super.setHeight(height);
	}

	@Override
	public int compareTo(Car car) {
		int comparation;
		if (this.color.compareToIgnoreCase(car.color) > 0) {
			comparation = 1;
		} else if(this.color.compareToIgnoreCase(car.color) < 0){
			comparation = -1;
		}else {
			comparation = 0;
		}
		return comparation;
	}

}
