/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import DLL.DLL_Login;
import DLL.DLL_Services;
import Entity.Login;
import Entity.Service;
import java.util.ArrayList;
import java.util.Vector;
import javax.rmi.CORBA.Util;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Win 8 32bit VS7
 */
public class frmStore extends javax.swing.JPanel {

    /**
     * Creates new form frmStore
     */
    DLL_Services service = new DLL_Services();
    ArrayList<Service> listService = new ArrayList<>();
    ArrayList<Service> listSecode = new ArrayList<>();
    ArrayList<Service> listPrice = new ArrayList<>();
    ArrayList<Service> listClassify = new ArrayList<>();
    ArrayList<Service> listUnit = new ArrayList<>();
    ArrayList<Service> listSername = new ArrayList<>();
    ArrayList<Service> listCbbunit = new ArrayList<>();
    ArrayList<Service> listClassifys = new ArrayList<>();
    
    public frmStore() {
        initComponents();
        showService();
        showCbbunit();
        btnDelete.setEnabled(false);
        showClasssify();
        showClasssify1();
    }
    
    public void showService() {
        listService = service.showService();
        Vector clums = new Vector();
        clums.add("Mã dịch vụ");
        clums.add("Tên dịch vụ");
        clums.add("Đơn vị tính");
        clums.add("Giá tiền");
        clums.add("Số lượng");
        clums.add("Phân loại");
        
        Vector data = new Vector();
        for (Service sr : listService) {
            Vector row = new Vector();
            row.add(sr.getSercode());
            row.add(sr.getSername());
            row.add(sr.getUnit());
            row.add(sr.getPrice());
            row.add(sr.getQuantity());
            row.add(sr.getClassify());
            data.add(row);
        }
        tblServices.setModel(new DefaultTableModel(data, clums));
        tblServicess.setModel(new DefaultTableModel(data, clums));
    }
    
    public void showCbbunit() {
        listCbbunit = service.showCbbunit();
        for (Service sr : listCbbunit) {
            cbbUnit.addItem(sr.getUnit());
        }
    }
    
    public void showClasssify() {
        listClassifys = service.showClassify();
        for (Service sr : listClassifys) {
            cbbClassifys.addItem(sr.getClassify());
        }
    }
    
