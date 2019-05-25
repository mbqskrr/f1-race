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
		// TODO Auto-generated method stub
		return super.getColor();
	}

	@Override
	public void setColor(String color) {
		// TODO Auto-generated method stub
		super.setColor(color);
	}

	@Override
	public double getWidth() {
		// TODO Auto-generated method stub
		return super.getWidth();
	}

	@Override
	public void setWidth(double width) {
		// TODO Auto-generated method stub
		super.setWidth(width);
	}

	@Override
	public double getHeight() {
		// TODO Auto-generated method stub
		return super.getHeight();
	}

	@Override
	public void setHeight(double height) {
		// TODO Auto-generated method stub
		super.setHeight(height);
	}

}
