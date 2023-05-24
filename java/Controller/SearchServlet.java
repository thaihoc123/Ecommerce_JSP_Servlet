package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.SanPhamDao;
import Model.Product;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String searchValue = request.getParameter("txtSearchValue");
		
		SanPhamDao dao = new SanPhamDao();
		if(searchValue == null || searchValue.trim().isEmpty()) {
			List<Product> ds = dao.AllSanPham();
			request.setAttribute("DSSP", ds);
			request.getRequestDispatcher("Home.jsp").forward(request, response);
			System.out.println(ds);
		}
		else {
			List<Product> ds = dao.SearchSanPham(searchValue);
			request.setAttribute("DSSP", ds);
			request.getRequestDispatcher("Home.jsp").forward(request, response);
			System.out.println(ds);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String searchValue = request.getParameter("txtSearchValue");
		
		SanPhamDao dao = new SanPhamDao();
		if(searchValue == null || searchValue.trim().isEmpty()) {
			List<Product> ds = dao.AllSanPham();
			request.setAttribute("DSSP", ds);
			request.getRequestDispatcher("Home.jsp").forward(request, response);
			System.out.println(ds);
		}
		else {
			List<Product> ds = dao.SearchSanPham(searchValue);
			request.setAttribute("DSSP", ds);
			request.getRequestDispatcher("Home.jsp").forward(request, response);
			System.out.println(ds);
		}
	}
}
