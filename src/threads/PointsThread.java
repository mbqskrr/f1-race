package threads;

import ui.RaceController;

/**
 * 
 * @author Manuel Balanta
 *
 */

public class PointsThread extends Thread{
	
	private RaceController race;
	
	/**
	 * 
	 * @param rc
	 */
	public PointsThread(RaceController rc) {
		race = rc;
	}
	
	/**
	 * 
	 */
	public void run() {
		//while (true) {
			race.generateMidTruck();
			/*int sleepTime1 = (int) Math.random()*(10000-2500+1)+2500;
			try {
				sleep(sleepTime1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			race.generateRightTruck();
			//int sleepTime2 = (int) Math.random()*(1000-2500+1)+2500;
			/*try {
				sleep(sleepTime2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			race.generateLeftTruck();
		//}
		
	}

}
