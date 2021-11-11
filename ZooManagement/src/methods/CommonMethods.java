/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

/**
 *
 * @author Nguyen Ngoc Phuong - SE150998 - SE1506 -LAB211 - LAB0004 - SPR2021
 */
// interface chua nhung chuc nang chung cua 4 kieu dong vat
public interface CommonMethods {
    //tim kiem dong vat thong qua 'findElement' va lua chon 'choice' theo tung kieu dong vat
    public int find(String findElement, int choice); 
    public void add();      //cho them dong vat
    public void update();   //chinh sua thong tin dong vat
    public void delete();   //xoa thong tin dong vat
    public void search();   // tim kiem dong vat
    public void show();     // hien thi thong tin dong vat
    public boolean isNotExist(int choice, boolean Errorshowing); //kiem tra danh sach cua tung kieu dong vat co rong hay khong
}
