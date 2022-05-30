
package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Kiosk;

public class AddGameController  extends Controller<Kiosk>{
    
    @FXML private TextField titleTf;
    @FXML private TextField yearTf;
    @FXML private TextField genreTf;
    @FXML private TextField priceTf;
    @FXML private Text gameTxt;
    
    @FXML
  public void initialize() {
  }
    
    public final Kiosk getKiosk() {
        return model;
    }
    
    private final String getTitle() { return titleTf.getText(); }
    private final int getYear() { return Integer.parseInt(yearTf.getText()); }
    private final String getGenre() { return genreTf.getText(); }
    private final int getPrice() { return Integer.parseInt(priceTf.getText()); }
    private final void setTitle(String title) {titleTf.setText(title); }
    private final void setYear(int year) { yearTf.setText(""+year); }
    private final void setGenre(String genre) {genreTf.setText(genre); }
    private final void setBalance(int price) {priceTf.setText(""+price); }
    
    @FXML private void closeAddGame(ActionEvent event) throws Exception {
        stage.close();
    }
    
    @FXML private void handleAddGame(ActionEvent event) {   
            if(model.getCatalogue().hasGame(getTitle(), getYear()) == false){
                model.getCatalogue().addGame(getTitle(), getYear(), getGenre(), getPrice());
                gameTxt.setText("Game added to Catalogue.");
            }
            else{
                gameTxt.setText("Game Already Exists.");
            }
                
    }

}
