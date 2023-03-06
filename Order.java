package Classes;

import java.util.ArrayList;

/**
 * this class stores the orders that customers make by implementing Customizable interface
 * @author Selin Altiparmak, Libby Birenboim
 *
 */
public class Order implements Customizable {
	
	private static int orderSerial = 1;
	
	private int orderNumber;
	
	private ArrayList<Pizza> pizzaList;
		
	/**
	 * Order constructor creates a new order and stores it in the pizza orders list
	 */
	public Order() {
		pizzaList = new ArrayList<Pizza>();
		orderNumber = orderSerial ;
		orderSerial++;
	}

	/**
	 * this method returns the unique order number
	 * @return integer order number
	 */
	public int getOrderNumber() {
		return orderNumber;
	}

	/**
	 * this method returns the pizza order list
	 * @return ArrayList<Pizza> or pizza order list
	 */
	public ArrayList<Pizza> getPizzaList() {
		return pizzaList;
	}

	/**
	 * this method adds a pizza order to the order list
	 * @return boolean true if added successfully, false otherwise
	 */
	@Override
	public boolean add(Object obj) {
		if (!(obj instanceof Pizza)) {
			return false;
		}
		
		Pizza pizza = (Pizza )obj;
		if (pizzaList.contains(pizza)) {
			return false;
		}
		
		pizzaList.add(pizza);
		return true;
	}

	/**
	 * this method removes a pizza order from the order list
	 * @return boolean true if removed successfully, false otherwise
	 */
	@Override
	public boolean remove(Object obj) {
		if (!(obj instanceof Pizza)) {
			return false;
		}
		
		Pizza pizza = (Pizza )obj;
		if (!pizzaList.contains(pizza)) {
			return false;
		}
		
		pizzaList.remove(pizza);
		return true;
	}
	
	/**
	 * this method clears and deletes the order
	 */
	public void clearOrder() {
		pizzaList.clear();
	}
	
	/**
	 * this method calculates and returns the sales total after including sales tax
	 * @return double price of sales total
	 */
	public double getSalesTotal() {
		double total = 0;
		for (Pizza p : pizzaList) {
			total += p.price();
		}
		return total;
	}
	
	/**
	 * this method calculates and returns the sales tax of order
	 * @return double sales tax of order
	 */
	public double getSalesTax() {
		
		return getSalesTotal() * 0.06625;
	}
	
	/**
	 * this method returns the total price of order
	 * @return double total price of order
	 */
	public double getTotal() {
		return getSalesTotal() + getSalesTax();
	}
	
}