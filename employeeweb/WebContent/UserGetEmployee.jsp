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
   <j:when test="${sessionScope.user != null}">
   <h3 style="align:center">Welcome to : <j:out value="${sessionScope.user}"></j:out> </h3> 
   <a href="Logout">Logout</a>
    <j:set var="emp" value="${employee}"></j:set>
    <form action="UserGetEmployee" method="get">
    <table border="2" align="center">
        <tr>
        <td>Employee Code :</td><td><input type="text" name="empcode"></td></tr>
        
        <tr><td colspan="2" align=center> <input type="submit" ></td></tr>
    	<tr>
    	  <th>EMPCODE</th>
    	  <th>EMPNAME</th>	        
		  <th>JOB</th>	   
		  <th>SALARY</th>
		  <th>DATE OF BIRTH</th>	
		</tr>
		
		<tr>
		 
		 <td><j:out value="${emp.empcode}"></j:out></td>
		 <td><j:out value="${emp.empname}"></j:out></td>
		 <td><j:out value="${emp.job}"></j:out></td>
         <td><j:out value="${emp.salary}"></j:out></td>
	     <td><j:out value="${emp.dateOfBirth}"></j:out></td>
	      			
		 
		</tr>     
    </table>
    <a href="Logout">Logout</a>
    <a href="UserHomePage.jsp">return</a>
     </form>
     </j:when>
     <j:otherwise>
         <j:out value="Not authorised"></j:out>
     </j:otherwise>
     </j:choose>
   
</body>
</html>