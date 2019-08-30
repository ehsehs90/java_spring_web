package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAO;
import service.BookService;
import service.BookServiceImpl;
import vo.BookVO;

@WebServlet({ "/InsertBookServlet", "/insertbook.do" })
public class InsertBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		BookDAO dao = new BookDAO();
		BookService service = new BookServiceImpl(dao);
		BookVO vo = new BookVO();
		
		vo.setAuthor(request.getParameter("author"));
		vo.setPrice(Integer.parseInt(request.getParameter("price")));
		vo.setTitle(request.getParameter("title"));
		try {
			int i = service.addBook(vo);
			response.sendRedirect("list.do");
		} catch (Exception e) {
			request.setAttribute("exception", e);
			getServletContext()
			.getRequestDispatcher("/error.jsp")
			.forward(request, response);
		}
		
	}

}
