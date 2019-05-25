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
 * Clase principal del modelo del mundo
 * @author Manuel Balanta
 *
 */

public class Game implements Serializable, Serialize, ExportFile{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Player root;
	private Car first;
	
	/**
	 * 
	 */
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
		File myFile = new File(FILE);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(myFile));
		oos.writeObject(root);
		oos.close();
	}

	@Override
	public void load() throws IOException, ClassNotFoundException {
		File myFile = new File(FILE);
		if (myFile.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(myFile));
			root = (Player)ois.readObject();
			ois.close();
		}
	}

	@Override
	public void exportPlayersReport() throws FileNotFoundException {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Este método permite conocer cuántos nodos tiene el ABB
	 * @param p objeto de la clase player
	 * @return el número de nodos que tiene el ABB
	 */
	public int getWeight(Player p) {
		if (p != null) {
			int left = getWeight(p.getLeft()); 
			int right = getWeight(p.getRight());
			int medio = 1;
			return left + right + medio;
		}
		return 0;
	}

	@Override
	public void exportTrucksReport() throws FileNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exportCarsReport() throws FileNotFoundException {
		// TODO Auto-generated method stub
		
	}

}
