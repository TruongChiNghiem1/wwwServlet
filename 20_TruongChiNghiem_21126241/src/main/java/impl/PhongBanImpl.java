package impl;

import java.util.List;

import DAO.PhongBanDAO;
import entities.PhongBan;
import jakarta.persistence.EntityManager;

public class PhongBanImpl implements PhongBanDAO{
	private EntityManager eManager;
	
	
	
	public PhongBanImpl(EntityManager eManager) {
		super();
		this.eManager = eManager;
	}



	public List<PhongBan> getAll() {
		eManager.clear();
		return eManager.createQuery("from PhongBan", PhongBan.class).getResultList();
	}
}
