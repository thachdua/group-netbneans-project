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
public class ByUser {
    private String fullName;
    private String address;
    private String phone;
    private String roles;
    private String shiftName;
    private String timeStart;
    private String timeStop;

    public ByUser() {
    }

    public ByUser(String fullName, String address, String phone, String roles, String shiftName, String timeStart, String timeStop) {
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.roles = roles;
        this.shiftName = shiftName;
        this.timeStart = timeStart;
        this.timeStop = timeStop;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getShiftName() {
        return shiftName;
    }

    public void setShiftName(String shiftName) {
        this.shiftName = shiftName;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeStop() {
        return timeStop;
    }

    public void setTimeStop(String timeStop) {
        this.timeStop = timeStop;
    }
    
}
