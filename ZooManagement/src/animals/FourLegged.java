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

//Four Legged la lop kieu dong vat co bon chan
public class FourLegged extends Animals {
    
    //constructor
    public FourLegged(String id, String name, int legs, double weight, String actions, String features) {
        super(id, name, legs, weight, actions, features);
    }
    //constructor
    public FourLegged(String id) {
        super(id);
    }
    //hien thi thong tin kieu dong vat nay thong qua lua chua 'choice'
    public String toString(int choice) {
        String result = "";
        switch (choice) {
            case 1://hien thi thong tin tren man hinh chinh
                result = "ID: " + id + "\nName: " + name + "\nLeg(s): " + legs + "\nWeight: " + weight + " kg\nAction(s): " + actions + "\nFeature(s): " + features;
                break;
            case 2://xuat thong tin ra file
                result = id + ";" + name + ";" + legs + " legs;" + weight + " kg;" + actions + ";" + features;
                break;
        }
        return result;
    }
    
    // tim kiem kieu dong vat nay thong qua id
    @Override
    public boolean equals(Object obj) {
        return this.id.equals(((FourLegged) obj).id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

}
