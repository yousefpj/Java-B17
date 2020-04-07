<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome to the Employee Management System</h1>
	<a href="listEmployees">List Employees</a> <br>
	<a href="index.jsp">Go Back</a> <br>
	<a href="addEmployeeForm">Add Employee</a>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Designation</th>
			<th>Salary</th>
			<th>Action</th>
		</tr>
		
		<c:forEach items ="${employeeList}" var= "employee">
		<tr>
			<td>${employee.id }</td>
			<td>${employee.name }</td>
			<td>${employee.designation }</td>
			<td>${employee.salary }</td>
			<td><a href="editEmployeeForm/${employee.id}">Edit</a> <a onclick="return confirm('do you want to delete this employee?')" href="deleteEmployee/${employee.id}">Delete</a></td>
		</tr>
		</c:forEach>
		
	</table>
</body>
</html>