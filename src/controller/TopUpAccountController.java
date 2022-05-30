package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Kiosk;

public class TopUpAccountController  extends Controller<Kiosk>{
   
    @FXML private TextField idTf;
    @FXML private TextField TopUpAmountTf;
    @FXML private Text completeTxt;
    @FXML private Button topUpBtn;
    
    @FXML
  public void initialize() {
      idTf.textProperty().addListener((observable, oldText, newText) -> topUpBtn.setDisable(model.getCustomer(getID()) == null));
  }
    
    public final Kiosk getKiosk() {
        return model;
    }
    private final int getID() { return Integer.parseInt(idTf.getText()); }
    private final int getTopUpAmount() { return Integer.parseInt(TopUpAmountTf.getText()); }
    private final void setID(int amount) {idTf.setText(""+amount); }
    private final void setTopUpAmmount(int amount) { TopUpAmountTf.setText(""+amount); }
    
    @FXML private void closeTopUpAccount(ActionEvent event) throws Exception {
        stage.close();
    }
    
    @FXML private void handleTopUp(ActionEvent event) {
        int amount = getTopUpAmount();
        if(model.getCustomer(getID()) != null){        
            if(getTopUpAmount() > 0){
                model.getCustomer(getID()).topUpAccount(amount);
                setID(0);
                setTopUpAmmount(0);
                completeTxt.setText("Transaction Complete.");
            }
            else{
                completeTxt.setText("Topup amount must be larger than 0.");
            }
        }
        else{
            completeTxt.setText("Customer does not exist.");
        }
    }
}
