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
public class Shiftname {
    private String Code;
    private String Fullname;
    private String Address;
    private String Phone;
    private String Email;
    private String Roles;
    private String Shiftname;

    public Shiftname() {
    }

    public Shiftname(String Code, String Fullname, String Phone, String Email, String Roles, String Shiftname) {
        this.Code = Code;
        this.Fullname = Fullname;
        this.Phone = Phone;
        this.Email = Email;
        this.Roles = Roles;
        this.Shiftname = Shiftname;
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
     * @return the Fullname
     */
    public String getFullname() {
        return Fullname;
    }

    /**
     * @param Fullname the Fullname to set
     */
    public void setFullname(String Fullname) {
        this.Fullname = Fullname;
    }

    /**
     * @return the Phone
     */
    public String getPhone() {
        return Phone;
    }

    /**
     * @param Phone the Phone to set
     */
    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    /**
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     * @return the Roles
     */
    public String getRoles() {
        return Roles;
    }

    /**
     * @param Roles the Roles to set
     */
    public void setRoles(String Roles) {
        this.Roles = Roles;
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
     * @return the Addresss
     */
    public String getAddress() {
        return Address;
    }

    /**
     * @param Addresss the Addresss to set
     */
    public void setAddresss(String Address) {
        this.Address = Address;
    }
    
}
