package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.SanPhamDao;
import Model.Product;


@WebServlet("/SanPhamServlet")
public class SanPhamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SanPhamDao sp = new SanPhamDao();
		List<Product> ds = sp.AllSanPham();
		request.setAttribute("DSSP", ds);
		request.getRequestDispatcher("Home.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SanPhamDao sp = new SanPhamDao();
		List<Product> ds = sp.AllSanPham();
		request.setAttribute("DSSP", ds);
		request.getSession().removeAttribute("carts");
		request.getRequestDispatcher("Home.jsp").forward(request, response);
	}
}
