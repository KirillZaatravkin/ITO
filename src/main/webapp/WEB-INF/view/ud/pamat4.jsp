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
    <form action="/pamat4" accept-charset="utf-8" method="POST">


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
                    <label id="lab">1.Имеются ли основания задержания, предусмотренные ч.1 ст.91 УПК РФ</label>
                </td>
                <td><p><input name="s1" type="radio" value="1"> Да</p>
                    <p><input name="s1" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input type="text" name ="t1"></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">2.Указаны ли в постановлении место и дата его вынесения</label>
                </td>
                <td><p><input name="s2" type="radio" value="1"> Да</p>
                    <p><input name="s2" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input type="text" name ="t2"></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">3.Соответствуют ли номер уголовного дела и обстоятельства преступления постановлению о возбуждении дела </label>
                </td>
                <td><p><input name="s3" type="radio" value="1"> Да</p>
                    <p><input name="s3" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input type="text" name ="t3"></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">4.Отражены ли в постановлении основания для признания лица потерпевшим (причинение конкретному лицу физического, имущественного или морального вреда; причинение в отношении конкретного юридического лица вреда его имуществу или деловой репутации)</label>
                </td>
                <td><p><input name="s4" type="radio" value="1"> Да</p>
                    <p><input name="s4" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input type="text" name ="t4"></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">4.1.В случае, если последствием преступления явилась смерть лица, отражены ли основания признания потерпевшим другого лица</label>
                </td>
                <td><p><input name="s5" type="radio" value="1"> Да</p>
                    <p><input name="s5" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input type="text" name ="t5"></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">5.В случае признания потерпевшим юридического лица либо лица, которое в силу возраста, по своему физическому или психическому состоянию лишено возможности самостоятельно защищать свои права и законные интересы, допущен ли для участия в уголовном деле его представитель (законный представитель)</label>
                </td>
                <td><p><input name="s6" type="radio" value="1"> Да</p>
                    <p><input name="s6" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input type="text" name ="t6"></p></td>
            </tr>


            <tr>
                <td>
                    <label id="lab">5.1.Надлежащее ли лицо допущено в качестве представителя (законного представителя) потерпевшего </label>
                </td>
                <td><p><input name="s7" type="radio" value="1"> Да</p>
                    <p><input name="s7" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input type="text" name ="t7"></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">6.Заявлено ли законным представителя потерпевшего, не достигшего возраста шестнадцати лет, в отношении которого совершено преступление против половой неприкосновенности, ходатайство об участии адвоката в качестве представителя несовершеннолетнего потерпевшего</label>
                </td>
                <td><p><input name="s8" type="radio" value="1"> Да</p>
                    <p><input name="s8" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input type="text" name ="t8"></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">6.1.Разрешено ли ходатайство законного представителя</label>
                </td>
                <td><p><input name="s9" type="radio" value="1"> Да</p>
                    <p><input name="s9" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input type="text" name ="t9"></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">6.2.Допущен ли адвокат к участию в уголовном дела в качестве представителя несовершеннолетнего потерпевшего</label>
                </td>
                <td><p><input name="s10" type="radio" value="1"> Да</p>
                    <p><input name="s10" type="radio" value="0"> Нет</p>


                </td>
                <td><p><input type="text" name ="t10"></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">7.Объявлено ли постановление о признании потерпевшим</label>
                </td>
                <td><p><input name="s11" type="radio" value="1"> Да</p>
                    <p><input name="s11" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input type="text" name ="t11"></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">8.Разъяснены ли потерпевшему (представителю, законному представителю) его права, обязанности, ответственность в соответствии с действующей редакцией УПК РФ </label>
                </td>
                <td><p><input name="s12" type="radio" value="1"> Да</p>
                    <p><input name="s12" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input type="text" name ="t12"></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">9.Разъяснено ли потерпевшему (представителю, законному представителю) право предъявления гражданского иска</label>
                </td>
                <td><p><input name="s13" type="radio" value="1"> Да</p>
                    <p><input name="s13" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input type="text" name ="t13"></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">9.1.Заявлен ли гражданский иск</label>
                </td>
                <td><p><input name="s14" type="radio" value="1"> Да</p>
                    <p><input name="s14" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input type="text" name ="t14"></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">9.2.Вынесено ли постановление о признании лица, заявившего иск, гражданским истцом</label>
                </td>
                <td><p><input name="s15" type="radio" value="1"> Да</p>
                    <p><input name="s15" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input type="text" name ="t15"></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">9.3.Вынесено ли постановление о привлечении обвиняемого в качестве гражданского ответчика</label>
                </td>
                <td><p><input name="s16" type="radio" value="1"> Да</p>
                    <p><input name="s16" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input type="text" name ="t16"></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">10.В случае причинения ущерба государству (субъекту Российской Федерации, муниципальному образованию), имеются ли основания для заявления иска прокурором</label>
                </td>
                <td><p><input name="s17" type="radio" value="1"> Да</p>
                    <p><input name="s17" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input type="text" name ="t17"></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">11.Проведен ли допрос потерпевшего</label>
                </td>
                <td><p><input name="s18" type="radio" value="1"> Да</p>
                    <p><input name="s18" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input type="text" name ="t18"></p></td>
            </tr>

            <tr>
                <td>
                    <label id="lab">12.Соблюдены ли требования ч. 1 ст. 42 УПК РФ о незамедлительном признании лица потерпевшим</label>
                </td>
                <td><p><input name="s19" type="radio" value="1"> Да</p>
                    <p><input name="s19" type="radio" value="0"> Нет</p>
                </td>
                <td><p><input type="text" name ="t19"></p></td>
            </tr>

            </tbody>
        </table>
        <input type="hidden" name="delo" value='<%=request.getParameter("delo")%>'/>
        <input type="hidden" name="type" value='3'/>
        <button type="submit" name="save">Сохранить</button>
    </form>
</div>

<%@ include file="../ap/footer.jsp" %>
</body>
</html>

