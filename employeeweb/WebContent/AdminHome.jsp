<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <j:choose>
   <j:when test="${sessionScope.user != null  and sessionScope.username == 'admin'}">
       <h3 style="align:center">Welcome to : <j:out value="${sessionScope.username}"></j:out> </h3> 
  <table align="center">
    <tr><td align=center><h2>Welcome to Admin</h2></td></tr>
    <tr><td align=center><a href="AddEmployee.jsp">AddEmployee</a></td></tr><br>
   <tr><td align=center><a href="ViewEmpls?name=update">UpdateEmployee</a></td></tr><br>
   <tr><td align=center><a href="ViewEmpls?name=delete">DeleteEmployee</a></td></tr><br>
   <tr><td align=center><a href="ViewEmpls?name=view">ViewEmployee</a></td></tr><br>
   <tr><td align=center><a href="Logout">Logout</a></td></tr>
   </table>
   </j:when>
   <j:otherwise>
    <j:out value="not authorised"></j:out>
   </j:otherwise>
   </j:choose>
 </body>
</html>