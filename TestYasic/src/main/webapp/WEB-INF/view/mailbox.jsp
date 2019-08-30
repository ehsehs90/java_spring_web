<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mailbox</title>

<style>
.name{
	font-size: 40px;
}


</style>


</head>
<body>
	<a href="#" class="title"><img src="./img/title.png"></a>
	<a class="name">이름</a>
	<table>
		<tr>
			<th><img id="img" src="${pageContext.request.contextPath}/img/profile.png" width=30 height=30/></th>
			<th>친구</th>
			<th>상태메세지</th>
			<th>yes</th>
			<th>no</th>
		</tr>
	</table>
</body>
</html>