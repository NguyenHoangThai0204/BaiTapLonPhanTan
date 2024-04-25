                            package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

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
     List<Object> results = entityManager.createNativeQuery(sql).getResultList();
     if (results.isEmpty()) {
         maKH = "KH001";
     } else {
         // handle multiple results here, for example by taking the first result
         String temp = results.get(0).toString();
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
        List<Object> results = entityManager.createNativeQuery(sql).getResultList();
        if (results.isEmpty()) {
            maNV = "NV001";
        } else {
            // handle multiple results here, for example by taking the first result
            String temp = results.get(0).toString();
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
        List<Object> results = entityManager.createNativeQuery(sql).getResultList();
        if (results.isEmpty()) {
            ma = "MH001";
        } else {
            // handle multiple results here, for example by taking the first result
            String temp = results.get(0).toString();
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

    public String getMaPhong() {
        String ma = "";
        String sql = "SELECT CONCAT('P', LPAD(IFNULL(SUBSTRING(maPhong, 2), 0) + 1, 3, '0')) FROM Phong WHERE maPhong LIKE 'P%' ORDER BY maPhong DESC LIMIT 1";
        Object result = entityManager.createNativeQuery(sql).getSingleResult();
        if (result != null) {
            String temp = result.toString();
            int so = Integer.parseInt(temp.substring(1)) + 1;
            ma = "P" + String.format("%03d", so);
        } else {
            ma = "P001";
        }
        return ma;
    }


    public String getMaDDP() {
        String ma = "";
        String sql = "SELECT CONCAT('DDP', LPAD(IFNULL(SUBSTRING(maDDP, 4), 0) + 1, 3, '0')) FROM DonDatPhong WHERE maDDP LIKE 'DDP%' ORDER BY maDDP DESC LIMIT 1";
        Object result = entityManager.createNativeQuery(sql).getSingleResult();
        if (result != null) {
            String temp = result.toString();
            int so = Integer.parseInt(temp.substring(3)) + 1;
            ma = "DDP" + String.format("%03d", so);
        } else {
            ma = "DDP001";
        }
        return ma;
    }

}
