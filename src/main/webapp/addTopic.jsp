<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление | Редактирование</title>
</head>
<body>

    <form action="addTopic" method="post">
        <label for="name">Введите имя:
            <input type="text" id="name" value="${topic.name}" name="name" />
        </label>  <br />
        <input type="hidden" name="id" value="${topic.id}" />
        <input type="submit" value="Сохранить" />
    </form>

</body>
</html>