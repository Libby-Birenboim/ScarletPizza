package Classes;

/**
 * this is the pizza factory interface that creates the different types of pizzas
 * @author Selin Altiparmak, Libby Birenboim
 *
 */
public interface PizzaFactory {
	Pizza createDeluxe();
	Pizza createMeatzza();
	Pizza createBBQChicken();
	Pizza createBuildYourOwn();
}