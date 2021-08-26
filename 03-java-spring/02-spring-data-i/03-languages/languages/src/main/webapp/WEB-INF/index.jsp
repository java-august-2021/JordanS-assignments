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
 <table>
    <thead>
        <tr>
            <th>Name</th>
            <th>Creator</th>
            <th>Current Version</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${languages}" var="language">
        <tr>
            <td><a href = "/languages/<c:out value="${language.id}"/>"><c:out value ="${language.name}"/></a></td>
            <td><c:out value="${language.creator}"/></td>
            <td><c:out value="${language.currentVersion}"/></td>
            
            <td><form action="/languages/${language.id}" method="post">
            <input type="hidden" name="_method" value="delete">
            <input type="submit" value="Delete">
            </form></td>
            <td><a href = "/languages/edit/<c:out value="${language.id}"/>">edit</a></td>
            
        </tr>
        </c:forEach>
    </tbody>
</table>

<form:form action="/languages" method="post" modelAttribute="lang">
    <p>
        <form:label path="name">Name</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="creator">Creator</form:label>
        <form:errors path="creator"/>
        <form:textarea path="creator"/>
    </p>
    <p>
        <form:label path="currentVersion">Current Version</form:label>
        <form:errors path="currentVersion"/>
        <form:input path="currentVersion"/>
    </p>  
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>