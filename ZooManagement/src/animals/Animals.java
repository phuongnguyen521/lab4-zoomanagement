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
//Animals la khuon mau chung cho 4 kieu dong vat thua ke
public abstract class Animals {
    
    //nhung thuoc tinh chung cua dong vat
    protected String id;
    protected String name;
    protected int legs;
    protected double weight;
    protected String actions;
    protected String features;
    
    //constructor
    public Animals(String id, String name, int legs, double weight, String actions, String features) {
        this.id = id;
        this.name = name;
        this.legs = legs;
        this.weight = weight;
        this.actions = actions;
        this.features = features;
    }
    
    //constructor
    public Animals(String id) {
        this.id = id;
    }
    
    // getters, setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getActions() {
        return actions;
    }

    public void setActions(String actions) {
        this.actions = actions;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
        return hash;
    }
    
    //tim kiem dong vat qua id
    @Override
    public boolean equals(Object obj) {
        return this.id.equals(((Animals)obj).id);
    }
    
    
}
