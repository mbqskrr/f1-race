package model;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 
 * @author Manuel Balanta
 *
 */

public interface Serialize {
	
	public static final String FILE = "data/persistence.txt";
	
	/**
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void load() throws IOException, ClassNotFoundException;
	
	/**
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public void save() throws IOException, FileNotFoundException;

}
