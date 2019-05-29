package threads;

/**
 * Esta clase permite llevar los puntos del juego
 * @author Manuel Balanta
 *
 */

public class PointsThread extends Thread{
	
	private int points;
	
	/**
	 * Consturctor de la clase
	 */
	public PointsThread() {
		
	}
	
	/**
	 * Método encargado de la ejecución
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
	
	/**
	 * Método que da los puntos 
	 * @return - puntos obtenidos en el juego
	 */
	public int getPoints() {
		return points;
	}
	
}
