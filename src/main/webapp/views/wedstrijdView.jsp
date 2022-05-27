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
<title>Wedstrijd</title>
</head>

<body>
<spring:message code="ticketform.availabletickets" var="available"/>
<spring:message code="ticketform.label.email" var="email"/>
<spring:message code="ticketform.label.tickets" var="tickets"/>
<spring:message code="ticketform.label.footballCode1" var="code1"/>
<spring:message code="ticketform.label.footballCode2" var="code2"/>
<spring:message code="ticketform.button.submit" var="submit"/>

<div class="wedstrijdDisplayBox">
<h2>${available}${wedstrijd.tickets}</h2>
<br>
	<form:form
    method="POST"
    action="" modelAttribute="ticketform">
	<p><label>${email}</label>
        <form:input class="inputField" path="email" size = "20"/>
        <form:errors path="email" cssClass="error"/>
    </p>
	<p><label>${tickets}</label>
        <form:input path="tickets" value="1"/>
        <form:errors path="tickets" cssClass="error"/>
    </p>    
	<p><label>${code1}</label>
        <form:input path="voetbalCode1" value="10"/>
        <form:errors path="voetbalCode1" cssClass="error"/>
    </p>
	<p><label>${code2}</label>
        <form:input path="voetbalCode2" value="20"/>
        <form:errors path="voetbalCode2" cssClass="error"/>
    </p>
<%--        	 <form:errors path="*" cssClass="error"/> --%>
<br>
         <input class="fifaButton" type="submit" value="${submit}" />
        
	</form:form>
</div>
</body>
</html>