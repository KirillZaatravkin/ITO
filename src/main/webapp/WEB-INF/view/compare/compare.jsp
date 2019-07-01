<%@ page import="source.systemUD.service.ParseDOCXService" %>
<%@ page import="source.systemUD.model.ParagraphCompare" %>
<%@ page import="java.util.List" %>
<%@ page import="org.springframework.web.multipart.MultipartFile" %>
<%@ page import="java.util.ArrayList" %>
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <title>ИТО</title>
    <style> <%@include file="../../css/style.css"%> </style>
</head>
<%@ include file="header_compare.jsp" %>
<%@ include file="../ud/sidebar_ud.jsp" %>
<body>


<div id="post">

    <label id="lab">Внимание! Используйте документы в формате docx.</label>
    <form action="${fileUploadControllerURL}" method="post"
          enctype="multipart/form-data">
        <table>
            <tr>
                <td><b>Документ 1:</b></td>
                <td><input type="file" name="file1"></td>

            </tr>

            <tr>
                <td><b>Документ 2:</b></td>
                <td><input type="file" name="file2"></td>
                <td><input type="submit" value="сравнить"></td>
            </tr>
        </table>
    </form>


    <% ArrayList<ParagraphCompare> parList = (ArrayList<ParagraphCompare>) request.getAttribute("parList");
        if (parList != null) {%>
    <div id="kol_compare">


        <div id="left_kol_compare"><%
            int temp = 0;
            for (int i = 0; i < parList.size(); i++) {
                if (temp != parList.get(i).getPn()) {
        %>
            <p></p>

            <%
                }
                temp=parList.get(i).getPn();

                if (parList.get(i).getK() == 1) {
                    if (parList.get(i).isFlagCompare() == true) {%>

            <label style="color: green"><%= parList.get(i).getPs()%>
            </label>

            <% } else {%>

            <label style="color: #e01e0a"><%= parList.get(i).getPs() %>
            </label>
            <%
                        }
                    }
                }
            %>
        </div>


        <div id="right_kol_compare"><%

            temp=0;

            for (int i = 0; i < parList.size(); i++) {
                if (temp != parList.get(i).getPn()) {
        %>
            <p></p>

            <%
                }
                temp=parList.get(i).getPn();

                if (parList.get(i).getK() == 2) {
                    if (parList.get(i).isFlagCompare()) {%>

            <label style="color: green"><%= parList.get(i).getPs()%>
            </label>

            <% } else {%>

            <label style="color: #e01e0a"><%= parList.get(i).getPs() %>
            </label>
            <%
                        }
                    }
                }
            %>
        </div>
    </div>
    <%}%>

</div>

<%@ include file="../ap/footer.jsp" %>
</body>
</html>