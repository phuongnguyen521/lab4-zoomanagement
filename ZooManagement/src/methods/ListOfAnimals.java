/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

import java.util.ArrayList;
import animals.BipedalAndFlightless;
import animals.BipedalAndFlying;
import animals.FourLegged;
import animals.NoLegged;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import util.Validation;

/**
 *
 * @author Nguyen Ngoc Phuong - SE150998 - SE1506 -LAB211 - LAB0004 - SPR2021
 */

/* ListOfAnimals la lop chua cac chuc nang cua dong vat va thua ke list chinh theo kieu fourlegged
Vi sao khong thua ke ArrayList<Animals>?
Tra loi: vi Animals va FourLegged cung cac thuoc tinh, nen chon 1 trong 2 deu duoc.
Tuy nhien, neu chon Animals thi se phan chuc nang delete se phuc tap,
vi vay chon FourLegged de hieu qua va de quan ly hon
 */
public class ListOfAnimals extends ArrayList<FourLegged> implements CommonMethods {

    /*tao list phu cho 4 kieu dong vat
    fl - FourLegged
    nl - NoLegged
    bai - BipedalAndFlightless
    bay - BipedalAndFlying
     */
    ArrayList<FourLegged> fl = new ArrayList<>();
    ArrayList<NoLegged> nl = new ArrayList<>();
    ArrayList<BipedalAndFlightless> bai = new ArrayList<>();
    ArrayList<BipedalAndFlying> bay = new ArrayList<>();

    //tim kiem thong tin qua element va lua chon 'choice'
    @Override
    public int find(String element, int choice) {
        int result = -1; //ket qua tim kiem
        //neu list chinh rong
        if (this.isEmpty()) {
            return result;
        }
        //neu list chinh khong rong 
        switch (choice) {
            case 1: //tim kiem id trong list chinh
                result = this.indexOf(new FourLegged(element));
                break;
            case 2:// tim kiem name trong list chinh
                for (int i = 0; i < this.size(); i++) {
                    if (this.get(i).getName().contains(element)) { //co ton tai name trong list chinh
                        //tim kiem trong tung list phu cua 4 kieu dong vat
                        //tim kiem name qua No Legged
                        return result = i;
                    }
                }
                break;
            case 3:
                //neu list No Legged rong
                if (nl.isEmpty()) {
                    return result;
                } else {
                    // neu list No Legged khong rong, tim kiem id qua indexOf
                    result = nl.indexOf(new NoLegged(element));
                }
                break;
            case 4:
                //neu list Bipedal and Flightless rong
                if (bai.isEmpty()) {
                    return result;
                } else {
                    //neu list Bipedal and Flightless khong rong, tim kiem qua indexOf
                    result = bai.indexOf(new BipedalAndFlightless(element));
                }
                break;
            case 5:// neu list Bipedal and Flying rong
                if (bay.isEmpty()) {
                    return result;
                } else {
                    // neu list Bipedal and Flying khong rong, tim kiem id qua indexOf
                    result = bay.indexOf(new BipedalAndFlying(element));
                }
                break;
            case 6:
                // neu list Four Legged rong
                if (fl.isEmpty()) {
                    return result;
                } else {
                    // neu list Four Legged khong rong, tim kiem id qua indexOf
                    result = fl.indexOf(new FourLegged(element));
                }
                break;
            case 7:
                // neu list No Legged rong
                if (nl.isEmpty()) {
                    return result;
                }
                // neu list No Legged khong rong, tim kiem name qua 
                for (int i = 0; i < nl.size(); i++) {
                    if (nl.get(i).getName().contains(element)) {
                        System.out.println("\n------------------------------------------\n"
                                + nl.get(i).toString(1)
                                + "\n------------------------------------------\n");
                    }
                }
                break;
            case 8:
                //neu list Bipedal and Flightless rong
                if (bai.isEmpty()) {
                    return result;
                }
                //neu list Bipedal and Flightless khong rong, tim kiem name trong lit
                for (int i = 0; i < bai.size(); i++) {
                    if (bai.get(i).getName().contains(element)) {
                        System.out.println("\n------------------------------------------\n"
                                + bai.get(i).toString(1)
                                + "\n------------------------------------------\n");
                    }
                }
                break;
            case 9:
                //neu list Bipedal and Flying rong
                if (bay.isEmpty()) {
                    return result;
                }
                //neu list Bipedal and Flying khong rong, tim kiem name trong lit
                for (int i = 0; i < bay.size(); i++) {
                    if (bay.get(i).getName().contains(element)) {
                        System.out.println("\n------------------------------------------\n"
                                + bay.get(i).toString(1)
                                + "\n------------------------------------------\n");
                    }
                }
                break;
            case 10:
                // neu list Four Legged rong
                if (fl.isEmpty()) {
                    return result;
                } // neu list Four Legged khong rong, tim kiem name trong list
                for (int i = 0; i < fl.size(); i++) {
                    if (fl.get(i).getName().contains(element)) {
                        System.out.println("\n------------------------------------------\n"
                                + fl.get(i).toString(1)
                                + "\n------------------------------------------\n");
                    }
                }
                break;
        }
        return result;
    }

