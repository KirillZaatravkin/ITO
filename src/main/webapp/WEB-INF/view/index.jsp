<%--
  Created by IntelliJ IDEA.
  User: кирюха
  Date: 29.12.2018
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="source.systemUD.service.ParseDOCXService" %>
<%@ page import="source.systemUD.model.ParagraphCompare" %>
<%@ page import="java.util.List" %>
<%@ page import="org.springframework.web.multipart.MultipartFile" %>
<%@ page import="java.util.ArrayList" %>
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <title>ИТО</title>
    <style> <%@include file="../css/style.css"%> </style>
    <style>
        .c {
            border: 1px solid #333; /* Рамка */
            display: inline-block;
            padding: 5px 15px; /* Поля */
            text-decoration: none; /* Убираем подчёркивание */
            color: #000; /* Цвет текста */
        }
        .c:hover {
            box-shadow: 0 0 5px rgba(0,0,0,0.3); /* Тень */
            background: linear-gradient(to bottom, #fcfff4, #e9e9ce); /* Градиент */
            color: #a00;
        }
    </style>
</head>
<%@ include file="ud/header_ud.jsp" %>


<body>


<div id="post">
    <a class="c" href="/resediv">Преюдиция АП</a>

    <a class="c" href="/viewall">Прокурорское досье</a>

</div>

<%@ include file="ap/footer.jsp" %>
</body>
</html>