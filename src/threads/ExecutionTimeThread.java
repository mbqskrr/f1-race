package threads;

import ui.RaceController;

/**
 * Hilo que se encarga de llevar el tiempo de la partida y del movimiento de los carros enemigos
 * @author Manuel Balanta
 *
 */

public class ExecutionTimeThread extends Thread{
	
	private int minutes;
	private int seconds;
	private RaceController raceC;
	
	/**
	 * M�todo constructor para crear un nuevo hilo
	 * @param raceC - objeto de la clase RaceController
	 */
	public ExecutionTimeThread(RaceController raceC) {
		this.raceC = raceC;
	}
	
	/**
	 * M�todo encargado de la ejecuci�n
	 */
	public void run() {
		while (raceC.isCollisioned() == false) {
			for (minutes = 0; minutes < 60; minutes++) {
				for (seconds = 0; seconds < 60; seconds++) {
					System.out.println(minutes+":"+seconds);
					raceC.moveTruck();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
	}
	
	/**
	 * M�todo que retorna los m�nutos 
	 * @return minutos
	 */
	public int getMinutes() {
		return minutes;
	}

	/**
	 * M�tod que retorna los segundos
	 * @return segundos
	 */
	public int getSeconds() {
		return seconds;
	}

}
