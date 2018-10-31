<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <j:choose >
<j:when test="${sessionScope.user != null and sessionScope.user != 'admin'}">
<h3 style="align:center">Welcome : <j:out value="${sessionScope.user}"></j:out> </h3>
    <Table align="center" border="2">
    
    	<nav align="left"><a href="LoginPage.jsp">Logout</a></nav>
    	<a href="UserGetEmployee.jsp">GetEmployee</a><br>
    	<a href="ViewEmpls?name=view">ViewAllEmployees</a>
    	
    </Table>
    </j:when>
       <j:otherwise>
          <j:out value="Not authorised"></j:out>
       </j:otherwise>
    </j:choose>
</body>
</html>