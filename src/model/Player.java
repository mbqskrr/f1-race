package model;

/**
 * 
 * @author Manuel Balanta
 *
 */

public class Player implements Comparable<Player>{
	
	private String nickName;
	private int points;
	private Player right;
	private Player left;
	private int weight;
	
	/**
	 * 
	 * @param nickName
	 * @param points
	 */
	public Player(String nickName, int points) {
		this.nickName = nickName;
		this.points = points;
	}

	/**
	 * 
	 * @return
	 */
	public String getNickName() {
		return nickName;
	}
	
	/**
	 * 
	 * @param nickName
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
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
		if (this.nickName.compareToIgnoreCase(player.nickName) > 0) {
			comparation = 1;
		} else if(this.nickName.compareToIgnoreCase(player.nickName) < 0){
			comparation = -1;
		}else {
			comparation = 0;
		}
		return comparation;
	}

	@Override
	public String toString() {
		return "Player [nickName=" + nickName + ", points=" + points + "]";
	}
	
}
