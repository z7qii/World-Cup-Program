package com.example;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Set;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.layout.HBox;

public class simulationController implements Initializable {
    private Model model = new Model();
    private Stadium stadium = new Stadium(model.getChosenMatch());
    @FXML
    private Button btn_serve;
    @FXML
    private Label TicketsSoldatE1;
    @FXML
    private Label TicketsSoldatE2;
    @FXML
    private List<Label>columnsContainer;
    @FXML
    private Label entrence1;
    @FXML
    private Label entrence2;
    @FXML
    private Button button_back;
    private Map <String , Label > columns = new HashMap<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setTicketsSold();
        setEntrenceE1();
        setEntrenceE2();
        setColumns();
        entrence1.setText(stadium.getE1());
        entrence2.setText(stadium.getE2());
        btn_serve.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if(!stadium.isEmptyE1()){
                    String st1 = stadium.serveE1();
                    entrence1.setText(stadium.getE1());
                    columns.get(st1.substring(0, 2) + "Col").setText("X");
                }

                if(!stadium.isEmptyE2()){
                    String st2 = stadium.serveE2();
                    entrence2.setText(stadium.getE2());
                    columns.get(st2.substring(0, 2) + "Col").setText("X");
                }

                else if(stadium.isEmptyE1() && stadium.isEmptyE2()){
                    showAlert("All customers are served");
                }
            
                
                 
            }
            
        });

        button_back.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Scene_Controller.changeScene(event, "/fxml/staff_view_seats.fxml", "Matches");
                
            }
            
        });

        
    }

    

    

    private void setEntrenceE1(){
        ArrayList<String> TicketsSoldAtE1 = stadium.getTicketsSoldAtE1();

        Random rand = new Random();
        int index = 0;
        
        while(true){
            if(TicketsSoldAtE1.isEmpty())
                break;
            else{

                index = rand.nextInt(TicketsSoldAtE1.size());

                if(!stadium.e1Contains(TicketsSoldAtE1.get(index)))
                    stadium.addAtE1(TicketsSoldAtE1.get(index));

                else if(stadium.getE1Size() == TicketsSoldAtE1.size())
                    break;   
            }
                 
                
        }

    }
    private  void setEntrenceE2(){
        ArrayList<String> TicketsSoldAtE2 = stadium.getTicketsSoldAtE2();
        
        Random rand = new Random();
        int index = 0;
        
        while(true){
            if(TicketsSoldAtE2.isEmpty())
                break;
            else{

                index = rand.nextInt(TicketsSoldAtE2.size());

                if(!stadium.e2Contains(TicketsSoldAtE2.get(index)))
                    stadium.addAtE2(TicketsSoldAtE2.get(index));

                else if(stadium.getE2Size() == TicketsSoldAtE2.size())
                    break;

            }
            
            
            
        }
    
    }

     private  void setColumns(){
        for(int i = 0 ; i < columnsContainer.size() ; i++)
            columns.put(columnsContainer.get(i).getId(), columnsContainer.get(i));
        
     }

     private void showAlert(String message){

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.show();
    }

   

     private void setTicketsSold() {
        
        TicketsSoldatE1.setText(stadium.TicketsSoldAtE1ToString());
        TicketsSoldatE2.setText(stadium.TicketsSoldAtE2ToString());
    }
    
}
