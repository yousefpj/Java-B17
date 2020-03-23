<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Management System</title>
</head>
<body>
	<h1 align="center">Book Management System</h1>
	<h2 align="center" ><a href="addBookForm">Add New Book</a>    <a href="list">List All Books</a></h2>

<div align="center">
	<table border=1>
	<tr>
		<th>ID</th>
		<th>Title</th>
		<th>Author</th>
		<th>Price</th>
		<th>Action</th>
	</tr>
	
	<c:forEach items ="${list}" var= "book">
		<tr>
			<td>${book.id}</td>
			<td>${book.title}</td>
			<td>${book.author}</td>
			<td>${book.price}</td>
			<td><a href="updateBookForm?id=${book.id}">Edit</a>   <a onclick="return confirm('Are you sure you want to delete this book?')" href="deleteBook?id=${book.id}">Delete</a></td>
		</tr>
	</c:forEach>
	
	</table>
</div>
	


</body>
</html>