    //them dong vat
    @Override
    public void add() {
        FourLegged fl1 = null;
        int choice = 0;
        String id = "", name = "";
        String submenu = "\n------------------------------------------\n"
                + "\tAdd information of animals Menu\n"
                + "1-No Legged\n2-Bipedal and flightless"
                + "\n3-Bipedal and flying"
                + "\n4-Four Legged"
                + "\n5-Back to Main Menu"
                + "\nEnter choice: ";
        String error = "Enter number 1 - 5";
        boolean checkingValue = false;
        do {
            //lua chon kieu dong vat thong qua 'choice'
            choice = Validation.checkInteger(submenu, error, 1, 5, 1);
            switch (choice) {
                case 1: //them kieu dong vat No Legged

                    //kiem tra id hop le va khong bi trung
                    while (true) {
                        id = enterValue(0, true);
                        if (find(id, 1) > -1) {
                            System.out.println("ID " + id + " is existed. Enter another ID");
                        } else {
                            break;
                        }
                    }
                    //nhap thong tin vao Four Legged fl1, sau do luu vao list nl va list chinh
                    /* Vi sao phai luu vao list phu va list chinh?
                    Tra loi: Khi tim kiem, truy xuat thong tin. Dau tien tim trong list chinh, 
                    neu ton tai thong tin thi list phu cung chua thong tin do*/
                    fl1 = new FourLegged(id, enterValue(4, true), 0, Double.parseDouble(enterValue(6, true)), enterValue(7, true), enterValue(8, true));
                    nl.add(new NoLegged(fl1.getId(), fl1.getName(), fl1.getLegs(), fl1.getWeight(), fl1.getActions(), fl1.getFeatures(), enterValue(9, true)));
                    this.add(fl1);
                    fl1 = null;
                    //thong bao them No Legged thanh cong
                    System.out.println("\n------------------------------------------\n"
                            + "Add No Legged Animal successfully\n"
                            + nl.get(find(id, 3)).toString(1) //Hien thi thong tin dong vat vua them vao
                            + "\n------------------------------------------");
                    break;
                case 2:
                    //them kieu dong vat Bipedal and Flightless

                    //kiem tra id hop le va khong bi trung
                    while (true) {
                        id = enterValue(1, true);
                        if (find(id, 1) > -1) {
                            System.out.println("ID " + id + " is existed. Enter another ID");
                        } else {
                            break;
                        }
                    }
                    //nhap thong tin vao Four Legged fl1, sau do luu vao list bai va list chinh
                    fl1 = new FourLegged(id, enterValue(4, true), Integer.parseInt(enterValue(5, true)), Double.parseDouble(enterValue(6, true)), enterValue(7, true), enterValue(8, true));
                    bai.add(new BipedalAndFlightless(fl1.getId(), fl1.getName(), fl1.getLegs(), fl1.getWeight(), fl1.getActions(), fl1.getFeatures(), enterValue(9, true), Integer.parseInt(enterValue(10, true))));
                    this.add(fl1);
                    fl1 = null;
                    //thong bao them Bipedal and Flightless thanh cong
                    System.out.println("\n------------------------------------------\n"
                            + "Add Bipedal and flightless successfully\n"
                            + bai.get(find(id, 4)).toString(1) //hien thi thong tin dong vat vua them vao
                            + "\n------------------------------------------");
                    break;
                case 3:
                    //them kieu dong vat Bipedal and Flying

                    //kiem tra id hop le va khong bi trung
                    while (true) {
                        id = enterValue(2, true);
                        if (find(id, 1) > -1) {
                            System.out.println("ID " + id + " is existed. Enter another ID");
                        } else {
                            break;
                        }
                    }
                    //nhap thong tin vao Four Legged fl1, sau do luu vao list bay va list chinh
                    fl1 = new FourLegged(id, enterValue(4, true), Integer.parseInt(enterValue(5, true)), Double.parseDouble(enterValue(6, true)), enterValue(7, true), enterValue(8, true));
                    bay.add(new BipedalAndFlying(fl1.getId(), fl1.getName(), fl1.getLegs(), fl1.getWeight(), fl1.getActions(), fl1.getFeatures(), Integer.parseInt(enterValue(10, true))));
                    this.add(fl1);
                    fl1 = null;
                    //thong bao them Bipedal and Flying thanh cong
                    System.out.println("\n------------------------------------------\n"
                            + "Add Bipedal and flying successfully\n"
                            + bay.get(find(id, 5)).toString(1) //hien thi thong tin dong vat them vao
                            + "\n------------------------------------------");
                    break;
                case 4:
                    //them kieu dong vat Four Legged

                    //kiem tra id hop le va khong bi trung
                    while (true) {
                        id = enterValue(3, true);
                        if (find(id, 1) > -1) {
                            System.out.println("ID " + id + " is existed. Enter another ID");
                        } else {
                            break;
                        }
                    }
                    //nhap thong tin vao Four Legged fl1, sau do luu vao list fl va list chinh
                    fl.add(new FourLegged(id, enterValue(4, true), Integer.parseInt(enterValue(5, true)), Double.parseDouble(enterValue(6, true)), enterValue(7, true), enterValue(8, true)));
                    //thong bao them Four Legged thanh cong
                    System.out.println("\n------------------------------------------\n"
                            + "Add Four Legged successfully\n"
                            + fl.get(find(id, 6)).toString(1) //hien thi thong tin dong vat them vao
                            + "\n------------------------------------------");
                    break;
            }
            //neu choice tu 1 - 4, se hoi nguoi dung tiep tuc nua khong. 
            //neu 'Y' se quay ve add. Neu 'N' quay ve Menu chinh
            if (choice >= 1 && choice <= 4) {
                checkingValue = Validation.checkYN("Do you want to add more animals? (Y/N)");
            }
        } while (checkingValue != false && choice != 5);
    }

    //chinh sua thong tin
    @Override
    public void update() {
        String id = "", name = "", actions = "", features = "", colors = "";
        int legs = 0, swings = 0, preposition = 0, choice = 0;
        double weight = 0;
        boolean checkingValue = true;
        String subMenu = "\n------------------------------------------\n"
                + "\tUpdate animals Menu\n"
                + "1-No Legged"
                + "\n2-Bipedal and flightless"
                + "\n3-Bipedal and flying"
                + "\n4-Four Legged"
                + "\n5-Back to Main Menu"
                + "\nEnter choice: ";
        String errorMenu = "Enter from 1 - 5";
        if (!isNotExist(0, true)) { // neu list chinh khong rong
            while (checkingValue != false && choice != 5) {
                choice = Validation.checkInteger(subMenu, errorMenu, 1, 5, 1); //lua chon kieu dong vat thong qua choice
                switch (choice) {
                    case 1://chinh sua thong tin No Legged
                        if (!isNotExist(1, true)) { // neu list No Legged rong, se thong bao list rong. Neu khong thi tien hanh tim kiem
                            updateNoLegged(id, name, weight, actions, features, colors, preposition, checkingValue);
                        }
                        break;
                    case 2://chinh sua thong tin Bipedal and Flightless
                        if (!isNotExist(2, true)) { // neu list No Legged rong, se thong bao list rong. Neu khong thi tien hanh tim kiem
                            updateBipedalAndFlightless(id, name, legs, weight, actions, features, colors, swings, preposition, checkingValue);
                        }
                        break;
                    case 3://chinh sua thong tin Bipedal and Flying
                        if (!isNotExist(3, true)) { // neu list No Legged rong, se thong bao list rong. Neu khong thi tien hanh tim kiem
                            updateBipedalAndFlying(id, name, legs, weight, actions, features, swings, preposition, checkingValue);
                        }
                        break;
                    case 4://chinh sua thong tin Four Legged
                        if (!isNotExist(4, true)) { // neu list No Legged rong, se thong bao list rong. Neu khong thi tien hanh tim kiem
                            updateFourLegged(id, name, legs, weight, actions, features, preposition, checkingValue);
                        }
                        break;
                }
                //sau khi chinh sua xong thong qua choice tu 1 -4 , se hoi co muon tiep tuc khong
                //Neu 'Y' se tiep tuc, neu 'N' se quay ve man hinh Menu chinh
                if (choice >= 1 && choice <= 4) {
                    checkingValue = Validation.checkYN("Do you want to update more animals (Y/N)?");
                }
            }
        }
    }

