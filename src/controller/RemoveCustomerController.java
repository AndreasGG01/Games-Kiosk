package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import model.Customer;
import model.Kiosk;

public class RemoveCustomerController extends Controller<Kiosk>{
    
    @FXML private TableView<Customer> customersTv;
    @FXML private ObservableList<Customer> customersLv;
    
    public void initialize() {
        customersLv = model.getCustomers();
        customersTv.setItems(customersLv);
    }
    
    
    public final Kiosk getKiosk() {
        return model;
    }
    
    private Customer getCustomer() { return customersTv.getSelectionModel().getSelectedItem(); }
    
    @FXML private void closeRemoveCustomer(ActionEvent event) throws Exception {
        stage.close();
    }
    
    @FXML private void handleRemoveCustomer(ActionEvent event) {   
                model.removeCustomer(getCustomer());           
    }
    
}
