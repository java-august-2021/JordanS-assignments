<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Create a Dojo!</h1>
<form:form action="/dojos/create" method="POST" modelAttribute="dojo">
	<form:label path="name">Dojo Name</form:label>
	<form:errors path="name"/>
	<form:input path="name"/>
	
	<input type="submit" value="Submit"/>
</form:form>

</body>
</html>