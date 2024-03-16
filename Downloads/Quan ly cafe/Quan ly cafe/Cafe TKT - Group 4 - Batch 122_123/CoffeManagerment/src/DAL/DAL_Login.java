/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.ByUser;
import Entity.Login;
import Entity.Service;
import Entity.Shift;
import Entity.Shiftname;
import Entity.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Win 8 32bit VS7
 */
public class DAL_Login extends ConnectionDB {

    String show_Emp = "SELECT Code, Fullname , Addresss , Phone, Email , Roles FROM db_Login";
    String show_Shifft = "SELECT * FROM db_Shifts";
    String show_Code = "SELECT DISTINCT Code FROM db_Login ORDER BY Code";
   

    public boolean getCode(String sercode) {
        boolean check = false;
        String Get_Login = "SELECT * FROM db_Login WHERE Code=?";
        try {
            getConn();

            PreparedStatement pre = cn.prepareStatement(Get_Login);
            pre.setString(1, sercode);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setCode(rs.getString("Code"));
                check = true;
            }
            closeConn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public boolean getLogin(String userName, String passWord) {
        boolean check = false;
        String Get_Login = "SELECT * FROM db_Login WHERE Username=? AND Passwords=?";
        try {
            getConn();

            PreparedStatement pre = cn.prepareStatement(Get_Login);
            pre.setString(1, userName);
            pre.setString(2, passWord);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setFullname(rs.getString("Fullname"));
                check = true;
            }
            closeConn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public boolean insertEmp(String Code, String Fullname, String Address,
            String Phone, String Email, String Username, String Password, String Roles) {
        boolean check = false;
        try {
            getConn();
            String Insert_Emp = "INSERT INTO db_Login VALUES ('" + Code + "', N'" + Fullname + "', "
                    + "N'" + Address + "', '" + Phone + "', '" + Email + "', '" + Username + "', '" + Password + "', N'" + Roles + "')";
            Statement st = cn.createStatement();
            st.executeUpdate(Insert_Emp);

            closeConn();
            check = true;
        } catch (Exception E) {
            E.printStackTrace();
        }
        return check;
    }

    public boolean repassWord(String userName, String passWord) {
        boolean check = true;
        String Re_Pass = "UPDATE db_Login SET Passwords = '" + passWord + "'  WHERE Username = '" + userName + "' ";
        try {
            getConn();
            Statement st = cn.createStatement();
            st.executeUpdate(Re_Pass);

            closeConn();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return check;
    }

    public ArrayList<Login> showEmp() {
        ArrayList<Login> showEmp = new ArrayList<>();
        try {
            getConn();
            PreparedStatement pre = cn.prepareStatement(show_Emp);
            ResultSet rs = pre.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Login login = new Login();
                    login.setCode(rs.getString("Code"));
                    login.setFullname(rs.getString("Fullname"));
                    login.setAddresss(rs.getString("Addresss"));
                    login.setPhone(rs.getString("Phone"));
                    login.setEmail(rs.getString("Email"));
                    login.setRoles(rs.getString("Roles"));
                    showEmp.add(login);
                }
            }

            closeConn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return showEmp;
    }

    public boolean deleteEmp(String Code) {
        boolean check = true;
        String delete_Emp = "DELETE FROM db_Login WHERE Code = '" + Code + "'";
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

    public boolean editEmp(String Code, String Fullname, String Address, String Phone, String Email, String Roles, String Codes) {
        boolean check = true;
        try {
            getConn();
            String sql = "UPDATE db_Login SET Code = '" + Code + "', Fullname = N'" + Fullname + "', Addresss = N'" + Address + "',"
                    + "Phone = '" + Phone + "', Email = '" + Email + "', Roles = '" + Roles + "'  WHERE Code = '" + Codes + "'";
            Statement st = cn.createStatement();
            st.executeUpdate(sql);
            closeConn();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return check;
    }

    public ArrayList<Login> showCode(String code) {
        String show_Sercode = "SELECT * FROM db_Login WHERE Code = ?";
        ArrayList<Login> showCode = new ArrayList<>();
        try {
            getConn();
            PreparedStatement pre = cn.prepareStatement(show_Sercode);
            pre.setString(1, code);
            ResultSet rs = pre.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Login lg = new Login();
                    lg.setCode(rs.getString("Code"));
                    lg.setFullname(rs.getString("Fullname"));
                    lg.setAddresss(rs.getString("Addresss"));
                    lg.setPhone(rs.getString("Phone"));
                    lg.setEmail(rs.getString("Email"));
                    lg.setRoles(rs.getString("Roles"));
                    showCode.add(lg);
                }
            }

            closeConn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return showCode;
    }

    public ArrayList<Login> showPhone(String phone) {
        String show_Phone = "SELECT * FROM db_Login WHERE Phone = ?";
        ArrayList<Login> showPhone = new ArrayList<>();
        try {
            getConn();
            PreparedStatement pre = cn.prepareStatement(show_Phone);
            pre.setString(1, phone);
            ResultSet rs = pre.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Login lg = new Login();
                    lg.setCode(rs.getString("Code"));
                    lg.setFullname(rs.getString("Fullname"));
                    lg.setAddresss(rs.getString("Addresss"));
                    lg.setPhone(rs.getString("Phone"));
                    lg.setEmail(rs.getString("Email"));
                    lg.setRoles(rs.getString("Roles"));
                    showPhone.add(lg);
                }
            }

            closeConn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return showPhone;
    }

    public ArrayList<Login> showFullname(String fullname) {
            String show_Fullname = "SELECT * FROM db_Login WHERE Fullname like N'%" + fullname + "%'";
        ArrayList<Login> showFullname = new ArrayList<>();
        try {
            getConn();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(show_Fullname);
            if (rs != null) {
                while (rs.next()) {
                    Login lg = new Login();
                    lg.setCode(rs.getString("Code"));
                    lg.setFullname(rs.getString("Fullname"));
                    lg.setAddresss(rs.getString("Addresss"));
                    lg.setPhone(rs.getString("Phone"));
                    lg.setEmail(rs.getString("Email"));
                    lg.setRoles(rs.getString("Roles"));
                    showFullname.add(lg);
                }
            }

            closeConn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return showFullname;
    }

    public ArrayList<Shiftname> showShifts(String shiftname) {
        String show_Shift = "SELECT A.Code , A.Fullname , A.Addresss , A.Phone , A.Email ,"
                + " A.Roles , B.Shiftname FROM db_Login as A join "
                + "db_Shifts as B on A.Code = B.Code Where B.Shiftname like N'%" + shiftname + "%'";
        ArrayList<Shiftname> showShiftt = new ArrayList<>();
        try {
            getConn();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(show_Shift);
            if (rs != null) {
                while (rs.next()) {
                    Shiftname sfn = new Shiftname();
                    sfn.setCode(rs.getString("Code"));
                    sfn.setFullname(rs.getString("Fullname"));
                    sfn.setAddresss(rs.getString("Addresss"));
                    sfn.setPhone(rs.getString("Phone"));
                    sfn.setEmail(rs.getString("Email"));
                    sfn.setRoles(rs.getString("Roles"));
                    sfn.setShiftname(rs.getString("Shiftname"));
                    showShiftt.add(sfn);
                }
            }

            closeConn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return showShiftt;
    }

    public ArrayList<Login> showAccounts(String username) {
        String show_Account = "Select Username , "
                + "Fullname , Addresss , Phone, Email , Roles From db_Login WHERE Username like N'%" + username + "%'";
        ArrayList<Login> showAccounts = new ArrayList<>();
        try {
            getConn();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(show_Account);
            if (rs != null) {
                while (rs.next()) {
                    Login lg = new Login();
                    lg.setUsername(rs.getString("Username"));
                    lg.setFullname(rs.getString("Fullname"));
                    lg.setAddresss(rs.getString("Addresss"));
                    lg.setPhone(rs.getString("Phone"));
                    lg.setEmail(rs.getString("Email"));
                    lg.setRoles(rs.getString("Roles"));
                    showAccounts.add(lg);
                }
            }

            closeConn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return showAccounts;
    }

    public ArrayList<Login> showAccountsAll() {
        String show_AccountAll = "Select Username , "
                + "Fullname , Addresss , Phone, Email , Roles From db_Login";
        ArrayList<Login> showAccounts = new ArrayList<>();
        try {
            getConn();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(show_AccountAll);
            if (rs != null) {
                while (rs.next()) {
                    Login lg = new Login();
                    lg.setUsername(rs.getString("Username"));
                    lg.setFullname(rs.getString("Fullname"));
                    lg.setAddresss(rs.getString("Addresss"));
                    lg.setPhone(rs.getString("Phone"));
                    lg.setEmail(rs.getString("Email"));
                    lg.setRoles(rs.getString("Roles"));
                    showAccounts.add(lg);
                }
            }

            closeConn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return showAccounts;
    }

    public ArrayList<Shift> showShift() {
        ArrayList<Shift> showShift = new ArrayList<>();
        try {
            getConn();
            PreparedStatement pre = cn.prepareStatement(show_Shifft);
            ResultSet rs = pre.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Shift service = new Shift();
                    service.setCode(rs.getString("Code"));
                    service.setShiftname(rs.getString("Shiftname"));
                    service.setTimestart(rs.getString("Timestart"));
                    service.setTimestop(rs.getString("Timestop"));
                    
                    showShift.add(service);
                }
            }

            closeConn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return showShift;
    }
    public ArrayList<Login> showCode() {
        ArrayList<Login> showCode = new ArrayList<>();
        try {
            getConn();
            PreparedStatement pre = cn.prepareStatement(show_Code);
            ResultSet rs = pre.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Login service = new Login();
                    service.setCode(rs.getString("Code"));
                    showCode.add(service);
                }
            }

            closeConn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return showCode;
    }
    public ArrayList<Login> showFull(int Code) {
         String show_Fullname = "SELECT Fullname  FROM db_Login WHERE Code = "+Code+"";
        ArrayList<Login> showFullnames = new ArrayList<>();
        try {
            getConn();
            PreparedStatement pre = cn.prepareStatement(show_Fullname);
            ResultSet rs = pre.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Login lg = new Login();
                    lg.setFullname(rs.getString("Fullname"));
                    showFullnames.add(lg);
                }
            }

            closeConn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return showFullnames;
    }
    public ArrayList<Shift> showTime(String Shiftname) {
         String show_Fullname = "SELECT Timestart , Timestop  FROM db_Shifts WHERE Shiftname = '"+Shiftname+"'";
        ArrayList<Shift> showTime = new ArrayList<>();
        try {
            getConn();
            PreparedStatement pre = cn.prepareStatement(show_Fullname);
            ResultSet rs = pre.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Shift lg = new Shift();
                    lg.setTimestart(rs.getString("Timestart"));
                    lg.setTimestop(rs.getString("Timestop"));
                    showTime.add(lg);
                }
            }

            closeConn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return showTime;
    }
    public boolean insertShift(int code , String shiftname , String timestart , String timestop){
        
        boolean check = false;
        try {
            getConn();
            String Insert_Emp = "INSERT INTO db_Shifts VALUES (" + code + ", '" + shiftname + "', "
                    + "'" + timestart + "', '" + timestop + "')";
            Statement st = cn.createStatement();
            st.executeUpdate(Insert_Emp);

            closeConn();
            check = true;
        } catch (Exception E) {
            E.printStackTrace();
        }
        return check;
        
    }
    public boolean deleteLogin(String code){
         boolean check = true;
        String delete_Emp = "DELETE FROM db_Login WHERE Code = " + code + "";
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
