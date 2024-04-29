package com.example;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BoockingConfirmationController implements Initializable{
    private Model model = new Model();
    @FXML
    private Label label_date;
    @FXML
    private Label team1Name;
    @FXML
    private Label team2Name;
    @FXML
    private Label seatId;
    @FXML
    private ImageView team1Flag;
    @FXML
    private ImageView team2Flag;
    @FXML
    private Button proceed;
    @FXML
    private Button button_back;
    @FXML
    private Label price;
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
        setPage();
        price.setText(model.getCustomer().getPrice(model.getChosenMatch(), model.getChosenSeat()) + "$");


        proceed.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Scene_Controller.changeScene(event, "/fxml/payment.fxml", "Payment");
                
            }
            
        });

        button_back.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Scene_Controller.changeScene(event, "/fxml/seats_layout.fxml", "Seats");
                
            }
            
        });


    }

    private void setPage(){

        int chosenMatchID = model.getChosenMatchID();
        Match match = WorldCup.getMatchInfo(chosenMatchID);
        Image image1 = new Image(match.getTeam1Flag());
        Image image2 = new Image(match.getTeam2Flag());
        label_date.setText(match.getDate());
        team1Name.setText(match.getTeam1());
        team2Name.setText(match.getTeam2());
        team1Flag.setImage(image1);
        team2Flag.setImage(image2);
        seatId.setText(model.getChosenSeat());

    }


}
