package com.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




public abstract class Scene_Controller {

    public static void changeScene(ActionEvent event, String fxmlFile, String title) {
        Parent root = null;
        
        
            try {
                root = FXMLLoader.load(Scene_Controller.class.getResource(fxmlFile));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root, 877, 598));
                stage.setResizable(false);
                stage.setTitle(title);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        
        
        

    }

    

}