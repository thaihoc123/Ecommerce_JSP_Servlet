package Controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.SanPhamDao;
import Model.Product;

/**
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet("/UpdateProductServlet")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		SanPhamDao dao = new SanPhamDao();
		Product product = dao.getProductById(id);
			request.setAttribute("product",product);
			request.getRequestDispatcher("UpdateProduct.jsp").forward(request, response);	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid= request.getParameter("pid");
		String pname= request.getParameter("pname");
		String pprice = request.getParameter("pprice");
		String pimg = request.getParameter("pimg");
		String pdes= request.getParameter("pdes");
		SanPhamDao dao = new SanPhamDao();
		System.out.println("img: "+ pimg);
		dao.UpdateProduct(pname, pimg, pdes, pprice, pid);
		request.getRequestDispatcher("DeleteServlet").forward(request, response);
	}

}
