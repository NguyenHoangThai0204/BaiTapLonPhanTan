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
        entityManager = Persistence.createEntityManagerFactory("mssql").createEntityManager();
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
 			String maKH="";
 			String sql = "select CONCAT('NV', RIGHT(CONCAT('000',ISNULL(right(max(maNhanVien),3),0) + 1),3)) from [dbo].[NhanVien] where maNhanVien like 'NV%'";
 			Object obj = entityManager.createNativeQuery(sql).getSingleResult();
			if (obj == null) {
				maKH = "KH001";
			} else {
				String temp = obj.toString();
				int so = Integer.parseInt(temp.substring("NV".length())) + 1;
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
    // tự động phát sinh mã NV
    public String getMaNV() {
        String maNV="";
        String sql = "select CONCAT('NV', RIGHT(CONCAT('000',ISNULL(right(max(maNhanVien),3),0) + 1),3)) from [dbo].[NhanVien] where maNhanVien like 'NV%'";
        Object obj = entityManager.createNativeQuery(sql).getSingleResult();
        if (obj == null) {
            maNV = "NV001";
        } else {
            String temp = obj.toString();
            int so = Integer.parseInt(temp.substring("NV".length())) + 1;
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
        String maMH = "";
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery(
                    "SELECT CONCAT('MH', RIGHT(CONCAT('000', COALESCE(CAST(SUBSTRING(m.maMH, 3) AS int), 0) + 1), 3)) FROM MatHang m WHERE m.maMH LIKE 'MH%'");
            maMH = (String) query.getSingleResult();
            entityManager.getTransaction().commit();
        } catch (NoResultException e) {
            // Xử lý nếu không tìm thấy kết quả
            maMH = "MH001"; // Giá trị mặc định nếu không tìm thấy kết quả
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return maMH;
    }
}
