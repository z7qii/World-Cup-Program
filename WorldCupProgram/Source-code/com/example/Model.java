package com.example;

public class Model {

    private static Staff staff;
    private static Customer customer ;
    private static String chosenMatch;
    private static int chosenMatchID;
    private static String chosenSeat;
    
    public void setStaff(Staff staff) {
        Model.staff = staff;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setChosenMatch(String chosenMatch) {
        this.chosenMatch = chosenMatch;
    }

    public void setChosenMatchID(int chosenMatchID) {
        this.chosenMatchID = chosenMatchID;
    }

    public void setChosenSeat(String chosenSeat) {
        this.chosenSeat = chosenSeat;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getChosenMatch() {
        return chosenMatch;
    }

    public int getChosenMatchID() {
        return chosenMatchID;
    }

    public String getChosenSeat() {
        return chosenSeat;
    }

    public Staff getStaff() {
        return staff;
    }
    
}
