<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
<body>

<h2 align="center">로그인</h2>
<form id="fomr1" name="form1"  action="login.do" method="post" >
    <table border="1" align="center">
       <tr>
          <td colspan="2">
      	<span style="color:red" align="right">${msg}</span>  
          </td>
       </tr>
    
       <tr>
          <td>ID</td>
          <td><input type="text" id="id" name="id" required="required"></td>
       </tr>
       <tr>
          <td>PW</td>
          <td><input type="text" id="pw" name="pw" 
                  required="required"></td>
       </tr>
       <tr align="center">
          <td colspan="2">
             <input type="submit" value="로그인" >
             <input type="reset" value="취소">
          </td>
       </tr>
       <tr>
          <td colspan="2">
             <a href="${pageContext.request.contextPath}/add.do"> 회원가입</a>
          </td>
       </tr>
    </table>
</form>
    
</body>
</html>
</body>
</html>