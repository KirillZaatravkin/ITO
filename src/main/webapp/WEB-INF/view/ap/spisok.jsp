<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ page import="source.systemAP.ReadApOVD" %>
<%@ page import="source.systemAP.model.ApOVD" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="source.systemAP.dao.SettingsDao" %>
<%@ page import="java.util.Set" %>
<%@ page import="source.systemAP.model.Settings" %>
<%@ page import="source.systemAP.ReadGibdd" %>
<%@ page import="source.systemAP.ReadPrist" %>
<%@ page import="source.systemAP.model.ApPrist" %>
<%@ page import="source.systemAP.ReadSpiski" %>
<%@ page import="source.systemAP.model.Spisok" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <title>ИТО</title>
    <style> <%@include file="../../css/style.css"%> </style>
</head>
<%@ include file="header.jsp" %>
<%@ include file="sidebar.jsp" %>
<body>
<div id="main_block">Загрузка данных</div>
<div id="post">
    <p><label id="lab_big">Проверить списки</label></p>
    <%

        String myfile = request.getParameter("myfile");
        System.out.print(myfile);
        SettingsDao settingsDao = new SettingsDao();
        Settings sett = settingsDao.getSetting(1);

        ReadSpiski rao = new ReadSpiski();
    %>
    <label>Папка, в которую следует поместить файл:<%=sett.getSettings()%>
    </label>


    <form action="/spisok" accept-charset="utf-8" method="POST" name="load">
        <input type="file" name="myfile">
        <div style="margin: 10px">
            <input type="submit" id="sub" name="proverka" value="Найти">
        </div>
       <label id="lab">Выбрать структура документа</label>
        <div style="margin: 10px">
            <label class="checkbox">
                <input type="checkbox" name="doc" value="standart"/>
                <div class="checkbox__text">Переключить</div>
            </label>
        </div>
        <div style="width: 610px">
            <div style="float: left;">
                <img id="img_exampel1" src="/media/exampel1.JPG">
            </div>
            <div style="float: right">
                <img id="img_exampel2" src="/media/exampel2.JPG">
            </div>
        </div>
    </form>


    <%
        if (myfile != null) {
            List<Spisok> spisokList=new ArrayList<Spisok>();
            if(request.getParameter("doc")!=null) {

               spisokList = rao.ReadExelStandart(sett.getSettings() + myfile);
            } else
            {
               spisokList = rao.ReadExel(sett.getSettings() + myfile);
            }
    %>

    <label id="lab_big">Вывод</label>
    <table border=1>
        <thead>
        <tr>

            <th>Фамилия</th>
            <th>Имя</th>
            <th>Отчество</th>
            <th>Дата рождения</th>
            <th>Место жительства</th>
            <th>Статья КоАП</th>
            <th>часть</th>
            <th>Дата совершения правонарушения</th>
            <th>Дата вступления в законную силу</th>
            <th>Вид наказания</th>
        </tr>
        </thead>
        <tbody>
        <%


            for (int i = 0; i < spisokList.size(); i++) {

        %>
        <tr>
            <td><%=spisokList.get(i).getLastName()%>
            </td>
            <td><%= spisokList.get(i).getFirstName()%>
            </td>
            <td><%= spisokList.get(i).getMiddleName()%>
            </td>
            <td><%= spisokList.get(i).getBirthDay()%>
            </td>
            <td><%= spisokList.get(i).getFacktAddr()%>
            </td>
            <td><%= spisokList.get(i).getArticle()%>
            </td>
            <td><%= spisokList.get(i).getCact()%>
            </td>
            <td><%= spisokList.get(i).getDateP()%>
            </td>
            <td><%= spisokList.get(i).getDateZak()%>
            </td>
            <td><%= spisokList.get(i).getNakaz()%>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>

    <% }%>
</div>

<%@ include file="footer.jsp" %>
</body>
</html>
