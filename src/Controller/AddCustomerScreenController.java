
package Controller;

import DAO.DBCountries;
import DAO.DBCustomers;
import DAO.DBDivisions;
import Model.Country;
import Model.Customer;
import Model.FirstLevelDivision;
import Utils.SceneChanger;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 FXML Add Customer Screen Controller class
 @author Sean
 */
public class AddCustomerScreenController implements Initializable {

    @FXML private TextField nameField;
    @FXML private TextField addressField;
    @FXML private TextField postalField;
    @FXML private TextField phoneField;
    @FXML private ComboBox<Country> countryField;
    @FXML private ComboBox<FirstLevelDivision> divisionField;
    
    @FXML private Label errorTextField;
    
    /**
     Called to initialize the Add Customer controller class after its root element has been completely processed. 
     Initializes a combo box with data pertaining to Country objects.
     @param url The location used to resolve relative paths for the root object, or null if the location is not known.
     @param rb The resources used to localize the root object, or null if the root object was not localized. 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        countryField.setItems(DBCountries.getAllCountries());
        
    }
    
    /**
     This method is responsible for filtering the selection of First Level divisions (states, provinces, etc) in the divisionField.
     Selection of a given country will filter the divisionField to only show First level divisions associated with it. For example, choosing "U.S"
     for country will populate the divisionField with U.S states, but no Canadian provinces will be displayed. LAMBDA: This lambda expression is justified
     by the need to filter the list of all FirstLevelDivisions to only include those FirstLevelDivisions from the specified Country. This lambda expression
     filters out any FirstLevelDivisions that are not apart of or associated with the specified Country.
     @param event the event representing the change or action made to the ComboBox countryField.
     @throws IOException the potential IOException that must be caught or declared to be thrown.
     */
    public void countryChangedHandler(ActionEvent event) throws IOException {
        
        List<FirstLevelDivision> divs = DBDivisions.getAllDivisions().stream()
                                                                     .filter(d -> d.getCountryId() == countryField.getSelectionModel().getSelectedItem().getId())
                                                                     .collect(Collectors.toList());
      
        ObservableList<FirstLevelDivision> filteredDivs = FXCollections.observableArrayList(divs);
        divisionField.setItems(filteredDivs);
        
    }
    
    /**
     This method handles the Save button for this screen being pressed. First, the validateNewCustomer method ensures that all the appropriate data fields
     have been completed appropriately. Next, the new Customer object is generated from the data fields filled out by the user. This customer is then
     saved to the database, and the screen changes back to the main screen.
     @param event the event object representing the Save button being pressed.
     @throws IOException the potential IOException that must be caught or declared to be thrown.
     @throws SQLException the potential SQLException that must be caught or declared to be thrown.
     */
    public void saveButtonHandler(ActionEvent event) throws IOException, SQLException {
        if (!validateNewCustomer()) return; // if fields !valid, do not continue.
        
        // create new customer. Intentionally blank/null ID
        Customer newCustomer = new Customer(nameField.getText(),
                                            addressField.getText(),
                                            postalField.getText(),
                                            phoneField.getText(),
                                            countryField.getValue(),
                                            divisionField.getValue());
        
        // Add customer to DB
        DBCustomers.addCustomer(newCustomer);
        
        SceneChanger sc = new SceneChanger();
        sc.changeSceneTo(event, "/View/MainScreen.fxml");
    }
    
    /**
     This button handles the Cancel button being pressed, sending the user from this screen back to the main screen.
     @param event the event object presenting the Cancel button being pressed.
     @throws IOException the potential IOException that must be caught or declared to be thrown.
     */
    public void cancelButtonHandler(ActionEvent event) throws IOException {
        SceneChanger sc = new SceneChanger();
        sc.changeSceneTo(event, "/View/MainScreen.fxml");
    }
    
    /**
     This helper method checks if a parameter String s is a number or contains numbers. Used by the validateFields method to check the TextFields of the screen.
     @param s the String to check for if it is a number or contains numbers.
     @return true the return value returned if none of the parameter's characters are digits.
     */
    public boolean isNumber(String s) {
        //loop through the input String's characters
        for (int i = 0; i < s.length(); i++) {
            
            if (Character.isDigit(s.charAt(i)) == false) return false;
            
        }
        //returns true only if none of the String's characters are digits
        return true;
    }
    
    /**
     This method ensures the user has correctly completed all data fields for the new Customer object being created on this screen.
     The method contains several 'checks,' each checking a data field to ensure it contains appropriate data for that field. If any of these
     checks do not pass, the user will be notified by a text label and this method will return false. If all data fields are correctly filled out,
     this method returns true.
     @return true the return value returned by this method if all customer data fields are valid. Otherwise, returns false.
     */
    public boolean validateNewCustomer() {
        // check each field is valid input, top to bottom
        if (nameField.getText().isBlank() ||
            isNumber(nameField.getText()) ||
            (!nameField.getText().trim().matches("^[a-zA-Z\\s]+$"))) { // spaces only allowed
            
            errorTextField.setText("Name field input invalid");
            return false;
            
        } else if (addressField.getText().isBlank() ||
                   isNumber(addressField.getText())) {
            
            errorTextField.setText("Address field input invalid");
            return false;
            
        } else if (postalField.getText().isBlank()) {
            errorTextField.setText("Postal code field input invalid");
            return false;
        } else if (phoneField.getText().isBlank()) {
            errorTextField.setText("Phone number field input invalid");
            return false;
        } else if (countryField.getSelectionModel().isEmpty()) {
            errorTextField.setText("Please select a country");
            return false;
        } else if (divisionField.getSelectionModel().isEmpty()) {
            errorTextField.setText("Please select a state/province");
            return false;
        }
        return true; // all fields valid
    }
    
}
