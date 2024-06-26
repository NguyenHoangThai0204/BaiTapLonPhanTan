
package gui;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.RootPaneContainer;

import dao.NhanVienDao;
import impl.NhanVienImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;


/**
 *
 * @author Asus
 */
public class FRMQuanLi extends javax.swing.JFrame{

    private FRMQuanLiDatPhong datPhong;
    private FRMNhanVien nhanVien;
    private FRMKhachHang khachHang;
    private FRMDangNhap dangNhap;
    private FRMQuanLiThongKe thongKe;
    private FRMQuanLiMatHang matHang;
    private FRMQuanLiPhong phong;
    private FRMThanhToan frmThanhToan;
    /**
     * Creates new form FRMQuanLiNhanVien
     * @throws RemoteException
     */

    public FRMQuanLi(String maTK) throws RemoteException {
        this.maTK = maTK;
        initComponents();
        this.setResizable(false);
        jButtonDatPhong.setForeground(Color.magenta);
        jButtonDatPhong.setBackground(new Color(255, 0, 255));
        FRMQuanLiDatPhong datPhong = new FRMQuanLiDatPhong(maTK);
        setTitle("Quản lí đặt phòng");
        jLayeredPane1.add(datPhong.getFRMDDP());
        setLocationRelativeTo(null);
    }
    public static NhanVienDao nhanVienDao;

