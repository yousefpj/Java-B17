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
	
	
	<c:if test="${book.id == null}">
		<form action="insertBook" >
		<h1>Add Book Form</h1>
	</c:if>
	
	<c:if test="${book.id != null}">
		<form action="updateBook" >
		<h1>Update Book Form</h1>
	</c:if>
	
		<table>
		
			<tr>
				<td><input type="hidden" name="id" value="${book.id}"></input> </td>
			</tr>
			<tr>
				<td>Title: <input type="text" name="title" value="${book.title}"></input> </td>
			</tr>
			<tr>
				<td>Author: <input type="text" name="author" value="${book.author}"></input> </td>
			</tr>
			<tr>
				<td>Price: <input type="text" name="price" value="${book.price}"></input> </td>
			</tr>
			<tr>
			<c:if test="${book.id == null}">
				<td><input type="submit" name="submit"></input></td>
			</c:if>
			
			<c:if test="${book.id != null}">
				<td><input type="submit" name="udpate" value="update"></input></td>
			</c:if>	
			
			
			
			
			</tr>
		</table>
	</form>
</body>
</html>