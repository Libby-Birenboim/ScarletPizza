package Classes;

/**
 * this class is meant to create the deluxe pizza with the correct toppings
 * @author Selin Altiparmak, Libby Birenboim
 *
 */
public class Deluxe extends Pizza {
	
	private String style;
	
	/**
	 * the Deluxe constructor receives a style and creates a deluxe pizza
	 * @param style String of style of pizza
	 */
	public Deluxe (String style) {
		this.style = style;
		add(Topping.SAUSAGE);
		add(Topping.PEPPORONI);
		add(Topping.GREEN_PEPPER);
		add(Topping.ONION);
		add(Topping.MUSHROOM);
	}
	
	/**
	 * this method returns the style of the pizza
	 * @return String style of pizza
	 */
	public String getStyle() {
		return this.style;
	}

	/**
	 * this method calculates and returns the price of the deluxe pizza based on different sizes
	 * @return double price of pizza
	 */
	@Override
	public double price() {
		if (this.getSize() == Size.SMALL ) {
			return 14.99;
		} else if (this.getSize() == Size.MEDIUM) {
			return 16.99;
		} else {
			return 18.99;
		}
 	}
	
	/**
	 * this method returns the String value of the deluxe pizza
	 * @return String of deluxe pizza
	 */
	public String toString() {
		String s = "Deluxe {" + this.style + " Style - " + this.getCrust().toString() + "},";
		for (Topping t:this.getToppings()) {
			s += t.toString() + ", ";
		}
		s += this.getSize().toString() + ", $" + String.format("%.2f", this.price()); 
		return s;
	}
}