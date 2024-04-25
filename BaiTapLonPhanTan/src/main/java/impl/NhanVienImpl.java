/*
 * @ (#) NhanVienImpl.java  1  4/22/2024
 * Copyright (c) 2024 IUH. All rights reserved
 */

package impl;
/*
 * @description:
 * @author: Nguyen Hoang Thai
 * @date: 4/22/2024
 * @version: 1.0
 */

import dao.NhanVienDao;
import entity.NhanVien;
import entity.TaiKhoan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class NhanVienImpl extends UnicastRemoteObject implements NhanVienDao {
    private EntityManager entityManager;

    public NhanVienImpl() throws RemoteException {
        entityManager = Persistence.createEntityManagerFactory("maria").createEntityManager();
    }

    @Override
    public boolean themNhanVien(NhanVien nv, TaiKhoan tk) throws RemoteException {
        entityManager.getTransaction().begin();
        //entityManager.persist(tk); // lưu đối tượng TaiKhoan trước
        nv.setTaiKhoan(tk); // set TaiKhoan cho NhanVien
        entityManager.persist(nv); // sau đó lưu NhanVien
        entityManager.getTransaction().commit();
        return true;
    }

    //update NhanVien set trangThaiLamViec = N'Đã nghỉ việc'
    @Override
    public boolean huyNV(String ma) throws RemoteException {
        entityManager.getTransaction().begin();
        NhanVien nv = entityManager.find(NhanVien.class, ma);
        nv.setTrangThaiLamViec("Đã nghỉ việc");
        entityManager.getTransaction().commit();
        return true;
    }

    @Override
    public boolean capNhatNV(NhanVien nv, String ma) throws RemoteException {
        entityManager.getTransaction().begin();
        NhanVien nhanVien = entityManager.find(NhanVien.class, ma);
        nhanVien.setTenNhanVien(nv.getTenNhanVien());
        nhanVien.setChucVu(nv.getChucVu());
        nhanVien.setNgaySinh(nv.getNgaySinh());
        nhanVien.setGioiTinh(nv.getGioiTinh());
        nhanVien.setDiaChi(nv.getDiaChi());
        nhanVien.setSdt(nv.getSdt());
        nhanVien.setCccd(nv.getCccd());
        nhanVien.setCaLamViec(nv.getCaLamViec());
        nhanVien.setLuong(nv.getLuong());
        nhanVien.setTrangThaiLamViec(nv.getTrangThaiLamViec());
        entityManager.getTransaction().commit();
        return true;
    }

    @Override
    public ArrayList<NhanVien> getAllDanhSachNV() throws RemoteException {
        return (ArrayList<NhanVien>) entityManager.createQuery("select nv from NhanVien nv").getResultList();
    }

    @Override
    public ArrayList<NhanVien> getDanhSachNV() throws RemoteException {
        return (ArrayList<NhanVien>) entityManager.createQuery("select nv from NhanVien nv where nv.trangThaiLamViec = 'Đang làm việc'").getResultList();
    }

    @Override
    public ArrayList<NhanVien> getMaVaSdtNVChoDDP(String info) throws RemoteException {
        return (ArrayList<NhanVien>) entityManager.createQuery("select nv from NhanVien nv where nv.maNhanVien like '%" + info + "%' or nv.sdt like '%" + info + "%'").getResultList();
    }

    @Override
    public NhanVien getNVTheoMa(String ma) throws RemoteException {
        return entityManager.find(NhanVien.class, ma);
    }

    @Override
    public ArrayList<NhanVien> getTenNV(String info) throws RemoteException {
        return (ArrayList<NhanVien>) entityManager.createQuery("select nv from NhanVien nv where nv.tenNhanVien = '" + info + "'").getResultList();
    }

    @Override
    public ArrayList<NhanVien> getChucVuNV(String info) throws RemoteException {
        return (ArrayList<NhanVien>) entityManager.createQuery("select nv from NhanVien nv where nv.chucVu = '" + info + "'").getResultList();
    }

    @Override
    public ArrayList<NhanVien> getCaNV(String info) throws RemoteException {
        Integer caLamViec = Integer.valueOf(info);
        return (ArrayList<NhanVien>) entityManager.createQuery("select nv from NhanVien nv where nv.caLamViec = :caLamViec", NhanVien.class)
                .setParameter("caLamViec", caLamViec)
                .getResultList();
    }


    @Override
    public NhanVien getNVDaNghiViec(String ma) throws RemoteException {
        return (NhanVien) entityManager.createQuery("select nv from NhanVien nv where nv.maNhanVien = '" + ma + "' and nv.trangThaiLamViec = 'Đã nghỉ việc'").getSingleResult();
    }

    @Override
    public NhanVien getNVTheoTK(String maTK) throws RemoteException {
        if (maTK == null) {
            // handle the case where maTK is null, for example, return null or throw a custom exception
            return null;
        } else {
            try {
                return (NhanVien) entityManager.createQuery("select nv from NhanVien nv where nv.taiKhoan.maTK = :maTK", NhanVien.class)
                        .setParameter("maTK", maTK)
                        .getSingleResult();
            } catch (NoResultException e) {
                // handle the case where no result is found, for example, return null or throw a custom exception
                return null;
            }
        }
    }
    @Override
    public ArrayList<NhanVien> sortMaNV(String kieuSapXep) throws RemoteException {
        String sapXep = "desc"; // mặc định sắp xếp giảm dần
        if ("ASC".equalsIgnoreCase(kieuSapXep)) {
            sapXep = "asc";
        }

        // Sử dụng tham số để tránh lỗ hổng bảo mật
        String queryString = "select nv from NhanVien nv order by nv.maNhanVien " + sapXep;

        TypedQuery<NhanVien> query = entityManager.createQuery(queryString, NhanVien.class);
        return new ArrayList<>(query.getResultList());
    }

    @Override
    public ArrayList<NhanVien> sortTen(String kieuSapXep) throws RemoteException {
        String sapXep = "desc"; // mặc định sắp xếp giảm dần
        if ("ASC".equalsIgnoreCase(kieuSapXep)) {
            sapXep = "asc";
        }

        // Sử dụng tham số để tránh lỗ hổng bảo mật
        String queryString = "select nv from NhanVien nv order by nv.tenNhanVien " + sapXep;

        TypedQuery<NhanVien> query = entityManager.createQuery(queryString, NhanVien.class);
        return new ArrayList<>(query.getResultList());
    }

    @Override
    public ArrayList<NhanVien> sortCV(String tenChucVu) throws RemoteException {
        // Sử dụng tham số để tránh lỗ hổng bảo mật
        String queryString = "select nv from NhanVien nv where nv.chucVu = :chucVu";
        TypedQuery<NhanVien> query = entityManager.createQuery(queryString, NhanVien.class);
        query.setParameter("chucVu", tenChucVu);
        return new ArrayList<>(query.getResultList());
    }

    @Override
    public boolean checkSdtNV(String sdt) throws RemoteException {
        List<NhanVien> results = entityManager.createQuery("select nv from NhanVien nv where nv.sdt = :sdt", NhanVien.class)
                .setParameter("sdt", sdt)
                .getResultList();
        if (results.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkCccdNV(String cccd) throws RemoteException {
        List<NhanVien> results = entityManager.createQuery("select nv from NhanVien nv where nv.cccd = '" + cccd + "'", NhanVien.class).getResultList();
        if(results.isEmpty()){
            return true;
        }else{
            return false;
        }
    }


}
