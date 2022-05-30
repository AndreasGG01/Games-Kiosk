package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Customer;
import model.Game;
import model.Kiosk;

public class RentGameController extends Controller<Kiosk>{
    
    @FXML private TableView<Game> availableGamesTv;
    @FXML private ObservableList<Game> availableGamesLv;
    @FXML private TextField idTf;
    @FXML private Button rentGameBtn;
    @FXML private Button selectCustomerBtn;
    @FXML private Text rentGameTxt;
    
    private int selectedID;
        
    public void initialize() {
       availableGamesTv.getSelectionModel().selectedItemProperty().addListener((observable, oldGame, newGame) -> rentGameBtn.setDisable(getGame() == null));
       idTf.textProperty().addListener((observable, oldText, newText) -> selectCustomerBtn.setDisable(model.getCustomer(getID()) == null));
    }
    
    public final Kiosk getKiosk() {
        return model;
    }
    
    private final int getID() { return Integer.parseInt(idTf.getText()); }
    private Game getGame() { return availableGamesTv.getSelectionModel().getSelectedItem(); }
    
    @FXML private void closeRentGame(ActionEvent event) throws Exception {
        stage.close();
    }
    
    @FXML private void selectCustomer(ActionEvent event) throws Exception {
        availableGamesLv = model.getCatalogue().getAvailableGames();
        availableGamesTv.setItems(availableGamesLv);
        selectedID = getID();
    }
    
    @FXML private void rentGame(ActionEvent event) throws Exception {
        Customer customer = model.getCustomer(selectedID);
        model.getCatalogue().rentGameToCustomer(getGame(), customer);
        rentGameTxt.setText("Game Rented.");
    }
    
}
