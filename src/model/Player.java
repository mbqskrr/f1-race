package model;

import java.io.Serializable;

/**
 * 
 * @author Manuel Balanta
 *
 */

public class Player extends Person implements Comparable<Player>, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int points;
	private String timePlayed;
	private Player right;
	private Player left;
	
	/**
	 * 
	 * @param nickName - nombre del jugador
	 * @param points - puntos que obtuvo el jugador en la partida
	 * @param timePlayed - tiempo que disputó la partida el jugador
	 */
	public Player(String nickName, int points, String timePlayed) {
		super(nickName);
		this.points = points;
		this.timePlayed = timePlayed;
	}


	


	/**
	 * 
	 * @return
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * 
	 * @param points
	 */
	public void setPoints(int points) {
		this.points = points;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getTimePlayed() {
		return timePlayed;
	}

	/**
	 * 
	 * @param timePlayed
	 */
	public void setTimePlayed(String timePlayed) {
		this.timePlayed = timePlayed;
	}

	/**
	 * 
	 * @return
	 */
	public Player getRight() {
		return right;
	}
	
	/**
	 * 
	 * @param right
	 */
	public void setRight(Player right) {
		this.right = right;
	}
	
	/**
	 * 
	 * @return
	 */
	public Player getLeft() {
		return left;
	}
	
	/**
	 * 
	 * @param left
	 */
	public void setLeft(Player left) {
		this.left = left;
	}

	@Override
	public int compareTo(Player player) {
		int comparation;
		if (this.name.compareToIgnoreCase(player.name) > 0) {
			comparation = 1;
		} else if(this.name.compareToIgnoreCase(player.name) < 0){
			comparation = -1;
		}else {
			comparation = 0;
		}
		return comparation;
	}

	@Override
	public String toString() {
		return "Jugador: Nickname=" + name + ", Puntos=" + points+", Tiempo jugado= "+timePlayed;
	}
	

	
}
