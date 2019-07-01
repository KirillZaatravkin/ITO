<%--
  Created by IntelliJ IDEA.
  User: кирюха
  Date: 29.12.2018
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>

<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <title>ИТО</title>
    <style> <%@include file="../../css/style.css"%> </style>
</head>
<%@ include file="header_ud.jsp" %>
<%@ include file="sidebar_ud.jsp" %>

<body>


<div id="post">
    <form action="/createud" accept-charset="utf-8" method="POST" name="CreaateUD">
        <p>
            <label id="lab">Номер дела</label>
            <input type="text" name="numberUD">
        </p>
        <button type="submit" name="save">Сохранить</button>
    </form>
</div>

<%@ include file="../ap/footer.jsp" %>
</body>
</html>