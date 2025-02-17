<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="d-flex justify-content-center m-3">
		<h4>20 - Trương Chí Nghiệm 21126241</h4>
	</div>
	<hr>
	<div class="d-flex justify-content-center m-3">
		<a href="/20_TruongChiNghiem_21126241">Danh sách nhân viên</a>| <a
			href="/20_TruongChiNghiem_21126241/add-data">Thêm mới nhân viên</a>
	</div>
	<div class="d-flex justify-content-center m-3">
			<h6 class="text-danger">${message}</h6>
		</div>
	<div class="d-flex justify-content-center m-3">
		<h4>THÊM NHÂN VIÊN</h4>
	</div>
	<div class="container">
		<form action="/20_TruongChiNghiem_21126241/add-data" method="POST">
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Tên nhân
					viên:</label> <input type="text" class="form-control" name="tenNV">
			</div>
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Email:</label> <input
					type="text" class="form-control" name="email">
			</div>
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Địa chỉ:</label>
				<input type="text" class="form-control" name="diaChi">
			</div>
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Số điện
					thoại:</label> <input type="text" class="form-control" name="soDienThoai">
			</div>
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Phòng
					ban:</label> <select class="form-select" name="maPhongBan"
					aria-label="Default select example">
					<c:forEach var="row" items="${rowsPhongBan}">
						<option value="${row.maPhongBan}">${row.tenPhongBan}</option>
					</c:forEach>
				</select>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>