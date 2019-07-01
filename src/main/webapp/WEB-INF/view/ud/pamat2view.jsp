<%--
  Created by IntelliJ IDEA.
  User: кирюха
  Date: 11.02.2019
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<html>
<head>
    <script>
        function isEven(number) {
            if (number == 1) {
                return document.write("Да");
            } else {
                return document.write("Нет");
            }
        }
    </script>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <title>ИТО</title>
    <style> <%@include file="../../css/style.css"%> </style>
</head>
<%@ include file="header_ud.jsp" %>
<%@ include file="sidebar_ud.jsp" %>

<body>


<div id="post">


    <table border=1>
        <thead>
        <tr>
            <th>Вопрос</th>
            <th>Ответ на вопрос</th>
            <th>Примичание</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>
                <label id="lab">1.Надлежащим ли должностным лицом возбуждено уголовное дело</label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat1.face}"/>))</script>
            </td>
            <td>
                <c:out value="${pamat1.facet}"/>
            </td>
        </tr>

        <tr>
            <td>
                <label id="lab">2.Соблюдены ли сроки возбуждения уголовного дела после регистрации сообщения о
                    преступлении в КУСП (3,10 или 30 суток)
                    РФ</label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat1.kusp}"/>))</script>
            </td>
            <td><c:out value="${pamat1.kuspt}"/></td>
        </tr>

        <tr>
            <td>
                <label id="lab">3.Имеются ли в материалах постановления о продлении процессуальных сроков проверки
                </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat1.sroki}"/>))</script>
            </td>
            <td><c:out value="${pamat1.srokit}"/></td>
        </tr>

        <tr>
            <td>
                <label id="lab">4.Указано ли в постановлении дата, время и место его вынесения
                </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat1.datapost}"/>))</script>
            </td>
            <td><c:out value="${pamat1.datapostt}"/></td>
        </tr>

        <tr>
            <td>
                <label id="lab">5.Указано ли в постановлении повод и основания для возбуждения уголовного дела
                </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat1.povod}"/>))</script>
            </td>
            <td><c:out value="${pamat1.povodt}"/></td>
        </tr>

        <tr>
            <td>
                <label id="lab">6.Соответствуют ли нормы УПК РФ, указанные в постановлении о возбуждении уголовного
                    дела, действующему законодательству
                </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat1.upk}"/>))</script>
            </td>
            <td><c:out value="${pamat1.upkt}"/></td>
        </tr>

        <tr>
            <td>
                <label id="lab">7.Соблюдены ли сроки предоставлении прокурору копии постановления о возбуждении
                    уголовного дела
                </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat1.prok}"/>))</script>
            </td>
            <td><c:out value="${pamat1.prokt}"/></td>
        </tr>

        <tr>
            <td>
                <label id="lab">8.Уведомлены ли заинтересованные лица о факте возбуждения уголовного дела (заявитель,
                    при возбуждении уголовного дела в отношении конкретного лица – подозреваемый)
                </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat1.uved}"/>))</script>
            </td>
            <td><c:out value="${pamat1.uvedt}"/></td>
        </tr>

        <tr>
            <td>
                <label id="lab">9.Соблюден ли порядок, предусмотренный ст.147 УПК РФ о возбуждении уголовного дела,
                    указанных в ч.2 ст.20 УПК РФ (дела частного обвинения)
                </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat1.st147}"/>))</script>
            </td>
            <td><c:out value="${pamat1.st147t}"/></td>
        </tr>

        <tr>
            <td>
                <label id="lab">10.Не имеется ли оснований для отвода следователя (дознавателя)
                </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat1.otvod}"/>))</script>
            </td>
            <td><c:out value="${pamat1.otvodt}"/></td>
        </tr>

        <tr>
            <td>
                <label id="lab">11.Указаны ли в постановлении данные, свидетельствующие о наличии признаков преступления
                </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat1.prest}"/>))</script>
            </td>
            <td><c:out value="${pamat1.prestt}"/></td>
        </tr>

        <tr>
            <td>
                <label id="lab">11.1.дата и время совершения преступления
                </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat1.dataprest}"/>))</script>
            </td>
            <td><c:out value="${pamat1.dataprestt}"/></td>
        </tr>

        <tr>
            <td>
                <label id="lab">11.2.место совершения преступления
                </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat1.mesto}"/>))</script>
            </td>
            <td><c:out value="${pamat1.mestot}"/></td>
        </tr>

        <tr>
            <td>
                <label id="lab">11.3.способ совершения преступления
                </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat1.sposob}"/>))</script>
            </td>
            <td><c:out value="${pamat1.sposobt}"/></td>
        </tr>

        <tr>
            <td>
                <label id="lab">11.4.характер и размер вреда, причиненного в результате преступления
                </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat1.har}"/>))</script>
            </td>
            <td><c:out value="${pamat1.hart}"/></td>
        </tr>

        <tr>
            <td>
                <label id="lab">12.Верной ли является квалификация преступления, по статье УК РФ
                </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat1.kval}"/>))</script>
            </td>
            <td><c:out value="${pamat1.kvalt}"/></td>
        </tr>

        <tr>
            <td>
                <label id="lab">13.Достаточно ли в материалах данных, свидетельствующих о наличии признаков преступления
                </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat1.mat}"/>))</script>
            </td>
            <td><c:out value="${pamat1.matt}"/></td>
        </tr>

        <tr>
            <td>
                <label id="lab">14.Соблюдены ли требования Инструкции « О порядке представления результатов
                    оперативно-розыскной
                    деятельности органу дознании, следователю или в суд» от 27.09.2013
                    №776/703/509/507/1820/42/535/398/68
                </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat1.inst}"/>))</script>
            </td>
            <td><c:out value="${pamat1.instt}"/></td>
        </tr>

        <tr>
            <td>
                <label id="lab">14.1.соответствуют ли материалы ОРД требованиям закона.
                </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat1.ord}"/>))</script>
            </td>
            <td><c:out value="${pamat1.ordt}"/></td>
        </tr>

        <tr>
            <td>
                <label id="lab">15.Соблюдён ли порядок возбуждения уголовного дела, в т.ч.:
                </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat1.ud}"/>))</script>
            </td>
            <td><c:out value="${pamat1.udt}"/></td>
        </tr>

        <tr>
            <td>
                <label id="lab">15.1.в отношении категорий лиц, приведённых в ст.447 УПК РФ
                </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat1.st447}"/>))</script>
            </td>
            <td><c:out value="${pamat1.st447t}"/></td>
        </tr>

        <tr>
            <td>
                <label id="lab">15.2.не нарушена ли подследственность, в том числе в отношении военнослужащих;
                </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat1.podsled}"/>))</script>
            </td>
            <td><c:out value="${pamat1.podsledt}"/></td>
        </tr>

        <tr>
            <td>
                <label id="lab">15.3.не истекли ли сроки давности привлечения к уголовной ответственности; </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat1.sroku}"/>))</script>
            </td>
            <td><c:out value="${pamat1.srokut}"/></td>
        </tr>

        <tr>
            <td>
                <label id="lab">15.4.не имеется ли неотменённого приговора суда, постановления о прекращении дела либо
                    постановления об отказе в возбуждении уголовного дела по этому же фактуи </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat1.prig}"/>))</script>
            </td>
            <td><c:out value="${pamat1.prigt}"/></td>
        </tr>

        <tr>
            <td>
                <label id="lab">16.Нет ли иных оснований, препятствующих возбуждению уголовного дела. </label></td>
            <td>
                <script>(isEven(<c:out value="${pamat1.inyi}"/>))</script>
            </td>
            <td><c:out value="${pamat1.inyit}"/></td>
        </tr>
        </tbody>
    </table>

</div>

<%@ include file="../ap/footer.jsp" %>
</body>
</html>