    //hien thi thong tin hien co trong 4 kieu dong vat
    public void showList(int choice) {
        switch (choice) {
            case 0:
                //hien thi id va name cura cua tat ca dong vat No Legged
                System.out.println("\n--------------------------------------------\n"
                        + "List of No Legged Animals\n"
                        + "ID\tName");
                for (NoLegged nl1 : nl) {
                    System.out.println(nl1.getId() + "\t" + nl1.getName());
                }
                break;
            case 1:
                //hien thi id va name cura cua tat ca dong vat Bipedal and Flightless
                System.out.println("\n--------------------------------------------\n"
                        + "List of Bipedal and Flightless Animals\n"
                        + "ID\tName");
                for (BipedalAndFlightless bai1 : bai) {
                    System.out.println(bai1.getId() + "\t" + bai1.getName());
                }
                break;
            case 2:
                //hien thi id va name cura cua tat ca dong vat Bipedal and Flying
                System.out.println("\n--------------------------------------------\n"
                        + "List of Bipedal and Flying Animals\n"
                        + "ID\tName");
                for (BipedalAndFlying bay1 : bay) {
                    System.out.println(bay1.getId() + "\t" + bay1.getName());
                }
                break;
            case 3:
                //hien thi id va name cura cua tat ca dong vat Four Legged
                System.out.println("\n--------------------------------------------\n"
                        + "List of Four Legged Animals\n"
                        + "ID\tName");
                for (FourLegged fl1 : fl) {
                    System.out.println(fl1.getId() + "\t" + fl1.getName());
                }
                break;
        }
        System.out.println("\n--------------------------------------------");
    }

    public void updateNoLegged(String id, String name, double weight, String actions, String features, String colors, int preposition, boolean checkingValue) {
        while (checkingValue) {
            //hien thi id va name co trong list No Legged
            showList(0);
            //nhap id can tim
            id = enterValue(0, true);
            //neu id co khong co trong list chinh
            if ((preposition = find(id, 1)) == -1) {
                System.out.println("Cannot find " + id); //thong bao khong tim thay
                //co muon tiep tuc chinh sua No Legged hay khong. Neu 'Y' thi tiep tuc, neu 'N' thi quay ve update 
                checkingValue = Validation.checkYN("Do you want to update more No Legged animals (Y/N)?: ");
            } else {
                //neu id co ton tai trong list chinh, tim kiem id trong list No Legged
                int position = find(id, 3);
                if (position > -1) {
                    //neu id co ton tai, hien thi toan bo thong tin cua dong vat do
                    System.out.println("------------------------------------------------\n"
                            + nl.get(position).toString(1)
                            + "\n------------------------------------------------\n"
                            + "\tUpdate information of " + id);
                    System.out.println("!!If not typing anything, the information will be not changed!!");
                    //thay doi id
                    while (true) {
                        String idReplacement = enterValue(0, false);
                        if (idReplacement.isEmpty()) {
                            break;
                        } else {
                            if (idReplacement.equals(id)) {
                                System.out.println("Same as id before. Enter other or not enter");
                            } else if (find(idReplacement, 3) > -1 && !(idReplacement.equals(id))) {
                                System.out.println(idReplacement + " is duplicated. Enter other or not enter");
                            } else {
                                nl.get(position).setId(idReplacement);
                                this.get(preposition).setId(idReplacement);
                                break;
                            }
                        }
                    }
                    // thay doi name
                    while (true) {
                        name = enterValue(4, false);
                        if (name.isEmpty()) {
                            break;
                        } else {
                            if (!(name.equals(nl.get(position).getName()))) {
                                nl.get(position).setName(name);
                                this.get(preposition).setName(name);
                                break;
                            } else {
                                //neu giong nhu thong tin cu
                                System.out.println("Same as name before. Enter other or not enter");
                            }
                        }
                    }

                    //thay doi weight
                    System.out.println("Weight should more than 0");
                    while (true) {
                        weight = Double.parseDouble(enterValue(6, false));
                        if (weight <= 0) {
                            break;
                        } else {
                            if (!(weight == nl.get(position).getWeight())) {
                                nl.get(position).setWeight(weight);
                                break;
                            } else {
                                //neu giong thong tin cu
                                System.out.println("Same as weight before. Enter other number or not enter");
                            }
                        }
                    }

                    //thay doi action(s)
                    while (true) {
                        actions = enterValue(7, false);
                        if (actions.isEmpty()) {
                            break;
                        } else {
                            if (!(actions.equals(nl.get(position).getActions()))) {
                                nl.get(position).setActions(actions);
                                break;
                            } else {
                                //neu giong thong tin cu
                                System.out.println("Same as actions before. Enter other or not enter");
                            }
                        }
                    }

                    //thay doi feature(s)
                    while (true) {
                        features = enterValue(8, false);
                        if (features.isEmpty()) {
                            break;
                        } else {
                            if (!(features.equals(nl.get(position).getFeatures()))) {
                                nl.get(position).setFeatures(features);
                                break;
                            } else {
                                //neu giong thong tin cu
                                System.out.println("Same as feature before. Enter other or not enter");
                            }
                        }
                    }

                    //thay doi color(s)
                    while (true) {
                        colors = enterValue(9, false);
                        if (colors.isEmpty()) {
                            break;
                        } else {
                            if (!(colors.equals(nl.get(position).getColor()))) {
                                nl.get(position).setColor(colors);
                                break;
                            } else {
                                //neu giong thong tin cu
                                System.out.println("Same as colors before. Enter other or not enter");
                            }
                        }
                    }
                    //hien thi thong tin vua nhap
                    System.out.println("\n------------------------------------------------\n"
                            + "\tUpdate No Legged animal successfully\n"
                            + nl.get(position).toString(1)
                            + "\n------------------------------------------------");

                }
                break;
            }
        }
    }

