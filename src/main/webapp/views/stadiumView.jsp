<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<spring:url value="/css/style.css" var="urlCss"/>
<link rel="stylesheet" href="${urlCss}" type="text/css" />
<title>Stadium</title>
</head>

<body>
	<spring:message code="stadium.listofgames" var="listofgames"/>
	<spring:message code="stadium.logout" var="logout"/>
	<spring:message code="ticketform.availabletickets" var="available"/>
	<spring:message code="ticketform.availabletickets" var="available"/>
	
	<div class="displayBox">
	<h2>${stadium.name}</h2>
	<p>${listofgames}<p>
	<ul>
	<c:forEach var="wedstrijd" items="${wedstrijden}">
		<li>
			<c:url value="http://localhost:8080/fifa/${stadiumUrlName}/${wedstrijd.land1}-${wedstrijd.land2}"
			 var="wedstrijdUrl"
			 scope="page"
			 >
			<c:param name="id" value="${wedstrijd.wedstrijd_id}"></c:param>
			</c:url>
		<a href="${wedstrijdUrl}">
			${wedstrijd.wedstrijd_id}   ${wedstrijd.land1}-${wedstrijd.land2} ${wedstrijd.datum} ${wedstrijd.aftrap} ${wedstrijd.tickets}
		</a>
		
		</li>
	</c:forEach>
	</ul>
	</div>
</body>
</html>
