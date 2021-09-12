<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h1>What is your question?</h1>
 
 <form:form action="/question/create" method = "POST" modelAttribute="question">
 	<form:label path = "body"></form:label>
 	<form:errors path="body"/>
 	<form:textarea path="body" rows="5" cols="40"/>
 	<br>
 	<form:label path="tagQuery">Tags: (must be comma separated)</form:label>
	<form:errors path="tagQuery"/>
	<form:input path="tagQuery"/>
	
	<input type="submit" value="Submit"/>
</form:form>

</body>
</html>