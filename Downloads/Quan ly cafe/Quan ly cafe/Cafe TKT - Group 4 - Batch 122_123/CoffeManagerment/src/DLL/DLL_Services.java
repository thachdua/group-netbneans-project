/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLL;

import DAL.DAL_Services;
import Entity.Login;
import Entity.Order;
import Entity.Service;
import Entity.Quantity;

import java.util.ArrayList;

/**
 *
 * @author Win 8 32bit VS7
 */
public class DLL_Services {

    DAL_Services service = new DAL_Services();

    public ArrayList<Service> showCbb1() {
        return service.showCbb1();
    }

    public ArrayList<Service> showCbb2() {
        return service.showCbb2();
    }

    public ArrayList<Service> showCbb3() {
        return service.showCbb3();
    }

    public ArrayList<Service> showCbb4() {
        return service.showCbb4();
    }

    public ArrayList<Service> showCbb5() {
        return service.showCbb5();
    }

    public ArrayList<Service> showCbb6() {
        return service.showCbb6();
    }

    public ArrayList<Service> showCbb7() {
        return service.showCbb7();
    }

    public ArrayList<Service> serviceSlect(String select) {
        return service.serviceSlect(select);
    }

    public ArrayList<Service> showService() {
        return service.showService();
    }
    public ArrayList<Service> showClassify() {
        return service.showClassify();
    }
    public boolean getSercode(String sercode){
        return service.getCode(sercode);
    }

    public boolean insertService(String Sercode, String Sername, String Unit, String Price, String Quantity, String Classify) {
        return service.insertServices(Sercode, Sername, Unit, Price, Quantity, Classify);
    }
    public boolean editService(String Sercode, String Sername, String Unit, String Price, String Quantity, String Classify , String Sercodes){
        return service.editService(Sercode, Sername, Unit, Price, Quantity, Classify, Sercodes);
    }
    public boolean deleteServide(String Sercode){
        return service.deleteServide(Sercode);
    }

    public ArrayList<Service> showSercode(String sercode) {
        return service.showSercode(sercode);
    }

    public ArrayList<Service> showPrice(String price) {
        return service.showPrice(price);
    }

    public ArrayList<Service> showClassify(String classify) {
        return service.showClassyfy(classify);
    }

    public ArrayList<Service> showUnit(String unit) {
        return service.showUnit(unit);
    }
    public ArrayList<Service> showSername(String sername) {
        return service.showSername(sername);
    }
    public ArrayList<Service> showPricewhere(String sername) {
        return service.showPircewhere(sername);
    }
    public ArrayList<Service> showCbbunit() {
        return service.showCbbUnit();
    }
    public boolean insertOrder(int Orderid ,String Seller, String Selldate, int Pricetotal){
        return service.insertOrder(Orderid, Seller, Selldate, Pricetotal);
    }
    public boolean insertOrderDetailt(int Orderid , String Sername , int Quantity , int Price , String Note, String Sercode){
        return service.insertOrderDetailt(Orderid, Sername, Quantity, Price, Note,Sercode);
    }
    public ArrayList<Service> showSercodes(String sername) {
        return service.showSercodes(sername);
    }
    public ArrayList<Quantity> showQuantity(String Sercode) {
        return service.showQuantity(Sercode);
    }
    public boolean updateQuantity(int Quantity , String Sercode){
        return service.updateQuantity(Quantity, Sercode);
    }
    public boolean updateQuantitybyOrderid(String serName){
        return service.updateQuantitybyorder(serName);
    }
    
    

}
