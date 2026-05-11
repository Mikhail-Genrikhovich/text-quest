<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Лесное приключение</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>

    <h2>🌲 ${sessionScope.playerName}, ты в лесу!</h2>

   <c:choose>

       <c:when test="${question.gameOver}">
           <c:choose>
               <c:when test="${question.win}">
                   <p>🏆 Победа!</p>
               </c:when>
               <c:otherwise>
                   <p>💀 Поражение!</p>
               </c:otherwise>
           </c:choose>

           <p>${question.text}</p>

           <p>Сыграно игр: <strong>${sessionScope.gamesCount}</strong></p>

           <a href="${pageContext.request.contextPath}/start">
               <button>🔄 Играть снова</button>
           </a>
       </c:when>

       <c:otherwise>
           <p>${question.text}</p>

           <c:forEach var="answer" items="${question.answers}">
               <form action="${pageContext.request.contextPath}/game" method="post">
                   <input type="hidden" name="answerId" value="${answer.nextQuestionId}"/>
                   <button type="submit">${answer.text}</button>
               </form>
           </c:forEach>
       </c:otherwise>

   </c:choose>

</body>
</html>