package com.example;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.ListChangeListener.Change;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;



public class Customer extends User {
   
    public Customer(){}
    
    public Customer(String name , String email , String password){
        super(name , email , password);
    }

    
    public boolean signUp() {
        Boolean excepted = false;
        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheckUserExists = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Assignment_1", "root", "uvhrkh12");
            psCheckUserExists = connection.prepareStatement("SELECT * FROM customers WHERE email = ?");
            psCheckUserExists.setString(1, super.getEmail());
            resultSet = psCheckUserExists.executeQuery();

            if (!resultSet.isBeforeFirst()) { // it will create a new row for the new customer 
                excepted = true;
                psInsert = connection.prepareStatement("INSERT INTO customers(name, email, password) VALUES (?, ?, ?)");
                psInsert.setString(1, super.getName());
                psInsert.setString(2, super.getEmail());
                psInsert.setString(3, super.getPassword());
                psInsert.executeUpdate();
            } else {
                
            }
            
        } catch (SQLException e) {

            e.printStackTrace();
            

        } finally { // to avoid the leak we closed all these variable 

            try { if (resultSet != null) resultSet.close(); } catch (SQLException e) {e.printStackTrace();};    
            try { if (psCheckUserExists != null) psCheckUserExists.close(); } catch (SQLException e) {e.printStackTrace();};
            try { if (psInsert != null) psInsert.close(); } catch (SQLException e) {e.printStackTrace();};
            try { if (connection != null) connection.close(); } catch (SQLException e) {e.printStackTrace();};
        }

        return excepted;
    }

    
    public boolean checkSeatAvailability(String choosenMatch , String seatID){
        boolean available = true;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Assignment_1", "root", "uvhrkh12");
            preparedStatement = connection.prepareStatement("SELECT * FROM " + choosenMatch + " WHERE seatID = ?");
            preparedStatement.setString(1, seatID);
            
            resultSet = preparedStatement.executeQuery();
            

            if (resultSet.isBeforeFirst()) {
                
                while(resultSet.next()){
                String checkAvailiavility = resultSet.getString("cusEmail");
                if(!checkAvailiavility.equals("Empty")) available = false; // if it is not empty this mean it is booked by a cus email
                }
                
            } else {
                available = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try { if (resultSet != null) resultSet.close(); } catch (SQLException e) {e.printStackTrace();};    
            try { if (preparedStatement != null) preparedStatement.close(); } catch (SQLException e) {e.printStackTrace();};
            try { if (connection != null) connection.close(); } catch (SQLException e) {e.printStackTrace();};

        }

        return available;


    }

   
    public void bookTicket(String choosenMatch , String seatID){ // uppdating the match table 
       
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Assignment_1", "root", "uvhrkh12");
            
            preparedStatement = connection.prepareStatement("UPDATE " + choosenMatch + " SET cusName = ? , cusEmail = ?  WHERE seatID = ?");
            preparedStatement.setString(1, super.getName());
            preparedStatement.setString(2, super.getEmail());
            preparedStatement.setString(3, seatID);
            preparedStatement.executeUpdate();
            
           
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try { if (resultSet != null) resultSet.close(); } catch (SQLException e) {e.printStackTrace();};    
            try { if (preparedStatement != null) preparedStatement.close(); } catch (SQLException e) {e.printStackTrace();};
            try { if (connection != null) connection.close(); } catch (SQLException e) {e.printStackTrace();};

            
        }
        
    }

    public String getPrice(String choosenMatch , String seatID){
        String price = "" ;
        Boolean logedIn = true;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Assignment_1", "root", "uvhrkh12");
            preparedStatement = connection.prepareStatement("SELECT seatPrice FROM " + choosenMatch + " WHERE seatID = ?");
            preparedStatement.setString(1, seatID);
            resultSet = preparedStatement.executeQuery();

            if(!resultSet.isBeforeFirst()){
                logedIn = false;
                
            }else{
                while(resultSet.next()){
                    price = resultSet.getString("seatPrice");
                    
                }
            }

        }catch(SQLException e){
            e.printStackTrace();

        } finally{

            try { if (resultSet != null) resultSet.close(); } catch (SQLException e) {e.printStackTrace();};    
            try { if (preparedStatement != null) preparedStatement.close(); } catch (SQLException e) {e.printStackTrace();};
            try { if (connection != null) connection.close(); } catch (SQLException e) {e.printStackTrace();};

        }

        return price;

    }

   
    public boolean login(){
        return super.login("Customers");
    }


}
