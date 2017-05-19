package ejercicio2;

import java.util.Date;

public class Clock{
  
    private String brandName;
    private String model;
    private int hour;
    private int minutes;
    private int seconds;
    private int meridiem;
    private Date actDate;
    private int formatType;
    
    public Clock(){
        
        brandName = "";
        hour = 0;
        minutes = 0;
        seconds = 0;
        meridiem = 0;
        actDate = new Date();
        formatType = 0;
        
    }
    
    public Clock( String pBrand, String pModel, Date newDate ){
       
        brandName = pBrand;
        model = pModel;
        actDate = newDate;
    }
    
    public void setHour(int newHour, int newMinutes, int newSeconds, int newFormat){
        hour = newHour;
        minutes = newMinutes;
        seconds = newSeconds;
        formatType = newFormat;
    }
    
    public void setDate (Date newDate){
        actDate = newDate;
    }
    
    private void setFormat (int newFormat){
        formatType = newFormat;
    }

}
