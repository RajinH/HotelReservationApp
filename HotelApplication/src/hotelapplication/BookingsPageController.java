/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelapplication;

import java.awt.Label;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author rajin
 */
public class BookingsPageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    // nav
    @FXML
    private Label lbl_view;
    @FXML
    private Label lbl_logOut;
    
    // basic info
    @FXML
    private ChoiceBox chb_suiteType;
    @FXML
    private DatePicker dp_checkIn;
    @FXML
    private DatePicker dp_checkOut;
    
    // extra info
    @FXML
    private CheckBox cb_beds;
    @FXML
    private CheckBox cb_breakfast;
    @FXML
    private CheckBox cb_wifi;
    @FXML
    private CheckBox cb_calls;
    
    // additional info
    @FXML
    private CheckBox cb_guests;
    @FXML
    private CheckBox cb_pets;
    
    // suite info
    @FXML
    private Label lbl_suiteHead;
    @FXML
    private TextArea ta_details;
    @FXML
    private Label lbl_totalCost;
    @FXML
    private CheckBox cb_terms;
    @FXML
    private Button btn_book;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
