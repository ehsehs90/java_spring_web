<%@page import="vo.BookVO"%>
<%@page import="java.util.List"%>
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
	<table>
		<tr>
			<th>bookno</th>
			<th>title</th>
			<th>author</th>
			<th>price</th>
			<th>pubdate</th>
		</tr>
	<% 
		List<BookVO> list = (List<BookVO>)request.getAttribute("list");
		for(BookVO b :list){
	%>
			<tr>
				<td><%= b.getBookno() %></td>
				<td><%= b.getTitle() %></td>
				<td><%= b.getAuthor() %></td>
				<td><%= b.getPrice() %></td>
				<td><%= b.getPubdate() %></td>
			</tr>
	<%
		}
	%>
		</table>	
	

</body>
</html>