    public void updateBipedalAndFlightless(String id, String name, int legs, double weight, String actions, String features, String colors, int swings, int preposition, boolean checkingValue) {
        while (checkingValue) {
            showList(1); //hien thi id va name cua list Bipedal And Flightless
            id = enterValue(1, true); //nhap id
            if ((preposition = find(id, 1)) == -1) { // neu list chinh khong ton tai id
                System.out.println("Cannot find " + id);
                //neu muon tiep tuc - 'Y'. Quay ve update -'N'
                checkingValue = Validation.checkYN("Do you want to update more bipedal and flightless animals (Y/N)?: ");
            } else {
                int position = find(id, 4);
                if (position > -1) {
                    System.out.println("\n------------------------------------------------\n"
                            + "\n" + bai.get(position).toString(1) //hien thi thong tin dong vat can chinh sua
                            + "\n------------------------------------------------\n"
                            + "\tUpdate information of " + id);
                    System.out.println("!!If not typing anything, the information will be not changed!!");
                    //chinh sua id
                    while (true) {
                        String idReplacement = enterValue(1, false);
                        if (idReplacement.isEmpty()) {
                            break;
                        } else {
                            if (idReplacement.equals(id)) {
                                System.out.println("Same as id before. Enter other or not enter");
                            } else if (find(idReplacement, 4) > -1 && !(idReplacement.equals(id))) {
                                System.out.println(idReplacement + " is duplicated. Enter another ID");
                            } else {
                                bai.get(position).setId(idReplacement);
                                this.get(preposition).setId(idReplacement);
                                break;
                            }
                        }
                    }
                    //chinh sua name
                    while (true) {
                        name = enterValue(4, false);
                        if (name.isEmpty()) {
                            break;
                        } else {
                            if (!(name.equals(bai.get(position).getName()))) {
                                bai.get(position).setName(name);
                                this.get(preposition).setName(name);
                                break;
                            } else {
                                System.out.println("Same as name before. Enter other or not enter");
                            }
                        }
                    }
                    //chinh sua leg(s)
                    System.out.println("Legs should more than 0");
                    while (true) {
                        legs = Integer.parseInt(enterValue(5, false));
                        if (legs <= 0) {
                            break;
                        } else {
                            if (!(legs == bai.get(position).getLegs())) {
                                bai.get(position).setLegs(legs);
                                break;
                            } else {
                                System.out.println("Same as amount of legs before"
                                        + "\nEnter other or not enter");
                            }
                        }
                    }
                    //chinh sua weight
                    System.out.println("Weight should more than 0");
                    while (true) {
                        weight = Double.parseDouble(enterValue(6, false));
                        if (weight <= 0) {
                            break;
                        } else {
                            if (!(weight == bai.get(position).getWeight())) {
                                bai.get(position).setWeight(weight);
                                break;
                            } else {
                                System.out.println("Same as amount weight before"
                                        + "\nEnter other number or not enter");
                            }
                        }
                    }

                    //chinh sua action(s)
                    while (true) {
                        actions = enterValue(7, false);
                        if (actions.isEmpty()) {
                            break;
                        } else {
                            if (!(actions.equals(bai.get(position).getActions()))) {
                                bai.get(position).setActions(actions);
                                break;
                            } else {
                                System.out.println("Same as actions before. Enter other or not enter");
                            }
                        }
                    }

                    //chinh sua feature(s)
                    while (true) {
                        features = enterValue(8, false);
                        if (features.isEmpty()) {
                            break;
                        } else {
                            if (!(features.equals(bai.get(position).getFeatures()))) {
                                bai.get(position).setFeatures(features);
                                break;
                            } else {
                                System.out.println("Same as features before. Enter other or not enter");
                            }
                        }
                    }

                    //chinh sua color(s)
                    while (true) {
                        colors = enterValue(9, false);
                        if (colors.isEmpty()) {
                            break;
                        } else {
                            if (!(colors.equals(bai.get(position).getColor()))) {
                                bai.get(position).setColor(colors);
                                break;
                            } else {
                                System.out.println("Same as colors before. Enter other or not enter");
                            }
                        }
                    }
                    //chinh sua wings
                    System.out.println("Swings should more than 0");
                    while (true) {
                        swings = Integer.parseInt(enterValue(10, false));
                        if (swings <= 1) {
                            break;
                        } else {
                            if (!(swings == bai.get(position).getSwings())) {
                                bai.get(position).setSwings(swings);
                                break;
                            } else {
                                System.out.println("Same as amount of wings before"
                                        + "\nEnter other or not enter");
                            }
                        }
                    }

                    System.out.println("\n------------------------------------------------\n"
                            + "Update Bipedal and Flightless animal successfully\n"
                            + bai.get(position).toString(1) //hien thi thong tin dong vat vua nhap
                            + "\n------------------------------------------------");
                }
                break;
            }
        }
    }

    public void updateBipedalAndFlying(String id, String name, int legs, double weight, String actions, String features, int swings, int preposition, boolean checkingValue) {
        while (checkingValue) {
            showList(2);//hien thi id va name cua list Bipedal And Flying
            id = enterValue(2, true);//nhap id
            if ((preposition = find(id, 1)) == -1) {//neu list chinh khong ton tai id
                System.out.println("Cannot find " + id);
                //neu muon tiep tuc - 'Y'. Quay ve update -'N'
                checkingValue = Validation.checkYN("Do you want to update more Bipedal and Flying animals (Y/N)?: ");
            } else {
                int position = find(id, 5);
                if (position > -1) {
                    System.out.println("\n------------------------------------------------\n"
                            + bay.get(position).toString(1) //hien thi thong tin dong vat can chinh sua
                            + "\n------------------------------------------------\n"
                            + "\tUpdate information of " + id);
                    System.out.println("!!If not typing anything, the information will be not changed!!");

                    while (true) {
                        String idReplacement = enterValue(2, false);
                        if (idReplacement.isEmpty()) {
                            break;
                        } else {
                            if (idReplacement.equals(id)) {
                                System.out.println("Same as id before. Enter other or not enter");
                            } else if (find(idReplacement, 5) > -1 && !(idReplacement.equals(id))) {
                                System.out.println(idReplacement + " is duplicated. Enter another ID");
                            } else {
                                bay.get(position).setId(idReplacement);
                                this.get(preposition).setId(idReplacement);
                                break;
                            }
                        }
                    }
                    //chinh sua name
                    while (true) {
                        name = enterValue(4, false);
                        if (name.isEmpty()) {
                            break;
                        } else {
                            if (!(name.equals(bay.get(position).getName()))) {
                                bay.get(position).setName(name);
                                this.get(preposition).setName(name);
                                break;
                            } else {
                                System.out.println("Same as name before. Enter other or not enter");
                            }
                        }
                    }

                    //chinh sua leg(s)
                    System.out.println("Legs should more than 0");
                    while (true) {
                        legs = Integer.parseInt(enterValue(5, false));
                        if (legs <= 0) {
                            break;
                        } else {
                            if (!(legs == bay.get(position).getLegs())) {
                                bay.get(position).setLegs(legs);
                                break;
                            } else {
                                System.out.println("Same as amount of legs before"
                                        + "\nEnter other or not enter");
                            }
                        }
                    }

                    //chinh sua weight
                    System.out.println("Weight should more than 0");
                    while (true) {
                        weight = Double.parseDouble(enterValue(6, false));
                        if (weight <= 0) {
                            break;
                        } else {
                            if (!(weight == bay.get(position).getWeight())) {
                                bay.get(position).setWeight(weight);
                                break;
                            } else {
                                System.out.println("Same as amount weight before"
                                        + "\nEnter other number or not enter");
                            }
                        }
                    }

                    //chinh sua action(s)
                    while (true) {
                        actions = enterValue(7, false);
                        if (actions.isEmpty()) {
                            break;
                        } else {
                            if (!(actions.equals(bay.get(position).getActions()))) {
                                bay.get(position).setActions(actions);
                                break;
                            } else {
                                System.out.println("Same as actions before. Enter other or not enter");
                            }
                        }
                    }

                    //chinh sua feature(s)
                    while (true) {
                        features = enterValue(8, false);
                        if (features.isEmpty()) {
                            break;
                        } else {
                            if (!(features.equals(bay.get(position).getFeatures()))) {
                                bay.get(position).setFeatures(features);
                                break;
                            } else {
                                System.out.println("Same as features before. Enter other or not enter");
                            }
                        }
                    }

                    //chinh sua wings
                    System.out.println("Swings should more than 0");
                    while (true) {
                        swings = Integer.parseInt(enterValue(10, false));
                        if (swings <= 1) {
                            break;
                        } else {
                            if (!(swings == bay.get(position).getSwings())) {
                                bay.get(position).setSwings(swings);
                                break;
                            } else {
                                System.out.println("Same as amount of wings before"
                                        + "\nEnter other or not enter");
                            }
                        }
                    }

                    System.out.println("\n------------------------------------------------\n"
                            + "Update Bipedal and Flying animal successfully"
                            + bay.get(position).toString(1)//hien thi thong tin dong vat vua nhap
                            + "\n------------------------------------------------");
                }
                break;
            }
        }
    }

