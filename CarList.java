/*
 * This class Represents a CarList which has a head, tail, cursor, and the number of car
 * @author Jinwoo Lee
 */
public class CarList {

	private CarListNode head;
	private CarListNode tail;
	private CarListNode cursor;
	private int numCar;

	/**
	 * This is a Constructor used to create a new CarList object
	 */
	public CarList() {
		this.head = null;
		this.tail = null;
		this.cursor = null;

	}

	/**
	 * This method gets the number of cars
	 * 
	 * @return The number of cars
	 */
	public int numCars() {
		return numCar;
	}

	/**
	 * This method get the head of the carlist
	 * 
	 * @return The head of the carlist
	 */
	public CarListNode getHead() {
		return head;
	}

	/**
	 * This method get the tail of the carlist
	 * 
	 * @return The tail of the carlist
	 */
	public CarListNode getTail() {
		return tail;
	}

	/**
	 * This method get the cursor of the carlist
	 * 
	 * @return The cusor of the carlist
	 */
	public CarListNode getCursor() {
		return cursor;
	}

	/**
	 * This method get the data of the cursor of car
	 * 
	 * @return The data of the cursor car
	 */
	public Car getCursorCar() {
		return this.cursor.getData();
	}

	/**
	 * This method set the head of the carlist
	 * 
	 * @param head The head to be set
	 */
	public void setHead(CarListNode head) {
		this.head = head;
	}

	/**
	 * This method set the tail of the carlist
	 * 
	 * @param tail The tail to be set
	 */
	public void setTail(CarListNode tail) {
		this.tail = tail;
	}

	/**
	 * This method set the cussor of the carlist
	 * 
	 * @param cursor The cursor to be set
	 */
	public void setCursor(CarListNode cursor) {
		this.cursor = cursor;
	}

	/**
	 * This method reset the cursor to head
	 * 
	 * @param head The set cursor to be head
	 */
	public void resetCursorToHead() {
		this.cursor = head;
	}

	/**
	 * This method reset the cursor to tail
	 * 
	 * @param head The set cursor to be tail
	 */
	public void resetCursorToTail() {
		this.cursor = tail;
	}

	/**
	 * This method move cursor to forward
	 * 
	 * @throws EndOfListException When cursor is at the tail of the list.
	 */
	public void cursorForward() throws EndOfListException {

		try {
			if (this.cursor.getNext() == null)
				throw new EndOfListException();

			this.cursor = this.cursor.getNext();
		} catch (EndOfListException e) {
			System.out.println("cannot move cursor forward");
		}

	}

	/**
	 * This method move cursor to backward
	 * 
	 * @throws EndOfListException When cursor is at the head of the list.
	 */
	public void cursorBackward() throws EndOfListException {
		if (this.cursor.getPrev() == null) {
			throw new EndOfListException();
		}

		this.cursor = this.cursor.getPrev();
	}

	/*
	 * This method insert car before the cursor
	 * 
	 * @throws EndOfListException When if the new object is null.
	 */
	public void insertBeforeCursor(Car newCar) throws IllegalArgumentException {
		CarListNode newNode = new CarListNode(newCar);

		if (newCar == null) {
			throw new IllegalArgumentException();
		} else {
			if (this.cursor == null) {
				this.head = newNode;
				this.tail = newNode;
				this.cursor = newNode;
			} else if (this.cursor == head) {

				newNode.setNext(this.cursor);
				head.setPrev(newNode);
				head = newNode;

			} else {
				newNode.setNext(this.cursor);
				newNode.setPrev(this.cursor.getPrev());
				newNode.getPrev().setNext(newNode);
				newNode.getNext().setPrev(newNode);

			}
			numCar++;
		}
	}

	/*
	 * This method add a car to the end
	 * 
	 * @throws IllegalArgumentException When if the new object is null.
	 */
	public void appendToTail(Car newCar) throws IllegalArgumentException {
		CarListNode newNode = new CarListNode(newCar);

		if (newCar == null) {
			throw new IllegalArgumentException();
		} else {
			if (this.tail == null) {
				this.head = newNode;
				this.tail = newNode;
				this.cursor = newNode;
			} else {
				tail.setNext(newNode);
				newNode.setPrev(this.tail);
				this.tail = newNode;
			}
		}

		numCar++;

	}

	/*
	 * This method remove a car at cursor
	 * 
	 * @throws EndOfListException When if the cursor is null
	 * 
	 * @return The car
	 */
	public Car removeCursor() throws EndOfListException {
		Car car = null;
		if (this.cursor == null) {
			throw new EndOfListException();
		} else {
			car = cursor.getData();

			if (this.cursor == head) {

				if (cursor.getNext() != null) {
					this.cursor = cursor.getNext();
					this.head = head.getNext();
					cursor.setPrev(null);

				} else {
					tail = null;
					head = null;
				}
			}

			if ((this.cursor.getNext() == null) && (this.cursor.getPrev() != null)) {
				this.cursor = tail.getPrev();
				tail.getPrev().setNext(null);
			}

			if ((this.cursor.getNext() != null) && (this.cursor.getPrev() != null)) {
				this.cursor.getPrev().setNext(cursor.getNext());
				this.cursor.getNext().setPrev(cursor.getPrev());
				this.cursor = this.cursor.getPrev();
			}

			numCar--;
			return car;

		}
	}

	/**
	 * This method print the cursor shape with a car data
	 * 
	 */
	public String toString() {

		CarListNode current = head;

		while (current != null) {
			String temp = "";
			if (current == cursor) {
				temp = "=>";
			}
			System.out.println(temp + current.getData());

			current = current.getNext();
		}
		return null;

	}
}
