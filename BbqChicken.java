package Classes;

/**
 * this class is the BBQChicken class that extends Pizza and is meant to create the BBQ chicken pizza
 * @author Selin Altiparmak, Libby Birenboim
 *
 */
public class BbqChicken extends Pizza {
	private String style;
	public BbqChicken (String style) {
		this.style = style;
		add(Topping.BBQ_CHICKEN);
		add(Topping.PROVOLONE);
		add(Topping.GREEN_PEPPER);
		add(Topping.CHEDDAR);
	}
	
	/**
	 * this method returns the style of the pizza (Chicago or NY)
	 * @return String style of pizza
	 */
	public String getStyle() {
		return this.style;
	}
	
	/**
	 * this method calculates the price of the pizza based on the size and the number of toppings
	 * @return double price value of pizza
	 */
	@Override
	public double price() {
		if (this.getSize() == Size.SMALL ) {
			return 13.99;
		} else if (this.getSize() == Size.MEDIUM) {
			return 15.99;
		} else {
			return 17.99;
		}
 	}
	
	/**
	 * this method converts the pizza including its style and price and returns the string value of the pizza.
	 * @return String of pizza info
	 */
	public String toString() {
		String s = "BBQ Chicken {" + this.style + " Style - " + this.getCrust().toString() + "},";
		for (Topping t:this.getToppings()) {
			s += t.toString() + ", ";
		}
		s += this.getSize().toString() + ", $" + String.format("%.2f", this.price()); 
		return s;
	}
}

