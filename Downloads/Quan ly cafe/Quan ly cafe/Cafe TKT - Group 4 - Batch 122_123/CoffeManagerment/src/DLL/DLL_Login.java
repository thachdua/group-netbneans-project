/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLL;

import DAL.DAL_Login;
import Entity.ByUser;
import Entity.Login;
import Entity.Service;
import Entity.Shift;
import Entity.Shiftname;
import java.util.ArrayList;

/**
 *
 * @author Win 8 32bit VS7
 */
public class DLL_Login {

    DAL_Login login = new DAL_Login();

    public boolean getLogin(String userName, String passWord) {
        return login.getLogin(userName, passWord);
    }

    public boolean getCode(String code) {
        return login.getCode(code);
    }

    public boolean insertEmp(String Code, String Fullname,
            String Address, String Phone, String Email, String Username, String Password, String Roles) {
        return login.insertEmp(Code, Fullname, Address, Phone, Email, Username, Password, Roles);
    }

    public boolean repassWord(String userName, String passWord) {
        return login.repassWord(userName, passWord);
    }

    public ArrayList<Login> showEmp() {
        return login.showEmp();
    }

    public boolean deleteEmp(String Code) {
        return login.deleteEmp(Code);
    }

    public boolean editEmp(String Code, String Fullname, String Address, String Phone, String Email, String Roles, String Codes) {
        return login.editEmp(Code, Fullname, Address, Phone, Email, Roles, Codes);
    }

    public ArrayList<Login> showCode(String code) {
        return login.showCode(code);
    }

    public ArrayList<Login> showPhone(String phone) {
        return login.showPhone(phone);
    }

    public ArrayList<Login> showFullname(String fullname) {
        return login.showFullname(fullname);
    }

    public ArrayList<Shiftname> showShifts(String shiftname) {
        return login.showShifts(shiftname);
    }

    public ArrayList<Login> showAccount(String username) {
        return login.showAccounts(username);
    }

    public ArrayList<Login> showAccountAll() {
        return login.showAccountsAll();
    }

    public ArrayList<Shift> showShift() {
        return login.showShift();
    }
    public ArrayList<Login> showCode() {
        return login.showCode();
    }
    public ArrayList<Login> showFull(int code) {
        return login.showFull(code);
    }
    public ArrayList<Shift> showtime(String Shiftname) {
        return login.showTime(Shiftname);
    }
    public boolean insertShift(int code, String shiftname, String timestart , String timestop){
        return login.insertShift(code, shiftname, timestart, timestop);
    }
    public boolean deleteLogin(String code){
        return login.deleteLogin(code);
    }

}
