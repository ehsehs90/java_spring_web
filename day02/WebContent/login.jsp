<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>login</title>
</head>
<body>
	<h2>Login form</h2>
	<form id="form1" name="form1" action="login.do" 
	method="post">
		<table border="1">
			<tr>
				<td colspan="2">
					<span style="color:red">${msg}</span>
				</td>
			</tr>
			<tr>
				<td>ID</td>
				<td><input type="text" id="id" name="id" required="required"></td>
			</tr>
			<tr>
				<td>PW</td>
				<td><input type="password" id="pw" name="pw" 
				required="required">
				</td>
				<!-- pattern=".*(?=[a-z]).*" -->
				<!-- ((?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{3,8}) -->
			</tr>
			<tr align="center">
				<td colspan="2">
					<input type="submit" value="login">
					<input type="reset" value="cancle">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<a href="#">sign up</a>
				</td>
			</tr>
		</table>
		
	</form>
</body>
</html>