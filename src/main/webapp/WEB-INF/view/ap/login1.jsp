<%--
  Created by IntelliJ IDEA.
  User: кирюха
  Date: 29.07.2018
  Time: 23:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>




<%request.setCharacterEncoding("UTF-8");%>

<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>


<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <title>ИТО</title>
    <style> <%@include file="../../css/style.css"%> </style>
</head>

<body>
<%@ include file="header.jsp" %>


<div id="post">

    <body onload='document.f.j_username.focus();'>

    <c:url var="loginUrl" value="/j_spring_security_check" />
    <form name='f' action="${loginUrl}" method="post">
        <div class="logincontainer">

            <div class="login">
                <table>
                    <tr>
                        <td>Имя <input type='text' name='j_username'>
                        </td>
                    </tr>
                    <tr>
                        <td>Пароль <input type='password' name='j_password' />
                        </td>
                    </tr>
                </table>
                <br /> <input class="btn btn-primary" name="submit" type="submit"
                              value="Вход" /> <br />
            </div>
            <c:if test="${not empty error}">
                <div class="alert alert-danger" style="width: 285px; margin: 0px auto;" role="alert">
                        ${error}</div>
            </c:if>
        </div>
    </form>
    </body>
</div>

<%@ include file="footer.jsp" %>
</body>