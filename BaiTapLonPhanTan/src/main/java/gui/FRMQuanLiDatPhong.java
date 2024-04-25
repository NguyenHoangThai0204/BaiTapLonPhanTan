package gui;

import com.toedter.calendar.JDateChooser;
import dao.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import entity.*;
import impl.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class FRMQuanLiDatPhong extends javax.swing.JFrame implements ActionListener, MouseListener, KeyListener {

	private static final long serialVersionUID = 7865810530834647930L;
	private JPanel JFrame;

	public FRMQuanLiDatPhong(String maTK) {
		this.maTK = maTK;
		try {
			initComponents();
		} catch (RemoteException e) {
			throw new RuntimeException(e);
		}
		setLocationRelativeTo(null);
	}

	public static PhongDao phongDao;
	public static LoaiPhongDao loaiPhongDao;
	public static KhachHangDao khachHangDao;
	public static DatPhongDao datPhongDao;
	public static LoaiKHDao loaiKHDao;
	public static NhanVienDao nhanVienDao;
	public static DAOSinhMaTuDong daoSinhMa;

	static {
		try {
			phongDao = new PhongImpl();
			loaiPhongDao = new LoaiPhongImpl();
			khachHangDao = new KhachHangImpl();
			datPhongDao = new DatPhongImpl();
			loaiKHDao = new LoaiKHDaoImpl();
			nhanVienDao = new NhanVienImpl();
			daoSinhMa = new DAOSinhMaTuDong();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}


	private void initComponents() throws RemoteException {

		/// new ĐƠN ĐẶT PHÒNG
		ddp = new DonDatPhong();
		this.maTK = maTK;
		// format ngay va gio\
		daoSinhMa = new DAOSinhMaTuDong();
		dfNgay = new SimpleDateFormat("dd/MM/yyyy");
		dfHienGio = new SimpleDateFormat("HH:mm");

		jPanel1 = new javax.swing.JPanel();
		jPanelThongTinDDP = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jComboBoxLoaiKH = new javax.swing.JComboBox<>();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		jComboBoxTrangThaiPhong = new javax.swing.JComboBox<>();
		txtSDTKH = new javax.swing.JTextField();
		txtTenNV = new javax.swing.JTextField();
		txtTenKH = new javax.swing.JTextField();
		jLabel11 = new javax.swing.JLabel();
		jComboBoxTrangThaiPhong1 = new javax.swing.JComboBox<>();
		btnPhong = new javax.swing.JButton();
		jLabel13 = new javax.swing.JLabel();
		txtPhong = new javax.swing.JTextField();
		txtNgayDen = new javax.swing.JTextField();
		jComboBoxGio = new javax.swing.JComboBox<>();
		jComboBoxPhut = new javax.swing.JComboBox<>();
		jPanel2 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jLabel12 = new javax.swing.JLabel();
		jLabel10 = new javax.swing.JLabel();
		jTextFieldTimDDP = new JTextField("Nhập mã đơn đặt phòng");
		jbTimDDP = new javax.swing.JButton();
		btnThemDDP = new javax.swing.JButton();
		btnSuaDDP = new javax.swing.JButton();
		btnXoaDDP = new javax.swing.JButton();
		btnLamMoiDDP = new javax.swing.JButton();
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Quản lí đặt phòng");

		jPanel1.setAutoscrolls(true);
		jPanel1.setPreferredSize(new java.awt.Dimension(1202, 422));

		jPanelThongTinDDP.setBackground(new java.awt.Color(255, 255, 255));
		jPanelThongTinDDP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 255)));

		jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
		jLabel1.setText("       Thông tin đơn đặt phòng");

		jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		jLabel2.setText("Loại khách hàng:");

		jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		jLabel3.setText("Tên khách hàng: ");

		jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		jLabel4.setText("SĐT:");

		jComboBoxLoaiKH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		jComboBoxLoaiKH.setPreferredSize(new Dimension(200, 30));

		jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		jLabel5.setText("Tên nhân viên:");

		jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		jLabel6.setText("Ngày đến: ");

		chooseNgayDen = new JDateChooser();
		chooseNgayDen.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		chooseNgayDen.setBounds(110, 213, 191, 25);
		chooseNgayDen.setDateFormatString("dd/MM/yyyy");
		chooseNgayDen.setDate(dNgayHienTai);
		chooseNgayDen.setBorder(new LineBorder(new Color(114, 23, 153), 1, true));
		chooseNgayDen.setFont(new Font("SansSerif", Font.PLAIN, 15));
		chooseNgayDen.getCalendarButton().setPreferredSize(new Dimension(30, 24));
		chooseNgayDen.getCalendarButton().setBackground(new Color(102, 0, 153));
		chooseNgayDen.getCalendarButton().setToolTipText("Chọn ngày sinh");

		jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		jLabel7.setText("Giờ đến:");

		jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		jLabel8.setText(":");

		jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		jLabel9.setText("Trạng thái DDP:");

		jComboBoxTrangThaiPhong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

		//jComboBoxTrangThaiPhong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Thường", "VIP"}));

		ArrayList<LoaiPhong> dsLoaiPhong = loaiPhongDao.getDanhSachLoaiPhong();
		for (LoaiPhong lp : dsLoaiPhong) {
			jComboBoxTrangThaiPhong.addItem(lp.getTenLoaiPhong());
		}


		txtTenKH.setToolTipText("loaiKH");

		jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		jLabel11.setText("Loại phòng:");

		jComboBoxTrangThaiPhong1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		jComboBoxTrangThaiPhong1
				.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Chờ xác nhận", "Đã xác nhận", "Đã trả phòng"}));

		btnPhong.setIcon(
				new javax.swing.ImageIcon("D:\\PhanTan2324\\BaiTapLon\\BaiTapLonPhanTan\\iCon\\search.png")); // NOI18N

		jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		jLabel13.setText("Phòng:");

		jComboBoxGio.setModel(new javax.swing.DefaultComboBoxModel<>(
				new String[]{"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14",
						"15", "16", "17", "18", "19", "20", "21", "22", "23"}));

		jComboBoxPhut.setModel(new javax.swing.DefaultComboBoxModel<>(
				new String[]{"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14",
						"15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
						"31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46",
						"47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));


		javax.swing.GroupLayout jPanelThongTinDDPLayout = new javax.swing.GroupLayout(jPanelThongTinDDP);
		jPanelThongTinDDP.setLayout(jPanelThongTinDDPLayout);
		jPanelThongTinDDPLayout.setHorizontalGroup(jPanelThongTinDDPLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(jPanelThongTinDDPLayout.createSequentialGroup().addContainerGap()
						.addGroup(jPanelThongTinDDPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										jPanelThongTinDDPLayout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
												.addComponent(jLabel2)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(jComboBoxLoaiKH, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(jPanelThongTinDDPLayout.createSequentialGroup()
										.addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 61,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(57, 57, 57).addComponent(txtPhong))
								.addGroup(jPanelThongTinDDPLayout.createSequentialGroup()
										.addGroup(jPanelThongTinDDPLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabel3)
												.addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 112,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(jPanelThongTinDDPLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(txtTenKH, javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(txtTenNV, javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(txtSDTKH)
												.addGroup(jPanelThongTinDDPLayout.createSequentialGroup()
														.addComponent(jComboBoxTrangThaiPhong1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(0, 0, Short.MAX_VALUE))))
								.addGroup(jPanelThongTinDDPLayout.createSequentialGroup()
										.addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 112,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(chooseNgayDen))
								.addGroup(jPanelThongTinDDPLayout.createSequentialGroup()
										.addGroup(jPanelThongTinDDPLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(jPanelThongTinDDPLayout.createSequentialGroup()
														.addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE,
																112, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(jComboBoxTrangThaiPhong,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(18, 18, 18).addComponent(btnPhong,
																javax.swing.GroupLayout.PREFERRED_SIZE, 49,
																javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(jPanelThongTinDDPLayout.createSequentialGroup()
														.addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE,
																63, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(57, 57, 57)
														.addComponent(jComboBoxGio,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE,
																7, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(jComboBoxPhut,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addGap(0, 0, Short.MAX_VALUE)))
						.addContainerGap()));
		jPanelThongTinDDPLayout.setVerticalGroup(jPanelThongTinDDPLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanelThongTinDDPLayout.createSequentialGroup().addContainerGap()
						.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanelThongTinDDPLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jComboBoxLoaiKH, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanelThongTinDDPLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(
								jPanelThongTinDDPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(txtSDTKH, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
												javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(
								jPanelThongTinDDPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
												javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanelThongTinDDPLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(jPanelThongTinDDPLayout.createSequentialGroup()
										.addGroup(jPanelThongTinDDPLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(chooseNgayDen, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(jPanelThongTinDDPLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel8)
												.addComponent(jComboBoxGio, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jComboBoxPhut, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(12, 12, 12)
										.addGroup(jPanelThongTinDDPLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel9).addComponent(jComboBoxTrangThaiPhong1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(12, 12, 12)
										.addGroup(jPanelThongTinDDPLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
												.addComponent(jComboBoxTrangThaiPhong).addComponent(jLabel11,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
								.addComponent(btnPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(
								jPanelThongTinDDPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(txtPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
												javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));


		jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
		jLabel12.setText("Thông tin đơn:");

		jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jLabel10.setText("Tìm kiếm:");

		jbTimDDP.setIcon(
				new javax.swing.ImageIcon("D:\\PhanTan2324\\BaiTapLon\\BaiTapLonPhanTan\\iCon\\search.png")); // NOI18N

		btnThemDDP.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		btnThemDDP.setIcon(
				new javax.swing.ImageIcon("D:\\PhanTan2324\\BaiTapLon\\BaiTapLonPhanTan\\iCon\\add.png")); // NOI18N
		btnThemDDP.setText("Thêm");
		btnThemDDP.setPreferredSize(new java.awt.Dimension(121, 39));

		btnSuaDDP.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		btnSuaDDP.setIcon(
				new javax.swing.ImageIcon("D:\\PhanTan2324\\BaiTapLon\\BaiTapLonPhanTan\\iCon\\service.png")); // NOI18N
		btnSuaDDP.setText("Sửa");
		btnSuaDDP.setPreferredSize(new java.awt.Dimension(121, 39));

		btnXoaDDP.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
		btnXoaDDP.setIcon(
				new javax.swing.ImageIcon("D:\\PhanTan2324\\BaiTapLon\\BaiTapLonPhanTan\\iCon\\sorting.png")); // NOI18N
		btnXoaDDP.setText("Lọc");
		btnXoaDDP.setPreferredSize(new java.awt.Dimension(121, 39));

		btnLamMoiDDP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		btnLamMoiDDP.setIcon(
				new javax.swing.ImageIcon("D:\\PhanTan2324\\BaiTapLon\\BaiTapLonPhanTan\\iCon\\refresh.png")); // NOI18N
		btnLamMoiDDP.setText("Làm Mới");

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addGap(42, 42, 42)
						.addComponent(btnThemDDP, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(119, 119, 119)
						.addComponent(btnSuaDDP, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnLamMoiDDP).addGap(112, 112, 112)
						.addComponent(btnXoaDDP, javax.swing.GroupLayout.PREFERRED_SIZE, 108,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(87, 87, 87))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel2Layout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 85,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addComponent(jTextFieldTimDDP, javax.swing.GroupLayout.PREFERRED_SIZE, 549,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(27, 27, 27)
								.addComponent(jbTimDDP, javax.swing.GroupLayout.PREFERRED_SIZE, 72,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(114, 114, 114))
				.addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel2Layout.createSequentialGroup().addGap(24, 24, 24).addComponent(jLabel12,
										javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(jScrollPane1,
										javax.swing.GroupLayout.PREFERRED_SIZE, 891, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(64, Short.MAX_VALUE)));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addGap(20, 20, 20)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jTextFieldTimDDP, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jbTimDDP, javax.swing.GroupLayout.PREFERRED_SIZE, 39,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btnThemDDP, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSuaDDP, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLamMoiDDP).addComponent(btnXoaDDP,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(46, 46, 46)));

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addComponent(jPanelThongTinDDP, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addComponent(jPanelThongTinDDP, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap())
				.addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING,
						javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1227,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addComponent(jPanel1,
										javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, Short.MAX_VALUE)));

		pack();
		jTextFieldTimDDP.setText("Nhập mã đơn đặt phòng");
		txtTenNV.setText(nhanVienDao.getNVTheoMa(maTK).getTenNhanVien());
		//
		chooseNgayDen.setDate(new java.util.Date());
//		txtTenKH.setEditable(false);
		txtTenNV.setEditable(false);
		txtPhong.setEditable(false);
		chooseNgayDen.getDateEditor().setEnabled(false);
		loadDS();
		// add event
		jTable1.addMouseListener(this);
		btnSuaDDP.addActionListener(this);
		btnLamMoiDDP.addActionListener(this);
		btnThemDDP.addActionListener(this);
		btnXoaDDP.addActionListener(this);
		btnPhong.addActionListener(this);
		jbTimDDP.addActionListener(this);
		jTextFieldTimDDP.addActionListener(this);
		jTextFieldTimDDP.addKeyListener(this);
		txtSDTKH.addKeyListener(this);

	}

	public JPanel getFRMDDP() {
		return jPanel1;
	}

	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(FRMQuanLiDatPhong.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(FRMQuanLiDatPhong.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(FRMQuanLiDatPhong.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(FRMQuanLiDatPhong.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new FRMQuanLiDatPhong(maTK).setVisible(true);
			}
		});

	}

	private void loadDanhSachDDP(DonDatPhong ddp) throws RemoteException {// không sử dụng
		// removeDanhSachDDP(modelDDP);
		List<DonDatPhong> lstDDP = datPhongDao.getAllDDP();
		//

		//
		for (DonDatPhong infoDDP : lstDDP) {
			KhachHang kh = khachHangDao.getKHTheoMa(infoDDP.getKhachHang().getMaKhangHang());
			NhanVien nv = nhanVienDao.getMaVaSdtNVChoDDP1(infoDDP.getNhanVien().getMaNhanVien());
			LoaiPhong loaiPhong = loaiPhongDao.getLoaiPhongTheoMa(infoDDP.getPhong().getLoaiPhong().getMaLoaiPhong());

			modelDDP.addRow(new Object[]{infoDDP.getMaDDP(), kh.getTenKH(), infoDDP.getPhong().getMaPhong(),
					loaiPhong.getTenLoaiPhong(), infoDDP.getKhachHang().getSdt(), dfHienGio.format(infoDDP.getGioDen()),
					dfNgay.format(infoDDP.getNgayDen()), nv.getTenNhanVien(), dfNgay.format(infoDDP.getNgayLap()),
					infoDDP.getTrangThaiDDP()});
		}

	}

	private void loadDS() throws RemoteException {
		// removeDanhSachDDP(modelDDP);
		modelDDP = new DefaultTableModel(colDDP, 0);
		jTable1.setModel(modelDDP);
		jTable1.setDefaultEditor(Object.class, null);
		jTable1.setToolTipText("");
		jScrollPane1.setViewportView(jTable1);
		if (jTable1.getColumnModel().getColumnCount() > 0) {
			jTable1.getColumnModel().getColumn(0).setResizable(false);
		}
		List<DonDatPhong> lstDDP = datPhongDao.getAllDDP();
		//

		//
		for (DonDatPhong infoDDP : lstDDP) {
			KhachHang kh = khachHangDao.getKHTheoMa(infoDDP.getKhachHang().getMaKhangHang());
			NhanVien nv = nhanVienDao.getMaVaSdtNVChoDDP1(infoDDP.getNhanVien().getMaNhanVien());
			LoaiPhong loaiPhong = loaiPhongDao.getLoaiPhongTheoMa(infoDDP.getPhong().getLoaiPhong().getMaLoaiPhong());

			modelDDP.addRow(new Object[]{infoDDP.getMaDDP(), kh.getTenKH(), infoDDP.getPhong().getMaPhong(),
					loaiPhong.getTenLoaiPhong(), infoDDP.getKhachHang().getSdt(), dfHienGio.format(infoDDP.getGioDen()),
					dfNgay.format(infoDDP.getNgayDen()), nv.getTenNhanVien(), dfNgay.format(infoDDP.getNgayLap()),
					infoDDP.getTrangThaiDDP()});
		}

	}

	private void loadDSPhong() throws RemoteException {
		// removeDanhSachDDP(modelDDP);
		modelPhong = new DefaultTableModel(colPhong, 0);
		jTable1.setModel(modelPhong);
		jTable1.setDefaultEditor(Object.class, null);
		jTable1.setToolTipText("");
		jScrollPane1.setViewportView(jTable1);
		if (jTable1.getColumnModel().getColumnCount() > 0) {
			jTable1.getColumnModel().getColumn(0).setResizable(false);
		}
		List<Phong> dsPhong;
		if (jComboBoxTrangThaiPhong.getSelectedItem().toString().matches("Phòng VIP")) {// load phong vip
			dsPhong = phongDao.getPhongVipTrong();

		} else if (jComboBoxTrangThaiPhong.getSelectedItem().toString().matches("Phòng trung")) {// load phong vip
			dsPhong = phongDao.getPhongTrungTrong();

		} else {// load phong thường
			dsPhong = phongDao.getPhongThuongTrong();
		}
		if (dsPhong != null) {
			for (Phong p : dsPhong)
				modelPhong.addRow(new Object[]{p.getMaPhong(), p.getLoaiPhong().getTenLoaiPhong(), p.getSucChua(),
						p.getGiaPhong(), p.getMoTa(), p.getTinhTrangPhong()});
		}

	}

	private void loadDSPhongTrong() throws RemoteException {
		// removeDanhSachDDP(modelDDP);
		modelPhong = new DefaultTableModel(colPhong, 0);
		jTable1.setModel(modelPhong);
		jTable1.setDefaultEditor(Object.class, null);
		jTable1.setToolTipText("");
		jScrollPane1.setViewportView(jTable1);
		if (jTable1.getColumnModel().getColumnCount() > 0) {
			jTable1.getColumnModel().getColumn(0).setResizable(false);
		}
		List<Phong> dsPhong = phongDao.getPhongThuongTrong();
		if (dsPhong != null) {
			for (Phong p : dsPhong)
				modelPhong.addRow(new Object[]{p.getMaPhong(), p.getLoaiPhong().getTenLoaiPhong(), p.getSucChua(),
						p.getGiaPhong(), p.getMoTa(), p.getTinhTrangPhong()});
		}
		dsPhong = phongDao.getPhongVipTrong();
		if (dsPhong != null) {
			for (Phong p : dsPhong)
				modelPhong.addRow(new Object[]{p.getMaPhong(), p.getLoaiPhong().getTenLoaiPhong(), p.getSucChua(),
						p.getGiaPhong(), p.getMoTa(), p.getTinhTrangPhong()});
		}

	}

	@SuppressWarnings("deprecation")
	private void lamMoi() {
		txtTenKH.setText("");
		txtTenNV.setText("");
		txtSDTKH.setText("");
		txtPhong.setText("");
		jTextFieldTimDDP.setText("Nhập mã đơn đặt phòng");
		chooseNgayDen.setDate(new java.util.Date());
		jComboBoxGio.setSelectedItem(new java.util.Date().getHours() + "");
		jComboBoxPhut.setSelectedItem(new java.util.Date().getMinutes() + "");
		jComboBoxLoaiKH.setSelectedItem(0);
		jComboBoxTrangThaiPhong1.setSelectedIndex(0);
		ddp = null;

	}


	@SuppressWarnings("deprecation")
	private void themDDP() throws RemoteException {
		if (regExThem()) {
			try {
				Object[] options = {"Có", "Không"};
				int n = JOptionPane.showOptionDialog(this, "Bạn có muốn thêm?", "Thêm mặt hàng",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, // do not use a custom Icon
						options, // the titles of buttons
						options[0]); // default button title
				if (n == JOptionPane.YES_OPTION) {
					String mDDP = daoSinhMa.getMaDDP();
					KhachHang kh = khachHangDao.getKHTheoSDT(txtSDTKH.getText());
					NhanVien nv = nhanVienDao.getNVTheoTK(maTK);
					Phong p = phongDao.getPhongTheoMa(txtPhong.getText());
					String ttDDP = jComboBoxTrangThaiPhong1.getSelectedItem().toString();
					java.util.Date date = chooseNgayDen.getDate();
//                    ddp1.setNgayDen(new Date(date.getYear(), date.getMonth(), date.getDate()));

					java.sql.Date ngayD = new java.sql.Date(date.getYear(), date.getMonth(), date.getDate());

					Time gioDen = new Time(dfHienGio.parse(jComboBoxGio.getSelectedItem().toString() + ":"
							+ jComboBoxPhut.getSelectedItem().toString()).getTime());
//                    ddp1.setGioDen(gioDen);

					Time gioD = new Time(dfHienGio.parse(jComboBoxGio.getSelectedItem().toString() + ":"
							+ jComboBoxPhut.getSelectedItem().toString()).getTime());

					java.util.Date date1 = new java.util.Date();
					java.sql.Date ngayL = new java.sql.Date(date1.getYear(), date1.getMonth(), date1.getDate());

					DonDatPhong ddp1 = new DonDatPhong(mDDP,ngayL,ttDDP, ngayD, gioD, kh, nv,p);

					if (datPhongDao.themDDP(ddp1)) {
//                         cap nhat trang thai phong khi them thanh cong
						if (jComboBoxTrangThaiPhong1.getSelectedItem().toString().matches("Đã xác nhận")) {
							phongDao.capNhatTrangThaiPhong(ddp1.getPhong().getMaPhong(), "Đang hoạt động");
						}
						JOptionPane.showMessageDialog(this, "Thêm thành công!");
					} else
						JOptionPane.showMessageDialog(this, " Thêm thất bại");

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


	private void suaDDP() {// update phòng,ngày giờ đến.
		if (regExSua()) {
			try {
				this.ddp.setPhong(phongDao.getPhongTheoMa(txtPhong.getText())); // update
				ddp.setTrangThaiDDP(jComboBoxTrangThaiPhong1.getSelectedItem().toString());// update

				java.util.Date date = chooseNgayDen.getDate();
				ddp.setNgayDen(new Date(date.getYear(), date.getMonth(), date.getDate()));// update

				Time gioDen = new Time(dfHienGio.parse(
								jComboBoxGio.getSelectedItem().toString() + ":" + jComboBoxPhut.getSelectedItem().toString())
						.getTime());
				ddp.setGioDen(gioDen);// update
				boolean update = datPhongDao.capNhatDDP(this.ddp, this.ddp.getMaDDP());
				if (update && jComboBoxTrangThaiPhong1.getSelectedItem().toString().matches("Đã xác nhận")) {
					phongDao.capNhatTrangThaiPhong(ddp.getPhong().getMaPhong(), "Đang hoạt động");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	private void timDDP() throws RemoteException {
		List<DonDatPhong> lstDDP = new ArrayList<DonDatPhong>();
		lstDDP = datPhongDao.getDDPTheoMaDDP(jTextFieldTimDDP.getText());
		modelDDP = new DefaultTableModel(colDDP, 0);
		jTable1.setModel(modelDDP);
		jTable1.setDefaultEditor(Object.class, null);
		jTable1.setToolTipText("");
		jScrollPane1.setViewportView(jTable1);
		if (jTable1.getColumnModel().getColumnCount() > 0) {
			jTable1.getColumnModel().getColumn(0).setResizable(false);
		}
		for (DonDatPhong infoDDP : lstDDP) {
			KhachHang kh = khachHangDao.getKHTheoMa(infoDDP.getKhachHang().getMaKhangHang());
			NhanVien nv = nhanVienDao.getMaVaSdtNVChoDDP1(infoDDP.getNhanVien().getMaNhanVien());
			LoaiPhong loaiPhong = loaiPhongDao.getLoaiPhongTheoMa(infoDDP.getPhong().getLoaiPhong().getMaLoaiPhong());

			modelDDP.addRow(new Object[]{infoDDP.getMaDDP(), kh.getTenKH(), infoDDP.getPhong().getMaPhong(),
					loaiPhong.getTenLoaiPhong(), infoDDP.getKhachHang().getSdt(), dfHienGio.format(infoDDP.getGioDen()),
					dfNgay.format(infoDDP.getNgayDen()), nv.getTenNhanVien(), dfNgay.format(infoDDP.getNgayLap()),
					infoDDP.getTrangThaiDDP()});
		}

	}

	private void updateTrangThaiPhongTheoDDP() throws RemoteException {
//        datPhongDao.capNhatTrangThaiPhongvaDDP();
	}


	private void getRowModelDDP() throws RemoteException {// chưa ổn sửa lại thuật toán
		int row = jTable1.getSelectedRow();
		/*
		 * Đổi địa chỉ thành tên nhân viên
		 */
		if (row > -1) {
			String maDDP = (String) jTable1.getValueAt(row, 0);
			List<DonDatPhong> lstDDP = datPhongDao.getAllDDP();
			for (DonDatPhong ddp : lstDDP) {
				if (maDDP.equals(ddp.getMaDDP())) {
					txtPhong.setText(ddp.getPhong().getMaPhong());
					txtSDTKH.setText(ddp.getKhachHang().getSdt());
					txtTenKH.setText(ddp.getKhachHang().getTenKH());
					txtTenNV.setText(ddp.getNhanVien().getTenNhanVien());
					jComboBoxLoaiKH.setSelectedItem(
							khachHangDao.getKHTheoSDT(ddp.getKhachHang().getSdt()).getLoaiKH().getTenLoaiKH());
					chooseNgayDen.setDate(ddp.getNgayDen());
					jComboBoxGio.setSelectedItem(ddp.getGioDen().getHours() + "");
					jComboBoxPhut.setSelectedItem(ddp.getGioDen().getMinutes() + "");
					jComboBoxTrangThaiPhong1.setSelectedItem(ddp.getTrangThaiDDP().toString());
					this.ddp = ddp;
					break;
				}
			}
		}

	}

	@SuppressWarnings({"deprecation", "unused"})
	private boolean regExSua() {
		// Ràng buộc chỉ được phép sửa trạng thái đơn đặt phòng chờ xác nhận thành đã
		// xác nhận
		String ddpSelect = ddp.getTrangThaiDDP();
		String jcbTrangThai = jComboBoxTrangThaiPhong1.getSelectedItem().toString();
		if (ddpSelect.equals("Đã xác nhận") || ddpSelect.equals("Huỷ")) {
			JOptionPane.showMessageDialog(this, "Không thể cập nhập đơn đặt phòng 'Đã xác nhận' hoặc 'Huỷ'");
			return false;
		}
		// Ràng buộc nhập ngày đến lớn hơn ngày hiện tại
		java.util.Date ngayGioDen = new java.util.Date(chooseNgayDen.getDate().getYear(),
				chooseNgayDen.getDate().getMonth(), chooseNgayDen.getDate().getDate(),
				Integer.parseInt(jComboBoxGio.getSelectedItem().toString()),
				Integer.parseInt(jComboBoxPhut.getSelectedItem().toString()));
		java.util.Date ngayGioHienTai = new java.util.Date();
		if (ngayGioDen.getTime() + 60000 < ngayGioHienTai.getTime()) {
			JOptionPane.showMessageDialog(this, "Ngày giờ không hợp lệ!");
			return false;
		}
		return true;
	}

	private void getRowModelPhong() {
		int row = jTable1.getSelectedRow();
		/*
		 * Đổi địa chỉ thành tên nhân viên
		 */
		if (row > -1) {
			txtPhong.setText(jTable1.getValueAt(row, 0).toString().trim());
		}
	}

	@SuppressWarnings({"deprecation", "unused"})
	private boolean regExThem() throws RemoteException {
		// Kiểm tra tên khách hàng
//		String tenkh = "^[A-Za-z][A-Za-z\\s]+";
		String tenkh = "[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s]+";
		if (!txtTenKH.getText().matches(tenkh)) {
			JOptionPane.showMessageDialog(this, "Tên khách hàng không hợp lệ\nChỉ chứa chữ cái và khoảng trắng!");
			return false;
		}
		// Kiểm tra số điện thoại nhập đúng 10 chữ số
		String sdt = "[0-9]{10}";
		if (!txtSDTKH.getText().matches(sdt)) {
			JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ\nNhập đúng 10 chữ số!");
			return false;
		}
		// Ràng buộc nhập ngày đến lớn hơn ngày hiện tại
		java.util.Date ngayGioDen = new java.util.Date(chooseNgayDen.getDate().getYear(),
				chooseNgayDen.getDate().getMonth(), chooseNgayDen.getDate().getDate(),
				Integer.parseInt(jComboBoxGio.getSelectedItem().toString()),
				Integer.parseInt(jComboBoxPhut.getSelectedItem().toString()));
		java.util.Date ngayGioHienTai = new java.util.Date();
		if (ngayGioDen.getTime() + 60000 < ngayGioHienTai.getTime()) {
			JOptionPane.showMessageDialog(this, "Ngày giờ không hợp lệ!");
			return false;
		}
		if (txtPhong.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn phòng!");
			return false;
		}
		String str = phongDao.getPhongTheoMa(txtPhong.getText()).getTinhTrangPhong();
		if (str.equals("Đang hoạt động") || str.equals("Đặt trước")) {
			JOptionPane.showMessageDialog(this, "Phòng hiện tại không trống!");
			return false;
		}
		return true;
	}


	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnLamMoiDDP;
	private javax.swing.JButton btnSuaDDP;
	private javax.swing.JButton btnThemDDP;
	private javax.swing.JButton btnXoaDDP;
	private javax.swing.JComboBox<String> jComboBoxGio;
	private javax.swing.JComboBox<String> jComboBoxLoaiKH;
	private javax.swing.JComboBox<String> jComboBoxPhut;
	private javax.swing.JComboBox<String> jComboBoxTrangThaiPhong;
	private javax.swing.JComboBox<String> jComboBoxTrangThaiPhong1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanelThongTinDDP;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;
	private javax.swing.JTextField jTextFieldTimDDP;
	private javax.swing.JButton jbTimDDP;
	private javax.swing.JButton btnPhong;
	private javax.swing.JTextField txtTenNV;
	private javax.swing.JTextField txtNgayDen;
	private JDateChooser chooseNgayDen;
	private javax.swing.JTextField txtPhong;
	private javax.swing.JTextField txtSDTKH;
	private javax.swing.JTextField txtTenKH;
	private SimpleDateFormat dfNgay, dfHienGio;
	private DefaultTableModel modelDDP;
	private DefaultTableModel modelPhong;
	@SuppressWarnings("unused")
	private Date dNgayHienTai;
	// KHAI BAO DAO
//    private DAOSinhMaTuDong daoSinhMa;
	private NhanVien nhanvien;
	// private LoaiPhong loaiPhong;
	private DonDatPhong ddp;
	private static String maTK;
	private String colDDP[] = {"Mã DDP", "Tên khách hàng", "Mã phòng", "Loại phòng", "SĐT", "Giờ đến", "Ngày đến",
			"Tên nhân viên", "Ngày lập", "Trạng thái"};
	private String colPhong[] = {"Mã phòng", "Loại Phòng", "Sức chứa", "Giá", "Mô tả", "Trạng thái"};


	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnLamMoiDDP)) {
			lamMoi();
			jTable1.removeAll();
			try {
				updateTrangThaiPhongTheoDDP();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				loadDS();
			} catch (RemoteException ex) {
				throw new RuntimeException(ex);
			}
		}
		if (o.equals(btnPhong)) {
			try {
				updateTrangThaiPhongTheoDDP();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				loadDSPhong();
			} catch (RemoteException ex) {
				throw new RuntimeException(ex);
			}
		}
		if (o.equals(btnThemDDP)) {
			try {
				themDDP();
			} catch (RemoteException ex) {
				throw new RuntimeException(ex);
			}
			try {
				updateTrangThaiPhongTheoDDP();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			jTable1.removeAll();
			try {
				loadDS();
			} catch (RemoteException ex) {
				throw new RuntimeException(ex);
			}
		}
		if (o.equals(btnSuaDDP)) {
			suaDDP();
			try {
				updateTrangThaiPhongTheoDDP();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			jTable1.removeAll();
			try {
				loadDS();
			} catch (RemoteException ex) {
				throw new RuntimeException(ex);
			}
		}
		if (o.equals(jTextFieldTimDDP)) {
			jTextFieldTimDDP.selectAll();
			;
		}
		if (o.equals(jbTimDDP)) {
			jTable1.removeAll();
			try {
				timDDP();
			} catch (RemoteException ex) {
				throw new RuntimeException(ex);
			}
		}
		if (o.equals(btnXoaDDP)) {
			jTable1.removeAll();
			if (jTable1.getModel().equals(modelDDP)) {
				try {
					loadDSPhongTrong();
				} catch (RemoteException ex) {
					throw new RuntimeException(ex);
				}
			} else {
				try {
					loadDS();
				} catch (RemoteException ex) {
					throw new RuntimeException(ex);
				}
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}
	@Override
	public void keyReleased(KeyEvent e) {
		Object o = e.getSource();
		if (o.equals(txtSDTKH) && txtSDTKH.getText().matches("[0-9]{10}")) {
			try {
				txtTenKH.setText(khachHangDao.getKHTheoSDT(txtSDTKH.getText()).getTenKH());
				jComboBoxLoaiKH.addItem(khachHangDao.getKHTheoSDT(txtSDTKH.getText()).getLoaiKH().getTenLoaiKH().toString());
			} catch (RemoteException ex) {
				throw new RuntimeException(ex);
			}

		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		Object o = e.getSource();
		if (o.equals(jTable1)) {
			if (e.getClickCount() == 2 && !e.isConsumed()) {
				e.consume();
				if (jTable1.getModel().equals(modelDDP)) {
					try {
						getRowModelDDP();
					} catch (RemoteException ex) {
						throw new RuntimeException(ex);
					}
				} else
					getRowModelPhong();
			}
		}
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
