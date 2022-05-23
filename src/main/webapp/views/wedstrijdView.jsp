<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<spring:url value="/css/style.css" var="urlCss"/>
<link rel="stylesheet" href="${urlCss}" type="text/css" />
<title>Wedstrijd placeholder</title>
</head>

<body>

<%-- 	<h2>${wedstrijd}</h2> --%>
	<form:form
    method="POST"
    action="" modelAttribute="ticketform">
	<p><label>Email:</label>
        <form:input path="email" size = "20"/>
    </p>
	<p><label>Tickets:</label>
        <form:input path="tickets"/>
    </p>    
	<p><label>VoetbalCode1:</label>
        <form:input path="voetbalCode1"/>
    </p>
	<p><label>VoetbalCode2:</label>
        <form:input path="voetbalCode2"/>
    </p>
       	 <form:errors path="*" cssClass="error"/>
         <input type="submit" value="Submit"/>
        
	</form:form>

</body>
</html>