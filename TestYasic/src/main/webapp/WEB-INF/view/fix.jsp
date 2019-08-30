<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
td:nth-child(odd) {
	text-align: center;
	background-color: #8BBDFF;
}

td:nth-child(even) {
	background-color: #ffffff;
}

#last {
	background-color: #ffffff;
}

td {
	padding-left: 5px;
}
</style>

</head>
<body>

	<h2>회원정보수정</h2>
	<!-- modify Form  -->
	<form name="f" method="post" action="">
		<table border="0" cellpadding="0" cellspacing="1" width="350"
			bgcolor="BBBBBB">
			<tr>
				<td>휴대폰번호</td>
				<td><input type="text" name="id" value="${user.id}" readonly>
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value="${user.name}">
				</td>
			</tr>
			<tr>
				<td>성별</td>
				<td><input type="radio" name="sex" checked="checked"
					value="남">남 <input type="radio" name="sex" value="여">여
					<input type="radio" name="sex" value="기타">기타</td>
			</tr>
			<tr>
				<td>나이</td>
				<td><input type="number" min="10" max="99" name="age" value="${user.age}">
				</td>
			</tr>
			<tr>
				<td>프로필</td>
				<td><input type="file" name="file"></td>
			</tr>

		</table>
	</form>
	<br>

	<table width=300 border=0 cellpadding=0 cellspacing=0>
		<tr>
			<td id="last" align=center><input type="button" value="수정"
				onClick="userModify()"> &nbsp; <input type="button"
				value="취소" onClick="userList()"></td>
		</tr>
	</table>




</body>
</html>