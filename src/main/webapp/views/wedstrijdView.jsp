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

<h2>aantal tickets beschikbaar: ${wedstrijd.tickets}</h2>
	<form:form
    method="POST"
    action="" modelAttribute="ticketform">
	<p><label>Email:</label>
        <form:input path="email" size = "20"/>
        <form:errors path="email" cssClass="error"/>
    </p>
	<p><label>Tickets:</label>
        <form:input path="tickets" value="1"/>
        <form:errors path="tickets" cssClass="error"/>
    </p>    
	<p><label>VoetbalCode1:</label>
        <form:input path="voetbalCode1" value="10"/>
        <form:errors path="voetbalCode1" cssClass="error"/>
    </p>
	<p><label>VoetbalCode2:</label>
        <form:input path="voetbalCode2" value="20"/>
        <form:errors path="voetbalCode2" cssClass="error"/>
    </p>
<%--        	 <form:errors path="*" cssClass="error"/> --%>
         <input type="submit" value="Submit"/>
        
	</form:form>

</body>
</html>