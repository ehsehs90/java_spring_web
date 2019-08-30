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
		<h3>you</h3>
<%-- 	<div>
		<img alt="노답" id="img" src="${pageContext.request.contextPath}/upload/${user.img}" width=350 height=275/> 
	</div> --%>
	
	<%-- <a class="name">${user.name}</a> --%>
	<a class="hashtag">${check.why}</a>
	<%-- <p class="message">${check.msg}</p> --%>
</body>
</html>