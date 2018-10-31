<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <s:form action="add" commandName="employee" method="post">
        Employee code:<s:input path="empcode"/><br>
        Employee name:<s:input path="empname"/><br>
        Employee Job:<s:input path="job"/><br>
        Employee salary:<s:input path="salary"/><br>
        Employee DOB(dd-mm-yyyy):<s:input path="dateOfBirth"/><br>
       <input type="submit">
    </s:form>
</body>
</html>