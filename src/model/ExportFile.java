package model;

import java.io.FileNotFoundException;

/**
 * Interfaz que permite la exportación de datos a un archivo de texto plano (.txt)
 * @author Manuel Balanta
 *
 */

public interface ExportFile {
	
	public static final String PATH_EXPORT_PLAYERS = "data/palyerReport.txt";
	public static final String PATH_TRUCKS = "data/trucksReport.txt";
	public static final String PATH_CARS = "data/carsReport.txt";
	
	/**
	 * Este método exporta los datos de la clase Truck a un archivo de texto
	 * @throws FileNotFoundException
	 */
	public void exportTrucksReport() throws FileNotFoundException;
	
	/**
	 * Este método exporta los datos de la clase Car a un archivo de texto
	 * @throws FileNotFoundException
	 */
	public void exportCarsReport() throws FileNotFoundException;
	
	/**
	 * Este método exporta los datos de la clase Player a un archivo de texto
	 * @throws FileNotFoundException
	 */
	public void exportPlayersReport() throws FileNotFoundException;
	
}
