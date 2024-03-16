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
public class Service {
    private String Sercode;
    private String Sername;
    private String Unit;
    private int Price;
    private int Quantity;
    private String Classify;

    public Service() {
    }

    public Service(String Sercode, String Sername, String Unit, int Price, int Quantity, String Classify) {
        this.Sercode = Sercode;
        this.Sername = Sername;
        this.Unit = Unit;
        this.Price = Price;
        this.Quantity = Quantity;
        this.Classify = Classify;
    }

    public Service(String Sercode, String Sername, String Unit, int Price, String Classify) {
        this.Sercode = Sercode;
        this.Sername = Sername;
        this.Unit = Unit;
        this.Price = Price;
        this.Classify = Classify;
    }

    /**
     * @return the Sercode
     */
    public String getSercode() {
        return Sercode;
    }

    /**
     * @param Sercode the Sercode to set
     */
    public void setSercode(String Sercode) {
        this.Sercode = Sercode;
    }

    /**
     * @return the Sername
     */
    public String getSername() {
        return Sername;
    }

    /**
     * @param Sername the Sername to set
     */
    public void setSername(String Sername) {
        this.Sername = Sername;
    }

    /**
     * @return the Unit
     */
    public String getUnit() {
        return Unit;
    }

    /**
     * @param Unit the Unit to set
     */
    public void setUnit(String Unit) {
        this.Unit = Unit;
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
     * @return the Classify
     */
    public String getClassify() {
        return Classify;
    }

    /**
     * @param Classify the Classify to set
     */
    public void setClassify(String Classify) {
        this.Classify = Classify;
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
    
}
