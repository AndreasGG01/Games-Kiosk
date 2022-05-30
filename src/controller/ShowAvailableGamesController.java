package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import model.Game;
import model.Kiosk;

public class ShowAvailableGamesController extends Controller<Kiosk>{
    @FXML private TableView<Game> availableGamesTv;
    @FXML private ObservableList<Game> availableGamesLv;
     
     @FXML
  public void initialize() {
     availableGamesLv = model.getCatalogue().getAvailableGames();
     availableGamesTv.setItems(availableGamesLv);
  }
    
    public final Kiosk getKiosk() {
        return model;
    }
    
    @FXML private void closeShowAvailableGames(ActionEvent event) throws Exception {
        stage.close();
    }
}
