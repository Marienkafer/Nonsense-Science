package Bank;

/**
 *
 * @author Marienkafer
 */

import java.util.Date;

public class Account {

    private double balance;
    private int numberAcc;
    private String accType;
    private String status;
    private Date apertureDate;
    private String apertureBranch;

    public Account() {
        
        this.balance = 0;
        this.numberAcc = 0;
        this.accType = "";
        this.status = "active";
        this.apertureDate = new Date(0,0,0);
        this.apertureBranch = "";
    }

        
    public Account(double balance, int numberAcc, String accType, String status, Date apertureDate, String apertureBranch) {
        this.balance = balance;
        this.numberAcc = numberAcc;
        this.accType = accType;
        this.status = status;
        this.apertureDate = apertureDate;
        this.apertureBranch = apertureBranch;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getNumberAcc() {
        return numberAcc;
    }

    public void setNumberAcc(int numberAcc) {
        this.numberAcc = numberAcc;
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getApertureDate() {
        return apertureDate;
    }

    public void setApertureDate(Date apertureDate) {
        this.apertureDate = apertureDate;
    }

    public String getApertureBranch() {
        return apertureBranch;
    }

    public void setApertureBranch(String apertureBranch) {
        this.apertureBranch = apertureBranch;
    }
    
   
    public void deposit( double amt){
        balance = balance + amt;
    }
    
    public void withdraw(double amt) {
        
        boolean success;
        
        if(amt > balance)
        {
            success = false;
            System.out.println("Not enough founds");
        }
        else
            balance = balance - amt;
     
    }
}
