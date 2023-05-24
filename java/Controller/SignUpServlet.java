package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.coyote.Request;

import DAO.SanPhamDao;
import util.mahoa;


@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String password = request.getParameter("pass");
		String re_pass = request.getParameter("repeatpass");
		System.out.println(user + password + re_pass);
		if(password.equals(re_pass)) {
			SanPhamDao dao = new SanPhamDao();
			if(dao.CheckUser(user)) {
				request.setAttribute("mess", "User already exist");
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}else {
				password = mahoa.toSHA1(password);
				dao.AddUser(user, password);
				request.setAttribute("signinsuccess", "Signin Successful");
				request.getRequestDispatcher("Login.jsp").forward(request, response);			
				}
		}else {
			request.setAttribute("mess1", "Wrong pass or user");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
		
	}

}
