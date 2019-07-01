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
    <form action="/pamat2" accept-charset="utf-8" method="POST">


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
                    <label id="lab">1.Надлежащим ли должностным лицом возбуждено уголовное делоа</label>
                </td>
                <td><p><input name="face" type="radio" value="1"> Да</p>
                    <p><input name="face" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input type="text" name ="facet"></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">2.Соблюдены ли сроки возбуждения уголовного дела после регистрации сообщения о преступлении в КУСП (3,10 или 30 суток)</label>
                </td>
                <td><p><input name="kusp" type="radio" value="1"> Да</p>
                    <p><input name="kusp" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input name ="kuspt" type="text" ></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">3.Имеются ли в материалах постановления о продлении процессуальных сроков проверки
                    </label>
                </td>
                <td><p><input name="sroki" type="radio" value="1"> Да</p>
                    <p><input name="sroki" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input name ="srokit" type="text" ></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">4.Указано ли в постановлении дата, время и место его вынесения
                    </label>
                </td>
                <td><p><input name="datapost" type="radio" value="1"> Да</p>
                    <p><input name="datapost" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input name ="datapostt" type="text" ></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">5.Указано ли в постановлении повод и основания для возбуждения уголовного дела </label>
                </td>
                <td><p><input name="povod" type="radio" value="1"> Да</p>
                    <p><input name="povod" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input name ="povodt" type="text" ></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">6.Соответствуют ли нормы УПК РФ, указанные в постановлении о возбуждении уголовного дела, действующему законодательству
                    </label>
                </td>
                <td><p><input name="upk" type="radio" value="1"> Да</p>
                    <p><input name="upk" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input name ="upkt" type="text" ></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab"> 7.Соблюдены ли сроки предоставлении прокурору копии постановления о возбуждении уголовного дела </label>
                </td>
                <td><p><input name="prok" type="radio" value="1"> Да</p>
                    <p><input name="prok" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input name ="prokt" type="text" ></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">8.Уведомлены ли заинтересованные лица о факте возбуждения уголовного дела  (заявитель, при возбуждении уголовного дела в отношении конкретного лица – подозреваемый)
                    </label>
                </td>
                <td><p><input name="uved" type="radio" value="1"> Да</p>
                    <p><input name="uved" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input name ="uvedt" type="text" ></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">9.Соблюден ли порядок, предусмотренный ст.147 УПК РФ о возбуждении уголовного дела, указанных в ч.2 ст.20 УПК РФ (дела частного обвинения)
                    </label>
                </td>
                <td><p><input name="st147" type="radio" value="1"> Да</p>
                    <p><input name="st147" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input name ="st147t" type="text" ></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">10.Не имеется ли оснований для отвода следователя (дознавателя)
                    </label>
                </td>
                <td><p><input name="otvod" type="radio" value="1"> Да</p>
                    <p><input name="otvod" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input name ="otvodt" type="text" ></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">11.Указаны ли в постановлении данные, свидетельствующие о наличии признаков преступления
                    </label>
                </td>
                <td><p><input name="prest" type="radio" value="1"> Да</p>
                    <p><input name="prest" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input name ="prestt" type="text" ></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">11.1.Дата и время совершения преступления
                    </label>
                </td>
                <td><p><input name="dataprest" type="radio" value="1"> Да</p>
                    <p><input name="dataprest" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input name ="dataprestt" type="text" ></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">11.2.Место совершения преступления
                    </label>
                </td>
                <td><p><input name="mesto" type="radio" value="1"> Да</p>
                    <p><input name="mesto" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input name ="mestot" type="text" ></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">11.3.Cпособ совершения преступления
                    </label>
                </td>
                <td><p><input name="sposob" type="radio" value="1"> Да</p>
                    <p><input name="sposob" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input name ="sposobt" type="text" ></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">11.4.Характер и размер вреда, причиненного в результате преступления     </label>
                </td>
                <td><p><input name="har" type="radio" value="1"> Да</p>
                    <p><input name="har" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input name ="hart" type="text" ></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">12.Верной ли является квалификация преступления, по статье УК РФ
                    </label>
                </td>
                <td><p><input name="kval" type="radio" value="1"> Да</p>
                    <p><input name="kval" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input name ="kvalt" type="text" ></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">13.Достаточно ли в материалах данных, свидетельствующих о наличии признаков преступления
                    </label>
                </td>
                <td><p><input name="mat" type="radio" value="1"> Да</p>
                    <p><input name="mat" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input name ="matt" type="text" ></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">14.Соблюдены ли требования Инструкции « О порядке представления результатов оперативно-розыскной
                        деятельности органу дознании, следователю или в суд» от 27.09.2013 №776/703/509/507/1820/42/535/398/68

                    </label>
                </td>
                <td><p><input name="inst" type="radio" value="1"> Да</p>
                    <p><input name="inst" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input name ="instt" type="text" ></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">14.1.Cоответствуют ли материалы ОРД требованиям закона. </label>
                </td>
                <td><p><input name="ord" type="radio" value="1"> Да</p>
                    <p><input name="ord" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input name ="ordt" type="text" ></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">15.Соблюдён ли порядок возбуждения уголовного дела</label>
                </td>
                <td><p><input name="ud" type="radio" value="1"> Да</p>
                    <p><input name="ud" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input name ="udt" type="text" ></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">15.1.B отношении категорий лиц, приведённых в ст.447 УПК РФ</label>
                </td>
                <td><p><input name="st447" type="radio" value="1"> Да</p>
                    <p><input name="st447" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input name ="st447t" type="text" ></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">15.2.Hе нарушена ли подследственность, в том числе в отношении военнослужащих</label>
                </td>
                <td><p><input name="podsled" type="radio" value="1"> Да</p>
                    <p><input name="podsled" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input name ="podsledt" type="text" ></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">15.3.Hе истекли ли сроки давности привлечения к уголовной ответственности</label>
                </td>
                <td><p><input name="sroku" type="radio" value="1"> Да</p>
                    <p><input name="sroku" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input name ="srokut" type="text" ></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">15.4.Hе имеется ли неотменённого приговора суда, постановления о прекращении дела либо постановления об отказе в возбуждении уголовного дела по этому же факту</label>
                </td>
                <td><p><input name="prig" type="radio" value="1"> Да</p>
                    <p><input name="prig" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input name ="prigt" type="text" ></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">16.Нет ли иных оснований, препятствующих возбуждению уголовного дела.</label>
                </td>
                <td><p><input name="inyi" type="radio" value="1"> Да</p>
                    <p><input name="inyi" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input name ="inyit" type="text" ></p></td>
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

