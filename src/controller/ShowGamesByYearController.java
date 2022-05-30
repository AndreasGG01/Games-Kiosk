package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import model.Game;
import model.Genre;
import model.Kiosk;

public class ShowGamesByYearController  extends Controller<Kiosk>{
    
    @FXML private TableView<Game> allGamesTv;
    @FXML private ListView<Integer> yearLv;
    @FXML private ObservableList<Game> gamesByYearLv;
    @FXML private ObservableList<Integer> yearOl;
    
    public void initialize() {
     yearOl = model.getCatalogue().getYears();
     yearLv.setItems(yearOl);
    }
    
    public final Kiosk getKiosk() {
        return model;
    }
    
    private Integer getYear() { return yearLv.getSelectionModel().getSelectedItem(); }
    
    @FXML private void closeShowGamesByYear(ActionEvent event) throws Exception {
        stage.close();
    }
    
    @FXML private void displayGames(ActionEvent event) throws Exception{
        Integer year = getYear();
        gamesByYearLv = model.getCatalogue().getGamesByYear(year);
        allGamesTv.setItems(gamesByYearLv);
    }
}