    public void updateFourLegged(String id, String name, int legs, double weight, String actions, String features, int preposition, boolean checkingValue) {
        while (checkingValue) {
            showList(3);
            id = enterValue(3, true);
            if ((preposition = find(id, 1)) == -1) {
                System.out.println("Cannot find " + id);
                checkingValue = Validation.checkYN("Do you want to update more Four Legged animals (Y/N)?: ");
            } else {
                int position = find(id, 6);
                if (position > -1) {
                    System.out.println("\n------------------------------------------------\n"
                            + fl.get(position).toString(1) //hien thi thong tin dong vat can chinh sua
                            + "\n------------------------------------------------\n"
                            + "\tUpdate information of " + id);
                    System.out.println("!!If not typing anything, the information will be not changed!!");
                    //chinh sua id
                    while (true) {
                        String idReplacement = enterValue(3, false);
                        if (idReplacement.isEmpty()) {
                            break;
                        } else {
                            if (idReplacement.equals(id)) {
                                System.out.println("Same as id before. Enter other or not enter");
                            } else if (find(idReplacement, 6) > -1 && !(idReplacement.equals(id))) {
                                System.out.println(idReplacement + " is duplicated. Enter another ID");
                            } else {
                                fl.get(position).setId(idReplacement);
                                this.get(preposition).setId(idReplacement);
                                break;
                            }
                        }
                    }
                    //chinh sua name
                    while (true) {
                        name = enterValue(4, false);
                        if (name.isEmpty()) {
                            break;
                        } else {
                            if (!(name.equals(fl.get(position).getName()))) {
                                fl.get(position).setName(name);
                                this.get(preposition).setName(name);
                                break;
                            } else {
                                System.out.println("Same as name before. Enter other or not enter");
                            }
                        }
                    }

                    //chinh sua leg(s)
                    System.out.println("Legs should more than 0");
                    while (true) {
                        legs = Integer.parseInt(enterValue(5, false));
                        if (legs <= 0) {
                            break;
                        } else {
                            if (!(legs == fl.get(position).getLegs())) {
                                fl.get(position).setLegs(legs);
                                break;
                            } else {
                                System.out.println("Same as amount of legs before"
                                        + "\nEnter other or not enter");
                            }
                        }
                    }

                    //chinh sua weight
                    while (true) {
                        weight = Double.parseDouble(enterValue(6, false));
                        if (weight <= 0) {
                            break;
                        } else {
                            if (!(weight == fl.get(position).getWeight())) {
                                fl.get(position).setWeight(weight);
                                break;
                            } else {
                                System.out.println("Same as amount weight before"
                                        + "\nEnter other number or not enter");
                            }
                        }
                    }

                    //chinh sua action(s)
                    while (true) {
                        actions = enterValue(7, false);
                        if (actions.isEmpty()) {
                            break;
                        } else {
                            if (!(actions.equals(fl.get(position).getActions()))) {
                                fl.get(position).setActions(actions);
                                break;
                            } else {
                                System.out.println("Same as actions before. Enter other or not enter");
                            }
                        }
                    }

                    //chinh sua feature(s)
                    while (true) {
                        features = enterValue(8, false);
                        if (features.isEmpty()) {
                            break;
                        } else {
                            if (!(features.equals(fl.get(position).getFeatures()))) {
                                fl.get(position).setFeatures(features);
                                break;
                            } else {
                                System.out.println("Same as features before. Enter other or not enter");
                            }
                        }
                    }
                    System.out.println("\n------------------------------------------------\n"
                            + "\tUpdate Four Legged animal successfully\n"
                            + fl.get(position).toString(1) //hien thi thong tin dong vat vua nhap
                            + "\n------------------------------------------------");
                }
                break;
            }
        }
    }

    //xoa thong tin dong vat
    @Override
    public void delete() {
        boolean checkingExit = false;
        boolean checkingValue = false;
        FourLegged fl1 = null;
        int position = -1, preposition = -1, choice = 0;
        String subMenu = "\n------------------------------------------\n"
                + "\tDelete animals Menu\n"
                + "1-No Legged"
                + "\n2-Bipedal and flightless"
                + "\n3-Bipedal and flying"
                + "\n4-Four Legged"
                + "\n5-Back to Main Menu";
        String errorMenu = "Enter from 1 - 5";
        if (!isNotExist(0, true)) {
            do {
                choice = Validation.checkInputMenu(subMenu, errorMenu, 1, 5);
                switch (choice) {
                    case 1: //xoa thong tin list No Legged
                        if (!isNotExist(1, true)) { //neu list No Legged khong rong
                            while (true) {
                                showList(0); //hien thi id - name No Legged
                                String id = enterValue(0, true);
                                if ((preposition = find(id, 1)) == -1) { //neu list chinh khong ton tai id tim kiem
                                    System.out.println("Cannot find " + id);
                                    checkingValue = Validation.checkYN("Do you want to delete No Legged animals (Y/N)? ");
                                    if (checkingValue == false) {
                                        break;
                                    }
                                } else {
                                    // neu ton tai id tim kiem
                                    position = find(id, 3);
                                    nl.remove(position); //xoa thong tin trong No Legged
                                    this.remove(preposition); // xoa thong tin trong list chinh
                                    System.out.println("Delete No Legged successfully");
                                    break;
                                }
                            }
                        }
                        break;
                    case 2://xoa thong tin list Bipedal and flightless
                        if (!isNotExist(2, true)) { // neu list Bipedal and flightless khong rong
                            while (true) {
                                showList(1); //hien thi id va name Bipedal and flightless
                                String id = enterValue(1, true);
                                if ((preposition = find(id, 1)) == -1) {
                                    System.out.println("Cannot find " + id); // neu list chinh khong ton tai id tim kiem
                                    checkingValue = Validation.checkYN("Do you want to delete Bipedal and Flightless animals (Y/N)? ");
                                    if (checkingValue == false) {
                                        break;
                                    }
                                } else {
                                    //neu ton tai id tim kiem
                                    position = find(id, 4);
                                    bai.remove(position); //xoa thong tin trong list Bipedal and flightless
                                    this.remove(preposition); // xoa thong tin list chinh
                                    System.out.println("Delete Bipedal and Flightless successfully");
                                    break;
                                }
                            }
                        }
                        break;
                    case 3://xoa thong tin list Bipedal and flying
                        if (!isNotExist(3, true)) { //neu list Bipedal and flying khong rong  
                            while (true) {
                                showList(2);
                                String id = enterValue(2, true);
                                if ((preposition = find(id, 1)) == -1) {
                                    System.out.println("Cannot find " + id); //neu list chinh khong ton tai id tim kiem
                                    checkingValue = Validation.checkYN("Do you want to delete Bipedal and Flying animals (Y/N)? ");
                                    if (checkingValue == false) {
                                        break;
                                    }
                                } else {
                                    //ton tai id tim kiem
                                    position = find(id, 5);
                                    bay.remove(position); //xoa thong tin list Bipedal and flying
                                    this.remove(preposition); //xoa thong tin list chinh
                                    System.out.println("Delete Bipedal and Flying successfully");
                                    break;
                                }
                            }
                        }
                        break;
                    case 4://xoa thong tin list No Legged
                        if (!isNotExist(4, true)) { //neu list Four Legged khong rong
                            while (true) {
                                showList(3);
                                String id = enterValue(3, true);
                                if ((preposition = find(id, 1)) == -1) {
                                    System.out.println("Cannot find " + id);
                                    checkingValue = Validation.checkYN("Do you want to delete Four Legged animals (Y/N)? ");
                                    if (checkingValue == false) {
                                        break;
                                    }
                                } else {
                                    position = find(id, 6);
                                    fl.remove(position); //xoa thong tin list Four Legged
                                    this.remove(preposition); //xoa thong trong list chinh
                                    System.out.println("Delete Four Legged successfully");
                                    break;
                                }
                            }
                        }
                        break;
                }
                //neu choice tu 1 - 4, hoi co muon tiep tuc xoa khong
                //Neu 'Y' - tiep tuc xoa, neu 'N' - quay ve Menu chinh
                if (choice >= 1 && choice <= 4) {
                    checkingExit = Validation.checkYN("Do you want to delete more animals (Y/N)? ");
                }
            } while (checkingExit != false && choice != 5);
        }
    }