    public void showClasssify1() {
        listClassifys = service.showClassify();
        for (Service sr : listClassifys) {
            cbbClasssify.addItem(sr.getClassify());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenegrated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnRemove = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblServicess = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSearchsername = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtSeachsercode = new javax.swing.JTextField();
        btnSearch1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnSearch2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtSearchprice = new javax.swing.JTextField();
        btnSearch3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        btnSearch4 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtEntertext5 = new javax.swing.JTextField();
        btnSearch5 = new javax.swing.JButton();
        cbbClassifys = new javax.swing.JComboBox<>();
        cbbUnit = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblServices = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        btnAddnew = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtSercode = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtSername = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtUnit = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        cbbClasssify = new javax.swing.JComboBox<>();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cancel-icon.png"))); // NOI18N
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jPanel7.setLayout(new java.awt.GridLayout(1, 0));

        tblServicess.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblServicessMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblServicess);

        jPanel7.add(jScrollPane1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Tìm theo tên dịch vụ:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Tìm theo mã dịch vụ:");

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/iconseacrh1.png"))); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Thông tin sản phẩm");

        btnSearch1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/iconseacrh1.png"))); // NOI18N
        btnSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearch1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Tìm theo loại:");

        btnSearch2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/iconseacrh1.png"))); // NOI18N
        btnSearch2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearch2ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Tìm theo giá tiền:");

        btnSearch3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/iconseacrh1.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Tìm theo đơn vị tính:");

        btnSearch4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/iconseacrh1.png"))); // NOI18N
        btnSearch4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearch4ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Khác:");

        btnSearch5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/iconseacrh1.png"))); // NOI18N
        btnSearch5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearch5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 873, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(cbbUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEntertext5, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(cbbClassifys, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSearchprice, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(txtSeachsercode, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSearchsername, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSearchsername, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSeachsercode, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbbClassifys, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSearchprice, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnSearch5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtEntertext5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnSearch4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearch3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jTabbedPane1.addTab("  Tìm kiếm", new javax.swing.ImageIcon(getClass().getResource("/Images/iconseacrh.png")), jPanel3); // NOI18N

        jPanel6.setLayout(new java.awt.GridLayout(1, 0));

        tblServices.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblServicesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblServices);

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

        jPanel5.setLayout(new java.awt.GridBagLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon-store.jpg"))); // NOI18N
        jPanel5.add(jLabel4, new java.awt.GridBagConstraints());

        jPanel8.setLayout(new java.awt.GridLayout(6, 2));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Mã dịch vụ:");
        jPanel8.add(jLabel5);
        jPanel8.add(txtSercode);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Tên dịch vụ:");
        jPanel8.add(jLabel12);
        jPanel8.add(txtSername);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Đơn vị tính:");
        jPanel8.add(jLabel13);
        jPanel8.add(txtUnit);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Giá tiền:");
        jPanel8.add(jLabel11);
        jPanel8.add(txtPrice);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Số lượng:");
        jPanel8.add(jLabel15);
        jPanel8.add(txtQuantity);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Loại dịch vụ:");
        jPanel8.add(jLabel14);

        cbbClasssify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbClasssifyActionPerformed(evt);
            }
        });
        jPanel8.add(cbbClasssify);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("  Thêm mới", new javax.swing.ImageIcon(getClass().getResource("/Images/iconadd.png")), jPanel2); // NOI18N

        jPanel1.add(jTabbedPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnRemove)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnRemove)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        frmManagement.as.cancelEmp();
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        txtSercode.setText("");
        txtSername.setText("");
        txtPrice.setText("");
        txtQuantity.setText("");
        txtUnit.setText("");
        

    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        String Sercode = txtSercode.getText();
        String Sername = txtSername.getText();
        String Unit = txtUnit.getText();
        String Price = txtPrice.getText();
        String Quantity = txtQuantity.getText();
        String Classify = (String) cbbClasssify.getSelectedItem();
        boolean check = true;
        if (Sercode.equals("")) {
            check = false;
            JOptionPane.showMessageDialog(this, "Chưa có dữ liệu để chỉnh sửa");
        }
        if (check) {
            int i = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắc chỉnh sửa thông tin sản phẩm  của  mã " + Sercode);
            switch (i) {
                case 0: // yes
                    if (service.editService(Sercode, Sername, Unit, Price, Quantity, Classify, Sercode)) {
                        JOptionPane.showMessageDialog(this, "Thành công !");
                        showService();
                        showClasssify();
                        showClasssify1();
                    } else {
                        JOptionPane.showMessageDialog(this, "Lỗi kết nối , vui lòng thử lại !");
                    }
                case 1: // no 
                    txtSercode.setText("");
                    txtSername.setText("");
                    txtUnit.setText("");
                    txtPrice.setText("");
                    txtQuantity.setText("");
                
            }
        }
        

    }//GEN-LAST:event_btnEditActionPerformed

    private void btnAddnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddnewActionPerformed
        String serCode = txtSercode.getText();
        String serName = txtSername.getText();
        String unit = txtUnit.getText();
        String price = txtPrice.getText();
        String quantity = txtQuantity.getText();
        String classify = (String) cbbClasssify.getSelectedItem();
        boolean check = true;
        if (serCode.equals("")) {
            check = false;
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập mã dịch vụ");
        } else if (serName.equals("")) {
            check = false;
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập tên dịch vụ");
        } else if (unit.equals("")) {
            check = false;
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập đơn vị tính của dịch vụ" + serName);
        } else if (price.equals("")) {
            check = false;
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập giá tiền");
        } else if (quantity.equals("")) {
            check = false;
            JOptionPane.showMessageDialog(this, "Số lượng chưa đúng định dạng");
        }
        if (check) {
            if (service.getSercode(serCode)) {
                int i = JOptionPane.showConfirmDialog(this, "Đã có mã dich vụ " + serCode + ",bạn có muốn ghi đè ?");
                switch (i) {
                    case 0:
                        if (service.editService(serCode, serName, unit, price, quantity, classify, serCode)) {
                            JOptionPane.showMessageDialog(this, "Ghi đè thành công !");
                            showService();
                        } else {
                            JOptionPane.showMessageDialog(this, "Lỗi kết nối , vui lòng thử lại !");
                            
                        }
                    case 1:
                       
                }
                
            } else if (service.insertService(serCode, serName, unit, price, quantity, classify)) {
                JOptionPane.showMessageDialog(this, "Thêm " + serName + " thành công !");
                txtSercode.setText("");
                txtSername.setText("");
                txtUnit.setText("");
                txtPrice.setText("");
                txtQuantity.setText("");
                showService();
                
            }
        }
    }//GEN-LAST:event_btnAddnewActionPerformed

    private void tblServicesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblServicesMouseClicked
        int row = tblServices.getSelectedRow();
        
        try {
            String sercode = (String) tblServicess.getValueAt(row, 0);
            String sername = (String) tblServicess.getValueAt(row, 1);
            String unit = (String) tblServicess.getValueAt(row, 2);
            int price = (Integer) tblServicess.getValueAt(row, 3);
            
            int quantity = (Integer) tblServices.getValueAt(row, 4);
            String classify = (String) tblServicess.getValueAt(row, 5);
            
            txtSercode.setText(sercode);
            txtSername.setText(sername);
            txtUnit.setText(unit);
            txtPrice.setText(price + "");
            txtQuantity.setText(quantity + "");
            cbbClasssify.setSelectedItem(classify);
            btnDelete.setEnabled(true);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_tblServicesMouseClicked

    private void cbbClasssifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbClasssifyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbClasssifyActionPerformed

    private void btnSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch1ActionPerformed
        String sercode = txtSeachsercode.getText();
        listSecode = service.showSercode(sercode);
        Vector clums = new Vector();
        clums.add("Mã dịch vụ");
        clums.add("Tên dịch vụ");
        clums.add("Đơn vị tính");
        clums.add("Giá tiền");
        clums.add("Số lượng");
        clums.add("Phân loại");
        
        Vector data = new Vector();
        for (Service sr : listSecode) {
            Vector row = new Vector();
            row.add(sr.getSercode());
            row.add(sr.getSername());
            row.add(sr.getUnit());
            row.add(sr.getPrice());
            row.add(sr.getQuantity());
            row.add(sr.getClassify());
            data.add(row);
        }
        tblServicess.setModel(new DefaultTableModel(data, clums));
    }//GEN-LAST:event_btnSearch1ActionPerformed

    private void btnSearch5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch5ActionPerformed
        String price = txtSearchprice.getText();
        listPrice = service.showPrice(price);
        Vector clums = new Vector();
        clums.add("Mã dịch vụ");
        clums.add("Tên dịch vụ");
        clums.add("Đơn vị tính");
        clums.add("Giá tiền");
        clums.add("Số lượng");
        clums.add("Phân loại");
        
        Vector data = new Vector();
        for (Service sr : listPrice) {
            Vector row = new Vector();
            row.add(sr.getSercode());
            row.add(sr.getSername());
            row.add(sr.getUnit());
            row.add(sr.getPrice());
            row.add(sr.getQuantity());
            row.add(sr.getClassify());
            data.add(row);
        }
        tblServicess.setModel(new DefaultTableModel(data, clums));
    }//GEN-LAST:event_btnSearch5ActionPerformed

    private void btnSearch2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch2ActionPerformed
        String classs = (String) cbbClassifys.getSelectedItem();
        listClassify = service.showClassify(classs);
        Vector clums = new Vector();
        clums.add("Mã dịch vụ");
        clums.add("Tên dịch vụ");
        clums.add("Đơn vị tính");
        clums.add("Giá tiền");
        clums.add("Số lượng");
        clums.add("Phân loại");
        
        Vector data = new Vector();
        for (Service sr : listClassify) {
            Vector row = new Vector();
            row.add(sr.getSercode());
            row.add(sr.getSername());
            row.add(sr.getUnit());
            row.add(sr.getPrice());
            row.add(sr.getQuantity());
            row.add(sr.getClassify());
            data.add(row);
        }
        tblServicess.setModel(new DefaultTableModel(data, clums));
        

    }//GEN-LAST:event_btnSearch2ActionPerformed

    private void btnSearch4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch4ActionPerformed
        String unit = (String) cbbUnit.getSelectedItem();
        listUnit = service.showUnit(unit);
        Vector clums = new Vector();
        clums.add("Mã dịch vụ");
        clums.add("Tên dịch vụ");
        clums.add("Đơn vị tính");
        clums.add("Giá tiền");
        clums.add("Số lượng");
        clums.add("Phân loại");
        
        Vector data = new Vector();
        for (Service sr : listUnit) {
            Vector row = new Vector();
            row.add(sr.getSercode());
            row.add(sr.getSername());
            row.add(sr.getUnit());
            row.add(sr.getPrice());
            row.add(sr.getQuantity());
            row.add(sr.getClassify());
            data.add(row);
        }
        tblServicess.setModel(new DefaultTableModel(data, clums));
    }//GEN-LAST:event_btnSearch4ActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String serName = txtSearchsername.getText();
        listSername = service.showSername(serName);
        Vector clums = new Vector();
        clums.add("Mã dịch vụ");
        clums.add("Tên dịch vụ");
        clums.add("Đơn vị tính");
        clums.add("Giá tiền");
        clums.add("Số lượng");
        clums.add("Phân loại");
        
        Vector data = new Vector();
        for (Service sr : listSername) {
            Vector row = new Vector();
            row.add(sr.getSercode());
            row.add(sr.getSername());
            row.add(sr.getUnit());
            row.add(sr.getPrice());
            row.add(sr.getQuantity());
            row.add(sr.getClassify());
            data.add(row);
        }
        tblServicess.setModel(new DefaultTableModel(data, clums));
    }//GEN-LAST:event_btnSearchActionPerformed

    private void tblServicessMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblServicessMouseClicked
        try {
            int row = tblServicess.getSelectedRow();
            String code = (String) tblServicess.getValueAt(row, 0);
            String serName = (String) tblServicess.getValueAt(row, 1);
            String unit = (String) tblServicess.getValueAt(row, 2);
            int price = (Integer) tblServicess.getValueAt(row, 3);
            String classify = (String) tblServicess.getValueAt(row, 5);
            txtSeachsercode.setText(code+"");
            txtSearchsername.setText(serName);
            cbbClassifys.setSelectedItem(classify);            
            txtSearchprice.setText(price+"");
            cbbUnit.setSelectedItem(unit);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tblServicessMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        String Sercode = txtSercode.getText();
        String Sername = txtSername.getText();
        boolean check = true;
        if (Sercode.equals("")) {
            check = false;
            JOptionPane.showMessageDialog(this, "Chưa có dữ liệu để xóa !");
        }
        if (check) {
            int i = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắc xóa  " + Sername);
            switch (i) {
                case 0: // yes
                    if (service.deleteServide(Sercode)) {
                        JOptionPane.showMessageDialog(this, "Đã xóa thành công !");
                        showService();
                    } else {
                        JOptionPane.showMessageDialog(this, "Lỗi kết nối vui lòng thử lại sau !");
                    }
                case 1: // no 
                    txtSercode.setText("");
                    txtSername.setText("");
                    txtUnit.setText("");
                    txtPrice.setText("");
                    txtQuantity.setText("");
                
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddnew;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSearch1;
    private javax.swing.JButton btnSearch2;
    private javax.swing.JButton btnSearch3;
    private javax.swing.JButton btnSearch4;
    private javax.swing.JButton btnSearch5;
    private javax.swing.JComboBox<String> cbbClassifys;
    private javax.swing.JComboBox<String> cbbClasssify;
    private javax.swing.JComboBox<String> cbbUnit;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblServices;
    private javax.swing.JTable tblServicess;
    private javax.swing.JTextField txtEntertext5;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtSeachsercode;
    private javax.swing.JTextField txtSearchprice;
    private javax.swing.JTextField txtSearchsername;
    private javax.swing.JTextField txtSercode;
    private javax.swing.JTextField txtSername;
    private javax.swing.JTextField txtUnit;
    // End of variables declaration//GEN-END:variables
}
