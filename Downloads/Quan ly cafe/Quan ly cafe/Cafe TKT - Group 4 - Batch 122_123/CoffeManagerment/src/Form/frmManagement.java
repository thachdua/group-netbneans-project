/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import DLL.DLL_Order;
import DLL.DLL_Services;
import Entity.Login;
import Entity.Order;
import Entity.Orderprice;
import Entity.Price;
import Entity.Quantity;
import Entity.Service;
import Entity.User;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Vector;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import sun.security.x509.AttributeNameEnumeration;

/**
 *
 * @author Win 8 32bit VS7
 */
public class frmManagement extends javax.swing.JFrame {

    /**
     * Creates new form Manager
     */
    public static Vector prinBill = new Vector();
    DLL_Services service = new DLL_Services();
    DLL_Order order = new DLL_Order();
    ArrayList<Service> list1 = new ArrayList<>();
    ArrayList<Service> list2 = new ArrayList<>();
    ArrayList<Service> list3 = new ArrayList<>();
    ArrayList<Service> list4 = new ArrayList<>();
    ArrayList<Service> list5 = new ArrayList<>();
    ArrayList<Service> list6 = new ArrayList<>();
    ArrayList<Service> list7 = new ArrayList<>();
    ArrayList<Service> pricelist = new ArrayList<>();
    ArrayList<Service> pricename = new ArrayList<>();
    ArrayList<Service> pricename1 = new ArrayList<>();
    ArrayList<Service> showSercodes = new ArrayList<>();
    ArrayList<Order> showOrderid = new ArrayList<>();
    ArrayList<Quantity> showQuantity = new ArrayList<>();
    public static frmManagement as;
    private Timer time;
    Locale locale;
    int total1 = 0;
    int total2 = 0;
    int total3 = 0;
    int total4 = 0;
    int total5 = 0;
    int total6 = 0;
    int total7 = 0;
    int total8 = 0;
    int total9 = 0;
    int total10 = 0;
    int total11 = 0;
    int total12 = 0;
    int total13 = 0;
    int total14 = 0;
    int total15 = 0;
    int total16 = 0;
    int total17 = 0;
    int totals = 0;

    int orderId = 0;

    public frmManagement(frmLogin frmlogin, User user) {
        super();
        as = this;
        initComponents();
        showOrderid();
        locale = new Locale("vi", "VN");

        this.setSize(1300, 850);

        showDate();
        this.setLocationRelativeTo(null);
//        this.setExtendedState(this.MAXIMIZED_BOTH);
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        this.setTitle("Phần Mềm Quản Lí Cafe");
        data = new Vector();
        head = new Vector();
        head.add("Tên dịch vụ");
        head.add("Giá tiền");
        head.add("Số lượng");
        head.add("Ghi chú");
        tableBill.setModel(new DefaultTableModel(data, head));
        showCbb1();
        showCbb2();
        showCbb3();
        showCbb4();
        showCbb5();
        showCbb6();
        showCbb7();
        banA01 = new Vector();
        banA02 = new Vector();
        banA03 = new Vector();
        banA04 = new Vector();
        banA05 = new Vector();
        banA06 = new Vector();
        banA07 = new Vector();
        banA08 = new Vector();
        banA09 = new Vector();
        banB01 = new Vector();
        banB02 = new Vector();
        banB03 = new Vector();
        banB04 = new Vector();
        banB05 = new Vector();
        banB06 = new Vector();
        banB07 = new Vector();
        banB08 = new Vector();
        int total1 = 0;

        txtHello.setText(user.getFullname());
        roles.setText(user.getRoles());
        String roless = roles.getText();
        if (roless.equals("Employee")) {
            btnManagaEmployee.setEnabled(false);
            btnManagerSell.setEnabled(false);
            btnManagerAccount.setEnabled(false);
        }
    }

    public frmManagement() {
        as = this;
        initComponents();
        showOrderid();
        locale = new Locale("vi", "VN");
        this.setSize(1300, 850);

        showDate();

        this.setLocationRelativeTo(null);
//        this.setExtendedState(this.MAXIMIZED_BOTH);
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        this.setTitle("Phần Mềm Quản Lí Cafe");
        data = new Vector();
        head = new Vector();
        head.add("Tên dịch vụ");
        head.add("Giá tiền");
        head.add("Số lượng");
        head.add("Ghi chú");
        tableBill.setModel(new DefaultTableModel(data, head));
        showCbb1();
        showCbb2();
        showCbb3();
        showCbb4();
        showCbb5();
        showCbb6();
        showCbb7();

        banA01 = new Vector();
        banA02 = new Vector();
        banA03 = new Vector();
        banA04 = new Vector();
        banA05 = new Vector();
        banA06 = new Vector();
        banA07 = new Vector();
        banA08 = new Vector();
        banA09 = new Vector();
        banB01 = new Vector();
        banB02 = new Vector();
        banB03 = new Vector();
        banB04 = new Vector();
        banB05 = new Vector();
        banB06 = new Vector();
        banB07 = new Vector();
        banB08 = new Vector();

    }

    public void showOrderid() {
        showOrderid = order.showOrderid();
        for (Order od : showOrderid) {

            orderId = Integer.parseInt(od.getOrderId());
            orderId++;

        }
    }

    public void showDate() {
        Date today = new Date(System.currentTimeMillis());
        SimpleDateFormat dataFormart = new SimpleDateFormat("yyyy-MM-dd");
        String s = dataFormart.format(today.getTime());
        txtDate.setText(s);
    }

    public void callEmp() {
        pannelMain.removeAll();
        frmEmployee emp = new frmEmployee();
        emp.setPreferredSize(new Dimension(400, 150));
        pannelMain.add(emp);
        pannelMain.updateUI();
    }

    public void cancelEmp() {
        pannelMain.removeAll();
        pannelMain.add(pannelShow);
        pannelMain.updateUI();
    }

    public void callSell() {
        pannelMain.removeAll();
        frmSell sell = new frmSell();
        sell.setPreferredSize(new Dimension(400, 150));
        pannelMain.add(sell);
        pannelMain.updateUI();
    }

    public void callStore() {
        pannelMain.removeAll();
        frmStore st = new frmStore();
        st.setPreferredSize(new Dimension(400, 150));
        pannelMain.add(st);
        pannelMain.updateUI();
    }

    public void callAccount() {
        pannelMain.removeAll();
        frmAccount ac = new frmAccount();
        ac.setPreferredSize(new Dimension(400, 150));
        pannelMain.add(ac);
        pannelMain.updateUI();
    }

    public void showCbb1() {
        list1 = service.showCbb1();
        for (Service sv : list1) {
            cbbSelect1.addItem(sv.getSername());
        }
    }

    public void showCbb2() {
        list2 = service.showCbb2();
        for (Service sv : list2) {
            cbbSelect2.addItem(sv.getSername());
        }
    }

    public void showCbb3() {
        list3 = service.showCbb3();
        for (Service sv : list3) {
            cbbSelect3.addItem(sv.getSername());
        }
    }

    public void showCbb4() {
        list4 = service.showCbb4();
        for (Service sv : list4) {
            cbbSelect4.addItem(sv.getSername());
        }
    }

    public void showCbb5() {
        list5 = service.showCbb5();
        for (Service sv : list5) {
            cbbSelect5.addItem(sv.getSername());
        }
    }

    public void showCbb6() {
        list6 = service.showCbb6();
        for (Service sv : list6) {
            cbbSelect6.addItem(sv.getSername());
        }
    }

    public void showCbb7() {
        list7 = service.showCbb7();
        for (Service sv : list7) {
            cbbSelect7.addItem(sv.getSername());
        }
    }

