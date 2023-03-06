package scarletpizza;

import java.io.IOException;

import Classes.Order;
import Classes.Pizza;
import Classes.StoreOrders;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

/**
 * this class is the ScarletPizza controller
 * @author Selin Altiparmak, Libby Birenboim
 */
public class ScarletPizzaController {

	private static StoreOrders storeOrder = new StoreOrders();
	private static Order currentOrder = new Order(); 

	private Button ChicagoStylePizzaButton, NewYorkStylePizzaButton, openStoreOrdersButton, CurrentOrderButton ;
	@FXML
	private ImageView ChicagoStylePizzaOrderingView;

	@FXML
	private ImageView NewYorkStylePizzaOrderingView;

	@FXML
	private ImageView StoreOrdersView;

	@FXML
	private ImageView CurrentOrderView;

	/**
	 * this method returns the store orders
	 * @return StoreOrders 
	 */
	public StoreOrders getStoreOrder() {
		return storeOrder;
	}

	/**
	 * this method returns the current order
	 * @return Order current order
	 */
	public static Order getCurrentOrder() {
		return currentOrder;
	}
	
	/**
	 * this method returns the store orders but is a static method
	 * @return StoreOrders
	 */
	public static  StoreOrders getStoreOrders() {
		return storeOrder;
	}
	
	/**
	 * this method creates a new order
	 */
	public static  void createNewOrder() {
		currentOrder = new Order();
	}
	
	/**
	 * this method tells the program what to do when user presses chicago style button
	 * @param event ActionEvent
	 * @throws IOException
	 */
	@FXML
	public void onChicagoStyleButtonClick(ActionEvent event) throws IOException {

		FXMLLoader loader = new FXMLLoader (getClass().getResource("ChicagoStylePizzaOrderingView.fxml"));

		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(loader.load(),645,450);
		ChicagoStylePizzaOrderingController chicagoPizzaController = loader.getController();
		chicagoPizzaController.setMainController(this);

		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setTitle("Chicago Style Pizza");
		stage.setScene(scene);

		stage.show();
	}

	/**
	 * this method tells the program what to do when user clicks the NY style button
	 * @param event ActionEvent
	 * @throws IOException
	 */
	@FXML
	private void onNYStyleButtonClick(ActionEvent event) throws IOException {
		// open NYStyleView
		FXMLLoader loader = new FXMLLoader (getClass().getResource("NewYorkStylePizzaOrderingView.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(loader.load(),645,450);
		NYStylePizzaOrderingController nyPizzaController = loader.getController();
		nyPizzaController.setMainController(this);

		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setTitle("New York Style Pizza");
		stage.setScene(scene);
		stage.show();
	}

	/**
	 * this method tells program what to do when user clicks the store orders button
	 * @param event ActionEvent
	 * @throws IOException
	 */
	@FXML
	private void onStoreOrdersClick(ActionEvent event) throws IOException {
		// open StoreOrdersView
		if (storeOrder.getOrderList().size()==0) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information");
			alert.setHeaderText("Store Order is Empty");
			alert.setContentText("Please add an order first");
			alert.showAndWait().ifPresent(rs -> {
				if (rs == ButtonType.OK) { }
			});
		} else {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("StoreOrdersView.fxml"));
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root,645,450);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setTitle("Store Orders");
			stage.setScene(scene);
			stage.show();
		}
	}

	/**
	 * this method tells program what to do when user clicks the current order button
	 * @param event ActionEvent
	 * @throws IOException
	 */
	@FXML
	private void onCurrentOrderClick(ActionEvent event) throws IOException {
		// open CurrentOrderView
		if (currentOrder.getPizzaList().size()==0) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information");
			alert.setHeaderText("Current Order is Empty");
			alert.setContentText("Please add a pizza first");
			alert.showAndWait().ifPresent(rs -> {
				if (rs == ButtonType.OK) { }
			});
		} else {
			FXMLLoader loader = new FXMLLoader (getClass().getResource("CurrentOrderView.fxml"));

			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			Scene scene = new Scene(loader.load(),645,450);
			CurrentOrderController currentOrderController = loader.getController();

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setTitle("Current Order");
			stage.setScene(scene);
			stage.show();			
		}
	}

	/**
	 * this method adds a pizza to order
	 * @param Pizza p
	 */
	public void addToOrder(Pizza p) {
		currentOrder.add(p);
	}
	
	/**
	 * this method removes a pizza from the order
	 * @param Pizza p
	 */
	public void removeFromOrder(Pizza p) {
		currentOrder.remove(p);
	}
}
