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
        <p><input id="result" name="result" readonly="readonly" type="text" value="<c:out value="${value1}"/>" /></p>
    </form>
    </body>
</html>