/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.Service;
import Entity.Shift;
import Entity.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Win 8 32bit VS7
 */
public class DAL_Shift extends ConnectionDB{
    String show_Shift = "SELECT DISTINCT Shiftname FROM db_Shifts ORDER BY Shiftname";
    public ArrayList<Shift> showShiftname() {
        ArrayList<Shift> showShiftname = new ArrayList<>();
        try {
            getConn();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(show_Shift);
            if (rs != null) {
                while (rs.next()) {
                    Shift sf = new Shift();
                    sf.setShiftname(rs.getString("Shiftname"));
                    showShiftname.add(sf);
                }
            }

            closeConn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return showShiftname;
    }
    public boolean getCode(String code , String shiftname) {
        boolean check = false;
        String Get_Login = "SELECT * FROM db_Shifts WHERE Code = ? AND Shiftname like ?";
        try {
            getConn();

            PreparedStatement pre = cn.prepareStatement(Get_Login);
            pre.setString(1, code);
            pre.setString(2, shiftname);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                Shift shif = new Shift();
                shif.setCode(rs.getString("Code"));
                shif.setShiftname(rs.getString("Shiftname"));
                check = true;
            }
            closeConn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
    public boolean deleteShift(String code){
         boolean check = true;
        String delete_Emp = "DELETE FROM db_Shifts WHERE Code = " + code + "";
        try {
            getConn();
            Statement st = cn.createStatement();
            st.executeUpdate(delete_Emp);

            closeConn();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return check;
    }
    
}
