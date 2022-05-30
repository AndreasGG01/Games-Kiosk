package controller;
import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.Customer;
import model.Kiosk;

public class KioskController extends Controller<Kiosk> {

   
    
  @FXML
  public void initialize() {

  }
  
  public final Kiosk getKiosk() {
        return model;
    }
 
  @FXML private void handleOpenAdmin(ActionEvent event) throws Exception {
        ViewLoader.showStage(model, "/view/Admin.fxml", "Administration Menu", new Stage());
    }
  
  @FXML private void handleOpenCatalogue(ActionEvent event) throws Exception {
        ViewLoader.showStage(model, "/view/Catalogue.fxml", "Catalogue", new Stage());
    }
  @FXML private void exitKiosk(ActionEvent event) throws Exception {
        stage.close();
    }
   @FXML private void handleOpenFavouriteGames(ActionEvent event) throws Exception {
        ViewLoader.showStage(model, "/view/FavouriteGames.fxml", "Favourite Games", new Stage());
    }
   @FXML private void handleOpenCustomerRecord(ActionEvent event) throws Exception {
        ViewLoader.showStage(model, "/view/CustomerRecord.fxml", "Customer Record", new Stage());
    }
   
   @FXML private void handleOpenTopUpAccount(ActionEvent event) throws Exception {
        ViewLoader.showStage(model, "/view/TopUpAccount.fxml", "Account Top-up", new Stage());
    }
}
