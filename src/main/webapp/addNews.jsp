<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление | Редактирование</title>
</head>
<body>

    <form action="addNews" method="post">
        <label for="name">Введите новость:
            <input type="text" id="name" value="${news.message}" name="message" style="width: 500px; height: 40px;" minlength="3" required/>
        </label>  <br />
        <input type="hidden" name="id" value="${news.id}" />
        <input type="submit" value="Сохранить" />
    </form>

</body>
</html>