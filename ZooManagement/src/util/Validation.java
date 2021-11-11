/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

/**
 *
 * @author Nguyen Ngoc Phuong - SE150998 - SE1506 -LAB211 - LAB0004 - SPR2021
 */
public class Validation {

    static Scanner sc = new Scanner(System.in);
    static String enteringValue = "";
    static int counter = 0;

    //nhap kieu String, khong dieu kien
    public static String freeString(String information) {
        System.out.print(information);
        enteringValue = sc.nextLine();
        return enteringValue;
    }

    //nhap kieu String, co dieu kien
    public static String checkStringFormat(String information, String error, String format, int choice) {
        while (true) {
            Pattern p = Pattern.compile(format);
            System.out.print(information);
            enteringValue = sc.nextLine().trim();
            switch (choice) {
                case 1: //kiem tra rong
                    if (enteringValue.isEmpty() || enteringValue.matches(format) == false) {
                        System.out.println(error);
                        counter = 1;
                    } else {
                        counter = 0;
                    }
                    break;
                default: //khong kiem tra rong
                    if (enteringValue.matches(format) == false && enteringValue.isEmpty() == false) {
                        System.out.println(error);
                        counter = 1;
                    } else {
                        counter = 0;
                    }
                    break;
            }
            if (counter != 1) {
                return enteringValue;
            }
        }
    }

    //kiem tra String la chu, co dieu kien
    public static String checkStringName(String information, String error, String format, int choice) {
        switch (choice) {
            case 1: //kiem tra rong
                while (true) {
                    System.out.print(information);
                    enteringValue = sc.nextLine().trim().toLowerCase();
                    if (enteringValue.isEmpty() == false) {
                        break;
                    } else {
                        System.out.println("Enter again");
                    }
                }
                //kiem tra chuoi String
                enteringValue = checkName(information, enteringValue, error, format, choice);
                break;
            default:// khong kiem tra rong
                while (true) {
                    System.out.print(information);
                    enteringValue = sc.nextLine().trim().toLowerCase();
                    if (enteringValue.isEmpty()) {
                        break;
                    } else {
                        //kiem tra chuoi String
                        enteringValue = checkName1(information, enteringValue, error, format, choice);
                        break;
                    }
                }
                break;
        }
        return enteringValue;
    }

    //kiem tra chuoi String, co dieu kien, hop le
    public static String checkName(String information, String name, String error, String format, int choice) {
        String rep = "";
        StringTokenizer temp = new StringTokenizer(name, ", ");
        name = "";
        while (temp.hasMoreTokens()) {
            rep = temp.nextToken().trim();
            boolean match = rep.matches(format);
            if (match == false) {
                name = name + " " + rep.substring(0, 1).toUpperCase() + rep.substring(1);
                rep = "";
            } else {
                System.out.println(error);
                name = checkStringName(information, error, format, choice);
            }
        }
        return name.trim();

    }

    //kiem tra chuoi String, co dieu kien, neu sai se quay ve checkStringName
    public static String checkName1(String information, String name, String error, String format, int choice) {
        String rep = "";
        StringTokenizer temp = new StringTokenizer(name, ", ");
        name = "";
        while (temp.hasMoreTokens()) {
            rep = temp.nextToken().trim();
            boolean match = rep.matches(format);
            if (match == false) {
                name = name + " " + rep.substring(0, 1).toUpperCase() + rep.substring(1);
                rep = "";
            } else {
                name = checkStringName(information, error, format, choice);
                break;
            }
        }
        return name.trim();

    }

