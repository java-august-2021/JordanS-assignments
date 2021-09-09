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


<h1><c:out value="${category.name}"/></h1>

<h2>Add a product to this category:</h2>

<form:form action="/categories/${category.id}/addproduct">

<select name="prodId">
	<c:forEach items="${unaffiliatedProducts}" var="product">
		<option value="${product.id}"><c:out value="${product.name}"/></option>
	</c:forEach>
	</select>
	<input type="submit" value="Submit"/>
</form:form>

<h3>Products:</h3>

<c:forEach items="${affiliatedProducts}" var="product">
		<option value="${product.id}"><c:out value="${product.name}"/></option>
	</c:forEach>
<br>
<a href="/categories/new">Back</a>
</body>
</html>