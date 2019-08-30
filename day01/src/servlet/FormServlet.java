package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/FormServlet", "/form.do" })
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String[] hobbies;
		PrintWriter out = response.getWriter();
		
		hobbies = request.getParameterValues("hobby");
		out.print("<h1>당신의 취미는</h1>");
		for(String s:hobbies) {
			out.print("<h3>"+s+"</h3>");
		}
	}
}
