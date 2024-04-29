package com.example;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Staff_view_seat_Controller implements Initializable {

    private Model model = new Model();
    @FXML
    private Button button_back;
    @FXML
    private TableColumn<Seat, String> email_Col;

    @FXML
    private TableColumn<Seat, String> name_Col;

    @FXML
    private TableColumn<Seat, String> price_Col;

    @FXML
    private TableColumn<Seat, String> seatID_Col;

    @FXML
    private TableView<Seat> table;
    @FXML
    Button btn_simulation;

    @FXML
    Button btn_statics;
   

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        email_Col.setCellValueFactory(new PropertyValueFactory<Seat , String>("email"));
        seatID_Col.setCellValueFactory(new PropertyValueFactory<Seat , String>("seatID"));
        price_Col.setCellValueFactory(new PropertyValueFactory<Seat , String>("seatPrice"));
        name_Col.setCellValueFactory(new PropertyValueFactory<Seat , String>("name"));
        
        ObservableList<Seat> list = model.getStaff().viewSeats(model.getChosenMatch());
        

        table.setItems(list);

        button_back.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Scene_Controller.changeScene(event, "/fxml/staff_choose_match.fxml", "Matches");
                
            }
            
        });


       btn_statics.setOnAction(new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent event) {
            Scene_Controller.changeScene(event , "/fxml/viewStatics.fxml" , "statics");
            
        }
        
       });

       btn_simulation.setOnAction(new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent event) {
            
            Scene_Controller.changeScene(event , "/fxml/queueSimulation.fxml" , "statics");
            
        }
        
       });
        
    }

}
