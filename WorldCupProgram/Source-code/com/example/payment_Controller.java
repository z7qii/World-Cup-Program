package com.example;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.cusHomePage_Controller;
import com.example.login_Controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class payment_Controller implements Initializable {
    private Model model = new Model();
    @FXML
    private AnchorPane Ap_mainParent;
    @FXML
    private Button button_checkOut;
    @FXML
    private Button button_back;
    @FXML
    private Label label_price;
    @FXML
    private TextField tf_cardNumber;
    @FXML
    private TextField tf_cvv;
    @FXML
    private TextField tf_name;
    @FXML
    private DatePicker tf_date;
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
        setTotalPrice();

        button_checkOut.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                if(!tf_name.getText().trim().isEmpty() && !tf_cardNumber.getText().trim().isEmpty() && !tf_cvv.getText().trim().isEmpty()){

                    if(!isValid(tf_cardNumber)){

                        showAlert("In valid card number!");

                    }else if(!isValid(tf_cvv) ){

                        showAlert("In valid cvv number!");

                    }else{
                           
                        model.getCustomer().bookTicket(model.getChosenMatch(), model.getChosenSeat());
                        showAlert("ticket purchased successfully");
                
                    }
                    
                }else{
                    
                    showAlert("Please fill in all information !");
                }
                
            }
            
        });

        button_back.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Scene_Controller.changeScene(event, "/fxml/BoockingConfirmation.fxml", "Seats");
                
            }
            
        });
        
    }

    private boolean isValid(TextField cardNumber){

        boolean isvalid = true;
        if(cardNumber.getId().equals(tf_cardNumber.getId()) && cardNumber.getLength() != 16) isvalid = false;
        if(cardNumber.getId().equals(tf_cvv.getId()) && cardNumber.getLength() != 3) isvalid = false;
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(cardNumber.getText());
        boolean isStringContainsSpecialCharacter = matcher.find();

        if(containsLetter(cardNumber.getText()) || isStringContainsSpecialCharacter || cardNumber.getText().contains(" ") ) isvalid = false;

        return isvalid;
            
    }

   
    private boolean containsLetter(String st){
        boolean valid = false;
        for (char ch : st.toCharArray()) {
            if (Character.isLetter(ch)) {
              valid = true;
              
            }
        }
        return valid;
    }

    private void setTotalPrice(){
        label_price.setText(model.getCustomer().getPrice(model.getChosenMatch(), model.getChosenSeat()) + "$");
    }

    private void showAlert(String message){

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.show();
    }

   
    
}
