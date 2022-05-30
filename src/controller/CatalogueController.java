
package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.Catalogue;
import model.Kiosk;

public class CatalogueController extends Controller<Kiosk>{
    
    @FXML
  public void initialize() {

  }
  
  public final Kiosk getKiosk() {
        return model;
    }
  
  @FXML private void openShowAllGames(ActionEvent event) throws Exception {
        ViewLoader.showStage(model, "/view/ShowAllGames.fxml", "All Games", new Stage());
    }
  
  @FXML private void openShowAvailableGames(ActionEvent event) throws Exception {
        ViewLoader.showStage(model, "/view/ShowAvailableGames.fxml", "Available Games", new Stage());
    }
  
  @FXML private void closeCatalogue(ActionEvent event) throws Exception {
        stage.close();
    }
  
  @FXML private void openRentGame(ActionEvent event) throws Exception {
        ViewLoader.showStage(model, "/view/RentGame.fxml", "Rent a Game", new Stage());
    }
  @FXML private void openReturnGame(ActionEvent event) throws Exception {
        ViewLoader.showStage(model, "/view/ReturnGame.fxml", "Return a Game", new Stage());
    }
  @FXML private void openShowGamesByGenre(ActionEvent event) throws Exception {
        ViewLoader.showStage(model, "/view/ShowGamesByGenre.fxml", "Games by Genre", new Stage());
    }
  @FXML private void openShowGamesByYear(ActionEvent event) throws Exception {
        ViewLoader.showStage(model, "/view/ShowGamesByYear.fxml", "Games by Year", new Stage());
    }
}
