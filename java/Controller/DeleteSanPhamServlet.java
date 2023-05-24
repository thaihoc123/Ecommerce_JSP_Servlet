package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.SanPhamDao;


@WebServlet("/DeleteSanPhamServlet")
public class DeleteSanPhamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DeleteSanPhamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		SanPhamDao dao = new SanPhamDao();
		dao.DeleteSanPham(id);
		response.sendRedirect("DeleteServlet");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
