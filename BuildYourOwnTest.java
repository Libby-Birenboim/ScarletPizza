package Test;

import static org.junit.Assert.*;

import Classes.BuildYourOwn;
import Classes.Size;
import Classes.Topping;

/**
 * BuildYourOwnTest class is the testing code to test the price method in the BuildYourOwn Pizza class
 */
public class BuildYourOwnTest {

    /**
     * price_smallPizzaNoToppings method checks the price method in BuildYourOwn pizza class when it is a small pizza with no toppings
     */
    @org.junit.Test
    public void price_smallPizzaNoToppings() {
        BuildYourOwn pizza = new BuildYourOwn("Chicago");
        pizza.setSize(Size.SMALL);
        double expectedOutput = 8.99;
        double actualOutput = pizza.price();
        assertTrue(expectedOutput == actualOutput);
    }

    /**
     * price_smallPizzaWithToppings method checks the price method in BuildYourOwn pizza class when it is a small pizza with 2 toppings
     */
    @org.junit.Test
    public void price_smallPizzaWithToppings() {
        BuildYourOwn pizza = new BuildYourOwn("Chicago");
        pizza.setSize(Size.SMALL);
        pizza.add(Topping.SAUSAGE);
        pizza.add(Topping.PEPPORONI);
        double expectedOutput = 12.17;
        double actualOutput = pizza.price();
        assertTrue(expectedOutput == actualOutput);
    }

    /**
     * price_mediumPizzaNoToppings method checks the price method in BuildYourOwn pizza class when it is a medium pizza with no toppings
     */
    @org.junit.Test
    public void price_mediumPizzaNoToppings() {
        BuildYourOwn pizza = new BuildYourOwn("Chicago");
        pizza.setSize(Size.MEDIUM);
        double expectedOutput = 10.99;
        double actualOutput = pizza.price();
        assertTrue(expectedOutput == actualOutput);
    }

    /**
     * price_mediumPizzaWithToppings method checks the price method in BuildYourOwn pizza class when it is a medium pizza with 5 toppings
     */
    @org.junit.Test
    public void price_mediumPizzaWithToppings() {
        BuildYourOwn pizza = new BuildYourOwn("Chicago");
        pizza.setSize(Size.MEDIUM);
        pizza.add(Topping.SAUSAGE);
        pizza.add(Topping.PEPPORONI);
        pizza.add(Topping.GREEN_PEPPER);
        pizza.add(Topping.MUSHROOM);
        pizza.add(Topping.PROVOLONE);
        double expectedOutput = 18.94;
        double actualOutput = pizza.price();
        assertTrue(expectedOutput == actualOutput);
    }

    /**
     * price_largePizzaNoToppings method checks the price method in BuildYourOwn pizza class when it is a large pizza with no toppings
     */
    @org.junit.Test
    public void price_largePizzaNoToppings() {
        BuildYourOwn pizza = new BuildYourOwn("Chicago");
        pizza.setSize(Size.LARGE);
        double expectedOutput = 12.99;
        double actualOutput = pizza.price();
        assertTrue(expectedOutput == actualOutput);
    }

    /**
     * price_largePizzaWithToppings method checks the price method in BuildYourOwn pizza class when it is a large pizza with 1 topping
     */
    @org.junit.Test
    public void price_largePizzaWithToppings() {
        BuildYourOwn pizza = new BuildYourOwn("Chicago");
        pizza.setSize(Size.LARGE);
        pizza.add(Topping.SAUSAGE);
        double expectedOutput = 14.58;
        double actualOutput = pizza.price();
        assertTrue(expectedOutput == actualOutput);
    }
}
