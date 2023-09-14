<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>${msg} a Book</title>
</head>

<body>
        <table>
            <tr>
                <td>Title:</td>
                <td>${book.getTitle()}</td>
            </tr>
            <tr>
                <td>ISBN:</td>
                <td>${book.getISBN()}</td>
            </tr>
            <tr>
                <td>Author:</td>
                <td>${book.getAuthor()}</td>
            </tr>
            <tr>
                <td>Price:</td>
                <td>${book.getPrice()}</td>
            </tr>
        </table>
        <a href="../../">Back to the list</a>
</body>

</html>