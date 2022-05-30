package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.Kiosk;

public class AdminController extends Controller<Kiosk> {
    
    @FXML
  public void initialize() {

  }
  
  public final Kiosk getKiosk() {
        return model;
    }
  
     
    @FXML private void exitAdmin(ActionEvent event) throws Exception {
        stage.close();
    }
    
    @FXML private void openAddCustomer(ActionEvent event) throws Exception {
        ViewLoader.showStage(model, "/view/AddCustomer.fxml", "Add Customer", new Stage());
    }
    
    @FXML private void openAddGame(ActionEvent event) throws Exception {
        ViewLoader.showStage(model, "/view/AddGame.fxml", "Add Game", new Stage());
    }
    
    @FXML private void openRemoveCustomer(ActionEvent event) throws Exception {
        ViewLoader.showStage(model, "/view/RemoveCustomer.fxml", "Remove Customer", new Stage());
    }
    
    @FXML private void openRemoveGame(ActionEvent event) throws Exception {
        ViewLoader.showStage(model, "/view/RemoveGame.fxml", "Remove Game", new Stage());
    }
    
    @FXML private void openShowAllGames(ActionEvent event) throws Exception {
        ViewLoader.showStage(model, "/view/ShowAllGames.fxml", "All Games", new Stage());
    }
    
    @FXML private void openShowAllCustomers(ActionEvent event) throws Exception {
        ViewLoader.showStage(model, "/view/ShowAllCustomers.fxml", "All Customers", new Stage());
    }
}
