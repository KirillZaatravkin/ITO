<%@page import="source.*" %>
<%@ page import="source.systemAP.Filter" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.ParseException" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="source.systemAP.model.ApGIBDDStat" %>
<%@ page import="source.systemAP.model.ApPristStat" %>
<%@ page import="source.systemAP.model.ApOVDStat" %>


<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>


<html>
<head>


    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <title>ИТО</title>
    <style> <%@include file="../../css/style.css"%> </style>
    <style> <%@include file="../../css/jquery-ui.css"%> </style>

    <script type="text/javascript" src="/js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="/js/jquery-ui-1.12.1js.js"></script>


    <script>
        $(function () {
            $("#datepicker").datepicker({dateFormat: "dd.mm.yy"}).val()
        });
    </script>
</head>


    <%
     request.setCharacterEncoding("UTF-8");


        List<ApOVDStat> apOVDs=new ArrayList<ApOVDStat>();
        List <ApGIBDDStat> apGIBDDs=new ArrayList<ApGIBDDStat>();
        List <ApPristStat> apPrists=new  ArrayList<ApPristStat>();

        java.sql.Date SQLbirthday=null;
        System.out.print(SQLbirthday);
        String lastname = (request.getParameter("lastname"));
        String middlename = (request.getParameter("middlename"));
        String firstname = (request.getParameter("firstname"));
        String STRbirthday = request.getParameter("birthday");
                if (firstname==""|| firstname==null){firstname ="%";}
                if (lastname==""|| lastname==null){lastname ="%";}
                if(middlename=="" || middlename==null){middlename="%";}
                if(request.getParameter("birthday")!=null)
                {

                    try   {
                        STRbirthday = request.getParameter("birthday");
                        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
                        Date birthday = format.parse(STRbirthday);
                        SQLbirthday = new java.sql.Date(birthday.getTime());
                        System.out.println("hf");
                        System.out.println(SQLbirthday);
                    }catch (ParseException e)
                    {
                    }
                }



                if ((firstname != "%" || middlename != "%" || lastname != "%") && (request.getParameter("birthday")!=null))
                {
                    Filter filter = new Filter();
                    apOVDs = filter.FindFaceOVD(lastname, firstname, middlename, SQLbirthday);
                    apGIBDDs= filter.FindFaceGIBDD(lastname,firstname, middlename, SQLbirthday);
                    apPrists=filter.FindFacePrist(lastname,firstname,middlename,SQLbirthday);
                }


              if ((firstname != "%" || middlename != "%" || lastname != "%") && (request.getParameter("birthday")==null))
              {
                 Filter filter = new Filter();
                 apOVDs = filter.FindFaceOVD(lastname, firstname, middlename, null);
                 apGIBDDs= filter.FindFaceGIBDD(lastname,firstname, middlename, null);
                 apPrists=filter.FindFacePrist(lastname,firstname,middlename,null);
              }
