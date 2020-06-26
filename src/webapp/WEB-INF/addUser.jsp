<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавить нового пользователя</title>
</head>
<body>
<form action = "/add" method="post">
    <input required type="text" name="name" placeholder="имя">
    <input required type="text" name="last_name" placeholder="пароль">
    <input required type="text" name="email" placeholder="почта">
    <input type="submit" value="Сохранить">
</form>

<p> ${AddUserException}</p>
<p> ${NumberFormatException}</p>
</body>
</html>