import java.util.Scanner;

/**
 * This class represents a OilChangeManager which has two instance Joe, donny
 * and FinishedList, currentList, temp, tempTwo, mergeList
 * 
 * @author Jin Lee
 *
 */
public class OilChangeManager {

	static Make make;

	private static CarList Joe;
	private static CarList Donny;
	private static CarList FinishedList;
	private static CarList currentList;
	private static CarList temp;
	private static CarList tempTwo;
	private static CarList mergeList;

	/**
	 * This method runs the program
	 * 
	 * @throws EndOfListException   When the cursor is at the tail or head of the
	 *                              list.
	 * @throws NullPointerException When the input points null
	 */
	public static void main(String[] args) throws EndOfListException, NullPointerException {
		// TODO Auto-generated method stub

		Joe = new CarList();
		Donny = new CarList();
		FinishedList = new CarList();
		currentList = new CarList();
		mergeList = new CarList();
		temp = new CarList();
		tempTwo = new CarList();

		CarListNode finishNode = null;
		System.out.println(menu());
		boolean invalidInput = false;

		boolean test = true;
		Car cutCar = null;

		while (test) {

			Scanner scan = new Scanner(System.in);
			String input = scan.nextLine();

			try {

				if (!input.equalsIgnoreCase("l") && !input.equalsIgnoreCase("m") && !input.equalsIgnoreCase("p")
						&& !input.equalsIgnoreCase("f") && !input.equalsIgnoreCase("s")
						&& !input.equalsIgnoreCase("q")) {
					throw new IllegalArgumentException();
				}
			}

			catch (IllegalArgumentException e) {
				System.out.println("Invalid input! Enter L,M,P,F,S,Q\n");

			}

			/**
			 * This method List Operations - select Joe (J) or Donny (D)
			 */
			if (input.equalsIgnoreCase("l")) {
				System.out.println("Please select a list - Joe (J) or Donny (D):");

				boolean invalidInp = false;
				String name = scan.nextLine();

				if (name.equalsIgnoreCase("j")) {
					currentList = Joe;
					System.out.println(Option());

				} else if (name.equalsIgnoreCase("d")) {
					currentList = Donny;
					System.out.println(Option());

				} else {
					invalidInp = true;
					System.out.println("\nInvalid input! Enter L,M,P,F,S,Q ");
				}

				if (!invalidInp) {
					String inputOption = scan.nextLine();

					/**
					 * This method add a car to the end
					 */
					if (inputOption.equalsIgnoreCase("a")) {

						System.out.println(
								"Please enter vehicle make (Ford, GMC, Chevy, Jeep, Dodge, Chrysler.\nand Lincoln):");
						String carMake = scan.nextLine();
						if (carMake.equalsIgnoreCase("FORD") || carMake.equalsIgnoreCase("GMC")
								|| carMake.equalsIgnoreCase("CHEVY") || carMake.equalsIgnoreCase("JEEP")
								|| carMake.equalsIgnoreCase("DODGE") || carMake.equalsIgnoreCase("CHRYSLER")
								|| carMake.equalsIgnoreCase("LINCOLN")) {

							make = Make.valueOf(carMake.toUpperCase());

							System.out.println("Please enter owner's name");
							String ownerName = scan.nextLine();
							Car currentList = new Car(make, ownerName);

							if (name.equalsIgnoreCase("j")) {
								joeEnumTestAddEnd(currentList);
								System.out.println("\n" + ownerName + "'s " + carMake
										+ " has been scheduled for an oil change with Joe and has \nbeen added to his list \n"
										+ "\nPlease select an option:");
							}
							if (name.equalsIgnoreCase("d")) {
								donnyEnumTestAddEnd(currentList);
								System.out.println("\n" + ownerName + "'s " + carMake
										+ " has been scheduled for an oil change with Donny and has \nbeen added to his list \n"
										+ "\nPlease select an option:");

							}

						} else {
							System.out.println("We don't service " + carMake + "!\n");
							System.out.println("Please select an option:");

						}
					}

					/**
					 * This method Insert car before cursor
					 */
					if (inputOption.equalsIgnoreCase("i")) {
						System.out.println(
								"Please enter vehicle make (Ford, GMC, Chevy, Jeep, Dodge, Chrysler.\nand Lincoln):");
						String carMake = scan.nextLine();

						try {
							make = Make.valueOf(carMake.toUpperCase());
							System.out.println("Please enter owner's name");
							String ownerName = scan.nextLine();
							Car currentList = new Car(make, ownerName);

							if (name.equalsIgnoreCase("j")) {
								joeEnumTestBeforeCar(currentList);
								System.out.println("\n" + ownerName + "'s " + carMake
										+ " has been scheduled for an oil change with Joe\nand has been added to his list before the cursor. \n");

							}
							if (name.equalsIgnoreCase("d")) {
								donnyEnumTestBeforeCar(currentList);
								System.out.println("\n" + ownerName + "'s " + carMake
										+ " has been scheduled for an oil change with Donny\nand has been added to his list before the cursor. \n");

							}

						}

						catch (IllegalArgumentException e) {
							System.out.println("We don't service " + carMake + "!\n");
						}

						System.out.println("Please select an option:");
					}

					/**
					 * This method remove car at cursor
					 */
					if (inputOption.equalsIgnoreCase("r")) {

						if (name.equalsIgnoreCase("j")) {
							CarListNode joeHead = Joe.getHead();
							if (joeHead == null) {
								System.out.println("Nothing to remove in the list");
							} else {
								Joe.removeCursor();
								System.out.println("Cursor removed in Joe's List.\n");
								System.out.println("Please select an option:");

							}

						}

						if (name.equalsIgnoreCase("d")) {
							CarListNode donnyHead = Donny.getHead();
							if (donnyHead == null) {
								System.out.println("Nothing to remove in the list");
							} else {
								Donny.removeCursor();
								System.out.println("Cursor removed in Donny's List.\n");
								System.out.println("Please select an option:");

							}

						}

					}

					/**
					 * This method cut car at cursor
					 */
					if (inputOption.equalsIgnoreCase("x")) {

						if (name.equalsIgnoreCase("j")) {

							currentList = Joe;

							cutCar = currentList.getCursorCar();
							Joe.removeCursor();
							System.out.println("Cursor cut in Joe's List.\n");
						}
						if (name.equalsIgnoreCase("d")) {
							currentList = Donny;
							cutCar = currentList.getCursorCar();
							Donny.removeCursor();
							System.out.println("Cursor cut in Donny's List.\n");
						}
						System.out.println("Please select an option:");

					}

					/**
					 * This method paste car before cursor
					 */
					if (inputOption.equalsIgnoreCase("v")) {

						if (name.equalsIgnoreCase("j")) {
							if (cutCar != null) {
								Donny.insertBeforeCursor(cutCar);
								cutCar = null;
								System.out.println("Cursor pasted in Joe's List.\n");
							} else {
								System.out.println("Nothing to paste\n");
							}

						}

						if (name.equalsIgnoreCase("d")) {
							if (cutCar != null) {
								Donny.insertBeforeCursor(cutCar);
								cutCar = null;
								System.out.println("Cursor pasted in Donny's List.\n");
							}

							else {
								System.out.println("Nothing to paste\n");
							}
						}
						System.out.println("Please select an option:");

					}

					/**
					 * This method move cursor Forward
					 */
					if (inputOption.equalsIgnoreCase("f")) {

						if (name.equalsIgnoreCase("j")) {
							if (Joe.getHead() == null) {
								System.out.println("Joe's list is empty\n");
							} else {
								Joe.cursorForward();
								if (Joe.getCursor() != null && Joe.getTail() != null) {
									System.out.println("Cursor Moved Forward in Joe's List.\n");
									System.out.println("Please select an option:");

								}
							}
						}

						if (name.equalsIgnoreCase("d")) {
							if (Donny.getHead() == null) {
								System.out.println("Donny's list is empty\n");
							} else {
								Donny.cursorForward();
								if (Donny.getCursor() != null && Donny.getTail() != null) {
									System.out.println("Cursor Moved Forward in Donny's List.\n");
									System.out.println("Please select an option:");

								}
							}
						}
					}

					/**
					 * This method move cursor to backward
					 */
					if (inputOption.equalsIgnoreCase("b")) {

						try {
							if (Joe.getHead() == null || Donny.getHead() == null) {
								throw new EndOfListException();
							}
							if (name.equalsIgnoreCase("j")) {

								Joe.cursorBackward();
								if (Joe.getCursor() != null && Joe.getTail() != null) {
									System.out.println("Cursor Moved Backward in Joe's List.\n");
								}
							}

							if (name.equalsIgnoreCase("d")) {

								Donny.cursorBackward();
								if (Donny.getCursor() != null && Donny.getTail() != null)
									System.out.println("Cursor Moved Backward in Donny's List.\n");

							}
						} catch (EndOfListException e) {
							System.out.println("Cannot move cursor backward\n");
						}
						System.out.println("Please select an option:");

					}

					/**
					 * This method move cursor to head
					 */
					if (inputOption.equalsIgnoreCase("h")) {

						if (name.equalsIgnoreCase("j")) {

							if (Joe.getHead() != null) {
								Joe.resetCursorToHead();
								System.out.println("Cursor Moved To Head in Joe's List\n");
							} else {
								System.out.println("There are no Cars in the list.");
							}
						}

						if (name.equalsIgnoreCase("d")) {

							if (Donny.getHead() != null) {
								Donny.resetCursorToHead();
								System.out.println("Cursor Moved To Head in Donny's List\n");
							} else {
								System.out.println("There are no Cars in the list.");
							}
						}
						System.out.println("Please select an option:");

					}

					/**
					 * This method move cursor to tail
					 */
					if (inputOption.equalsIgnoreCase("t")) {
						if (name.equalsIgnoreCase("j")) {

							if (Joe.getTail() != null) {
								Joe.resetCursorToTail();
								System.out.println("Cursor Moved To Tail in Joe's List\n");
							} else {
								System.out.println("There are no Cars in the list.\n");
							}
						}

						if (name.equalsIgnoreCase("d")) {

							if (Donny.getTail() != null) {
								Donny.resetCursorToTail();
								System.out.println("Cursor Moved To Tail in Donny's List\n");
							} else {
								System.out.println("There are no Cars in the list.\n");
							}
						}
						System.out.println("Please select an option:");

					}
				}

			}

			/**
			 * This method merge the list
			 */

			if (input.equalsIgnoreCase("m")) {

				System.out.println("Please select a destination list - Joe (J) or Donny (D): ");
				String nameList = scan.nextLine();

				if (!nameList.equalsIgnoreCase("d") && !nameList.equalsIgnoreCase("j")) {
					System.out.println("Invalid input. Etner L,M,P,F,S,Q");
					invalidInput = true;

				}

				if (nameList.equalsIgnoreCase("d")) {

					int Joecar = Joe.numCars();
					int DonnyCar = Donny.numCars();
					int manyCar = 0;
					if (Joecar >= DonnyCar) {
						manyCar = Joecar;
					} else {
						manyCar = DonnyCar;
					}

					if (Donny.getHead() == null && Joe.getHead() != null) {
						System.out.println("Joe's list merged into Donny's\n");

						Car joeCursorCar = Joe.getCursorCar();

						Donny = Joe;
						Joe = tempTwo;
						while (Donny.getCursorCar() != joeCursorCar) {
							Donny.cursorForward();
						}
					} else {
						try {
							Car donnyCursorCar = Donny.getCursorCar();
							Joe.resetCursorToHead();
							Donny.resetCursorToHead();
							for (int i = 0; i < manyCar; i++) {

								if (Donny.getHead() != null) {
									cutCar = Donny.getCursorCar();
									Donny.removeCursor();
									mergeList.appendToTail(cutCar);
									cutCar = null;
								}

								if (Joe.getHead() != null) {
									cutCar = Joe.getCursorCar();
									Joe.removeCursor();
									mergeList.appendToTail(cutCar);
									cutCar = null;
								}

							}
							System.out.println("Joe's list merged into Donny's\n");

							Donny = mergeList;
							while (Donny.getCursorCar() != donnyCursorCar) {
								Donny.cursorForward();
							}
						} catch (Exception e) {
							System.out.println("Exception occurred: " + e.toString());
						}
						System.out.println("Please select an option");

					}

				}

				if (nameList.equalsIgnoreCase("j")) {

					int Joecar = Joe.numCars();
					int DonnyCar = Donny.numCars();
					int manyCar = 0;
					if (Joecar >= DonnyCar) {
						manyCar = Joecar;
					} else {
						manyCar = DonnyCar;
					}

					if (Joe.getHead() == null && Donny.getHead() != null) {
						System.out.println("Donny's list merged into Joe's\n");
						Car donnyCursorCar = Donny.getCursorCar();
						Joe = Donny;
						Donny = temp;
						while (Joe.getCursorCar() != donnyCursorCar) {
							Joe.cursorForward();
						}

					} else {
						try {
							Car joeCursorCar = Joe.getCursorCar();
							Donny.resetCursorToHead();
							Joe.resetCursorToHead();
							for (int i = 0; i < manyCar; i++) {

								if (Joe.getHead() != null) {
									cutCar = Joe.getCursorCar();
									Joe.removeCursor();
									mergeList.appendToTail(cutCar);
									cutCar = null;
								}

								if (Donny.getHead() != null) {
									cutCar = Donny.getCursorCar();
									Donny.removeCursor();
									mergeList.appendToTail(cutCar);
									cutCar = null;
								}

							}
							System.out.println("Donny's list merged into Joe's\n");

							Joe = mergeList;
							while (Joe.getCursorCar() != joeCursorCar) {
								Joe.cursorForward();
							}

						} catch (Exception e) {
							System.out.println("Exception occurred: " + e.toString());
						}

						System.out.println("Please select an option");

					}

				}
			}

			/**
			 * This method print lists
			 */
			if (input.equalsIgnoreCase("p")) {
				System.out.println("\nJoe's List:");
				System.out.println("Make \t\t  Owner\n------------------------");
				if (Joe.getHead() == null) {
					System.out.println("[empty]");
				} else {
					Joe.toString();

				}

				System.out.println("\n");

				System.out.println("Donny's List:");
				System.out.println("Make \t\t  Owner\n------------------------");
				if (Donny.getHead() == null) {
					System.out.println("[empty]");
				} else {
					Donny.toString();
				}

				System.out.println("\n");

				System.out.println("Finished List:");
				System.out.println("Make \t\t  Owner\n------------------------");
				if (FinishedList.getHead() == null) {
					System.out.println("[empty]\n");
				} else {
					FinishedList.toString();
				}

				System.out.println("Please select an option:");

			}

			/**
			 * This method paste car to finished list.
			 */
			if (input.equalsIgnoreCase("f")) {

				if (cutCar != null) {
					FinishedList.appendToTail(cutCar);
					cutCar = null;
					finishNode = currentList.getCursor();
					FinishedList.setCursor(finishNode);
					;
					System.out.println("Car pasted in finished list.\n");
				} else {
					System.out.println("Nothing to paste\n");
				}

				System.out.println("Please select an option");

			}

			/**
			 * This method quit the program.
			 */
			if (input.equalsIgnoreCase("q")) {
				System.out.println("Enjoy your retirement!");

				break;
			}
		}
	}

