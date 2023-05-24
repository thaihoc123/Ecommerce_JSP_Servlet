package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.coyote.Request;

import DAO.SanPhamDao;
import Model.Account;
import util.mahoa;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("user");
		String password = request.getParameter("pass");
		password = mahoa.toSHA1(password);
		SanPhamDao dao = new SanPhamDao();
		Account a = dao.login(username, password);
		System.out.println(username+password);
		if(a == null) {
			request.setAttribute("mess", "Wrong user or password");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}else {
			HttpSession session=request.getSession();
			session.setAttribute("account", a);
			response.sendRedirect("SanPhamServlet");
		}
		
	}

}
