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
			<a href="http://localhost:8080/${stadiumUrlName}/${wedstrijd.land1}-${wedstrijd.land2}">
				${wedstrijd.wedstrijd_id}
			</a>${wedstrijd.land1} ${wedstrijd.land2} ${wedstrijd.datetime} ${wedstrijd.datum}  ${wedstrijd.aftrap} ${wedstrijd.tickets}</li>
	</c:forEach>

</body>
</html>