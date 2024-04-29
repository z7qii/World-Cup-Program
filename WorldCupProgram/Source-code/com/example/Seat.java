package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Seat {
    private String seatID;
    private String cusName ;
    private String cusEmail;
    private String seatPrice;

    public Seat(String seatID, String name, String email , String seatPrice) {
        this.seatID = seatID;
        this.cusName = name;
        this.cusEmail = email;
        this.seatPrice = seatPrice;
    }



    public Seat() {}


    public String getSeatID() {
        return seatID;
    }



    public String getName() {
        return cusName;
    }



    public String getEmail() {
        return cusEmail;
    }

    public String getSeatPrice() {
        return seatPrice;
    }



    
}
