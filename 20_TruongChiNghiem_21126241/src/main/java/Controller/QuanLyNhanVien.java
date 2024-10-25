package Controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ServiceNhanVien;
import utils.EntityManagerFactoryProvider;

import java.io.IOException;

/**
 * Servlet implementation class QuanLyNhanVien
 */
@WebServlet(urlPatterns = {"/list-user"})
public class QuanLyNhanVien extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ServiceNhanVien serviceNhanVien;
    /**
     * Default constructor. 
     */
    public QuanLyNhanVien() {
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) throws ServletException {
    	serviceNhanVien = new ServiceNhanVien(EntityManagerFactoryProvider.getFactory().createEntityManager());
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idDelete = request.getParameter("idDelete");
		if(idDelete != null) {
			serviceNhanVien.delete(Integer.parseInt(idDelete));
			request.getRequestDispatcher("views/ListNhanVien/index.jsp").forward(request, response);
		}
		request.setAttribute("totalNhanVien", serviceNhanVien.getAll());
		request.setAttribute("rowsNhanVien", serviceNhanVien.getAll());
		request.getRequestDispatcher("views/ListNhanVien/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}