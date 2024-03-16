/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.Order;
import Entity.OrderDetail;
import Entity.Service;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Win 8 32bit VS7
 */
public class DAL_Order extends ConnectionDB{
    public ArrayList<Order> showSell() {
        ArrayList<Order> showSell = new ArrayList<>();
        String show_Sell = "SELECT * FROM db_Order";
        try {
            getConn();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(show_Sell);
            if (rs != null) {
                while (rs.next()) {
                    Order sv = new Order();
                    sv.setOrderId(rs.getString("Orderid"));
                    sv.setSeller(rs.getString("Seller"));
                    sv.setSellDate(rs.getString("Selldate"));
                    sv.setTotal(rs.getInt("Pricetotal"));
                    showSell.add(sv);
                }
            }

            closeConn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return showSell;
    }
    public ArrayList<Order> showBydate(String date) {
        ArrayList<Order> showBydate = new ArrayList<>();
        String show_Sell = "SELECT * FROM db_Order WHERE Selldate = '"+date+"'";
        try {
            getConn();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(show_Sell);
            if (rs != null) {
                while (rs.next()) {
                    Order sv = new Order();
                    sv.setOrderId(rs.getString("Orderid"));
                    sv.setSeller(rs.getString("Seller"));
                    sv.setSellDate(rs.getString("Selldate"));
                    sv.setTotal(rs.getInt("Pricetotal"));
                    showBydate.add(sv);
                }
            }

            closeConn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return showBydate;
    }
    public ArrayList<Order> showbyFullname(String fullname) {
        String show_Fullname = "SELECT * FROM db_Order WHERE Seller like N'%" + fullname + "%'";
        ArrayList<Order> showbyFullname = new ArrayList<>();
        try {
            getConn();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(show_Fullname);
            if (rs != null) {
                while (rs.next()) {
                    Order sv = new Order();
                    sv.setOrderId(rs.getString("Orderid"));
                    sv.setSeller(rs.getString("Seller"));
                    sv.setSellDate(rs.getString("Selldate"));
                    sv.setTotal(rs.getInt("Pricetotal"));
                    showbyFullname.add(sv);
                }
            }

            closeConn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return showbyFullname;
    }
    
    public ArrayList<OrderDetail> showbyOrderid(String orderid) {
        String show_Fullname = "SELECT * FROM db_OrderDetail WHERE Orderid = '"+orderid+"'";
        ArrayList<OrderDetail> showbyOrderid = new ArrayList<>();
        try {
            getConn();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(show_Fullname);
            if (rs != null) {
                while (rs.next()) {
                    OrderDetail sv = new OrderDetail();
                    sv.setOrderId(rs.getInt("Orderid"));
                    sv.setSerName(rs.getString("Sername"));
                    sv.setQuantity(rs.getInt("Quantity"));
                    sv.setPrice(rs.getInt("Price"));
                    sv.setNote(rs.getString("Note"));
                    sv.setSercode(rs.getInt("Sercode"));
                    
                    showbyOrderid.add(sv);
                }
            }

            closeConn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return showbyOrderid;
    }
    public ArrayList<Order> showOrderid() {
        ArrayList<Order> showOrderid = new ArrayList<>();
        String show_Sercode = "SELECT TOP 1 Orderid FROM db_Order ORDER BY Orderid DESC";
        try {
            getConn();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(show_Sercode);
            if (rs != null) {
                while (rs.next()) {
                    Order sv = new Order();
                    sv.setOrderId(rs.getString("Orderid"));
                    showOrderid.add(sv);
                }
            }

            closeConn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return showOrderid;
    }
    public boolean deleteOrderid(int Orderid , String serName){
        boolean check = true;
        try {
            getConn();
            String updateQuantity = "DELETE FROM db_OrderDetail WHERE Orderid = '"+Orderid+"' AND Sername like N'%"+serName+"%'";
            Statement st = cn.createStatement();
            st.executeUpdate(updateQuantity);
            closeConn();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return check;
    }
    public boolean updatePrice(int priceTotal , int Orderid){
        boolean check = true;
        try {
            getConn();
            String updatePrice = "Update db_Order SET Pricetotal = "+priceTotal+" WHERE Orderid = "+Orderid+"";
            Statement st = cn.createStatement();
            st.executeUpdate(updatePrice);
            closeConn();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return check;
    }
}
