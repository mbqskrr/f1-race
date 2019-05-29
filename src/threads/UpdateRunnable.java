package threads;

import ui.RaceController;

/**
 * Clase encargada de llevar el tiempo de ejecición del programa
 * @author Manuel Balanta
 * @deprecated
 *
 */

public class UpdateRunnable implements Runnable{
	
	private RaceController raceC;
	
	/**
	 * Constructor
	 * @param raceC objeto tipo RaceController
	 */
	public UpdateRunnable(RaceController raceC) {
		this.raceC = raceC;
	}

	@Override
	public void run() {
		int minutes, seconds;
		for (minutes = 0; minutes < 60; minutes++) {
			for (seconds = 0; seconds < 60; seconds++) {
				System.out.println(minutes+":"+seconds);
				raceC.getLblTimePlayed().setText(minutes+":"+seconds);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