    //tim kiem dong vat
    @Override
    public void search() {
        int choice = 0;
        String submenu = "\n------------------------------------------------\n"
                + "\tSearch animals Menu\n"
                + "1-Search by name"
                + "\n2-Search by weight"
                + "\n3-Back to Main Menu"
                + "\nEnter choice: ";
        String error = "Enter number 1 - 3";
        boolean checkingValue = false;
        if (!isNotExist(0, true)) {
            do {
                choice = Validation.checkInteger(submenu, error, 1, 3, 1);
                switch (choice) {
                    case 1: //tim kiem theo ten
                        searchName();
                        break;
                    case 2:
                        //tim kiem theo weight
                        System.out.println("Min weight");
                        double minWeight = Double.parseDouble(enterValue(6, true));
                        double maxWeight = 0;
                        while (maxWeight <= minWeight) {
                            System.out.println("Max weight");
                            maxWeight = Double.parseDouble(enterValue(6, true));
                            if (maxWeight <= minWeight) {
                                System.out.println("Max of Weight should be larger than min of Weight");
                            }
                        }
                        searchWeight(minWeight, maxWeight);
                        break;
                }
                if (choice == 1 || choice == 2) {
                    checkingValue = Validation.checkYN("Do you want to search more (Y/N)? ");
                }
            } while (checkingValue != false && choice != 3);
        }
    }

    //tim kiem ten
    public void searchName() {
        int position = 0;
        int counter = 0;

        //hien thi toan bo name co trong list chinh
        System.out.println("\nSearch By Name\n----------------------------------");
        for (FourLegged animals : this) {
            if (counter != 2) {
                System.out.print(animals.getName() + "\t");
                counter++;
            } else {
                System.out.print("\n" + animals.getName() + "\t");
                counter = 0;
            }
        }
        System.out.println("\n----------------------------------");
        String name = enterValue(4, true);
        if (find(name, 2) > -1) { //neu name co ton tai trong list chinh
            System.out.println("Result of Search by Name:");
            find(name, 7);
            find(name, 8);
            find(name, 9);
            find(name, 10);
        } else {
            System.out.println("Cannot find " + name); //list chinh khong ton tai name
        }
    }

    //tim kiem can nang
    public void searchWeight(double minWeight, double maxWeight) {
        int counter = 0;
        if (!isNotExist(1, false)) { //neu list No Legged khong rong 
            for (NoLegged nl1 : nl) {
                if (nl1.getWeight() >= minWeight && nl1.getWeight() <= maxWeight) {
                    System.out.println("\n------------------------------------------\n"
                            + nl1.toString(1)
                            + "\n------------------------------------------");
                    counter = 1;
                }
            }
        }

        if (!isNotExist(2, false)) {//neu list Bipedal and Flightless khong rong
            for (BipedalAndFlightless bai1 : bai) {
                if (bai1.getWeight() >= minWeight && bai1.getWeight() <= maxWeight) {
                    System.out.println("\n------------------------------------------\n"
                            + bai1.toString(1)
                            + "\n------------------------------------------");
                    counter = 1;
                }
            }
        }

        if (!isNotExist(3, false)) { //neu list Bipedal and Flying khong rong
            for (BipedalAndFlying bay1 : bay) {
                if (bay1.getWeight() >= minWeight && bay1.getWeight() <= maxWeight) {
                    System.out.println("\n------------------------------------------\n"
                            + bay1.toString(1)
                            + "\n------------------------------------------");
                    counter = 1;
                }
            }
        }

        if (!isNotExist(4, false)) {//neu list Four Legged khong rong
            for (FourLegged fl1 : fl) {
                if (fl1.getWeight() >= minWeight && fl1.getWeight() <= maxWeight) {
                    System.out.println("\n------------------------------------------\n"
                            + fl1.toString(1)
                            + "\n------------------------------------------\n");
                    counter = 1;
                }
            }
        }

        //neu khong co weight trong khoang minWeight va maxWeight
        if (counter == 0) {
            System.out.println("Cannot find weight between " + minWeight + " - " + maxWeight);
        }

    }

