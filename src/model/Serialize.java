package model;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Interfaz con los m�todos b�sicos para serializar
 * @author Manuel Balanta
 *
 */

public interface Serialize {
	
	/**
	 * Constate donde se almacenar� los datos serializados
	 */
	public static final String FILE = "data/persistence.txt";
	
	/**
	 * Este m�todo permite deserializar un archivo de bytes
	 * @throws IOException
	 * @throws ClassNotFoundException - No se encontr� la clase que debe estar serializada
	 */
	public void load() throws IOException, ClassNotFoundException;
	
	/**
	 * Este m�todo serializa a bytes
	 * @throws IOException
	 * @throws FileNotFoundException - No se encontr� la ruta donde se debe guardar los datos serializados
	 */
	public void save() throws IOException, FileNotFoundException;

}
