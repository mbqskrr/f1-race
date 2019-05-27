package threads;

import ui.RaceController;

public class MoveTrucksThread extends Thread{
	
	private RaceController raceC;
	
	public MoveTrucksThread(RaceController raceC) {
		this.raceC = raceC;
	}
	
	public void run() {
		while (raceC.isCollisioned() == false) {
			raceC.moveTruck();
		}
	}

}
