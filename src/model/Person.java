package model;

import java.io.Serializable;

/**
 * Clase padre de Player
 * @author W-7
 *
 */

public abstract class Person implements Serializable{
	
	/**
	 * Constante
	 */
	private static final long serialVersionUID = 1L;
	protected String name;

	/**
	 * Método constructor
	 * @param name el nombre de la persona
	 */
	public Person(String name) {
		this.name = name;
	}

	/**
	 * Método que da el nombre de una persona
	 * @return el nombre de una persona
	 */
	public String getName() {
		return name;
	}

	/**
	 * Método para modificar el nombre de una persona
	 * @param name el nombre de la persona
	 */
	public void setName(String name) {
		this.name = name;
	}

}
