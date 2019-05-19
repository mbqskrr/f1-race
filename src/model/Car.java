package model;

public class Car{
	
	private int lives;
	private int bonus;
	private int points;

	public Car(String color, int lives, int bonus, int points) {
		this.lives = lives;
		this.bonus = bonus;
		this.points = points;
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public void jump() {
		
	}
	
	public void crash() {
		
	}

}
