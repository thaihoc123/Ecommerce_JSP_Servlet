package Controller;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

import javax.mail.Session;
import javax.mail.Authenticator;
import DAO.SanPhamDao;
import java.util.Date;
import java.util.Iterator;
import javax.mail.PasswordAuthentication;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.activation.DataHandler;
import javax.activation.DataSource;

/**
 * Servlet implementation class EmailServlet
 */
@WebServlet("/EmailServlet")
public class EmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public EmailServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String user = "thaihoc2le2@gmail.com";
		final String pass = "hfpjizfeqtrjmmbc";
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP HOST
		props.put("mail.smtp.port", "587"); // TLS 587 SSL 465
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, pass);
			}
		});
		// kiem tra gmail co ton tai
		String email = request.getParameter("reset");
		HttpSession session2 =request.getSession();
		session2.setAttribute("email", email);
		System.out.println(email);
		SanPhamDao dao = new SanPhamDao();
		boolean check = dao.CheckUser(email);
		if(check) {
			try {
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(user));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
				message.setSubject("Forget Password");
				int otp = (int) ((Math.random() * (999999 - 100000)) + 100000);
				String otpString = String.valueOf(otp);
				HttpSession Otpsession =request.getSession();
				Otpsession.setAttribute("otp", otpString);
				message.setText("Please insert this OTP to reset password: "+ otp);
			Transport.send(message);
			System.out.println("Sent");
			request.getRequestDispatcher("checkOTP.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		else {
			request.setAttribute("mess", "Email is not signed up!");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("Repassword.jsp").forward(request, response);
	}
}
