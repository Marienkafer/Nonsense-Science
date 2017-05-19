/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Devices;

import java.lang.Math;
/**
 *Class Calculatator that contents basic mathematical functions for basic mathematical operations
 * 
 * 
 * @author Marien
 */
public class Calculator extends Utilities.ElectronicDevice {
    
    /**
     * Default value it's initializated in 0 whom function works as backup of results for basic operations
     */  
    private double defaultValue;
    
    public Calculator() {
        this.defaultValue = 0;
    }
    
    public Calculator(String pBrand, String pModel){
        setBrandName(pBrand);
        setModel(pModel);
    }
    
    /**
     * Addition
     * 
     * @param value1
     * @param value2
     * @return a double that represent the adition of value1+value2 
     */
    
    public double addition(double value1, double value2){
        defaultValue = value1+value2;
        return(value1+value2);
        
    }
    
    /**
     * Substration
     * 
     * @param value1
     * @param value2
     * @return a double that represent the substration between value1-value2
     */
    public double substract(double value1, double value2){
        defaultValue = value1-value2;
        return(value1-value2);
        
    }
    
    /**
     * Multiply
     * 
     * @param value1
     * @param value2
     * @return a double that represent the multiplication between value1*value2
     */
    public double product(double value1, double value2){
        
        defaultValue = value1*value2;
        return(value1*value2);
        
    }
    
    /**
     * Divition
     * 
     * @param value1
     * @param value2
     * @return a double that represent the substration between value1/value2
     */
    public double divition(double value1, double value2) {
        
        defaultValue = value1/value2;
        return (value1/value2);

    }
    
    /**
     * Absolute Value 
     * 
     * @param value
     * @return a double that represent the absolute value of |value| using Math package
     */
    public double absoluteValue(double value){
        defaultValue = Math.abs(value);
        return(Math.abs(value));
        
        
    }
    
    /**
     * Square Root 
     * 
     * @param value
     * @return a double that represent the absolute value of value^(1/2) using Math package
     */
    public double squareRoot(double value){
        defaultValue = Math.sqrt(value);
        return(Math.sqrt(value));
        
    }

    public void setCModel(String pModel){
        setModel(pModel);
    }
    
    public void setCBrand(String pBrand){
        setBrandName(pBrand);
    }
    
    public String getCBrand(){
        return super.getBrandName();
    }
    
    public String getCModel(){
        return super.getModel();
    }
}
