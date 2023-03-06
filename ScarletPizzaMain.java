package scarletpizza;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

/**
 * this class is the ScarletPizza main controller
 * @author Selin Altiparmak, Libby Birenboim
 */
public class ScarletPizzaMain extends Application {
	
	/**
	 * this method starts the stage window
	 * @param primaryStage Stage
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("MainView.fxml"));
			Scene scene = new Scene(root,645,450);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setOnHiding(new EventHandler<WindowEvent>() {

				/**
				 * this method handles the window
				 * @param event WindowEvent
				 */
		         @Override
		         public void handle(WindowEvent event) {
		             Platform.runLater(new Runnable() {

		            	 /**
		            	  * this method runs the stage program
		            	  */
		                 @Override
		                 public void run() {
		                	 try {
		                		 Stage s = (Stage)event.getSource();
		                		 if (!s.getTitle().equals("Main View")) {
		                			 mainMenu(event);	 
		                		 } else {
		                			 Platform.exit();
		                		 }
		                		 
							} catch (Exception e) {
								//e.printStackTrace();
							}
		                 }
		             });
		         }
		     });
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * this method creates the main menu for the program
	 * @param event WindowEvent
	 * @throws IOException
	 */
    @FXML
    public void mainMenu(WindowEvent event) throws IOException {
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("MainView.fxml"));
		Stage stage = (Stage)event.getSource();
		Scene scene = new Scene(root,645,450);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setTitle("Main View");
		stage.setScene(scene);
		stage.show();

    }
	
    /**
     * this method is the main method that launches the program
     * @param args String[] array
     */
	public static void main(String[] args) {
		launch(args);
	}
}
