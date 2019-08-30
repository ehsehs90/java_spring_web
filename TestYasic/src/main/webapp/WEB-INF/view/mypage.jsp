<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	#editinfo {
	position: absolute;
	
	left: 200px;
	top: 10px;
	}

	#logout {
	position: absolute;
	
	left: 270px;
	top: 10px;
	}

	.light{
		position: absolute;
		left: 300px;
		top: 280px;
	}

</style>


</head>
<body>
		
	<div>
		<span id="editinfo"><a href="${pageContext.request.contextPath}/fix.do"> 정보수정</a> </span> 
		<img id="img" src="${pageContext.request.contextPath}/upload/${user.img}" width=350 height=275/> 
		<span id="logout"><a href="${pageContext.request.contextPath}/logout.do"> 로그아웃</a> </span>
	</div>
	
	
	
	<a class="name">${user.name}</a>
	<a class="hashtag">${check.why}</a>
	<a class="light"><img src="./img/mailcount.png" width=30 height=30></a>
	<p class="message">${check.msg}</p>
</body>
</html>