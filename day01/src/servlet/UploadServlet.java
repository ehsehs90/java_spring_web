package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet({ "/UploadServlet", "/upload.do" })
@MultipartConfig(location = "c:/upload", maxFileSize = 1024 * 1024 * 5)
/* 파일 업로드를 처리하기 때문에 붙여주는 애너테이션 */
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();

		String path = "c:/upload";
		File isDir = new File(path);
		if (!isDir.isDirectory()) {
			isDir.mkdir();
		}

		Collection<Part> parts = request.getParts();
		for (Part p : parts) {
			if (p.getContentType() != null) {
				String filename = p.getSubmittedFileName();
				if (filename != null) {
					p.write(filename);
					out.print("<h3>업로드한 파일 이름 : " + filename + "</h3>");
					out.print("<h3>업로드한 파일 크기 : " + p.getSize() / 1024 + "KB</h3>");
				}
			} else {
				out.print("<h3>파일이 선택되지 않았습니다.</h3>");
			}
		}

	}

}
