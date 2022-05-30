
package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Kiosk;

public class AddCustomerController extends Controller<Kiosk>{
    
    @FXML private TextField idTf;
    @FXML private TextField nameTf;
    @FXML private TextField balanceTf;
    @FXML private Text customerTxt;
    
    @FXML
  public void initialize() {
  }
    
    public final Kiosk getKiosk() {
        return model;
    }
    
    private final int getID() { return Integer.parseInt(idTf.getText()); }
    private final String getName() { return nameTf.getText(); }
    private final int getBalance() { return Integer.parseInt(balanceTf.getText()); }
    private final void setID(int amount) {idTf.setText(""+amount); }
    private final void setName(String name) { nameTf.setText(name); }
    private final void setBalance(int amount) {balanceTf.setText(""+amount); }
    
    @FXML private void closeAddCustomer(ActionEvent event) throws Exception {
        stage.close();
    }
    
    @FXML private void handleAddCustomer(ActionEvent event) {   
            int id = getID();
            String name = getName();
            int balance = getBalance();
            if(model.getCustomer(getID()) == null){
                model.addCustomer(id, name, balance);
                customerTxt.setText("Customer added to Kiosk.");
            }
            else{
                customerTxt.setText("Customer Already Exists.");
            }
                
    }

}
