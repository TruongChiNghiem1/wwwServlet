package DAO;

import java.util.List;

import entities.NhanVien;

public interface NhanVienDAO {
	List<NhanVien> getAll();
	boolean insert(NhanVien nhanVien);
	boolean delete(int maNV);
}