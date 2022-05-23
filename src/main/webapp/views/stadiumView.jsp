<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Stadium placeholder</title>
</head>

<body>
	<h2>${stadium.name}</h2>
	<p>Lijst van wedstrijden in dit stadium:<p>
	<br>	
	<c:forEach var="wedstrijd" items="${wedstrijden}">
		<li>
			<c:url value="http://localhost:8080/${stadiumUrlName}/${wedstrijd.land1}-${wedstrijd.land2}"
			 var="wedstrijdUrl"
			 scope="page"
			 >
			<c:param name="id" value="${wedstrijd.wedstrijd_id}"></c:param>
		</c:url>
		<h4><a href="${wedstrijdUrl}">${wedstrijd.wedstrijd_id}</a></h4>
		</li>

	</c:forEach>

</body>
</html>
