package com.example;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class staff_chooseMatch_Controller implements Initializable {
    
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
        

        for(int  i  = 0 ; i < buttonsList.size() ; i++){
            final int index = i;
                
            buttonsList.get(i).setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                            
                           
                    model.setChosenMatch(buttonsList.get(index).getId());
                       
                    Scene_Controller.changeScene(event, "/fxml/staff_view_seats.fxml","Seats" );

                }
                
            });
        }
        
       

        button_back.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Scene_Controller.changeScene(event, "/fxml/login.fxml", "Login");
                
            }
            
        });
        
    }

    private void setMatches(){

        com.example.Match  match = new com.example.Match();
        
        int index = -2;

        for(int i  = 0 ; i < 3; i++){
            match = WorldCup.getMatchInfo((i + 1));
            index += 2;

            for( int j = 0 ; j < 1 ; j++){
               
                Image image1 = new Image(match.getTeam1Flag());
                Image image2 = new Image(match.getTeam2Flag());
                imageList.get(index).setImage(image1);
                imageList.get(index + 1).setImage(image2);
                labelList.get(index).setText(match.getTeam1());
                labelList.get(index + 1).setText(match.getTeam2());
            }
           
          
           dateList.get(i).setText(match.getDate());
        }

    }
 
}
