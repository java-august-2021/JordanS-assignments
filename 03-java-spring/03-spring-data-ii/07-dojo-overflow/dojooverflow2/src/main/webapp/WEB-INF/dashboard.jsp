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

<h1>Questions Dashboard</h1>

<table>
    <thead>
        <tr>
            <th>Question</th>
            <th>Tags</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${questions}" var="question">
        <tr>
            <td><a href="/question/${question.id}"><c:out value="${question.body}"/></a></td>
        	<td><c:forEach items="${question.tags}" var="tag">
<c:out value="${tag.subject}"></c:out>
</c:forEach></td>
        </tr>
        </c:forEach>
    </tbody>
</table>

<h3><a href="/question/new">Create New Question</a></h3>

</body>
</html>