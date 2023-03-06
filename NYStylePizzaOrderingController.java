package scarletpizza;

import java.io.File;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

import Classes.BuildYourOwn;
import Classes.ChicagoPizza;
import Classes.NYPizza;
import Classes.Order;
import Classes.Pizza;
import Classes.Size;
import Classes.Topping;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;

/**
 * this class is the NY style pizza controller 
 * @author Selin Altiparmak, Libby Birenboim
 */
public class NYStylePizzaOrderingController  {
	
	private static final String NY_DELUXE_IMAGE_FILE = "src/images/Deluxe-NY.png";
	private static final String NY_MEATZZA_IMAGE_FILE = "src/images/Meatzza-NY.png";
	private static final String NY_BBQCHICKEN_IMAGE_FILE = "src/images/BBQ Chicken-NY.png";
	private static final String NY_BUILDYOUROWN_IMAGE_FILE = "src/images/BuildYourOwn-NY.png";

	ObservableList<String> pizzaTypeList = FXCollections.observableArrayList("Build Your Own",
			"Deluxe", "BBQ Chicken", "Meatzza");
	
	private ScarletPizzaController scarletPizzaController;
	private Pizza pizza;
	private NYPizza nyPizza = new NYPizza();

	@FXML
	private RadioButton pizzaSizeSmall;
	@FXML
	private RadioButton pizzaSizeMedium;
	@FXML
	private RadioButton pizzaSizeLarge;

	@FXML
	private ComboBox pizzaType;
	
	@FXML
	private ListView selectedToppings;
	
	@FXML
	private ListView availableToppings;
	
	@FXML
	private Button btnAddTopping;
	
	@FXML
	private Button btnRemoveTopping;
	
	@FXML
	private Button btnAddToOrder;	
		
	@FXML
	private TextField crust;
	
	@FXML
	private TextField pizzaPrice;
	
	@FXML
	private ImageView pizzaImage;
	
	/**
	 * this method adds order to the pizza
	 * @param event ActionEvent
	 */
	@FXML
	private void addToOrder(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information");
		alert.setHeaderText("Order Added");
		alert.setContentText("You added a new Order");
		alert.showAndWait().ifPresent(rs -> {
		    if (rs == ButtonType.OK) {
		        
		    }
		});
		scarletPizzaController.addToOrder(pizza); 

		initialize() ;
	}
	
