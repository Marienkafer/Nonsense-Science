package Utilities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Curso
 */
public class ElectronicDevice {
     
    private String brandName;
    private String model;

    
    
    public ElectronicDevice() {
        this.brandName = "";
        this.model = "";
    }

    
    public ElectronicDevice(String brandName, String model) {
        this.brandName = brandName;
        this.model = model;
    }

    
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    
    
    
}
