/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Win 8 32bit VS7
 */
public class Price {

    private String deskNumber;
    private String sellerDate;
    private String sellerName;
    private int totalPrice;

    public Price() {
    }

    public Price(String deskNumber, String sellerDate, String sellerName, int totalPrice) {
        this.deskNumber = deskNumber;
        this.sellerDate = sellerDate;
        this.sellerName = sellerName;
        this.totalPrice = totalPrice;
    }

    public String getDeskNumber() {
        return deskNumber;
    }

    public void setDeskNumber(String deskNumber) {
        this.deskNumber = deskNumber;
    }

    public String getSellerDate() {
        return sellerDate;
    }

    public void setSellerDate(String sellerDate) {
        this.sellerDate = sellerDate;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
    
}
