<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FIFA</title>
</head>
<body>

	<h3>${aantalGekochteTickets}</h3>
	<H2>${stadiumList}</H2>
	
	 <form:form method="POST" action="fifa"
		modelAttribute="stadium">
		
 	<form:select path="stadium_id"
		multiple="false">
<!-- itemValue="stadium_id" -->
	<form:options items="${stadiumList}" itemLabel="name" itemValue="stadium_id"/>
	</form:select>
	<input type="submit" value="OK"/>
	</form:form>
	
	

</body>
</html>