package scarletpizza;

import Classes.Order;
import Classes.Pizza;
import Classes.StoreOrders;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.ListView;

/**
 * this is the controller class for the current orders
 * @author Selin Altiparmak, Libby Birenboim
 */
public class CurrentOrderController  {
	
	private Order currentOrder = ScarletPizzaController.getCurrentOrder();
	private StoreOrders storeOrder = ScarletPizzaController.getStoreOrders();
	
	@FXML
	private TextField txtOrderNumber;
	@FXML
	private TextField txtSubTotal;
	@FXML
	private TextField txtOrderTotal;
	@FXML
	private TextField txtSalesTax;
	@FXML
	private ListView lstPizzas;
	@FXML
	private Button btnPlaceOrder;
	@FXML
	private Button btnRemovePizza;
	@FXML
	private Button btnClearOrder;
	
	/**
	 * this method initializes the current order default window
	 */
	@FXML
	private void initialize() {
		txtOrderNumber.setText(Integer.toString(currentOrder.getOrderNumber()));
		txtSubTotal.setText(String.format("%.2f",currentOrder.getSalesTotal()));
		txtOrderTotal.setText(String.format("%.2f",currentOrder.getTotal()));
		txtSalesTax.setText(String.format("%.2f",currentOrder.getSalesTax()));
		lstPizzas.getItems().clear();
		for (Pizza pizza: currentOrder.getPizzaList()) {
			lstPizzas.getItems().add(pizza);
		}
	}
	
	/**
	 * this method removes a pizza from an order
	 */
	@FXML
	private void removePizza() {
		Pizza p = (Pizza)lstPizzas.getSelectionModel().getSelectedItem();
		if (p != null) {
			currentOrder.remove(p);
		}
		
		initialize();	
	}
	
	/**
	 * this method clears the order of all pizzas
	 */
	@FXML
	private void clearOrder() {
		
		if (currentOrder.getPizzaList().size() == 0) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information");
			alert.setHeaderText("Order Already Cleared");
			alert.setContentText("Order is already cleared");
			alert.showAndWait().ifPresent(rs -> {
			    if (rs == ButtonType.OK) { }
			});
		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information");
			alert.setHeaderText("Order Cleared");
			alert.setContentText("You cleared the contents of the order");
			alert.showAndWait().ifPresent(rs -> {
			    if (rs == ButtonType.OK) { }
			});
			
			currentOrder.clearOrder();
			initialize();	
		}
	}
	
	/**
	 * this method places an order when user presses button
	 * @param ActionEvent event of user pressing button
	 */
	@FXML
	private void placeOrder(ActionEvent event) {
		
		if (currentOrder.getPizzaList().size() == 0) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information");
			alert.setHeaderText("Order can not be placed");
			alert.setContentText("The are no pizzas in the order");
			alert.showAndWait().ifPresent(rs -> {
			    if (rs == ButtonType.OK) { }
			});	
		} else {
			storeOrder.add(currentOrder);
			ScarletPizzaController.createNewOrder();
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information");
			alert.setHeaderText("Order Placed");
			alert.setContentText("You placed a new Order");
			alert.showAndWait().ifPresent(rs -> {
			    if (rs == ButtonType.OK) { }
			});
			
			Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		    stage.close();
		}	
	}
}