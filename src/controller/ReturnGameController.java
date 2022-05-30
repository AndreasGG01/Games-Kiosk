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

public class ReturnGameController extends Controller<Kiosk> {
    @FXML private TableView<Game> RentedGamesTv;
    @FXML private ObservableList<Game> RentedGamesLv;
    @FXML private TextField idTf;
    @FXML private Button returnGameBtn;
    @FXML private Button selectCustomerBtn;
    @FXML private Text returnGameTxt;
    private int selectedID;
    
    public void initialize() {
       RentedGamesTv.getSelectionModel().selectedItemProperty().addListener((observable, oldGame, newGame) -> returnGameBtn.setDisable(getGame() == null));
       idTf.textProperty().addListener((observable, oldText, newText) -> selectCustomerBtn.setDisable(model.getCustomer(getID()) == null));
    }
    
    public final Kiosk getKiosk() {
        return model;
    }
    
    private final int getID() { return Integer.parseInt(idTf.getText()); }
    private Game getGame() { return RentedGamesTv.getSelectionModel().getSelectedItem(); }
    
    @FXML private void closeReturnGame(ActionEvent event) throws Exception {
        stage.close();
    }
    
    @FXML private void selectCustomer(ActionEvent event) throws Exception {
        RentedGamesLv = model.getCustomer(getID()).currentlyRented();
        RentedGamesTv.setItems(RentedGamesLv);
        selectedID = getID();
    }
    
    @FXML private void returnGame(ActionEvent event) throws Exception{
        Customer customer = model.getCustomer(selectedID);
        model.getCatalogue().returnGameFromCustomer(getGame(), customer);
        returnGameTxt.setText("Game Returned.");
    }
}
