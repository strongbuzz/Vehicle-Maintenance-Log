/*
 * This class Represents a Car which has a make, owner
 * @author Jinwoo Lee
 */
public class Car {

	private Make make;
	private String owner;

	/**
	 * This is a constructor used to create a new student object
	 * 
	 * @param make  The car brand of a car
	 * @param owner The name of the car owner
	 */
	public Car(Make make, String owner) {
		this.make = make;
		this.owner = owner;
	}

	/**
	 * This method get the name of the car brand
	 * 
	 * @return The name of car
	 */
	public Make getMake() {
		return this.make;
	}

	/**
	 * This method get owner of the car
	 * 
	 * @return The name of the car owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * This method set the name of the car
	 * 
	 * @param name The name to be set
	 */
	public void setMake(Make make) {
		this.make = make;
	}

	/**
	 * This method set the name of owner
	 * 
	 * @param name The name to be set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * This method print the name of owner and a car
	 * 
	 */
	public String toString() {
		String result = "";
		result = result + String.format("%-10s", make) + "\t" + String.format("%6s", owner);

		return result;
	}

}
