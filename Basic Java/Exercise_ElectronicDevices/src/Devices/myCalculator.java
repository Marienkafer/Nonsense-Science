/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Devices;

import Devices.Calculator;

/**
 *
 * @author Marien
 * 
 */
public class myCalculator {

    public static void main(String[] args) {
       
        Calculator test;
        
        test = new Calculator();
        
        test.setCBrand("Casio");
        test.setCModel("6969");
        
         System.out.println("Initialising Calculator "+ test.getCBrand()+ " " + test.getCModel());
        
        
        System.out.println("Addition: " + test.addition(15, 30));
        System.out.println("Substraction " + test.substract(15,30));
        System.out.println("Product " + test.product(15,30));
        System.out.println("Divition " + test.divition(15,30));
        System.out.println("Absolute Value " + test.absoluteValue(-150));
        System.out.println("Square Root " + test.squareRoot(20));
        System.out.println("Calculator Turned off.. Bye ");
         
    }
}
