package Classes;

/**
 * this class is meant to create a Chicago style pizza by implementing PizzaFactory interface
 * @author Selin Altiparmak, Libby Birenboim
 *
 */
public class ChicagoPizza implements PizzaFactory {

	/**
	 * this method creates the Deluxe pizza with the Chicago style
	 */
	@Override
	public Pizza createDeluxe() {
		Deluxe pizza = new Deluxe("Chicago");
		pizza.setCrust(Crust.DEEP_DISH);
		return pizza;
	}

	/**
	 * this method creates the meat pizza with the Chicago style
	 */
	@Override
	public Pizza createMeatzza() {
		Meatzza pizza = new Meatzza("Chicago");
		pizza.setCrust(Crust.STUFFED);
		return pizza;
	}

	/**
	 * this method creates the BBQ chicken pizza with the Chicago style
	 */
	@Override
	public Pizza createBBQChicken() {
		BbqChicken pizza = new BbqChicken("Chicago");
		pizza.setCrust(Crust.PAN);
		return pizza;
	}

	/**
	 * this method creates the build your own pizza with the Chicago style
	 */
	@Override
	public Pizza createBuildYourOwn() {
		BuildYourOwn pizza = new BuildYourOwn("Chicago");
		pizza.setCrust(Crust.PAN);
		return pizza;
	}
}
