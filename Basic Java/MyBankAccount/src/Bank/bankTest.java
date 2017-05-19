/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package Bank;
import java.util.Scanner;
import Bank.Client;
import java.util.Date;
/**
 *
 * @author Marien
 */
public class bankTest {

    
    
    public static void main(String[] args) {
        
    int option = 0;
    String keepActive;
    keepActive = "Y";
 
    //int userOperation;
    
    
    do{
    System.out.println(" Welcome to the Bank ");
    System.out.println(" Choose an option: ");
    System.out.println("1- Create new account ");
    System.out.println("2- Client Sign up");
    System.out.println("3- Operations ");
    
    Scanner in = new Scanner(System.in);
    option = in.nextInt();                                                                                                                                                                                
   
        switch(option){
        case 1: 
              createAccount();
            break;
            
        case 2:
            break;
        case 3:
            
            System.out.println("a- Deposit");
            System.out.println("b- Withdraw ");
            
            int aOption;
            aOption = in.nextInt();
                 
            switch(aOption) {
                case 1: 
            }
            break;
            
        default: 
            break;
        
        }
        
        if(option >= 3)
        {
            System.out.println(" Continue? ");
            
        }
        
    }while( keepActive.equals("Y"));
    
    }
    
    public static void createClient()
    {
        Scanner in = new Scanner(System.in);
        Client user;
        user = new Client();
    
        System.out.println("Client information: ");
            System.out.println("Insert name, address, phone ");
            
            String name = in.next();
            name = name.toUpperCase();
            user.setName(name);
                       
            String addres = in.nextLine();
            user.setAdress(addres);
            in.nextLine();
            
            String phone = in.next();
            user.setPhone(phone);
  
    }
    
    public static void createAccount()
    {
        Scanner in = new Scanner(System.in);
        Account userAcc;
        
        userAcc = new Account();
        
        System.out.println("Creating a new account");
        System.out.println("Required fields: ");
                      
        System.out.println("Client bank account information ");
        System.out.println("Account number, account type and aperture branch ");
           
        int numberAcc = in.nextInt();
        userAcc.setNumberAcc(numberAcc);
            
        String accType = in.next();
        userAcc.setAccType(accType);
            
        String apertureBranch = in.nextLine();
        userAcc.setApertureBranch(apertureBranch);
        in.nextLine();
            
            
        Date actDate = new Date();
        userAcc.setApertureDate(actDate);    
    
    }
    
}

