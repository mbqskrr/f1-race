package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import exception.NickNameExcpetion;
import exception.NotFoundException;

/**
 * Clase principal del modelo del mundo
 * @author Manuel Balanta
 *
 */

public class Game implements Serialize, IEFile{
	

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
	 * @return - raíz 
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
	public Truck getFirstT() {
		return firstT;
	}

	/**
	 * 
	 * @param rootT
	 */
	public void setFirstT(Truck firstT) {
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
			System.out.println(root);
		}
	}

	@Override
	public void exportReport() throws FileNotFoundException {
		String msg = "";
		while (firstT != null) {
			Truck current = firstT;
			msg+=current.getColor()+"\t"+current.getWidth()+"\t"+current.getHeight();
			firstT = firstT.getNext();
		}
		PrintWriter pw = new PrintWriter(new File(PATH_EXPORT));
		pw.print(msg);
		pw.close();
	}
	
	@Override
	public void importReport(String path, String sep) throws IOException {
		File f = new File(PATH);
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		while (line!=null) {
			String[] parts = line.split(sep);
			int lives = Integer.parseInt(parts[0]);
			String color = parts[1];
			double width = Double.parseDouble(parts[2]);
			double height = Double.parseDouble(parts[3]);
			Car c = new Car(lives, color, width, height);
			addCar(c);
			line = br.readLine();
		}
		br.close();
		fr.close();
	}

	/**
	 * Este método permite conocer cuántos nodos tiene el ABB
	 * @param p - objeto de la clase Player
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
	
	/**
	 * Método privado para agregar un jugador
	 * @param p - un jugador cualquiera
	 * @param r - la raíz de la clase Player
	 */
	private void addPlayer(Player p, Player r) {
		if (r==null) {
			this.setRoot(p);
		}else if(p.getName().compareTo(r.getName())<=0) {
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
	
	/**
	 * Método público para agregar un jugador
	 * @param p - el jugador a agregar
	 */
	public void addPlayer(Player p) {
		addPlayer(p, this.root);
	}

	/**
	 * Métod para agregar un carro enemigo
	 * @param truck
	 */
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
	
	/**
	 * Método para agregar un carro 
	 * @param car
	 */
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
	
	/**
	 * Método para ordenar en preorden los objetos de la clase Player
	 * @param p - un objeto de tipo Player
	 * @return - una lista con los jugadores ordenados
	 */
	public List<Player> preOrderSort(Player p) {
		List<Player> playersSorted = new ArrayList<Player>();
		if (root!=null) {
			root.getName();
			root.getPoints();
			root.getTimePlayed();
			playersSorted.add(root);
			preOrderSort(root.getLeft());
			preOrderSort(root.getRight());
		}
		return playersSorted;
	}
	
	/**
	 * Método para ordenar en inorden los objetos de la clase Player
	 * @param p - un objeto de tipo Player
	 * @return - una lista con los jugaodres ordenados
	 */
	public List<Player> inOrderSort(Player p) {
		List<Player> playersSorted = new ArrayList<Player>();
		if (root!=null) {
			preOrderSort(root.getLeft());
			root.getName();
			root.getPoints();
			root.getTimePlayed();
			playersSorted.add(root);
			preOrderSort(root.getRight());
		}
		return playersSorted;
	}
	
	/**
	 * Método para ordenar en posorden los objetos de la clase Player
	 * @param p - un objeto de tipo Player
	 * @return - una lista con los jugadores ordenados
	 */
	public List<Player> posOrderSort(Player p) {
		List<Player> playersSorted = new ArrayList<Player>();
		if (root!=null) {
			posOrderSort(root.getLeft());
			posOrderSort(root.getRight());
			root.getName();
			root.getPoints();
			root.getTimePlayed();
			playersSorted.add(root);
		}
		return playersSorted;
	}
	
	/**
	 * Método para ordenar con burbuja los objetos de tipo Car
	 * <b>pos</b> Se ha ordenado la list enlazada de tipo Car
	 */
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
	
	/**
	 * Método para validar el nickname de un jugador
	 * @param nn - el nickname del jugador
	 * @throws NickNameExcpetion - el nickname no es válido
	 */
	public void validateNickname(String nn) throws NickNameExcpetion{
		if (nn.equals("") || nn == null || nn.equals(" ")) {
			throw new NickNameExcpetion("El nickname no es válido");
		}
	}
	
	/**
	 * Método privado que permite buscar un jugador.
	 * <b>pre:</b> Se debe ordenar el ABB de jugadores por preorden.<br>
	 * @param p - el jugador a buscar
	 * @return el jugador a buscar, ó null en caso de que el jugador buscado no exista
	 */
	private Player binarySearch(Player p) {
		Player player = null;
		
		List<Player> lp = inOrderSort(p);
		boolean find = true;
		int begining = 0;
		int last = lp.size()-1;
		while (begining<=last && !find) {
			int mid = (begining+last)/2;
			if (lp.get(mid).compareTo(p)==0) {
				find = true;
			} else if(lp.get(mid).compareTo(p)>0){
				last = mid-1;
			}else {
				begining = mid + 1;
			}
		}
		return player;
	}
	
	/**
	 * Método público para buscar un jugador
	 * @param p - objeto tipo player a buscar 
	 * @throws NotFoundException - Si el jugador buscado no existe
	 */
	public void searchPlayer(Player p) throws NotFoundException{
		if (binarySearch(p) == null) {
			throw new NotFoundException("Jugador no encontrado");
		}
	}
	
	//public void 
}
