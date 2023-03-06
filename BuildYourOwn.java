package Classes;

/**
 * this class is the BuildYourOwn pizza class that is meant to create the build your own pizza
 * @author Selin Altiparmak, Libby Birenboim
 *
 */
public class BuildYourOwn extends Pizza{
	
	private String style;
	
	/**
	 * this constructor creates the buildYourOwn pizza with the specified style
	 * @param style of pizza
	 */
	public BuildYourOwn  (String style) {
		this.style = style;
		
	}
	
	/**
	 * this method returns the style of the pizza (Chicago or NY)
	 * @return String style of pizza
	 */
	public String getStyle() {
		return this.style;
	}
	
	/**
	 * this method calculates and returns the price of the pizza based on the size and the number of toppings
	 * @return double price of pizza
	 */
	@Override
	public double price() {
		if (this.getSize() == Size.SMALL ) {
			Double price = 8.99 + getToppingCount() * 1.59; 
			return price;
		} else if (this.getSize() == Size.MEDIUM) {
			Double price = 10.99 + getToppingCount() * 1.59; 
			return price;
		} else {
			Double price = 12.99 + getToppingCount() * 1.59; 
			return price;
		}
 	}
	
	/**
	 * this method converts the build your own pizza to strign form
	 * @return String of build your own pizza
	 */
	public String toString() {
		String s = "Build your own {" + this.style +" Style - " + this.getCrust().toString() + "},";
		for (Topping t : this.getToppings()) {
			s += t.toString() +", ";
		}
		s += this.getSize().toString() + ", $" + String.format("%.2f", this.price()); 
		return s;
	}
}