package threads;


public class ExecutionTimeThread {
	
	private int minutes;
	private int seconds;

	
	public ExecutionTimeThread() {
	
	}
	
	public void run() {
		for (minutes = 0; minutes < 60; minutes++) {
			for (seconds = 0; seconds < 60; seconds++) {
				System.out.println(minutes+":"+seconds);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
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
