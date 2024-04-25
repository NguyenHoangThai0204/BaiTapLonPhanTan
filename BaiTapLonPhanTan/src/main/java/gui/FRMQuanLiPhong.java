package gui;

import dao.DAOSinhMaTuDong;
import dao.LoaiPhongDao;
import dao.PhongDao;
import dao.Regex;
import entity.LoaiPhong;
import entity.Phong;
import impl.LoaiPhongImpl;
import impl.PhongImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class FRMQuanLiPhong extends javax.swing.JFrame implements MouseListener, ActionListener {

    public FRMQuanLiPhong() throws RemoteException {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public JPanel getFRMQuanLiPhong() {
        return jPanel5;
    }

    public static PhongDao phongDao;
    public static LoaiPhongDao loaiPhongDao;

    public static DAOSinhMaTuDong daoMa;

    static {
        try {
            phongDao = new PhongImpl();
            loaiPhongDao = new LoaiPhongImpl();
            daoMa = new DAOSinhMaTuDong();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private void initComponents() throws RemoteException {
        // Code here
        PhongDao phongDao;
        LoaiPhongDao loaiPhongDao;
        regex = new Regex();
        daoMa = new DAOSinhMaTuDong();

        dfGiaP = new DecimalFormat("###,###");
        dftxtGiaP = new DecimalFormat("######");

        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jTextField1 = new JTextField("Nhập mã phòng");

        jpnSapXep1 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jbTimKH = new javax.swing.JButton();
        jbLocKH = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jcboChucVu = new javax.swing.JComboBox<>();
        txtMaPhong = new javax.swing.JTextField();
        txtGiaPhong = new javax.swing.JTextField();
        txtTinhTrang = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnThemNV = new javax.swing.JButton();
        btnSuaNV = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnXoaNV = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtSucChua = new javax.swing.JTextField();
        txtMoTa = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel5.setPreferredSize(new java.awt.Dimension(1202, 422));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Tìm kiếm");

        jpnSapXep1.setBackground(new java.awt.Color(255, 255, 255));
        jpnSapXep1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 255)));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel17.setText("Sắp Xếp");

        jRadioButton4.setBackground(new java.awt.Color(255, 153, 204));
        jRadioButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jRadioButton4.setText("Theo Mã");

        jRadioButton6.setBackground(new java.awt.Color(255, 153, 204));
        jRadioButton6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jRadioButton6.setText("Loại phòng");
        jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnSapXep1Layout = new javax.swing.GroupLayout(jpnSapXep1);
        jpnSapXep1.setLayout(jpnSapXep1Layout);
        jpnSapXep1Layout.setHorizontalGroup(
                jpnSapXep1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jpnSapXep1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(118, 118, 118)
                                .addComponent(jRadioButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(141, 141, 141)
                                .addComponent(jRadioButton6)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnSapXep1Layout.setVerticalGroup(
                jpnSapXep1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jpnSapXep1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jpnSapXep1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jRadioButton4)
                                        .addComponent(jRadioButton6)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        btnGr = new ButtonGroup();
        btnGr.add(jRadioButton4);
        btnGr.add(jRadioButton6);

//        jTable1.setModel(new javax.swing.table.DefaultTableModel(
//            new Object [][] {
//                {null, null, null, null, null, null, null, null},
//                {null, null, null, null, null, null, null, null},
//                {null, null, null, null, null, null, null, null},
//                {null, null, null, null, null, null, null, null},
//                {null, null, null, null, null, null, null, null},
//                {null, null, null, null, null, null, null, null},
//                {null, null, null, null, null, null, null, null},
//                {null, null, null, null, null, null, null, null},
//                {null, null, null, null, null, null, null, null},
//                {null, null, null, null, null, null, null, null},
//                {null, null, null, null, null, null, null, null},
//                {null, null, null, null, null, null, null, null},
//                {null, null, null, null, null, null, null, null},
//                {null, null, null, null, null, null, null, null},
//                {null, null, null, null, null, null, null, null},
//                {null, null, null, null, null, null, null, null},
//                {null, null, null, null, null, null, null, null},
//                {null, null, null, null, null, null, null, null}
//            },
//            new String [] {
//                "Mã NV", "Họ tên", "SĐT", "Địa chỉ", "CCCD", "Ngày sinh", "Giới tính", "Loại khách hàng"
//            }
//        ));
        String phong[] = {"Mã phòng", "Loại phòng", "Giá phòng", "Tình trạng phòng", "Sức Chứa", "Mô Tả"};
        modelPhong = new DefaultTableModel(phong, 0);
        jTable1 = new JTable(modelPhong);

        // đọc dữ liệu từ database lên table
        loadDanhSachPhong();

        jScrollPane1.setViewportView(jTable1);

        jbTimKH.setIcon(new javax.swing.ImageIcon("D:\\PhanTan2324\\BaiTapLon\\BaiTapLonPhanTan\\iCon\\search.png")); // NOI18N

        jbLocKH.setIcon(new javax.swing.ImageIcon("D:\\PhanTan2324\\BaiTapLon\\BaiTapLonPhanTan\\iCon\\sorting.png")); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jpnSapXep1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jbTimKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jbLocKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(0, 6, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 844, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jbTimKH, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jbLocKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jpnSapXep1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(12, 12, 12)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 255)));
        jPanel3.setPreferredSize(new java.awt.Dimension(329, 512));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Mã phòng:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Giá phòng:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Tình trạng:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Loại phòng");

        jcboChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Phòng thường", "Phòng trung", "Phòng Vip"}));

        txtMaPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaPhongActionPerformed(evt);
            }
        });

        txtGiaPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaPhongActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("THÔNG TIN PHÒNG");

        btnThemNV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnThemNV.setIcon(new javax.swing.ImageIcon("D:\\PhanTan2324\\BaiTapLon\\BaiTapLonPhanTan\\iCon\\add.png")); // NOI18N
        btnThemNV.setText("Thêm");

        btnSuaNV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnSuaNV.setIcon(new javax.swing.ImageIcon("D:\\PhanTan2324\\BaiTapLon\\BaiTapLonPhanTan\\iCon\\service.png")); // NOI18N
        btnSuaNV.setText("Sửa");

        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnLamMoi.setIcon(new javax.swing.ImageIcon("D:\\PhanTan2324\\BaiTapLon\\BaiTapLonPhanTan\\iCon\\refresh.png")); // NOI18N
        btnLamMoi.setText("Làm Mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        btnXoaNV.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnXoaNV.setIcon(new javax.swing.ImageIcon("D:\\PhanTan2324\\BaiTapLon\\BaiTapLonPhanTan\\iCon\\delete.png")); // NOI18N
        btnXoaNV.setText("Xóa");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Sức chứa:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Mô tả:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(txtTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                                                                .addComponent(jLabel10)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(jLabel6)
                                                                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                                                                                .addComponent(jLabel12)
                                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                .addComponent(jLabel16))
                                                                                                        .addComponent(jLabel7))
                                                                                                .addComponent(jLabel8))
                                                                                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING))
                                                                                .addGap(18, 18, 18)))
                                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(txtMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(txtGiaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jcboChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(txtMoTa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(txtSucChua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(btnThemNV, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(btnLamMoi))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(btnXoaNV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(btnSuaNV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)))))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(69, 69, 69)
                                                .addComponent(jLabel5)))
                                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jcboChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtGiaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(txtTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9)
                                        .addComponent(txtSucChua, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel10))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnSuaNV)
                                        .addComponent(btnThemNV))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnLamMoi)
                                        .addComponent(btnXoaNV))
                                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE))
                                .addContainerGap(9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 1218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );


        pack();
        // mã phòng phát sinh tự động nên k nhập
        txtMaPhong.setEnabled(false);
        txtTinhTrang.setEnabled(false);
        // add sự kiện
        jTable1.addMouseListener(this);
        btnXoaNV.addActionListener(this);
        btnLamMoi.addActionListener(this);
        btnThemNV.addActionListener(this);
        jRadioButton4.addActionListener(this);
        jRadioButton6.addActionListener(this);
        jbTimKH.addActionListener(this);
        btnSuaNV.addActionListener(this);
    }

    private void clearTable() {
        while (jTable1.getRowCount() > 0) {
            modelPhong.removeRow(0);
        }
    }

    private void reset() throws RemoteException {
        txtMaPhong.setText("");
        txtGiaPhong.setText("");
        txtMoTa.setText("");
        txtSucChua.setText("");
        txtTinhTrang.setText("Trống");
        jcboChucVu.setSelectedIndex(2);
        jTextField1.setText("");
        clearTable();
        loadDanhSachPhong();
    }

    public void loadDanhSachPhong() throws RemoteException {

        List<Phong> lsP = phongDao.getDanhSachPhong();
        for (Phong p : lsP) {
            LoaiPhong loaiP = loaiPhongDao.getLoaiPhongTheoMa(p.getLoaiPhong().getMaLoaiPhong());
            modelPhong.addRow(new Object[]{p.getMaPhong(), loaiP.getTenLoaiPhong(), dfGiaP.format(p.getGiaPhong()), p.getTinhTrangPhong(), p.getSucChua(), p.getMoTa()});
        }
    }

    private void loadDanhSachPhong(List<Phong> lstP) throws RemoteException {
        clearTable();
        for (Phong p : lstP) {
            LoaiPhong loaiP = loaiPhongDao.getLoaiPhongTheoMa(p.getLoaiPhong().getMaLoaiPhong());
            modelPhong.addRow(new Object[]{p.getMaPhong(), loaiP.getTenLoaiPhong(), dfGiaP.format(p.getGiaPhong()), p.getTinhTrangPhong(), p.getSucChua(), p.getMoTa()});
        }
    }


    // xoá phòng
    private void xoaPhong() throws RemoteException {
        int row = jTable1.getSelectedRow();
        if (row >= 0) {
            int choose = JOptionPane.showConfirmDialog(null, "Bạn muốn xoá phòng này?", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (choose == JOptionPane.YES_OPTION) {
                String maPhong = modelPhong.getValueAt(row, 0).toString();
                // xoá phòng khỏi bảng
                modelPhong.removeRow(row);
                // xoá phòng khỏi database
                try {
                    System.out.println("maPhoing"+maPhong);
                    phongDao.huyPhong(maPhong);
                    JOptionPane.showMessageDialog(null, "Đã xoá thành công", "Thông báo", JOptionPane.OK_OPTION);
                } catch (RemoteException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Xoá Không thành công", "Thông báo", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn phòng để xoá", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }


    // thêm phòng
    public void themPhong() throws RemoteException {
        if (regex.regexGiaP(txtGiaPhong)) {
            float giaP = Float.parseFloat(txtGiaPhong.getText());
            String maP = daoMa.getMaPhong();
            String tinhTrang = "Trống";

            LoaiPhong loaiP = new LoaiPhong(loaiPhongDao.getMaLoaiPhongTheoTen(jcboChucVu.getSelectedItem().toString()));
            int sucChua = Integer.parseInt(txtSucChua.getText());
            String moTa = txtMoTa.getText();
            Phong p = new Phong(maP, tinhTrang, giaP, loaiP, sucChua, moTa);
            System.out.println("phong"+p);
            phongDao.themPhong(p);
            clearTable();
            loadPhongDuocChon(p);
            JOptionPane.showMessageDialog(this, "Thêm phòng thành công");
        }
    }

    //Sap xep theo loai Phong tang dan
    public void sortLoaiPhong(Phong p) throws RemoteException {
        clearTable();
        List<Phong> lsThuong = phongDao.getPhongTheoLoai(loaiPhongDao.getMaLoaiPhongTheoTen("Phòng thường"));
        for (Phong lsp : lsThuong) {
            LoaiPhong loaiP = loaiPhongDao.getLoaiPhongTheoMa(lsp.getLoaiPhong().getMaLoaiPhong());
            modelPhong.addRow(new Object[]{lsp.getMaPhong(), loaiP.getTenLoaiPhong(), dfGiaP.format(lsp.getGiaPhong()), lsp.getTinhTrangPhong(), lsp.getSucChua(), lsp.getMoTa()});
        }

        List<Phong> lsTrung = phongDao.getPhongTheoLoai(loaiPhongDao.getMaLoaiPhongTheoTen("Phòng trung"));
        for (Phong lsp : lsTrung) {
            LoaiPhong loaiP = loaiPhongDao.getLoaiPhongTheoMa(lsp.getLoaiPhong().getMaLoaiPhong());
            modelPhong.addRow(new Object[]{lsp.getMaPhong(), loaiP.getTenLoaiPhong(), dfGiaP.format(lsp.getGiaPhong()), lsp.getTinhTrangPhong(), lsp.getSucChua(), lsp.getMoTa()});
        }


        List<Phong> lsVip = phongDao.getPhongTheoLoai(loaiPhongDao.getMaLoaiPhongTheoTen("Phòng VIP"));
        for (Phong lsp : lsVip) {
            LoaiPhong loaiP = loaiPhongDao.getLoaiPhongTheoMa(lsp.getLoaiPhong().getMaLoaiPhong());
            modelPhong.addRow(new Object[]{lsp.getMaPhong(), loaiP.getTenLoaiPhong(), dfGiaP.format(lsp.getGiaPhong()), lsp.getTinhTrangPhong(), lsp.getSucChua(), lsp.getMoTa()});
        }
    }

    public void loadPhongDuocChon(Phong p) throws RemoteException {
        LoaiPhong loaiP = loaiPhongDao.getLoaiPhongTheoMa(p.getLoaiPhong().getMaLoaiPhong());
        modelPhong.addRow(new Object[]{p.getMaPhong(), loaiP.getTenLoaiPhong(), dfGiaP.format(p.getGiaPhong()), p.getTinhTrangPhong(), p.getTinhTrangPhong(), p.getSucChua(), p.getMoTa()});
    }

    private void loadDanhSachPhongTheoLoai(List<Phong> p2) throws RemoteException {
        clearTable();
        String maLoai = loaiPhongDao.getMaLoaiPhongTheoTen(jTextField1.getText());

        List<Phong> lstName = phongDao.getPhongTheoLoai(maLoai);
        for (Phong p : lstName) {
            LoaiPhong loaiP = loaiPhongDao.getLoaiPhongTheoMa(p.getLoaiPhong().getMaLoaiPhong());
            modelPhong.addRow(new Object[]{p.getMaPhong(), loaiP.getTenLoaiPhong(), dfGiaP.format(p.getGiaPhong()), p.getTinhTrangPhong(), p.getSucChua(), p.getMoTa()});
        }
    }

    public void loadDanhSachPhongTheoMa(List<Phong> lstP) throws RemoteException {
        clearTable();
        List<Phong> lsP = phongDao.getPhongTheoMaP(jTextField1.getText());
        for (Phong p : lsP) {
            LoaiPhong loaiP = loaiPhongDao.getLoaiPhongTheoMa(p.getLoaiPhong().getMaLoaiPhong());
            modelPhong.addRow(new Object[]{p.getMaPhong(), loaiP.getTenLoaiPhong(), dfGiaP.format(p.getGiaPhong()), p.getTinhTrangPhong(), p.getSucChua(), p.getMoTa()});
        }
    }

    public void loadDanhSachPhongTheoTinhTrang(List<Phong> lstP) throws RemoteException {
        clearTable();
        List<Phong> lsP = phongDao.getPhongTheoTinhTrang(jTextField1.getText());
        for (Phong p : lsP) {
            LoaiPhong loaiP = loaiPhongDao.getLoaiPhongTheoMa(p.getLoaiPhong().getMaLoaiPhong());
            modelPhong.addRow(new Object[]{p.getMaPhong(), loaiP.getTenLoaiPhong(), dfGiaP.format(p.getGiaPhong()), p.getTinhTrangPhong(), p.getSucChua(), p.getMoTa()});
        }
    }

    //Tìm kiếm phòng
    private void findPhong() throws RemoteException {
        List<Phong> lstP = null;
        String regexMaPhong = "((P|p)[0-9]{3})";
        if (!jTextField1.getText().equals("") && !jTextField1.getText().equals("Tìm theo mã phòng, loại phòng, tình trạng phòng")) {
            if (regex.regexTimPhong(jTextField1)) {
                if (jTextField1.getText().trim().matches(regexMaPhong)) {
                    lstP = phongDao.getPhongTheoMaP(jTextField1.getText().trim());
                    loadDanhSachPhongTheoMa(lstP);
                }
                if (regex.regexTimKiemLoaiPhong(jTextField1)) {
                    lstP = phongDao.getPhongTheoLoai(loaiPhongDao.getMaLoaiPhongTheoTen(jTextField1.getText()).trim());
                    System.out.println("lstP" + lstP);
                    loadDanhSachPhongTheoLoai(lstP);
                }
                if (regex.regexTimKiemTinhTrang(jTextField1)) {
                    lstP = phongDao.getPhongTheoTinhTrang(jTextField1.getText());
                    loadDanhSachPhongTheoTinhTrang(lstP);
                }
                if (lstP.size() == 0) {
                    JOptionPane.showMessageDialog(this, "Không tìm thấy thông tin tìm kiếm phù hợp!");
                    loadDanhSachPhong(lstP);
                }
            }
        } else {
            clearTable();
            JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin tìm kiếm!", "Thông báo",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    //Sua thong tin phong
    public void suaThongTin() throws RemoteException {
        int row = jTable1.getSelectedRow();
        if (row >= 0) {
            int update = JOptionPane.showConfirmDialog(this, "Bạn muốn sửa thông tin phòng này không?", "Thông báo",
                    JOptionPane.YES_NO_OPTION);
            if (update == JOptionPane.YES_OPTION) {
                JTextField txtTam = new JTextField();
                String maP = modelPhong.getValueAt(row, 0).toString();
                double gia = Math.round(phongDao.getPhongTheoMa(maP).getGiaPhong());
                txtTam.setText(String.valueOf(Math.round(gia)));
                if (regex.regexGiaP(txtTam)) {
                    try {

                        LoaiPhong loaiP = new LoaiPhong(loaiPhongDao.getMaLoaiPhongTheoTen(jcboChucVu.getSelectedItem().toString()));
                        System.out.println("Loai P" + loaiP);
                        double giaP = Double.parseDouble(txtGiaPhong.getText().toString());
                        System.out.println("Gia P" + giaP);
                        String tinhTrang = txtTinhTrang.getText();
                        System.out.println("tTR"+ tinhTrang);
                        int sucChua = Integer.parseInt(txtSucChua.getText());
                        String moTa = txtMoTa.getText();
                        Phong p = new Phong(maP, tinhTrang, giaP, loaiP, sucChua, moTa);
                        System.out.println("Phong" + p);
                        clearTable();
                        phongDao.capNhatPhong(p);
                        loadPhongDuocChon(p);
                        JOptionPane.showMessageDialog(this, "Thông tin phòng đã được sửa!", "Thông báo",
                                JOptionPane.OK_OPTION);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Vui lòng kiểm tra lại giá phòng!!", "Thông báo",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn thông tin phòng sửa!", "Thông báo",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void txtGiaPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaPhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaPhongActionPerformed

    private void txtMaPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaPhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaPhongActionPerformed

    private void jRadioButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(FRMQuanLiPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRMQuanLiPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRMQuanLiPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRMQuanLiPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FRMQuanLiPhong().setVisible(true);
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSuaNV;
    private javax.swing.JButton btnThemNV;
    private javax.swing.JButton btnXoaNV;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton jbLocKH;
    private javax.swing.JButton jbTimKH;
    private javax.swing.JComboBox<String> jcboChucVu;
    private javax.swing.JPanel jpnSapXep1;
    private javax.swing.JTextField txtGiaPhong;
    private javax.swing.JTextField txtMaPhong;
    private javax.swing.JTextField txtMoTa;
    private javax.swing.JTextField txtSucChua;
    private javax.swing.JTextField txtTinhTrang;
    private DefaultTableModel modelPhong;
    private ButtonGroup btnGr;
    private Regex regex;
    //
    private DecimalFormat dfGiaP, dftxtGiaP;
    //
    private Phong p;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o.equals(btnXoaNV)) {
            try {
                xoaPhong();
            } catch (RemoteException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (o.equals(btnLamMoi)) {
            try {
                reset();
            } catch (RemoteException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (o.equals(btnThemNV)) {
            try {
                themPhong();
            } catch (RemoteException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (o.equals(jRadioButton4)) {
            clearTable();
            try {
                loadDanhSachPhong();
            } catch (RemoteException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (o.equals(jRadioButton6)) {
            try {
                sortLoaiPhong(p);
            } catch (RemoteException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (o.equals(jbTimKH)) {
            try {
                findPhong();
            } catch (RemoteException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (o.equals(btnSuaNV)) {
            try {
                suaThongTin();
            } catch (RemoteException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object o = e.getSource();
        if (o.equals(jTable1)) {
            int row = jTable1.getSelectedRow();
            txtMaPhong.setText(modelPhong.getValueAt(row, 0).toString());
            // loại phòng chưa load đc qua bảng
            jcboChucVu.setSelectedItem(modelPhong.getValueAt(row, 1).toString());
            txtGiaPhong.setText(modelPhong.getValueAt(row, 2).toString());
            txtTinhTrang.setText(modelPhong.getValueAt(row, 3).toString());
            txtSucChua.setText(modelPhong.getValueAt(row, 4).toString());
            txtMoTa.setText(modelPhong.getValueAt(row, 5).toString());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
