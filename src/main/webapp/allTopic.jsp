<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Список топиков</title>
</head>
<body>

    <h3>Все топики:</h3>
    (<a href="addTopic">добавить</a>)
    <ol>
        <c:forEach items="${topics}" var="topic">
            <li>
                ${topic.name}
                    <a href="addTopic?edit=${topic.id}">редактировать</a> | <a href="delete?id=${topic.id}">удалить</a>
                    | <a href="allNews?id_topic = ${topic.id}">Посмотреть новости  данного топика</a>
            </li>
        </c:forEach>
    </ol>

</body>
</html>