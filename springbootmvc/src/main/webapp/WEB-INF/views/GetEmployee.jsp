<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    
   <%--  <s:form action="getemployee" >
       Employee code:<s:input path="empcode"/>
	   <input type="submit">
	   </s:form> 
	    --%>
	   
	   <table border="2" align="center">   
	      <tr>
		        <th>EMPCODE</th>
		        <th>EMPNAME</th>	        
		        <th>JOB</th>	   
		        <th>SALARY</th>
		        <th>DATE OF BIRTH</th>	        	      
	      </tr>
	      
	      <tr>
	      			<td><j:out value="${empls.empcode}"></j:out></td>
	      			<td><j:out value="${empls.empname}"></j:out></td>
	      			<td><j:out value="${empls.job}"></j:out></td>
	      			<td><j:out value="${empls.salary}"></j:out></td>
	      			<td><j:out value="${empls.dateOfBirth}"></j:out></td>
	      		</tr>	
	   </table>
	   
	     
</body>
</html>