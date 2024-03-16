/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import DLL.DLL_Login;
import DLL.DLL_Shift;
import Entity.Login;
import Entity.Service;
import Entity.Shift;
import Entity.Shiftname;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Win 8 32bit VS7
 */
public class frmEmployee extends javax.swing.JPanel {

    /**
     * Creates new form frmEmployee
     */
    DLL_Login login = new DLL_Login();
    DLL_Shift shift = new DLL_Shift();
    ArrayList<Login> listEmp = new ArrayList<>();
    ArrayList<Login> listEmps = new ArrayList<>();
    ArrayList<Login> listCode = new ArrayList<>();
    ArrayList<Login> listPhone = new ArrayList<>();
    ArrayList<Login> listFullname = new ArrayList<>();
    ArrayList<Shift> listShiftname = new ArrayList<>();
    ArrayList<Shiftname> listShift = new ArrayList<>();

    public frmEmployee() {
        initComponents();
        this.setSize(900, 800);
        showEmp();
        showCbbshiftname();
        btnDelete.setEnabled(false);
    }

    public void showEmp() {
        listEmp = login.showEmp();
        Vector clums = new Vector();
        clums.add("Mã nhân viên");
        clums.add("Họ tên");
        clums.add("Địa chỉ");
        clums.add("Phone");
        clums.add("Email");
        clums.add("Quyền hạn");

        Vector data = new Vector();
        for (Login lg : listEmp) {
            Vector row = new Vector();
            row.add(lg.getCode());
            row.add(lg.getFullname());
            row.add(lg.getAddresss());
            row.add(lg.getPhone());
            row.add(lg.getEmail());
            row.add(lg.getRoles());
            data.add(row);
        }
        tblEmp.setModel(new DefaultTableModel(data, clums));
        tblEmp2.setModel(new DefaultTableModel(data, clums));
    }

