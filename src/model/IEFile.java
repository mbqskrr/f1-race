package model;

import java.io.FileNotFoundException;

/**
 * 
 * @author Manuel Balanta
 *
 */

public interface IEFile {
	
	public static final String PATH_EXPORT_PLAYER = "data/palyerReport.txt";
	public static final String PATH_TRUCK = "data/trucks.txt";
	public static final String PATH_CAR = "data/cars.txt";
	
	/**
	 * 
	 * @param path
	 * @param sep
	 */
	public void loadTrucks(String path, String sep);
	
	/**
	 * 
	 * @param path
	 * @param sep
	 */
	public void loadCars(String path, String sep);
	
	/**
	 * 
	 * @throws FileNotFoundException
	 */
	public void exportPlayersReport() throws FileNotFoundException;
	
}
