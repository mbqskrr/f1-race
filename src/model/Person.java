package model;

/**
 * 
 * @author W-7
 *
 */

public abstract class Person {
	
	protected String name;

	/**
	 * 
	 * @param name
	 */
	public Person(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

}
