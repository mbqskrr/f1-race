package model;

/**
 * 
 * @author Manuel Balanta
 *
 */

public class Truck  extends Vehicule{
	
	private Truck next;
	private Truck prev;
	
	/**
	 * 
	 * @param color
	 * @param width
	 * @param height
	 */
	public Truck(String color, double width, double height) {
		super(color, width, height);
	}

	/**
	 * 
	 * @return
	 */
	public Truck getNext() {
		return next;
	}

	/**
	 * 
	 * @param next
	 */
	public void setNext(Truck next) {
		this.next = next;
	}

	/**
	 * 
	 * @return
	 */
	public Truck getPrev() {
		return prev;
	}

	/**
	 * 
	 * @param prev
	 */
	public void setPrev(Truck prev) {
		this.prev = prev;
	}

	@Override
	public String getColor() {
		return super.getColor();
	}

	@Override
	public void setColor(String color) {
		super.setColor(color);
	}

	@Override
	public double getWidth() {
		return super.getWidth();
	}

	@Override
	public void setWidth(double width) {
		super.setWidth(width);
	}

	@Override
	public double getHeight() {
		return super.getHeight();
	}

	@Override
	public void setHeight(double height) {
		super.setHeight(height);
	}

	/*@Override
	public int compareTo(Truck truck) {
		int comparation;
		if (this.color.compareToIgnoreCase(truck.color) > 0) {
			comparation = 1;
		} else if(this.color.compareToIgnoreCase(truck.color) < 0){
			comparation = -1;
		}else {
			comparation = 0;
		}
		return comparation;
	}*/

	public int getSize() {
		Truck actual = this;
		int size = 0;
		while (actual!=null) {
			size++;
			actual = actual.getNext();
		}
		return size;
	}

	
}
