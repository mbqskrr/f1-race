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
 */

public class Game implements Serialize, IEFile{
	

	private Player root;
	private Car first;
	private Truck firstT;
	private int sizeT;
	private int sizeC;
	
	/**
	 * Constructor clase Game
	 */
	public Game() {
		
	}
	
	/**
	 * Método que retorna la raíz de la clase Player
	 * @return la raíz de la clase Player
	 */
	public Player getRoot() {
		return root;
	}

	/**
	 * Método que modifica la raíz de la clase Player
	 * @param root objeto de tipo Player para modificar la raíz
	 */
	public void setRoot(Player root) {
		this.root = root;
	}

	/**
	 * Método que da el primero elmento de la lista enlazada de carros
	 * @return el primer elemento de tipo Car
	 */
	public Car getFirst() {
		return first;
	}

	/**
	 * Método que modifica el primer elemento de tipo car
	 * @param first objeto tipo Car para modifcar el primer elemento de la Lista Enlazada
	 */
	public void setFirst(Car first) {
		this.first = first;
	}

	/**
	 * Método que retorna el primer elemento de la lista enlazada tipo Truck
	 * @return el primer elemento tipo Truck
	 */
	public Truck getFirstT() {
		return firstT;
	}

	/**
	 * Método que retorna el tamaño de la lista enlazada tipo Truck
	 * @return el tamaño de la lista enlazada de Truck
	 */
	public int getSizeT() {
		return sizeT;
	}

	/**
	 * Método que retorna el tamaño de la lista enlazada tipo Car
	 * @return el tamaño de la lista enlazada de Car
	 */
	public int getSizeC() {
		return sizeC;
	}

	/**
	 * Método que modifica el primer elemento tipo Truck
	 * @param firstT objeto tipo Truck a modificar
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
	
	/**
	 * Método privado para agregar un jugador
	 * @param p un jugador cualquiera
	 * @param r la raíz de la clase Player
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
	 * @param p el jugador a agregar
	 */
	public void addPlayer(Player p) {
		addPlayer(p, this.root);
	}

	/**
	 * Método para agregar un carro enemigo
	 * @param truck el nuevo objeto tipo Truck a agregar
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
		sizeT++;
	}
	
	/**
	 * Método para agregar un carro 
	 * @param car el nuevo objeto tipo Car para añadir
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
		sizeC++;
	}
	
	/**
	 * Método para ordenar en preorden los objetos de la clase Player
	 * @param p un objeto de tipo Player
	 * @return una lista con los jugadores ordenados
	 */
	public List<Player> preOrderSort(Player p) {
		List<Player> playersSorted = new ArrayList<Player>();
		if (p!=null) {
			playersSorted.add(p);
			preOrderSort(p.getLeft());
			preOrderSort(p.getRight());
		}
		return playersSorted;
	}
	
	/**
	 * Método para ordenar en inorden los objetos de la clase Player
	 * @param p un objeto de tipo Player
	 * @return una lista con los jugaodres ordenados
	 */
	public List<Player> inOrderSort(Player p) {
		List<Player> playersSorted = new ArrayList<Player>();
		if (p!=null) {
			inOrderSort(p.getLeft());
			playersSorted.add(p);
			inOrderSort(p.getRight());
		}
		return playersSorted;
	}
	
	/**
	 * Método para ordenar en posorden los objetos de la clase Player
	 * @param p un objeto de tipo Player
	 * @return una lista con los jugadores ordenados
	 */
	public List<Player> posOrderSort(Player p) {
		List<Player> playersSorted = new ArrayList<Player>();
		if (p!=null) {
			posOrderSort(p.getLeft());
			posOrderSort(p.getRight());
			playersSorted.add(p);
		}
		return playersSorted;
	}
	
	/**
	 * Método para ordenar con burbuja los objetos de tipo Car
	 * <b>pos</b> Se ha ordenado la list enlazada de tipo Car lexicográficamente según el color
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
	 * @param nn  el nickname del jugador
	 * @throws NickNameExcpetion  el nickname no es válido
	 */
	public void validateNickname(String nn) throws NickNameExcpetion{
		if (nn.equals("") || nn == null || nn.equals(" ")) {
			throw new NickNameExcpetion("El nickname no es válido");
		}
	}
	
	/**
	 * Método privado que permite buscar un jugador, mediante busqueda binaria.
	 * <b>pre:</b> Se debe ordenar el ABB de jugadores por inorden.<br>
	 * @param p el jugador a buscar
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
	 * @param p objeto tipo player a buscar 
	 * @throws NotFoundException Si el jugador buscado no existe
	 */
	public void searchPlayer(Player p) throws NotFoundException{
		if (binarySearch(p) == null) {
			throw new NotFoundException("Jugador no encontrado");
		}
	}
	 
}
