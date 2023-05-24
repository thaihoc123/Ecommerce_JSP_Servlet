package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import DAO.AccountDao;
import DAO.OderDao;
import Model.Account;
import Model.Cart;

/**
 * Servlet implementation class PayServlet
 */
@WebServlet("/PayServlet")
public class PayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sumP=request.getParameter("sumP");
		List<Cart>list=(List<Cart>) request.getSession().getAttribute("carts");
		Account account=(Account)request.getSession().getAttribute("account");
		AccountDao dao=new AccountDao();
		System.out.println("id"+account.getId());
		System.out.println("date: "+java.time.LocalDate.now().toString()+"  ");
		OderDao odao=new OderDao();
		odao.insert(java.time.LocalDateTime.now().toString(), account.getId());
		int idOder=odao.getLast();
		for(int i=0;i<list.size();i++) {
			int idP=list.get(i).getProduct().getId();
			int q=list.get(i).getQuanlity();
			odao.insertOderDetail(idP, idOder, q);
		}
		request.setAttribute("sumP", sumP);
		request.getRequestDispatcher("Pay.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
