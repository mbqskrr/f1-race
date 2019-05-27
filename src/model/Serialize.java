package model;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Interfaz con los m�todos b�sicos para serializar
 * @author Manuel Balanta
 *
 */

public interface Serialize {
	
	public static final String FILE = "data/persistence.txt";
	
	/**
	 * Este m�todo permite deserializar un archivo de bytes
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void load() throws IOException, ClassNotFoundException;
	
	/**
	 * Este m�todo serializa a bytes
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public void save() throws IOException, FileNotFoundException;

}
