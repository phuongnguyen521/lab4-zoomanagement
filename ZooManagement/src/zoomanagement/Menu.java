/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoomanagement;

import java.util.ArrayList;
import util.Validation;

/**
 *
 * @author Nguyen Ngoc Phuong - SE150998 - SE1506 -LAB211 - LAB0004 - SPR2021
 */
//Menu la lop hien thi thong tin Menu
public class Menu {
    
    private final String menuTitle;                         // tieu de Menu
    private ArrayList<String> mainMenu = new ArrayList<>(); // arraylist chua thong tin Menu

    //constructor
    public Menu(String menuString) {
        this.menuTitle = menuString;
    }
    
    //Cho them thong tin Menu
    public void addMenu(String input) {
        mainMenu.add(input);
    }
    //Hien thi thong tin
    public void display() {
        System.out.println(menuTitle);
        for (String mn : mainMenu) {
            System.out.println(mn);
        }
    }
    //Lua chon cua user thong qua 'choice'
    public int inputChoice() {
        int choice = Validation.checkInteger("Enter choice (1-8): ", "Enter from 1 to " + mainMenu.size() + ": ", 1, mainMenu.size(), 1);
        return choice;
    }
}
