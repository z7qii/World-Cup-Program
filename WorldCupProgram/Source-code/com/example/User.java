package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class is a parent class that will contain general methods and data feidls among different types of users
 * @author Group 2 
 */

public abstract class User {                        // this class is the super calss for the customer and staff classes 
    private String name;
    private String email;
    private String password;
    
    /**
     * Constructs a User with name , email and password set to null.
     */
    public User(){}
   /**
    * Constructs a User with the specified name , email and password
    *
    * @param name the name of the user
    * @param email the email of the user
    * @param password the password of the user
    */
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    /**
     * 
     * @return returns the name of the user
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @return return the email of the user
     */
    public String getEmail() {

        
        return email;
    }

    /**
     * 
     * @return return the password of the user
     */
    public String getPassword() {
        return password;
    }

    /**
     * 
     * @param name Accepts String name and set the user name to that name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * 
     * @param email Accepts a String email and set the user email to that email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 
     * @param password Accepts a String password and set the user password to that password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 
     * @param userType Accepts a String userType to perform the login operation based on that user type
     * @return return a boolean to indicate wether the login operation was successfull or not
     */

    public boolean login(String userType){                              // this is the main method in the user class 
        Boolean logedIn = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            connection = DriverManager.getConnection("URL");
            preparedStatement = connection.prepareStatement("SELECT * FROM " + userType + " WHERE email = ?");
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();

            if(resultSet.isBeforeFirst()){
                while(resultSet.next()){
                    String retrievedPassword = resultSet.getString("password"); // checking the password by comparing the passwords
                    if(retrievedPassword.equals(this.password)){
                        logedIn = true;
                        this.name = resultSet.getString("name");
                        
                    }
                }
                
            }

        }catch(SQLException e){

            e.printStackTrace();

        } finally{

            try { if (resultSet != null) resultSet.close(); } catch (SQLException e) {e.printStackTrace();};
            try { if (preparedStatement != null) preparedStatement.close(); } catch (SQLException e) {e.printStackTrace();};
            try { if (connection != null) connection.close(); } catch (SQLException e) {e.printStackTrace();};

        }

        return logedIn;
    }

    

}
