/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bank;

/**
 *
 * @author Marien
 */

public class Client {
    
    private String name;
    private Account bankAccount;
    private String adress;
    private String phone;

    public Client(String name, Account bankAccount, String adress, String  phone) {
        this.name = name;
        this.bankAccount = bankAccount;
        this.adress = adress;
        this.phone = phone;
    }

    Client() {
        this.name = "";
        this.bankAccount = null;
        this.adress = "";
        this.phone = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(Account bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
}
