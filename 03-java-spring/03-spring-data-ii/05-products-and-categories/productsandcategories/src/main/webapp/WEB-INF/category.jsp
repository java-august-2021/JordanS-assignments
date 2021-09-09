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

<h1> All Categories </h1>
<table>
    <thead>
        <tr>
            <th>Name</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${categories}" var="category">
        <tr>
            <td><a href="/categories/${category.id}"><c:out value="${category.name}"/></a></td>
        </tr>
        </c:forEach>
    </tbody>
</table>

<h1>New Category</h1>
	<form:form action="/categories/create" method="POST" modelAttribute="category">
	<form:label path="name">Name</form:label>
	<form:errors path="name"/>
	<form:input path="name"/>
	
	<input type="submit" value="Submit"/>
</form:form>

<br>

<a href="/products/new">Back</a>
</body>
</html>