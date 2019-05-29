package model;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {
	
	private Game game;
	
	private void setUpScenary() {
		game = new Game();
	}
	
	private void setUpSceary1() {
		game = new Game();
		Player p = new Player("César", 6, "2:35");
		game.addPlayer(p);
		Player p1 = new Player("Héctor", 8, "2:55");
		game.addPlayer(p1);
		Player p2 = new Player("Arturo", 10, "3:59");
		game.addPlayer(p2);
	}
	
	private void setUpScenary2() {
		game = new Game();
		Truck t = new Truck("GREEN", 90, 130);
		game.addTruck(t);
		Truck t1 = new Truck("BLACK", 93, 138);
		game.addTruck(t1);
		Truck t2 = new Truck("WHITE", 92, 137);
		game.addTruck(t2);
	}

	@org.junit.jupiter.api.Test
	void addPlayerTest() {
		setUpScenary();
		Player p = new Player("Camilo", 7, "1:23");
		game.addPlayer(p);
		assertTrue("No se agregó la raíz", game.getRoot().getName().equals(p.name));
	}
	
	@org.junit.jupiter.api.Test
	void getWeightTest() {
		setUpScenary();
		Player p = new Player("Hernán", 8, "3:47");
		game.addPlayer(p);
		Player p1 = new Player("Jonas", 25, "10:31");
		game.addPlayer(p1);
		assertEquals(2, game.getWeight(p), "No se están agregando correctamente los nodos al árbol");
	}
	
	@org.junit.jupiter.api.Test
	void addTruckTest() {
		setUpScenary();
		Truck t = new Truck("BLUE", 95, 140);
		game.addTruck(t);
		Truck t1 = new Truck("RED", 94, 139);
		game.addTruck(t1);
		assertTrue("No se agregó correctamente el primer elemento a la lista enlazada", game.getFirstT().getColor().equals(t.getColor()));
	}
	
	@org.junit.jupiter.api.Test
	void getSizeTest() {
		setUpScenary2();
		assertEquals(3, game.getFirstT().getSize(), "No se está agregando correctamente el siguiente elemento");
	}
	
	@org.junit.jupiter.api.Test
	void addCarTest() {
		
	}

	@org.junit.jupiter.api.Test
	void preOrderTest() {
		setUpSceary1();
	}
	
	@org.junit.jupiter.api.Test
	void inOrderTest() {
		setUpSceary1();
	}
	
	@org.junit.jupiter.api.Test
	void posOrderTest() {
		setUpSceary1();
	}
	
	@org.junit.jupiter.api.Test
	void bubbleSortTest() {
		
	}
	
}
