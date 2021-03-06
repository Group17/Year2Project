package model;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17
*/

public class Sale {
  
    private int saleID;
    private String date;
    private String time;
    private double discount;
    private double amount;
    
    public Sale() {
      saleID = 0;
      date = "";
      time = "";
      discount = 0.00;
      amount = 0.00;
    }
    
    public Sale(int saleID, String date, String time, double discount, double amount) {
      this.saleID = saleID;
      this.date = date;
      this.time = time;
      this.discount = discount;
      this.amount = amount;
    }
     //METHODS
    public void awardpoints() {
      
    }
    
    public double loyaltyDiscount() {
      
      return 0.00;
    }
    
    //GETTERS
    public int getSaleID() {
        return saleID;
    }
    
    public String getDate() {
        return date;
    }
    
    public String getTime() {
        return time;
    }
    
    public double getDiscount() {
        return discount;
    }
    
    public double getAmount() {
        return amount;
    }
    
    //SETTERS
    public void setSaleID(int saleID) {
        this.saleID = saleID;
    }
    
    public void setDate(String date) {
        this.date = date;
    }
    
    public void setTime(String time) {
        this.time = time;
    }
    
    public void setDiscount(double discount) {
        this.discount = discount;
    }
    
    public void setAmount(double amount) {
        this.amount = amount;
    }
}
