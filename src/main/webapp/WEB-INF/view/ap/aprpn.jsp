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
<%@ page import="source.systemAP.ReadApRPN" %>
<%@ page import="source.systemAP.model.ApRPN" %>
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
    <%@ include file="vertmenu2.jsp" %>
    <p><label id="lab_big">Загрузка баз РосПотребНадзора</label></p>
    <%

        String myfile = request.getParameter("myfile");
        System.out.print(myfile);
        SettingsDao settingsDao = new SettingsDao();
        Settings sett = settingsDao.getSetting(1);
        String proverka = null;
        proverka = request.getParameter("proverka");
        String save = null;
        save = request.getParameter("save");
        ReadApRPN rao = new ReadApRPN ();
    %>
    <label>Папка, в которую следует поместить файл:<%=sett.getSettings()%>
    </label>
    <% if (myfile != null && save != null) {

        int i = rao.WriteToBD(rao.ReadExel(sett.getSettings() + myfile));

    %>
    <label>Обработано записей:<%=i%>
    </label>
    <%
        }
    %>

    <form action="/aprpn" accept-charset="utf-8" method="POST" name="load">
        <input type="file" name="myfile">
        <div>
            <input type="submit" id="sub" name="save" value="Загрузить в БД">
            <input type="submit" id="sub" name="proverka" value="Проверить документ">
        </div>
    </form>


    <%
        if (myfile != null && proverka != null) {
            List<ApRPN> apRPN = rao.ReadExel(sett.getSettings() + myfile);
    %>

    <label id="lab_big">Проверка на правильность занесения данных</label>
    <table border=1>
        <thead>
        <tr>

            <th>ФИО</th >
            <th>Место жительства</th>
            <th>Статья КоАП</th>
             <th>Дата совершения правонарушения</th>
            <th>Дата вступления в законную силу</th>
            <th>Наказание</th>
            <th>№ протокола</th>
        </tr>
        </thead>
        <tbody>
        <%
            int p = (apRPN.size() / 100) + 1;
            for (int i = 0; i < p; i++) {

        %>
        <tr>
            <td><%=apRPN.get(i).getFIO()%>
            </td>
            <td><%= apRPN.get(i).getFacktAddr()%>
            </td>
            <td><%= apRPN.get(i).getArticle()%>
            </td>
            <td><%= apRPN.get(i).getDateP()%>
            </td>
            <td><%= apRPN.get(i).getDateZak()%>
            </td>
            <td><%= apRPN.get(i).getNakaz()%>
            </td>
            <td><%= apRPN.get(i).getProtocolN()%>
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
