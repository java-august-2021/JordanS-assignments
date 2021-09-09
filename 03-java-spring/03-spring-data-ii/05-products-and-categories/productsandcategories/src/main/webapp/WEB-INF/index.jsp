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

<h1> All Products </h1>
<table>
    <thead>
        <tr>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${products}" var="product">
        <tr>
            <td><a href="/products/${product.id}"><c:out value="${product.name}"/></a></td>
            <td><c:out value="${product.description}"/></td>
            <td><c:out value="${product.price}"/></td>
        </tr>
        </c:forEach>
    </tbody>
</table>

<h1>Add a Product</h1>
	<form:form action="/products/create" method="POST" modelAttribute="product">
	<form:label path="name">Name</form:label>
	<form:errors path="name"/>
	<form:input path="name"/>
	
	<form:label path="description">Description</form:label>
	<form:errors path="description"/>
	<form:input path="description"/>
	
	<form:label path="price">Price</form:label>
	<form:errors path="price"/>
	<form:input path="price"/>
	
	<input type="submit" value="Submit"/>
</form:form>
<br>
<br>
<h1><a href="/categories/new">Go to Categories</a></h1>
</body>
</html>