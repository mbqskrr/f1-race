package threads;

//import ui.RaceController;

/**
 * 
 * @author Manuel Balanta
 *
 */

public class PointsThread extends Thread{
	
	//private RaceController race;
	private int points;
	
	/**
	 * 
	 * @param rc
	 */
	public PointsThread() {
		
	}
	
	/**
	 * 
	 */
	public void run() {
		int minutes, seconds;
		for (minutes = 0; minutes < 60; minutes++) {
			for (seconds = 0; seconds < 60; seconds++) {
				if (seconds>6 && seconds%7==0) {
					points++;
					System.out.println("Puntos: "+points);
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public int getPoints() {
		return points;
	}
	
}
