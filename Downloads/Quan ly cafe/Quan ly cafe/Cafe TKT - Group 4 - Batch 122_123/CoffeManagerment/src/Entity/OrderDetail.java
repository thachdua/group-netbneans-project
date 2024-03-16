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
public class OrderDetail {
    private int OrderId;
    private String SerName;
    private int Quantity;
    private int Price;
    private String Note;
    private int Sercode;

    public OrderDetail() {
    }

    public OrderDetail(int OrderId, String SerName, int Quantity, int Price, String Note) {
        this.OrderId = OrderId;
        this.SerName = SerName;
        this.Quantity = Quantity;
        this.Price = Price;
        this.Note = Note;
    }

    /**
     * @return the OrderId
     */
    public int getOrderId() {
        return OrderId;
    }

    /**
     * @param OrderId the OrderId to set
     */
    public void setOrderId(int OrderId) {
        this.OrderId = OrderId;
    }

    /**
     * @return the SerName
     */
    public String getSerName() {
        return SerName;
    }

    /**
     * @param SerName the SerName to set
     */
    public void setSerName(String SerName) {
        this.SerName = SerName;
    }

    /**
     * @return the Quantity
     */
    public int getQuantity() {
        return Quantity;
    }

    /**
     * @param Quantity the Quantity to set
     */
    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    /**
     * @return the Price
     */
    public int getPrice() {
        return Price;
    }

    /**
     * @param Price the Price to set
     */
    public void setPrice(int Price) {
        this.Price = Price;
    }

    /**
     * @return the Note
     */
    public String getNote() {
        return Note;
    }

    /**
     * @param Note the Note to set
     */
    public void setNote(String Note) {
        this.Note = Note;
    }

    /**
     * @return the Sercode
     */
    public int getSercode() {
        return Sercode;
    }

    /**
     * @param Sercode the Sercode to set
     */
    public void setSercode(int Sercode) {
        this.Sercode = Sercode;
    }
    
}
