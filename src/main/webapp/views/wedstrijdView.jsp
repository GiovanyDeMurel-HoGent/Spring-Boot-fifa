<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Wedstrijd placeholder</title>
</head>

<body>

	<h2>${wedstrijd}</h2>
	<form:form
    method="POST"
    action="tickets" modelAttribute="wedstrijd">

    <table>
    <tr>
            <td><form:label path="">email:</form:label></td>
            <td><form:input path=""/></td>
        </tr>
        <tr>
            <td><form:label path="">aantalTickets:</form:label></td>
            <td><form:input path=""/></td>
        </tr>
        <tr>
            <td><form:label path="">voetbalCode1:</form:label></td>
            <td><form:input path=""/></td>
        </tr>
        <tr>
            <td><form:label path="">voetbalCode2:</form:label></td>
            <td><form:input path=""/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>

</body>
</html>