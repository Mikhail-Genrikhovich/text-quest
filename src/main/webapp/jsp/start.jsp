<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Лесное приключение</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>

    <h1>🌲Лесное приключение🌲</h1>
    <p>
            На майские выходные вы с друзьями решили поехать на природу —
            погулять, пожарить шашлыки, отдохнуть от городской суеты...
        </p>
        <p>
            Пока кто-то разводил костёр, а кто-то занимался приготовлениями,
            тебе захотелось пройтись по лесу и осмотреться.
            И это была твоя ошибка...
        </p>
        <p>
            <strong>Ты заблудился. Связи нет.</strong>
        </p>
        <p>
            Сможешь ли ты найти дорогу обратно к друзьям?
        </p>
    <hr/>

    <c:if test="${sessionScope.gamesCount > 0}">
        <p>Сыграно игр: <strong>${sessionScope.gamesCount}</strong></p>
    </c:if>

    <form action="${pageContext.request.contextPath}/start" method="post">
        <input type="text" name="name" placeholder="Введи своё имя" autocomplete="off"/>
        <button type="submit">Начать игру!</button>
    </form>

</body>
</html>