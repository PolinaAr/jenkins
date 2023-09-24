<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Users</title>
</head>
<body>
<div>
    <h1>Users</h1>
</div>
<div>
    <form action="./users/create">
        <button>Add user</button>
    </form>
    <table>
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>Lastname</td>
            <td>Age</td>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td><c:out value="${user.name}"/></a></td>
                <td><c:out value="${user.lastname}"/></td>
                <td>${user.age}</td>
                <td><a href="./users/update?id=${user.id}">
                    <button>Update</button></a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>