package model;

import java.io.Serializable;

/**
 * Clase tipo Árbol
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
	 * Método constructor
	 * @param nickName nombre del jugador
	 * @param points puntos que obtuvo el jugador en la partida
	 * @param timePlayed tiempo que disputó la partida el jugador
	 */
	public Player(String nickName, int points, String timePlayed) {
		super(nickName);
		this.points = points;
		this.timePlayed = timePlayed;
	}

	/**
	 * Método que retorna los puntos obtenidos de un jugador
	 * @return los puntos de un jugaodr
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * Método que modifica los puntos de un jugaodr
	 * @param points puntos de un jugador
	 */
	public void setPoints(int points) {
		this.points = points;
	}
	
	/**
	 * Método que retorna el tiempo que jugó un jugaodr
	 * @return el tiempo jugado de un jugador
	 */
	public String getTimePlayed() {
		return timePlayed;
	}

	/**
	 * Método que modifica el tiempo jugado por un juegador
	 * @param timePlayed el tiempo que jugó el jugador
	 */
	public void setTimePlayed(String timePlayed) {
		this.timePlayed = timePlayed;
	}

	/**
	 * Método que retorna el elemento a la derecha del actual
	 * @return elemento a la derecha del actual
	 */
	public Player getRight() {
		return right;
	}
	
	/**
	 * Método que modifica el elemento a la derecha del actual
	 * @param right objeto tipo Player para modifcar el derecho del actual
	 */
	public void setRight(Player right) {
		this.right = right;
	}
	
	/**
	 * Método que retorna el elemento a la derecha del actual
	 * @return elemento a la izquierdada del actual
	 */
	public Player getLeft() {
		return left;
	}
	
	/**
	 * Método que modifica el elemento a la izquierdada del actual
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
