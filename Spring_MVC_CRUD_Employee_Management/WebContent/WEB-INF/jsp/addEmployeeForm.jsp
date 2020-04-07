<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Add Employee Form</h1>
	
	<form:form method="post" action="addEmployee">
		<table>
			<tr> Name: <form:input path="name"/> </tr>
			<tr> Designation: <form:input path="designation"/> </tr>
			<tr> Salary: <form:input path="salary"/> </tr>
			<tr> <input type="submit" value="Submit"></input>  </tr>
		</table>
		
	
	</form:form>
</body>
</html>