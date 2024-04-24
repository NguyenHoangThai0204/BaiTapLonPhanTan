/*
 * @ (#) DAOCTHDImpl.java  1  4/24/2024
 * Copyright (c) 2024 IUH. All rights reserved
 */

package impl;
/*
 * @description:
 * @author: Nguyen Hoang Thai
 * @date: 4/24/2024
 * @version: 1.0
 */

import dao.DAOCTHD;
import entity.ChiTietHD;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class DAOCTHDImpl extends UnicastRemoteObject implements DAOCTHD {
    private static final long serialVersionUID = 1L;
    private EntityManager entityManager;
    protected DAOCTHDImpl() throws RemoteException {
        entityManager = Persistence.createEntityManagerFactory("maria").createEntityManager();
    }

    @Override
    public boolean themCTHD(ChiTietHD cthd) throws RemoteException {
        entityManager.getTransaction().begin();
        entityManager.persist(cthd);
        entityManager.getTransaction().commit();
        return true;
    }

    @Override
    public ChiTietHD getCTHDTheoMa(String maHD, String maMH) throws RemoteException {
        return (ChiTietHD) entityManager.createQuery("SELECT c FROM ChiTietHD c WHERE c.hoaDon.maHoaDon = :maHD AND c.matHang.maMH = :maMH")
                .setParameter("maHD", maHD)
                .setParameter("maMH", maMH)
                .getSingleResult();
    }

    @Override
    public ArrayList<ChiTietHD> getCTHDTheoMaHD(String maHD) throws RemoteException {
        return (ArrayList<ChiTietHD>) entityManager.createQuery("SELECT c FROM ChiTietHD c WHERE c.hoaDon.maHoaDon = :maHD")
                .setParameter("maHD", maHD)
                .getResultList();
    }
}
