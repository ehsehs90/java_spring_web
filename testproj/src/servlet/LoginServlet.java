package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.JDBCUtil;

@WebServlet({ "/LoginServlet", "/login.do" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String sql = "select * from testusers where name=?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String light = null;
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(rs != null) {
			response.sendRedirect("./login.html");
		}
		else {
			HttpSession session = request.getSession();
			session.setAttribute("name", name);
			RequestDispatcher rdp = getServletContext().getRequestDispatcher("index.jsp");
			request.setAttribute("name", name);
			request.setAttribute("light", light);
			rdp.forward(request, response); 
		}
	}

}
