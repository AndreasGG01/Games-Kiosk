package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import model.Catalogue;
import model.Customer;
import model.Game;
import model.Kiosk;

public class RemoveGameController extends Controller<Kiosk> {
    
    public void initialize() {
        gamesLv = model.getCatalogue().getAvailableGames();
        gamesTv.setItems(gamesLv);
    }
    
    public final Kiosk getKiosk() {
        return model;
    }
    
    @FXML private TableView<Game> gamesTv;
    @FXML private ObservableList<Game> gamesLv;
    
    private Game getGame() { return gamesTv.getSelectionModel().getSelectedItem(); }
    
    @FXML private void closeRemoveGame(ActionEvent event) throws Exception {
        stage.close();
    }
    
    @FXML private void handleRemoveGame(ActionEvent event) {   
                model.getCatalogue().removeGame(getGame());           
    }

}
