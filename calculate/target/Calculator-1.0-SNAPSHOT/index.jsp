<%--
  Created by IntelliJ IDEA.
  User: Юрий
  Date: 16.06.15
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
    <script></script>
    <style>
        table, th, td{border: 1px solid #333;}
    </style>
</head>
<body>
<form action="result" method="post">
    <label for="value">Введите число:</label>
    <p><input  id="value" name="value" type="text" value="0.0" /></p>
    <p>
        <input name="plus" type="submit" value="+" />
        <input name="minus" type="submit" value="-" />

        <input name="divide" type="submit" value="/" />
        <input name="multiply" type="submit" value="*" />
    </p>
    <label for="result">Результат:</label>
    <p><input id="result" name="result" readonly="readonly" type="text" value="<c:out value="${value1}" default="0.0"/>" /></p>

    <label for="tabResult">Последние результаты:</label>
    <table id="tabResult" >
        <tr><th>Выражение</th><th>Результат</th><th>Дата</th></tr>
        <c:forEach var="item" items="${results}">
            <tr><td>${item.exp}</td><td>${item.result}</td><td>${item.date}</td></tr>
        </c:forEach>
    </table>
</form>
</body>
</html>