    public void showCbbshiftname() {
        listShiftname = shift.showShiftname();
        for (Shift sf : listShiftname) {
            cbbShiftname.addItem(sf.getShiftname());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel9 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtFullname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtAdderss = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        txtRepass = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        cbbRoles = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEmp2 = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        btnAddnew = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmp = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSearchfullname = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtSearchcode = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtSearchphone = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        btnSearch1 = new javax.swing.JButton();
        btnSearch2 = new javax.swing.JButton();
        btnSearch3 = new javax.swing.JButton();
        btnSearch4 = new javax.swing.JButton();
        cbbShiftname = new javax.swing.JComboBox<>();
        btnRemove = new javax.swing.JButton();

        jPanel9.setLayout(new java.awt.GridLayout(1, 0));

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin cá nhân", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jPanel8.setOpaque(false);
        jPanel8.setLayout(new java.awt.GridLayout(5, 2));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Mã nhân viên:");
        jPanel8.add(jLabel13);
        jPanel8.add(txtCode);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Họ và tên:");
        jPanel8.add(jLabel4);
        jPanel8.add(txtFullname);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Địa chỉ:");
        jPanel8.add(jLabel5);
        jPanel8.add(txtAdderss);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Số điện thoại:");
        jPanel8.add(jLabel6);
        jPanel8.add(txtPhone);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Email:");
        jPanel8.add(jLabel11);
        jPanel8.add(txtEmail);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin đăng nhập", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jPanel5.setOpaque(false);
        jPanel5.setLayout(new java.awt.GridLayout(4, 2));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Tên đăng nhập:");
        jPanel5.add(jLabel8);
        jPanel5.add(txtUsername);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Mật khẩu:");
        jPanel5.add(jLabel9);
        jPanel5.add(txtPassword);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Nhập lại mật khẩu:");
        jPanel5.add(jLabel10);
        jPanel5.add(txtRepass);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Quyền hạn:");
        jPanel5.add(jLabel7);

        cbbRoles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Employee" }));
        jPanel5.add(cbbRoles);

        jPanel6.setLayout(new java.awt.GridLayout(1, 0));

        tblEmp2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmp2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblEmp2);

        jPanel6.add(jScrollPane2);

        jPanel10.setLayout(new java.awt.GridLayout(1, 0));

        btnAddnew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add-icon.png"))); // NOI18N
        btnAddnew.setText("  Thêm");
        btnAddnew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddnewActionPerformed(evt);
            }
        });
        jPanel10.add(btnAddnew);

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon-delete.png"))); // NOI18N
        btnDelete.setText("  Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel10.add(btnDelete);

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pen-icon.png"))); // NOI18N
        btnEdit.setText("  Sửa");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel10.add(btnEdit);

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/exit-iocn.png"))); // NOI18N
        btnCancel.setText("  Hủy");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel10.add(btnCancel);

        jPanel1.setBackground(new java.awt.Color(51, 51, 0));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon-emp.jpg"))); // NOI18N
        jPanel1.add(jLabel12, new java.awt.GridBagConstraints());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("  Thêm mới", new javax.swing.ImageIcon(getClass().getResource("/Images/iconadd.png")), jPanel2); // NOI18N

        jPanel7.setLayout(new java.awt.GridLayout(1, 0));

        tblEmp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmp);

        jPanel7.add(jScrollPane1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Tìm theo tên nhân viên:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Tìm theo mã nhân viên:");

        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Thông tin nhân viên");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Tìm theo số điện thoại:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Tìm theo ca làm việc:");

        btnSearch1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/iconseacrh1.png"))); // NOI18N
        btnSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearch1ActionPerformed(evt);
            }
        });

        btnSearch2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/iconseacrh1.png"))); // NOI18N
        btnSearch2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearch2ActionPerformed(evt);
            }
        });

        btnSearch3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/iconseacrh1.png"))); // NOI18N
        btnSearch3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearch3ActionPerformed(evt);
            }
        });

        btnSearch4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/iconseacrh1.png"))); // NOI18N
        btnSearch4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearch4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtSearchcode, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearch3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtSearchphone, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearch4, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSearchfullname, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbShiftname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))))
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSearchcode, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSearchfullname, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSearchphone, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbbShiftname, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnSearch4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jTabbedPane1.addTab("  Tìm kiếm", new javax.swing.ImageIcon(getClass().getResource("/Images/iconseacrh.png")), jPanel3); // NOI18N

        jPanel9.add(jTabbedPane1);

        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cancel-icon.png"))); // NOI18N
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnRemove)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(btnRemove)
                .addGap(0, 0, 0)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        frmManagement.as.cancelEmp();
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        txtCode.setText("");
        txtAdderss.setText("");
        txtEmail.setText("");
        txtFullname.setText("");
        txtPassword.setText("");
        txtPhone.setText("");
        txtUsername.setText("");
        txtRepass.setText("");
        txtUsername.setEnabled(true);
        txtPassword.setEnabled(true);
        txtRepass.setEnabled(true);
        btnDelete.setEnabled(false);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnAddnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddnewActionPerformed

        String code = txtCode.getText();
        String fullName = txtFullname.getText();
        String address = txtAdderss.getText();
        String phone = txtPhone.getText();
        String email = txtEmail.getText();
        String userName = txtUsername.getText();
        String passWord = txtPassword.getText();
        String rePass = txtRepass.getText();
        String roles = (String) cbbRoles.getSelectedItem();

        boolean checkAll = true;
        if (code.equals("")) {
            checkAll = false;
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập mã nhân viên!");
        } else if (fullName.equals("")) {
            checkAll = false;
            JOptionPane.showMessageDialog(this, "Họ tên không được để trống!");
        } else if (address.equals("")) {
            checkAll = false;
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập địa chỉ!");
        } else if (!phone.matches("0\\d\\d\\d\\d\\d\\d\\d\\d\\d") && !phone.matches("0\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d")) {
            checkAll = false;
            JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ!");
        } else if (!email.matches("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
            checkAll = false;
            JOptionPane.showMessageDialog(this, "Email bạn vừa nhập không hợp lệ!");
        } else if (userName.equals("")) {
            checkAll = false;
            JOptionPane.showMessageDialog(this, "Tên đăng nhập từ 3~14 kí tự!");
        } else if (passWord.equals("")) {
            checkAll = false;
            JOptionPane.showMessageDialog(this, "Mật khẩu không được để trống!");
        } else if (!rePass.equals(passWord)) {
            checkAll = false;
            JOptionPane.showMessageDialog(this, "Nhập lại mật khẩu không chính xác!");
        }
        if (checkAll) {
            if (login.getCode(code)) {
                int i = JOptionPane.showConfirmDialog(this, "Đã có mã nhân viên : " + code + ", bạn có muốn ghi đè ?");
                switch (i) {
                    case 0: // yes
                        login.editEmp(code, fullName, address, phone, email, roles, code);
                        showEmp();

                    case 1: // no 
                        txtCode.setText("");
                        txtFullname.setText("");
                        txtAdderss.setText("");
                        txtPhone.setText("");
                        txtEmail.setText("");
                        txtUsername.setText("");
                        txtPassword.setText("");
                        txtRepass.setText("");

                }
            } else if (login.insertEmp(code, fullName, address, phone, email, userName, passWord, roles)) {
                JOptionPane.showMessageDialog(this, "Thêm thành công " + fullName);
                showEmp();
            } else {
                JOptionPane.showMessageDialog(this, "Lỗi kết nối , vui lòng thử lại !");
            }
        }
    }//GEN-LAST:event_btnAddnewActionPerformed

    private void tblEmp2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmp2MouseClicked
        int row = tblEmp2.getSelectedRow();
        try {
            String code = (String) tblEmp2.getValueAt(row, 0);
            String fullName = (String) tblEmp2.getValueAt(row, 1);
            String address = (String) tblEmp2.getValueAt(row, 2);
            String phone = (String) tblEmp2.getValueAt(row, 3);
            String email = (String) tblEmp2.getValueAt(row, 4);
            String roles = (String) tblEmp2.getValueAt(row, 5);

            txtCode.setText(code);
            txtFullname.setText(fullName);
            txtAdderss.setText(address);
            txtPhone.setText(phone);
            txtEmail.setText(email);
            cbbRoles.setSelectedItem(roles);
            txtUsername.setEnabled(false);
            txtPassword.setEnabled(false);
            txtRepass.setEnabled(false);
            btnDelete.setEnabled(true);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_tblEmp2MouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        String code = txtCode.getText();
        String fullName = txtFullname.getText();
        int i = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắc xóa nhân viên: " + fullName);
        switch (i) {
            case 0: // yes
                if (shift.delelteShift(code)) {
                    if (login.deleteLogin(code)) {
                        JOptionPane.showMessageDialog(this, " Đã xóa " + fullName + "thành công!");
                        showEmp();
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "Lỗi kết nối , vui lòng thử lại!");
                }

            case 1: // no 
                txtCode.setText("");
                txtFullname.setText("");
                txtAdderss.setText("");
                txtPhone.setText("");
                txtEmail.setText("");
                txtUsername.setText("");
                txtPassword.setText("");
                txtRepass.setText("");

        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        String code = txtCode.getText();
        String fullName = txtFullname.getText();
        String address = txtAdderss.getText();
        String phone = txtPhone.getText();
        String email = txtEmail.getText();
        String roles = (String) cbbRoles.getSelectedItem();
        if(fullName.equals("")){
            JOptionPane.showMessageDialog(this, " Chưa có thông tin để chỉnh sửa !");
        }else{
            int i = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắc chỉnh sửa thông tin của " + fullName);
        switch (i) {
            case 0: // yes
                if (login.editEmp(code, fullName, address, phone, email, roles, code)) {
                    JOptionPane.showMessageDialog(this, "Đã chỉnh sửa thành công cho " + fullName);

                } else {
                    JOptionPane.showMessageDialog(this, "Lỗi kết nối , vui lòng thử lại!");
                }
                showEmp();

            case 1: // no 
                txtCode.setText("");
                txtFullname.setText("");
                txtAdderss.setText("");
                txtPhone.setText("");
                txtEmail.setText("");
                txtUsername.setText("");
                txtPassword.setText("");
                txtRepass.setText("");

        }
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch1ActionPerformed
        String fullname = txtSearchfullname.getText();
        boolean check = true;
        if (fullname.equals("")) {
            check = false;
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập họ tên ?");
        }
        if (check) {
            listFullname = login.showFullname(fullname);
            Vector clums = new Vector();
            clums.add("Mã nhân viên");
            clums.add("Họ tên");
            clums.add("Địa chỉ");
            clums.add("Phone");
            clums.add("Email");
            clums.add("Quyền hạn");
            Vector data = new Vector();
            for (Login lg : listFullname) {
                Vector row = new Vector();
                row.add(lg.getCode());
                row.add(lg.getFullname());
                row.add(lg.getAddresss());
                row.add(lg.getPhone());
                row.add(lg.getEmail());
                row.add(lg.getRoles());
                data.add(row);
            }
            tblEmp.setModel(new DefaultTableModel(data, clums));
        }
    }//GEN-LAST:event_btnSearch1ActionPerformed

    private void btnSearch2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch2ActionPerformed
        String shift = (String) cbbShiftname.getSelectedItem();
        listShift = login.showShifts(shift);
        Vector clums = new Vector();
        clums.add("Mã nhân viên");
        clums.add("Họ tên");
        clums.add("Địa chỉ");
        clums.add("Phone");
        clums.add("Email");
        clums.add("Quyền hạn");
        clums.add("Ca làm việc");
        Vector data = new Vector();
        for (Shiftname sfn : listShift) {
            Vector row = new Vector();
            row.add(sfn.getCode());
            row.add(sfn.getFullname());
            row.add(sfn.getAddress());
            row.add(sfn.getPhone());
            row.add(sfn.getEmail());
            row.add(sfn.getRoles());
            row.add(sfn.getShiftname());

            data.add(row);
        }
        tblEmp.setModel(new DefaultTableModel(data, clums));
    }//GEN-LAST:event_btnSearch2ActionPerformed

    private void btnSearch3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch3ActionPerformed
        String code = txtSearchcode.getText();
        boolean check = true;
        if (code.equals("")) {
            check = false;
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập mã nhân viên?");
        }
        if (check) {
            listCode = login.showCode(code);
            Vector clums = new Vector();
            clums.add("Mã nhân viên");
            clums.add("Họ tên");
            clums.add("Địa chỉ");
            clums.add("Phone");
            clums.add("Email");
            clums.add("Quyền hạn");

            Vector data = new Vector();
            for (Login lg : listCode) {
                Vector row = new Vector();
                row.add(lg.getCode());
                row.add(lg.getFullname());
                row.add(lg.getAddresss());
                row.add(lg.getPhone());
                row.add(lg.getEmail());
                row.add(lg.getRoles());
                data.add(row);

                tblEmp.setModel(new DefaultTableModel(data, clums));
            }
        }
    }//GEN-LAST:event_btnSearch3ActionPerformed

    private void btnSearch4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch4ActionPerformed
        String phone = txtSearchphone.getText();
        boolean check = true;
        if (phone.equals("")) {
            check = false;
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập số điện thoại ?");
        }
        if (check) {
            listPhone = login.showPhone(phone);
            Vector clums = new Vector();
            clums.add("Mã nhân viên");
            clums.add("Họ tên");
            clums.add("Địa chỉ");
            clums.add("Phone");
            clums.add("Email");
            clums.add("Quyền hạn");

            Vector data = new Vector();
            for (Login lg : listPhone) {
                Vector row = new Vector();
                row.add(lg.getCode());
                row.add(lg.getFullname());
                row.add(lg.getAddresss());
                row.add(lg.getPhone());
                row.add(lg.getEmail());
                row.add(lg.getRoles());
                data.add(row);
            }
            tblEmp.setModel(new DefaultTableModel(data, clums));
        }
    }//GEN-LAST:event_btnSearch4ActionPerformed

    private void tblEmpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpMouseClicked
        int row = tblEmp.getSelectedRow();
        try {
            String code = (String) tblEmp.getValueAt(row, 0);
            String fullName = (String) tblEmp.getValueAt(row, 1);
            String phone = (String) tblEmp.getValueAt(row, 3);

            txtSearchcode.setText(code);
            txtSearchfullname.setText(fullName);
            txtSearchphone.setText(phone);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_tblEmpMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddnew;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSearch1;
    private javax.swing.JButton btnSearch2;
    private javax.swing.JButton btnSearch3;
    private javax.swing.JButton btnSearch4;
    private javax.swing.JComboBox<String> cbbRoles;
    private javax.swing.JComboBox<String> cbbShiftname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblEmp;
    private javax.swing.JTable tblEmp2;
    private javax.swing.JTextField txtAdderss;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFullname;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JPasswordField txtRepass;
    private javax.swing.JTextField txtSearchcode;
    private javax.swing.JTextField txtSearchfullname;
    private javax.swing.JTextField txtSearchphone;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}