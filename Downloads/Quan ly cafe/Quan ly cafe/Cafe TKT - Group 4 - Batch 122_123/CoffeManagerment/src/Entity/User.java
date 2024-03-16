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
public class User {

    private String Code;
    private String Fullname;
    private String Addresss;
    private String Phone;
    private String Email;
    private String Username;
    private String Password;
    private String Roles;

    public User() {
    }

    public User(String Code, String Fullname, String Addresss, String Phone, String Email, String Username, String Password, String Roles) {
        this.Code = Code;
        this.Fullname = Fullname;
        this.Addresss = Addresss;
        this.Phone = Phone;
        this.Email = Email;
        this.Username = Username;
        this.Password = Password;
        this.Roles = Roles;
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
     * @return the Addresss
     */
    public String getAddresss() {
        return Addresss;
    }

    /**
     * @param Addresss the Addresss to set
     */
    public void setAddresss(String Addresss) {
        this.Addresss = Addresss;
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
     * @return the Username
     */
    public String getUsername() {
        return Username;
    }

    /**
     * @param Username the Username to set
     */
    public void setUsername(String Username) {
        this.Username = Username;
    }

    /**
     * @return the Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * @param Password the Password to set
     */
    public void setPassword(String Password) {
        this.Password = Password;
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

}
