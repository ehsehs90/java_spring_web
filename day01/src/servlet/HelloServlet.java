package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns = { "/Hello", "/hello.do" }, loadOnStartup = 1)
@WebServlet({ "/Hello", "/hello.do" })
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public HelloServlet() {
		System.out.println("HelloServlet Construct");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("HelloServlet => init");
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		System.out.println("HelloServlet => doGet service : "+Thread.currentThread().getName());
		PrintWriter out = response.getWriter(); 
		out.print("<h1>HelloServlet page입니다.</h1>");
		
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		if(name != null)
			out.print("<h3>당신의 이름은 : "+name.charAt(0)+"**</h3>");
		out.print("<h3>당신의 주소는 : "+addr+"</h3>");
	}
	/*
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HelloServlet => doPost service"+Thread.currentThread().getName());
		doGet(request, response);
	}*/
	
	@Override
	public void destroy() {
		System.out.println("HelloServlet => destroy");
	}

}
