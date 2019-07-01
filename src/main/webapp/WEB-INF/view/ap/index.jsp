<%@ taglib tagdir="/WEB-INF/tags" prefix="h" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="source.*" %>
<%@ page import="source.systemAP.dao.CurrentDate" %>


<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%--@elvariable id="nologin" type="javax.lang.Boolean"
<c:if test="${!nologin}">
    <%
        if (session.getAttribute("login") == null) {
    %>
    <script> window.location = "header";</script>
    <%
        }
    %>
</c:if>--%>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <title>ИТО</title>
    <style> <%@include file="../../css/style.css"%> </style>
</head>

<body>
<%@ include file="header.jsp" %>
<%@ include file="sidebar.jsp" %>
<div id="main_block">Анализ</div>
<div id="post">
    <div style="width: 690px">
  <div id="analiz_right">
      <a href="preloader?interval=year">
         <div id="analiz">Анализ текущего года
         <p><c:out value="${y}"/></p></div>
      </a>
      <a href="preloader?interval=month">
          <div id="analiz">Анализ текущего месяца
              <p><c:out value="${m}"/></p></div>
      </a>
   </div>


     </div>
    </div>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>