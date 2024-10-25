package entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class PhongBan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maPhongBan;
	
	private String tenPhongBan;
	
	@OneToMany(mappedBy = "phongBan")
	private List<NhanVien> nhanVien;

	public PhongBan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PhongBan(int maPhongBan, String tenPhongBan, List<NhanVien> nhanVien) {
		super();
		this.maPhongBan = maPhongBan;
		this.tenPhongBan = tenPhongBan;
		this.nhanVien = nhanVien;
	}
	
	

	public PhongBan(String tenPhongBan, List<NhanVien> nhanVien) {
		super();
		this.tenPhongBan = tenPhongBan;
		this.nhanVien = nhanVien;
	}

	public int getMaPhongBan() {
		return maPhongBan;
	}

	public void setMaPhongBan(int maPhongBan) {
		this.maPhongBan = maPhongBan;
	}

	public String getTenPhongBan() {
		return tenPhongBan;
	}

	public void setTenPhongBan(String tenPhongBan) {
		this.tenPhongBan = tenPhongBan;
	}

	public List<NhanVien> getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(List<NhanVien> nhanVien) {
		this.nhanVien = nhanVien;
	}

	@Override
	public String toString() {
		return "PhongBan [maPhongBan=" + maPhongBan + ", tenPhongBan=" + tenPhongBan + ", nhanVien=" + nhanVien + "]";
	}

	
}
