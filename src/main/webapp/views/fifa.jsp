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
	
	<H2>${stadiumList}"</H2>
	
	 <form:form method="POST" action="stadium"
		modelAttribute="stadiumList">
		
 	<form:select path=""
		multiple="false">

	<form:options items="${stadiumList}"/>
	</form:select>
	<input type="submit" value="OK"/>
	</form:form>
	
	

</body>
</html>