<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/survey" method="POST">
		<p>Name: <input type="text" name="name"></p>
		<p>Location: <select name="location">
			<option value="Online">Online</option>
			<option value="Seattle">Seattle</option>
			<option value="Denver">Denver</option>
		</select></p>
		<p>Favorite Language: <select name="favoriteLanguage">
			<option value="Python">Python</option>
			<option value="Java">Java</option>
			<option value="HTML">HTML</option>
			<option value="C++">C++</option>
		</select></p>
		<p>Comments:<textarea rows="10" cols="30" name="comments"></textarea></p>
		<button>Submit!</button>
	</form>
</body>
</html>