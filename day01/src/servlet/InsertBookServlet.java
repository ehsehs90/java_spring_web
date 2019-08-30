package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookprob.dao.BookDAO;
import bookprob.service.BookService;
import bookprob.service.BookServiceImpl;
import bookprob.vo.BookVO;

@WebServlet({ "/BookServlet", "/book.do" })
public class InsertBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		int price = Integer.parseInt(request.getParameter("price"));
		
		BookDAO dao = new BookDAO();
		BookService service = new BookServiceImpl(dao);
		BookVO vo = new BookVO(title, author, price);
		if(service != null) {
			try {
				System.out.println(service.addBook(vo));
				out.print("<h3>title : "+title+"</h3>");
				out.print("<h3>author : "+author+"</h3>");
				out.print("<h3>price : "+price+"</h3>");
				out.print("<h3>추가 성공</h3>");
			} catch (Exception e) {
				e.printStackTrace();
			}
			List<BookVO> list = service.bookList();
			list.forEach(i->System.out.println(i));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
