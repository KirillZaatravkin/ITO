<%@ page import="source.systemUD.model.Settings" %>

<%@ page import="source.systemUD.dao.SettingsDAO" %><%--
  Created by IntelliJ IDEA.
  User: кирюха
  Date: 29.12.2018
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <title>ИТО</title>
    <style> <%@include file="../../css/style.css"%> </style>

    <style>
        .c {
            border: 1px solid #333; /* Рамка */
            display: inline-block;
            padding: 5px 15px; /* Поля */
            text-decoration: none; /* Убираем подчёркивание */
            color: #000; /* Цвет текста */
        }

        .c:hover {
            box-shadow: 0 0 5px rgba(0, 0, 0, 0.3); /* Тень */
            background: linear-gradient(to bottom, #fcfff4, #e9e9ce); /* Градиент */
            color: #a00;
        }
    </style>

    <script>
        function showContent(link) {
            var cont = document.getElementById('content');
            var loading = document.getElementById('loading');
            cont.innerHTML = loading.innerHTML;
            var http = createRequestObject();
            if( http )
            { http.open('get', link);
                http.onreadystatechange = function ()
                {   if(http.readyState == 4)
                {   cont.innerHTML = http.responseText;  }    }
                http.send(null);  }
            else
            {  document.location = link;   }   }
        // ajax объект
        function createRequestObject()
        {  try { return new XMLHttpRequest() }
        catch(e)
        {  try { return new ActiveXObject('Msxml2.XMLHTTP') }
        catch(e)
        {   try { return new ActiveXObject('Microsoft.XMLHTTP') }
        catch(e) { return null; }   } } }
    </script>


    <script type="text/javascript" src="../../js/jquery-1.12.4.js"></script>



</head>
<%@ include file="header_ud.jsp" %>
<%@ include file="sidebar_ud.jsp" %>
<% int f = 0;%>

<div id="post">

    <ul style="text-align:center">
        <li style="color:blue"><a href="#" onClick="showContent('/menupamat')">Страница 1</a></li>
        <li style="color:green"><a href="#" onClick="showContent('page2.html')">Страница 2</a></li>
        <li style="color:cyan"><a href="#" onClick="showContent('page3.html')">Страница 3</a></li>
        <li style="color:red"><a href="#" onClick="showContent('page4.html')">Страница 4</a></li>
    </ul>

    <div id="content">
        <!-- CONTENT -->
    </div>
    <div id="loading" style="display: none">
        Идет загрузка...
    </div>

    <label id="lab_big">Дело № ${ud.numberUD}</label>


 <!--  <div> <form action="/createzip" method="post" target="_blank">
        <input type="hidden" name="UD" value=<c:out value="${ud.id}"/> />
        <button type="submit">Создать архив c пакетом документов/> </button>
    </form></div>
-->
    <p><label id="lab">Загруженные файлы: </label></p>
    <table border="1">
        <thead>
        <tr>
            <th>№</th>
            <th>Тип документа</th>
            <th>Имя файла</th>
            <th>Дата загрузки</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${docList}" var="list">
            <tr>
                <td>
                    <%=++f%>
                </td>
                <td><c:out value="${list.typeDocTitle}"/>
                </td>
                <td><c:out value="${list.originalName}"/>
                </td>
                <td><c:out value="${list.createdate}"/>
                </td>
                <c:choose>
                    <c:when test="${list.docx}">
                        <td style="border: hidden">
                            <form action="/selectdoc" method="post" target="_blank">
                                <input type="hidden" name="path" value=<c:out value="${list.path}"/>/>
                                <button type="submit">Выбрать для сравнения</button>
                                <label id="lab"> </label>
                            </form>
                        </td>
                    </c:when>
                    <c:otherwise>
                        <td style="border: hidden">Для сравнения переведите документ в формат docx</td>
                    </c:otherwise>
                </c:choose>


                <td style="border: hidden">
                    <form action="/filedown" method="post" target="_blank">
                        <input type="hidden" name="file" value=<c:out value="${list.path}"/>/>
                        <button type="submit" id="butdow">Скачать</button>
                    </form>
                </td>

                <td style="border: hidden">
                    <form action="/delete" method="post">
                        <input type="hidden" name="path" value=<c:out value="${list.path}"/>/>
                        <input type="hidden" name="id" value=
                            <c:out value="${list.id}"/>
                        />
                        <button type="submit" id="butdel">Удалить</button>
                    </form>
                </td>

                <td>
                    <label id="lab">Буферная папка для скачивания: <c:out value="${sett}"></c:out></label>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>


    <p><label id="lab">Заполненные памятки: </label></p>
    <table border="1">

        <tbody>
        <c:forEach items="${pamat1}" var="pamat1">
            <tr>

                <td>Памятка 1</td>

                <td><a href="/pamat1view?id=${pamat1.intValue()}" class="c">Открыть</a>

            </tr>
        </c:forEach>


        <c:forEach items="${pamat2}" var="pamat2">
            <tr>

                <td>Памятка 2</td>

                <td><a href="/pamat2view?id=${pamat2.intValue()}" class="c">Открыть</a>

            </tr>
        </c:forEach>

        <c:forEach items="${pamat3}" var="pamat3">
            <tr>

                <td>Памятка 3</td>

                <td><a href="/pamat3view?id=${pamat3.intValue()}" class="c">Открыть</a>

            </tr>
        </c:forEach>
        </tbody>
    </table>


    <div id="kol_compare">
        <div id="left_kol_compare">
            <% int j = 1;%>

            <p><label id="lab">1.Загрузить документы о движении уголовного дела:</label></p>
            <c:forEach items="${docGroup}" var="group1">
                <p><a href="/uploidfile?id=${ud.id}&type=${group1.id}" class="c"><%=j%><%="."%>${group1.title}</a></p>
                <%j++;%>
            </c:forEach>

            <%j = 1;%>
            <p><label id="lab">2.Загрузить действия на основании постановлений,судебного решения:</label>
            </p>
            <c:forEach items="${docGroup3}" var="group3">
                <p><a href="/uploidfile?id=${ud.id}&type=${group3.id}" class="c"><%=j%><%="."%>${group3.title}</a></p>
                <%j++;%>
            </c:forEach>

            <%j = 1;%>
            <p><label id="lab">3.Загрузить сведения о потерпевшем, возмещение ущерба:</label></p>
            <c:forEach items="${docGroup4}" var="group4">
                <p><a href="/uploidfile?id=${ud.id}&type=${group4.id}" class="c"><%=j%><%="."%>${group4.title}</a></p>
                <%j++;%>
            </c:forEach>

            <%j = 1;%>
            <p><label id="lab">4.Загрузить сведения об опечпечении прав на защиту:</label></p>
            <c:forEach items="${docGroup5}" var="group5">
                <p><a href="/uploidfile?id=${ud.id}&type=${group5.id}" class="c"><%=j%><%="."%>${group5.title}</a></p>
                <%j++;%>
            </c:forEach>

            <%j = 1;%>
            <p><label id="lab">5.Загрузить сведения о действии с участнием подозреваемого:</label></p>
            <c:forEach items="${docGroup6}" var="group6">
                <p><a href="/uploidfile?id=${ud.id}&type=${group6.id}" class="c"><%=j%><%="."%>${group6.title}</a></p>
                <%j++;%>
            </c:forEach>

            <%j = 1;%>
            <p><label id="lab">6.Загрузить сведения о рассмотрении жалоб и ходатайств :</label></p>
            <c:forEach items="${docGroup7}" var="group7">
                <p><a href="/uploidfile?id=${ud.id}&type=${group7.id}" class="c"><%=j%><%="."%>${group7.title}</a></p>
                <%j++;%>
            </c:forEach>

            <%j = 1;%>
            <p><label id="lab">7.Загрузить сведения о судебных экспертизах:</label></p>
            <c:forEach items="${docGroup8}" var="group8">
                <p><a href="/uploidfile?id=${ud.id}&type=${group8.id}" class="c"><%=j%><%="."%>${group8.title}</a></p>
                <%j++;%>
            </c:forEach>

            <%j = 1;%>
            <p><label id="lab">8.Загрузить сведения о следственных действиях:</label></p>
            <c:forEach items="${docGroup9}" var="group9">
                <p><a href="/uploidfile?id=${ud.id}&type=${group9.id}" class="c"><%=j%><%="."%>${group9.title}</a></p>
                <%j++;%>
            </c:forEach>

            <%j = 1;%>
            <p><label id="lab">9.Загрузить сведения о мерах пресечения:</label></p>
            <c:forEach items="${docGroup10}" var="group10">
                <p><a href="/uploidfile?id=${ud.id}&type=${group10.id}" class="c"><%=j%><%="."%>${group10.title}</a></p>
                <%j++;%>
            </c:forEach>

            <%j = 1;%>
            <p><label id="lab">10.Загрузить сведения о запросах:</label></p>
            <c:forEach items="${docGroup11}" var="group11">
                <p><a href="/uploidfile?id=${ud.id}&type=${group11.id}" class="c"><%=j%><%="."%>${group11.title}</a></p>
                <%j++;%>
            </c:forEach>

            <%j = 1;%>
            <p><label id="lab">11.Загрузить характерезующие материалы:</label></p>
            <c:forEach items="${docGroup12}" var="group12">
                <p><a href="/uploidfile?id=${ud.id}&type=${group12.id}" class="c"><%=j%><%="."%>${group12.title}</a></p>
                <%j++;%>
            </c:forEach>

            <%j = 1;%>
            <p><label id="lab">12.Загрузить сведения об окончании предварительного расследования:</label></p>
            <c:forEach items="${docGroup13}" var="group13">
                <p><a href="/uploidfile?id=${ud.id}&type=${group13.id}" class="c"><%=j%><%="."%>${group13.title}</a></p>
                <%j++;%>
            </c:forEach>

            <%j = 1;%>
            <p><label id="lab">13.Загрузить сведения об обстоятельствах, способствавших совершению преступления:</label>
            </p>
            <c:forEach items="${docGroup14}" var="group14">
                <p><a href="/uploidfile?id=${ud.id}&type=14${group14.id}" class="c"><%=j%><%="."%>${group14.title}</a>
                </p>
                <%j++;%>
            </c:forEach>

            <%j = 1;%>
            <p><label id="lab">14.Загрузить акты реагтрования:</label></p>
            <c:forEach items="${docGroup15}" var="group15">
                <p><a href="/uploidfile?id=${ud.id}&type=${group15.id}" class="c"><%=j%><%="."%>${group15.title}</a></p>
                <%j++;%>
            </c:forEach>

            <%j = 1;%>
            <p><label id="lab">15.Загрузить сведения о международном сотрудничестве</label></p>
            <c:forEach items="${docGroup16}" var="group16">
                <p><a href="/uploidfile?id=${ud.id}&type=${group16.id}" class="c"><%=j%><%="."%>${group16.title}</a></p>
                <%j++;%>
            </c:forEach>
        </div>

        <div id="right_kol_compare">

            <%j = 1;%>
            <p><label id="lab">Загрузить планы расследования </label></p>
            <c:forEach items="${docGroup2}" var="group2">
                <p><a href="/uploidfile?id=${ud.id}&type=${group2.id}" class="c">Загрузить план</a></p>
                <%j++;%>
            </c:forEach>
            <div>
                <p><label id="lab">1.Заполнить памятку №1</label></p>
                <p><a href="/pamat1?delo=${ud.id}" class="c">по проверке постановления об отказе в возбуждении
                    уголовного дела</a></p>
            </div>
            <div>
                <p><label id="lab">2.Заполнить памятку №2</label></p>
                <p><a href="/pamat2?delo=${ud.id}" class="c">по проверке постановления о возбуждении уголовного дела</a></p>
            </div>
            <div>
                <p><label id="lab">3.Заполнить памятку №3</label></p>
                <p><a href="/pamat3?delo=${ud.id}" class="c">по проверке уголовного дела при признании лица потерпевшим</a></p>
            </div>
        </div>
    </div>

</div>

<%@ include file="../ap/footer.jsp" %>
</body>
</html>