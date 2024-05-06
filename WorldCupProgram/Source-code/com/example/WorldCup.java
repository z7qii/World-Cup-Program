package com.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public abstract class WorldCup {
   private static Map<Integer , Match> matches = getMatches();
    
    private static HashMap<Integer , Match> getMatches(){

        HashMap<Integer , Match> matches = new HashMap<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            connection = DriverManager.getConnection("URL");
            preparedStatement = connection.prepareStatement("SELECT * FROM  world_cup");
            
            resultSet = preparedStatement.executeQuery();

            if(resultSet.isBeforeFirst()){
                while(resultSet.next()){                         
                    Match match = new Match(resultSet.getString("firstTeam"),resultSet.getString("secondTeam") ,
                                            resultSet.getString("firstTeamFlag"),resultSet.getString("secondTeamFlag") ,
                                            resultSet.getString("date"));
                                            matches.put(Integer.parseInt(resultSet.getString("matchID")), match);
                }
                
            }

        }catch(SQLException e){

            e.printStackTrace();

        } finally{

            try { if (resultSet != null) resultSet.close(); } catch (SQLException e) {e.printStackTrace();};
            try { if (preparedStatement != null) preparedStatement.close(); } catch (SQLException e) {e.printStackTrace();};
            try { if (connection != null) connection.close(); } catch (SQLException e) {e.printStackTrace();};
            
        }


        return matches;
    }


    public static Match getMatchInfo(int matchID){
        return matches.get(matchID);
    }

}  
