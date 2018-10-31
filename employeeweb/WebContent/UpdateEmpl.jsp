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
   <j:when test="${sessionScope.user != null and ${sessionScope.user=='admin'}">
    <h3 style="align:center">Username : <j:out value="${sessionScope.user}"></j:out> </h3>
    <form action="UpdateEmpl" method="post">
      Employee code:<input type="text" name="empcode" value="${employee.empcode}" readonly="readonly"><br>
      Employee name:<input type="text" name="empname" value="${employee.empname}"><br>
      Employee job:<input type="text" name="job" value="${employee.job}"><br>
      Employee sal:<input type="text" name="salary" value="${employee.salary}"><br>
      Employee dateofbirth:<input type="date" name="dateofbirth" value="${employee.dateOfBirth}"><br>
      <input type="submit">
    
   </form>
   </j:when>
   <j:otherwise>
      <j:out value="Not Authorized"></j:out>
   </j:otherwise>
   </j:choose>
   
 </body>
</html>