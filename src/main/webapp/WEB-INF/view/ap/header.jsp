<%@ page import="org.springframework.security.core.Authentication" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %><%--
  Created by IntelliJ IDEA.
  User: кирюха
  Date: 30.10.2017
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>

 <%Authentication authentication = SecurityContextHolder.getContext().getAuthentication();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<head>
    <meta charset="utf-8">
</head>


<div id="header">

    <div style="width: 100%;">
        <div style=" float: right; width: 200px;"><img src="/media/logo.png"></div>
        <div style="float: right; max-width: 750px;"><h1>Преюдиция АП</h1></div>

        <c:url value="/logout" var="logoutUrl" />
        <form id="logout" action="${logoutUrl}" method="post" >
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        </form>

        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <p><label  id="text_hi"> Здравствуйте, <%= authentication.getName()%> </label></p>
            <a style="color: #e01e0a" href="javascript:document.getElementById('logout'
            ).submit()">Выход</a>
        </c:if>

    </div>
</div>
