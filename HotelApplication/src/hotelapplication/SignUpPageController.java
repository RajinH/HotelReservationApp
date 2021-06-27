/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelapplication;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author rajin
 */
public class SignUpPageController implements Initializable {
    
    // Array of Users // 
    private ArrayList<User> users =  new ArrayList<User>();
    /**
     * Initializes the controller class.
     */
    
    // sign up page ui
    @FXML
    private TextField tf_firstname;
    @FXML
    private TextField tf_lastname;
    @FXML
    private TextField tf_username;
    @FXML
    private PasswordField pf_password;
    @FXML
    private PasswordField pf_confirmPassword;
    @FXML
    private TextField tf_mobile;
    @FXML
    private TextField tf_address;
    @FXML
    private CheckBox cb_terms;
    @FXML
    private Button btn_signUp;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void SignUp(ActionEvent event) {
        loadData();
        
        if(!(tf_firstname.getText().isEmpty()&&tf_lastname.getText().isEmpty()&&tf_username.getText().isEmpty()&&pf_password.getText().isEmpty()&&pf_confirmPassword.getText().isEmpty()&&tf_address.getText().isEmpty()&&tf_mobile.getText().isEmpty()&&!cb_terms.isSelected())){
            if(!(pf_password.getText().equals(pf_confirmPassword.getText()))){
                User user = new User(tf_firstname.getText(), tf_lastname.getText(), tf_username.getText(), pf_password.getText(), tf_address.getText(), tf_mobile.getText(), "Customer");
                users.add(user);
                saveData();
            } else {
                AlertBox.display("Error", "Passwords Do Not Match");
            }
        } else {
            AlertBox.display("Error", "Not Every Filed Is Filled");
        }
   
    } 
    private void saveData() {
        try{
            FileOutputStream fileOut = new FileOutputStream("Users.txt");
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(users);
            objOut.close();
            fileOut.close();
        } catch (IOException i){
            i.printStackTrace();
        }
    }
    
    private void loadData(){
        try{
            FileInputStream fileIn = new FileInputStream("Users.txt");
            ObjectInputStream objIn = new ObjectInputStream(fileIn);
            users = (ArrayList<User>)objIn.readObject();
            objIn.close();
            fileIn.close();        
        } catch (IOException i){
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c){
            c.printStackTrace();
            return;
        }   
    }
}
