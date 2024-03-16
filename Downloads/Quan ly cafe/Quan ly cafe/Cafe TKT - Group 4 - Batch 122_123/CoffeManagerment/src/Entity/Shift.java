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
public class Shift {
    private String Code;
    private String Shiftname;
    private String Timestart;
    private String Timestop;

    public Shift() {
    }

    public Shift(String Code, String Shiftname, String Timestart, String Timestop) {
        this.Code = Code;
        this.Shiftname = Shiftname;
        this.Timestart = Timestart;
        this.Timestop = Timestop;
    }

    /**
     * @return the Code
     */
    public String getCode() {
        return Code;
    }

    /**
     * @param Code the Code to set
     */
    public void setCode(String Code) {
        this.Code = Code;
    }

    /**
     * @return the Shiftname
     */
    public String getShiftname() {
        return Shiftname;
    }

    /**
     * @param Shiftname the Shiftname to set
     */
    public void setShiftname(String Shiftname) {
        this.Shiftname = Shiftname;
    }

    /**
     * @return the Timestart
     */
    public String getTimestart() {
        return Timestart;
    }

    /**
     * @param Timestart the Timestart to set
     */
    public void setTimestart(String Timestart) {
        this.Timestart = Timestart;
    }

    /**
     * @return the Timestop
     */
    public String getTimestop() {
        return Timestop;
    }

    /**
     * @param Timestop the Timestop to set
     */
    public void setTimestop(String Timestop) {
        this.Timestop = Timestop;
    }
    
}
