package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javafx.scene.control.Label;

public class Stadium {

    private String match;
    private Queue <String> e1 = new LinkedList<>();
    private Queue <String> e2 = new LinkedList<>();
    private ArrayList<String> ticketsSoldAtE1 = new ArrayList<>();
    private ArrayList<String> ticketsSoldAtE2 = new ArrayList<>();

    public Stadium(String match){
        this.match = match;
        setTicketsSoldAtEntrences();
    }

    public void addAtE1(String s){
        e1.add(s);
    }
    public void addAtE2(String s){
        e2.add(s);
    }

    public String serveE1(){
        return e1.poll();
    }
    public String serveE2(){
        return e2.poll();
    }


    public boolean isEmptyE1(){
        return e1.size() == 0;
    }
    public boolean isEmptyE2(){
        return e2.size() == 0;
    }

    private ArrayList<String> getTickets(){
        ArrayList<String> tickets = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Assignment_1", "root", "uvhrkh12");
            preparedStatement = connection.prepareStatement("SELECT TicketId FROM " + match + " WHERE cusEmail != ?" );
            preparedStatement.setString(1, "Empty");
            resultSet = preparedStatement.executeQuery();

            if(resultSet.isBeforeFirst()){
                while(resultSet.next()){
                    tickets.add(resultSet.getString("TicketId"));
                }
                
            }

        }catch(SQLException e){

            e.printStackTrace();

        } finally{

            try { if (resultSet != null) resultSet.close(); } catch (SQLException e) {e.printStackTrace();};
            try { if (preparedStatement != null) preparedStatement.close(); } catch (SQLException e) {e.printStackTrace();};
            try { if (connection != null) connection.close(); } catch (SQLException e) {e.printStackTrace();};

        }

        return tickets;
    }

    private void setTicketsSoldAtEntrences(){
        ArrayList <String> tickets = getTickets();

        for(int i = 0 ; i < tickets.size() ; i++){
            if(tickets.get(i).contains("A") || tickets.get(i).contains("B")){
                ticketsSoldAtE1.add(tickets.get(i));
            }else{
                ticketsSoldAtE2.add(tickets.get(i));
            }
        }

      
    }

    public ArrayList<String> getTicketsSoldAtE1(){
        return ticketsSoldAtE1;
    }

    public ArrayList<String> getTicketsSoldAtE2(){
        return ticketsSoldAtE2;
    }

    public String TicketsSoldAtE1ToString(){
        

       return ticketsSoldAtE1.toString();
    }

    public String TicketsSoldAtE2ToString(){
        return ticketsSoldAtE2.toString();
    }

    public boolean e1Contains(String a){
        return e1.contains(a);
    }

    public boolean e2Contains(String a){
        return e2.contains(a);
    }

    public int getE1Size(){
        return e1.size();
    }

    public int getE2Size(){
        return e2.size();
    }

    public String getE1(){
        StringBuilder sb = new StringBuilder("[");

        for(String l : e1){
            sb.append(l + "   ");
            
        }

        return sb.append("]").toString();
    }

    public String getE2(){
        StringBuilder sb = new StringBuilder("[");

        for(String l : e2){
            sb.append(l + "   ");
            
        }

        return sb.append("]").toString();
    }


}
