package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setResizable(false);
       
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        primaryStage.setTitle("login page");
        primaryStage.setScene(new Scene(root, 877 , 598));
        
        primaryStage.show();
        
    }


    public static void main(String [] args){launch(args);}
    
}

// INSTRUCTOINS: In order to run the program, first you need to import the database attached to the zip file.
// First, open Mysql Workbench, then create a new connection with IP address 127.0.0.1, user name root, and password uvhrkh12.

// After you have created the connection, open the connection and choose Server at the top of the window.
// Then choose the import option and import the Dump folder attached with the zip folder.
// After that you need to download mysql-connector-j-8.0.31.jar
// After you have downloaded it, open the assignment in VS Code, click on referenced libraries, and add the mysql-connector file.

// NOTE: In order to log in as a staff member, you need to choose one of these two accounts: 

// Email: zayed@staff.com
// Password: Uvhrkh12-


// Email: alassaf@staff.com
// Password: Uvhrkh12-

