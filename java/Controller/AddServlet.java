package Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import DAO.SanPhamDao;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddServlet")
@MultipartConfig()
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SAVE_DIR="images";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("AddNew.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String TenSanPham = request.getParameter("name");
		String Gia = request.getParameter("price");
		
		String savePath="C:\\Users\\ACER\\Downloads\\eclipse\\WebDongHo\\src\\main\\webapp" + File.separator + SAVE_DIR;
		File fileSaveDir=new File(savePath);
		
		Part filePart=request.getPart("img");
		String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();	
		filePart.write(savePath+File.separator+fileName);
	
		
		String Mota=request.getParameter("des");
		
		SanPhamDao dao = new SanPhamDao();
		dao.AddNew(TenSanPham, Gia, "images/"+fileName,Mota);
		//request.getRequestDispatcher("SanPhamServlet").forward(request, response);
		response.sendRedirect("SanPhamServlet");
	}
	public static void main(String[] args) {
		String savePath="C:\\Users\\ACER\\Downloads\\eclipse\\WebDongHo\\src\\main\\webapp" + File.separator + SAVE_DIR;
		File fileSaveDir=new File(savePath);
		System.out.println(savePath);
//		
//		Part filePart="anh1.jpg";
//		String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();	
//		filePart.write(savePath+File.separator+fileName);
	}
}
