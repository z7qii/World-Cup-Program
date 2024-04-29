package com.example;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ResourceBundle;

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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class seats_layout_Controller implements Initializable{

    private Model model = new Model();
    @FXML
    private Label label_date;
    @FXML
    private Label team1Name;
    @FXML
    private Label team2Name;
    @FXML
    private Button button_back;
    @FXML
    private ImageView team1Flag;
    @FXML
    private ImageView team2Flag;
    @FXML
    private List<Button> seatsList  ;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setPage();
       
        for(int  i  = 0 ; i < seatsList.size() ; i++){
            final int index = i;
                
            seatsList.get(i).setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {                     // this is for checking the set availability
                    if(model.getCustomer().checkSeatAvailability(model.getChosenMatch(),seatsList.get(index).getId())){
                        model.setChosenSeat(seatsList.get(index).getId());
                        Scene_Controller.changeScene(event, "/fxml/BoockingConfirmation.fxml", "Seats");
                    }else{
                        showAlert("Seat not available");
                    }            
                    
                }
                
            });
        }
        
        button_back.setOnAction(new EventHandler<ActionEvent>() {               // this is for going back to the home page

            @Override
            public void handle(ActionEvent event) {
                Scene_Controller.changeScene(event, "/fxml/cusHomePage.fxml", "Home page");
                
            }
            
        });
    }




    private void setPage(){                                 // this for seting the choosen match page 

        int chosenMatchID = model.getChosenMatchID();
        Match match = WorldCup.getMatchInfo(chosenMatchID);
        Image image1 = new Image(match.getTeam1Flag());
        Image image2 = new Image(match.getTeam2Flag());
        label_date.setText(match.getDate());
        team1Name.setText(match.getTeam1());
        team2Name.setText(match.getTeam2());
        team1Flag.setImage(image1);
        team2Flag.setImage(image2);

        String chosenMatch = model.getChosenMatch();

        for(int i = 0 ; i < seatsList.size() ; i++){
            
            if(model.getCustomer().checkSeatAvailability(chosenMatch, seatsList.get(i).getId() ))
                seatsList.get(i).setStyle("-fx-background-color:  #FED700;");   // Availability color yellow 
            else
                seatsList.get(i).setStyle(" -fx-background-color: #FF5056");    // Not availability color red 
        }
    }

    private void showAlert(String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.show();
    }

}
