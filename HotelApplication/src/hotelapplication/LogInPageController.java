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
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author rajin
 */
public class LogInPageController implements Initializable {
    
    // Array of Users //
    private ArrayList<User> users =  new ArrayList<User>();
    /**
     * Initializes the controller class.
     */
    
    // log in ui
    @FXML
    private TextField tf_username;
    @FXML
    private PasswordField pf_password;
    @FXML
    private Button btn_logIn;
    @FXML
    private Label lbl_signUp;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private void logIn(MouseEvent event) throws IOException {
        loadData();
        
        // load data
        loadData();
        
        if (users.isEmpty()){
            // if array is empty
            System.out.println("User Array is Empty");
            AlertBox.display("Error", "No Users Exist");
        } else {
            // go through all the usernames to make sure they exist
            for(int i = 0; i<users.size(); i++){
                // has username in the database
                if((tf_username.getText()).equals(users.get(i).getUsername())){
                    System.out.println(users.get(i).getUsername());
                    // has password matched
                    if((pf_password.getText()).equals(users.get(i).getPassword())){
                        // log in
                        AlertBox.display("Successfully Logged In", "Logged In");
                        // stores the current user as the logged in user
                        HotelApplication.user = users.get(i);
                        System.out.println("User Now: "+HotelApplication.user.getFirstname());
                        goToBooking();
                        
                    } else {
                        AlertBox.display("Error Log In", "Password Does Not Match");
                    }
                    break;
                } else if (i==users.size()-1) {
                    AlertBox.display("Error Log In", "Username Does Not Exist");   
                }
            }
        }
        
        System.out.println("Arary Size: " + users.size());
    }
    
    @FXML
    private void goToBooking() throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("BookingsPage.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) btn_logIn.getScene().getWindow();
        stage.setTitle("Make a Booking");
        stage.setResizable(false);
        stage.hide();
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void goToSignUp(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("SignUpPage.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Sign Up");
        stage.setResizable(false);
        stage.hide();
        stage.setScene(scene);
        stage.show();
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
