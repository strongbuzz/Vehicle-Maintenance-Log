/*
 * This class Represents a CarListNode which has data, cursor next, cursor previous
 * @author Jinwoo Lee
 */
public class CarListNode {

	public int CAPACITY;

	private Car data;
	private CarListNode next;
	private CarListNode prev;

	/**
	 * This is a constructor used to create a new car object
	 * 
	 * @param initial data of the car
	 */
	public CarListNode(Car initData) throws IllegalArgumentException {
		if (initData == null) {
			throw new IllegalArgumentException();
		}
		this.next = null;
		this.prev = null;
		this.data = initData;
	}

	/**
	 * This method get the data of the car
	 * 
	 * @return The data of a car
	 */
	public Car getData() {
		return data;
	}

	/**
	 * This method get the next cursor car data
	 * 
	 * @return The data of a next car
	 */
	public CarListNode getNext() {
		return next;
	}

	/**
	 * This method get the previous cursor car data
	 * 
	 * @return The data of a previous car
	 */
	public CarListNode getPrev() {
		return prev;
	}

	/**
	 * This method set data of a car
	 * 
	 * @param data The data to be set
	 */
	public void setData(Car data) {
		this.data = data;
	}

	/**
	 * This method set next data of a car
	 * 
	 * @param data The next data of car to be set
	 */
	public void setNext(CarListNode next) {
		this.next = next;
	}

	/**
	 * This method set previous data of a car
	 * 
	 * @param data The previous data of car to be set
	 */
	public void setPrev(CarListNode prev) {
		this.prev = prev;
	}

}