    //hien thi thong tin
    @Override
    public void show() {
        int choice = 0;
        String submenu = "\n------------------------------------------\n"
                + "\tShow animals Menu\n"
                + "1-Show by type"
                + "\n2-Show all"
                + "\n3-Back to Main Menu"
                + "\nEnter choice: ";
        String error = "Enter number 1 - 3";
        boolean checkingValue = false;
        if (!isNotExist(0, true)) {
            do {
                choice = Validation.checkInteger(submenu, error, 1, 3, 1);
                switch (choice) {
                    case 1: //hien thi qua kieu dong vat
                        String subMenuByShowType = "\n------------------------------------------\n"
                                + "\tShow information of animals\n"
                                + "1-No Legged"
                                + "\n2-Bipedal and flightless"
                                + "\n3-Bipedal and flying"
                                + "\n4-Four Legged"
                                + "\n5-Back to Show Menu"
                                + "\nEnter choice: ";
                        String errorByShowType = "Enter number 1 - 5";
                        int choiceSub = Validation.checkInteger(subMenuByShowType, errorByShowType, 1, 4, 1);
                        printAll(choiceSub);
                        break;
                    case 2:
                        //hien thi tat ca thong tin
                        for (int i = 1; i <= 4; i++) {
                            printAll(i);
                        }
                        break;
                }
                //neu choice tu 1 -2, hoi tiep tuc hay khong
                // neu 'Y' tiep tuc hien thi, neu 'N' quay ve Menu chinh
                if (choice >= 1 && choice <= 2) {
                    checkingValue = Validation.checkYN("Do you want to show more (Y/N)? ");
                }
            } while (checkingValue != false && choice != 3);
        }
    }

    //hien thi thong tin theo yeu cau
    public void printAll(int choice) {
        switch (choice) {
            case 1: //hien thi thong tin cua No Legged
                if (!isNotExist(choice, false)) {
                    System.out.println("\n------------------------------------------\n"
                            + "\tList of No Legged animals");
                    for (NoLegged nl1 : nl) {
                        System.out.println("\n------------------------------------------\n"
                                + nl1.toString(1));
                    }
                    System.out.println("------------------------------------------");
                }
                break;
            case 2: //hien thi thong tin cua Bipedal and Flightless
                if (!isNotExist(choice, false)) {
                    System.out.println("\n------------------------------------------\n"
                            + "\tList of Bipedal and Flightless animals");
                    for (BipedalAndFlightless bai1 : bai) {
                        System.out.println("\n------------------------------------------\n"
                                + bai1.toString(1));
                    }
                    System.out.println("\n------------------------------------------\n");
                }
                break;
            case 3: //hien thi thong tin cua Bipedal and Flying
                if (!isNotExist(choice, false)) {
                    System.out.println("\n------------------------------------------\n"
                            + "\tList of Bipedal and Flying animals");
                    for (BipedalAndFlying bay1 : bay) {
                        System.out.println("\n------------------------------------------\n"
                                + bay1.toString(1));
                    }
                    System.out.println("\n------------------------------------------\n");
                }
                break;
            case 4: //hien thi thong tin cua Four Legged
                if (!isNotExist(choice, false)) {
                    System.out.println("\n------------------------------------------\n"
                            + "\tList of Four Legged animals");
                    for (FourLegged fl1 : fl) {
                        System.out.println("\n------------------------------------------\n"
                                + fl1.toString(1));
                    }
                    System.out.println("\n------------------------------------------\n");
                }
                break;
        }
    }

    //kiem tra list chinh va 4 list phu co rong khong
    @Override
    public boolean isNotExist(int choice, boolean Errorshowing) {
        boolean empty = false;
        switch (choice) {
            case 0: //kiem tra list chinh
                if (this.isEmpty()) {
                    if (Errorshowing) {
                        System.out.println("You should add animals or import files of animals");
                    }
                    empty = true;
                }
                break;
            case 1://kiem tra list No Legged
                if (nl.isEmpty()) {
                    if (Errorshowing) {
                        System.out.println("You should add No Legged Animals or import files of animals");
                    }
                    empty = true;
                }
                break;
            case 2:// kiem tra list Bipedal and Flightless
                if (bai.isEmpty()) {
                    if (Errorshowing) {
                        System.out.println("You should add Bipedal and Flightless animals or import files of animals");
                    }
                    empty = true;
                }
                break;
            case 3://kiem tra list Bipedal and Flying
                if (bay.isEmpty()) {
                    if (Errorshowing) {
                        System.out.println("You should Bipedal and Flying animals or import files of animals");
                    }
                    empty = true;
                }
                break;
            case 4://kiem tra list No Legged
                if (fl.isEmpty()) {
                    if (Errorshowing) {
                        System.out.println("You should Four Legged animals or import files of animals");
                    }
                    empty = true;
                }
                break;
        }
        return empty;
    }

    //nhap gia tri theo tung thuoc tinh
    public String enterValue(int choice, boolean notNull) {
        String line = "";
        int nullChoice = notNull == true ? 1 : 2;
        if (choice == 5 || choice == 6 || choice == 10) {
            nullChoice = notNull == true ? 2 : 0;
        }
        switch (choice) {
            case 0://id No Legged
                line = Validation.checkStringFormat("No legged ID[0xxx] (x is a number): ", "Enter again", "^[0]\\d{3}$", nullChoice).toUpperCase();
                break;
            case 1://id Bipedal and flightless
                line = Validation.checkStringFormat("Bipedal and flightless ID[Bxxx] (x is a number): ", "Enter again", "^[B|b]\\d{3}$", nullChoice).toUpperCase();
                break;
            case 2: //id Bipedal and flying
                line = Validation.checkStringFormat("Bipedal and flying ID[Fxxx] (x is a number): ", "Enter again", "^[F|f]\\d{3}$", nullChoice).toUpperCase();
                break;
            case 3://id Four legged
                line = Validation.checkStringFormat("Four legged ID[4xxx] (x is a number): ", "Enter again", "^[4]\\d{3}$", nullChoice);
                break;
            case 4://name
                line = Validation.checkStringName("Name: ", "Just words, not numbers or special signs", "^.*(?=.*[^A-Za-z]){2,}.*$", nullChoice);
                break;
            case 5://leg(s)
                line += Validation.checkInteger("Legs: ", "Enter number more than 0", 0, 0, nullChoice);
                break;
            case 6://weight
                line += Validation.checkDouble("Weight: ", "Enter number more than 0", 0, 0, nullChoice);
                break;
            case 7://action(s)
                System.out.println("Action(s) can be enter one or more activites"
                        + "\nFor example: 'can creep' or 'can creep, can breathe'");
                line = Validation.checkStringName("Action(s): ", "Just word(s), not numbers or special signs", "^.*(?=.*[^A-Za-z]){2,}.*$", nullChoice).toLowerCase();
                line = Validation.inputSign(line, " ", ", ");
                break;
            case 8://feature(s)
                System.out.println("Feature(s) can be enter one or more activites"
                        + "\nFor example: 'cute' or 'cute, short'");
                line = Validation.checkStringName("Feature(s): ", "Just word, not number or special signs", "^.*(?=.*[^A-Za-z]){2,}.*$", nullChoice).toLowerCase();
                line = Validation.inputSign(line, " ", ", ");
                break;
            case 9://color(s)
                System.out.println("Color(s) can be enter one or more activites"
                        + "\nFor example: 'black' or 'black, white'");
                line = Validation.checkStringName("Color(s): ", "Just word, not number or special signs", "^.*(?=.*[^A-Za-z]){2,}.*$", nullChoice).toLowerCase();
                line = Validation.inputSign(line, " ", ", ");
                break;
            case 10://wings
                line += Validation.checkInteger("Swings (more than 1): ", "Enter numbers more than 1", 1, 0, nullChoice);
                break;
        }
        return line.trim();
    }

