<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="./css/table.css">
<script>
	function del(){
		
	}
</script>
</head>
<body>
	<h1>Book List</h1>
	<h3>로그인 정보 : ${login}</h3>
	<a href="./logout.do">Logout</a>
	<a href="./index.jsp">Home</a>
	<form action="./delete.do" method="get">
	<table>
		<tr>
			<th>bookno</th>
			<th>title</th>
			<th>author</th>
			<th>price</th>
			<th>pubdate</th>
			<th><input type="submit" value="삭제"></th>
		</tr>
		<c:forEach var="book" items=${list}>
		<tr>
			<td>${book.bookno}</td>
			<td>${book.title}</td>
			<td>${book.author}</td>
			<td>${book.price}</td>
			<td>${book.pubdate}</td>
			<td><input type="checkbox" name="del" value=${book.bookno}></td>
		</tr>
		</c:forEach>
	</table>
	</form>
</body>
</html>