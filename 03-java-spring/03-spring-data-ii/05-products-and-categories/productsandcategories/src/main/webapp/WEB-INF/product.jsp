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

<h1><c:out value="${product.name}"/></h1>

<h2>Add a category to this product:</h2>

<form:form action="/products/${product.id}/addcategory">

<select name="catId">
	<c:forEach items="${unaffiliatedCategories}" var="category">
		<option value="${category.id}"><c:out value="${category.name}"/></option>
	</c:forEach>
	</select>
	<input type="submit" value="Submit"/>
</form:form>

<h3>Categories:</h3>

<c:forEach items="${affiliatedCategories}" var="category">
		<option value="${category.id}"><c:out value="${category.name}"/></option>
	</c:forEach>
<br>
<a href="/products/new">Back</a>

</body>
</html>