	/**
	 * This method sort the car name and then add the object to the end of the Joe's
	 * list
	 */
	public static void joeEnumTestAddEnd(Car k) {
		switch (make) {
			case FORD:
				Joe.appendToTail(k);
				break;
			case GMC:
				Joe.appendToTail(k);
				break;

			case CHEVY:
				Joe.appendToTail(k);
				break;

			case JEEP:
				Joe.appendToTail(k);
				break;

			case DODGE:
				Joe.appendToTail(k);
				break;

			case CHRYSLER:
				Joe.appendToTail(k);
				break;

			case LINCOLN:
				Joe.appendToTail(k);
				break;

		}

	}

	/**
	 * This method sort the car name and then add the object to the
	 * before cursor of the joe's list.
	 */
	public static void joeEnumTestBeforeCar(Car k) {

		switch (make) {
			case FORD:
				Joe.insertBeforeCursor(k);
				break;
			case GMC:
				Joe.insertBeforeCursor(k);
				break;

			case CHEVY:
				Joe.insertBeforeCursor(k);
				break;

			case JEEP:
				Joe.insertBeforeCursor(k);
				break;

			case DODGE:
				Joe.insertBeforeCursor(k);
				break;

			case CHRYSLER:
				Joe.insertBeforeCursor(k);
				break;

			case LINCOLN:
				Joe.insertBeforeCursor(k);
				break;

		}
	}

