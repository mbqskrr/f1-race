package threads;

import ui.RaceController;

public class ExecutionTimeThread extends Thread{
	
	private int minutes;
	private int seconds;
	private RaceController raceC;
	
	public ExecutionTimeThread(RaceController raceC) {
		this.raceC = raceC;
	}
	
	public void run() {
		while (raceC.clash() == false) {
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

	public int getMinutes() {
		return minutes;
	}

	public int getSeconds() {
		return seconds;
	}

}
