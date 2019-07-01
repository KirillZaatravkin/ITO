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
<%@ page import="source.systemUD.dao.UDDAO" %>
<%@ page import="source.systemUD.dao.SettingsDAO" %>
<%@ page import="source.systemUD.model.Settings" %>
<%@ page import="source.systemUD.model.UDDoc" %>
<%@ page import="source.systemUD.dao.DocDAO" %>
<%@ page import="source.systemUD.model.UDModel" %>
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

<%

    SettingsDAO sett = new SettingsDAO();
    Settings setting = sett.getSetting(1);

    Integer id= Integer.valueOf(request.getParameter("id"));


    UDDAO uddao = new UDDAO();
    UDModel udModel=uddao.getUD(id);
    String st = setting.getSettings() + udModel.getNumberUD();

%>
<div id="post">
    <form action="${fileUploadControllerURL}" method="post"
          enctype="multipart/form-data">
        <p><a href="editud?id=<%=id%> ">Вернуться назад</a></p>

        <table>
            <tr>
                <td><b>File:</b></td>
                <td><input type="file" name="file"></td>
                <input type="hidden" name="patch" value='<%=st%>'/>
                <input type="hidden" name="udId" value='<%=udModel.getId()%>'/>
                <input type="hidden" name="type" value='<%=request.getParameter("type")%>'/>
                <td><input type="submit" value="загрузить файл"></td>
            </tr>
        </table>
    </form>
</div>

<%@ include file="../ap/footer.jsp" %>
</body>
</html>



















