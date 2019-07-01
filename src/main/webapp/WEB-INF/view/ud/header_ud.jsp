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
        <div style="float: right; max-width: 750px;"><h1>Прокуратура Псковской области</h1></div>


    </div>
</div>
