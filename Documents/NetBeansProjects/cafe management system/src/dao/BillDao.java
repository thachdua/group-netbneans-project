/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.awt.Component;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Bill;

public class BillDao {
    public BillDao() {
    }

    public static String getId() {
        int id = 1;

        try {
            ResultSet rs = DbOperations.getData("select max(id) from bill");
            if (rs.next()) {
                id = rs.getInt(1);
                ++id;
            }
        } catch (Exception var2) {
            JOptionPane.showMessageDialog((Component)null, var2);
        }

        return String.valueOf(id);
    }

    public static void save(Bill bill) {
        int var10000 = bill.getId();
        String query = "insert into bill values ('" + var10000 + "','" + bill.getName() + "','" + bill.getMobileNumber() + "','" + bill.getEmail() + "','" + bill.getDate() + "','" + bill.getTotal() + "','" + bill.getCreatedBy() + "')";
        DbOperations.setDataOrDelete(query, "Bill details added successfully");
    }

    public static ArrayList<Bill> getAllRecordsByInc(String date) {
        ArrayList<Bill> arrayList = new ArrayList();

        try {
            ResultSet rs = DbOperations.getData("select * from bill where date like '%" + date + "%'");

            while(rs.next()) {
                Bill bill = new Bill();
                bill.setId(rs.getInt("id"));
                bill.setName(rs.getString("name"));
                bill.setMobileNumber(rs.getString("mobileNumber"));
                bill.setEmail(rs.getString("email"));
                bill.setDate(rs.getString("date"));
                bill.setTotal(rs.getString("total"));
                bill.setCreatedBy(rs.getString("createdBy"));
                arrayList.add(bill);
            }
        } catch (Exception var4) {
            JOptionPane.showMessageDialog((Component)null, var4);
        }

        return arrayList;
    }

    public static ArrayList<Bill> getAllRecordsByDesc(String date) {
        ArrayList<Bill> arrayList = new ArrayList();

        try {
            ResultSet rs = DbOperations.getData("select * from bill where date like '%" + date + "%' order by id DESC");

            while(rs.next()) {
                Bill bill = new Bill();
                bill.setId(rs.getInt("id"));
                bill.setName(rs.getString("name"));
                bill.setMobileNumber(rs.getString("mobileNumber"));
                bill.setEmail(rs.getString("email"));
                bill.setDate(rs.getString("date"));
                bill.setTotal(rs.getString("total"));
                bill.setCreatedBy(rs.getString("createdBy"));
                arrayList.add(bill);
            }
        } catch (Exception var4) {
            JOptionPane.showMessageDialog((Component)null, var4);
        }

        return arrayList;
    }
}
