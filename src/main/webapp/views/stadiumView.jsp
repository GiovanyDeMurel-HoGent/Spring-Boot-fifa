<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Beer Selection Advice</title>
</head>

<body>
	<h2>${stadium.name}</h2>
	<p>Lijst van wedstrijden in dit stadium:<p>
	<br>	
	<c:forEach var="wedstrijd" items="${wedstrijden}"><br>${wedstrijd}</c:forEach>

</body>
</html>