    public void totalA01() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect1.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total1 = u + y;
            total.setText(total1 + "");
        }
    }

    public void totalA011() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect2.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total1 = u + y;
            total.setText(total1 + "");
        }
    }

    public void totalA0111() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect3.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total1 = u + y;
            total.setText(total1 + "");
        }
    }

    public void totalA01111() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect4.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total1 = u + y;
            total.setText(total1 + "");
        }
    }

    public void totalA011111() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect5.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total1 = u + y;
            total.setText(total1 + "");
        }
    }

    public void totalA0111111() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect6.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total1 = u + y;
            total.setText(total1 + "");
        }
    }

    public void totalA01111111() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect7.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total1 = u + y;
            total.setText(total1 + "");
        }
    }

    public void totalA02() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect1.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total2 = u + y;
            total.setText(total2 + "");
        }
    }

    public void totalA022() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect2.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total2 = u + y;
            total.setText(total2 + "");
        }
    }

    public void totalA0222() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect3.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total2 = u + y;
            total.setText(total2 + "");
        }
    }

    public void totalA02222() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect4.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total2 = u + y;
            total.setText(total2 + "");
        }
    }

    public void totalA022222() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect5.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total2 = u + y;
            total.setText(total2 + "");
        }
    }

    public void totalA0222222() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect6.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total2 = u + y;
            total.setText(total2 + "");
        }
    }

    public void totalA02222222() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect7.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total2 = u + y;
            total.setText(total2 + "");
        }
    }

    ////////
    public void totalA03() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect1.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total3 = u + y;
            total.setText(total3 + "");
        }
    }

    public void totalA033() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect2.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total3 = u + y;
            total.setText(total3 + "");
        }
    }

    public void totalA0333() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect3.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total3 = u + y;
            total.setText(total3 + "");
        }
    }

    public void totalA03333() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect4.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total3 = u + y;
            total.setText(total3 + "");
        }
    }

    public void totalA033333() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect5.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total3 = u + y;
            total.setText(total3 + "");
        }
    }

    public void totalA0333333() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect6.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total3 = u + y;
            total.setText(total3 + "");
        }
    }

    public void totalA03333333() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect7.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total3 = u + y;
            total.setText(total3 + "");
        }
    }

    ////
    public void totalA04() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect1.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total4 = u + y;
            total.setText(total4 + "");
        }
    }

    public void totalA044() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect2.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total4 = u + y;
            total.setText(total4 + "");
        }
    }

    public void totalA0444() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect3.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total4 = u + y;
            total.setText(total4 + "");
        }
    }

    public void totalA04444() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect4.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total4 = u + y;
            total.setText(total4 + "");
        }
    }

    public void totalA044444() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect5.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total4 = u + y;
            total.setText(total4 + "");
        }
    }

    public void totalA0444444() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect6.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total4 = u + y;
            total.setText(total4 + "");
        }
    }

    public void totalA04444444() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect7.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total4 = u + y;
            total.setText(total4 + "");
        }
    }

    ///
    public void totalA05() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect1.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total5 = u + y;
            total.setText(total5 + "");
        }
    }

    public void totalA055() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect2.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total5 = u + y;
            total.setText(total5 + "");
        }
    }

    public void totalA0555() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect3.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total5 = u + y;
            total.setText(total5 + "");
        }
    }

    public void totalA05555() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect4.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total5 = u + y;
            total.setText(total5 + "");
        }
    }

    public void totalA055555() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect5.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total5 = u + y;
            total.setText(total5 + "");
        }
    }

    public void totalA0555555() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect6.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total5 = u + y;
            total.setText(total5 + "");
        }
    }

    public void totalA05555555() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect7.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total5 = u + y;
            total.setText(total5 + "");
        }
    }

    ///
    public void totalA06() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect1.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total6 = u + y;
            total.setText(total6 + "");
        }
    }

    public void totalA066() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect2.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total6 = u + y;
            total.setText(total6 + "");
        }
    }

    public void totalA0666() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect3.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total6 = u + y;
            total.setText(total6 + "");
        }
    }

    public void totalA06666() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect4.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total6 = u + y;
            total.setText(total6 + "");
        }
    }

    public void totalA066666() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect5.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total6 = u + y;
            total.setText(total6 + "");
        }
    }

    public void totalA0666666() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect6.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total6 = u + y;
            total.setText(total6 + "");
        }
    }

    public void totalA06666666() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect7.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total6 = u + y;
            total.setText(total6 + "");
        }
    }

    ///
    public void totalA07() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect1.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total7 = u + y;
            total.setText(total7 + "");
        }
    }

    public void totalA077() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect2.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total7 = u + y;
            total.setText(total7 + "");
        }
    }

    public void totalA0777() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect3.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total7 = u + y;
            total.setText(total7 + "");
        }
    }

    public void totalA07777() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect4.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total7 = u + y;
            total.setText(total7 + "");
        }
    }

    public void totalA077777() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect5.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total7 = u + y;
            total.setText(total7 + "");
        }
    }

    public void totalA0777777() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect6.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total7 = u + y;
            total.setText(total7 + "");
        }
    }

    public void totalA07777777() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect7.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total7 = u + y;
            total.setText(total7 + "");
        }
    }

    //
    public void totalA08() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect1.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total8 = u + y;
            total.setText(total8 + "");
        }
    }

    public void totalA088() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect2.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total8 = u + y;
            total.setText(total8 + "");
        }
    }

    public void totalA0888() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect3.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total8 = u + y;
            total.setText(total8 + "");
        }
    }

    public void totalA08888() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect4.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total8 = u + y;
            total.setText(total8 + "");
        }
    }

    public void totalA088888() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect5.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total8 = u + y;
            total.setText(total8 + "");
        }
    }

    public void totalA0888888() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect6.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total8 = u + y;
            total.setText(total8 + "");
        }
    }

    public void totalA08888888() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect7.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total8 = u + y;
            total.setText(total8 + "");
        }
    }

    //
    public void totalA09() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect1.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total9 = u + y;
            total.setText(total9 + "");
        }
    }

    public void totalA099() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect2.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total9 = u + y;
            total.setText(total9 + "");
        }
    }

    public void totalA0999() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect3.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total9 = u + y;
            total.setText(total9 + "");
        }
    }

    public void totalA09999() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect4.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total9 = u + y;
            total.setText(total9 + "");
        }
    }

    public void totalA099999() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect5.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total9 = u + y;
            total.setText(total9 + "");
        }
    }

    public void totalA0999999() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect6.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total9 = u + y;
            total.setText(total9 + "");
        }
    }

    public void totalA09999999() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect7.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total9 = u + y;
            total.setText(total9 + "");
        }
    }

    // B
    public void totalB01() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect1.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total10 = u + y;
            total.setText(total10 + "");
        }
    }

    public void totalB011() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect2.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total10 = u + y;
            total.setText(total10 + "");
        }
    }

    public void totalB0111() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect3.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total10 = u + y;
            total.setText(total10 + "");
        }
    }

    public void totalB01111() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect4.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total10 = u + y;
            total.setText(total10 + "");
        }
    }

    public void totalB011111() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect5.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total10 = u + y;
            total.setText(total10 + "");
        }
    }

    public void totalB0111111() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect6.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total10 = u + y;
            total.setText(total10 + "");
        }
    }

    public void totalB01111111() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect7.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total10 = u + y;
            total.setText(total10 + "");
        }
    }

    //
    public void totalB02() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect1.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total11 = u + y;
            total.setText(total11 + "");
        }
    }

    public void totalB022() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect2.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total11 = u + y;
            total.setText(total11 + "");
        }
    }

    public void totalB0222() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect3.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total11 = u + y;
            total.setText(total11 + "");
        }
    }

    public void totalB02222() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect4.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total11 = u + y;
            total.setText(total11 + "");
        }
    }

    public void totalB022222() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect5.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total11 = u + y;
            total.setText(total11 + "");
        }
    }

    public void totalB0222222() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect6.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total11 = u + y;
            total.setText(total11 + "");
        }
    }

    public void totalB02222222() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect7.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total11 = u + y;
            total.setText(total11 + "");
        }
    }

    //
    public void totalB03() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect1.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total12 = u + y;
            total.setText(total12 + "");
        }
    }

    public void totalB033() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect2.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total12 = u + y;
            total.setText(total12 + "");
        }
    }

    public void totalB0333() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect3.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total12 = u + y;
            total.setText(total12 + "");
        }
    }

    public void totalB03333() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect4.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total12 = u + y;
            total.setText(total12 + "");
        }
    }

    public void totalB033333() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect5.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total12 = u + y;
            total.setText(total12 + "");
        }
    }

    public void totalB0333333() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect6.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total12 = u + y;
            total.setText(total12 + "");
        }
    }

    public void totalB03333333() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect7.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total12 = u + y;
            total.setText(total12 + "");
        }
    }

    //
    public void totalB04() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect1.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total13 = u + y;
            total.setText(total13 + "");
        }
    }

    public void totalB044() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect2.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total13 = u + y;
            total.setText(total13 + "");
        }
    }

    public void totalB0444() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect3.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total13 = u + y;
            total.setText(total13 + "");
        }
    }

    public void totalB04444() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect4.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total13 = u + y;
            total.setText(total13 + "");
        }
    }

    public void totalB044444() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect5.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total13 = u + y;
            total.setText(total13 + "");
        }
    }

    public void totalB0444444() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect6.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total13 = u + y;
            total.setText(total13 + "");
        }
    }

    public void totalB04444444() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect7.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total13 = u + y;
            total.setText(total13 + "");
        }
    }

    //
    public void totalB05() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect1.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total14 = u + y;
            total.setText(total14 + "");
        }
    }

    public void totalB055() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect2.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total14 = u + y;
            total.setText(total14 + "");
        }
    }

    public void totalB0555() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect3.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total14 = u + y;
            total.setText(total14 + "");
        }
    }

    public void totalB05555() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect4.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total14 = u + y;
            total.setText(total14 + "");
        }
    }

    public void totalB055555() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect5.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total14 = u + y;
            total.setText(total14 + "");
        }
    }

    public void totalB0555555() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect6.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total14 = u + y;
            total.setText(total14 + "");
        }
    }

    public void totalB05555555() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect7.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total14 = u + y;
            total.setText(total14 + "");
        }
    }

    //
    public void totalB06() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect1.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total15 = u + y;
            total.setText(total15 + "");
        }
    }

    public void totalB066() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect2.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total15 = u + y;
            total.setText(total15 + "");
        }
    }

    public void totalB0666() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect3.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total15 = u + y;
            total.setText(total15 + "");
        }
    }

    public void totalB06666() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect4.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total15 = u + y;
            total.setText(total15 + "");
        }
    }

    public void totalB066666() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect5.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total15 = u + y;
            total.setText(total15 + "");
        }
    }

    public void totalB0666666() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect6.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total15 = u + y;
            total.setText(total15 + "");
        }
    }

    public void totalB06666666() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect7.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total15 = u + y;
            total.setText(total15 + "");
        }
    }

    ////
    public void totalB07() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect1.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total16 = u + y;
            total.setText(total16 + "");
        }
    }

    public void totalB077() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect2.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total16 = u + y;
            total.setText(total16 + "");
        }
    }

    public void totalB0777() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect3.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total16 = u + y;
            total.setText(total16 + "");
        }
    }

    public void totalB07777() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect4.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total16 = u + y;
            total.setText(total16 + "");
        }
    }

    public void totalB077777() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect5.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total16 = u + y;
            total.setText(total16 + "");
        }
    }

    public void totalB0777777() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect6.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total16 = u + y;
            total.setText(total16 + "");
        }
    }

    public void totalB07777777() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect7.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total16 = u + y;
            total.setText(total16 + "");
        }
    }

    //
    public void totalB08() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect1.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total17 = u + y;
            total.setText(total17 + "");
        }
    }

    public void totalB088() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect2.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total17 = u + y;
            total.setText(total17 + "");
        }
    }

    public void totalB0888() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect3.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total17 = u + y;
            total.setText(total17 + "");
        }
    }

    public void totalB08888() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect4.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total17 = u + y;
            total.setText(total17 + "");
        }
    }

    public void totalB088888() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect5.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total17 = u + y;
            total.setText(total17 + "");
        }
    }

    public void totalB0888888() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect6.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total17 = u + y;
            total.setText(total17 + "");
        }
    }

    public void totalB08888888() {
        int u = 0;
        int y = 0;
        String sername = (String) cbbSelect7.getSelectedItem();
        for (int i = 0; i < tableBill.getRowCount(); i++) {
            int a = (Integer) tableBill.getValueAt(i, 1);
            String b = (String) tableBill.getValueAt(i, 0);

            if (b == sername) {
                u = (Integer) tableBill.getValueAt(i, 1);

            } else {
                y += a;

            }
            total17 = u + y;
            total.setText(total17 + "");
        }
    }

    public void addBan01() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect1.getSelectedItem();
        int quantity = cbbTotal1.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA01.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA01.add(svs);

            tableBill.setModel(new DefaultTableModel(banA01, head));
            tableBill.updateUI();
        }

    }

    public void addBan02() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect1.getSelectedItem();
        int quantity = cbbTotal1.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA02.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA02.add(svs);

            tableBill.setModel(new DefaultTableModel(banA02, head));
            tableBill.updateUI();
        }

    }

    public void addBan03() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect1.getSelectedItem();
        int quantity = cbbTotal1.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA03.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA03.add(svs);

            tableBill.setModel(new DefaultTableModel(banA03, head));
            tableBill.updateUI();
        }

    }

    public void addBan04() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect1.getSelectedItem();
        int quantity = cbbTotal1.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA04.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA04.add(svs);

            tableBill.setModel(new DefaultTableModel(banA04, head));
            tableBill.updateUI();
        }

    }

    public void addBan05() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect1.getSelectedItem();
        int quantity = cbbTotal1.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA05.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA05.add(svs);

            tableBill.setModel(new DefaultTableModel(banA05, head));
            tableBill.updateUI();
        }

    }

    public void addBan06() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect1.getSelectedItem();
        int quantity = cbbTotal1.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA06.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA06.add(svs);

            tableBill.setModel(new DefaultTableModel(banA06, head));
            tableBill.updateUI();
        }

    }

    public void addBan07() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect1.getSelectedItem();
        int quantity = cbbTotal1.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA07.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA07.add(svs);

            tableBill.setModel(new DefaultTableModel(banA07, head));
            tableBill.updateUI();
        }

    }

    public void addBan08() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect1.getSelectedItem();
        int quantity = cbbTotal1.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA08.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA08.add(svs);

            tableBill.setModel(new DefaultTableModel(banA08, head));
            tableBill.updateUI();
        }

    }

    public void addBan09() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect1.getSelectedItem();
        int quantity = cbbTotal1.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA09.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA09.add(svs);

            tableBill.setModel(new DefaultTableModel(banA09, head));
            tableBill.updateUI();
        }

    }

    public void addBanB01() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect1.getSelectedItem();
        int quantity = cbbTotal1.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banB01.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banB01.add(svs);

            tableBill.setModel(new DefaultTableModel(banB01, head));
            tableBill.updateUI();
        }

    }

    public void addBanB02() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect1.getSelectedItem();
        int quantity = cbbTotal1.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banB02.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banB02.add(svs);

            tableBill.setModel(new DefaultTableModel(banB02, head));
            tableBill.updateUI();
        }

    }

    public void addBanB03() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect1.getSelectedItem();
        int quantity = cbbTotal1.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banB03.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banB03.add(svs);

            tableBill.setModel(new DefaultTableModel(banB03, head));
            tableBill.updateUI();
        }

    }

    public void addBanB04() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect1.getSelectedItem();
        int quantity = cbbTotal1.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banB04.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banB04.add(svs);

            tableBill.setModel(new DefaultTableModel(banB04, head));
            tableBill.updateUI();
        }

    }

    public void addBanB05() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect1.getSelectedItem();
        int quantity = cbbTotal1.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banB05.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banB05.add(svs);

            tableBill.setModel(new DefaultTableModel(banB05, head));
            tableBill.updateUI();
        }

    }

    public void addBanB06() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect1.getSelectedItem();
        int quantity = cbbTotal1.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banB06.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banB06.add(svs);

            tableBill.setModel(new DefaultTableModel(banB06, head));
            tableBill.updateUI();
        }

    }

    public void addBanB07() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect1.getSelectedItem();
        int quantity = cbbTotal1.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banB07.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banB07.add(svs);

            tableBill.setModel(new DefaultTableModel(banB07, head));
            tableBill.updateUI();
        }

    }

    public void addBanB08() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect1.getSelectedItem();
        int quantity = cbbTotal1.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banB08.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banB08.add(svs);

            tableBill.setModel(new DefaultTableModel(banB08, head));
            tableBill.updateUI();
        }

    }

