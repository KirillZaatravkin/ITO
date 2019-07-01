package source.systemAP;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import source.DbConnect;
import source.systemAP.model.ArticleStat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static jdk.nashorn.internal.objects.NativeString.toUpperCase;

/**
 * Created by кирюха on 13.06.2018.
 */
public class ArticleResediv {

    private Connection connection;
    private Authentication authentication;

    public List<ArticleStat> FilterStat(String article, java.sql.Date d1, java.sql.Date d2, String sorts, String interval, String cact, String regionMask, int volume) {

        long curr = System.currentTimeMillis();

        connection = DbConnect.getConnection();
        authentication = SecurityContextHolder.getContext().getAuthentication();

        List<ArticleStat> stat = new ArrayList<ArticleStat>();
        PreparedStatement statement = null;
        PreparedStatement statementDrop = null;
        ResultSet rs = null;
        ResultSet rsDrop = null;
        try {


            try {
                String queryDrop = "drop TABLE temp_" + authentication.getName() + ";";
                statementDrop = connection.prepareStatement(queryDrop);
                rsDrop = statementDrop.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                String queryOVD = "create TABLE temp_" + authentication.getName() + " ( article TEXT,   cact TEXT,   datep DATE,   datepost DATE,   datezak DATE,   nakaz TEXT,   protokoln TEXT,   facktaddr TEXT,   pasportn TEXT,   pasports TEXT,   vodud TEXT,   organ TEXT,  lastname TEXT,   firstname TEXT,   middlename TEXT,   birthday DATE,   datecreate DATE ,   resaddr TEXT );";
                statement = connection.prepareStatement(queryOVD);
                rs = statement.executeQuery();
            } catch (
                    SQLException e) {
                e.printStackTrace();
            }

            if (article.equals("7.27")) {
                try {
                    String queryGIBDD = "INSERT INTO   temp_" + authentication.getName() + " SELECT  * from dblink ('dbname= gibdd user= root password =1' ,  'select  article,cact, datep, datepost, datezak, nakaz, protokoln, facktaddr, pasportn, pasports, vodud, organ, lastname, firstname, middlename, birthday, datecreate, resaddr from st_7_27') as t1 (  article text, cact text, datep date, datepost date, datezak date, nakaz text, protokoln text, facktaddr text, pasportn text, pasports text, vodud text, organ text, lastname text, firstname text, middlename text, birthday date, datecreate date, resaadr text);";
                    System.out.println(queryGIBDD);
                    statement = connection.prepareStatement(queryGIBDD);
                    rs = statement.executeQuery();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    String queryOVD = "INSERT INTO   temp_" + authentication.getName() + " SELECT  * from dblink ('dbname= ovd user= root password =1' ,  'select  article,cact, datep, datepost, datezak, nakaz, protokoln, facktaddr, pasportn, pasports, vodud, organ, lastname, firstname, middlename, birthday, datecreate, resaddr from st_7_27') as t1 (  article text, cact text, datep date, datepost date, datezak date, nakaz text, protokoln text, facktaddr text, pasportn text, pasports text, vodud text, organ text, lastname text, firstname text, middlename text, birthday date, datecreate date, resaadr text);";
                    System.out.println(queryOVD);
                    statement = connection.prepareStatement(queryOVD);
                    rs = statement.executeQuery();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                try {
                    String queryPrist = "INSERT INTO   temp_" + authentication.getName() + " SELECT  * from dblink ('dbname= fssp user= root password =1' ,  'select  article,cact, datep, datepost, datezak, nakaz, protokoln, facktaddr, pasportn, pasports, vodud, organ, lastname, firstname, middlename, birthday, datecreate, resaddr from st_7_27') as t1 (  article text, cact text, datep date, datepost date, datezak date, nakaz text, protokoln text, facktaddr text, pasportn text, pasports text, vodud text, organ text, lastname text, firstname text, middlename text, birthday date, datecreate date, resaadr text);";
                    System.out.println(queryPrist);
                    statement = connection.prepareStatement(queryPrist);
                    rs = statement.executeQuery();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else if (article.equals("5.35.1")) {
                try {
                    String queryGIBDD = "INSERT INTO   temp_" + authentication.getName() + " SELECT  * from dblink ('dbname= gibdd user= root password =1' ,  'select  article,cact, datep, datepost, datezak, nakaz, protokoln, facktaddr, pasportn, pasports, vodud, organ, lastname, firstname, middlename, birthday, datecreate, resaddr from st_5_35_1') as t1 (  article text, cact text, datep date, datepost date, datezak date, nakaz text, protokoln text, facktaddr text, pasportn text, pasports text, vodud text, organ text, lastname text, firstname text, middlename text, birthday date, datecreate date, resaadr text);";
                    System.out.println(queryGIBDD);
                    statement = connection.prepareStatement(queryGIBDD);
                    rs = statement.executeQuery();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    String queryOVD = "INSERT INTO   temp_" + authentication.getName() + " SELECT  * from dblink ('dbname= ovd user= root password =1' ,  'select  article,cact, datep, datepost, datezak, nakaz, protokoln, facktaddr, pasportn, pasports, vodud, organ, lastname, firstname, middlename, birthday, datecreate, resaddr from st_5_35_1') as t1 (  article text, cact text, datep date, datepost date, datezak date, nakaz text, protokoln text, facktaddr text, pasportn text, pasports text, vodud text, organ text, lastname text, firstname text, middlename text, birthday date, datecreate date, resaadr text);";
                    System.out.println(queryOVD);
                    statement = connection.prepareStatement(queryOVD);
                    rs = statement.executeQuery();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                try {
                    String queryPrist = "INSERT INTO   temp_" + authentication.getName() + " SELECT  * from dblink ('dbname= fssp user= root password =1' ,  'select  article,cact, datep, datepost, datezak, nakaz, protokoln, facktaddr, pasportn, pasports, vodud, organ, lastname, firstname, middlename, birthday, datecreate, resaddr from st_5_35_1') as t1 (  article text, cact text, datep date, datepost date, datezak date, nakaz text, protokoln text, facktaddr text, pasportn text, pasports text, vodud text, organ text, lastname text, firstname text, middlename text, birthday date, datecreate date, resaadr text);";
                    System.out.println(queryPrist);
                    statement = connection.prepareStatement(queryPrist);
                    rs = statement.executeQuery();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else if (article.equals("14.16")) {
                try {
                    String queryGIBDD = "INSERT INTO   temp_" + authentication.getName() + " SELECT  * from dblink ('dbname= gibdd user= root password =1' ,  'select  article,cact, datep, datepost, datezak, nakaz, protokoln, facktaddr, pasportn, pasports, vodud, organ, lastname, firstname, middlename, birthday, datecreate, resaddr from st_14_16') as t1 (  article text, cact text, datep date, datepost date, datezak date, nakaz text, protokoln text, facktaddr text, pasportn text, pasports text, vodud text, organ text, lastname text, firstname text, middlename text, birthday date, datecreate date, resaadr text);";
                    System.out.println(queryGIBDD);
                    statement = connection.prepareStatement(queryGIBDD);
                    rs = statement.executeQuery();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    String queryOVD = "INSERT INTO   temp_" + authentication.getName() + " SELECT  * from dblink ('dbname= ovd user= root password =1' ,  'select  article,cact, datep, datepost, datezak, nakaz, protokoln, facktaddr, pasportn, pasports, vodud, organ, lastname, firstname, middlename, birthday, datecreate, resaddr from st_14_16') as t1 (  article text, cact text, datep date, datepost date, datezak date, nakaz text, protokoln text, facktaddr text, pasportn text, pasports text, vodud text, organ text, lastname text, firstname text, middlename text, birthday date, datecreate date, resaadr text);";
                    System.out.println(queryOVD);
                    statement = connection.prepareStatement(queryOVD);
                    rs = statement.executeQuery();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                try {
                    String queryPrist = "INSERT INTO   temp_" + authentication.getName() + " SELECT  * from dblink ('dbname= fssp user= root password =1' ,  'select  article,cact, datep, datepost, datezak, nakaz, protokoln, facktaddr, pasportn, pasports, vodud, organ, lastname, firstname, middlename, birthday, datecreate, resaddr from st_14_16') as t1 (  article text, cact text, datep date, datepost date, datezak date, nakaz text, protokoln text, facktaddr text, pasportn text, pasports text, vodud text, organ text, lastname text, firstname text, middlename text, birthday date, datecreate date, resaadr text);";
                    System.out.println(queryPrist);
                    statement = connection.prepareStatement(queryPrist);
                    rs = statement.executeQuery();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else if (article.equals("12.8_12.26")) {
                try {
                    String queryGIBDD = "INSERT INTO   temp_" + authentication.getName() + " SELECT  * from dblink ('dbname= gibdd user= root password =1' ,  'select  article,cact, datep, datepost, datezak, nakaz, protokoln, facktaddr, pasportn, pasports, vodud, organ, lastname, firstname, middlename, birthday, datecreate, resaddr from st_12_8_st_12_6') as t1 (  article text, cact text, datep date, datepost date, datezak date, nakaz text, protokoln text, facktaddr text, pasportn text, pasports text, vodud text, organ text, lastname text, firstname text, middlename text, birthday date, datecreate date, resaadr text);";
                    System.out.println(queryGIBDD);
                    statement = connection.prepareStatement(queryGIBDD);
                    rs = statement.executeQuery();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    String queryOVD = "INSERT INTO   temp_" + authentication.getName() + " SELECT  * from dblink ('dbname= ovd user= root password =1' ,  'select  article,cact, datep, datepost, datezak, nakaz, protokoln, facktaddr, pasportn, pasports, vodud, organ, lastname, firstname, middlename, birthday, datecreate, resaddr from st_12_8_st_12_6') as t1 (  article text, cact text, datep date, datepost date, datezak date, nakaz text, protokoln text, facktaddr text, pasportn text, pasports text, vodud text, organ text, lastname text, firstname text, middlename text, birthday date, datecreate date, resaadr text);";
                    System.out.println(queryOVD);
                    statement = connection.prepareStatement(queryOVD);
                    rs = statement.executeQuery();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                try {
                    String queryPrist = "INSERT INTO   temp_" + authentication.getName() + " SELECT  * from dblink ('dbname= fssp user= root password =1' ,  'select  article,cact, datep, datepost, datezak, nakaz, protokoln, facktaddr, pasportn, pasports, vodud, organ, lastname, firstname, middlename, birthday, datecreate, resaddr from st_12_8_st_12_6') as t1 (  article text, cact text, datep date, datepost date, datezak date, nakaz text, protokoln text, facktaddr text, pasportn text, pasports text, vodud text, organ text, lastname text, firstname text, middlename text, birthday date, datecreate date, resaadr text);";
                    System.out.println(queryPrist);
                    statement = connection.prepareStatement(queryPrist);
                    rs = statement.executeQuery();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else if (article.equals("6.1.1")) {
                try {
                    String queryGIBDD = "INSERT INTO   temp_" + authentication.getName() + " SELECT  * from dblink ('dbname= gibdd user= root password =1' ,  'select  article,cact, datep, datepost, datezak, nakaz, protokoln, facktaddr, pasportn, pasports, vodud, organ, lastname, firstname, middlename, birthday, datecreate, resaddr from st_6_1_1') as t1 (  article text, cact text, datep date, datepost date, datezak date, nakaz text, protokoln text, facktaddr text, pasportn text, pasports text, vodud text, organ text, lastname text, firstname text, middlename text, birthday date, datecreate date, resaadr text);";
                    System.out.println(queryGIBDD);
                    statement = connection.prepareStatement(queryGIBDD);
                    rs = statement.executeQuery();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    String queryOVD = "INSERT INTO   temp_" + authentication.getName() + " SELECT  * from dblink ('dbname= ovd user= root password =1' ,  'select  article,cact, datep, datepost, datezak, nakaz, protokoln, facktaddr, pasportn, pasports, vodud, organ, lastname, firstname, middlename, birthday, datecreate, resaddr from st_6_1_1') as t1 (  article text, cact text, datep date, datepost date, datezak date, nakaz text, protokoln text, facktaddr text, pasportn text, pasports text, vodud text, organ text, lastname text, firstname text, middlename text, birthday date, datecreate date, resaadr text);";
                    System.out.println(queryOVD);
                    statement = connection.prepareStatement(queryOVD);
                    rs = statement.executeQuery();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                try {
                    String queryPrist = "INSERT INTO   temp_" + authentication.getName() + " SELECT  * from dblink ('dbname= fssp user= root password =1' ,  'select  article,cact, datep, datepost, datezak, nakaz, protokoln, facktaddr, pasportn, pasports, vodud, organ, lastname, firstname, middlename, birthday, datecreate, resaddr from st_6_1_1') as t1 (  article text, cact text, datep date, datepost date, datezak date, nakaz text, protokoln text, facktaddr text, pasportn text, pasports text, vodud text, organ text, lastname text, firstname text, middlename text, birthday date, datecreate date, resaadr text);";
                    System.out.println(queryPrist);
                    statement = connection.prepareStatement(queryPrist);
                    rs = statement.executeQuery();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else if (article.equals("14.17.1")) {
                try {
                    String queryGIBDD = "INSERT INTO   temp_" + authentication.getName() + " SELECT  * from dblink ('dbname= gibdd user= root password =1' ,  'select  article,cact, datep, datepost, datezak, nakaz, protokoln, facktaddr, pasportn, pasports, vodud, organ, lastname, firstname, middlename, birthday, datecreate, resaddr from st_14_17_1') as t1 (  article text, cact text, datep date, datepost date, datezak date, nakaz text, protokoln text, facktaddr text, pasportn text, pasports text, vodud text, organ text, lastname text, firstname text, middlename text, birthday date, datecreate date, resaadr text);";
                    System.out.println(queryGIBDD);
                    statement = connection.prepareStatement(queryGIBDD);
                    rs = statement.executeQuery();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    String queryOVD = "INSERT INTO   temp_" + authentication.getName() + " SELECT  * from dblink ('dbname= ovd user= root password =1' ,  'select  article,cact, datep, datepost, datezak, nakaz, protokoln, facktaddr, pasportn, pasports, vodud, organ, lastname, firstname, middlename, birthday, datecreate, resaddr from  st_14_17_1') as t1 (  article text, cact text, datep date, datepost date, datezak date, nakaz text, protokoln text, facktaddr text, pasportn text, pasports text, vodud text, organ text, lastname text, firstname text, middlename text, birthday date, datecreate date, resaadr text);";
                    System.out.println(queryOVD);
                    statement = connection.prepareStatement(queryOVD);
                    rs = statement.executeQuery();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                try {
                    String queryPrist = "INSERT INTO   temp_" + authentication.getName() + " SELECT  * from dblink ('dbname= fssp user= root password =1' ,  'select  article,cact, datep, datepost, datezak, nakaz, protokoln, facktaddr, pasportn, pasports, vodud, organ, lastname, firstname, middlename, birthday, datecreate, resaddr from  st_14_17_1') as t1 (  article text, cact text, datep date, datepost date, datezak date, nakaz text, protokoln text, facktaddr text, pasportn text, pasports text, vodud text, organ text, lastname text, firstname text, middlename text, birthday date, datecreate date, resaadr text);";
                    System.out.println(queryPrist);
                    statement = connection.prepareStatement(queryPrist);
                    rs = statement.executeQuery();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else if (article.equals("20.2")) {
                try {
                    String queryGIBDD = "INSERT INTO   temp_" + authentication.getName() + " SELECT  * from dblink ('dbname= gibdd user= root password =1' ,  'select  article,cact, datep, datepost, datezak, nakaz, protokoln, facktaddr, pasportn, pasports, vodud, organ, lastname, firstname, middlename, birthday, datecreate, resaddr from st_20_2') as t1 (  article text, cact text, datep date, datepost date, datezak date, nakaz text, protokoln text, facktaddr text, pasportn text, pasports text, vodud text, organ text, lastname text, firstname text, middlename text, birthday date, datecreate date, resaadr text);";
                    System.out.println(queryGIBDD);
                    statement = connection.prepareStatement(queryGIBDD);
                    rs = statement.executeQuery();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    String queryOVD = "INSERT INTO   temp_" + authentication.getName() + " SELECT  * from dblink ('dbname= ovd user= root password =1' ,  'select  article,cact, datep, datepost, datezak, nakaz, protokoln, facktaddr, pasportn, pasports, vodud, organ, lastname, firstname, middlename, birthday, datecreate, resaddr from  st_20_2') as t1 (  article text, cact text, datep date, datepost date, datezak date, nakaz text, protokoln text, facktaddr text, pasportn text, pasports text, vodud text, organ text, lastname text, firstname text, middlename text, birthday date, datecreate date, resaadr text);";
                    System.out.println(queryOVD);
                    statement = connection.prepareStatement(queryOVD);
                    rs = statement.executeQuery();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                try {
                    String queryPrist = "INSERT INTO   temp_" + authentication.getName() + " SELECT  * from dblink ('dbname= fssp user= root password =1' ,  'select  article,cact, datep, datepost, datezak, nakaz, protokoln, facktaddr, pasportn, pasports, vodud, organ, lastname, firstname, middlename, birthday, datecreate, resaddr from  st_20_2') as t1 (  article text, cact text, datep date, datepost date, datezak date, nakaz text, protokoln text, facktaddr text, pasportn text, pasports text, vodud text, organ text, lastname text, firstname text, middlename text, birthday date, datecreate date, resaadr text);";
                    System.out.println(queryPrist);
                    statement = connection.prepareStatement(queryPrist);
                    rs = statement.executeQuery();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else if (article.equals("20.17")) {
                try {
                    String queryGIBDD = "INSERT INTO   temp_" + authentication.getName() + " SELECT  * from dblink ('dbname= gibdd user= root password =1' ,  'select  article,cact, datep, datepost, datezak, nakaz, protokoln, facktaddr, pasportn, pasports, vodud, organ, lastname, firstname, middlename, birthday, datecreate, resaddr from st_20_17') as t1 (  article text, cact text, datep date, datepost date, datezak date, nakaz text, protokoln text, facktaddr text, pasportn text, pasports text, vodud text, organ text, lastname text, firstname text, middlename text, birthday date, datecreate date, resaadr text);";
                    System.out.println(queryGIBDD);
                    statement = connection.prepareStatement(queryGIBDD);
                    rs = statement.executeQuery();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    String queryOVD = "INSERT INTO   temp_" + authentication.getName() + " SELECT  * from dblink ('dbname= ovd user= root password =1' ,  'select  article,cact, datep, datepost, datezak, nakaz, protokoln, facktaddr, pasportn, pasports, vodud, organ, lastname, firstname, middlename, birthday, datecreate, resaddr from  st_20_17') as t1 (  article text, cact text, datep date, datepost date, datezak date, nakaz text, protokoln text, facktaddr text, pasportn text, pasports text, vodud text, organ text, lastname text, firstname text, middlename text, birthday date, datecreate date, resaadr text);";
                    System.out.println(queryOVD);
                    statement = connection.prepareStatement(queryOVD);
                    rs = statement.executeQuery();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                try {
                    String queryPrist = "INSERT INTO   temp_" + authentication.getName() + " SELECT  * from dblink ('dbname= fssp user= root password =1' ,  'select  article,cact, datep, datepost, datezak, nakaz, protokoln, facktaddr, pasportn, pasports, vodud, organ, lastname, firstname, middlename, birthday, datecreate, resaddr from  st_20_17') as t1 (  article text, cact text, datep date, datepost date, datezak date, nakaz text, protokoln text, facktaddr text, pasportn text, pasports text, vodud text, organ text, lastname text, firstname text, middlename text, birthday date, datecreate date, resaadr text);";
                    System.out.println(queryPrist);
                    statement = connection.prepareStatement(queryPrist);
                    rs = statement.executeQuery();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else if (article.equals("20.33")) {
                try {
                    String queryGIBDD = "INSERT INTO   temp_" + authentication.getName() + " SELECT  * from dblink ('dbname= gibdd user= root password =1' ,  'select  article,cact, datep, datepost, datezak, nakaz, protokoln, facktaddr, pasportn, pasports, vodud, organ, lastname, firstname, middlename, birthday, datecreate, resaddr from st_20_2') as t1 (  article text, cact text, datep date, datepost date, datezak date, nakaz text, protokoln text, facktaddr text, pasportn text, pasports text, vodud text, organ text, lastname text, firstname text, middlename text, birthday date, datecreate date, resaadr text);";
                    System.out.println(queryGIBDD);
                    statement = connection.prepareStatement(queryGIBDD);
                    rs = statement.executeQuery();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    String queryOVD = "INSERT INTO   temp_" + authentication.getName() + " SELECT  * from dblink ('dbname= ovd user= root password =1' ,  'select  article,cact, datep, datepost, datezak, nakaz, protokoln, facktaddr, pasportn, pasports, vodud, organ, lastname, firstname, middlename, birthday, datecreate, resaddr from  st_20_2') as t1 (  article text, cact text, datep date, datepost date, datezak date, nakaz text, protokoln text, facktaddr text, pasportn text, pasports text, vodud text, organ text, lastname text, firstname text, middlename text, birthday date, datecreate date, resaadr text);";
                    System.out.println(queryOVD);
                    statement = connection.prepareStatement(queryOVD);
                    rs = statement.executeQuery();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                try {
                    String queryPrist = "INSERT INTO   temp_" + authentication.getName() + " SELECT  * from dblink ('dbname= fssp user= root password =1' ,  'select  article,cact, datep, datepost, datezak, nakaz, protokoln, facktaddr, pasportn, pasports, vodud, organ, lastname, firstname, middlename, birthday, datecreate, resaddr from  st_20_2') as t1 (  article text, cact text, datep date, datepost date, datezak date, nakaz text, protokoln text, facktaddr text, pasportn text, pasports text, vodud text, organ text, lastname text, firstname text, middlename text, birthday date, datecreate date, resaadr text);";
                    System.out.println(queryPrist);
                    statement = connection.prepareStatement(queryPrist);
                    rs = statement.executeQuery();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            String q1 = "select MAX(facktaddr) as facktaddr, count(protokoln) as kol, lastname, firstname, birthday, middlename, max(datep) as md , max(datep) - INTERVAL '365 day' as md2 from   temp_" + authentication.getName() + "  where facktaddr LIKE ? and datep BETWEEN  ? and ?  group by lastname, firstname, middlename, birthday  order by kol DESC ;";
            try {
                statement = connection.prepareStatement(q1);
            } catch (SQLException e) {
                e.printStackTrace();
            }


            statement.setString(1, regionMask);
            statement.setDate(2, d1);
            statement.setDate(3, d2);



            rs = statement.executeQuery();
            while (rs.next()) {
                ArticleStat articleStat = new ArticleStat();
                articleStat.setLastName(toUpperCase(rs.getString("lastname")));
                articleStat.setFirsName(toUpperCase(rs.getString("firstname")));
                articleStat.setMiddleName(toUpperCase(rs.getString("middlename")));
                articleStat.setBirthday(rs.getDate("birthday"));
                articleStat.setKol(rs.getInt("kol"));
                articleStat.setFacktAddr(rs.getString("facktaddr"));
                articleStat.setDateP(rs.getDate("md"));
                articleStat.setDateP2(rs.getDate("md2"));
                System.out.println(rs.getString("facktaddr"));

                stat.add(articleStat);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rsDrop != null) {
                try {
                    rsDrop.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statementDrop != null) {
                try {
                    statementDrop.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        PreparedStatement statement2 = null;
        ResultSet rs2 = null;
        ArrayList<ArticleStat> stats = new ArrayList<ArticleStat>();
        try {

            String query = "select count(protokoln) as kol, lastname, firstname, birthday, middlename from temp_" + authentication.getName() + "   WHERE  datep BETWEEN ? and ? and lastname=? and firstname=? and middlename=? and birthday=? group by  lastname, firstname, middlename, birthday HAVING count(protokoln)>= ? order by kol dESC ;";
            statement2 = connection.prepareStatement(query);

            for (int i = 0; i < stat.size(); i++) {
                System.out.println(i);

                statement2.setDate(1, (java.sql.Date) stat.get(i).getDateP2());
                statement2.setDate(2, (java.sql.Date) stat.get(i).getDateP());
                statement2.setString(3, stat.get(i).getLastName());
                statement2.setString(4, stat.get(i).getFirsName());
                statement2.setString(5, stat.get(i).getMiddleName());
                statement2.setDate(6, (java.sql.Date) stat.get(i).getBirthday());
                statement2.setInt(7, volume);


                rs2 = statement2.executeQuery();
                while (rs2.next()) {
                    ArticleStat arStat = new ArticleStat();
                    arStat.setLastName(toUpperCase(rs2.getString("lastname")));
                    arStat.setFirsName(toUpperCase(rs2.getString("firstname")));
                    arStat.setMiddleName(toUpperCase(rs2.getString("middlename")));
                    arStat.setBirthday(rs2.getDate("birthday"));
                    arStat.setKol(rs2.getInt("kol"));
                    arStat.setDateP(stat.get(i).getDateP());
                    arStat.setFacktAddr(stat.get(i).getFacktAddr());
                    System.out.println(rs2.getString("lastname"));
                    stats.add(arStat);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {


            if (rs2 != null) {
                try {
                    rs2.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        if (statement2 != null) {
            try {
                statement2.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        DbConnect.close(connection);
        return stats;
    }


    public int KolNarush(String article, String mask, java.sql.Date d1, java.sql.Date d2, boolean flag) {

        connection = DbConnect.getConnection();
        int kol = 0;

        PreparedStatement statement = null;
        ResultSet rs = null;

        try {

            authentication = SecurityContextHolder.getContext().getAuthentication();

            String query = "select count(protokoln) as kol from  temp_" + authentication.getName() + " where facktaddr like ? and datep BETWEEN  ? and ?   ;";
            statement = connection.prepareStatement(query);
            statement.setString(1, mask);
            statement.setDate(2, d1);
            statement.setDate(3, d2);
            rs = statement.executeQuery();
            while (rs.next()) {
                kol = (rs.getInt("kol"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        DbConnect.close(connection);
        return kol;
    }

    public int KolFace(String article, String mask, java.sql.Date d1, java.sql.Date d2, boolean flag) {

        connection = DbConnect.getConnection();
        int kf = 0;

        PreparedStatement statement = null;
        ResultSet rs = null;

        try {

            authentication = SecurityContextHolder.getContext().getAuthentication();

            String query = "select count(DISTINCT(lastname,firstname,middlename,birthday)) as kf  from  temp_" + authentication.getName() + " where facktaddr like ? and datep BETWEEN  ? and ?   ;";
            statement = connection.prepareStatement(query);

            statement.setString(1, mask);
            statement.setDate(2, d1);
            statement.setDate(3, d2);


            rs = statement.executeQuery();

            while (rs.next()) {
                kf = (rs.getInt("kf"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        DbConnect.close(connection);
        return kf;
    }
}
