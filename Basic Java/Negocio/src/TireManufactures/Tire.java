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
public class Tire {
    
    private  String model;
    private short diameter;
    private byte ring;

    public Tire() {
    }

    public Tire(String model, int diameter, int ring) {
        this.model = model;
        this.diameter = (short) diameter;
        this.ring = (byte) ring;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public short getDiameter() {
        return diameter;
    }

    public void setDiameter(short diameter) {
        this.diameter = diameter;
    }

    public byte getRing() {
        return ring;
    }

    public void setRing(byte ring) {
        this.ring = ring;
    }
    
    
    public void avalaible(){
        
        
        if( this.diameter > 195 && this.diameter < 205) {
            System.out.println("We don't have available tires for big vehicles");
        }
        else if(this.diameter >= 165 && this.diameter <= 175) {
            System.out.println("Only Kelly model available ");
        } else if (this.diameter > 205 && this.ring < 16){
             System.out.println("Avalaible tires: ULTRAMETRIC ");
        }else{
            System.out.println("Not available tires ");
        }
    }
    
}
