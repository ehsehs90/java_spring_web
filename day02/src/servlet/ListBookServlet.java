package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookDAO;
import service.BookService;
import service.BookServiceImpl;
import vo.BookVO;

@WebServlet({ "/ListBookServlet", "/list.do" })
public class ListBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BookDAO dao = new BookDAO();
		BookService service = new BookServiceImpl(dao);
		List<BookVO> list;
		list = service.bookList();

		HttpSession session = request.getSession();
		String login = (String) session.getAttribute("login");
		if (login == null) {
			request.setAttribute("msg", "로그인이 필요합니다.");
			
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		else {
			request.setAttribute("list", list);
			getServletContext().getRequestDispatcher("/bookList.jsp").forward(request, response);
		}
	}
}
