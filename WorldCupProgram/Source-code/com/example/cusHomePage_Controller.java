package com.example;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.ListChangeListener.Change;
import javafx.css.Match;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class cusHomePage_Controller implements Initializable {
    private Model model = new Model();
    
    @FXML
    private Button button_back;
    @FXML
    private List<Label> labelList ;
    @FXML
    private List<ImageView> imageList ;
    @FXML
    private List<Label> dateList ;
    @FXML
    private List<Button> buttonsList;
    
   

   
    @Override
    public void initialize(URL location, ResourceBundle resources) {                
       
        setMatches();
       
        for(int  i  = 0 ; i < buttonsList.size() ; i++){                        // this for specifying which match the customer choose
            final int index = i;
                
            buttonsList.get(i).setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                                  
                    model.setChosenMatchID(index + 1); 
                    model.setChosenMatch(buttonsList.get(index).getId());
                        
                    Scene_Controller.changeScene(event, "/fxml/seats_layout.fxml", "Seats");

                }
                
            });
        }


        button_back.setOnAction(new EventHandler<ActionEvent>() {               // going back to home page 

            @Override
            public void handle(ActionEvent event) {
                Scene_Controller.changeScene(event, "/fxml/login.fxml", "Login");
                
            }
            
        });
    }


    private void setMatches(){  // this function is for displaying the matches and their info
                                // by using the match cless and the world cup as well 
        com.example.Match  match = new com.example.Match();
        
        int counter = -2;

        for(int i  = 0 ; i < 3; i++){
            match = WorldCup.getMatchInfo((i + 1));
            counter += 2;

            for( int j = 0 ; j < 1 ; j++){
               
                Image image1 = new Image(match.getTeam1Flag());
                Image image2 = new Image(match.getTeam2Flag());
                imageList.get(counter).setImage(image1);
                imageList.get(counter + 1).setImage(image2);
                labelList.get(counter).setText(match.getTeam1());
                labelList.get(counter + 1).setText(match.getTeam2());
            }
           
           dateList.get(i).setText(match.getDate());
        }
 
    }
    
}
