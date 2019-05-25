package threads;

import ui.RaceController;

/**
 * 
 * @author Manuel Balanta
 *
 */

public class PointsThread extends Thread{
	
	//private RaceController race;
	
	/**
	 * 
	 * @param rc
	 */
	public PointsThread(RaceController rc) {
		//race = rc;
	}
	
	/**
	 * 
	 */
	public void run() {
		System.currentTimeMillis();
	}

}
