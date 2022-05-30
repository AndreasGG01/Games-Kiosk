package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import model.Game;
import model.Kiosk;

public class ShowAllGamesController  extends Controller<Kiosk>{
    
     @FXML private TableView<Game> ShowAllGamesTv;
     
     @FXML
  public void initialize() {
  }
    
    public final Kiosk getKiosk() {
        return model;
    }
    
    @FXML private void closeShowAllGames(ActionEvent event) throws Exception {
        stage.close();
    }
}
