package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import entity.LoaiPhong;

public interface LoaiPhongDao extends Remote{

    ArrayList<LoaiPhong> getDanhSachLoaiPhong() throws RemoteException;

    LoaiPhong getLoaiPhongTheoMa(String ma) throws RemoteException;

    LoaiPhong getLoaiPhongTheoTen(String ten) throws RemoteException;

    String getMaLoaiPhongTheoTen(String ten) throws RemoteException;


}