    //nhap file vao list
    public void writeFiletoList() throws FileNotFoundException, IOException {
        String fileName = "";
        int counter = 0;
        boolean checkingValue = false;
        fileName = Validation.checkFileName("Zoo Management", false); //nhap file name
        if (!fileName.isEmpty()) { //neu file name ton tai
            File f = new File(fileName);
            FileReader fr = new FileReader(f);
            BufferedReader bfr = new BufferedReader(fr);
            String line = "";
            String id = "";
            try {
                while ((line = bfr.readLine()) != null) {
                    counter = 1;
                    StringTokenizer temp = new StringTokenizer(line, ";");
                    while (temp.hasMoreTokens()) {
                        id = temp.nextToken().toUpperCase();
                        //nhap thong tin vao list No Legged
                        if (id.matches("^[0]\\d{3}$") && (find(id, 3) == -1)) {
                            writeFiletoEachList(line, 1);
                            for (int i = 0; i < 5; i++) {
                                id = temp.nextToken();
                            }
                            id = "";
                        }
                        //nhap thong tin vao list Bipedal and Flightless
                        if (id.matches("^[B|b]\\d{3}$") && (find(id, 4) == -1)) {
                            writeFiletoEachList(line, 2);
                            for (int i = 0; i < 6; i++) {
                                id = temp.nextToken();
                            }
                            id = "";
                        }
                        //nhap thong tin vao list Bipedal and Flying
                        if (id.matches("^[f|F]\\d{3}$") && (find(id, 5) == -1)) {
                            writeFiletoEachList(line, 3);
                            for (int i = 0; i < 5; i++) {
                                id = temp.nextToken();
                            }
                            id = "";
                        }
                        //nhap thong tin vao list No Legged
                        if (id.matches("^[4]\\d{3}$") && (find(id, 6) == -1)) {
                            writeFiletoEachList(line, 4);
                            for (int i = 0; i < 4; i++) {
                                id = temp.nextToken();
                            }
                            id = "";
                        }
                    }
                }
            } catch (IOException e) {
            } finally {
                if (bfr != null) {
                    bfr.close();
                }
                if (fr != null) {
                    fr.close();
                }
            }
            //neu file name khong co thong tin
            if (this.isEmpty() || counter == 0) {
                System.out.println(fileName + " has nothing to import");
                checkingValue = Validation.checkYN("Do you want to import other file (Y/N)? ");
                if (checkingValue) { //neu tiep tuc 'Y', neu quay ve Menu chinh - 'N'
                    writeFiletoList();
                }
            } else {
                //thong bao thanh cong
                System.out.println("File " + fileName + " is imported successfully");
            }
        }
    }

    // nhap file vao tung list phu
    public void writeFiletoEachList(String line, int choice) {
        String id = "", name = "", actions = "", features = "", colors = "";
        int legs = 0, swings = 0, position = 0;
        String tempInfo = "";
        double weight = 0;
        StringTokenizer temp = new StringTokenizer(line, ";");
        while (temp.hasMoreTokens()) {
            id = temp.nextToken().toUpperCase();
            if (find(id, 1) == -1) { // neu id khong trung lap
                name = temp.nextToken().toLowerCase();
                name = name.substring(0, 1).toUpperCase() + name.substring(1);
                tempInfo = temp.nextToken();
                legs = Integer.parseInt(checkDigit(tempInfo, 1));
                tempInfo = temp.nextToken();
                weight = Double.parseDouble(checkDigit(tempInfo, 2));
                actions = temp.nextToken();
                features = temp.nextToken();
                FourLegged fl1 = new FourLegged(id, name, legs, weight, actions, features);
                this.add(fl1);
                switch (choice) {
                    case 1:
                        //cap nhap vao list No Legged
                        colors = temp.nextToken();
                        nl.add(new NoLegged(id, name, legs, weight, actions, features, colors));
                        break;
                    case 2://cap nhap vao Bipedal And Flightless
                        colors = temp.nextToken();
                        tempInfo = temp.nextToken();
                        swings = Integer.parseInt(checkDigit(tempInfo, 1));
                        bai.add(new BipedalAndFlightless(id, name, legs, weight, actions, features, colors, swings));
                        break;
                    case 3:
                        //cap nhap vao list Bipedal And Flying
                        tempInfo = temp.nextToken();
                        swings = Integer.parseInt(checkDigit(tempInfo, 1));
                        bay.add(new BipedalAndFlying(id, name, legs, weight, actions, features, swings));
                        break;
                    case 4:
                        //cap nhap vao list Four Legged
                        fl.add(new FourLegged(id, name, legs, weight, actions, features));
                        break;
                }
            } else {
                break;
            }
        }
    }

    //kiem tra thong tin kieu int, double khi nhap tu file vao list
    public String checkDigit(String line, int choice) {
        String result = "";
        switch (choice) {
            case 1: //lay so kieu int
                for (int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);
                    if (Character.isDigit(c)) {
                        result += c;
                    } else {
                        break;
                    }
                }
                break;
            case 2://lay so kieu double
                for (int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);
                    if (Character.isDigit(c) || c == '.') {
                        result += c;
                    } else {
                        break;
                    }
                }
                break;
        }
        return result.trim();
    }

    //xuat thong tin 4 kieu dong vat ra file
    public void savetoFile() throws FileNotFoundException {
        if (!isNotExist(0, true)) { //neu list chinh khong rong
            String fileName = Validation.checkFileName("Zoo Managment", true); //nhap file name
            if (!fileName.isEmpty()) { //neu file name ton tai
                File f = new File(fileName);
                PrintWriter pw = new PrintWriter(f);
                if (!nl.isEmpty()) { //nhap thong tin No Legged
                    for (NoLegged nl1 : nl) {
                        pw.print(nl1.toString(2) + "\n");
                    }
                }
                if (!nl.isEmpty()) { //nhap thong tin Bipedal and Flightless
                    for (BipedalAndFlightless bai1 : bai) {
                        pw.print(bai1.toString(2) + "\n");
                    }
                }
                if (!nl.isEmpty()) { //nhap thong tin Bipedal and Flying
                    for (BipedalAndFlying bay1 : bay) {
                        pw.print(bay1.toString(2) + "\n");
                    }
                }
                if (!nl.isEmpty()) {  //nhap thong tin Four Legged
                    for (FourLegged fl1 : fl) {
                        pw.print(fl1.toString(2) + "\n");
                    }
                }
                if (pw != null) {
                    pw.close();
                }
                System.out.println("Save to file successfully");
            }
        }
    }
}
