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
    <style> <%@include file="../../css/style.css"%> </style>
</head>
<%@ include file="header_ud.jsp" %>
<%@ include file="sidebar_ud.jsp" %>

<body>


<div id="post">


    <label>Список уголовных дел</label>

    <table border=1>
        <thead>
        <tr>
            <th>Номер дела</th>

        </tr>
        </thead>
        <tbody>

        <c:forEach items="${udsList}" var="ud">


                <tr>
                    <td><c:out value="${ud.numberUD}"/></td>
                    <td><a href="/editud?id=${ud.id}">Редактировать</a></td>
                </tr>

        </c:forEach>

        </tbody>
    </table>

</div>

<%@ include file="../ap/footer.jsp" %>
</body>
</html>