package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import model.Customer;
import model.Kiosk;

public class ShowAllCustomersController extends Controller<Kiosk>{
     public final Kiosk getKiosk() {
        return model;
    }
    
    @FXML private TableView<Customer> customersTv;
    
    @FXML private void closeShowAllCustomers(ActionEvent event) throws Exception {
        stage.close();
    }

}
