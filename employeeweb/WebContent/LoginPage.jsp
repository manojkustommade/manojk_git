<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>

</head>
<body> 
   <form action="LoginPage" method="get">
	<table border="0" align="center">
	   <tr><td><h1>Login Page</h1></td></tr>
	   <tr><td>username:<input type="text" name="uname" placeholder="Username"></td></tr><br>
	   <tr><td>password:<input type="password" name="pwd" placeholder="password"></td></tr><br>
	   <tr><td colspan="2" align=center><input type="submit"></td></tr>
	   <tr><td colspan="2" align=center><j:out value="${error}"></j:out></td></tr>
	 </table>  
   </form>	 
</body>
</html>