	/**
	 * this method adds a topping to the pizza
	 */
	@FXML
	private void addTopping() {
		if (availableToppings.getSelectionModel().getSelectedItem() != null ) {
			if (pizza.getToppingCount() < 7) {
				Topping topping = Topping.valueOf(availableToppings.getSelectionModel().getSelectedItem().toString());
				pizza.add(topping);
				selectedToppings.getItems().add(topping);
				availableToppings.getItems().remove(topping);
				calculatePrice();
				
			} else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Toppings");
				alert.setHeaderText("Topping Limit Exceeded");
				alert.setContentText("Only 7 toppings are allowed");
				alert.showAndWait().ifPresent(rs -> {
				    if (rs == ButtonType.OK) {
				        System.out.println("Pressed OK.");
				    }
				});
			}
		}
	}
	
	/**
	 * this method removes a topping from the pizza
	 */
	@FXML
	private void removeTopping() {
		if (selectedToppings.getSelectionModel().getSelectedItem() != null ) {
		
				Topping topping = Topping.valueOf(selectedToppings.getSelectionModel().getSelectedItem().toString());
				pizza.remove(topping);
				availableToppings.getItems().add(topping);
				selectedToppings.getItems().remove(topping);
				calculatePrice();
		}
	}
	
	/**
	 * this method sets the toppings buttons
	 */
	private void setTopppingButtons() {
		if (pizza instanceof BuildYourOwn) {
			btnAddTopping.setDisable(false);
			btnRemoveTopping.setDisable(false);
		} else {
			btnAddTopping.setDisable(true);
			btnRemoveTopping.setDisable(true);
		}
	}
	
	/**
	 * this method fills the size options for the pizzas
	 */
	private void fillSize() {
		if (pizzaSizeSmall.isSelected()) {
			pizza.setSize(Size.SMALL);
		} else if (pizzaSizeMedium.isSelected()) {
			pizza.setSize(Size.MEDIUM);
		} else if (pizzaSizeLarge.isSelected()) {
			pizza.setSize(Size.LARGE);
		} 
	}
	
	/**
	 * this method calculates the price of the pizza
	 */
	private void calculatePrice() {
		pizzaPrice.setText(String.format("%.2f", pizza.price()));
	}

	/**
	 * this method fills the list view with the pizza toppings
	 */
	private void fillListViews() {
		selectedToppings.getItems().clear();
		availableToppings.getItems().clear();
		for (Topping t : Topping.values()) {
			availableToppings.getItems().add(t);
		}
		
		for (Topping t: pizza.getToppings()) {
			selectedToppings.getItems().add(t.toString());
			availableToppings.getItems().remove(t);
		}
		
		setTopppingButtons();
	}
	
	/**
	 * this method initializes the default window of the NY style pizza
	 */
	@FXML
	private void initialize() {
		pizzaType.setValue("BuildYourOwn");
		pizzaType.setItems(pizzaTypeList);
		pizza = nyPizza.createBuildYourOwn();
		pizza.setSize(Size.SMALL);
		crust.setText(pizza.getCrust().toString());
		File file = new File(NY_BUILDYOUROWN_IMAGE_FILE);
	    Image image = new Image(file.toURI().toString());
	    pizzaImage.setImage(image);

		calculatePrice();
		fillListViews();
	}
	
	/**
	 * this method allows the user to choose the type of pizza they want
	 * @param ActionEvent event of user choosing pizza from Combo-box
	 */
	@FXML
	private void choosePizza(ActionEvent event) {
		File file;
	    Image image;
		switch (pizzaType.getValue().toString()) {
			case "Deluxe":
				pizza = nyPizza.createDeluxe();
				file = new File(NY_DELUXE_IMAGE_FILE);
			    image = new Image(file.toURI().toString());
			    pizzaImage.setImage(image);
				fillSize();
				fillListViews();
				calculatePrice();
				break;
			case "BBQ Chicken":
				pizza = nyPizza.createBBQChicken();
				file = new File(NY_BBQCHICKEN_IMAGE_FILE);
			    image = new Image(file.toURI().toString());
			    pizzaImage.setImage(image);
				fillSize();
				fillListViews();
				calculatePrice();
				break;
			case "Meatzza":
				pizza = nyPizza.createMeatzza();
				file = new File(NY_MEATZZA_IMAGE_FILE);
			    image = new Image(file.toURI().toString());
			    pizzaImage.setImage(image);
				fillSize();
				fillListViews();
				calculatePrice();
				break;
			case "Build Your Own":
				pizza = nyPizza.createBuildYourOwn();
				file = new File(NY_BUILDYOUROWN_IMAGE_FILE);
			    image = new Image(file.toURI().toString());
			    pizzaImage.setImage(image);
				fillSize();
				fillListViews();
				calculatePrice();
				break;
			default:
				break;
		
		}
		
		crust.setText(pizza.getCrust().toString());
	}
	
	/**
	 * this method sets the size and price of the pizza to small
	 * @param ActionEvent event of setting pizza size to small
	 */
	@FXML
	private void pizzaSmall(ActionEvent event) {
		pizza.setSize(Size.SMALL);
		calculatePrice();
	}
	
	/**
	 * this method sets the size and price of the pizza to medium
	 * @param ActionEvent event of setting pizza size to medium
	 */
	@FXML
	private void pizzaMedium(ActionEvent event) {
		pizza.setSize(Size.MEDIUM);
		calculatePrice();
	}
	
	/**
	 * this method sets the size and price of the pizza to large
	 * @param ActionEvent event of setting pizza size to large
	 */
	@FXML
	private void pizzaLarge(ActionEvent event) {
		pizza.setSize(Size.LARGE);
		calculatePrice();
	}
	
	/**
	 * this method sets the main controller for the Scarlet pizza controller to be connected to the NY style pizza controller
	 * @param scarletPizzaController ScarletPizzacontroller
	 */
	public void setMainController(ScarletPizzaController scarletPizzaController) {
		this.scarletPizzaController = scarletPizzaController;
	}
}