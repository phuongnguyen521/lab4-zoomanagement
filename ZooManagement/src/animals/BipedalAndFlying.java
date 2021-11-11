/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animals;

/**
 *
 * @author Nguyen Ngoc Phuong - SE150998 - SE1506 -LAB211 - LAB0004 - SPR2021
 */
// Bipedal And Flying la kieu dong vat bay
public class BipedalAndFlying extends Animals {
    //thuoc tinh rieng cua kieu dong vat nay
    private int swings;

    //constructor
    public BipedalAndFlying(String id, String name, int legs, double weight, String actions, String features, int swings) {
        super(id, name, legs, weight, actions, features);
        this.swings = swings;
    }

    //constructor
    public BipedalAndFlying(String id) {
        super(id);
    }

    //getters, setters
    public int getSwings() {
        return swings;
    }

    public void setSwings(int swings) {
        this.swings = swings;
    }
    
    //hien thi thong tin kieu dong vat nay thong qua lua chon 'choice'
    public String toString(int choice) {
        String result = "";
        switch (choice) {
            case 1://hien thi thong tin tren man hinh
                result = "ID: " + id + "\nName: " + name + "\nLeg(s): " + legs + "\nWeight: " + weight + "kg\nAction(s): " + actions + "\nFeature(s): " + features + "\nSwing(s): " + swings;
                break;
            case 2://xuat thong tin ra file
                result = id + ";" + name + ";" + legs + " legs;" + weight + " kg;" + actions + ";" + features + ";" + swings + " wings";
                break;
        }
        return result;
    }

    //tim kiem kieu dong vat nay thong qua id
    @Override
    public boolean equals(Object obj) {
        return this.id.equals(((BipedalAndFlying) obj).id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

}
