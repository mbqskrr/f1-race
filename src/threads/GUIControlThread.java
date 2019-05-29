package threads;

import javafx.application.Platform;
import ui.RaceController;

/**
 * Hilo encargado de ejecutar la lcase UpdateRunnable
 * @author Manuel Balanta
 * @deprecated
 *
 */

public class GUIControlThread extends Thread{
	
	private RaceController raceC;
	
	/**
	 * Constructor 
	 * @param raceC objeto tipo RaceController
	 */
	public GUIControlThread(RaceController raceC) {
		this.raceC = raceC;
	};
	
	/**
	 * Método que ejecuta UpdateRunnable
	 */
	public void run() {
		while (true) {
			UpdateRunnable gct = new UpdateRunnable(raceC);
			Platform.runLater(gct);
			try {
				sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
