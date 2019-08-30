<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3 style="color:red">${msg}</h3>
	<form action="${pageContext.request.contextPath}/fadd.do" method="post">
		<input type='text' class='text' name="fid" />
		<button type='submit' class='submit'>추가</button>
	</form>



</body>
</html>