    static {
        try {
            nhanVienDao = new NhanVienImpl();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     * @throws RemoteException
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() throws RemoteException {
        EntityManager entityManager = Persistence.createEntityManagerFactory("maria").createEntityManager();
        NhanVienDao daoNhanVien;

        jPanel2 = new javax.swing.JPanel();
        jButtonThanhToan = new javax.swing.JButton();
        jButtonKhachHang = new javax.swing.JButton();
        jButtonNhanVien = new javax.swing.JButton();
        jButtonMatHang = new javax.swing.JButton();
        jButtonThongKe = new javax.swing.JButton();
        jButtonPhong = new javax.swing.JButton();
        jButtonDatPhong = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButtonDangXuat = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTenNV = new javax.swing.JTextField();
        txtMaNV = new javax.swing.JTextField();
        jLayeredPane1 = new javax.swing.JLayeredPane();


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButtonThanhToan.setText("Quản lí thanh toán ");
        jButtonThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButtonThanhToanActionPerformed(evt);
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        jButtonThanhToan.setContentAreaFilled(false);
        jButtonKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButtonKhachHang.setText("Quản lí khách hàng");
        jButtonKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButtonKhachHangActionPerformed(evt);
                } catch (RemoteException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        jButtonKhachHang.setContentAreaFilled(false);
        jButtonNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButtonNhanVien.setText("Quản lí nhân viên");
        jButtonNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNhanVienActionPerformed(evt);
            }
        });
        jButtonNhanVien.setContentAreaFilled(false);
        jButtonMatHang.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButtonMatHang.setText("Quản lí mặt hàng");
        jButtonMatHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButtonMatHangActionPerformed(evt);
                } catch (RemoteException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        jButtonMatHang.setContentAreaFilled(false);
        jButtonThongKe.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButtonThongKe.setText("Quản lí thống kê");
        jButtonThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonThongKeActionPerformed(evt);
            }
        });
        jButtonThongKe.setContentAreaFilled(false);
        jButtonPhong.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButtonPhong.setText("Quản lí phòng");
        jButtonPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButtonPhongActionPerformed(evt);
                } catch (RemoteException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        jButtonPhong.setContentAreaFilled(false);
        jButtonDatPhong.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButtonDatPhong.setText("Quản lí đặt phòng");
        jButtonDatPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDatPhongActionPerformed(evt);
            }
        });
        jButtonDatPhong.setContentAreaFilled(false);
        jPanel1.setBackground(new java.awt.Color(152, 69, 173));

        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\PhanTan2324\\BaiTapLon\\BaiTapLonPhanTan\\iCon\\logo.png")); // NOI18N
        jLabel1.setText("jLabel1");

        jButtonDangXuat.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jButtonDangXuat.setForeground(new java.awt.Color(255, 0, 51));
        jButtonDangXuat.setText("ĐĂNG XUẤT");
        jButtonDangXuat.setPreferredSize(new java.awt.Dimension(112, 50));
        jButtonDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDangXuatActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ngày hiện tại :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tên:   ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Mã NV");



        now = LocalDate.now();
        ngay = now.getDayOfMonth();
        thang = now.getMonthValue()-1;
        nam = now.getYear()-1900;

        dNow = new Date(nam,thang,ngay);

        jTextFieldNgayHienTai = new JDateChooser();
        jTextFieldNgayHienTai.setDateFormatString("dd/MM/yyyy");

        jTextFieldNgayHienTai.setFont(new Font("SansSerif", Font.PLAIN, 15));
        jTextFieldNgayHienTai.getCalendarButton().setPreferredSize(new Dimension(30, 24));
        jTextFieldNgayHienTai.getCalendarButton().setBackground(new Color(102, 0, 153));

        jTextFieldNgayHienTai.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jTextFieldNgayHienTai.setBounds(130, 15, 180, 38);
        jTextFieldNgayHienTai.setDate(dNow);

        txtTenNV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTenNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        txtMaNV.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(75, 75, 75)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldNgayHienTai, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(154, 154, 154)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(16, 16, 16)
                                                .addComponent(jButtonDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                                        .addComponent(txtTenNV))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jTextFieldNgayHienTai)
                                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(12, Short.MAX_VALUE))
        );

        jLayeredPane1.setPreferredSize(new java.awt.Dimension(1202, 422));

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
                jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
                jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 422, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jButtonDatPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                                .addComponent(jButtonThanhToan)
                                                .addGap(30, 30, 30)
                                                .addComponent(jButtonKhachHang)
                                                .addGap(30, 30, 30)
                                                .addComponent(jButtonPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(30, 30, 30)
                                                .addComponent(jButtonNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(30, 30, 30)
                                                .addComponent(jButtonMatHang, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(30, 30, 30)
                                                .addComponent(jButtonThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButtonDatPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonMatHang, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        txtTenNV.setText(nhanVienDao.getNVTheoTK(maTK).getTenNhanVien());
        txtMaNV.setText(nhanVienDao.getNVTheoTK(maTK).getMaNhanVien());
        txtTenNV.setEnabled(false);
        txtMaNV.setEnabled(false);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDangXuatActionPerformed
        dangNhap = new FRMDangNhap();
        dangNhap.setVisible(true);
        this.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_jButtonDangXuatActionPerformed

    public void xoaMauButton(){
        jButtonDatPhong.setForeground(null);
        jButtonKhachHang.setForeground(null);
        jButtonNhanVien.setForeground(null);
        jButtonThongKe.setForeground(null);
        jButtonMatHang.setForeground(null);
        jButtonPhong.setForeground(null);
        jButtonThanhToan.setForeground(null);
    }
    private void jButtonDatPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDatPhongActionPerformed
        // TODO add your handling code here:
        xoaMauButton();
        jLayeredPane1.removeAll();
        jButtonDatPhong.setBackground(new Color(255, 0, 255));
        FRMQuanLiDatPhong datPhong = new FRMQuanLiDatPhong(this.maTK);
        setTitle("Quản lí đặt phòng");
        jButtonDatPhong.setForeground(Color.magenta);
        jLayeredPane1.add(datPhong.getFRMDDP());
    }//GEN-LAST:event_jButtonDatPhongActionPerformed

    private void jButtonThanhToanActionPerformed(java.awt.event.ActionEvent evt) throws RemoteException {//GEN-FIRST:event_jButtonThanhToanActionPerformed
        // TODO add your handling code here:
        xoaMauButton();
        jLayeredPane1.removeAll();
        System.out.println("maTK: "+this.maTK);
        jButtonThanhToan.setBackground(new Color(255,0,255
        ));
        setTitle("Quản lí thanh toán");
        FRMThanhToan thanhToan = new FRMThanhToan(this.maTK);
        jButtonThanhToan.setForeground(Color.magenta);
        jLayeredPane1.add(thanhToan.getFRMThanhToan());
    }//GEN-LAST:event_jButtonThanhToanActionPerformed

    private void jButtonNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNhanVienActionPerformed
        // TODO add your handling code here:
        xoaMauButton();
        jLayeredPane1.removeAll();
        jButtonNhanVien.setBackground(new Color(255,0,255));
        setTitle("Quản lí nhân viên");
        jButtonNhanVien.setForeground(Color.magenta);
        nhanVien = new FRMNhanVien();
        jLayeredPane1.add(nhanVien.getNhanVien());
    }//GEN-LAST:event_jButtonNhanVienActionPerformed

    private void jButtonKhachHangActionPerformed(java.awt.event.ActionEvent evt) throws RemoteException {//GEN-FIRST:event_jButtonKhachHangActionPerformed
        // TODO add your handling code here:
        xoaMauButton();
        jLayeredPane1.removeAll();
        jButtonKhachHang.setBackground(new Color(255, 0, 255));
        setTitle("Quản lí khách hàng");
        khachHang = new FRMKhachHang();
        jButtonKhachHang.setForeground(Color.magenta);
        jLayeredPane1.add(khachHang.getFRMKhachHang());
    }//GEN-LAST:event_jButtonKhachHangActionPerformed

    private void jButtonThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThongKeActionPerformed
        // TODO add your handling code here:
        xoaMauButton();
        jLayeredPane1.removeAll();
        jButtonThongKe.setBackground(new Color(255, 0, 255));
        setTitle("Quản lí thống kê");
        thongKe = new FRMQuanLiThongKe();
        jButtonThongKe.setForeground(Color.magenta);
        jLayeredPane1.add(thongKe.getFRMThongKe());
    }//GEN-LAST:event_jButtonThongKeActionPerformed

    private void jButtonMatHangActionPerformed(java.awt.event.ActionEvent evt) throws RemoteException {//GEN-FIRST:event_jButtonMatHangActionPerformed
        // TODO add your handling code here:
        xoaMauButton();
        jLayeredPane1.removeAll();
        jButtonMatHang.setBackground(new Color(255, 0, 255));
        setTitle("Quản lí mặt hàng");
        matHang = new FRMQuanLiMatHang();
        jButtonMatHang.setForeground(Color.magenta);
        jLayeredPane1.add(matHang.getFRMMatHang());
    }//GEN-LAST:event_jButtonMatHangActionPerformed

    private void jButtonPhongActionPerformed(java.awt.event.ActionEvent evt) throws RemoteException {//GEN-FIRST:event_jButtonPhongActionPerformed
        // TODO add your handling code here:
        xoaMauButton();
        jLayeredPane1.removeAll();
        jButtonPhong.setBackground(new Color(255, 0, 255));
        setTitle("Quản lí phòng");
        phong = new FRMQuanLiPhong();
        jButtonPhong.setForeground(Color.magenta);
        jLayeredPane1.add(phong.getFRMQuanLiPhong());
    }//GEN-LAST:event_jButtonPhongActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

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
            java.util.logging.Logger.getLogger(FRMQuanLi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRMQuanLi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRMQuanLi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRMQuanLi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

//                new FRMQuanLi().setVisible(true);
                try {
                    new FRMQuanLi(maTK).setVisible(true);
                } catch (RemoteException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });


    }
    public JPanel getJPanle1() {
        return jPanel1;
    }
    public JPanel getJPanle2() {
        return jPanel2;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDangXuat;
    private javax.swing.JButton jButtonDatPhong;
    private javax.swing.JButton jButtonKhachHang;
    private javax.swing.JButton jButtonMatHang;
    private javax.swing.JButton jButtonNhanVien;
    private javax.swing.JButton jButtonPhong;
    private javax.swing.JButton jButtonThanhToan;
    private javax.swing.JButton jButtonThongKe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtTenNV;
    private javax.swing.JTextField txtMaNV;
    private LocalDate now;
    private int ngay;
    private int thang;
    private int nam;

    private Date dNow;
    private JDateChooser jTextFieldNgayHienTai;
    private static String maTK;
    // End of variables declaration//GEN-END:variables


}
