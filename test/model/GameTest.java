package model;



//import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

import exception.NickNameExcpetion;
import exception.NotFoundException;

class GameTest {
	
	private Game game;
	
	private void setUpScenary() {
		game = new Game();
	}
	
	private void setUpSceary1() {
		game = new Game();
		Player p = new Player("C�sar", 6, "2:35");
		game.addPlayer(p);
		Player p1 = new Player("H�ctor", 8, "2:55");
		game.addPlayer(p1);
		Player p2 = new Player("Arturo", 10, "3:59");
		game.addPlayer(p2);
		System.out.println(game.getWeight(p)+"");
	}
	
	private void setUpScenary2() {
		game = new Game();
		Car c = new Car(3, "GREEN", 90, 130);
		game.addCar(c);
		Car c1 = new Car(2, "BLACK", 93, 138);
		game.addCar(c1);
		Car c2 = new Car(1, "WHITE", 92, 137);
		game.addCar(c2);
	}

	@org.junit.jupiter.api.Test
	void addPlayerTest() {
		setUpScenary();
		Player p = new Player("Camilo", 7, "1:23");
		game.addPlayer(p);
		assertTrue("No se agreg� la ra�z", game.getRoot().getName().equals(p.name));
	}
	
	@org.junit.jupiter.api.Test
	void getWeightTest() {
		setUpScenary();
		Player p = new Player("Hern�n", 8, "3:47");
		game.addPlayer(p);
		Player p1 = new Player("Jonas", 25, "10:31");
		game.addPlayer(p1);
		assertEquals(2, game.getWeight(p), "No se est�n agregando correctamente los nodos al �rbol");
	}
	
	@org.junit.jupiter.api.Test
	void addTruckTest() {
		setUpScenary();
		Truck t = new Truck("BLUE", 95, 140);
		game.addTruck(t);
		Truck t1 = new Truck("RED", 94, 139);
		game.addTruck(t1);
		assertTrue("No se agreg� correctamente el primer elemento a la lista enlazada", game.getFirstT().getColor().equals(t.getColor()));
	}
	
	@org.junit.jupiter.api.Test
	void addCarTest() {
		setUpScenary();
		Car c = new Car(3, "YELLOW", 95, 140);
		game.addCar(c);
		assertEquals(game.getFirst(), c, "No se agreg� el primero elemento a la lista");
	}

	@org.junit.jupiter.api.Test
	void preOrderTest() {
		setUpSceary1();
		assertTrue("Ra�z agregada erroneamente", game.getRoot().getName().equals("C�sar"));
		List<Player> lp = game.preOrderSort(game.getRoot());
		assertTrue("Recorrido del ABB Player en preorden incorrecto", lp.get(0).getName().equals("C�sar"));
		assertEquals(3, lp.size(), "Error al crear el arreglo de preorden");
	}
	
	@org.junit.jupiter.api.Test
	void inOrderTest() {
		setUpSceary1();
		assertTrue("Elemento izquierdo de la ra�z agregado erroneamente", game.getRoot().getLeft().getName().equals("Arturo"));
		List<Player> lp = game.inOrderSort(game.getRoot());
		assertTrue("Recorrido del ABB Player en inorden incorrecto", lp.get(0).getName().equals("Arturo"));
		assertEquals(3, lp.size(), "Error al crear el arreglo de preorden");
	}
	
	@org.junit.jupiter.api.Test
	void posOrderTest() {
		setUpSceary1();
		assertTrue("Elemento derecho de la ra�z agregado erroneamente", game.getRoot().getRight().getName().equals("H�ctor"));
		List<Player> lp = game.posOrderSort(game.getRoot());
		assertTrue("Recorrido del ABB Player en posorden incorrecto", lp.get(1).getName().equals("Hector"));
		assertEquals(3, lp.size(), "Error al crear el arreglo de preorden");
	}
	
	@org.junit.jupiter.api.Test
	void bubbleSortTest() {
		setUpScenary2();
		game.bubbleSort();
		assertEquals(3, game.getSizeC(), "Error al guardar los nodos en la lista enlazada");
		assertTrue("Error al ordenar la lista", game.getFirst().getColor().equals("BLACK"));
	}
	
	@org.junit.jupiter.api.Test
	void validateNameTest() {
		setUpScenary();
		try {
			game.validateNickname(" ");
			fail("Error al lanzar la excepci�n");
		} catch (NickNameExcpetion e) {
			e.printStackTrace();
		}
	}

	@org.junit.jupiter.api.Test
	void searchPlayerTest() {
		setUpSceary1();
		try {
			game.searchPlayer(game.getRoot().getRight());
			fail("NotFoundException esperada por lanzar");
		} catch (NotFoundException e) {
			//e.printStackTrace();
		}
	}
}
