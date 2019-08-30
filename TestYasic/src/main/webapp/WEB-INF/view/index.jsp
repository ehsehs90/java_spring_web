<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#userimg {
	width: 25px;
	height: 25px;
}

#myimg {
	width: 25px;
	height: 25px;
}

header {
	height: 150px;
}

.title {
	font-size: 40px;
	position: absolute;
	left: 50px;
	top: 40px;
}

.search_window {
	display: inline-block;
	width: 466px;
	height: 34px;
	border: 3px solid blue;
	background: white;
	position: absolute;
	left: 250px;
	top: 60px;
}

.text {
	width: 380px;
	height: 21px;
	margin: 6px 0 0 9px;
	border: 0;
	line-height: 21px;
	font-weight: bold;
	font-size: 16px;
	outline: none;
}

.submit {
	width: 54px;
	height: 21px;
	margin: 0;
	border: 0;
	background: blue;
	color: white;
	font-weight: bold;
	border-radius: 1px;
	cursor: pointer;
	position: relative;
	left: 10px;
}

.submit:hover {
	background: black;
}

.mail_window {
	position: absolute;
	top: 30px;
	left: 750px;
}

.mail {
	
}

.mailcount {
	position: absolute;
	left: 50px;
	top: 0px;
}

.contact {
	position: absolute;
	top: 30px;
	left: 880px;
}

.profile {
	position: absolute;
	top: 30px;
	left: 1050px;
	width: 50px;
	height: 50px;
}

aside {
	float: left;
	width: 20%;
	height: 30em;
	background-color: #C4FDFF;
}

article {
	float: left;
	width: 60%;
	height: 30em;
	background-color: #C4FDFF;
}

table {
	width: 90%;
	margin: 5em auto;
	background-color: blue;
	text-align: center;
}

th {
	height: 20px;
	background-color: aqua;
}

td {
	height: 30px;
	background-color: #D9E5FF;
}

td:nth-child(2) {
	text-align: left;
}

td:nth-child(3) {
	width: 30%;
}

footer {
	clear: both;
	width: 100%;
	height: 5em;
	background-color: #B2CCFF;
}
}
</style>
</head>
<body>
	<header>
		<hgroup>
			<a href="${pageContext.request.contextPath}/index.do" class="title"><img
				src="./img/title.png"></a>
			<a href="${pageContext.request.contextPath}/logout.do"> 로그아웃</a>
			<span class='search_window'>
				<form action="${pageContext.request.contextPath}/search.do"
					method="get">
					<input type='text' class='text' name="condition" /> <input
						type="submit" value="검색" class="submit">
					</button>
				</form>
			</span>
			<span class='mail_window'> <a
				href="${pageContext.request.contextPath}/mailbox.do" class="mail"
				onclick="window.open(this.href, '_blank', 'width=400px,height=550px,toolbars=no,scrollbars=no'); return false;"><img
					src="./img/mail.png"></a> <a
				href="${pageContext.request.contextPath}/mailbox.do"
				class="mailcount"
				onclick="window.open(this.href, '_blank', 'width=400px,height=550px,toolbars=no,scrollbars=no'); return false;"><img
					src="./img/mailcount.png"></a>
			</span>
			<a href="${pageContext.request.contextPath}/contact.do"
				class="contact"
				onclick="window.open(this.href, '_blank', 'width=400px,height=550px,toolbars=no,scrollbars=no'); return false;"><img
				src="./img/contact.png" width=160 height=80></a>

			<a href="${pageContext.request.contextPath}/mypage.do"
				class="profile"
				onclick="window.open(this.href, '_blank', 'width=400px,height=550px,toolbars=no,scrollbars=no'); return false;"><img
				src="./img/profile.png" width=80 height=80></a>
		</hgroup>
	</header>
	<aside></aside>
	<article>
		<a href="${pageContext.request.contextPath}/fadd.do"
			onclick="window.open(this.href, '_blank', 'width=400px,height=550px,toolbars=no,scrollbars=no'); return false;">친구추가</a>
		<table>
			<tr>
				<td><img alt="노답"
					src="${pageContext.request.contextPath}/upload/${myview.img}"
					id="myimg"
					onclick="window.open('${pageContext.request.contextPath}/mypage.do', '_blank', 'width=400px,height=550px,toolbars=no,scrollbars=no'); return false;"></td>
				<th>${myview.name}</th>
				<td>${myview.why}</td>
				<td>${myview.stime}</td>
				<c:if test="${empty user.color}">
					<td><a href="${pageContext.request.contextPath}/checkbox.do"
						style="color: gray"
						onclick="window.open(this.href, '_blank', 'width=400px,height=550px,toolbars=no,scrollbars=no'); return false;">■</a></td>
				</c:if>
				<c:if test="${user.color=='1'}">
					<td><a href="${pageContext.request.contextPath}/checkbox.do"
						style="color: lime"
						onclick="window.open(this.href, '_blank', 'width=400px,height=550px,toolbars=no,scrollbars=no'); return false;">■</a></td>
				</c:if>
			</tr>
		</table>

		<table>
			<c:forEach var="user" items="${users}">
				<form>
					<tr>
						<input type="hidden" name="id" value="${user.id}">
						<td><img alt="노답"
							src="${pageContext.request.contextPath}/upload/${user.img}"
							id="userimg"
							onclick="window.open('${pageContext.request.contextPath}/yourpage.do', '_blank', 'width=400px,height=550px,toolbars=no,scrollbars=no'); return false;"></td>
						<th>${user.name}</th>
						<td><a href="${pageContext.request.contextPath}/sendmsg.do"
							onclick="window.open(this.href, '_blank', 'width=400px,height=550px,toolbars=no,scrollbars=no'); return false;">${user.why}</a></td>
						<td>${user.stime}</td>
						<c:if test="${empty user.color}">
							<td><a href="${pageContext.request.contextPath}/checkbox.do"
								style="color: gray"
								onclick="window.open(this.href, '_blank', 'width=400px,height=550px,toolbars=no,scrollbars=no'); return false;">■</a></td>
						</c:if>
						<c:if test="${user.color=='1'}">
							<td><a href="${pageContext.request.contextPath}/checkbox.do"
								style="color: lime"
								onclick="window.open(this.href, '_blank', 'width=400px,height=550px,toolbars=no,scrollbars=no'); return false;">■</a></td>
						</c:if>
					</tr>
				</form>
			</c:forEach>
		</table>
	</article>
	<aside></aside>
	<footer></footer>
</body>
</html>