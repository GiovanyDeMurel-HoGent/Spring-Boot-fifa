<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Wedstrijd placeholder</title>
</head>

<body>
<h2><%= request.getParameter("id")%></h2>
	
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