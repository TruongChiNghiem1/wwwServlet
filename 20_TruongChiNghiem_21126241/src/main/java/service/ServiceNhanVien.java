package service;

import java.util.List;
import java.util.Set;

import DAO.NhanVienDAO;
import entities.NhanVien;
import entities.PhongBan;
import impl.NhanVienImpl;
import jakarta.persistence.EntityManager;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class ServiceNhanVien {
	private static NhanVienDAO nhanVienDao;
	private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	Validator validator;
	
	public ServiceNhanVien(EntityManager eManager) {
		nhanVienDao = new NhanVienImpl(eManager);
		validator = factory.getValidator();
	}
	
	public List<NhanVien> getAll() {
		return nhanVienDao.getAll();
	}
	
	public String insert(String tenNV, String email, String diaChi, String soDienThoai, int maPB) {
		String message = "Thêm nhân viên thành công";
		PhongBan pb = new PhongBan();
		pb.setMaPhongBan(maPB);
		
		NhanVien nv = new NhanVien(tenNV, email, diaChi, soDienThoai, pb);
		Set<ConstraintViolation<NhanVien>> violations = validator.validate(nv);
		for(ConstraintViolation<NhanVien> violation : violations) {
			return violation.getMessage();
		}
		if(!nhanVienDao.insert(nv)) {
			message = "Faild";
		}
		return message;
	}
	
	public boolean delete(int id) {
		return nhanVienDao.delete(id);
	}
}
