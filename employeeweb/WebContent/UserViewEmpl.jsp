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
<j:when test="${sessionScope.username != null}">
<h3 style="align:center">Username : <j:out value="${sessionScope.username}"></j:out> </h3>
     <form action="UserViewEmpl" method="get">
      <a href="Logout">Logout</a>
	  <table border="2" align="center">
	      
	      <tr>
		        <th>EMPCODE</th>
		        <th>EMPNAME</th>	        
		        <th>JOB</th>	   
		        <th>SALARY</th>
		        <th>DATE OF BIRTH</th>	        	      
	      </tr>
	      <j:forEach var="empls" items="${emp}">
	      		<tr>
	      			<td><j:out value="${emp.empcode}"></j:out></td>
	      			<td><j:out value="${emp.empname}"></j:out></td>
	      			<td><j:out value="${emp.job}"></j:out></td>
	      			<td><j:out value="${emp.salary}"></j:out></td>
	      			<td><j:out value="${emp.dateOfBirth}"></j:out></td>
	      		</tr>	
	      </j:forEach>
	      <tr><td align="center"><a href="UserHomePage.jsp">Back</a></td></tr>
	</table>
  </form>
  </j:when>
  <j:otherwise>
     <h1>Not Authorized</h1>
  </j:otherwise>
 </j:choose> 
</body>
</html>