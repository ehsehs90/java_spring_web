<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
header {
	width: 100%;
	height: 5em;
	background-color: lime;
}
form.search{
	display: inline-block;
	width: 30%;
}
#search{
	width: 80%;
	display: inline-block;
}
#submit{
	display: inline-block;
}
aside {
	float: left;
	width: 20%;
	height: 30em;
	background-color: blue;
}
article {
	float: left;
	width: 60%;
	height: 30em;
	background-color: green;
}
table {
	width: 90%;
	margin: 5em auto;
	background-color: red;
}
td {
	border: 1px solid black;
	background-color: yellow;
}
td:nth-child(3) {
	width: 60%;
}
footer{
	clear: both;
	width: 100%;
	height: 5em;
	background-color: black;
}
}
</style>
</head>
<body>
	<header>
		<a href="#">URI(titleImage)</a>
		<form class="search">
			<input type="search" name="keyword" id="search" value="검색">
			<input type="submit" id="submit">
		</form>
		<button>메일</button>
		<button>개인정보</button>
	</header>
	<aside></aside>
	<article>
		<table>
			<tr>
				<td>사진</td>
				<td>이름</td>
				<td>해시태그</td>
				<td><a href="#">라이트</a></td>
			</tr>
			<c:forEach var="user" items="${users}">
				<tr>
					<td>${user.img}</td>
					<td>${user.name}</td>
					<td>${user.age}</td>
					<td>${user.sex}</td>
				</tr>
			</c:forEach>
		</table>
	</article>
	<aside></aside>
	<footer></footer>
</body>
</html>