    //kiem tra kieu int, co dieu kien
    public static int checkInteger(String information, String error, int min, int max, int choice) {
        int enterInteger = 0;
        if (max < min) {
            int temp = min;
            min = max;
            max = min;
        }
        switch (choice) {
            case 1: // trong khoang min, max, khong rong
                while (true) {
                    try {
                        System.out.print(information);
                        enterInteger = Integer.parseInt(sc.nextLine().trim());
                        if (enterInteger < min || enterInteger > max) {
                            throw new Exception();
                        }
                        return enterInteger;
                    } catch (Exception e) {
                        System.out.println(error);
                    }
                }
            case 2: // kiem tra lon hon min,
                while (true) {
                    try {
                        System.out.print(information);
                        enterInteger = Integer.parseInt(sc.nextLine().trim());
                        if (enterInteger <= min) {
                            throw new Exception();
                        }
                        return enterInteger;
                    } catch (Exception e) {
                        System.out.println(error);
                    }
                }
            default:// kiem tra rong
                while (true) {
                    try {
                        System.out.println(information);
                        enteringValue = sc.nextLine().trim();
                        if (enteringValue.isEmpty()){
                            return enterInteger = -1;
                        } else{
                            if (Integer.parseInt(enteringValue) <= min){
                                System.out.println(error);
                            } else {
                                return enterInteger = Integer.parseInt(enteringValue);
                            }
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Just numbers!");
                        enterInteger = checkInteger(information, error, min, max, choice);
                        break;
                    }
                }
                break;
        }

        return enterInteger;
    }

    //kiem tra kieu int cua menu, co dieu kien
    public static int checkInputMenu(String information, String error, int min, int max) {
        int enterInteger = 0;
        if (max < min) {
            int temp = min;
            min = max;
            max = min;
        }
        while (true) {
            try {
                System.out.print(information + "\n");
                System.out.print("Enter choice: ");
                enterInteger = Integer.parseInt(sc.nextLine().trim());
                if (enterInteger < min || enterInteger > max) {
                    throw new Exception();
                }
                return enterInteger;
            } catch (Exception e) {
                System.out.println(error);
            }
        }
    }

    //kiem tra kieu double, co dieu kien
    public static double checkDouble(String information, String error, double min, double max, int choice) {
        double enterDouble = 0;
        if (max < min) {
            double temp = min;
            min = max;
            max = min;
        }
        switch (choice) {
            case 1://kiem tra trong khoang min, max
                while (true) {
                    try {
                        System.out.print(information);
                        enterDouble = Double.parseDouble(sc.nextLine().trim());
                        if (enterDouble < min || enterDouble > max) {
                            throw new Exception();
                        } else {
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println(error);
                    }
                }
                break;
            case 2: //kiem tra nho hon min
                while (true) {
                    try {
                        System.out.print(information);
                        enterDouble = Double.parseDouble(sc.nextLine().trim());
                        if (enterDouble < min) {
                            throw new Exception();
                        } else {
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println(error);
                    }
                }
                break;
            default: //kiem tra rong
                while (true) {
                    try {
                        System.out.print(information);
                        enteringValue = sc.nextLine().trim();
                        if (enteringValue.isEmpty()) {
                            return enterDouble = -1;
                        } else {
                            if (Double.parseDouble(enteringValue) <= min) {
                                System.out.println(error);
                            } else {
                                return enterDouble = Double.parseDouble(enteringValue);
                            }
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Just number!");
                        return enterDouble = checkDouble(information, error, min, max, choice);
                    }
                }
        }
        return enterDouble;
    }

    //kiem tra Y/N 
    public static boolean checkYN(String information) {
        boolean check = false;
        enteringValue = checkStringFormat(information, "Enter Y or N", "[Y|y|N|n]{1}", 1);
        if (enteringValue.equals("y") || enteringValue.equals("Y")) {
            check = true;
        }
        return check;
    }

    //kiem tra file name co ton tai
    public static boolean checkExistFile(String fileName) {
        boolean result = false;
        File f = new File(fileName);
        if (f.exists()) {
            result = true;
        }
        return result;
    }

    //kiem tra filename
    public static String checkFileName(String kind, boolean savingOrNot) {
        while (true) {
            System.out.println("\n--------------------------------------------------");
            String fileName = freeString("Enter file name " + kind + ": ");
            if (checkExistFile(fileName)) {
                return fileName;
            } else {
                if (savingOrNot) {
                    System.out.println("Cannot find " + fileName);
                    return checkSaveToFile(fileName, kind);
                } else {
                    boolean checkValue = checkYN(fileName + " is not existed.\n"
                            + "Do you want to import other file name (Y/N)? ");
                    if (checkValue == false) {
                        return fileName = "";
                    }
                }
            }
        }
    }

    //kiem tra file name kieu save
    public static String checkSaveToFile(String fileName, String kind) {
        int choice = 0;
        String result = "";
        String subMenu = "Do you want to"
                + "\n1-Enter other file to save"
                + "\n2-Create file to save"
                + "\n3-Back to Menu"
                + "\nEnter choice: ";
        String error = "Enter 1 - 3";
        while (true) {
            choice = checkInteger(subMenu, error, 1, 3, 1);
            if (choice == 1) { //nhap file khac
                result = checkFileName(kind, true);
                return result;
            }
            if (choice == 2) { //tao file de luu
                try {
                    fileName = freeString("Enter file name to create: ");
                    if (fileName.contains(".txt") == false) {
                        fileName += ".txt";
                    }
                    File f = new File(fileName);
                    if (!f.exists()) { //neu file khong ton tai
                        f.createNewFile(); //tao file moi
                        System.out.println(fileName + " is created");
                        return result = fileName;
                    } else {//file co ton tai
                        return result = fileName;
                    }
                } catch (IOException e) {
                }
            }
            if (choice == 3){
                return fileName = "";
            }
        }
    }
    
    public static String inputSign(String information, String delim,String sign){
        if (!information.isEmpty()){
        StringTokenizer str = new StringTokenizer(information, delim);
        information = "";
        while (str.hasMoreTokens()){
            information = information + str.nextToken() + sign;
        }
        return information = information.substring(0, information.length() - 2).trim();
    }
        return information;
    }
}
