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
public class Order {
    private String OrderId;
    private String Seller;
    private String SellDate;
    private int Total;

    public Order() {
    }

    public Order(String OrderId, String Seller, String SellDate, int Total) {
        this.OrderId = OrderId;
        this.Seller = Seller;
        this.SellDate = SellDate;
        this.Total = Total;
    }

    /**
     * @return the OrderId
     */
    public String getOrderId() {
        return OrderId;
    }

    /**
     * @param OrderId the OrderId to set
     */
    public void setOrderId(String OrderId) {
        this.OrderId = OrderId;
    }

    /**
     * @return the Seller
     */
    public String getSeller() {
        return Seller;
    }

    /**
     * @param Seller the Seller to set
     */
    public void setSeller(String Seller) {
        this.Seller = Seller;
    }

    /**
     * @return the SellDate
     */
    public String getSellDate() {
        return SellDate;
    }

    /**
     * @param SellDate the SellDate to set
     */
    public void setSellDate(String SellDate) {
        this.SellDate = SellDate;
    }

    /**
     * @return the Total
     */
    public int getTotal() {
        return Total;
    }

    /**
     * @param Total the Total to set
     */
    public void setTotal(int Total) {
        this.Total = Total;
    }
    
}
