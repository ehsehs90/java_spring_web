<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error.jsp</title>
</head>
<body>
	<% Exception e = (Exception)request.getAttribute("exception"); %>
	<h2>Error Page</h2>
	<h3 style="color:red">서버 점검중입니다.</h3>
	<div style="color:red"><%= e.getMessage() %></div>
</body>
</html>