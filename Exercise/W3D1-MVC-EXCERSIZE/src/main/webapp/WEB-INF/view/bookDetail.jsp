<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>${msg} a Book</title>
</head>

<body>
<c:if test="${msg == 'Update'}">
<form action="../books/${book.getId()}" method="post">
    </c:if>
    <c:if test="${msg == 'Add'}">
    <form action="../books" method="post">
        </c:if>
        <table>
            <tr>
                <td>Title:</td>
                <td><input type="text" name="title" value="${book.getTitle()}" /> </td>
            </tr>
            <tr>
                <td>ISBN:</td>
                <td><input type="text" name="ISBN" value="${book.getISBN()}" /> </td>
            </tr>
            <tr>
                <td>Author:</td>
                <td><input type="text" name="author" value="${book.getAuthor()}" /> </td>
            </tr>
            <tr>
                <td>Price:</td>
                <td><input type="number" name="price" value="${book.getPrice()}" /> </td>
            </tr>
        </table>
        <input type="submit" value="${msg}"/>
    </form>
    <c:if test="${msg == 'Update'}">
    <form action="delete?bookId=${book.getId()}" method="post">
        <button type="submit">Delete</button>
    </form>
    </c:if>
</body>

</html>