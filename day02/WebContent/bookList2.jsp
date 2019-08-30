<%@page import="vo.BookVO"%>
<%@page import="java.util.List"%>
<%@page import="service.BookServiceImpl"%>
<%@page import="service.BookService"%>
<%@page import="dao.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="./css/table.css">
</head>
<body>
	<h1>Book List</h1>
	<% 
		BookDAO dao = new BookDAO();
		BookService service = new BookServiceImpl(dao);
		List<BookVO> list = service.bookList();
		int size = list.size();
	%>
	<table>
		<tr>
			<th>bookno</th>
			<th>title</th>
			<th>author</th>
			<th>price</th>
			<th>pubdate</th>
		</tr>
	<% 
		for(int i = 0; i < size; i++){
	%>
			<tr>
				<td><%= list.get(i).getBookno() %></td>
				<td><%= list.get(i).getTitle() %></td>
				<td><%= list.get(i).getAuthor() %></td>
				<td><%= list.get(i).getPrice() %></td>
				<td><%= list.get(i).getPubdate() %></td>
			</tr>
	<%
		}
	%>
		</table>	
	

</body>
</html>