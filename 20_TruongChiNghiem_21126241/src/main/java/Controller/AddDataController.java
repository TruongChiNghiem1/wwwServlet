package Controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ServiceNhanVien;
import service.ServicePhongBan;
import utils.EntityManagerFactoryProvider;

import java.io.IOException;

/**
 * Servlet implementation class AddDataController
 */
@WebServlet(urlPatterns = {"/add-data"})
public class AddDataController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ServiceNhanVien serviceNhanVien;
	private static ServicePhongBan servicePhongBan;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDataController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) {
    	serviceNhanVien = new ServiceNhanVien(EntityManagerFactoryProvider.getFactory().createEntityManager());
    	servicePhongBan = new ServicePhongBan(EntityManagerFactoryProvider.getFactory().createEntityManager());
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("rowsPhongBan", servicePhongBan.getAll());
		request.getRequestDispatcher("views/AddData/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tenNV = request.getParameter("tenNV");
		String email = request.getParameter("email");
		String diaChi = request.getParameter("diaChi");
		String soDienThoai = request.getParameter("soDienThoai");
		String maPB = request.getParameter("maPhongBan");
		
		String message = serviceNhanVien.insert(tenNV, email, diaChi, soDienThoai, Integer.parseInt(maPB));
		request.setAttribute("message", message);
		request.getRequestDispatcher("views/AddData/index.jsp").forward(request, response);
		
	}

}
