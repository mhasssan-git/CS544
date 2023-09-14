<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Books currently in the library</title>
</head>

<body>
<h1>Books currently in the library</h1>
<table>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.getTitle()}</td>
            <td>${book.getISBN()}</td>
            <td>${book.getAuthor()}</td>
            <td>${book.getPrice()}</td>
            <sec:authorize access="hasRole('ADMIN')">
                <td><a href="books/${book.getId()}">edit</a></td>
            </sec:authorize>
            <sec:authorize access="hasRole('USER')">
                <td><a href="books/view/${book.getId()}">view</a></td>
            </sec:authorize>

        </tr>
    </c:forEach>
</table>

<sec:authorize access="hasRole('ADMIN')">
<a href="books/add"> Add a Book</a>
</sec:authorize>
<a href="logout">Logout</a>
</body>

</html>