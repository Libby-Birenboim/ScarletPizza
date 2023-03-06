package Classes;

/**
 * this class creates the meat pizza with the correct toppings by extending Pizza
 * @author Selin Altiparmak, Libby Birenboim
 *
 */
public class Meatzza extends Pizza {
	
	private String style;
	
	/**
	 * this constructor receives the style of the pizza and creates a meatzza
	 * @param style String style of pizza
	 */
	public Meatzza (String style) {
		this.style = style;
		add(Topping.SAUSAGE);
		add(Topping.PEPPORONI);
		add(Topping.BEEF);
		add(Topping.HAM);
	}
	
	/**
	 * this method returns the style of the meatzza
	 * @return String style of meatzza
	 */
	public String getStyle() {
		return this.style;
	}
	
	/**
	 * this method calculates and returns the price of the meatzza based on its size
	 */
	@Override
	public double price() {
		if (this.getSize() == Size.SMALL ) {
			return 15.99;
		} else if (this.getSize() == Size.MEDIUM) {
			return 17.99;
		} else {
			return 19.99;
		}
 	}
	
	/**
	 * this method returns the String value of the meatzza
	 * @return String value of meatzza
	 */
	public String toString() {
		String s = "Meatzza {" + this.style +" Style - " + this.getCrust().toString() + "},";
		for (Topping t:this.getToppings()) {
			s += t.toString() +", ";
		}
		s += this.getSize().toString() + ", $" + String.format("%.2f", this.price()); 
		return s;
	}
}
