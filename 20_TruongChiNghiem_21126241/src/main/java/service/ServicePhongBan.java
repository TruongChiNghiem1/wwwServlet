package service;

import java.util.List;

import DAO.PhongBanDAO;
import entities.PhongBan;
import impl.PhongBanImpl;
import jakarta.persistence.EntityManager;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class ServicePhongBan {
	private static PhongBanDAO phongBanDao;
	private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	Validator validator;
	
	public ServicePhongBan(EntityManager eManager) {
		phongBanDao = new PhongBanImpl(eManager);
		validator = factory.getValidator();
	}
	
	public List<PhongBan> getAll() {
		return phongBanDao.getAll();
	}
}
