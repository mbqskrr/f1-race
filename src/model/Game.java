package model;

import java.io.Serializable;

/**
 * 
 * @author W-7
 *
 */
public class Game implements Serializable{
	
	private Player root;
	private Car first;
	
	public Game() {
		
	}
	
	/**
	 * 
	 * @return
	 */
	public Player getRoot() {
		return root;
	}

	/**
	 * 
	 * @param root
	 */
	public void setRoot(Player root) {
		this.root = root;
	}

	/**
	 * 
	 * @return
	 */
	public Car getFirst() {
		return first;
	}

	/**
	 * 
	 * @param first
	 */
	public void setFirst(Car first) {
		this.first = first;
	}



	public void saveResult() {
		
	}

}
