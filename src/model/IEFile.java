package model;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 
 * @author Manuel Balanta
 *
 */

public interface IEFile {
	
	public static final String PATH_EXPORT_PLAYERS = "data/palyerReport.txt";
	public static final String PATH_TRUCKS = "data/trucks.txt";
	public static final String PATH_CARS = "data/cars.txt";
	
	/**
	 * 
	 * @param path
	 * @param sep
	 */
	public void loadTrucks(String path, String sep) throws IOException;
	
	/**
	 * 
	 * @param path
	 * @param sep
	 */
	public void loadCars(String path, String sep) throws IOException;
	
	/**
	 * 
	 * @throws FileNotFoundException
	 */
	public void exportPlayersReport() throws FileNotFoundException;
	
}
