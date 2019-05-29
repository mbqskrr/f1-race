package model;

import java.io.Serializable;

/**
 * Clase tipo �rbol
 * @author Manuel Balanta
 *
 */

public class Player extends Person implements Comparable<Player>, Serializable{
	
	/**
	 * Constante
	 */
	private static final long serialVersionUID = 1L;
	private int points;
	private String timePlayed;
	private Player right;
	private Player left;
	
	/**
	 * M�todo constructor
	 * @param nickName nombre del jugador
	 * @param points puntos que obtuvo el jugador en la partida
	 * @param timePlayed tiempo que disput� la partida el jugador
	 */
	public Player(String nickName, int points, String timePlayed) {
		super(nickName);
		this.points = points;
		this.timePlayed = timePlayed;
	}

	/**
	 * M�todo que retorna los puntos obtenidos de un jugador
	 * @return los puntos de un jugaodr
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * M�todo que modifica los puntos de un jugaodr
	 * @param points puntos de un jugador
	 */
	public void setPoints(int points) {
		this.points = points;
	}
	
	/**
	 * M�todo que retorna el tiempo que jug� un jugaodr
	 * @return el tiempo jugado de un jugador
	 */
	public String getTimePlayed() {
		return timePlayed;
	}

	/**
	 * M�todo que modifica el tiempo jugado por un juegador
	 * @param timePlayed el tiempo que jug� el jugador
	 */
	public void setTimePlayed(String timePlayed) {
		this.timePlayed = timePlayed;
	}

	/**
	 * M�todo que retorna el elemento a la derecha del actual
	 * @return elemento a la derecha del actual
	 */
	public Player getRight() {
		return right;
	}
	
	/**
	 * M�todo que modifica el elemento a la derecha del actual
	 * @param right objeto tipo Player para modifcar el derecho del actual
	 */
	public void setRight(Player right) {
		this.right = right;
	}
	
	/**
	 * M�todo que retorna el elemento a la derecha del actual
	 * @return elemento a la izquierdada del actual
	 */
	public Player getLeft() {
		return left;
	}
	
	/**
	 * M�todo que modifica el elemento a la izquierdada del actual
	 * @param left objeto tipo Player para modifcar el izquierdo del actual
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
