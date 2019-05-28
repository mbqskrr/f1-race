package model;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Interfaz con los métodos básicos para serializar
 * @author Manuel Balanta
 *
 */

public interface Serialize {
	
	/**
	 * Constate donde se almacenará los datos serializados
	 */
	public static final String FILE = "data/persistence.txt";
	
	/**
	 * Este método permite deserializar un archivo de bytes
	 * @throws IOException
	 * @throws ClassNotFoundException - No se encontró la clase que debe estar serializada
	 */
	public void load() throws IOException, ClassNotFoundException;
	
	/**
	 * Este método serializa a bytes
	 * @throws IOException
	 * @throws FileNotFoundException - No se encontró la ruta donde se debe guardar los datos serializados
	 */
	public void save() throws IOException, FileNotFoundException;

}
