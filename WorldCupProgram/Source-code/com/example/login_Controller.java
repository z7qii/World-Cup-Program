package com.example;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class login_Controller implements Initializable {
    
    
    private Model model = new Model();

    @FXML
    private Button button_login;

    @FXML
    private Button button_sign_up;

    @FXML
    private TextField tf_email;

    @FXML
    private PasswordField tf_password ;
    @FXML
    private Label notUser;


    @Override
    public void initialize(URL location, ResourceBundle resources) {            

        notUser.setOnMouseClicked(new EventHandler<MouseEvent>() {              // written text 
            @Override
            public void handle(MouseEvent event) {
               notUser.setTextFill(Color.RED);
            }
        });
        
        button_login.setOnAction(new EventHandler<ActionEvent>() {              // hits the login butto
            
            @Override
            public void handle(ActionEvent event) {
                
                boolean loggedIn;                                               // checking wither it is a staff
                if(tf_email.getText().contains("@staff.com")){
                    Staff staff = new Staff();
                    staff.setEmail(tf_email.getText());
                    staff.setPassword(tf_password.getText());
                    loggedIn = staff.login();

                    if(loggedIn){
                        model.setStaff(staff);                                  // changing the scene to staff home page
                        
                        Scene_Controller.changeScene(event, "/fxml/staff_choose_match.fxml", "Home page" );
                    }

                }else{

                    Customer customer = new Customer() ;
                    customer.setEmail(tf_email.getText());
                    customer.setPassword(tf_password.getText());
                    loggedIn = customer.login();

                    if(loggedIn){

                        model.setCustomer(customer);
                        Scene_Controller.changeScene(event, "/fxml/cusHomePage.fxml", "Home page" );
                    }
                    
                }
                
                if(!loggedIn){                                                  // if the information is not correct 
                    
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("The provided credentials are incorrect !");
                    alert.show();
                }
                
            }
            
        });
        
        button_sign_up.setOnAction(new EventHandler<ActionEvent>() {        // sign up page 

            @Override
            public void handle(ActionEvent event) {
                
                Scene_Controller.changeScene(event, "/fxml/sign_up.fxml", "Sign Up");
                
            }
            
        });
  
    }

}