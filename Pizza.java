package Classes;

import java.util.ArrayList;

/**
 * this class is the main pizza class that is extended by the types of pizza classes. It implements Customizable interface
 * @author Selin Altiparmak, Libby Birenboim
 *
 */
public abstract class Pizza implements Customizable {
	private ArrayList<Topping> toppings;
	private Crust crust;
	private Size size;
	
	/**
	 * the pizza constructor creates a new pizza with a new list of toppings
	 */
	public Pizza() {
		toppings = new ArrayList<Topping> ();
	}
	
	/**
	 * this method adds a topping to a pizza
	 * @return boolean true if added successfully, false otherwise
	 */
	public boolean add(Object obj) {
		if (!(obj instanceof Topping)) {
			return false;
		}
		Topping topping = (Topping )obj;
		if (toppings.contains(topping)) {
			return false;
		}
		
		if (toppings.size() >= 7) {
			return false;
		}
		
		toppings.add(topping);
		return true;
	}

	/**
	 * this method removes a topping from a pizza
	 * @return boolean true if removed successfully, false otherwise
	 */
	public boolean remove(Object obj) {
		if (!(obj instanceof Topping)) {
			return false;
		}
		
		Topping topping = (Topping )obj;
		if (!toppings.contains(topping)) {
			return false;
		}
		
		toppings.remove(topping);
		return true;
	}
	
	/**
	 * this method returns the type of crust that the pizza has
	 * @return Crust of pizza
	 */
	public Crust getCrust() {
		return crust;
	}

	/**
	 * this method sets the crust of the pizza to what the user inputs as the crust
	 * @param Crust of pizza
	 */
	public void setCrust(Crust crust) {
		this.crust = crust;
	}

	/**
	 * this method returns the size of the pizza
	 * @return Size of pizza
	 */
	public Size getSize() {
		return size;
	}

	/**
	 * this method sets the size of the pizza
	 * @param Size of pizza
	 */
	public void setSize(Size size) {
		this.size = size;
	}
	
	/**
	 * this method returns the amount of toppings on the pizza
	 * @return integer of number of toppings of pizza
	 */
	public int getToppingCount() {
		return toppings.size();
	}
	
	/**
	 * this method returns all the toppings of the pizza
	 * @return ArrayList<Topping> of toppings of pizza
	 */
	public ArrayList<Topping> getToppings() {
		return toppings;
	}

	/**
	 * this method is an abstract method that in the child classes would return the price of the pizza
	 * @return double price of pizza
	 */
	public abstract double price();
}