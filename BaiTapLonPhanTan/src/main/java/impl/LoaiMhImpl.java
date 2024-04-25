package impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dao.LoaiMhDao;
import entity.LoaiMH;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;

public class LoaiMhImpl extends UnicastRemoteObject implements LoaiMhDao{

	private EntityManager entityManager;

	public LoaiMhImpl() throws RemoteException {
		entityManager = Persistence.createEntityManagerFactory("maria").createEntityManager();
	}
	
	@Override
	
	public boolean themLoaiMatHang(LoaiMH loaiMatHang) throws RemoteException {
		entityManager.getTransaction().begin();
		entityManager.persist(loaiMatHang);
		entityManager.getTransaction().commit();
		return true;
	}
	
	@Override
	public ArrayList<LoaiMH> getAllLoaiMatHang() throws RemoteException {
		return (ArrayList<LoaiMH>) entityManager.createQuery("SELECT lmh FROM LoaiMH lmh").getResultList();
	}
	
	@Override
	public LoaiMH getLMHTheoMa(String ma) throws RemoteException {
		return entityManager.find(LoaiMH.class, ma);
	}

	@Override
	public LoaiMH getLMHTheoTen(String ten) throws RemoteException {
		try {
			return entityManager.createQuery("SELECT lmh FROM LoaiMH lmh WHERE lmh.tenLoaiMatHang = :ten", LoaiMH.class)
					.setParameter("ten", ten).getSingleResult();
		} catch (NoResultException e) {
			// handle the case where no result is found, for example, return null or throw a custom exception
			return null;
		}
	}
	
	
	
}
