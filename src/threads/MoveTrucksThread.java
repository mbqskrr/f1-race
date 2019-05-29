package threads;

import ui.RaceController;

/**
 * Hilo encargado de mover los carros enemigos en la GUI
 * @author Manuel Balanta
 * @deprecated
 *
 */

public class MoveTrucksThread extends Thread{
	
	private RaceController raceC;
	
	/**
	 * Constructor
	 * @param raceC objeto tipo RaceController
	 */
	public MoveTrucksThread(RaceController raceC) {
		this.raceC = raceC;
	}
	
	/**
	 * Método que inicializa el hilo
	 */
	public void run() {
		while (raceC.isCollisioned() == false) {
			raceC.moveTruck();
		}
	}

}
