package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.If;

import DAO.SanPhamDao;
import Model.Cart;
import Model.Product;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		List<Cart>list=(List<Cart>) request.getSession().getAttribute("carts");
		SanPhamDao dao=new SanPhamDao();
		if(list==null) {
			list=new ArrayList<Cart>();
			list.add(new Cart(dao.getProductById(id), 1));
			request.getSession().setAttribute("carts", list);
		}else {
			Product p=dao.getProductById(id);
			boolean check=false;
			for(int i=0;i<list.size();i++) {
				if(list.get(i).getProduct().getId()==p.getId()) {
					list.get(i).setQuanlity(list.get(i).getQuanlity()+1);
					check=true;
					break;
				}
			}
			if(!check) {
				list.add(new Cart(dao.getProductById(id), 1));				
			}
			request.getSession().setAttribute("carts", list);
		}
		response.sendRedirect("SanPhamServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
