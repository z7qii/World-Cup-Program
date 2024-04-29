package com.example;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class viewStatics_Controller implements Initializable {
    private Model model = new Model();
    
    @FXML
    private Button button_back;
    @FXML
    private Label lbl_capacity;
    @FXML
    private Label lbl_soldOut;
    @FXML
    private Label lbl_revenue;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String chosenMatch = model.getChosenMatch();
        lbl_capacity.setText(model.getStaff().getCapacity(chosenMatch));
        lbl_soldOut.setText(model.getStaff().getSeatsSoldOut(chosenMatch));
        lbl_revenue.setText(Double.toString(model.getStaff().getRevenue(chosenMatch)));

        button_back.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Scene_Controller.changeScene(event, "/fxml/staff_view_seats.fxml", "View Seats");                
            }
            
        });
        
    }
     
}