//    End Button Add 1
    public void addBan11() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect2.getSelectedItem();
        int quantity = cbbTotal2.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA01.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA01.add(svs);

            tableBill.setModel(new DefaultTableModel(banA01, head));
            tableBill.updateUI();
        }

    }

    public void addBan22() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect2.getSelectedItem();
        int quantity = cbbTotal2.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA02.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA02.add(svs);

            tableBill.setModel(new DefaultTableModel(banA02, head));
            tableBill.updateUI();
        }

    }

    public void addBan33() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect2.getSelectedItem();
        int quantity = cbbTotal2.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA03.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA03.add(svs);

            tableBill.setModel(new DefaultTableModel(banA03, head));
            tableBill.updateUI();
        }

    }

    public void addBan44() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect2.getSelectedItem();
        int quantity = cbbTotal2.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA04.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA04.add(svs);

            tableBill.setModel(new DefaultTableModel(banA04, head));
            tableBill.updateUI();
        }

    }

    public void addBan55() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect2.getSelectedItem();
        int quantity = cbbTotal2.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA05.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA05.add(svs);

            tableBill.setModel(new DefaultTableModel(banA05, head));
            tableBill.updateUI();
        }

    }

    public void addBan66() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect2.getSelectedItem();
        int quantity = cbbTotal2.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA06.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA06.add(svs);

            tableBill.setModel(new DefaultTableModel(banA06, head));
            tableBill.updateUI();
        }

    }

    public void addBan77() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect2.getSelectedItem();
        int quantity = cbbTotal2.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA07.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA07.add(svs);

            tableBill.setModel(new DefaultTableModel(banA07, head));
            tableBill.updateUI();
        }

    }

    int giatien = 0;

    public void addBan88() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect2.getSelectedItem();
        int quantity = cbbTotal2.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA08.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA08.add(svs);

            tableBill.setModel(new DefaultTableModel(banA08, head));
            tableBill.updateUI();
        }

    }

    public void addBan99() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect2.getSelectedItem();
        int quantity = cbbTotal2.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA09.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA09.add(svs);

            tableBill.setModel(new DefaultTableModel(banA09, head));
            tableBill.updateUI();
        }

    }

    public void addBanB011() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect2.getSelectedItem();
        int quantity = cbbTotal2.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banB01.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banB01.add(svs);

            tableBill.setModel(new DefaultTableModel(banB01, head));
            tableBill.updateUI();
        }

    }

    public void addBanB022() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect2.getSelectedItem();
        int quantity = cbbTotal2.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banB02.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banB02.add(svs);

            tableBill.setModel(new DefaultTableModel(banB02, head));
            tableBill.updateUI();
        }

    }

    public void addBanB033() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect2.getSelectedItem();
        int quantity = cbbTotal2.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banB03.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banB03.add(svs);

            tableBill.setModel(new DefaultTableModel(banB03, head));
            tableBill.updateUI();
        }

    }

    public void addBanB044() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect2.getSelectedItem();
        int quantity = cbbTotal2.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banB04.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banB04.add(svs);

            tableBill.setModel(new DefaultTableModel(banB04, head));
            tableBill.updateUI();
        }

    }

    public void addBanB055() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect2.getSelectedItem();
        int quantity = cbbTotal2.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banB05.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banB05.add(svs);

            tableBill.setModel(new DefaultTableModel(banB05, head));
            tableBill.updateUI();
        }

    }

    public void addBanB066() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect2.getSelectedItem();
        int quantity = cbbTotal2.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banB06.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banB06.add(svs);

            tableBill.setModel(new DefaultTableModel(banB06, head));
            tableBill.updateUI();
        }

    }

    public void addBanB077() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect2.getSelectedItem();
        int quantity = cbbTotal2.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banB07.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banB07.add(svs);

            tableBill.setModel(new DefaultTableModel(banB07, head));
            tableBill.updateUI();
        }

    }

    public void addBanB088() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect2.getSelectedItem();
        int quantity = cbbTotal2.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banB08.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banB08.add(svs);

            tableBill.setModel(new DefaultTableModel(banB08, head));
            tableBill.updateUI();
        }

    }

    // End Button Add 2 
    public void addBan111() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect3.getSelectedItem();
        int quantity = cbbTotal3.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA01.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA01.add(svs);

            tableBill.setModel(new DefaultTableModel(banA01, head));
            tableBill.updateUI();
        }

    }

    public void addBan222() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect3.getSelectedItem();
        int quantity = cbbTotal3.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA02.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA02.add(svs);

            tableBill.setModel(new DefaultTableModel(banA02, head));
            tableBill.updateUI();
        }

    }

    public void addBan333() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect3.getSelectedItem();
        int quantity = cbbTotal3.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA03.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA03.add(svs);

            tableBill.setModel(new DefaultTableModel(banA03, head));
            tableBill.updateUI();
        }

    }

    public void addBan444() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect3.getSelectedItem();
        int quantity = cbbTotal3.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA04.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA04.add(svs);

            tableBill.setModel(new DefaultTableModel(banA04, head));
            tableBill.updateUI();
        }

    }

    public void addBan555() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect3.getSelectedItem();
        int quantity = cbbTotal3.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA05.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA05.add(svs);

            tableBill.setModel(new DefaultTableModel(banA05, head));
            tableBill.updateUI();
        }

    }

    public void addBan666() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect3.getSelectedItem();
        int quantity = cbbTotal3.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA06.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA06.add(svs);

            tableBill.setModel(new DefaultTableModel(banA06, head));
            tableBill.updateUI();
        }

    }

    public void addBan777() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect3.getSelectedItem();
        int quantity = cbbTotal3.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA07.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA07.add(svs);

            tableBill.setModel(new DefaultTableModel(banA07, head));
            tableBill.updateUI();
        }

    }

    public void addBan888() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect3.getSelectedItem();
        int quantity = cbbTotal3.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA08.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA08.add(svs);

            tableBill.setModel(new DefaultTableModel(banA08, head));
            tableBill.updateUI();
        }

    }

    public void addBan999() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect3.getSelectedItem();
        int quantity = cbbTotal3.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA09.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA09.add(svs);

            tableBill.setModel(new DefaultTableModel(banA09, head));
            tableBill.updateUI();
        }

    }

    public void addBanB0111() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect3.getSelectedItem();
        int quantity = cbbTotal3.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banB01.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banB01.add(svs);

            tableBill.setModel(new DefaultTableModel(banB01, head));
            tableBill.updateUI();
        }

    }

    public void addBanB0222() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect3.getSelectedItem();
        int quantity = cbbTotal3.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banB02.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banB02.add(svs);

            tableBill.setModel(new DefaultTableModel(banB02, head));
            tableBill.updateUI();
        }

    }

    public void addBanB0333() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect3.getSelectedItem();
        int quantity = cbbTotal3.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banB03.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banB03.add(svs);

            tableBill.setModel(new DefaultTableModel(banB03, head));
            tableBill.updateUI();
        }

    }

    public void addBanB0444() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect3.getSelectedItem();
        int quantity = cbbTotal3.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banB04.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banB04.add(svs);

            tableBill.setModel(new DefaultTableModel(banB04, head));
            tableBill.updateUI();
        }

    }

    public void addBanB0555() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect3.getSelectedItem();
        int quantity = cbbTotal3.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banB05.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banB05.add(svs);

            tableBill.setModel(new DefaultTableModel(banB05, head));
            tableBill.updateUI();
        }

    }

    public void addBanB0666() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect3.getSelectedItem();
        int quantity = cbbTotal3.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banB06.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banB06.add(svs);

            tableBill.setModel(new DefaultTableModel(banB06, head));
            tableBill.updateUI();
        }

    }

    public void addBanB0777() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect3.getSelectedItem();
        int quantity = cbbTotal3.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banB07.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banB07.add(svs);

            tableBill.setModel(new DefaultTableModel(banB07, head));
            tableBill.updateUI();
        }

    }

    public void addBanB0888() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect3.getSelectedItem();
        int quantity = cbbTotal3.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banB08.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banB08.add(svs);

            tableBill.setModel(new DefaultTableModel(banB08, head));
            tableBill.updateUI();
        }

    }

    // End Button Add 3
    public void addBan1111() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect4.getSelectedItem();
        int quantity = cbbTotal4.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA01.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA01.add(svs);

            tableBill.setModel(new DefaultTableModel(banA01, head));
            tableBill.updateUI();
        }

    }

    public void addBan2222() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect4.getSelectedItem();
        int quantity = cbbTotal4.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA02.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA02.add(svs);

            tableBill.setModel(new DefaultTableModel(banA02, head));
            tableBill.updateUI();
        }

    }

    public void addBan3333() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect4.getSelectedItem();
        int quantity = cbbTotal4.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA03.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA03.add(svs);

            tableBill.setModel(new DefaultTableModel(banA03, head));
            tableBill.updateUI();
        }

    }

    public void addBan4444() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect4.getSelectedItem();
        int quantity = cbbTotal4.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA04.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA04.add(svs);

            tableBill.setModel(new DefaultTableModel(banA04, head));
            tableBill.updateUI();
        }

    }

    public void addBan5555() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect4.getSelectedItem();
        int quantity = cbbTotal4.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA05.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA05.add(svs);

            tableBill.setModel(new DefaultTableModel(banA05, head));
            tableBill.updateUI();
        }

    }

    public void addBan6666() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect4.getSelectedItem();
        int quantity = cbbTotal4.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA06.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA06.add(svs);

            tableBill.setModel(new DefaultTableModel(banA06, head));
            tableBill.updateUI();
        }

    }

    public void addBan7777() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect4.getSelectedItem();
        int quantity = cbbTotal4.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA07.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA07.add(svs);

            tableBill.setModel(new DefaultTableModel(banA07, head));
            tableBill.updateUI();
        }

    }

    public void addBan8888() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect4.getSelectedItem();
        int quantity = cbbTotal4.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA08.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA08.add(svs);

            tableBill.setModel(new DefaultTableModel(banA08, head));
            tableBill.updateUI();
        }

    }

    public void addBan9999() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect4.getSelectedItem();
        int quantity = cbbTotal4.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA09.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA09.add(svs);

            tableBill.setModel(new DefaultTableModel(banA09, head));
            tableBill.updateUI();
        }

    }

    public void addBanB01111() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect4.getSelectedItem();
        int quantity = cbbTotal4.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banB01.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banB01.add(svs);

            tableBill.setModel(new DefaultTableModel(banB01, head));
            tableBill.updateUI();
        }

    }

    public void addBanB02222() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect4.getSelectedItem();
        int quantity = cbbTotal4.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banB02.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banB02.add(svs);

            tableBill.setModel(new DefaultTableModel(banB02, head));
            tableBill.updateUI();
        }

    }

    public void addBanB03333() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect4.getSelectedItem();
        int quantity = cbbTotal4.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banB03.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banB03.add(svs);

            tableBill.setModel(new DefaultTableModel(banB03, head));
            tableBill.updateUI();
        }

    }

    public void addBanB04444() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect4.getSelectedItem();
        int quantity = cbbTotal4.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banB04.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banB04.add(svs);

            tableBill.setModel(new DefaultTableModel(banB04, head));
            tableBill.updateUI();
        }

    }

    public void addBanB05555() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect4.getSelectedItem();
        int quantity = cbbTotal4.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banB05.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banB05.add(svs);

            tableBill.setModel(new DefaultTableModel(banB05, head));
            tableBill.updateUI();
        }

    }

    public void addBanB06666() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect4.getSelectedItem();
        int quantity = cbbTotal4.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banB06.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banB06.add(svs);

            tableBill.setModel(new DefaultTableModel(banB06, head));
            tableBill.updateUI();
        }

    }

    public void addBanB07777() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect4.getSelectedItem();
        int quantity = cbbTotal4.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banB07.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banB07.add(svs);

            tableBill.setModel(new DefaultTableModel(banB07, head));
            tableBill.updateUI();
        }

    }

    public void addBanB08888() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect4.getSelectedItem();
        int quantity = cbbTotal4.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banB08.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banB08.add(svs);

            tableBill.setModel(new DefaultTableModel(banB08, head));
            tableBill.updateUI();
        }

    }

    // End Button Add 4
    public void addBan11111() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect5.getSelectedItem();
        int quantity = cbbTotal5.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA01.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA01.add(svs);

            tableBill.setModel(new DefaultTableModel(banA01, head));
            tableBill.updateUI();
        }

    }

    public void addBan22222() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect5.getSelectedItem();
        int quantity = cbbTotal5.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA02.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA02.add(svs);

            tableBill.setModel(new DefaultTableModel(banA02, head));
            tableBill.updateUI();
        }

    }

    public void addBan33333() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect5.getSelectedItem();
        int quantity = cbbTotal5.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA03.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA03.add(svs);

            tableBill.setModel(new DefaultTableModel(banA03, head));
            tableBill.updateUI();
        }

    }

    public void addBan44444() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect5.getSelectedItem();
        int quantity = cbbTotal5.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA04.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA04.add(svs);

            tableBill.setModel(new DefaultTableModel(banA04, head));
            tableBill.updateUI();
        }

    }

    public void addBan55555() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect5.getSelectedItem();
        int quantity = cbbTotal5.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA05.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA05.add(svs);

            tableBill.setModel(new DefaultTableModel(banA05, head));
            tableBill.updateUI();
        }

    }

    public void addBan66666() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect5.getSelectedItem();
        int quantity = cbbTotal5.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA06.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA06.add(svs);

            tableBill.setModel(new DefaultTableModel(banA06, head));
            tableBill.updateUI();
        }

    }

    public void addBan77777() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect5.getSelectedItem();
        int quantity = cbbTotal5.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA07.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA07.add(svs);

            tableBill.setModel(new DefaultTableModel(banA07, head));
            tableBill.updateUI();
        }

    }

    public void addBan88888() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect5.getSelectedItem();
        int quantity = cbbTotal5.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA08.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA08.add(svs);

            tableBill.setModel(new DefaultTableModel(banA08, head));
            tableBill.updateUI();
        }

    }

    public void addBan99999() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect5.getSelectedItem();
        int quantity = cbbTotal5.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA09.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA09.add(svs);

            tableBill.setModel(new DefaultTableModel(banA09, head));
            tableBill.updateUI();
        }

    }

    public void addBanB011111() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect5.getSelectedItem();
        int quantity = cbbTotal5.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banB01.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banB01.add(svs);

            tableBill.setModel(new DefaultTableModel(banB01, head));
            tableBill.updateUI();
        }

    }

    public void addBanB022222() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect5.getSelectedItem();
        int quantity = cbbTotal5.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banB02.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banB02.add(svs);

            tableBill.setModel(new DefaultTableModel(banB02, head));
            tableBill.updateUI();
        }

    }

    public void addBanB033333() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect5.getSelectedItem();
        int quantity = cbbTotal5.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banB03.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banB03.add(svs);

            tableBill.setModel(new DefaultTableModel(banB03, head));
            tableBill.updateUI();
        }

    }

    public void addBanB044444() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect5.getSelectedItem();
        int quantity = cbbTotal5.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banB04.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banB04.add(svs);

            tableBill.setModel(new DefaultTableModel(banB04, head));
            tableBill.updateUI();
        }

    }

    public void addBanB055555() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect5.getSelectedItem();
        int quantity = cbbTotal5.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banB05.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banB05.add(svs);

            tableBill.setModel(new DefaultTableModel(banB05, head));
            tableBill.updateUI();
        }

    }

    public void addBanB066666() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect5.getSelectedItem();
        int quantity = cbbTotal5.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banB06.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banB06.add(svs);

            tableBill.setModel(new DefaultTableModel(banB06, head));
            tableBill.updateUI();
        }

    }

    public void addBanB077777() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect5.getSelectedItem();
        int quantity = cbbTotal5.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banB07.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banB07.add(svs);

            tableBill.setModel(new DefaultTableModel(banB07, head));
            tableBill.updateUI();
        }

    }

    public void addBanB088888() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect5.getSelectedItem();
        int quantity = cbbTotal5.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banB08.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banB08.add(svs);

            tableBill.setModel(new DefaultTableModel(banB08, head));
            tableBill.updateUI();
        }

    }

    // End Button Add 5
    public void addBan111111() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect6.getSelectedItem();
        int quantity = cbbTotal6.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA01.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA01.add(svs);

            tableBill.setModel(new DefaultTableModel(banA01, head));
            tableBill.updateUI();
        }

    }

    public void addBan222222() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect6.getSelectedItem();
        int quantity = cbbTotal6.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA02.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA02.add(svs);

            tableBill.setModel(new DefaultTableModel(banA02, head));
            tableBill.updateUI();
        }

    }

    public void addBan333333() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect6.getSelectedItem();
        int quantity = cbbTotal6.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA03.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA03.add(svs);

            tableBill.setModel(new DefaultTableModel(banA03, head));
            tableBill.updateUI();
        }

    }

    public void addBan444444() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect6.getSelectedItem();
        int quantity = cbbTotal6.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA04.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA04.add(svs);

            tableBill.setModel(new DefaultTableModel(banA04, head));
            tableBill.updateUI();
        }

    }

    public void addBan555555() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect6.getSelectedItem();
        int quantity = cbbTotal6.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA05.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA05.add(svs);

            tableBill.setModel(new DefaultTableModel(banA05, head));
            tableBill.updateUI();
        }

    }

    public void addBan666666() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect6.getSelectedItem();
        int quantity = cbbTotal6.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA06.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA06.add(svs);

            tableBill.setModel(new DefaultTableModel(banA06, head));
            tableBill.updateUI();
        }

    }

    public void addBan777777() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect6.getSelectedItem();
        int quantity = cbbTotal6.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA07.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA07.add(svs);

            tableBill.setModel(new DefaultTableModel(banA07, head));
            tableBill.updateUI();
        }

    }

    public void addBan888888() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect6.getSelectedItem();
        int quantity = cbbTotal6.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA08.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA08.add(svs);

            tableBill.setModel(new DefaultTableModel(banA08, head));
            tableBill.updateUI();
        }

    }

    public void addBan999999() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect6.getSelectedItem();
        int quantity = cbbTotal6.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA09.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA09.add(svs);

            tableBill.setModel(new DefaultTableModel(banA09, head));
            tableBill.updateUI();
        }

    }

    public void addBanB0111111() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect6.getSelectedItem();
        int quantity = cbbTotal6.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banB01.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banB01.add(svs);

            tableBill.setModel(new DefaultTableModel(banB01, head));
            tableBill.updateUI();
        }

    }

    public void addBanB0222222() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect6.getSelectedItem();
        int quantity = cbbTotal6.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banB02.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banB02.add(svs);

            tableBill.setModel(new DefaultTableModel(banB02, head));
            tableBill.updateUI();
        }

    }

    public void addBanB0333333() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect6.getSelectedItem();
        int quantity = cbbTotal6.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banB03.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banB03.add(svs);

            tableBill.setModel(new DefaultTableModel(banB03, head));
            tableBill.updateUI();
        }

    }

    public void addBanB0444444() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect6.getSelectedItem();
        int quantity = cbbTotal6.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banB04.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banB04.add(svs);

            tableBill.setModel(new DefaultTableModel(banB04, head));
            tableBill.updateUI();
        }

    }

    public void addBanB0555555() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect6.getSelectedItem();
        int quantity = cbbTotal6.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banB05.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banB05.add(svs);

            tableBill.setModel(new DefaultTableModel(banB05, head));
            tableBill.updateUI();
        }

    }

    public void addBanB0666666() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect6.getSelectedItem();
        int quantity = cbbTotal6.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banB06.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banB06.add(svs);

            tableBill.setModel(new DefaultTableModel(banB06, head));
            tableBill.updateUI();
        }

    }

    public void addBanB0777777() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect6.getSelectedItem();
        int quantity = cbbTotal6.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banB07.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banB07.add(svs);

            tableBill.setModel(new DefaultTableModel(banB07, head));
            tableBill.updateUI();
        }

    }

    public void addBanB0888888() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect6.getSelectedItem();
        int quantity = cbbTotal6.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banB08.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banB08.add(svs);

            tableBill.setModel(new DefaultTableModel(banB08, head));
            tableBill.updateUI();
        }

    }

    // End Button Add 6
    public void addBan1111111() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect7.getSelectedItem();
        int quantity = cbbTotal7.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA01.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA01.add(svs);

            tableBill.setModel(new DefaultTableModel(banA01, head));
            tableBill.updateUI();
        }

    }

    public void addBan2222222() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect7.getSelectedItem();
        int quantity = cbbTotal7.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA02.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA02.add(svs);

            tableBill.setModel(new DefaultTableModel(banA02, head));
            tableBill.updateUI();
        }

    }

    public void addBan3333333() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect7.getSelectedItem();
        int quantity = cbbTotal7.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA03.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA03.add(svs);

            tableBill.setModel(new DefaultTableModel(banA03, head));
            tableBill.updateUI();
        }

    }

    public void addBan4444444() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect7.getSelectedItem();
        int quantity = cbbTotal7.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA04.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA04.add(svs);

            tableBill.setModel(new DefaultTableModel(banA04, head));
            tableBill.updateUI();
        }

    }

    public void addBan5555555() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect7.getSelectedItem();
        int quantity = cbbTotal7.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA05.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA05.add(svs);

            tableBill.setModel(new DefaultTableModel(banA05, head));
            tableBill.updateUI();
        }

    }

    public void addBan6666666() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect7.getSelectedItem();
        int quantity = cbbTotal7.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA06.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA06.add(svs);

            tableBill.setModel(new DefaultTableModel(banA06, head));
            tableBill.updateUI();
        }

    }

    public void addBan7777777() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect7.getSelectedItem();
        int quantity = cbbTotal7.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA07.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA07.add(svs);

            tableBill.setModel(new DefaultTableModel(banA07, head));
            tableBill.updateUI();
        }

    }

    public void addBan8888888() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect7.getSelectedItem();
        int quantity = cbbTotal7.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA08.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA08.add(svs);

            tableBill.setModel(new DefaultTableModel(banA08, head));
            tableBill.updateUI();
        }

    }

    public void addBan9999999() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect7.getSelectedItem();
        int quantity = cbbTotal7.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banA09.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banA09.add(svs);

            tableBill.setModel(new DefaultTableModel(banA09, head));
            tableBill.updateUI();
        }

    }

    public void addBanB01111111() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect7.getSelectedItem();
        int quantity = cbbTotal7.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banB01.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banB01.add(svs);

            tableBill.setModel(new DefaultTableModel(banB01, head));
            tableBill.updateUI();
        }

    }

    public void addBanB02222222() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect7.getSelectedItem();
        int quantity = cbbTotal7.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banB02.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banB02.add(svs);

            tableBill.setModel(new DefaultTableModel(banB02, head));
            tableBill.updateUI();
        }

    }

    public void addBanB03333333() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect7.getSelectedItem();
        int quantity = cbbTotal7.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banB03.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banB03.add(svs);

            tableBill.setModel(new DefaultTableModel(banB03, head));
            tableBill.updateUI();
        }

    }

    public void addBanB04444444() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect7.getSelectedItem();
        int quantity = cbbTotal7.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banB04.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banB04.add(svs);

            tableBill.setModel(new DefaultTableModel(banB04, head));
            tableBill.updateUI();
        }

    }

    public void addBanB05555555() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect7.getSelectedItem();
        int quantity = cbbTotal7.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banB05.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banB05.add(svs);

            tableBill.setModel(new DefaultTableModel(banB05, head));
            tableBill.updateUI();
        }

    }

    public void addBanB06666666() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect7.getSelectedItem();
        int quantity = cbbTotal7.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banB06.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banB06.add(svs);

            tableBill.setModel(new DefaultTableModel(banB06, head));
            tableBill.updateUI();
        }

    }

    public void addBanB07777777() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect7.getSelectedItem();
        int quantity = cbbTotal7.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banB07.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banB07.add(svs);

            tableBill.setModel(new DefaultTableModel(banB07, head));
            tableBill.updateUI();
        }

    }

    public void addBanB08888888() {
        int soluong = 0;
        int giatien = 0;
        String sername = (String) cbbSelect7.getSelectedItem();
        int quantity = cbbTotal7.getSelectedIndex();
        pricename = service.showPricewhere(sername);
        Vector svs = new Vector();
        for (Service sv : pricename) {

            boolean check = false;
            soluong = 0;
            giatien = 0;
            for (int i = 0; i < tableBill.getRowCount(); i++) {

                String b = (String) tableBill.getValueAt(i, 0);

                if (b == sername) {
                    soluong = (Integer) tableBill.getValueAt(i, 2);
                    giatien = (Integer) tableBill.getValueAt(i, 1);
                    check = true;
                    banB08.remove(i);
                }
            }
            svs.addElement(sername);

            giatien = (sv.getPrice() * ((quantity + 1) + soluong));
            svs.addElement(giatien);
            svs.addElement((quantity + 1) + soluong);
            svs.addElement("");

            banB08.add(svs);

            tableBill.setModel(new DefaultTableModel(banB08, head));
            tableBill.updateUI();
        }

    }

    // End Button Add 7
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jButton11 = new javax.swing.JButton();
        btnA01 = new javax.swing.JButton();
        pannelTool = new javax.swing.JPanel();
        btnLogout = new javax.swing.JButton();
        btnRepassword = new javax.swing.JButton();
        btnUtilities = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        cbbLanguage = new javax.swing.JComboBox<>();
        pannelUser = new javax.swing.JPanel();
        roles = new javax.swing.JLabel();
        txtHello = new javax.swing.JLabel();
        pannelLogo = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        pannelPrimary = new javax.swing.JPanel();
        txtTrangchu = new javax.swing.JTabbedPane();
        pannelHomes = new javax.swing.JPanel();
        pannelSelect = new javax.swing.JPanel();
        btnManagaEmployee = new javax.swing.JButton();
        btnManagerAccount = new javax.swing.JButton();
        btnManagerSell = new javax.swing.JButton();
        btnManageStore = new javax.swing.JButton();
        btnExitSystem = new javax.swing.JButton();
        btnExitSystem1 = new javax.swing.JButton();
        pannelMain = new javax.swing.JPanel();
        pannelShow = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        pannelLogoItem = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        pannelB = new javax.swing.JPanel();
        pannelTable = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        pannelKhuA = new javax.swing.JPanel();
        btnA02 = new javax.swing.JButton();
        btnA03 = new javax.swing.JButton();
        btnA04 = new javax.swing.JButton();
        btnA05 = new javax.swing.JButton();
        btnA06 = new javax.swing.JButton();
        btnA07 = new javax.swing.JButton();
        btnA08 = new javax.swing.JButton();
        btnA09 = new javax.swing.JButton();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        pannelKhuB = new javax.swing.JPanel();
        btnB01 = new javax.swing.JButton();
        btnB02 = new javax.swing.JButton();
        btnB03 = new javax.swing.JButton();
        btnB04 = new javax.swing.JButton();
        btnB05 = new javax.swing.JButton();
        btnB06 = new javax.swing.JButton();
        btnB07 = new javax.swing.JButton();
        btnB08 = new javax.swing.JButton();
        pannelDv = new javax.swing.JPanel();
        pannelChonDv = new javax.swing.JPanel();
        pannelTools = new javax.swing.JPanel();
        btnGross = new javax.swing.JButton();
        btnCup = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnAddNew = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        pannelSelectDv = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        cbbSelect1 = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        cbbTotal1 = new javax.swing.JComboBox<>();
        btnAdd1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        cbbSelect2 = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        cbbTotal2 = new javax.swing.JComboBox<>();
        btnAdd2 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        txtSua = new javax.swing.JLabel();
        cbbSelect3 = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        cbbTotal3 = new javax.swing.JComboBox<>();
        btnAdd3 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        cbbSelect4 = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        cbbTotal4 = new javax.swing.JComboBox<>();
        btnAdd4 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        cbbSelect5 = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        cbbTotal5 = new javax.swing.JComboBox<>();
        btnAdd5 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        cbbSelect6 = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        cbbTotal6 = new javax.swing.JComboBox<>();
        btnAdd6 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        cbbSelect7 = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        cbbTotal7 = new javax.swing.JComboBox<>();
        btnAdd7 = new javax.swing.JButton();
        pannelHoadon = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableBill = new javax.swing.JTable();
        pannelTT = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jTableNumber = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLable3 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        price = new javax.swing.JLabel();
        btnPrintf = new javax.swing.JButton();
        btnDeletes = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnTotalPrice = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtDate = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jButton11.setText("jButton11");

        btnA01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/notselect.jpg"))); // NOI18N
        btnA01.setText("A01");
        btnA01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnA01ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pannelTool.setLayout(new java.awt.GridLayout(1, 5));

        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logout.png"))); // NOI18N
        btnLogout.setText("  Đăng xuất");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        pannelTool.add(btnLogout);

        btnRepassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/repass.jpg"))); // NOI18N
        btnRepassword.setText("  Đổi mật khẩu");
        btnRepassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRepasswordActionPerformed(evt);
            }
        });
        pannelTool.add(btnRepassword);

        btnUtilities.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Utilities.png"))); // NOI18N
        btnUtilities.setText("Tiện ích");
        btnUtilities.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUtilitiesActionPerformed(evt);
            }
        });
        pannelTool.add(btnUtilities);

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/exit.jpg"))); // NOI18N
        btnExit.setText("Thoát");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        pannelTool.add(btnExit);

        cbbLanguage.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Thay đổi ngôn ngữ ---", "Tiếng việt", "Tiếng anh" }));
        cbbLanguage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLanguageActionPerformed(evt);
            }
        });
        pannelTool.add(cbbLanguage);

        pannelUser.setLayout(new java.awt.GridLayout(1, 2));

        roles.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        roles.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pannelUser.add(roles);

        txtHello.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtHello.setText("Admin");
        pannelUser.add(txtHello);

        pannelLogo.setLayout(new java.awt.GridBagLayout());
        pannelLogo.add(jLabel6, new java.awt.GridBagConstraints());

        pannelPrimary.setLayout(new java.awt.GridLayout(1, 0));

        pannelHomes.setPreferredSize(new java.awt.Dimension(900, 500));

        pannelSelect.setLayout(new java.awt.GridLayout(6, 0));

        btnManagaEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/manager.png"))); // NOI18N
        btnManagaEmployee.setText("Quản lí nhân viên");
        btnManagaEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManagaEmployeeActionPerformed(evt);
            }
        });
        pannelSelect.add(btnManagaEmployee);

        btnManagerAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/account.png"))); // NOI18N
        btnManagerAccount.setText("Quản lí giờ làm ");
        btnManagerAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManagerAccountActionPerformed(evt);
            }
        });
        pannelSelect.add(btnManagerAccount);

        btnManagerSell.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/sell.png"))); // NOI18N
        btnManagerSell.setText("Quản lí bán hàng - Thu chi");
        btnManagerSell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManagerSellActionPerformed(evt);
            }
        });
        pannelSelect.add(btnManagerSell);

        btnManageStore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dry.png"))); // NOI18N
        btnManageStore.setText("Quản lí kho");
        btnManageStore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageStoreActionPerformed(evt);
            }
        });
        pannelSelect.add(btnManageStore);

        btnExitSystem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/tienich.png"))); // NOI18N
        btnExitSystem.setText("Máy tính");
        btnExitSystem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitSystemActionPerformed(evt);
            }
        });
        pannelSelect.add(btnExitSystem);

        btnExitSystem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/exit1.png"))); // NOI18N
        btnExitSystem1.setText("Thoát hệ thống");
        btnExitSystem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitSystem1ActionPerformed(evt);
            }
        });
        pannelSelect.add(btnExitSystem1);

        pannelMain.setLayout(new java.awt.GridLayout(1, 0));

        pannelShow.setBackground(new java.awt.Color(255, 255, 255));
        pannelShow.setLayout(new java.awt.GridBagLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logoMain.jpg"))); // NOI18N
        pannelShow.add(jLabel2, new java.awt.GridBagConstraints());

        pannelMain.add(pannelShow);

        pannelLogoItem.setLayout(new java.awt.GridLayout(1, 0));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logocfM.jpg"))); // NOI18N
        pannelLogoItem.add(jLabel5);

        javax.swing.GroupLayout pannelHomesLayout = new javax.swing.GroupLayout(pannelHomes);
        pannelHomes.setLayout(pannelHomesLayout);
        pannelHomesLayout.setHorizontalGroup(
            pannelHomesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelHomesLayout.createSequentialGroup()
                .addGroup(pannelHomesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pannelSelect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pannelLogoItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(pannelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pannelHomesLayout.setVerticalGroup(
            pannelHomesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelHomesLayout.createSequentialGroup()
                .addComponent(pannelLogoItem, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pannelSelect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(pannelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        txtTrangchu.addTab("   Trang Chủ  ", new javax.swing.ImageIcon(getClass().getResource("/Images/home.png")), pannelHomes); // NOI18N

        pannelTable.setLayout(new java.awt.GridLayout(2, 0));

        pannelKhuA.setLayout(new java.awt.GridLayout(5, 2));

        btnA02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/notselect.jpg"))); // NOI18N
        btnA02.setText("A02");
        btnA02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnA02ActionPerformed(evt);
            }
        });
        pannelKhuA.add(btnA02);

        btnA03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/notselect.jpg"))); // NOI18N
        btnA03.setText("A03");
        btnA03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnA03ActionPerformed(evt);
            }
        });
        pannelKhuA.add(btnA03);

        btnA04.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/notselect.jpg"))); // NOI18N
        btnA04.setText("A04");
        btnA04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnA04ActionPerformed(evt);
            }
        });
        pannelKhuA.add(btnA04);

        btnA05.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/notselect.jpg"))); // NOI18N
        btnA05.setText("A05");
        btnA05.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnA05ActionPerformed(evt);
            }
        });
        pannelKhuA.add(btnA05);

        btnA06.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/notselect.jpg"))); // NOI18N
        btnA06.setText("A06");
        btnA06.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnA06ActionPerformed(evt);
            }
        });
        pannelKhuA.add(btnA06);

        btnA07.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/notselect.jpg"))); // NOI18N
        btnA07.setText("A07");
        btnA07.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnA07ActionPerformed(evt);
            }
        });
        pannelKhuA.add(btnA07);

        btnA08.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/notselect.jpg"))); // NOI18N
        btnA08.setText("A08");
        btnA08.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnA08ActionPerformed(evt);
            }
        });
        pannelKhuA.add(btnA08);

        btnA09.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/notselect.jpg"))); // NOI18N
        btnA09.setText("A09");
        btnA09.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnA09ActionPerformed(evt);
            }
        });
        pannelKhuA.add(btnA09);

        jTabbedPane2.addTab("Khu Sân Vườn", new javax.swing.ImageIcon(getClass().getResource("/Images/A.png")), pannelKhuA); // NOI18N

        pannelTable.add(jTabbedPane2);

        pannelKhuB.setLayout(new java.awt.GridLayout(5, 4));

        btnB01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/notselect.jpg"))); // NOI18N
        btnB01.setText("B01");
        btnB01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnB01ActionPerformed(evt);
            }
        });
        pannelKhuB.add(btnB01);

        btnB02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/notselect.jpg"))); // NOI18N
        btnB02.setText("B02");
        btnB02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnB02ActionPerformed(evt);
            }
        });
        pannelKhuB.add(btnB02);

        btnB03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/notselect.jpg"))); // NOI18N
        btnB03.setText("B03");
        btnB03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnB03ActionPerformed(evt);
            }
        });
        pannelKhuB.add(btnB03);

        btnB04.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/notselect.jpg"))); // NOI18N
        btnB04.setText("B04");
        btnB04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnB04ActionPerformed(evt);
            }
        });
        pannelKhuB.add(btnB04);

        btnB05.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/notselect.jpg"))); // NOI18N
        btnB05.setText("B05");
        btnB05.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnB05ActionPerformed(evt);
            }
        });
        pannelKhuB.add(btnB05);

        btnB06.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/notselect.jpg"))); // NOI18N
        btnB06.setText("B06");
        btnB06.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnB06ActionPerformed(evt);
            }
        });
        pannelKhuB.add(btnB06);

        btnB07.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/notselect.jpg"))); // NOI18N
        btnB07.setText("B07");
        btnB07.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnB07ActionPerformed(evt);
            }
        });
        pannelKhuB.add(btnB07);

        btnB08.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/notselect.jpg"))); // NOI18N
        btnB08.setText("B08");
        btnB08.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnB08ActionPerformed(evt);
            }
        });
        pannelKhuB.add(btnB08);

        jTabbedPane3.addTab("Khu Trong Nhà", new javax.swing.ImageIcon(getClass().getResource("/Images/B.png")), pannelKhuB); // NOI18N

        pannelTable.add(jTabbedPane3);

        pannelDv.setLayout(new java.awt.GridLayout(2, 0));

        pannelTools.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức năng"));
        pannelTools.setLayout(new java.awt.GridLayout(5, 0));

        btnGross.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/gop.png"))); // NOI18N
        btnGross.setText("Gộp bàn");
        btnGross.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrossActionPerformed(evt);
            }
        });
        pannelTools.add(btnGross);

        btnCup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/tach.png"))); // NOI18N
        btnCup.setText("Tách bàn");
        btnCup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCupActionPerformed(evt);
            }
        });
        pannelTools.add(btnCup);

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/delete.png"))); // NOI18N
        btnDelete.setText("Xóa bàn");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        pannelTools.add(btnDelete);

        btnAddNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/total.png"))); // NOI18N
        btnAddNew.setText("Thêm bàn");
        btnAddNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewActionPerformed(evt);
            }
        });
        pannelTools.add(btnAddNew);

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/searchTable.png"))); // NOI18N
        btnSearch.setText("Tìm bàn");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        pannelTools.add(btnSearch);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Chọn dịch vụ"));
        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        pannelSelectDv.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pannelSelectDv.setLayout(new java.awt.GridLayout(7, 0));

        jPanel5.setLayout(new java.awt.GridLayout(1, 6));

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Tráng  miệng:");
        jPanel5.add(jLabel17);
        jPanel5.add(cbbSelect1);

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Số lượng:");
        jPanel5.add(jLabel18);

        cbbTotal1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        jPanel5.add(cbbTotal1);

        btnAdd1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add.png"))); // NOI18N
        btnAdd1.setText("Thêm");
        btnAdd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd1ActionPerformed(evt);
            }
        });
        jPanel5.add(btnAdd1);

        pannelSelectDv.add(jPanel5);

        jPanel4.setLayout(new java.awt.GridLayout(1, 6));

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Cafe:");
        jPanel4.add(jLabel19);
        jPanel4.add(cbbSelect2);

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Số lượng:");
        jPanel4.add(jLabel20);

        cbbTotal2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        jPanel4.add(cbbTotal2);

        btnAdd2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add.png"))); // NOI18N
        btnAdd2.setText("Thêm");
        btnAdd2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd2ActionPerformed(evt);
            }
        });
        jPanel4.add(btnAdd2);

        pannelSelectDv.add(jPanel4);

        jPanel6.setLayout(new java.awt.GridLayout(1, 6));

        txtSua.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSua.setText("Sữa:");
        jPanel6.add(txtSua);
        jPanel6.add(cbbSelect3);

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Số lượng:");
        jPanel6.add(jLabel22);

        cbbTotal3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        jPanel6.add(cbbTotal3);

        btnAdd3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add.png"))); // NOI18N
        btnAdd3.setText("Thêm");
        btnAdd3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd3ActionPerformed(evt);
            }
        });
        jPanel6.add(btnAdd3);

        pannelSelectDv.add(jPanel6);

        jPanel7.setLayout(new java.awt.GridLayout(1, 6));

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Nước:");
        jPanel7.add(jLabel23);
        jPanel7.add(cbbSelect4);

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Số lượng:");
        jPanel7.add(jLabel24);

        cbbTotal4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        jPanel7.add(cbbTotal4);

        btnAdd4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add.png"))); // NOI18N
        btnAdd4.setText("Thêm");
        btnAdd4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd4ActionPerformed(evt);
            }
        });
        jPanel7.add(btnAdd4);

        pannelSelectDv.add(jPanel7);

        jPanel8.setLayout(new java.awt.GridLayout(1, 6));

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Pha chế:");
        jPanel8.add(jLabel25);
        jPanel8.add(cbbSelect5);

        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Số lượng:");
        jPanel8.add(jLabel26);

        cbbTotal5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        jPanel8.add(cbbTotal5);

        btnAdd5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add.png"))); // NOI18N
        btnAdd5.setText("Thêm");
        btnAdd5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd5ActionPerformed(evt);
            }
        });
        jPanel8.add(btnAdd5);

        pannelSelectDv.add(jPanel8);

        jPanel11.setLayout(new java.awt.GridLayout(1, 6));

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Nước trái cây:");
        jPanel11.add(jLabel27);
        jPanel11.add(cbbSelect6);

        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Số lượng:");
        jPanel11.add(jLabel28);

        cbbTotal6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        jPanel11.add(cbbTotal6);

        btnAdd6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add.png"))); // NOI18N
        btnAdd6.setText("Thêm");
        btnAdd6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd6ActionPerformed(evt);
            }
        });
        jPanel11.add(btnAdd6);

        pannelSelectDv.add(jPanel11);

        jPanel12.setLayout(new java.awt.GridLayout(1, 6));

        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Thuốc:");
        jPanel12.add(jLabel29);
        jPanel12.add(cbbSelect7);

        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Số lượng:");
        jPanel12.add(jLabel30);

        cbbTotal7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        jPanel12.add(cbbTotal7);

        btnAdd7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add.png"))); // NOI18N
        btnAdd7.setText("Thêm");
        btnAdd7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd7ActionPerformed(evt);
            }
        });
        jPanel12.add(btnAdd7);

        pannelSelectDv.add(jPanel12);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pannelSelectDv, javax.swing.GroupLayout.DEFAULT_SIZE, 1147, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pannelSelectDv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel2);

        javax.swing.GroupLayout pannelChonDvLayout = new javax.swing.GroupLayout(pannelChonDv);
        pannelChonDv.setLayout(pannelChonDvLayout);
        pannelChonDvLayout.setHorizontalGroup(
            pannelChonDvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pannelChonDvLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(pannelTools, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pannelChonDvLayout.setVerticalGroup(
            pannelChonDvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pannelTools, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pannelDv.add(pannelChonDv);

        pannelHoadon.setBorder(javax.swing.BorderFactory.createTitledBorder("Hóa đơn"));
        pannelHoadon.setLayout(new java.awt.GridLayout(1, 2));

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel10.setLayout(new java.awt.GridLayout(1, 0));

        tableBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableBillMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableBillMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tableBill);

        jPanel10.add(jScrollPane1);

        pannelHoadon.add(jPanel10);

        pannelTT.setBackground(new java.awt.Color(255, 255, 204));
        pannelTT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pannelTT.setLayout(new java.awt.GridLayout(6, 2));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Thông tin bàn số:");
        pannelTT.add(jLabel9);

        jTableNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pannelTT.add(jTableNumber);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Tổng tiền:");
        pannelTT.add(jLabel11);

        total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        total.setText("0");
        pannelTT.add(total);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Khuyến mãi:");
        pannelTT.add(jLabel13);

        jLable3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLable3.setText("0%");
        pannelTT.add(jLable3);

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("VAT:");
        pannelTT.add(jLabel15);

        price.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        price.setText("0%");
        pannelTT.add(price);

        btnPrintf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/printf.png"))); // NOI18N
        btnPrintf.setText("In hóa đơn");
        btnPrintf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintfActionPerformed(evt);
            }
        });
        pannelTT.add(btnPrintf);

        btnDeletes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/deletess.png"))); // NOI18N
        btnDeletes.setText("Mặc định");
        btnDeletes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletesActionPerformed(evt);
            }
        });
        pannelTT.add(btnDeletes);

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/save.jpg"))); // NOI18N
        btnSave.setText("Lưu");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        pannelTT.add(btnSave);

        btnTotalPrice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/monney.png"))); // NOI18N
        btnTotalPrice.setText("Tính tiền");
        btnTotalPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTotalPriceActionPerformed(evt);
            }
        });
        pannelTT.add(btnTotalPrice);

        pannelHoadon.add(pannelTT);

        pannelDv.add(pannelHoadon);

        javax.swing.GroupLayout pannelBLayout = new javax.swing.GroupLayout(pannelB);
        pannelB.setLayout(pannelBLayout);
        pannelBLayout.setHorizontalGroup(
            pannelBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelBLayout.createSequentialGroup()
                .addComponent(pannelTable, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pannelDv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pannelBLayout.setVerticalGroup(
            pannelBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pannelTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pannelDv, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        txtTrangchu.addTab("Bàn - Dịch vụ", new javax.swing.ImageIcon(getClass().getResource("/Images/cafe.png")), pannelB); // NOI18N

        pannelPrimary.add(txtTrangchu);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel9.setOpaque(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Ngày:");

        txtDate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel9, new java.awt.GridBagConstraints());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel1.add(jLabel3, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pannelTool, javax.swing.GroupLayout.PREFERRED_SIZE, 1008, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pannelUser, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(pannelLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pannelPrimary, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pannelUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pannelTool, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(pannelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pannelPrimary, javax.swing.GroupLayout.DEFAULT_SIZE, 693, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnRepasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRepasswordActionPerformed
        frmRepassword repass = new frmRepassword();
        repass.setVisible(true);
    }//GEN-LAST:event_btnRepasswordActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        int i = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn đăng xuất khỏi hệ thống ?");
        switch (i) {
            case 0: // yes
                this.setVisible(false);
                frmLogin login = new frmLogin();
                login.setVisible(true);

            case 1: // no 
        }

    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnGrossActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrossActionPerformed
        JOptionPane.showMessageDialog(this, "Chức năng này sẽ được phát triển trong tương lai");
    }//GEN-LAST:event_btnGrossActionPerformed

    private void cbbLanguageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLanguageActionPerformed
        int s = cbbLanguage.getSelectedIndex();
        if (s == 0) {
            locale = new Locale("vi", "VN");
        }
        if (s == 1) {
            locale = new Locale("vi", "VN");
        } else {
            locale = new Locale("en", "US");
        }
        ResourceBundle bundle = ResourceBundle.getBundle("Directorys.language", locale);
        btnLogout.setText(bundle.getString("key1"));
        btnRepassword.setText(bundle.getString("key2"));
        btnUtilities.setText(bundle.getString("key3"));
        btnExit.setText(bundle.getString("key4"));
        roles.setText(bundle.getString("key5"));

        pannelHomes.setToolTipText(bundle.getString("key6"));
        txtTrangchu.setToolTipText(bundle.getString("key7"));

        btnManagaEmployee.setText(bundle.getString("key8"));
        btnManagerSell.setText(bundle.getString("key9"));
        btnManageStore.setText(bundle.getString("key10"));
        btnManagerAccount.setText(bundle.getString("key11"));
        btnExitSystem.setText(bundle.getString("key12"));
        btnExitSystem1.setText(bundle.getString("key13"));

        jLabel4.setText(bundle.getString("key14"));

        jTabbedPane2.setToolTipText(bundle.getString("key17"));
        jTabbedPane3.setToolTipText(bundle.getString("key18"));

        jPanel3.setToolTipText(bundle.getString("key19"));

        jLabel17.setText(bundle.getString("key20"));
        jLabel19.setText(bundle.getString("key21"));
        txtSua.setText(bundle.getString("key22"));
        jLabel23.setText(bundle.getString("key23"));
        jLabel25.setText(bundle.getString("key24"));
        jLabel27.setText(bundle.getString("key25"));
        jLabel29.setText(bundle.getString("key26"));

        jLabel18.setText(bundle.getString("key27"));
        jLabel20.setText(bundle.getString("key28"));
        jLabel22.setText(bundle.getString("key29"));
        jLabel24.setText(bundle.getString("key30"));
        jLabel26.setText(bundle.getString("key31"));
        jLabel28.setText(bundle.getString("key32"));
        jLabel30.setText(bundle.getString("key33"));

        btnAdd1.setText(bundle.getString("key34"));
        btnAdd2.setText(bundle.getString("key35"));
        btnAdd3.setText(bundle.getString("key36"));
        btnAdd4.setText(bundle.getString("key37"));
        btnAdd5.setText(bundle.getString("key38"));
        btnAdd6.setText(bundle.getString("key39"));
        btnAdd7.setText(bundle.getString("key40"));

        pannelTools.setToolTipText(bundle.getString("key41"));

        btnGross.setText(bundle.getString("key42"));
        btnCup.setText(bundle.getString("key43"));
        btnDelete.setText(bundle.getString("key44"));
        btnAddNew.setText(bundle.getString("key45"));
        btnSearch.setText(bundle.getString("key46"));

        pannelHoadon.setToolTipText(bundle.getString("key47"));

        jLabel9.setText(bundle.getString("key48"));
        jLabel11.setText(bundle.getString("key49"));
        jLabel13.setText(bundle.getString("key50"));
        jLabel15.setText(bundle.getString("key51"));
        btnPrintf.setText(bundle.getString("key52"));
        btnDeletes.setText(bundle.getString("key53"));
        btnTotalPrice.setText(bundle.getString("key54"));
        btnSave.setText(bundle.getString("key55"));

    }//GEN-LAST:event_cbbLanguageActionPerformed

    private void btnManagaEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManagaEmployeeActionPerformed
        callEmp();
    }//GEN-LAST:event_btnManagaEmployeeActionPerformed

    private void btnManagerSellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManagerSellActionPerformed
        callSell();
    }//GEN-LAST:event_btnManagerSellActionPerformed

    private void btnAddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewActionPerformed
        btnA10 = new javax.swing.JButton();
        btnA10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/notselect.jpg")));
        btnA10.setText("A10");
        btnA10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnA10ActionPerformed(evt);
            }
        });
        pannelKhuA.add(btnA10);

    }//GEN-LAST:event_btnAddNewActionPerformed
    private void btnA10ActionPerformed(java.awt.event.ActionEvent evt) {
        jTableNumber.setText("A10");
    }
    private void btnA01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnA01ActionPerformed
        jTableNumber.setText(btnA01.getText());
        total.setText(total1 + "");

        tableBill.setModel(new DefaultTableModel(banA01, head));
    }//GEN-LAST:event_btnA01ActionPerformed

    private void btnA02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnA02ActionPerformed
        jTableNumber.setText(btnA02.getText());
        total.setText(total2 + "");
        tableBill.setModel(new DefaultTableModel(banA02, head));
    }//GEN-LAST:event_btnA02ActionPerformed

    private void btnA03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnA03ActionPerformed
        jTableNumber.setText(btnA03.getText());
        total.setText(total3 + "");
        tableBill.setModel(new DefaultTableModel(banA03, head));
    }//GEN-LAST:event_btnA03ActionPerformed

    private void btnA04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnA04ActionPerformed
        jTableNumber.setText(btnA04.getText());
        total.setText(total4 + "");
        tableBill.setModel(new DefaultTableModel(banA04, head));
    }//GEN-LAST:event_btnA04ActionPerformed

    private void btnA05ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnA05ActionPerformed
        jTableNumber.setText(btnA05.getText());
        total.setText(total5 + "");
        tableBill.setModel(new DefaultTableModel(banA05, head));
    }//GEN-LAST:event_btnA05ActionPerformed

    private void btnA06ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnA06ActionPerformed
        jTableNumber.setText(btnA06.getText());
        total.setText(total6 + "");
        tableBill.setModel(new DefaultTableModel(banA06, head));
    }//GEN-LAST:event_btnA06ActionPerformed

    private void btnA07ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnA07ActionPerformed
        jTableNumber.setText(btnA07.getText());
        total.setText(total7 + "");
        tableBill.setModel(new DefaultTableModel(banA07, head));
    }//GEN-LAST:event_btnA07ActionPerformed

    private void btnA08ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnA08ActionPerformed
        jTableNumber.setText(btnA08.getText());
        total.setText(total8 + "");
        tableBill.setModel(new DefaultTableModel(banA08, head));
    }//GEN-LAST:event_btnA08ActionPerformed

    private void btnA09ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnA09ActionPerformed
        jTableNumber.setText(btnA09.getText());
        total.setText(total9 + "");
        tableBill.setModel(new DefaultTableModel(banA09, head));
    }//GEN-LAST:event_btnA09ActionPerformed

    private void btnB01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnB01ActionPerformed
        jTableNumber.setText(btnB01.getText());
        total.setText(total10 + "");
        tableBill.setModel(new DefaultTableModel(banB01, head));
    }//GEN-LAST:event_btnB01ActionPerformed

    private void btnB02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnB02ActionPerformed
        jTableNumber.setText(btnB02.getText());
        total.setText(total11 + "");
        tableBill.setModel(new DefaultTableModel(banB02, head));
    }//GEN-LAST:event_btnB02ActionPerformed

    private void btnB03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnB03ActionPerformed
        jTableNumber.setText(btnB03.getText());
        total.setText(total12 + "");
        tableBill.setModel(new DefaultTableModel(banB03, head));
    }//GEN-LAST:event_btnB03ActionPerformed

    private void btnB04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnB04ActionPerformed
        jTableNumber.setText(btnB04.getText());
        total.setText(total13 + "");
        tableBill.setModel(new DefaultTableModel(banB04, head));
    }//GEN-LAST:event_btnB04ActionPerformed

    private void btnB05ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnB05ActionPerformed
        jTableNumber.setText(btnB05.getText());
        total.setText(total14 + "");
        tableBill.setModel(new DefaultTableModel(banB05, head));
    }//GEN-LAST:event_btnB05ActionPerformed

    private void btnB06ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnB06ActionPerformed
        jTableNumber.setText(btnB06.getText());
        total.setText(total15 + "");
        tableBill.setModel(new DefaultTableModel(banB06, head));
    }//GEN-LAST:event_btnB06ActionPerformed

    private void btnB07ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnB07ActionPerformed
        jTableNumber.setText(btnB07.getText());
        total.setText(total16 + "");
        tableBill.setModel(new DefaultTableModel(banB07, head));
    }//GEN-LAST:event_btnB07ActionPerformed

    private void btnB08ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnB08ActionPerformed
        jTableNumber.setText(btnB08.getText());
        total.setText(total17 + "");
        tableBill.setModel(new DefaultTableModel(banB08, head));
    }//GEN-LAST:event_btnB08ActionPerformed

    private void btnManageStoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageStoreActionPerformed
        callStore();
    }//GEN-LAST:event_btnManageStoreActionPerformed

    private void btnExitSystemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitSystemActionPerformed
        frmCalculates ca = new frmCalculates();
        ca.setVisible(true);
    }//GEN-LAST:event_btnExitSystemActionPerformed

    private void btnExitSystem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitSystem1ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnExitSystem1ActionPerformed

    private void btnManagerAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManagerAccountActionPerformed
        callAccount();
    }//GEN-LAST:event_btnManagerAccountActionPerformed

    private void btnAdd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd1ActionPerformed
        String numberDesk = jTableNumber.getText();
        if (numberDesk.equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn bàn ?");
        }
        if (numberDesk.equals("A01")) {
            btnA01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan01();
            totalA01();
        } else if (numberDesk.equals("A02")) {
            btnA02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan02();
            totalA02();
        } else if (numberDesk.equals("A03")) {
            btnA03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan03();
            totalA03();
        } else if (numberDesk.equals("A04")) {
            btnA04.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan04();
            totalA04();
        } else if (numberDesk.equals("A05")) {
            btnA05.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan05();
            totalA05();
        } else if (numberDesk.equals("A06")) {
            btnA06.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan06();
            totalA06();
        } else if (numberDesk.equals("A07")) {
            btnA07.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan07();
            totalA07();
        } else if (numberDesk.equals("A08")) {
            btnA08.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan08();
            totalA08();
        } else if (numberDesk.equals("A09")) {
            btnA09.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan09();
            totalA09();
        } else if (numberDesk.equals("B01")) {
            btnB01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBanB01();
            totalB01();
        } else if (numberDesk.equals("B02")) {
            btnB02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBanB02();
            totalB02();
        } else if (numberDesk.equals("B03")) {
            btnB03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBanB03();
            totalB03();
        } else if (numberDesk.equals("B04")) {
            btnB04.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBanB04();
            totalB04();
        } else if (numberDesk.equals("B05")) {
            btnB05.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBanB05();
            totalB05();
        } else if (numberDesk.equals("B06")) {
            btnB06.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBanB06();
            totalB06();
        } else if (numberDesk.equals("B07")) {
            btnB07.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBanB07();
            totalB07();
        } else if (numberDesk.equals("B08")) {
            btnB08.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBanB08();
            totalB08();
        }


    }//GEN-LAST:event_btnAdd1ActionPerformed

    private void btnAdd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd2ActionPerformed
        String numberDesk = jTableNumber.getText();
        if (numberDesk.equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn bàn ?");
        }
        if (numberDesk.equals("A01")) {
            btnA01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan11();
            totalA011();
        } else if (numberDesk.equals("A02")) {
            btnA02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan22();
            totalA022();
        } else if (numberDesk.equals("A03")) {
            btnA03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan33();
            totalA033();
        } else if (numberDesk.equals("A04")) {
            btnA04.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan44();
            totalA044();
        } else if (numberDesk.equals("A05")) {
            btnA05.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan55();
            totalA055();
        } else if (numberDesk.equals("A06")) {
            btnA06.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan66();
            totalA066();
        } else if (numberDesk.equals("A07")) {
            btnA07.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan77();
            totalA077();
        } else if (numberDesk.equals("A08")) {
            btnA08.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan88();
            totalA088();
        } else if (numberDesk.equals("A09")) {
            btnA09.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan99();
            totalA099();
        } else if (numberDesk.equals("B01")) {
            btnB01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBanB011();
            totalB011();
        } else if (numberDesk.equals("B02")) {
            btnB02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBanB022();
            totalB022();
        } else if (numberDesk.equals("B03")) {
            btnB03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBanB033();
            totalB033();
        } else if (numberDesk.equals("B04")) {
            btnB04.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBanB044();
            totalB044();
        } else if (numberDesk.equals("B05")) {
            btnB05.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBanB055();
            totalB055();
        } else if (numberDesk.equals("B06")) {
            btnB06.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBanB066();
            totalB066();
        } else if (numberDesk.equals("B07")) {
            btnB07.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBanB077();
            totalB077();
        } else if (numberDesk.equals("B08")) {
            btnB08.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBanB088();
            totalB088();
        }
    }//GEN-LAST:event_btnAdd2ActionPerformed

    private void btnDeletesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletesActionPerformed
        String numberDesk = jTableNumber.getText();
        if (numberDesk.equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn bàn !");
        } else {
            int i = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xóa dữ liệu của bàn : " + numberDesk);
            switch (i) {
                case 0: // yes
                    if (numberDesk.equals("A01")) {
                        banA01.removeAll(banA01);
                        tableBill.setModel(new DefaultTableModel(banA01, head));
                        btnA01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/notselect.jpg")));
                        total.setText("");

                    } else if (numberDesk.equals("A02")) {
                        banA02.removeAll(banA02);
                        tableBill.setModel(new DefaultTableModel(banA02, head));
                        btnA02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/notselect.jpg")));
                        total.setText("");
                    } else if (numberDesk.equals("A03")) {
                        banA03.removeAll(banA03);
                        tableBill.setModel(new DefaultTableModel(banA03, head));
                        btnA03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/notselect.jpg")));
                        total.setText("");
                    } else if (numberDesk.equals("A04")) {
                        banA04.removeAll(banA04);
                        tableBill.setModel(new DefaultTableModel(banA04, head));
                        btnA04.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/notselect.jpg")));
                        total.setText("");
                    } else if (numberDesk.equals("A05")) {
                        banA05.removeAll(banA05);
                        tableBill.setModel(new DefaultTableModel(banA05, head));
                        btnA05.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/notselect.jpg")));
                        total.setText("");
                    } else if (numberDesk.equals("A06")) {
                        banA06.removeAll(banA06);
                        tableBill.setModel(new DefaultTableModel(banA06, head));
                        btnA06.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/notselect.jpg")));
                        total.setText("");
                    } else if (numberDesk.equals("A07")) {
                        banA07.removeAll(banA07);
                        tableBill.setModel(new DefaultTableModel(banA07, head));
                        btnA07.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/notselect.jpg")));
                        total.setText("");
                    } else if (numberDesk.equals("A08")) {
                        banA08.removeAll(banA08);
                        tableBill.setModel(new DefaultTableModel(banA08, head));
                        btnA08.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/notselect.jpg")));
                        total.setText("");
                    } else if (numberDesk.equals("A09")) {
                        banA09.removeAll(banA09);
                        tableBill.setModel(new DefaultTableModel(banA09, head));
                        btnA09.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/notselect.jpg")));
                        total.setText("");
                    } else if (numberDesk.equals("B01")) {
                        banB01.removeAll(banB01);
                        tableBill.setModel(new DefaultTableModel(banB01, head));
                        btnB01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/notselect.jpg")));
                        total.setText("");
                    } else if (numberDesk.equals("B02")) {
                        banB02.removeAll(banB02);
                        tableBill.setModel(new DefaultTableModel(banB02, head));
                        btnB02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/notselect.jpg")));
                        total.setText("");
                    } else if (numberDesk.equals("B03")) {
                        banB03.removeAll(banB03);
                        tableBill.setModel(new DefaultTableModel(banB03, head));
                        btnB03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/notselect.jpg")));
                        total.setText("");
                    } else if (numberDesk.equals("B04")) {
                        banB04.removeAll(banB04);
                        tableBill.setModel(new DefaultTableModel(banB04, head));
                        btnB04.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/notselect.jpg")));
                        total.setText("");
                    } else if (numberDesk.equals("B05")) {
                        banB05.removeAll(banB05);
                        tableBill.setModel(new DefaultTableModel(banB05, head));
                        btnB05.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/notselect.jpg")));
                        total.setText("");
                    } else if (numberDesk.equals("B06")) {
                        banB06.removeAll(banB06);
                        tableBill.setModel(new DefaultTableModel(banB06, head));
                        btnB06.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/notselect.jpg")));
                        total.setText("");
                    } else if (numberDesk.equals("B07")) {
                        banB07.removeAll(banB07);
                        tableBill.setModel(new DefaultTableModel(banB07, head));
                        btnB07.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/notselect.jpg")));
                        total.setText("");
                    } else if (numberDesk.equals("B08")) {
                        banB08.removeAll(banB08);
                        tableBill.setModel(new DefaultTableModel(banB08, head));
                        btnB08.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/notselect.jpg")));
                        total.setText("");
                    }
                case 1: // no 

            }
        }


    }//GEN-LAST:event_btnDeletesActionPerformed

    private void tableBillMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableBillMouseReleased

    }//GEN-LAST:event_tableBillMouseReleased

    private void btnAdd3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd3ActionPerformed
        String numberDesk = jTableNumber.getText();
        if (numberDesk.equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn bàn ?");
        }
        if (numberDesk.equals("A01")) {
            btnA01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan111();
            totalA0111();
        } else if (numberDesk.equals("A02")) {
            btnA02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan222();
            totalA0222();
        } else if (numberDesk.equals("A03")) {
            btnA03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan333();
            totalA0333();
        } else if (numberDesk.equals("A04")) {
            btnA04.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan444();
            totalA0444();
        } else if (numberDesk.equals("A05")) {
            btnA05.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan555();
            totalA0555();
        } else if (numberDesk.equals("A06")) {
            btnA06.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan666();
            totalA0666();
        } else if (numberDesk.equals("A07")) {
            btnA07.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan777();
            totalA0777();
        } else if (numberDesk.equals("A08")) {
            btnA08.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan888();
            totalA0888();
        } else if (numberDesk.equals("A09")) {
            btnA09.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan999();
            totalA0999();
        } else if (numberDesk.equals("B01")) {
            btnB01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBanB0111();
            totalB0111();
        } else if (numberDesk.equals("B02")) {
            btnB02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBanB0222();
            totalB0222();
        } else if (numberDesk.equals("B03")) {
            btnB03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBanB0333();
            totalB0333();
        } else if (numberDesk.equals("B04")) {
            btnB04.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBanB0444();
            totalB0444();
        } else if (numberDesk.equals("B05")) {
            btnB05.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBanB0555();
            totalB0555();
        } else if (numberDesk.equals("B06")) {
            btnB06.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBanB0666();
            totalB0666();
        } else if (numberDesk.equals("B07")) {
            btnB07.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBanB0777();
            totalB0777();
        } else if (numberDesk.equals("B08")) {
            btnB08.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBanB0888();
            totalB0888();
        }
    }//GEN-LAST:event_btnAdd3ActionPerformed

    private void btnAdd4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd4ActionPerformed
        String numberDesk = jTableNumber.getText();
        if (numberDesk.equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn bàn ?");
        }
        if (numberDesk.equals("A01")) {
            btnA01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan1111();
            totalA01111();
        } else if (numberDesk.equals("A02")) {
            btnA02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan2222();
            totalA02222();
        } else if (numberDesk.equals("A03")) {
            btnA03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan3333();
            totalA03333();
        } else if (numberDesk.equals("A04")) {
            btnA04.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan4444();
            totalA04444();
        } else if (numberDesk.equals("A05")) {
            btnA05.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan5555();
            totalA05555();
        } else if (numberDesk.equals("A06")) {
            btnA06.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan6666();
            totalA06666();
        } else if (numberDesk.equals("A07")) {
            btnA07.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan7777();
            totalA07777();
        } else if (numberDesk.equals("A08")) {
            btnA08.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan8888();
            totalA08888();
        } else if (numberDesk.equals("A09")) {
            btnA09.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan9999();
            totalA09999();
        } else if (numberDesk.equals("B01")) {
            btnB01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBanB01111();
            totalB01111();
        } else if (numberDesk.equals("B02")) {
            btnB02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBanB02222();
            totalB02222();
        } else if (numberDesk.equals("B03")) {
            btnB03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBanB03333();
            totalB03333();
        } else if (numberDesk.equals("B04")) {
            btnB04.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBanB04444();
            totalB04444();
        } else if (numberDesk.equals("B05")) {
            btnB05.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBanB05555();
            totalB05555();
        } else if (numberDesk.equals("B06")) {
            btnB06.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBanB06666();
            totalB06666();
        } else if (numberDesk.equals("B07")) {
            btnB07.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBanB07777();
            totalB07777();
        } else if (numberDesk.equals("B08")) {
            btnB08.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBanB08888();
            totalB08888();
        }
    }//GEN-LAST:event_btnAdd4ActionPerformed

    private void btnAdd5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd5ActionPerformed
        String numberDesk = jTableNumber.getText();
        if (numberDesk.equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn bàn ?");
        }
        if (numberDesk.equals("A01")) {
            btnA01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan11111();
            totalA011111();
        } else if (numberDesk.equals("A02")) {
            btnA02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan22222();
            totalA022222();
        } else if (numberDesk.equals("A03")) {
            btnA03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan33333();
            totalA033333();
        } else if (numberDesk.equals("A04")) {
            btnA04.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan44444();
            totalA044444();
        } else if (numberDesk.equals("A05")) {
            btnA05.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan55555();
            totalA055555();
        } else if (numberDesk.equals("A06")) {
            btnA06.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan66666();
            totalA066666();
        } else if (numberDesk.equals("A07")) {
            btnA07.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan77777();
            totalA077777();
        } else if (numberDesk.equals("A08")) {
            btnA08.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan88888();
            totalA088888();
        } else if (numberDesk.equals("A09")) {
            btnA09.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan99999();
            totalA099999();
        } else if (numberDesk.equals("B01")) {
            btnB01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBanB011111();
            totalB011111();
        } else if (numberDesk.equals("B02")) {
            btnB02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBanB022222();
            totalB022222();
        } else if (numberDesk.equals("B03")) {
            btnB03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBanB033333();
            totalB033333();
        } else if (numberDesk.equals("B04")) {
            btnB04.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBanB044444();
            totalB044444();
        } else if (numberDesk.equals("B05")) {
            btnB05.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBanB055555();
            totalB055555();
        } else if (numberDesk.equals("B06")) {
            btnB06.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBanB066666();
            totalB066666();
        } else if (numberDesk.equals("B07")) {
            btnB07.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBanB077777();
            totalB077777();
        } else if (numberDesk.equals("B08")) {
            btnB08.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBanB088888();
            totalB088888();
        }
    }//GEN-LAST:event_btnAdd5ActionPerformed

    private void btnAdd6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd6ActionPerformed
        String numberDesk = jTableNumber.getText();
        if (numberDesk.equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn bàn ?");
        }
        if (numberDesk.equals("A01")) {
            btnA01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan111111();
            totalA0111111();
        } else if (numberDesk.equals("A02")) {
            btnA02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan222222();
            totalA0222222();
        } else if (numberDesk.equals("A03")) {
            btnA03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan333333();
            totalA0333333();
        } else if (numberDesk.equals("A04")) {
            btnA04.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan444444();
            totalA0444444();
        } else if (numberDesk.equals("A05")) {
            btnA05.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan555555();
            totalA0555555();
        } else if (numberDesk.equals("A06")) {
            btnA06.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan666666();
            totalA0666666();
        } else if (numberDesk.equals("A07")) {
            btnA07.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan777777();
            totalA0777777();
        } else if (numberDesk.equals("A08")) {
            btnA08.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan888888();
            totalA0888888();
        } else if (numberDesk.equals("A09")) {
            btnA09.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan999999();
            totalA0999999();
        } else if (numberDesk.equals("B01")) {
            btnB01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBanB0111111();
            totalB0111111();
        } else if (numberDesk.equals("B02")) {
            btnB02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBanB0222222();
            totalB0222222();
        } else if (numberDesk.equals("B03")) {
            btnB03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBanB0333333();
            totalB0333333();
        } else if (numberDesk.equals("B04")) {
            btnB04.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBanB0444444();
            totalB0444444();
        } else if (numberDesk.equals("B05")) {
            btnB05.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBanB0555555();
            totalB0555555();
        } else if (numberDesk.equals("B06")) {
            btnB06.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBanB0666666();
            totalB0666666();
        } else if (numberDesk.equals("B07")) {
            btnB07.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBanB0777777();
            totalB0777777();
        } else if (numberDesk.equals("B08")) {
            btnB08.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBanB0888888();
            totalB0888888();
        }
    }//GEN-LAST:event_btnAdd6ActionPerformed

    private void btnAdd7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd7ActionPerformed
        String numberDesk = jTableNumber.getText();
        if (numberDesk.equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn bàn ?");
        }
        if (numberDesk.equals("A01")) {
            btnA01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan1111111();
            totalA01111111();
        } else if (numberDesk.equals("A02")) {
            btnA02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan2222222();
            totalA02222222();
        } else if (numberDesk.equals("A03")) {
            btnA03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan3333333();
            totalA03333333();
        } else if (numberDesk.equals("A04")) {
            btnA04.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan4444444();
            totalA04444444();
        } else if (numberDesk.equals("A05")) {
            btnA05.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan5555555();
            totalA05555555();
        } else if (numberDesk.equals("A06")) {
            btnA06.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan6666666();
            totalA06666666();
        } else if (numberDesk.equals("A07")) {
            btnA07.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan7777777();
            totalA07777777();
        } else if (numberDesk.equals("A08")) {
            btnA08.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan8888888();
            totalA08888888();
        } else if (numberDesk.equals("A09")) {
            btnA09.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBan9999999();
            totalA09999999();
        } else if (numberDesk.equals("B01")) {
            btnB01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBanB01111111();
            totalB01111111();
        } else if (numberDesk.equals("B02")) {
            btnB02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBanB02222222();
            totalB02222222();
        } else if (numberDesk.equals("B03")) {
            btnB03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBanB03333333();
            totalB03333333();
        } else if (numberDesk.equals("B04")) {
            btnB04.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBanB04444444();
            totalB04444444();
        } else if (numberDesk.equals("B05")) {
            btnB05.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBanB05555555();
            totalB05555555();
        } else if (numberDesk.equals("B06")) {
            btnB06.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBanB06666666();
            totalB06666666();
        } else if (numberDesk.equals("B07")) {
            btnB07.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBanB07777777();
            totalB07777777();
        } else if (numberDesk.equals("B08")) {
            btnB08.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png")));
            addBanB08888888();
            totalB08888888();
        }
    }//GEN-LAST:event_btnAdd7ActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String numberDesk = jTableNumber.getText();

        String user = txtHello.getText();
        int price = Integer.parseInt(total.getText());
        String date = txtDate.getText();
        String sercode = "";

        if (!numberDesk.equals("")) {
            boolean check = true;
            int i = tableBill.getRowCount();
            if (i == 0) {
                JOptionPane.showMessageDialog(this, "Chưa có dữ liệu để lưu !");
            } else {
                if (service.insertOrder(orderId, user, date, price)) {

                } else {
                    check = false;
                }
                if (check) {

                    int rows = tableBill.getRowCount();
                    for (int row = 0; row < rows; row++) {
                        String serName = (String) tableBill.getValueAt(row, 0);
                        showSercodes = service.showSercodes(serName);
                        for (Service sv : showSercodes) {
                            sercode = sv.getSercode();
                        }
                        int prices = (Integer) tableBill.getValueAt(row, 1);
                        int quantity = (Integer) tableBill.getValueAt(row, 2);
                        String note = (String) tableBill.getValueAt(row, 3);
                        try {
                            if (service.insertOrderDetailt(orderId, serName, quantity, prices, note, sercode)) {
                                showQuantity = service.showQuantity(sercode);
                                for (Quantity sv : showQuantity) {
                                    totals = sv.getQuantity();

                                }

                            }
                            if (service.updateQuantity(totals, sercode)) {

                            }

                            if (totals < 0) {

                                JOptionPane.showMessageDialog(this, serName + " đã hết số lượng , vui lòng thêm dịch vụ !");
                                if (numberDesk.equals("A01")) {
                                    int tongtam = 0;
                                    for (int u = 0; u < tableBill.getRowCount(); u++) {
                                        String nameSevices = (String) tableBill.getValueAt(u, 0);
                                        int quantitytam = (Integer) tableBill.getValueAt(u, 2);
                                        if (serName.equals(nameSevices)) {
                                            banA01.remove(u);
                                            pricename = service.showPricewhere(serName);
                                            for (Service sv : pricename) {
                                                tongtam = sv.getPrice();
                                            }
                                            total1 = total1 - (tongtam * quantitytam);
                                            total.setText(total1 + "");
                                            order.updatePrice(total1, orderId);
                                            tableBill.updateUI();
                                        }
                                        if (order.deleteOrderid(orderId, serName)) {
                                            service.updateQuantitybyOrderid(serName);
                                        }

                                    }
                                } else if (numberDesk.equals("A02")) {
                                    int tongtam = 0;
                                    for (int u = 0; u < tableBill.getRowCount(); u++) {
                                        String nameSevices = (String) tableBill.getValueAt(u, 0);
                                        int quantitytam = (Integer) tableBill.getValueAt(u, 2);
                                        if (serName.equals(nameSevices)) {
                                            banA02.remove(u);
                                            pricename = service.showPricewhere(serName);
                                            for (Service sv : pricename) {
                                                tongtam = sv.getPrice();
                                            }
                                            total2 = total2 - (tongtam * quantitytam);
                                            total.setText(total2 + "");
                                            order.updatePrice(total2, orderId);
                                            tableBill.updateUI();
                                        }
                                        if (order.deleteOrderid(orderId, serName)) {
                                            service.updateQuantitybyOrderid(serName);
                                        }

                                    }
                                } else if (numberDesk.equals("A03")) {
                                    int tongtam = 0;
                                    for (int u = 0; u < tableBill.getRowCount(); u++) {
                                        String nameSevices = (String) tableBill.getValueAt(u, 0);
                                        int quantitytam = (Integer) tableBill.getValueAt(u, 2);
                                        if (serName.equals(nameSevices)) {
                                            banA03.remove(u);
                                            pricename = service.showPricewhere(serName);
                                            for (Service sv : pricename) {
                                                tongtam = sv.getPrice();
                                            }
                                            total3 = total3 - (tongtam * quantitytam);
                                            total.setText(total3 + "");
                                            order.updatePrice(total3, orderId);
                                            tableBill.updateUI();
                                        }
                                        if (order.deleteOrderid(orderId, serName)) {
                                            service.updateQuantitybyOrderid(serName);
                                        }

                                    }
                                } else if (numberDesk.equals("A04")) {
                                    int tongtam = 0;
                                    for (int u = 0; u < tableBill.getRowCount(); u++) {
                                        String nameSevices = (String) tableBill.getValueAt(u, 0);
                                        int quantitytam = (Integer) tableBill.getValueAt(u, 2);
                                        if (serName.equals(nameSevices)) {
                                            banA04.remove(u);
                                            pricename = service.showPricewhere(serName);
                                            for (Service sv : pricename) {
                                                tongtam = sv.getPrice();
                                            }
                                            total4 = total4 - (tongtam * quantitytam);
                                            total.setText(total4 + "");
                                            order.updatePrice(total4, orderId);
                                            tableBill.updateUI();
                                        }
                                        if (order.deleteOrderid(orderId, serName)) {
                                            service.updateQuantitybyOrderid(serName);
                                        }

                                    }
                                } else if (numberDesk.equals("A05")) {
                                    int tongtam = 0;
                                    for (int u = 0; u < tableBill.getRowCount(); u++) {
                                        String nameSevices = (String) tableBill.getValueAt(u, 0);
                                        int quantitytam = (Integer) tableBill.getValueAt(u, 2);
                                        if (serName.equals(nameSevices)) {
                                            banA05.remove(u);
                                            pricename = service.showPricewhere(serName);
                                            for (Service sv : pricename) {
                                                tongtam = sv.getPrice();
                                            }
                                            total5 = total5 - (tongtam * quantitytam);
                                            total.setText(total5 + "");
                                            order.updatePrice(total4, orderId);
                                            tableBill.updateUI();
                                        }
                                        if (order.deleteOrderid(orderId, serName)) {
                                            service.updateQuantitybyOrderid(serName);
                                        }

                                    }
                                } else if (numberDesk.equals("A06")) {
                                    int tongtam = 0;
                                    for (int u = 0; u < tableBill.getRowCount(); u++) {
                                        String nameSevices = (String) tableBill.getValueAt(u, 0);
                                        int quantitytam = (Integer) tableBill.getValueAt(u, 2);
                                        if (serName.equals(nameSevices)) {
                                            banA06.remove(u);
                                            pricename = service.showPricewhere(serName);
                                            for (Service sv : pricename) {
                                                tongtam = sv.getPrice();
                                            }
                                            total6 = total6 - (tongtam * quantitytam);
                                            total.setText(total6 + "");
                                            order.updatePrice(total6, orderId);
                                            tableBill.updateUI();
                                        }
                                        if (order.deleteOrderid(orderId, serName)) {
                                            service.updateQuantitybyOrderid(serName);
                                        }

                                    }
                                } else if (numberDesk.equals("A07")) {
                                    int tongtam = 0;
                                    for (int u = 0; u < tableBill.getRowCount(); u++) {
                                        String nameSevices = (String) tableBill.getValueAt(u, 0);
                                        int quantitytam = (Integer) tableBill.getValueAt(u, 2);
                                        if (serName.equals(nameSevices)) {
                                            banA07.remove(u);
                                            pricename = service.showPricewhere(serName);
                                            for (Service sv : pricename) {
                                                tongtam = sv.getPrice();
                                            }
                                            total7 = total7 - (tongtam * quantitytam);
                                            total.setText(total7 + "");
                                            order.updatePrice(total7, orderId);
                                            tableBill.updateUI();
                                        }
                                        if (order.deleteOrderid(orderId, serName)) {
                                            service.updateQuantitybyOrderid(serName);
                                        }

                                    }
                                } else if (numberDesk.equals("A08")) {
                                    int tongtam = 0;
                                    for (int u = 0; u < tableBill.getRowCount(); u++) {
                                        String nameSevices = (String) tableBill.getValueAt(u, 0);
                                        int quantitytam = (Integer) tableBill.getValueAt(u, 2);
                                        if (serName.equals(nameSevices)) {
                                            banA08.remove(u);
                                            pricename = service.showPricewhere(serName);
                                            for (Service sv : pricename) {
                                                tongtam = sv.getPrice();
                                            }
                                            total8 = total8 - (tongtam * quantitytam);
                                            total.setText(total8 + "");
                                            order.updatePrice(total8, orderId);
                                            tableBill.updateUI();
                                        }
                                        if (order.deleteOrderid(orderId, serName)) {
                                            service.updateQuantitybyOrderid(serName);
                                        }

                                    }
                                } else if (numberDesk.equals("A09")) {
                                    int tongtam = 0;
                                    for (int u = 0; u < tableBill.getRowCount(); u++) {
                                        String nameSevices = (String) tableBill.getValueAt(u, 0);
                                        int quantitytam = (Integer) tableBill.getValueAt(u, 2);
                                        if (serName.equals(nameSevices)) {
                                            banA09.remove(u);
                                            pricename = service.showPricewhere(serName);
                                            for (Service sv : pricename) {
                                                tongtam = sv.getPrice();
                                            }
                                            total9 = total9 - (tongtam * quantitytam);
                                            total.setText(total9 + "");
                                            order.updatePrice(total9, orderId);
                                            tableBill.updateUI();
                                        }
                                        if (order.deleteOrderid(orderId, serName)) {
                                            service.updateQuantitybyOrderid(serName);
                                        }

                                    }
                                } else if (numberDesk.equals("B01")) {
                                    int tongtam = 0;
                                    for (int u = 0; u < tableBill.getRowCount(); u++) {
                                        String nameSevices = (String) tableBill.getValueAt(u, 0);
                                        int quantitytam = (Integer) tableBill.getValueAt(u, 2);
                                        if (serName.equals(nameSevices)) {
                                            banB01.remove(u);
                                            pricename = service.showPricewhere(serName);
                                            for (Service sv : pricename) {
                                                tongtam = sv.getPrice();
                                            }
                                            total10 = total10 - (tongtam * quantitytam);
                                            total.setText(total10 + "");
                                            order.updatePrice(total10, orderId);
                                            tableBill.updateUI();
                                        }
                                        if (order.deleteOrderid(orderId, serName)) {
                                            service.updateQuantitybyOrderid(serName);
                                        }

                                    }
                                } else if (numberDesk.equals("B02")) {
                                    int tongtam = 0;
                                    for (int u = 0; u < tableBill.getRowCount(); u++) {
                                        String nameSevices = (String) tableBill.getValueAt(u, 0);
                                        int quantitytam = (Integer) tableBill.getValueAt(u, 2);
                                        if (serName.equals(nameSevices)) {
                                            banB02.remove(u);
                                            pricename = service.showPricewhere(serName);
                                            for (Service sv : pricename) {
                                                tongtam = sv.getPrice();
                                            }
                                            total11 = total11 - (tongtam * quantitytam);
                                            total.setText(total11 + "");
                                            order.updatePrice(total11, orderId);
                                            tableBill.updateUI();
                                        }
                                        if (order.deleteOrderid(orderId, serName)) {
                                            service.updateQuantitybyOrderid(serName);
                                        }

                                    }
                                } else if (numberDesk.equals("B03")) {
                                    int tongtam = 0;
                                    for (int u = 0; u < tableBill.getRowCount(); u++) {
                                        String nameSevices = (String) tableBill.getValueAt(u, 0);
                                        int quantitytam = (Integer) tableBill.getValueAt(u, 2);
                                        if (serName.equals(nameSevices)) {
                                            banB03.remove(u);
                                            pricename = service.showPricewhere(serName);
                                            for (Service sv : pricename) {
                                                tongtam = sv.getPrice();
                                            }
                                            total12 = total12 - (tongtam * quantitytam);
                                            total.setText(total12 + "");
                                            order.updatePrice(total12, orderId);
                                            tableBill.updateUI();
                                        }
                                        if (order.deleteOrderid(orderId, serName)) {
                                            service.updateQuantitybyOrderid(serName);
                                        }

                                    }
                                } else if (numberDesk.equals("B04")) {
                                    int tongtam = 0;
                                    for (int u = 0; u < tableBill.getRowCount(); u++) {
                                        String nameSevices = (String) tableBill.getValueAt(u, 0);
                                        int quantitytam = (Integer) tableBill.getValueAt(u, 2);
                                        if (serName.equals(nameSevices)) {
                                            banB04.remove(u);
                                            pricename = service.showPricewhere(serName);
                                            for (Service sv : pricename) {
                                                tongtam = sv.getPrice();
                                            }
                                            total13 = total13 - (tongtam * quantitytam);
                                            total.setText(total13 + "");
                                            order.updatePrice(total13, orderId);
                                            tableBill.updateUI();
                                        }
                                        if (order.deleteOrderid(orderId, serName)) {
                                            service.updateQuantitybyOrderid(serName);
                                        }

                                    }
                                } else if (numberDesk.equals("B05")) {
                                    int tongtam = 0;
                                    for (int u = 0; u < tableBill.getRowCount(); u++) {
                                        String nameSevices = (String) tableBill.getValueAt(u, 0);
                                        int quantitytam = (Integer) tableBill.getValueAt(u, 2);
                                        if (serName.equals(nameSevices)) {
                                            banB05.remove(u);
                                            pricename = service.showPricewhere(serName);
                                            for (Service sv : pricename) {
                                                tongtam = sv.getPrice();
                                            }
                                            total14 = total14 - (tongtam * quantitytam);
                                            total.setText(total14 + "");
                                            order.updatePrice(total14, orderId);
                                            tableBill.updateUI();
                                        }
                                        if (order.deleteOrderid(orderId, serName)) {
                                            service.updateQuantitybyOrderid(serName);
                                        }

                                    }
                                } else if (numberDesk.equals("B06")) {
                                    int tongtam = 0;
                                    for (int u = 0; u < tableBill.getRowCount(); u++) {
                                        String nameSevices = (String) tableBill.getValueAt(u, 0);
                                        int quantitytam = (Integer) tableBill.getValueAt(u, 2);
                                        if (serName.equals(nameSevices)) {
                                            banB06.remove(u);
                                            pricename = service.showPricewhere(serName);
                                            for (Service sv : pricename) {
                                                tongtam = sv.getPrice();
                                            }
                                            total15 = total15 - (tongtam * quantitytam);
                                            total.setText(total15 + "");
                                            order.updatePrice(total15, orderId);
                                            tableBill.updateUI();
                                        }
                                        if (order.deleteOrderid(orderId, serName)) {
                                            service.updateQuantitybyOrderid(serName);
                                        }

                                    }
                                } else if (numberDesk.equals("B07")) {
                                    int tongtam = 0;
                                    for (int u = 0; u < tableBill.getRowCount(); u++) {
                                        String nameSevices = (String) tableBill.getValueAt(u, 0);
                                        int quantitytam = (Integer) tableBill.getValueAt(u, 2);
                                        if (serName.equals(nameSevices)) {
                                            banB07.remove(u);
                                            pricename = service.showPricewhere(serName);
                                            for (Service sv : pricename) {
                                                tongtam = sv.getPrice();
                                            }
                                            total16 = total16 - (tongtam * quantitytam);
                                            total.setText(total16 + "");
                                            order.updatePrice(total16, orderId);
                                            tableBill.updateUI();
                                        }
                                        if (order.deleteOrderid(orderId, serName)) {
                                            service.updateQuantitybyOrderid(serName);
                                        }

                                    }
                                } else if (numberDesk.equals("B08")) {
                                    int tongtam = 0;
                                    for (int u = 0; u < tableBill.getRowCount(); u++) {
                                        String nameSevices = (String) tableBill.getValueAt(u, 0);
                                        int quantitytam = (Integer) tableBill.getValueAt(u, 2);
                                        if (serName.equals(nameSevices)) {
                                            banB08.remove(u);
                                            pricename = service.showPricewhere(serName);
                                            for (Service sv : pricename) {
                                                tongtam = sv.getPrice();
                                            }
                                            total17 = total17 - (tongtam * quantitytam);
                                            total.setText(total17 + "");
                                            order.updatePrice(total17, orderId);
                                            tableBill.updateUI();
                                        }
                                        if (order.deleteOrderid(orderId, serName)) {
                                            service.updateQuantitybyOrderid(serName);
                                        }

                                    }
                                }

                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    orderId++;
                }
                JOptionPane.showMessageDialog(this, "Lưu thành công ! ");
            }

        } else if (numberDesk.equals("")) {

            JOptionPane.showMessageDialog(this, "Chưa có dự liệu để lưu !");
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnPrintfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintfActionPerformed

    }//GEN-LAST:event_btnPrintfActionPerformed

    private void btnTotalPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTotalPriceActionPerformed

        String deskNumber = jTableNumber.getText();
        String sellerDate = txtDate.getText();
        String sellerName = txtHello.getText();
        int totalPrice = Integer.parseInt((String) total.getText());
        Price pr = new Price();
        pr.setDeskNumber(deskNumber);
        pr.setSellerDate(sellerDate);
        pr.setSellerName(sellerName);
        pr.setTotalPrice(totalPrice);
        

        frmPrintBill frmbill = new frmPrintBill(this, pr);
        frmbill.setVisible(true);


    }//GEN-LAST:event_btnTotalPriceActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        String numberDesk = jTableNumber.getText();
        if (numberDesk.equals("")) {
            JOptionPane.showMessageDialog(this, "Chưa có bàn để xóa ?");
        } else {
            int i = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xóa dữ liệu của bàn : " + numberDesk);
            switch (i) {
                case 0: // yes
                    if (numberDesk.equals("A01")) {
                        banA01.removeAll(banA01);
                        tableBill.setModel(new DefaultTableModel(banA01, head));
                        btnA01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/notselect.jpg")));
                        total.setText("");

                    } else if (numberDesk.equals("A02")) {
                        banA02.removeAll(banA02);
                        tableBill.setModel(new DefaultTableModel(banA02, head));
                        btnA02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/notselect.jpg")));
                        total.setText("");
                    } else if (numberDesk.equals("A03")) {
                        banA03.removeAll(banA03);
                        tableBill.setModel(new DefaultTableModel(banA03, head));
                        btnA03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/notselect.jpg")));
                        total.setText("");
                    } else if (numberDesk.equals("A04")) {
                        banA04.removeAll(banA04);
                        tableBill.setModel(new DefaultTableModel(banA04, head));
                        btnA04.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/notselect.jpg")));
                        total.setText("");
                    } else if (numberDesk.equals("A05")) {
                        banA05.removeAll(banA05);
                        tableBill.setModel(new DefaultTableModel(banA05, head));
                        btnA05.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/notselect.jpg")));
                        total.setText("");
                    } else if (numberDesk.equals("A06")) {
                        banA06.removeAll(banA06);
                        tableBill.setModel(new DefaultTableModel(banA06, head));
                        btnA06.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/notselect.jpg")));
                        total.setText("");
                    } else if (numberDesk.equals("A07")) {
                        banA07.removeAll(banA07);
                        tableBill.setModel(new DefaultTableModel(banA07, head));
                        btnA07.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/notselect.jpg")));
                        total.setText("");
                    } else if (numberDesk.equals("A08")) {
                        banA08.removeAll(banA08);
                        tableBill.setModel(new DefaultTableModel(banA08, head));
                        btnA08.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/notselect.jpg")));
                        total.setText("");
                    } else if (numberDesk.equals("A09")) {
                        banA09.removeAll(banA09);
                        tableBill.setModel(new DefaultTableModel(banA09, head));
                        btnA09.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/notselect.jpg")));
                        total.setText("");
                    } else if (numberDesk.equals("B01")) {
                        banB01.removeAll(banB01);
                        tableBill.setModel(new DefaultTableModel(banB01, head));
                        btnB01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/notselect.jpg")));
                        total.setText("");
                    } else if (numberDesk.equals("B02")) {
                        banB02.removeAll(banB02);
                        tableBill.setModel(new DefaultTableModel(banB02, head));
                        btnB02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/notselect.jpg")));
                        total.setText("");
                    } else if (numberDesk.equals("B03")) {
                        banB03.removeAll(banB03);
                        tableBill.setModel(new DefaultTableModel(banB03, head));
                        btnB03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/notselect.jpg")));
                        total.setText("");
                    } else if (numberDesk.equals("B04")) {
                        banB04.removeAll(banB04);
                        tableBill.setModel(new DefaultTableModel(banB04, head));
                        btnB04.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/notselect.jpg")));
                        total.setText("");
                    } else if (numberDesk.equals("B05")) {
                        banB05.removeAll(banB05);
                        tableBill.setModel(new DefaultTableModel(banB05, head));
                        btnB05.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/notselect.jpg")));
                        total.setText("");
                    } else if (numberDesk.equals("B06")) {
                        banB06.removeAll(banB06);
                        tableBill.setModel(new DefaultTableModel(banB06, head));
                        btnB06.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/notselect.jpg")));
                        total.setText("");
                    } else if (numberDesk.equals("B07")) {
                        banB07.removeAll(banB07);
                        tableBill.setModel(new DefaultTableModel(banB07, head));
                        btnB07.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/notselect.jpg")));
                        total.setText("");
                    } else if (numberDesk.equals("B08")) {
                        banB08.removeAll(banB08);
                        tableBill.setModel(new DefaultTableModel(banB08, head));
                        btnB08.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/notselect.jpg")));
                        total.setText("");
                    }
                case 1: // no 

            }
        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUtilitiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUtilitiesActionPerformed
        JOptionPane.showMessageDialog(this, "Chọn Ok để mở tiện ích bảng tính");
        frmCalculates cal = new frmCalculates();
        cal.setVisible(true);
    }//GEN-LAST:event_btnUtilitiesActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        JOptionPane.showMessageDialog(this, "Chức năng này sẽ được phát triển trong tương lai");
    }//GEN-LAST:event_btnSearchActionPerformed

    private void tableBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableBillMouseClicked

    }//GEN-LAST:event_tableBillMouseClicked

    private void btnCupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCupActionPerformed
        JOptionPane.showMessageDialog(this, "Chức năng này sẽ được phát triển trong tương lai");
    }//GEN-LAST:event_btnCupActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnA01;
    private javax.swing.JButton btnA02;
    private javax.swing.JButton btnA03;
    private javax.swing.JButton btnA04;
    private javax.swing.JButton btnA05;
    private javax.swing.JButton btnA06;
    private javax.swing.JButton btnA07;
    private javax.swing.JButton btnA08;
    private javax.swing.JButton btnA09;
    private javax.swing.JButton btnAdd1;
    private javax.swing.JButton btnAdd2;
    private javax.swing.JButton btnAdd3;
    private javax.swing.JButton btnAdd4;
    private javax.swing.JButton btnAdd5;
    private javax.swing.JButton btnAdd6;
    private javax.swing.JButton btnAdd7;
    private javax.swing.JButton btnAddNew;
    private javax.swing.JButton btnB01;
    private javax.swing.JButton btnB02;
    private javax.swing.JButton btnB03;
    private javax.swing.JButton btnB04;
    private javax.swing.JButton btnB05;
    private javax.swing.JButton btnB06;
    private javax.swing.JButton btnB07;
    private javax.swing.JButton btnB08;
    private javax.swing.JButton btnCup;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDeletes;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnExitSystem;
    private javax.swing.JButton btnExitSystem1;
    private javax.swing.JButton btnGross;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnManagaEmployee;
    private javax.swing.JButton btnManageStore;
    private javax.swing.JButton btnManagerAccount;
    private javax.swing.JButton btnManagerSell;
    private javax.swing.JButton btnPrintf;
    private javax.swing.JButton btnRepassword;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnTotalPrice;
    private javax.swing.JButton btnUtilities;
    private javax.swing.JComboBox<String> cbbLanguage;
    private javax.swing.JComboBox<String> cbbSelect1;
    private javax.swing.JComboBox<String> cbbSelect2;
    private javax.swing.JComboBox<String> cbbSelect3;
    private javax.swing.JComboBox<String> cbbSelect4;
    private javax.swing.JComboBox<String> cbbSelect5;
    private javax.swing.JComboBox<String> cbbSelect6;
    private javax.swing.JComboBox<String> cbbSelect7;
    private javax.swing.JComboBox<String> cbbTotal1;
    private javax.swing.JComboBox<String> cbbTotal2;
    private javax.swing.JComboBox<String> cbbTotal3;
    private javax.swing.JComboBox<String> cbbTotal4;
    private javax.swing.JComboBox<String> cbbTotal5;
    private javax.swing.JComboBox<String> cbbTotal6;
    private javax.swing.JComboBox<String> cbbTotal7;
    private javax.swing.JButton jButton11;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLable3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JLabel jTableNumber;
    private javax.swing.JPanel pannelB;
    private javax.swing.JPanel pannelChonDv;
    private javax.swing.JPanel pannelDv;
    private javax.swing.JPanel pannelHoadon;
    private javax.swing.JPanel pannelHomes;
    private javax.swing.JPanel pannelKhuA;
    private javax.swing.JPanel pannelKhuB;
    private javax.swing.JPanel pannelLogo;
    private javax.swing.JPanel pannelLogoItem;
    private javax.swing.JPanel pannelMain;
    private javax.swing.JPanel pannelPrimary;
    private javax.swing.JPanel pannelSelect;
    private javax.swing.JPanel pannelSelectDv;
    private javax.swing.JPanel pannelShow;
    private javax.swing.JPanel pannelTT;
    private javax.swing.JPanel pannelTable;
    private javax.swing.JPanel pannelTool;
    private javax.swing.JPanel pannelTools;
    private javax.swing.JPanel pannelUser;
    private javax.swing.JLabel price;
    private javax.swing.JLabel roles;
    private javax.swing.JTable tableBill;
    private javax.swing.JLabel total;
    private javax.swing.JLabel txtDate;
    private javax.swing.JLabel txtHello;
    private javax.swing.JLabel txtSua;
    private javax.swing.JTabbedPane txtTrangchu;
    // End of variables declaration//GEN-END:variables
   private javax.swing.JButton btnA10;
    Vector data;
    Vector head;
    Vector delete;
    Vector deletes;
    Vector banA01;
    Vector banA02;
    Vector banA03;
    Vector banA04;
    Vector banA05;
    Vector banA06;
    Vector banA07;
    Vector banA08;
    Vector banA09;
    Vector banB01;
    Vector banB02;
    Vector banB03;
    Vector banB04;
    Vector banB05;
    Vector banB06;
    Vector banB07;
    Vector banB08;
}
