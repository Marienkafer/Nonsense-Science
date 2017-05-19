/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TireManufactures;

/**
 *
 * @author Curso
 */
import java.util.Scanner;
import java.util.ArrayList;
import TireManufactures.Tire;
import java.util.Random;
import java.util.Date;
import java.io.*;

public class TireSystem {

    
    
    public static void main(String[] args) {
    
        Tire aTire, consultTire, t1;
        ArrayList<Tire> anArrayofTires;
        
        anArrayofTires = new ArrayList();
        
        t1 = new Tire("peni", 48, 5);
        

        Scanner in = new Scanner(System.in);

        int option;
       
        
        System.out.println(" *************************************************** ");
        System.out.println(" Welcome to the your favorite Tire Manufacture ");
        System.out.println(" *************************************************** ");
        do{
            System.out.println(" *************************************************** ");
            System.out.println(" Choose an option: ");
            System.out.println("1- Add a tire to the database ");
            System.out.println("2- Make a Purchase Appointment");
            System.out.println("3- Bye ");
            System.out.println(" *************************************************** ");
            option = in.nextInt();
            switch(option)
            {
                case 1:
                    System.out.println("Required Fields: ");
                    System.out.println("Model: ");
                    String tireModel;
                    tireModel = in.nextLine();
                    in.nextLine();
                    System.out.println("Size ");
                    int tireSize;
                    tireSize = in.nextInt();
                    System.out.println("Ring ");
                    int tireRing;
                    tireRing = in.nextInt();

                    aTire = new Tire(tireModel, tireSize, tireRing);
                    anArrayofTires.add(t1);
                    anArrayofTires.add(aTire);

                    System.out.println("Do you wish to add another Tire? y/n " );
                    String a;
                    a = in.next();
                    if(a.equals("Y"))
                            option = 1;
                            
                    break;
                case 2:

                    System.out.println("Making an Appointment ");
                    System.out.println("Consult if Tire required it's avalaible ");

                    System.out.println("Required Fields: ");
                    System.out.println(" Model: ");
                    
                    String atireModel;
                    atireModel = in.nextLine();
                    in.nextLine();
                    
                    System.out.println("Size ");
                    int atireSize;
                    atireSize = in.nextInt();
                    System.out.println("Ring ");
                    int atireRing;
                    atireRing = in.nextInt();
/*
                    consultTire = new Tire(atireModel, atireSize, atireRing);
                    boolean ap;
                    anArrayofTires.add(t1);
                    ap = consultaTire(consultTire, anArrayofTires);      */              

                   /* if ()
                    {*/
                         System.out.println("Congrats! this tire it's available \n"
                                 + "Update client info ");
                         System.out.println("Required Fields: ");
                         System.out.println("Name: ");
                         String clientName;
                         
                         clientName = in.nextLine();
                         in.nextLine();
                         System.out.println("Name: "+clientName);
                         
                         System.out.println("ID ");
                         int clientID;
                         clientID = in.nextInt();

                         try{

                            PrintWriter writer = new PrintWriter("TireAppointment.txt", "UTF-8");
                            
                            writer.println("************  TIRE BUY APPOINTMENT DATE ************");
                            writer.println("NAME: "+ clientName);
                            
                            writer.println("ID: "+ clientID);

                            Random rn = new Random();
                            int confirmationNumber = rn.nextInt();
                            if(confirmationNumber < 0)
                                confirmationNumber=confirmationNumber*(-1);
                            
                            writer.println("CONFIRMATION NUMBER: "+ confirmationNumber );

                            Date infoDate = new Date();
                            writer.println("APPOINTMENT DATE: "+ infoDate );

                            writer.println("TIRE MODEL: "+atireModel);
                            writer.println("TIRE SIZE: "+atireSize);
                            writer.println("TIRE RING: "+atireRing);
                            writer.println("\n");
                            
                            writer.flush();
                            writer.close();
                         }catch(IOException e){
                             
                             e.printStackTrace();
                         };
                   /* }*/
                    break; 

                default: break;
            }
            
        }while(option<=2);
        
  }
    /*
    public static boolean consultaTire( Tire t, ArrayList<Tire> arrayList){
        boolean available;
        available = false;
        
            for (Tire product : arrayList) {
       System.out.println(product.getModel());
    }
            
            System.out.println("Required Fields: "+ available);
        return available;
    }*/

}
