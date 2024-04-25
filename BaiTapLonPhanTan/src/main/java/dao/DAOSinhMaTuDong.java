package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class DAOSinhMaTuDong {
    private EntityManager entityManager;

    public DAOSinhMaTuDong() {
        entityManager = Persistence.createEntityManagerFactory("maria").createEntityManager();
    }

    public String sinhMaTuDong(String tenBang, String tenCot) {
        String ma = "";
        String sql = "SELECT MAX(" + tenCot + ") FROM " + tenBang;
        Object obj = entityManager.createNativeQuery(sql).getSingleResult();
        if (obj == null) {
            ma = tenBang + "001";
        } else {
            String temp = obj.toString();
            int so = Integer.parseInt(temp.substring(tenBang.length())) + 1;
            if (so < 10) {
                ma = tenBang + "00" + so;
            } else if (so < 100) {
                ma = tenBang + "0" + so;
            } else {
                ma = tenBang + so;
            }
        }
        return ma;
    }

 // tự động phát sinh mã KH
 public String getMaKH() {
     String maKH = "";
     String sql = "SELECT CONCAT('KH', LPAD(IFNULL(SUBSTRING(maKhachHang, 3), 0) + 1, 3, '0')) FROM KhachHang WHERE maKhachHang LIKE 'KH%'";
     Object obj = entityManager.createNativeQuery(sql).getSingleResult();
     if (obj == null) {
         maKH = "KH001";
     } else {
         String temp = obj.toString();
         int so = Integer.parseInt(temp.substring(2)) + 1;
         if (so < 10) {
             maKH = "KH00" + so;
         } else if (so < 100) {
             maKH = "KH0" + so;
         } else {
             maKH = "KH" + so;
         }
     }
     return maKH;
 }

    public String getMaNV() {
        String maNV = "";
        String sql = "SELECT CONCAT('NV', LPAD(IFNULL(SUBSTRING(maNhanVien, 3), 0) + 1, 3, '0')) FROM NhanVien WHERE maNhanVien LIKE 'NV%'";
        Object obj = entityManager.createNativeQuery(sql).getSingleResult();
        if (obj == null) {
            maNV = "NV001";
        } else {
            String temp = obj.toString();
            int so = Integer.parseInt(temp.substring(2)) + 1;
            if (so < 10) {
                maNV = "NV00" + so;
            } else if (so < 100) {
                maNV = "NV0" + so;
            } else {
                maNV = "NV" + so;
            }
        }
        return maNV;
    }
    public String getMaMH() {
        String ma = "";
        String sql = "SELECT CONCAT('MH', LPAD(IFNULL(SUBSTRING(maMH, 3), 0) + 1, 3, '0')) FROM MatHang WHERE maMH LIKE 'MH%'";
        Object obj = entityManager.createNativeQuery(sql).getSingleResult();
        if (obj == null) {
            ma = "MH001";
        } else {
            String temp = obj.toString();
            int so = Integer.parseInt(temp.substring(2)) + 1;
            if (so < 10) {
                ma = "MH00" + so;
            } else if (so < 100) {
                ma = "MH0" + so;
            } else {
                ma = "MH" + so;
            }
        }
        return ma;
    }


}
