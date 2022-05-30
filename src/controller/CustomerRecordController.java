
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

public class CustomerRecordController extends Controller<Kiosk> {
    @FXML private Button selectCustomerBtn;
    @FXML private TextField idTf;
    @FXML private TableView<Game> RentedGamesTv;
    @FXML private TableView<Game> RentedHistoryGamesTv;
    @FXML private ObservableList<Game> RentedGamesLv;
    @FXML private ObservableList<Game> RentedHistoryGamesLv;
    @FXML private Text customerTxt;
    @FXML private Customer selectedCustomer;
    
    @FXML
  public void initialize() {
      idTf.textProperty().addListener((observable, oldText, newText) -> selectCustomerBtn.setDisable(model.getCustomer(getID()) == null));
  }
    
    public final Kiosk getKiosk() {
        return model;
    }
    private final int getID() { return Integer.parseInt(idTf.getText()); }
    private final String getCustomer(){return model.getCustomer(getID()).toString(); }
    
    
    @FXML private void closeCustomerRecord(ActionEvent event) throws Exception {
        stage.close();
    }
    
    @FXML private void selectCustomer(ActionEvent event) throws Exception {
        selectedCustomer = model.getCustomer(getID());
        if(selectedCustomer != null){
            customerTxt.setText(getCustomer());
            RentedGamesLv = selectedCustomer.currentlyRented();
            RentedGamesTv.setItems(RentedGamesLv);
            RentedHistoryGamesLv = selectedCustomer.rentingHistory();
            RentedHistoryGamesTv.setItems(RentedHistoryGamesLv);
        }
    }
}
