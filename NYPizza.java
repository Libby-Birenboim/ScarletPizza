package Classes;

/**
 * this class implements the PizzaFactory interface and creates NYstyle pizzas
 * @author Selin Altiparmak, Libby Birenboim
 *
 */
public class NYPizza implements PizzaFactory {
	
	/**
	 * this method creates the deluxe NYstyle pizza
	 */
	@Override
	public Pizza createDeluxe() {
		Deluxe pizza = new Deluxe("Newyork");
		pizza.setCrust(Crust.BROOKLYN);
		return pizza;
	}

	/**
	 * this method creates the meatzza NYstyle pizza
	 */
	@Override
	public Pizza createMeatzza() {
		Meatzza pizza = new Meatzza("Newyork");
		pizza.setCrust(Crust.HAND_TOSSED);
		return pizza;
	}

	/**
	 * this method creates the BBQ chicken NY style pizza
	 */
	@Override
	public Pizza createBBQChicken() {
		BbqChicken pizza = new BbqChicken("Newyork");
		pizza.setCrust(Crust.THIN);
		return pizza;
	}

	/**
	 * this  method creates the build your own NY style pizza
	 */
	@Override
	public Pizza createBuildYourOwn() {
		BuildYourOwn pizza = new BuildYourOwn("Newyork");
		pizza.setCrust(Crust.HAND_TOSSED);
		return pizza;
	}
}
