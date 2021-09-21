package com.blue.mybmi;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Bmi implements Serializable {
    private String height;
    private String weight;
    private String bmi;

    public Bmi(String height, String weight) {
        this.height = height;
        this.weight = weight;
    }

    @Override
    public String toString() {
        double dBMI = Double.valueOf(bmi);
        String message;
        if(dBMI < 18.5){
            message = "Underweight";
        }else if( 18.5 <= dBMI && dBMI < 25){
            message = "Normal weight";
        }else if(25 <= dBMI && dBMI < 30){
            message = "Overweight";
        }else{
            message = "Obese";
        }
        return "Height: " + height + "\nWeight: " + weight +"\nBMI: " + bmi + "\n" + message;
    }

    public void getBMI() {
        double dHeight = Double.valueOf(height);
        double dWeight = Double.valueOf(weight);
        double result = dWeight / Math.pow(dHeight / 100, 2);
        bmi = String.valueOf(new BigDecimal(result).setScale(3, RoundingMode.HALF_UP));
    }


    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getBmi() {
        return bmi;
    }

    public void setBmi(String bmi) {
        this.bmi = bmi;
    }
}
