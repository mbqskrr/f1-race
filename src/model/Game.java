package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import exception.NickNameExcpetion;

/**
 * Clase principal del modelo del mundo
 * @author Manuel Balanta
 *
 */

public class Game implements Serialize, ExportFile{
	

	private Player root;
	private Car first;
	private Truck firstT;
	
	/**
	 * 
	 */
	public Game() {
		
	}
	
	/**
	 * 
	 * @return
	 */
	public Player getRoot() {
		return root;
	}

	/**
	 * 
	 * @param root
	 */
	public void setRoot(Player root) {
		this.root = root;
	}

	/**
	 * 
	 * @return
	 */
	public Car getFirst() {
		return first;
	}

	/**
	 * 
	 * @param first
	 */
	public void setFirst(Car first) {
		this.first = first;
	}

	/**
	 * 
	 * @return
	 */
	public Truck getRootT() {
		return firstT;
	}

	/**
	 * 
	 * @param rootT
	 */
	public void setRootT(Truck firstT) {
		this.firstT = firstT;
	}

	@Override
	public void save() throws IOException, FileNotFoundException{
		File myFile = new File(FILE);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(myFile));
		oos.writeObject(root);
		oos.close();
	}

	@Override
	public void load() throws IOException, ClassNotFoundException {
		File myFile = new File(FILE);
		if (myFile.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(myFile));
			root = (Player)ois.readObject();
			ois.close();
			System.out.println(root+" auuuuuu");
		}
	}

	@Override
	public void exportPlayersReport() throws FileNotFoundException {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Este método permite conocer cuántos nodos tiene el ABB
	 * @param p objeto de la clase Player
	 * @return el número de nodos que tiene el ABB
	 */
	public int getWeight(Player p) {
		if (p != null) {
			int left = getWeight(p.getLeft()); 
			int right = getWeight(p.getRight());
			int medio = 1;
			return left + right + medio;
		}
		return 0;
	}

	@Override
	public void exportTrucksReport() throws FileNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exportCarsReport() throws FileNotFoundException {
		// TODO Auto-generated method stub
		
	}
	
	private void addPlayer(Player p, Player r) {
		if (r==null) {
			this.setRoot(p);
		}else if(p.getNickName().compareTo(r.getNickName())<=0) {
			if (r.getLeft()==null) {
				r.setLeft(p);
			} else {
				addPlayer(p, r.getLeft());
			}
		}else {
			if (r.getRight()==null) {
				r.setRight(p);
			} else {
				addPlayer(p, r.getRight());
			}
		}
	}
	
	public void addPlayer(Player p) {
		addPlayer(p, this.root);
	}

	public void addTruck(Truck truck) {
		if (firstT == null) {
			firstT = truck;
			truck.setPrev(truck);
			truck.setNext(truck);
		} else {
			firstT.getPrev().setNext(truck);
			truck.setPrev(firstT.getPrev());
			truck.setNext(firstT);
			firstT.setPrev(truck);
		}
	}
	
	public void addCar(Car car) {
		if (first == null) {
			first = car;
			car.setPrev(car);
			car.setNext(car);
		} else {
			first.getPrev().setNext(car);
			car.setPrev(first.getPrev());
			car.setNext(first);
			first.setPrev(car);
		}
	}
	
	public List<Player> preOrderSort(Player p) {
		List<Player> playersSorted = new ArrayList<Player>();
		if (root!=null) {
			root.getNickName();
			root.getPoints();
			root.getTimePlayed();
			playersSorted.add(root);
			preOrderSort(root.getLeft());
			preOrderSort(root.getRight());
		}
		return playersSorted;
	}
	
	public List<Player> inOrderSort(Player p) {
		List<Player> playersSorted = new ArrayList<Player>();
		if (root!=null) {
			preOrderSort(root.getLeft());
			root.getNickName();
			root.getPoints();
			root.getTimePlayed();
			playersSorted.add(root);
			preOrderSort(root.getRight());
		}
		return playersSorted;
	}
	
	public List<Player> posOrderSort(Player p) {
		List<Player> playersSorted = new ArrayList<Player>();
		if (root!=null) {
			posOrderSort(root.getLeft());
			posOrderSort(root.getRight());
			root.getNickName();
			root.getPoints();
			root.getTimePlayed();
			playersSorted.add(root);
		}
		return playersSorted;
	}
	
	public void bubbleSort() {
		if(first != null) {
			
			boolean sorted = true;
			while(sorted) {
				Car current = first;
				sorted = false;
				while(current.getNext() != first) {
					Car next = current.getNext();
					if(current.compareTo(next)>0) {
						if(current.getPrev()!=null) {
							current.getPrev().setNext(next);
						}
						if(next.getNext()!=null) {
							next.getNext().setPrev(current);
						}
						current.setNext(next.getNext());
						next.setPrev(current.getPrev());
						current.setPrev(next);
						next.setNext(current);
						if(current==first) {
							first = next;
						}
						sorted = true;
					}else{
						current = current.getNext();
					}
				}				
			}
		}
	}
	
	public void validateNickname(String nn) throws NickNameExcpetion{
		if (nn.equals("") || nn == null || nn.equals(" ")) {
			throw new NickNameExcpetion("El nickname no es valido");
		}
	}
}
