/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animals;

import java.util.Objects;

/**
 *
 * @author Nguyen Ngoc Phuong - SE150998 - SE1506 -LAB211 - LAB0004 - SPR2021
 */

//Bipedal and flightless la kieu dong vat khong bay
public class BipedalAndFlightless extends Animals {
    
    //hai thuoc tinh rieng biet
    private int swings;
    private String color;
    
    
    // constructor
    public BipedalAndFlightless(String id, String name, int legs, double weight, String actions, String features, String color, int swings) {
        super(id, name, legs, weight, actions, features);
        this.swings = swings;
        this.color = color;
    }
    
    //constructor
    public BipedalAndFlightless(String id) {
        super(id);
    }
    
    //getters, setters
    public int getSwings() {
        return swings;
    }

    public void setSwings(int swings) {
        this.swings = swings;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    //xuat thong tin thong qua lua chon 'choice'
    public String toString(int choice) {
        String result = "";
        switch (choice) {
            case 1: //xuat thong tin tren man hinh cua kieu dong vat nay
                result = "ID: " + id + "\nName: " + name + "\nLeg(s): " + legs + "\nWeight: " + weight + "kg\nAction(s): " + actions + "\nFeature(s): " + features + "\nColor: " + color + "\nSwings: " + swings;
                break;
            case 2://xuat thong tin vao file cua kieu dong vat nay
                result = id + ";" + name + ";" + legs + " legs;" + weight + " kg;" + actions + ";" + features + ";" + color + ";" + swings + " wings;";
                break;
        }
        return result;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
        return hash;
    }
    
    //tim kiem kieu dong vat nay thong qua id
    @Override
    public boolean equals(Object obj) {
        return this.id.equals(((BipedalAndFlightless) obj).id);
    }
}
