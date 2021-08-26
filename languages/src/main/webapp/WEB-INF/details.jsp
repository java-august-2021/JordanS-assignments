<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

Name: <c:out value = "${language.name}"/>
<br>
Creator: <c:out value = "${language.creator}"/>
<br>
Current Version: <c:out value = "${language.currentVersion}"/>
<br>
<a href = "/languages/edit/<c:out value="${language.id}"/>">edit</a>

<form action="/languages/${language.id}" method="post">
<input type="hidden" name="_method" value="delete">
<input type="submit" value="Delete">
</form>

<br>
<a href="/languages">Home</a>

</body>
</html>