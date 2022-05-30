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

public class ShowGamesByGenreController extends Controller<Kiosk>{
    @FXML private TableView<Game> allGamesTv;
    @FXML private ListView<Genre> genreLv;
    @FXML private ObservableList<Game> gamesByGenreLv;
    @FXML private ObservableList<Genre> GenreOl;
    
    public void initialize() {
     GenreOl = model.getCatalogue().getGenres();
     genreLv.setItems(GenreOl);
    }
    
    public final Kiosk getKiosk() {
        return model;
    }
    
    private Genre getGenre() { return genreLv.getSelectionModel().getSelectedItem(); }
    
    @FXML private void closeShowGamesByGenre(ActionEvent event) throws Exception {
        stage.close();
    }
    
    @FXML private void displayGames(ActionEvent event) throws Exception{
        Genre genre = getGenre();
        gamesByGenreLv = model.getCatalogue().getGamesInGenre(genre);
        allGamesTv.setItems(gamesByGenreLv);
    }

}
