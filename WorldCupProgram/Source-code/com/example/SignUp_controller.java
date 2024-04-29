package com.example;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import com.example.Customer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class SignUp_controller implements Initializable {

    @FXML
    private Button button_back;
    @FXML
    private Button button_signup;
    
    @FXML
    private Button button_log_in;

    @FXML
    private TextField tf_email;

    @FXML
    private PasswordField tf_password ;

    @FXML
    private TextField tf_name;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        button_signup.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                
                if(!tf_email.getText().trim().isEmpty() && !tf_password.getText().trim().isEmpty()){    // checing of the email & password fileds
                    String validatePassword = isValidPassword(tf_password.getText());                   // validating the password
                    if(!isValidEmail(tf_email.getText())){
                                                                                                        // checking the email validation
                        showAlert("In Valid Email!");

                    }else if(!validatePassword.equals("valid")){
                                                                                                        // checking the password validation
                       showAlert(validatePassword);

                    }else{
                        
                        Customer customer = new Customer(tf_name.getText(), tf_email.getText(), tf_password.getText());
                        
                        if(customer.signUp()){                                                          // checking the account existence
                            Scene_Controller.changeScene(event, "/fxml/login.fxml", "Login");
                        }else{
                            showAlert("Account already exists !");
                        }
                    }
                    
                    
                    
                } else{
                    showAlert("Please fill in all information to sign up!");
                }
                
            }
            
        });

        button_log_in.setOnAction(new EventHandler<ActionEvent>() {                                     // login page 

            @Override
            public void handle(ActionEvent event) {
                // TODO Auto-generated method stub
                Scene_Controller.changeScene(event , "/fxml/login.fxml" , "Log in!");
            }
            
        });

        button_back.setOnAction(new EventHandler<ActionEvent>() {                                       // login page 

            @Override
            public void handle(ActionEvent event) {
                Scene_Controller.changeScene(event , "/fxml/login.fxml" , "Log in");
                
            }
            
        });

        
        
    }

    private boolean isValidEmail(String email){                                                         // cheking the email context 
        if(email.contains("@staff")) return false;
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";
                              
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    private String isValidPassword (String password){                                                   // checking the password content
      boolean checkValidity = true;
      int passwordLength=8, upChars=0, lowChars=0;
      int special=0, digits=0;
      char ch;
      
      int total = password.length();
      if(total<passwordLength) return "password length must be at least 8 charactrs";
      
      else
      {
         for(int i=0; i<total; i++)
         {
            ch = password.charAt(i);
            if(Character.isUpperCase(ch))
               upChars = 1;
            else if(Character.isLowerCase(ch))
               lowChars = 1;
            else if(Character.isDigit(ch))
               digits = 1;
            else
               special = 1;
         }
      }
      if(upChars!=1) return "passwrd must contain at least 1 uppercase letter";
      else if(lowChars!=1) return "password must contain at least 1 lowercase leeter";
      else if( digits!=1) return "password must contain at least 1 digit";
      else if(special!=1) return "password msut contain at least 1 special character";
         
      return "valid";
    }

    private void showAlert(String message){
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.show();

    }
    
}
