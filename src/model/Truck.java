package model;

/**
 * Clase tipo Lista Enlazada
 * @author Manuel Balanta
 *
 */

public class Truck  extends Vehicule{
	
	private Truck next;
	private Truck prev;
	
	/**
	 * 
	 * @param color
	 * @param width
	 * @param height
	 */
	public Truck(String color, double width, double height) {
		super(color, width, height);
	}

	/**
	 * Método que retorna el elmento siguiente del actual
	 * @return elemento siguiente del actual
	 */
	public Truck getNext() {
		return next;
	}

	/**
	 * Método que modifica el siguiente elmento del acutal
	 * @param next nuevo elemento a modificar
	 */
	public void setNext(Truck next) {
		this.next = next;
	}

	/**
	 * Método que retorna el elemento previo del actual
	 * @return elemento previo del actual
	 */
	public Truck getPrev() {
		return prev;
	}

	/**
	 * Método que modifica el elemento previo del actual
	 * @param prev nuevo elemento previo al actual
	 */
	public void setPrev(Truck prev) {
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

	/*@Override
	public int compareTo(Truck truck) {
		int comparation;
		if (this.color.compareToIgnoreCase(truck.color) > 0) {
			comparation = 1;
		} else if(this.color.compareToIgnoreCase(truck.color) < 0){
			comparation = -1;
		}else {
			comparation = 0;
		}
		return comparation;
	}*/


	
}