	/**
	 * This method sort the car name and then add the object to the
	 * end of the Donny's list
	 */
	public static void donnyEnumTestAddEnd(Car k) {
		switch (make) {
			case FORD:
				Donny.appendToTail(k);

				break;
			case GMC:
				Donny.appendToTail(k);
				break;

			case CHEVY:
				Donny.appendToTail(k);
				break;

			case JEEP:
				Donny.appendToTail(k);
				break;

			case DODGE:
				Donny.appendToTail(k);
				break;

			case CHRYSLER:
				Donny.appendToTail(k);
				break;

			case LINCOLN:
				Donny.appendToTail(k);
				break;

		}

	}

	/**
	 * This method sort the car name and then add the object to the
	 * before cursor of the Donny's list.
	 */
	public static void donnyEnumTestBeforeCar(Car k) {

		switch (make) {
			case FORD:
				Donny.insertBeforeCursor(k);
				break;
			case GMC:
				Donny.insertBeforeCursor(k);
				break;

			case CHEVY:
				Donny.insertBeforeCursor(k);
				break;

			case JEEP:
				Donny.insertBeforeCursor(k);
				break;

			case DODGE:
				Donny.insertBeforeCursor(k);
				break;

			case CHRYSLER:
				Donny.insertBeforeCursor(k);
				break;

			case LINCOLN:
				Donny.insertBeforeCursor(k);
				break;

		}
	}

	/**
	 * This method display the menu
	 * 
	 * @return The menu
	 */
	public static String menu() {

		String menu = "";

		menu = menu + "Menu:\n" +

				"L) Edit Job Lists for Joe and Donny \n"
				+ "M) Merge Job Lists\n"
				+ "P) Print Job Lists\n"
				+ "F) Paste car to end of finished car list\n"
				+ "Q) Quit.\n\n"
				+ "Please select an option";

		return menu;

	}

	/**
	 * This method display the Option
	 * 
	 * @return The option
	 */
	public static String Option() {

		String Option = "";

		Option = Option + "Option:\n"
				+ "A) Add a car to the end of the list\n"
				+ "F) Cursor Forward\n"
				+ "H) Cursor to Head\n"
				+ "T) Cursor to Tail\n"
				+ "B) Cursor Backward\n"
				+ "I) Insert car before cursor\n"
				+ "X) Cut car at cursor\n"
				+ "V) Paste before cursor\n"
				+ "R) Remove cursor\n\n"
				+ "Please select an option:";
		return Option;
	}
}
