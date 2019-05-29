package model;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Interfaz que permite la exportaci�n de datos a un archivo de texto plano (.txt)
 * @author Manuel Balanta
 *
 */

public interface IEFile {
	
	/**
	 * Constante para exportar el archivo
	 */
	public static final String PATH_EXPORT = "data/report.txt";
	
	/**
	 * Constante para importar un archivo
	 */
	public static final String PATH = "data/cars.txt";
	
	/**
	 * Este m�todo exporta datos de una clase a un archivo de texto
	 * @throws FileNotFoundException - No se encontr� la ruta para exportar el archivo
	 */
	public void exportReport() throws FileNotFoundException;
	
	/**
	 * Este m�todo permite importar los datos de un archivo de texto
	 * @param <T>
	 * @param path la ruta del arcivho
	 * @param sep el separador para leer el archivo
	 * @throws IOException IOException
	 */
	public void importReport(String path, String sep) throws IOException;
	
}
