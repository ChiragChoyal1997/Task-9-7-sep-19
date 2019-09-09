<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Book Entry Form</h2>
	<form action="BookEntry" method="get">
	<table>
	<tr><td>Title</td><td><input type="text" name="title"></td></tr>
	<tr><td>Author</td><td><input type="text" name="author"></td></tr>
	<tr><td>Edition</td><td><input type="text" name="edition"></td></tr>
	<tr><td>Price</td><td><input type="text" name="price"></td></tr>
	<tr><td></td><td><input type="submit" name="submit"></td></tr>
	</table>
	</form>
	<hr>
	<a href="/BookSale/index.jsp">Back to Home</a>
</body>
</html>