%>
<%@ include file="header.jsp" %>
<%@ include file="sidebar.jsp" %>
<body>
<div id="main_block">Поиск гражданина по базам</div>
<div id="post" style="height: 130%">
    <form action="/findface" method="POST" name="filter">

        <div id="kol">
            <div id="lab_big">
                <label>Данные для поиска</label>
            </div>
            <p></p>
            <div id="left_kol">
                <div>
                    <div><label label id="lab"> Фамилия </label></div>
                    <% if (lastname.equals("%")) { %>
                    <input type="text" name="lastname">
                    <% } else {
                    %>
                    <input type="text" name="lastname" value="<%=lastname%>">
                    <%}%>
                </div>

                <div>
                    <div><label label id="lab"> Имя </label></div>
                    <% if (firstname.equals("%")) { %>
                    <input type="text" name="firstname">
                    <% } else {
                    %>
                    <input type="text" name="firstname" value="<%=firstname%>">
                    <%}%>
                </div>

                <div>
                    <div><label label id="lab"> Отчество </label></div>
                    <% if (middlename.equals("%")) { %>
                    <input type="text" name="middlename">
                    <% } else {
                    %>
                    <input type="text" name="middlename" value="<%=middlename%>">
                    <%}%>
                </div>

            </div>

            <div id="right_kol">
                <div><label id="lab">Дата рождения</label></div>
                <input type="text" placeholder="12.04.1962" name="birthday" id="datepicker">

                <!--
                <div>Известна точная дата</div>	<input type="checkbox" name="on" value="on"  onclick="if(this.checked){this.nextSibling.style.display=''}else {this.nextSibling.style.display='none';  this.nextSibling.value='';}"><input type="date" id="dt" onchange="mydate1();"/>
                  -->
            </div>
        </div>

        <button id="but_ok" type="submit" name="save">Искать</button>

    </form>

    <%

        System.out.println(request.getParameter("birthday"));
        if (apOVDs.size() > 0) {
    %>
    <label id="lab_big">Правонарушители из баз ОВД</label>
    <table border=1>

        <thead>
        <tr>

            <th>Фамилия</th>
            <th>Имя</th>
            <th>Отчество</th>
            <th>Дата рождения</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <%
            for (int i = 0; i < apOVDs.size(); i++) {

        %>
        <tr>
            <td><%=apOVDs.get(i).getLastName()%>
            </td>
            <td><%= apOVDs.get(i).getFirstName()%>
            </td>
            <td><%= apOVDs.get(i).getMiddleName()%>
            </td>
            <td><%= apOVDs.get(i).getBirthDay()%>
            </td>
            <td>
                <form method="post" target="_blank" action="/echofilter">
                    <input type="hidden" value=<%=apOVDs.get(i).getLastName()%> name="lastname">
                    <input type="hidden" value=<%=apOVDs.get(i).getFirstName()%> name="firstname">
                    <input type="hidden" value=<%=apOVDs.get(i).getMiddleName()%> name="middlename">
                    <input type="hidden" value=<%=apOVDs.get(i).getBirthDay()%> name="birthday">
                    <button type="submit">Подробно о грaжданине</button>
                </form>
            </td>

        </tr>
        <%
            }
        %>
        </tbody>
    </table>

    <% }

        if (apGIBDDs.size() > 0) {
            System.out.println("fghdf");
    %>

    <label id="lab_big">Правонарушители из баз ГИБДД</label>
    <table border=1>
        <thead>
        <tr>
            <th>Фамилия</th>
            <th>Имя</th>
            <th>Отчество</th>
            <th>Дата рождения</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <%
            for (int i = 0; i < apGIBDDs.size(); i++) {

        %>
        <tr>
            <td><%=apGIBDDs.get(i).getLastName()%>
            </td>
            <td><%= apGIBDDs.get(i).getFirstName()%>
            </td>
            <td><%= apGIBDDs.get(i).getMiddleName()%>
            </td>
            <td><%= apGIBDDs.get(i).getBirthDay()%>
            </td>
            <td>
                <form method="post" action="/echofilter">
                    <input type="hidden" value=<%=apGIBDDs.get(i).getLastName()%> name="lastname">
                    <input type="hidden" value=<%=apGIBDDs.get(i).getFirstName()%> name="firstname">
                    <input type="hidden" value=<%=apGIBDDs.get(i).getMiddleName()%> name="middlename">
                    <input type="hidden" value=<%=apGIBDDs.get(i).getBirthDay()%> name="birthday">
                    <button type="submit">Подробно о грaжданине</button>
                </form>
            </td>

        </tr>
        <%
            }
        %>
        </tbody>
    </table>
    <% }
        if (apPrists.size() > 0) {

    %>
    <label id="lab_big">Правонарушители из баз ФССП</label>
    <table border=1>
        <thead>
        <tr>
            <th>Фамилия</th>
            <th>Имя</th>
            <th>Отчество</th>
            <th>Дата рождения</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <%
            for (int i = 0; i < apPrists.size(); i++) {

        %>
        <tr>
            <td><%=apPrists.get(i).getLastName()%>
            </td>
            <td><%= apPrists.get(i).getFirstName()%>
            </td>
            <td><%= apPrists.get(i).getMiddleName()%>
            </td>
            <td><%= apPrists.get(i).getBirthDay()%>
            </td>
            <td>
                <form method="post" action="/echofilter">
                    <input type="hidden" value=<%=apPrists.get(i).getLastName()%> name="lastname">
                    <input type="hidden" value=<%=apPrists.get(i).getFirstName()%> name="firstname">
                    <input type="hidden" value=<%=apPrists.get(i).getMiddleName()%> name="middlename">
                    <input type="hidden" value=<%=apPrists.get(i).getBirthDay()%> name="birthday">
                    <button type="submit">Подробно о грaжданине</button>
                </form>
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