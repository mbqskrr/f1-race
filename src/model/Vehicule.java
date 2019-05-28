package model;

/**
 * Clase padre de Car y Truck
 * @author Manuel Balanta
 *
 */

public abstract class Vehicule {
	
	protected String color;
	protected double width;
	protected double height;
	
	/**
	 * 
	 * @param color
	 * @param width
	 * @param height
	 */
	public Vehicule(String color, double width, double height) {
		this.color = color;
		this.width = width;
		this.height = height;
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
	public double getWidth() {
		return width;
	}

	/**
	 * 
	 * @param width
	 */
	public void setWidth(double width) {
		this.width = width;
	}
	
	/**
	 * 
	 * @return
	 */
	public double getHeight() {
		return height;
	}
	
	/**
	 * 
	 * @param height
	 */
	public void setHeight(double height) {
		this.height = height;
	}
	
}
