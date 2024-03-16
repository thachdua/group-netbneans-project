/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.Login;
import Entity.Order;
import Entity.Quantity;
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
public class DAL_Services extends ConnectionDB {

    String select_Service = "SELECT Price From db_Services WHERE Sername = N'?'";
    String show_Service = "SELECT * FROM db_Services";
    String show_Sercode = "SELECT * FROM db_Services WHERE Sercode = ?";
    String show_Price = "SELECT * FROM db_Services WHERE Price = ?";
    
    String show_Unit = "SELECT DISTINCT Unit FROM db_Services ORDER BY Unit";

    public ArrayList<Service> showCbb1() {
        String classsify = "Tráng Miệng";
        String show_Cbb = "SELECT Sername FROM db_Services WHERE Classify = N'" + classsify + "'";
        ArrayList<Service> showCbb1 = new ArrayList<>();
        try {
            getConn();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(show_Cbb);
            if (rs != null) {
                while (rs.next()) {
                    Service sv = new Service();
                    sv.setSername(rs.getString("Sername"));
                    showCbb1.add(sv);
                }
            }

            closeConn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return showCbb1;
    }

    public ArrayList<Service> showCbb2() {
        String classsify = "Cafe";
        String show_Cbb = "SELECT Sername FROM db_Services WHERE Classify = N'" + classsify + "'";
        ArrayList<Service> showCbb2 = new ArrayList<>();
        try {
            getConn();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(show_Cbb);
            if (rs != null) {
                while (rs.next()) {
                    Service sv = new Service();
                    sv.setSername(rs.getString("Sername"));
                    showCbb2.add(sv);
                }
            }

            closeConn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return showCbb2;
    }

    public ArrayList<Service> showCbb3() {
        String classsify = "Sữa";
        String show_Cbb = "SELECT Sername FROM db_Services WHERE Classify = N'" + classsify + "'";
        ArrayList<Service> showCbb3 = new ArrayList<>();
        try {
            getConn();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(show_Cbb);
            if (rs != null) {
                while (rs.next()) {
                    Service sv = new Service();
                    sv.setSername(rs.getString("Sername"));
                    showCbb3.add(sv);
                }
            }

            closeConn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return showCbb3;
    }

    public ArrayList<Service> showCbb4() {
       String classsify = "Nước Uống";
        String show_Cbb = "SELECT Sername FROM db_Services WHERE Classify = N'" + classsify + "'";
        ArrayList<Service> showCbb4 = new ArrayList<>();
        try {
            getConn();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(show_Cbb);
            if (rs != null) {
                while (rs.next()) {
                    Service sv = new Service();
                    sv.setSername(rs.getString("Sername"));
                    showCbb4.add(sv);
                }
            }

            closeConn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return showCbb4;
    }

    public ArrayList<Service> showCbb5() {
        String classsify = "Pha Chế";
        String show_Cbb = "SELECT Sername FROM db_Services WHERE Classify = N'" + classsify + "'";
        ArrayList<Service> showCbb5 = new ArrayList<>();
        try {
            getConn();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(show_Cbb);
            if (rs != null) {
                while (rs.next()) {
                    Service sv = new Service();
                    sv.setSername(rs.getString("Sername"));
                    showCbb5.add(sv);
                }
            }

            closeConn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return showCbb5;
    }

    public ArrayList<Service> showCbb6() {
        String classsify = "Nước Trái Cây";
        String show_Cbb = "SELECT Sername FROM db_Services WHERE Classify = N'" + classsify + "'";
        ArrayList<Service> showCbb6 = new ArrayList<>();
        try {
            getConn();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(show_Cbb);
            if (rs != null) {
                while (rs.next()) {
                    Service sv = new Service();
                    sv.setSername(rs.getString("Sername"));
                    showCbb6.add(sv);
                }
            }

            closeConn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return showCbb6;
    }

    public ArrayList<Service> showCbb7() {
        String classsify = "Thuốc Lá";
        String show_Cbb = "SELECT Sername FROM db_Services WHERE Classify = N'" + classsify + "'";
        ArrayList<Service> showCbb7 = new ArrayList<>();
        try {
            getConn();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(show_Cbb);
            if (rs != null) {
                while (rs.next()) {
                    Service sv = new Service();
                    sv.setSername(rs.getString("Sername"));
                    showCbb7.add(sv);
                }
            }

            closeConn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return showCbb7;
    }

    public ArrayList<Service> showSercode(String sercode) {
        ArrayList<Service> showSercode = new ArrayList<>();
        try {
            getConn();
            PreparedStatement pre = cn.prepareStatement(show_Sercode);
            pre.setString(1, sercode);
            ResultSet rs = pre.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Service sv = new Service();
                    sv.setSercode(rs.getString("Sercode"));
                    sv.setSername(rs.getString("Sername"));
                    sv.setUnit(rs.getString("Unit"));
                    sv.setPrice(rs.getInt("Price"));
                    sv.setQuantity(rs.getInt("Quantity"));
                    sv.setClassify(rs.getString("Classify"));
                    showSercode.add(sv);
                }
            }

            closeConn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return showSercode;
    }

    public ArrayList<Service> showPrice(String price) {
        ArrayList<Service> showSercode = new ArrayList<>();
        try {
            getConn();
            PreparedStatement pre = cn.prepareStatement(show_Price);
            pre.setString(1, price);
            ResultSet rs = pre.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Service sv = new Service();
                    sv.setSercode(rs.getString("Sercode"));
                    sv.setSername(rs.getString("Sername"));
                    sv.setUnit(rs.getString("Unit"));
                    sv.setPrice(rs.getInt("Price"));
                    sv.setQuantity(rs.getInt("Quantity"));
                    sv.setClassify(rs.getString("Classify"));
                    showSercode.add(sv);
                }
            }

            closeConn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return showSercode;
    }

    public ArrayList<Service> showClassyfy(String classify) {
        String show_Classify = "SELECT * FROM db_Services WHERE Classify = N'"+classify+"'";
        ArrayList<Service> showClassyfy = new ArrayList<>();
        try {
            getConn();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(show_Classify);
            if (rs != null) {
                while (rs.next()) {
                    Service sv = new Service();
                    sv.setSercode(rs.getString("Sercode"));
                    sv.setSername(rs.getString("Sername"));
                    sv.setUnit(rs.getString("Unit"));
                    sv.setPrice(rs.getInt("Price"));
                    sv.setQuantity(rs.getInt("Quantity"));
                    sv.setClassify(rs.getString("Classify"));
                    showClassyfy.add(sv);
                }
            }

            closeConn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return showClassyfy;
    }

    public ArrayList<Service> showUnit(String unit) {
        String show_Unit = "SELECT * FROM db_Services WHERE Unit = N'" + unit + "'";
        ArrayList<Service> showUnit = new ArrayList<>();
        try {
            getConn();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(show_Unit);
            if (rs != null) {
                while (rs.next()) {
                    Service sv = new Service();
                    sv.setSercode(rs.getString("Sercode"));
                    sv.setSername(rs.getString("Sername"));
                    sv.setUnit(rs.getString("Unit"));
                    sv.setPrice(rs.getInt("Price"));
                    sv.setQuantity(rs.getInt("Quantity"));
                    sv.setClassify(rs.getString("Classify"));
                    showUnit.add(sv);
                }
            }

            closeConn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return showUnit;
    }
    
    public ArrayList<Service> showClassify() {
        String show_Classify = "SELECT DISTINCT Classify FROM db_Services ORDER BY Classify";
        ArrayList<Service> showClassify = new ArrayList<>();
        try {
            getConn();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(show_Classify);
            if (rs != null) {
                while (rs.next()) {
                    Service sf = new Service();
                    sf.setClassify(rs.getString("Classify"));
                    showClassify.add(sf);
                }
            }

            closeConn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return showClassify;
    }
    public boolean getCode(String sercode) {
        boolean check = false;
        String Get_code = "SELECT * FROM db_Services WHERE Sercode =?";
        try {
            getConn();

            PreparedStatement pre = cn.prepareStatement(Get_code);
            pre.setString(1, sercode);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                Service sr = new Service();
                sr.setSercode(rs.getString("Sercode"));
                check = true;
            }
            closeConn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public ArrayList<Service> showSername(String sername) {
        String showSernames = "SELECT * FROM db_Services WHERE Sername = N'" + sername + "'";
        ArrayList<Service> showSername = new ArrayList<>();
        try {
            getConn();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(showSernames);
            if (rs != null) {
                while (rs.next()) {
                    Service sv = new Service();
                    sv.setSercode(rs.getString("Sercode"));
                    sv.setSername(rs.getString("Sername"));
                    sv.setUnit(rs.getString("Unit"));
                    sv.setPrice(rs.getInt("Price"));
                    sv.setQuantity(rs.getInt("Quantity"));
                    sv.setClassify(rs.getString("Classify"));
                    showSername.add(sv);
                }
            }

            closeConn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return showSername;
    }

    public ArrayList<Service> serviceSlect(String Select) {
        ArrayList<Service> serviceSlect = new ArrayList<>();
        String show_Where = "SELECT Price FROM db_Services WHERE Sername = N'?'";
        try {
            getConn();
            PreparedStatement pre = cn.prepareStatement(show_Where);
            pre.setString(1, Select);
            ResultSet rs = pre.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Service sv = new Service();
                    sv.setPrice(rs.getInt("Price"));
                    serviceSlect.add(sv);
                }
            }

            closeConn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return serviceSlect;
    }

    public ArrayList<Service> showService() {
        ArrayList<Service> showService = new ArrayList<>();
        try {
            getConn();
            PreparedStatement pre = cn.prepareStatement(show_Service);
            ResultSet rs = pre.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Service service = new Service();
                    service.setSercode(rs.getString("Sercode"));
                    service.setSername(rs.getString("Sername"));
                    service.setUnit(rs.getString("Unit"));
                    service.setPrice(rs.getInt("Price"));
                    service.setQuantity(rs.getInt("Quantity"));
                    service.setClassify(rs.getString("Classify"));
                    showService.add(service);
                }
            }

            closeConn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return showService;
    }

    public boolean insertServices(String Sercode, String Sername, String Unit, String Price, String Quantity, String Classify) {
        boolean check = false;
        try {
            getConn();
            String Insert_Services = "INSERT INTO db_Services VALUES ('" + Sercode + "', N'" + Sername + "', "
                    + "N'" + Unit + "', '" + Price + "', '" + Quantity + "', N'" + Classify + "')";
            Statement st = cn.createStatement();
            st.executeUpdate(Insert_Services);

            closeConn();
            check = true;
        } catch (Exception E) {
            E.printStackTrace();
        }
        return check;
    }

    public ArrayList<Service> showPircewhere(String sername) {
        String showSernames = "SELECT * FROM db_Services WHERE Sername like N'%" + sername + "%'";
        ArrayList<Service> showPirce = new ArrayList<>();
        try {
            getConn();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(showSernames);
            if (rs != null) {
                while (rs.next()) {
                    Service sv = new Service();
                    sv.setPrice(rs.getInt("Price"));
                    showPirce.add(sv);
                }
            }

            closeConn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return showPirce;
    }

    public ArrayList<Service> showCbbUnit() {
        ArrayList<Service> showCbbUnit = new ArrayList<>();
        try {
            getConn();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(show_Unit);
            if (rs != null) {
                while (rs.next()) {
                    Service sv = new Service();
                    sv.setUnit(rs.getString("Unit"));
                    showCbbUnit.add(sv);
                }
            }

            closeConn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return showCbbUnit;
    }
    public boolean editService(String Sercode, String Sername, String Unit, String Price, String Quantity, String Classify , String Sercodes) {
        boolean check = true;
        try {
            getConn();
            String editService = "UPDATE db_Services SET Sercode = '" + Sercode + "', Sername = N'" + Sername + "', Unit = N'" + Unit + "',"
                    + "Price = '" + Price + "', Quantity = '" + Quantity + "', Classify = N'" + Classify + "'  WHERE Sercode = '" + Sercodes + "'";
            Statement st = cn.createStatement();
            st.executeUpdate(editService);
            closeConn();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return check;
    }
    public boolean deleteServide(String Sercode) {
        boolean check = true;
        String delete_Servide = "DELETE FROM db_Services WHERE Sercode = '" + Sercode + "'";
        try {
            getConn();
            Statement st = cn.createStatement();
            st.executeUpdate(delete_Servide);

            closeConn();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return check;
    }
    public boolean insertOrder(int Orderid , String Seller, String Selldate, int Pricetotal){
        String insert_Order = "INSERT INTO db_Order VALUES ("+Orderid+",N'"+Seller+"','"+Selldate+"', "+Pricetotal+")";
        try{
            getConn();
            Statement st = cn.createStatement();
            st.executeUpdate(insert_Order);
            closeConn();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return true;
    }
    public boolean insertOrderDetailt(int Orderid , String Sername , int Quantity , int Price , String Note, String Sercode){
        String insert_OrderDetailt = "INSERT INTO db_OrderDetail VALUES ("+Orderid+",N'"+Sername+"', "+Quantity+", "+Price+", N'"+Note+"', '"+Sercode+"')";
        try{
            getConn();
            Statement st = cn.createStatement();
            st.addBatch(insert_OrderDetailt);
            st.executeBatch();
            cn.commit();
            closeConn();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        
        
        return true;
    }
    public ArrayList<Service> showSercodes(String Sername) {
        ArrayList<Service> showSercodes = new ArrayList<>();
        String show_Sercode = "SELECT Sercode FROM db_Services WHERE Sername like N'%" + Sername + "%'";
        try {
            getConn();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(show_Sercode);
            if (rs != null) {
                while (rs.next()) {
                    Service sv = new Service();
                    sv.setSercode(rs.getString("Sercode"));
                    showSercodes.add(sv);
                }
            }

            closeConn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return showSercodes;
    }
    
    public ArrayList<Quantity> showQuantity(String Sercode) {
        ArrayList<Quantity> showQuantity = new ArrayList<>();
        String show_Sercode = "SELECT A.Quantity-B.Quantity as Quantity  From db_Services as A\n" +
" join db_OrderDetail as B \n" +
" on A.Sercode = B.Sercode \n" +
" WHERE A.Sercode = "+Sercode+"";
        try {
            getConn();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(show_Sercode);
            if (rs != null) {
                while (rs.next()) {
                    Quantity sv = new Quantity();
                    sv.setQuantity(rs.getInt("Quantity"));
                    showQuantity.add(sv);
                }
            }

            closeConn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return showQuantity;
    } 
    
    public boolean updateQuantity(int Quantity , String sercode) {
        boolean check = true;
        try {
            getConn();
            String updateQuantity = "Update db_Services SET Quantity = "+Quantity+" WHERE Sercode = "+sercode+"";
            Statement st = cn.createStatement();
            st.executeUpdate(updateQuantity);
            closeConn();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return check;
    }
    public boolean updateQuantitybyorder(String serName) {
        boolean check = true;
        try {
            getConn();
            String updateQuantity = "Update db_Services SET Quantity = '0' WHERE Sername like N'%"+serName+"%'";
            Statement st = cn.createStatement();
            st.executeUpdate(updateQuantity);
            closeConn();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return check;
    }
    
}
