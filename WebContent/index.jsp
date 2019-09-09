<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Welcome to dashboard</h2>
<hr>
<a href="BookEntry.jsp">Book Entry</a>
<br>
<br>
<a href="FeaturedBooks">Some featured Books</a>
<br>
<br>
<form action="BookSearch" method="get">
<input type="text" name="search" placeholder="Search Book Here...">
<input type="submit" name="Search">
</form>
</body>
</html>