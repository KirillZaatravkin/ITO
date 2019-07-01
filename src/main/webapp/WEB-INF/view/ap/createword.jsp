<%@ page import="java.util.*" %>
<%@page import="source.*" %>
<%@ page import="source.systemAP.Filter" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="static jdk.nashorn.internal.objects.NativeString.toUpperCase" %>
<%@ page import="source.systemAP.model.ApGIBDD" %>
<%@ page import="source.systemAP.model.ApPrist" %>
<%@ page import="source.systemAP.model.ApOVD" %>
<%@ page import="source.systemAP.CreateWord" %>


<% request.setCharacterEncoding("UTF-8");
    String lastname = toUpperCase(request.getParameter("lastname"));
    String firstname = toUpperCase(request.getParameter("firstname"));
    String middlename = toUpperCase(request.getParameter("middlename"));
    String STRbirthday = request.getParameter("birthday");


    if (STRbirthday != null && firstname != null && middlename != null && lastname != null) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = format.parse(STRbirthday);
        java.sql.Date SQLbirthday = new java.sql.Date(birthday.getTime());
        Filter filter = new Filter();

        List<ApOVD> apOVDs = filter.EchoFaceOVD(lastname, firstname, middlename, SQLbirthday);
        List<ApGIBDD> apGIBDDs = filter.EchoFaceGIBDD(lastname, firstname, middlename, SQLbirthday);
        List<ApPrist> apPrists = filter.EchoFacePrist(lastname, firstname, middlename, SQLbirthday);

        if(apOVDs.size()>0 || apGIBDDs.size()>0)
        {
               CreateWord cw= new CreateWord();
               cw.WordFindFace(apOVDs,apGIBDDs, apPrists,lastname, firstname, middlename,STRbirthday );
%>

<script> window.close() </script><%
        }
        else
        {
            %>
<script> window.close() </script>
<%
        }
    }%>
