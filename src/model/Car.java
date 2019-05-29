package model;

/**
 * Clase tipo Lista Enlazada
 * @author W-7
 *
 */

public class Car extends Vehicule implements Comparable<Car>{
	
	private int lives; 
	private Car next;
	private Car prev;
	
	/**
	 * Método constructor de la clase Player
	 * @param lives vidas del carro
	 * @param color color del carro 
	 * @param width ancho del carro
	 * @param height alto del carro
	 */
	public Car(int lives, String color, double width, double height) {
		super(color, width, height);
		this.lives = lives;
	}
	
	/**
	 * Método que da el siguiente elemento
	 * @return el siguiente elemento del actual
	 */
	public Car getNext() {
		return next;
	}
	
	/**
	 *Método que modifica el siguiente elemento
	 * @param next siguiente elemento del actual a modificar
	 */
	public void setNext(Car next) {
		this.next = next;
	}
	
	/**
	 * Método que retorna las vidas de un carro
	 * @return método que retorna las vidas de un carro
	 */
	public int getLives() {
		return lives;
	}
	
	/**
	 * Método que modifica las vidas de un carro
	 * @param lives vidas de un carro
	 */
	public void setLives(int lives) {
		this.lives = lives;
	}
	
	/**
	 * Método que retorna el elemento previo al actual
	 * @return elemento previo al actual
	 */
	public Car getPrev() {
		return prev;
	}
	
	/**
	 * Método que modifica el elemento previo al actual
	 * @param prev elemento para modificar el previo del actual
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
