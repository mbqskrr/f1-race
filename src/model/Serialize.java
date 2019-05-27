package model;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Interfaz con los métodos básicos para serializar
 * @author Manuel Balanta
 *
 */

public interface Serialize {
	
	public static final String FILE = "data/persistence.txt";
	
	/**
	 * Este método permite deserializar un archivo de bytes
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void load() throws IOException, ClassNotFoundException;
	
	/**
	 * Este método serializa a bytes
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public void save() throws IOException, FileNotFoundException;

}
