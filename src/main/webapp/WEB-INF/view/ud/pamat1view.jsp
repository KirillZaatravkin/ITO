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
                <label id="lab">1.надлежащим ли должностным лицом вынесено постановление об отказе в возбуждении
                    уголовного дела</label>
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
                <label id="lab">1.1.соблюдены ли правила подследственности в соответствии со ст.ст. 150, 151 УПК
                    РФ</label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat1.st150}"/>))</script>
            </td>
            <td><c:out value="${pamat1.st150t}"/></td>
        </tr>

        <tr>
            <td>
                <label id="lab">2.имеется ли повод для проведения доследственной проверки в соответствии
                    со ст. 140 УПК РФ, в том числе
                </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat1.st140}"/>))</script>
            </td>
            <td><c:out value="${pamat1.st140t}"/></td>
        </tr>

        <tr>
            <td>
                <label id="lab">2.1имелись ли основания для проведения процессуальной проверки
                </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat1.osnov}"/>))</script>
            </td>
            <td><c:out value="${pamat1.osnovt}"/></td>
        </tr>

        <tr>
            <td>
                <label id="lab">3.предупрежден ли заявитель об уголовной ответственности за заведомо ложный донос в
                    соответствии со ст. 306 УК РФ
                </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat1.st306}"/>))</script>
            </td>
            <td><c:out value="${pamat1.st306t}"/></td>
        </tr>

        <tr>
            <td>
                <label id="lab">4.имеется ли поручение прокурора органу дознания или руководителя следственного органа
                    следователю о проведении проверки по сообщению о преступлении, распространенному в средствах
                    массовой информации
                </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat1.poruc}"/>))</script>
            </td>
            <td><c:out value="${pamat1.poruct}"/></td>
        </tr>

        <tr>
            <td>
                <label id="lab">5.cоблюдены ли требования Инструкции « О порядке представления результатов
                    оперативно-розыскной деятельности органу дознании, следователю или в суд» от 27.09.2013
                    №776/703/509/507/1820/42/535/398/68
                </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat1.inst776}"/>))</script>
            </td>
            <td><c:out value="${pamat1.inst776t}"/></td>
        </tr>

        <tr>
            <td>
                <label id="lab">5.1соответствуют ли материалы ОРД требованиям закона
                </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat1.ord}"/>))</script>
            </td>
            <td><c:out value="${pamat1.ordt}"/></td>
        </tr>

        <tr>
            <td>
                <label id="lab">6.cоблюдены ли сроки вынесения постановления об отказе в возбуждении уголовного дела
                    после регистрации сообщения о преступлении в КУСП (3,10 или 30 суток)
                </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat1.kusp}"/>))</script>
            </td>
            <td><c:out value="${pamat1.kuspt}"/></td>
        </tr>

        <tr>
            <td>
                <label id="lab">6.1имеются ли в материалах постановления о продлении процессуальных сроков проверки
                </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat1.prodl}"/>))</script>
            </td>
            <td><c:out value="${pamat1.prodlt}"/></td>
        </tr>

        <tr>
            <td>
                <label id="lab">6.2соблюдены ли требования ч. 3 ст. 144 УПК РФ при продлении процессуальных сроков
                    проверки
                </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat1.st144}"/>))</script>
            </td>
            <td><c:out value="${pamat1.st144t}"/></td>
        </tr>

        <tr>
            <td>
                <label id="lab">7.в полном ли объеме исполнены мероприятия, изложенные в ходатайствах о продлении
                    процессуальных сроков
                </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat1.stoki}"/>))</script>
            </td>
            <td><c:out value="${pamat1.stokit}"/></td>
        </tr>

        <tr>
            <td>
                <label id="lab">8.получено ли объяснение от заявителя
                </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat1.zayv}"/>))</script>
            </td>
            <td><c:out value="${pamat1.zayvt}"/></td>
        </tr>

        <tr>
            <td>
                <label id="lab">9.имеются ли объяснения всех лиц, имеющих отношение к проверяемому событию
                </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat1.obysnen}"/>))</script>
            </td>
            <td><c:out value="${pamat1.obysnent}"/></td>
        </tr>

        <tr>
            <td>
                <label id="lab">10.проведены ли в рамках проверки соответствующие документальные проверки, ревизии,
                    судебные экспертизы, исследования документов, предметов, трупов
                </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat1.doc}"/>))</script>
            </td>
            <td><c:out value="${pamat1.doct}"/></td>
        </tr>

        <tr>
            <td>
                <label id="lab">11.исполнены ли в полном объеме письменные поручения о проведении оперативно-розыскных
                    мероприятий
                </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat1.pismmer}"/>))</script>
            </td>
            <td><c:out value="${pamat1.pismmert}"/></td>
        </tr>

        <tr>
            <td>
                <label id="lab">12.исполнены ли в полном объеме письменные указания о проведении конкретных проверочных
                    мероприятий
                </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat1.pismprov}"/>))</script>
            </td>
            <td><c:out value="${pamat1.pismprovt}"/></td>
        </tr>

        <tr>
            <td>
                <label id="lab">13.указаны ли в постановлении дата и место его вынесения
                </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat1.datavyn}"/>))</script>
            </td>
            <td><c:out value="${pamat1.datavynt}"/></td>
        </tr>

        <tr>
            <td>
                <label id="lab">14.cоответствуют ли нормы УПК РФ, указанные в постановлении об отказе в возбуждении
                    уголовного дела, действующему законодательствуя
                </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat1.upk}"/>))</script>
            </td>
            <td><c:out value="${pamat1.upkt}"/></td>
        </tr>

        <tr>
            <td>
                <label id="lab">15.правильно ли указаны основания, предусмотренные ст. 24 УПК РФ, в частности, отказ в
                    возбуждении уголовного дела на основании п. 2 ч. 1 ст. 24 УПК РФ допускается лишь в отношении
                    конкретного лица
                </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat1.st24}"/>))</script>
            </td>
            <td><c:out value="${pamat1.st24t}"/></td>
        </tr>

        <tr>
            <td>
                <label id="lab">16.правильно ли указана в постановлении квалификация преступления, в соответствии с УК
                    РФ, состав или событие которого отсутствует в чьих-либо действиях
                </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat1.kval}"/>))</script>
            </td>
            <td><c:out value="${pamat1.kvalt}"/></td>
        </tr>

        <tr>
            <td>
                <label id="lab">17.при вынесении постановления об отказе в возбуждении уголовного дела рассмотрен ли
                    вопрос об ответственности за заведомо ложный донос в отношении лица, заявившего или
                    распространившего сообщение о преступлении
                </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat1.donos}"/>))</script>
            </td>
            <td><c:out value="${pamat1.donost}"/></td>
        </tr>

        <tr>
            <td>
                <label id="lab">18.направлена ли для опубликования информация об отказе в возбуждении уголовного дела по
                    результатам проверки сообщения о преступлении, распространенного средством массовой
                    информации </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat1.smi}"/>))</script>
            </td>
            <td><c:out value="${pamat1.smit}"/></td>
        </tr>

        <tr>
            <td>
                <label id="lab">19.получено ли согласие руководителя следственного органа при вынесении постановления об
                    отказе в возбуждении уголовного дела при рассмотрении постановления прокурора о направлении
                    соответствующих материалов для решения вопроса об уголовном преследовании </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat1.organ}"/>))</script>
            </td>
            <td><c:out value="${pamat1.organt}"/></td>
        </tr>

        <tr>
            <td>
                <label id="lab">20.получено ли согласие на отказ в возбуждении уголовного дела в случаях, когда отказ в
                    возбуждении уголовного дела допускается только при наличии данного согласия </label></td>
            <td>
                <script>(isEven(<c:out value="${pamat1.soglas}"/>))</script>
            </td>
            <td><c:out value="${pamat1.soglast}"/></td>
        </tr>

        <tr>
            <td>
                <label id="lab">21.Соблюдены ли сроки направления копии постановления об отказе в возбуждении уголовного
                    дела заявителю и прокурору</label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat1.prokuror}"/>))</script>
            </td>
            <td><c:out value="${pamat1.prokurort}"/></td>
        </tr>

        <tr>
            <td>
                <label id="lab">22.разъяснены ли заявителю право на обжалование процессуального решения и его
                    порядок</label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat1.yasno}"/>))</script>
            </td>
            <td><c:out value="${pamat1.yasnot}"/></td>
        </tr>

        <tr>
            <td>
                <label id="lab">23.имеются ли основания для отмены постановления об отказе в возбуждении уголовного
                    дела</label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat1.osnova}"/>))</script>
            </td>
            <td><c:out value="${pamat1.osnovat}"/></td>
        </tr>

        <tr>
            <td>
                <label id="lab">24.истекли ли сроки давности привлечения к уголовной ответственности по составу
                    преступления, по которому отказано в возбуждении уголовного дела на момент отмены постановления об
                    отказе в возбуждении уголовного дела</label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat1.srokidavn}"/>))</script>
            </td>
            <td><c:out value="${pamat1.srokidavnt}"/></td>
        </tr>

        <tr>
            <td>
                <label id="lab">25.имеются ли основания для применения актов прокурорского реагирования при отсутствии
                    оснований для отмены постановления об отказе в возбуждении уголовного дела</label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat1.otmena}"/>))</script>
            </td>
            <td><c:out value="${pamat1.otmenat}"/></td>
        </tr>

        <tr>
            <td>
                <label id="lab">26.имеются ли основания для опроса заявителя, изменившего свое первичное обращение или
                    объяснение</label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat1.pervich}"/>))</script>
            </td>
            <td><c:out value="${pamat1.pervicht}"/></td>
        </tr>

        </tbody>
    </table>

</div>

<%@ include file="../ap/footer.jsp" %>
</body>
</html>

