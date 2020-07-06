<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Изменить данные пользователя</title>
</head>
<body>

Редактировать пользователя

<form action="/update" method="post">
    <input type="hidden" name = "id" value="${user.id}">
    <input type="text" name="name" value="${user.firstName}" placeholder=${user.firstName}>
    <input type="text" name="lastname" value="${user.lastName}" placeholder=${user.lastName}>
    <input type="text" name="email" value="${user.email}" placeholder=${user.email}>
    <input type="submit" value="Обновить">
</form>

<p> ${UpdateUserException}</p>

</body>
</html>
