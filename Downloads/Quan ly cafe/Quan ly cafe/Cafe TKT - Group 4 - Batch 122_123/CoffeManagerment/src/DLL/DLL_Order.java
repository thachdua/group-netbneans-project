/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLL;

import DAL.DAL_Order;
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
public class DLL_Order {
    DAL_Order order = new DAL_Order();
    public ArrayList<Order> showSell() {
        return order.showSell();
    }
    public ArrayList<Order> showBydate(String date) {
        return order.showBydate(date);
    }
    public ArrayList<Order> showbyFullname( String fullname) {
        return order.showbyFullname(fullname);
    }
    public ArrayList<OrderDetail> showbyOrderId( String orderId) {
        return order.showbyOrderid(orderId);
    }
    public ArrayList<Order> showOrderid() {
        return order.showOrderid();
    }
    public boolean deleteOrderid(int Orderid, String serName){
        return order.deleteOrderid(Orderid, serName);
    }
    public boolean updatePrice(int priceTotal , int Orderid){
        return order.updatePrice(priceTotal, Orderid);
    }
}
