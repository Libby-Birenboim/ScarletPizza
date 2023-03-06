package scarletpizza;

import java.io.FileWriter;
import java.io.IOException;

import Classes.Order;
import Classes.Pizza;
import Classes.StoreOrders;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.ListView;

/**
 * this class is the store orders controller
 * @author Selin Altiparmak, Libby Birenboim
 */
public class StoreOrdersController  {
	
	private Order currentOrder = ScarletPizzaController.getCurrentOrder();
	private StoreOrders storeOrder = ScarletPizzaController.getStoreOrders();
	
	@FXML
	private ComboBox cmbOrderNumber;
	
	@FXML
	private TextField txtOrderTotal;
	
	@FXML
	private ListView lstPizzas;
	
	@FXML
	private Button btnCancelOrder;
	
	@FXML
	private Button btnExportOrders;
	
	/**
	 * this method initializes the store orders default window
	 */
	@FXML
	private void initialize() {
		ObservableList<String> orderNumberList = FXCollections.observableArrayList();
		for (Order order : storeOrder.getOrderList()) {
			orderNumberList.add(Integer.toString(order.getOrderNumber()));
		}
	
		cmbOrderNumber.setItems(orderNumberList);
		lstPizzas.getItems().clear();
		txtOrderTotal.setText("");
		if (orderNumberList.size() > 0) {
			cmbOrderNumber.setValue(orderNumberList.get(0));
			lstPizzas.getItems().clear();
			int orderNumber = Integer.parseInt(cmbOrderNumber.getValue().toString());

			for (Pizza pizza: storeOrder.getOrder(orderNumber).getPizzaList()) {
				lstPizzas.getItems().add(pizza);
			}
			
			txtOrderTotal.setText(String.format ("%.2f", storeOrder.getOrder(orderNumber).getTotal()));
		}	
	}
	
	/**
	 * this method selects the order based on user mouse input
	 * @param event ActionEvent
	 */
	@FXML
	private void selectOrder(ActionEvent event) {
		if (cmbOrderNumber.getValue() == null) {
			return;
		}
		
		int orderNumber = Integer.parseInt(cmbOrderNumber.getValue().toString());
		if (storeOrder.getOrder(orderNumber) != null) {
			lstPizzas.getItems().clear();
			for (Pizza pizza: storeOrder.getOrder(orderNumber).getPizzaList()) {
				lstPizzas.getItems().add(pizza );
				
			}
			
			txtOrderTotal.setText(String.format ("%.2f", storeOrder.getOrder(orderNumber).getTotal()));			
		}
	}
	
	/**
	 * this method cancels an order based on user input through a button
	 * @param event ActionEvent
	 */
	@FXML
	private void cancelOrder(ActionEvent event) {
		
		if (cmbOrderNumber.getValue() == null) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information");
			alert.setHeaderText("Order can not be canceled");
			alert.setContentText("There is no order to cancel");
			alert.showAndWait().ifPresent(rs -> {
			    if (rs == ButtonType.OK) {}
			});
		} else {
			int orderNumber = Integer.parseInt(cmbOrderNumber.getValue().toString());
			Order order = storeOrder.getOrder(orderNumber);
			storeOrder.remove(order);
			initialize();	
		}
	}
	
	/**
	 * this method exports the orders into a text file
	 * @param event ActionEvent when user presses export orders button
	 */
	@FXML
	private void exportOrders(ActionEvent event) {
		
		try {
		      FileWriter myWriter = new FileWriter("store_orders.txt");
		      myWriter.write("{");
		      for (int j = 0; j < storeOrder.getOrderList().size(); j++) {
		    	    Order order = storeOrder.getOrderList().get(j);
					myWriter.write("\n" + order.getOrderNumber() + ":");
					myWriter.write(" {");
					myWriter.write(" 'SalesTotal:' " + order.getSalesTotal());
					myWriter.write(" , 'SalesTax:' " + order.getSalesTax());
					myWriter.write(" , 'Total:' " + order.getTotal());
					myWriter.write(" , 'Pizzas:' {") ;
					for (int i = 0; i<order.getPizzaList().size(); i++ ) {
						Pizza pizza = order.getPizzaList().get(i);
						if (i == order.getPizzaList().size() - 1) {
							myWriter.write(pizza.toString() + " ") ;
						} else {
							myWriter.write(pizza.toString() + " , ") ;	
						}			
					}
					myWriter.write(" }") ;	
					if (j == storeOrder.getOrderList().size() - 1) {
						myWriter.write(" }");
					} else {
						myWriter.write(" },");	
					}
				}
		      
			  myWriter.write("\n}");
		      myWriter.close();
		      
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information");
				alert.setHeaderText("Export");
				alert.setContentText("Store orders exported to store_orders.txt");
				alert.showAndWait().ifPresent(rs -> {
				    if (rs == ButtonType.OK) { }
				});
		      
		    } catch (IOException e) {
		      System.out.println("Unable to create file store_orders.txt");
		      e.printStackTrace();
		    }
	}
}