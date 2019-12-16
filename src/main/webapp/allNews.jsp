<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Список Новостей</title>
</head>
<body>

    <h3>Все новости:</h3>
    (<a href="addNews">добавить</a>)
    <ol>
        <c:forEach items="${news}" var="news">
            <li>
                ${news.message}
                    <a href="addNews?edit=${news.id}">редактировать</a> | <a href="delete?id=${news.id}">удалить</a>

            </li>
        </c:forEach>
        <a href="allTopic"> Вернуться к топикам </a>
    </ol>

</body>
</html>