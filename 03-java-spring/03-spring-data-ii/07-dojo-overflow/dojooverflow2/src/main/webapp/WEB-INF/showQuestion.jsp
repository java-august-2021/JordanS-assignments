<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2><c:out value="${question.body}"/></h2>
<br>
Tags: <c:forEach items="${question.tags}" var="tag">
<c:out value="${tag.subject}"></c:out>
</c:forEach>
<br>
Answers: <c:forEach items="${question.answers}" var="answer">
<c:out value="${answer.body}"></c:out>
</c:forEach>
<br>

Add your answer!

 <form:form action="/question/${question.id}/answer" method = "POST" modelAttribute="answer">
 
 	<form:label path = "body"></form:label>
 	<form:errors path="body"/>
 	<form:textarea path="body" rows="5" cols="40"/>
 	<form:hidden path = "question" value = "${question.id}"/>
	<input type="submit" value="Submit"/>
	
</form:form>

<a href="/">Dashboard</a>

</body>
</html>