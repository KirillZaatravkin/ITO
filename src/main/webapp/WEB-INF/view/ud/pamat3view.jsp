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
                <label id="lab">1.Надлежащим ли лицом вынесено постановление (уголовное дело находится в производстве данного лица, либо оно входит в состав следственной группы), подписано ли оно должностным лицом</label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat3.s1}"/>))</script>
            </td>
            <td>
                <c:out value="${pamat3.t1}"/>
            </td>
        </tr>

        <tr>
            <td>
                <label id="lab">2.Указаны ли в постановлении место и дата его вынесения</label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat3.s2}"/>))</script>
            </td>
            <td>
                <c:out value="${pamat3.t2}"/>
            </td>
        </tr>

        <tr>
            <td>
                <label id="lab">3.Соответствуют ли номер уголовного дела и обстоятельства преступления постановлению о возбуждении дела   </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat3.s3}"/>))</script>
            </td>
            <td>
                <c:out value="${pamat3.t3}"/>
            </td>
        </tr>

        <tr>
            <td>
                <label id="lab">4.Отражены ли в постановлении основания для признания лица потерпевшим (причинение конкретному лицу физического, имущественного или морального вреда; причинение в отношении конкретного юридического лица вреда его имуществу или деловой репутации)  </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat3.s4}"/>))</script>
            </td>
            <td>
                <c:out value="${pamat3.t4}"/>
            </td>
        </tr>

        <tr>
            <td>
                <label id="lab">4.1.В случае, если последствием преступления явилась смерть лица, отражены ли основания признания потерпевшим другого лица  </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat3.s5}"/>))</script>
            </td>
            <td>
                <c:out value="${pamat3.t5}"/>
            </td>
        </tr>

        <tr>
            <td>
                <label id="lab">5.В случае признания потерпевшим юридического лица либо лица, которое в силу возраста, по своему физическому или психическому состоянию лишено возможности самостоятельно защищать свои права и законные интересы, допущен ли для участия в уголовном деле его представитель (законный представитель)  </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat3.s6}"/>))</script>
            </td>
            <td>
                <c:out value="${pamat3.t6}"/>
            </td>
        </tr>

        <tr>
            <td>
                <label id="lab">5.1.Надлежащее ли лицо допущено в качестве представителя (законного представителя) потерпевшего   </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat3.s7}"/>))</script>
            </td>
            <td>
                <c:out value="${pamat3.t7}"/>
            </td>
        </tr>

        <tr>
            <td>
                <label id="lab">6.Заявлено ли законным представителя потерпевшего, не достигшего возраста шестнадцати лет, в отношении которого совершено преступление против половой неприкосновенности, ходатайство об участии адвоката в качестве представителя несовершеннолетнего потерпевшего  </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat3.s8}"/>))</script>
            </td>
            <td>
                <c:out value="${pamat3.t8}"/>
            </td>
        </tr>


        <tr>
            <td>
                <label id="lab">6.1.Разрешено ли ходатайство законного представителя </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat3.s9}"/>))</script>
            </td>
            <td>
                <c:out value="${pamat3.t9}"/>
            </td>
        </tr>

        <tr>
            <td>
                <label id="lab">6.2.Допущен ли адвокат к участию в уголовном дела в качестве представителя несовершеннолетнего потерпевшего  </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat3.s10}"/>))</script>
            </td>
            <td>
                <c:out value="${pamat3.t10}"/>
            </td>
        </tr>

        <tr>
            <td>
                <label id="lab">7.Объявлено ли постановление о признании потерпевшим  </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat3.s11}"/>))</script>
            </td>
            <td>
                <c:out value="${pamat3.t11}"/>
            </td>
        </tr>

        <tr>
            <td>
                <label id="lab">8.Разъяснены ли потерпевшему (представителю, законному представителю) его права, обязанности, ответственность в соответствии с действующей редакцией УПК РФ   </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat3.s12}"/>))</script>
            </td>
            <td>
                <c:out value="${pamat3.t12}"/>
            </td>
        </tr>


        <tr>
            <td>
                <label id="lab">9.Разъяснено ли потерпевшему (представителю, законному представителю) право предъявления гражданского иска </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat3.s13}"/>))</script>
            </td>
            <td>
                <c:out value="${pamat3.t13}"/>
            </td>
        </tr>

        <tr>
            <td>
                <label id="lab">9.1.Заявлен ли гражданский иск  </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat3.s14}"/>))</script>
            </td>
            <td>
                <c:out value="${pamat3.t14}"/>
            </td>
        </tr>
        <tr>
            <td>
                <label id="lab"> 9.2.Вынесено ли постановление о признании лица, заявившего иск, гражданским истцом </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat3.s15}"/>))</script>
            </td>
            <td>
                <c:out value="${pamat3.t15}"/>
            </td>
        </tr>

        <tr>
            <td>
                <label id="lab">9.3.Вынесено ли постановление о привлечении обвиняемого в качестве гражданского ответчика  </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat3.s16}"/>))</script>
            </td>
            <td>
                <c:out value="${pamat3.t16}"/>
            </td>
        </tr>



        <tr>
            <td>
                <label id="lab">10.В случае причинения ущерба государству (субъекту Российской Федерации, муниципальному образованию), имеются ли основания для заявления иска прокурором  </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat3.s17}"/>))</script>
            </td>
            <td>
                <c:out value="${pamat3.t17}"/>
            </td>
        </tr>

        <tr>
            <td>
                <label id="lab">11.Проведен ли допрос потерпевшего  </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat3.s18}"/>))</script>
            </td>
            <td>
                <c:out value="${pamat3.t18}"/>
            </td>
        </tr>
        <tr>
            <td>
                <label id="lab">12.Соблюдены ли требования ч. 1 ст. 42 УПК РФ о незамедлительном признании лица потерпевшим </label>
            </td>
            <td>
                <script>(isEven(<c:out value="${pamat3.s19}"/>))</script>
            </td>
            <td>
                <c:out value="${pamat3.t19}"/>
            </td>
        </tr>

        </tbody>
    </table>

</div>

<%@ include file="../ap/footer.jsp" %>
</body>
</html>

