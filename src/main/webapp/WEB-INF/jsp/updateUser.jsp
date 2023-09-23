<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>Update user</title>
</head>
<body>
<div>
    <h1>Update user</h1>
</div>
<div>
    <p>Enter values</p>
    <form action="" method="post">
                <input id="id-input" name="id" type="text" value="${user.id}" hidden/><br/>
        <label for="name-input"> Name: </label>
            <input id="name-input" name="name" type="text" value="${user.name}" required/><br/>
        <label for="lastname-input">Lastname: </label>
            <input id="lastname-input" name="lastname" type="text" value="${user.lastname}" required/><br/>
        <label for="age-input">Age: </label>
            <input id="age-input" name="age" type="number" value="${user.age}" required/><br/>
        <input type="submit" value="Update"/>
    </form>
</div>
</body>
</html>