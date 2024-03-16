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
public class Store {
    private String Sercode;
    private int Total;

    public Store() {
    }

    public Store(String Sercode, int Total) {
        this.Sercode = Sercode;
        this.Total = Total;
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
