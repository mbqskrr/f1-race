package model;

public class Truck  {
	
	private Truck next;
	private Truck prev;

	public Truck() {
		
	}

	public Truck getNext() {
		return next;
	}

	public void setNext(Truck next) {
		this.next = next;
	}

	public Truck getPrev() {
		return prev;
	}

	public void setPrev(Truck prev) {
		this.prev = prev;
	}
	
}
