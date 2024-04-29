package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Staff extends User {
    

    public Staff(){}
    public Staff(String name , String email , String password){
        super(name , email , password);
        
    }

    public ObservableList<Seat> viewSeats(String choosenMatch){

        ObservableList<Seat> seats = FXCollections.observableArrayList();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Assignment_1", "root", "uvhrkh12");
            preparedStatement = connection.prepareStatement("SELECT * FROM " + choosenMatch );
        
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                
                seats.add(new Seat(resultSet.getString("seatID") , resultSet.getString("cusName") , resultSet.getString("cusEmail")
                , resultSet.getString("seatPrice")));
            }
        } catch (SQLException e) {

            e.printStackTrace();

        } finally {

            try { if (resultSet != null) resultSet.close(); } catch (SQLException e) {e.printStackTrace();};    
            try { if (preparedStatement != null) preparedStatement.close(); } catch (SQLException e) {e.printStackTrace();};
            try { if (connection != null) connection.close(); } catch (SQLException e) {e.printStackTrace();};
           
            
        }

        return seats;
        
    }

    public boolean login(){
        return super.login("staff");
    }

    


    public String getCapacity(String matchID){
        String capactiy = " ";
        String revenue = "";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
       
        try{
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Assignment_1", "root", "uvhrkh12");
            preparedStatement = connection.prepareStatement("SELECT COUNT(*) FROM " + matchID);
          
            resultSet = preparedStatement.executeQuery();

            if(resultSet.isBeforeFirst()){
                while(resultSet.next()){
                    capactiy = resultSet.getString(1);
                }
                
            }

        }catch(SQLException e){

            e.printStackTrace();

        } finally{

            try { if (resultSet != null) resultSet.close(); } catch (SQLException e) {e.printStackTrace();};
            try { if (preparedStatement != null) preparedStatement.close(); } catch (SQLException e) {e.printStackTrace();};
            try { if (connection != null) connection.close(); } catch (SQLException e) {e.printStackTrace();};

        }

        return capactiy;
    }

    public String getSeatsSoldOut(String matchID){
        String soldOut = " ";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        try{
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Assignment_1", "root", "uvhrkh12");
            preparedStatement = connection.prepareStatement("SELECT COUNT(*) FROM " + matchID + " WHERE cusEmail != ?");
             preparedStatement.setString(1, "Empty");
            resultSet = preparedStatement.executeQuery();

            if(resultSet.isBeforeFirst()){
                while(resultSet.next()){
                    soldOut =  resultSet.getString(1);
                }
                
            }

        }catch(SQLException e){

            e.printStackTrace();

        } finally{

            try { if (resultSet != null) resultSet.close(); } catch (SQLException e) {e.printStackTrace();};
            try { if (preparedStatement != null) preparedStatement.close(); } catch (SQLException e) {e.printStackTrace();};
            try { if (connection != null) connection.close(); } catch (SQLException e) {e.printStackTrace();};

        }

        return soldOut;
    }

    public double getRevenue(String matchID){
        double revenue = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        try{
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Assignment_1", "root", "uvhrkh12");
            preparedStatement = connection.prepareStatement("select seatPrice FROM " + matchID + " WHERE cusEmail != ?");
             preparedStatement.setString(1, "Empty");
            resultSet = preparedStatement.executeQuery();

            if(resultSet.isBeforeFirst()){
                while(resultSet.next()){
                    revenue +=  Double.parseDouble(resultSet.getString(1));
                }
                
            }

        }catch(SQLException e){

            e.printStackTrace();

        } finally{

            try { if (resultSet != null) resultSet.close(); } catch (SQLException e) {e.printStackTrace();};
            try { if (preparedStatement != null) preparedStatement.close(); } catch (SQLException e) {e.printStackTrace();};
            try { if (connection != null) connection.close(); } catch (SQLException e) {e.printStackTrace();};

        }

        return revenue;
    }

}
