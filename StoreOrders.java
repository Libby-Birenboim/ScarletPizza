package Classes;

import java.util.ArrayList;

/**
 * this class stores all the store pizza orders
 * @author Selin Altiparmak, Libby Birenboim
 *
 */
public class StoreOrders implements Customizable<Order> {
	private ArrayList<Order> orderList = new ArrayList<Order>();

	/**
	 * this method adds an order to the store orders
	 * @return boolean true if added successfully, false otherwise
	 */
	@Override
	public boolean add(Object obj) {
		if (!(obj instanceof Order)) {
			return false;
		}
		
		Order order = (Order)obj;
		if (orderList.contains(order)) {
			return false;
		}
		
		orderList.add(order);
		return true;
	}

	/**
	 * this method removes an order from the store orders
	 * @returns true if removed successfully, false otherwise
	 */
	@Override
	public boolean remove(Object obj) {
		if (!(obj instanceof Order)) {
			return false;
		}
		
		Order order = (Order)obj;
		if (!orderList.contains(order)) {
			return false;
		}
		
		orderList.remove(order);
		return true;
	}
	
	/**
	 * this method returns the store order list
	 * @return ArrayList<Order> of store orders
	 */
	public ArrayList<Order> getOrderList() {
		return orderList;
	}
	
	/**
	 * this method returns the order based on the order number
	 * @param orderNumber of order
	 * @return Order
	 */
	public Order getOrder(int orderNumber) {
		for (Order order: orderList) {
			if (order.getOrderNumber() == orderNumber) {
				return order;
			}
		}
		
		return null;
	}
}
