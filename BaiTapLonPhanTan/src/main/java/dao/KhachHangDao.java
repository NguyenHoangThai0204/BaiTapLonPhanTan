/*
 * @ (#) KhachHangDao.java     1     22
 * Copyright (c) 2024 IUH. All rights reserved
 */

package dao;
/*
 * @description:
 * @author: Nguyen Hoang Thai
 * @date: 22
 * @version: 18
 */


import entity.KhachHang;
import entity.LoaiKH;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface KhachHangDao extends Remote {
    // them khach hang
    public boolean themKhachHang(KhachHang khachHang) throws RemoteException;

    // huỷ khach hang
    public boolean huyKH(String maKH) throws RemoteException;
    // cap nhat khach hang
    public boolean capNhatKH(KhachHang khachHang) throws RemoteException;

    // Load tat ca khach hang
    public ArrayList<KhachHang> getAllDanhSachKH() throws RemoteException;

    // Load 1 khach hang theo ma
    public KhachHang getKHTheoMa(String ma) throws RemoteException;

    // Load danh sách khach hang theo ten
    public ArrayList<KhachHang> getTenKH(String info) throws RemoteException;

    // Load danh sách khach hang theo sdt hoặc mã khách hàng
    public ArrayList<KhachHang> getMaVaSDTKH(String info) throws RemoteException;

    // Load danh sách khách hàng theo mã giảm dần
    public ArrayList<KhachHang> sortMaKH() throws RemoteException;

    // Load danh sách khách hàng theo mã loại khách hàng
    public ArrayList<KhachHang> getKHTheoLoai(String maLoaiKH) throws RemoteException;

    // thêm khách hàng theo đơn đặt phòng
    public boolean themKHTheoDDP(KhachHang kh) throws RemoteException;

    // Loại khách hàng từ tên khách hàng
    public LoaiKH getMaLoaiKHFromTen(String tenLoaiKH) throws RemoteException;

    // kiểm tra số điện thoại đã tồn tại chưa
    public boolean checkSdtKH(String sdt) throws RemoteException;

    // Load khách hàng theo tên
    public KhachHang getKHTheoTen(String info) throws RemoteException;
    public KhachHang getKHTheoSDT(String sdt) throws RemoteException;


}
