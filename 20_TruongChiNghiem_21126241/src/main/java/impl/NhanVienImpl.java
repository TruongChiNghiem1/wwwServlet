package impl;

import java.util.List;

import DAO.NhanVienDAO;
import entities.NhanVien;
import jakarta.persistence.EntityManager;

public class NhanVienImpl implements NhanVienDAO{
	private EntityManager eManager;
	
	
	
	public NhanVienImpl(EntityManager eManager) {
		this.eManager = eManager;
	}

	@Override
	public List<NhanVien> getAll() {
		return eManager.createQuery("from NhanVien", NhanVien.class).getResultList();
	}

	@Override
	public boolean insert(NhanVien nhanVien) {
		// TODO Auto-generated method stub
		try {
			eManager.getTransaction().begin();
			eManager.persist(nhanVien);
			eManager.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			if(eManager.getTransaction().isActive()) {
				eManager.getTransaction().rollback();
			}
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(int maNV) {
		// TODO Auto-generated method stub
		try {
			eManager.getTransaction().begin();
			NhanVien nv = eManager.find(NhanVien.class, maNV);
			if(nv == null) {
				eManager.getTransaction().rollback();
				return false;
			}
			eManager.remove(nv);
			eManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			if(eManager.getTransaction().isActive()) {
				eManager.getTransaction().rollback();
				
			}
			e.printStackTrace();
			return false;
		}
	}

}
