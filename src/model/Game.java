package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 
 * @author W-7
 *
 */

public class Game implements Serializable, Serialize{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Player root;
	private Car first;
	private String f = file;
	
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
	
	@Override
	public void save() throws IOException, FileNotFoundException{
		File myFile = new File(f);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(myFile));
		oos.writeObject(root);
		oos.close();
	}

	@Override
	public void load() throws IOException, ClassNotFoundException {
		File myFile = new File(f);
		if (myFile.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(myFile));
			root = (Player)ois.readObject();
			ois.close();
		}
	}

}
