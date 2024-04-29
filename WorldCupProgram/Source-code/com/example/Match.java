package com.example;

public class Match {
    private String team1;
    private String team2;
    private String team1Flag;
    private String team2Flag;
    private String Date;

    public Match(){}
    public Match(String team1, String team2, String team1Flag, String team2Flag, String date) {
        this.team1 = team1;
        this.team2 = team2;
        this.team1Flag = team1Flag;
        this.team2Flag = team2Flag;
        this.Date = date;
    }

    public String getTeam1() {
        return team1;
    }
    public String getTeam2() {
        return team2;
    }
    public String getTeam1Flag() {
        return team1Flag;
    }
    public String getTeam2Flag() {
        return team2Flag;
    }
    public String getDate() {
        return Date;
    }

    
}
