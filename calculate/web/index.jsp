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
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.js" type="text/javascript"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="app.js"></script>
    <style>
        table, th, td{border: 1px solid #333;}
    </style>
</head>
    <body>
    <form id="myAjaxRequestForm">
        <p>Введите число:</p>
        <p><input id="value" name="value" type="text" value="0.0" pattern="\d+(\.\d{12})?"/></p>
        <p>
            <input name="plus" id="bPlus" type="button" value="+" />
            <input name="minus" id="bMinus" type="button" value="-" />

            <input name="divide" id="bDivide" type="button" value="/"/>
            <input name="multiply" id="bMultiply" type="button" value="*" />
            <input name="clear" id="bClear" type="button" value="C" />
        </p>
        <p>Результат:</p>
        <p><input id="result" name="result" readonly="readonly" type="text" value="<c:out value="${value}" default="0.0"/>" /></p>
    </form>
    <form id="anotherSection">
        <label for="ajaxResponse"/>Прошлые результаты:</label>
        <p><div id="ajaxResponse"/></p>
    </form>
    </body>
</html>