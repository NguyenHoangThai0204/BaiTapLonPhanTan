/*
 * @ (#) DAOCTHD.java     1     24
 * Copyright (c) 2024 IUH. All rights reserved
 */

package dao;
/*
 * @description:
 * @author: Nguyen Hoang Thai
 * @date: 24
 * @version: 18
 */


import entity.ChiTietHD;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface DAOCTHD extends Remote {
    public boolean themCTHD(ChiTietHD cthd) throws RemoteException;
    public	ChiTietHD getCTHDTheoMa(String maHD,String maMH) throws RemoteException;
    public ArrayList<ChiTietHD> getCTHDTheoMaHD(String maHD) throws RemoteException;
}
