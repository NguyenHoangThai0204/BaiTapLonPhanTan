/*
 * @ (#) $NAME.java         4/23/2024
 *
 * Copyright (c) 2024 IUH.
 *
 */

package impl;

import dao.LoaiPhongDao;
import entity.LoaiPhong;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/*
 * @description: ...
 * @author: Vinh Trung Pham
 * @studentID: 20119821
 * @date: 4/23/2024
 */
public class LoaiPhongImpl extends UnicastRemoteObject implements LoaiPhongDao {

    private static EntityManager em;

    public LoaiPhongImpl() throws RemoteException {
        em = Persistence.createEntityManagerFactory("maria").createEntityManager();
    }

    @Override
    public ArrayList<LoaiPhong> getDanhSachLoaiPhong() throws RemoteException {
        TypedQuery<LoaiPhong> query = em.createQuery("SELECT lp FROM LoaiPhong lp", LoaiPhong.class);
        return (ArrayList<LoaiPhong>) query.getResultList();
    }

    @Override
    public LoaiPhong getLoaiPhongTheoMa(String ma) throws RemoteException {
        return em.find(LoaiPhong.class, ma);
    }

    @Override
    public LoaiPhong getLoaiPhongTheoTen(String ten) throws RemoteException {
        TypedQuery<LoaiPhong> query = em.createQuery("SELECT lp FROM LoaiPhong lp WHERE lp.tenLoaiPhong = :ten", LoaiPhong.class);
        query.setParameter("ten", ten);
        return query.getSingleResult();
    }

    @Override
    public String getMaLoaiPhongTheoTen(String ten) throws RemoteException {
        TypedQuery<LoaiPhong> query = em.createQuery("SELECT lp FROM LoaiPhong lp WHERE lp.tenLoaiPhong = :ten",
                LoaiPhong.class);
        query.setParameter("ten", ten);
        return query.getSingleResult().getMaLoaiPhong();
    }
}
