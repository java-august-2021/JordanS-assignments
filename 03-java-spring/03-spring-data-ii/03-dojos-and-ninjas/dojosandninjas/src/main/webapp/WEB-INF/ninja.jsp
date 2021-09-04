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

<h1>Add a Ninja!</h1>
<form:form action="/ninjas/create" method="POST" modelAttribute="ninja">
	Location: 
	<select name="dojo">
	<c:forEach items="${dojos}" var="dojo">
		<option value=<c:out value="${dojo.id}"/>><c:out value="${dojo.name}"/></option>
	</c:forEach>
	</select>
	<br>
	
	<form:label path="firstName">First Name</form:label>
	<form:errors path="firstName"/>
	<form:input path="firstName"/>
	<br>
	<form:label path="lastName">Last Name</form:label>
	<form:errors path="lastName"/>
	<form:input path="lastName"/>
	<br>
	<form:label path="age">Age</form:label>
	<form:errors path="age"/>
	<form:input path="age"/>
	<br>
	<input type="submit" value="Submit"/>
</form:form>

</body>
</html>