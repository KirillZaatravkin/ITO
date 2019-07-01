<%--
  Created by IntelliJ IDEA.
  User: кирюха
  Date: 12.07.2018
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
         language="java"%>
<%@ page session="false"%>
<!doctype html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <title>Вход</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
    <link rel="stylesheet"
          href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" />
</head>
<body>
<div id="admin-section">
    <h3>Поздравляем, вы на закрытой странице!</h3>
    <c:url value="/logout" var="logoutUrl" />
    <form id="logout" action="${logoutUrl}" method="post" >
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </form>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <a href="javascript:document.getElementById('logout').submit()">Logout</a>
    </c:if>
</div>
</body>
</html>