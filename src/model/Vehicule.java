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
	 * M�odo constructor
	 * @param color color
	 * @param width ancho
	 * @param height alto
	 */
	public Vehicule(String color, double width, double height) {
		this.color = color;
		this.width = width;
		this.height = height;
	}
	
	/**
	 * M�todo que da el color
	 * @return el color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * M�todo que modifica el color
	 * @param color nuevo color a modificar
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * M�todo que da el ancho
	 * @return el ancho
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * M�todo que modifica el ancho
	 * @param width ancho
	 */
	public void setWidth(double width) {
		this.width = width;
	}
	
	/**
	 * M�todo que da la altura
	 * @return la altura 
	 */
	public double getHeight() {
		return height;
	}
	
	/**
	 * M�todo que modifica la alutra
	 * @param height altura
	 */
	public void setHeight(double height) {
		this.height = height;
	}
	
}
