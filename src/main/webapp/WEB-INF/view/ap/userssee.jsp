<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>


<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <title>ИТО</title>
    <style> <%@include file="../../css/style.css"%> </style>
</head>

<body>
<%@ include file="header.jsp" %>
<%@ include file="sidebar.jsp" %>
<div id="main_block">Настройка</div>

<div id="post">

    <%@ include file="vertsidebar.jsp" %>
    <p><label id="lab_big">Настройка пользователей</label></p>
    <p><a id="button_href" href="/useradd">Добавить пользователя</a></p>
    <label>Зарегистрированные пользователи</label>

    <table border=1>
        <thead>
        <tr>

            <th>Логин</th>
            <th>Дата регистрации</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${usersList}" var="user">
        <tr>

            <td><c:out value="${user.login}"/></td>
            <td><c:out value="${user.reg}"/></td>
            <td><a href="/userupdate?id=${user.id}">Редактировать</a></td>
        </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>