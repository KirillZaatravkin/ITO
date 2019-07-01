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
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <title>ИТО</title>
    <style> <%@include file="../../css/style.css"%> </style>
</head>
<%@ include file="header_ud.jsp" %>
<%@ include file="sidebar_ud.jsp" %>

<body>


<div id="post">
    <form action="/pamat1" accept-charset="utf-8" method="POST">


        <table border=1>
            <thead>
            <tr>
                <th>Вопрос</th>
                <th>Ответ на вопрос</th>
                <th>Примечание</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>
                    <label id="lab">1.надлежащим ли должностным лицом вынесено постановление об отказе в возбуждении
                        уголовного дела</label>
                </td>
                <td><p><input name="face" type="radio" value="1"> Да</p>
                    <p><input name="face" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input type="text" name ="facet"></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">1.1.соблюдены ли правила подследственности в соответствии со ст.ст. 150, 151 УПК
                        РФ</label>
                </td>
                <td><p><input name="st150" type="radio" value="1"> Да</p>
                    <p><input name="st150" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input name ="st150t" type="text" ></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">2.имеется ли повод для проведения доследственной проверки в соответствии
                        со ст. 140 УПК РФ, в том числе
                    </label>
                </td>
                <td><p><input name="st140" type="radio" value="1"> Да</p>
                    <p><input name="st140" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input name ="st140t" type="text" ></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">2.1имелись ли основания для проведения процессуальной проверки
                    </label>
                </td>
                <td><p><input name="osnov" type="radio" value="1"> Да</p>
                    <p><input name="osnov" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input name ="osnovt" type="text" ></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">3.предупрежден ли заявитель об уголовной ответственности за заведомо ложный донос в соответствии со ст. 306 УК РФ
                    </label>
                </td>
                <td><p><input name="st306" type="radio" value="1"> Да</p>
                    <p><input name="st306" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input name ="st306t" type="text" ></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">4.имеется ли поручение прокурора органу дознания или руководителя следственного органа следователю о проведении проверки по сообщению о преступлении, распространенному в средствах массовой информации
                    </label>
                </td>
                <td><p><input name="poruc" type="radio" value="1"> Да</p>
                    <p><input name="poruc" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input name ="poruct" type="text" ></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">5.cоблюдены ли требования Инструкции « О порядке представления результатов оперативно-розыскной деятельности органу дознании, следователю или в суд» от 27.09.2013 №776/703/509/507/1820/42/535/398/68
                    </label>
                </td>
                <td><p><input name="inst776" type="radio" value="1"> Да</p>
                    <p><input name="inst776" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input name ="inst776t" type="text" ></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">5.1соответствуют ли материалы ОРД требованиям закона
                    </label>
                </td>
                <td><p><input name="ord" type="radio" value="1"> Да</p>
                    <p><input name="ord" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input name ="ordt" type="text" ></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">6.cоблюдены ли сроки вынесения постановления об отказе в возбуждении уголовного дела после регистрации сообщения о преступлении в КУСП (3,10 или 30 суток)
                    </label>
                </td>
                <td><p><input name="kusp" type="radio" value="1"> Да</p>
                    <p><input name="kusp" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input name ="kuspt" type="text" ></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">6.1имеются ли в материалах постановления о продлении процессуальных сроков проверки
                    </label>
                </td>
                <td><p><input name="prodl" type="radio" value="1"> Да</p>
                    <p><input name="prodl" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input name ="prodlt" type="text" ></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">6.2соблюдены ли требования ч. 3 ст. 144 УПК РФ при продлении процессуальных сроков проверки
                    </label>
                </td>
                <td><p><input name="st144" type="radio" value="1"> Да</p>
                    <p><input name="st144" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input name ="st144t" type="text" ></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">7.в полном ли объеме исполнены мероприятия, изложенные в ходатайствах о продлении процессуальных сроков
                    </label>
                </td>
                <td><p><input name="sroki" type="radio" value="1"> Да</p>
                    <p><input name="sroki" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input name ="srokit" type="text" ></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">8.получено ли объяснение от заявителя
                    </label>
                </td>
                <td><p><input name="zayv" type="radio" value="1"> Да</p>
                    <p><input name="zayv" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input name ="zayvt" type="text" ></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">9.имеются ли объяснения всех лиц, имеющих отношение к проверяемому событию
                    </label>
                </td>
                <td><p><input name="obysnen" type="radio" value="1"> Да</p>
                    <p><input name="obysnen" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input name ="obysnent" type="text" ></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">10.проведены ли в рамках проверки соответствующие документальные проверки, ревизии, судебные экспертизы, исследования документов, предметов, трупов
                    </label>
                </td>
                <td><p><input name="doc" type="radio" value="1"> Да</p>
                    <p><input name="doc" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input name ="doct" type="text" ></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">11.исполнены ли в полном объеме письменные поручения о проведении оперативно-розыскных мероприятий
                    </label>
                </td>
                <td><p><input name="pismmer" type="radio" value="1"> Да</p>
                    <p><input name="pismmer" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input name ="pismmert" type="text" ></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">12.исполнены ли в полном объеме письменные указания о проведении конкретных проверочных мероприятий
                    </label>
                </td>
                <td><p><input name="pismprov" type="radio" value="1"> Да</p>
                    <p><input name="pismprov" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input name ="pismprovt" type="text" ></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">13.указаны ли в постановлении дата и место его вынесения
                    </label>
                </td>
                <td><p><input name="datavyn" type="radio" value="1"> Да</p>
                    <p><input name="datavyn" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input name ="datavynt" type="text" ></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">14.cоответствуют ли нормы УПК РФ, указанные в постановлении об отказе в возбуждении уголовного дела, действующему законодательствуя
                    </label>
                </td>
                <td><p><input name="upk" type="radio" value="1"> Да</p>
                    <p><input name="upk" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input name ="upkt" type="text" ></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">15.правильно ли указаны основания, предусмотренные ст. 24 УПК РФ, в частности, отказ в возбуждении уголовного дела на основании п. 2 ч. 1 ст. 24 УПК РФ допускается лишь в отношении конкретного лица
                    </label>
                </td>
                <td><p><input name="st24" type="radio" value="1"> Да</p>
                    <p><input name="st24" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input name ="st24t" type="text" ></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">16.правильно ли указана в постановлении квалификация преступления, в соответствии с УК РФ, состав или событие которого отсутствует в чьих-либо действиях
                    </label>
                </td>
                <td><p><input name="kval" type="radio" value="1"> Да</p>
                    <p><input name="kval" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input name ="kvalt" type="text" ></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">17.при вынесении постановления об отказе в возбуждении уголовного дела рассмотрен ли вопрос об ответственности за заведомо ложный донос в отношении лица, заявившего или распространившего сообщение о преступлении
                    </label>
                </td>
                <td><p><input name="donos" type="radio" value="1"> Да</p>
                    <p><input name="donos" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input name ="donost" type="text" ></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">18.направлена ли для опубликования информация об отказе в возбуждении уголовного дела по результатам проверки сообщения о преступлении, распространенного средством массовой информации   </label>
                </td>
                <td><p><input name="smi" type="radio" value="1"> Да</p>
                    <p><input name="smi" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input name ="smit" type="text" ></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">19.получено ли согласие руководителя следственного органа при вынесении постановления об отказе в возбуждении уголовного дела при рассмотрении постановления прокурора о направлении соответствующих материалов для решения вопроса об уголовном преследовании </label>
                </td>
                <td><p><input name="organ" type="radio" value="1"> Да</p>
                    <p><input name="organ" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input name ="organt" type="text" ></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">20.получено ли согласие на отказ в возбуждении уголовного дела в случаях, когда отказ в возбуждении уголовного дела допускается только при наличии данного согласия </label>       </td>
                <td><p><input name="soglas" type="radio" value="1"> Да</p>
                    <p><input name="soglas" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input name ="soglast" type="text" ></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">21.Соблюдены ли сроки направления копии постановления об отказе в возбуждении уголовного дела заявителю и прокурору</label>
                </td>
                <td><p><input name="prokuror" type="radio" value="1"> Да</p>
                    <p><input name="prokuror" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input name ="prokurort" type="text" ></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">22.разъяснены ли заявителю право на обжалование процессуального решения и его порядок</label>
                </td>
                <td><p><input name="yasno" type="radio" value="1"> Да</p>
                    <p><input name="yasno" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input name ="yasnot" type="text" ></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">23.имеются ли основания для отмены постановления об отказе в возбуждении уголовного дела</label>
                </td>
                <td><p><input name="osnova" type="radio" value="1"> Да</p>
                    <p><input name="osnova" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input name ="osnovat" type="text" ></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">24.истекли ли сроки давности привлечения к уголовной ответственности по составу преступления, по которому отказано в возбуждении уголовного дела на момент отмены постановления об отказе в возбуждении уголовного дела</label>
                </td>
                <td><p><input name="srokidavn" type="radio" value="1"> Да</p>
                    <p><input name="srokidavn" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input name ="srokidavnt" type="text" ></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">25.имеются ли основания для применения актов прокурорского реагирования при  отсутствии оснований для отмены постановления об отказе в возбуждении уголовного дела</label>
                </td>
                <td><p><input name="otmena" type="radio" value="1"> Да</p>
                    <p><input name="otmena" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input name ="otmenat" type="text" ></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">26.имеются ли основания для опроса заявителя, изменившего свое первичное обращение или объяснение</label>
                </td>
                <td><p><input name="pervich" type="radio" value="1"> Да</p>
                    <p><input name="pervich" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input name ="pervicht" type="text" ></p></td>
            </tr>

            </tbody>
        </table>
        <input type="hidden" name="delo" value='<%=request.getParameter("delo")%>'/>
        <button type="submit" name="save">Сохранить</button>
    </form>
</div>

<%@ include file="../ap/footer.jsp" %>
</body>
</html>

