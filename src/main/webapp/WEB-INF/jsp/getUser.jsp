<%@ page import="org.example.service.UserDtoFull" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User</title>
</head>
<body>

<%UserDtoFull user =(UserDtoFull) request.getAttribute("user");%>

<h2>Read existing User</h2>

    <div>
        <h2>with id = <%=user.getId()%></h2>
        <p>Name = <%=user.getName()%> </p>
        <p>Lastname = <%=user.getLastname()%> </p>
        <p>Age = <%=user.getAge()%> </p>
    </div>
</body>
</html>