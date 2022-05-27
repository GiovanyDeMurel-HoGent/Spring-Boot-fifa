<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<spring:url value="/css/style.css" var="urlCss"/>
<link rel="stylesheet" href="${urlCss}" type="text/css" />
<title>FIFA</title>
</head>
<body>
	<spring:message code="label.test" var="test"/>
	<spring:message code="label.welcome" var="welcome"/>
	<spring:message code="stadium.logout" var="logout"/>
	
	
	
<%-- 	<H3>${welcome}</H3> --%>
	<div class="displayBox">
	<h2>${aantalGekochteTickets}</h2>
	 <form:form method="POST" action="fifa"
		modelAttribute="stadium">
		
 	<form:select class="dropdown" path="stadium_id"
		multiple="false">
<!-- itemValue="stadium_id" -->
	<form:options class="dropdownItem" items="${stadiumList}" itemLabel="name" itemValue="stadium_id"/>
	</form:select>
	<input class="fifaButton" type="submit" value="OK"/>
	</form:form>
	<form action='logout' method='post'>
	<input class="fifaButton" type="submit" value="${logout}" />
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>  
	</form>
	</div>
	

</body>
</html>