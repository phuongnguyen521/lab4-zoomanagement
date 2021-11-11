/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoomanagement;

import java.io.FileNotFoundException;
import java.io.IOException;
import methods.ListOfAnimals;

/**
 *
 * @author Nguyen Ngoc Phuong - SE150998 - SE1506 -LAB211 - LAB0004 - SPR2021
 */
public class ZooManagement {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    
    //ZooManagement la lop main thuc hien cac chuc nang
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Menu mn = new Menu("-----------------------------\n\tZoo Management"); // tieu de Menu
        //Thong tin Menu
        mn.addMenu("1-Add new animal");
        mn.addMenu("2-Update animal");
        mn.addMenu("3-Delete animal");
        mn.addMenu("4-Search animal");
        mn.addMenu("5-Show animal list");
        mn.addMenu("6-Import File");
        mn.addMenu("7-Save to File");
        mn.addMenu("8-Exit");
        int choice = 0;                             //lua chon user
        ListOfAnimals loa = new ListOfAnimals();    //lop list chua cac chuc nang
        do {
            mn.display();
            choice = mn.inputChoice();
            switch (choice) {
                case 1:
                    //them vao dong vat
                    loa.add();
                    break;
                case 2:
                    //chinh sua dong vat
                    loa.update();
                    break;
                case 3:
                    //xoa dong vat
                    loa.delete();
                    break;
                case 4:
                    //tim kiem dong vat
                    loa.search();
                    break;
                case 5:
                    //hien thi thong tin dong vat
                    loa.show();
                    break;
                case 6:
                    //nhap file vao lop list
                    loa.writeFiletoList();
                    break;
                case 7:
                    //xuat thong tin dong vat ra file
                    loa.savetoFile();
                    break;
                default:
                    //thoat khoi chuong trinh
                    System.out.println("Thank you!");
                    break;
            }
        } while (choice != 8);
    }

}
