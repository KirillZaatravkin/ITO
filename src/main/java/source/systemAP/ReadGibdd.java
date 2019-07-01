package source.systemAP;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import source.DbConnect;
import source.DbConnectFSSP;
import source.DbConnectGIBDD;
import source.systemAP.model.ApGIBDD;
import source.systemAP.model.ApPristStat;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

import static jdk.nashorn.internal.objects.NativeString.toUpperCase;
import static source.systemAP.model.ApPristStat.*;


public class ReadGibdd {
    public static final int FirstNameCell = 1;
    public static final int LastNameCell = 0;
    public static final int MiddleNameCell = 2;
    public static final int BirthDayCell = 3;
    public static final int FacktAddrCell = 4;
    public static final int FacktAddrCell1 = 5;
    public static final int FacktAddrCell2 = 6;
    public static final int FacktAddrCell3 = 7;
    public static final int FacktAddrCell4 = 8;
    public static final int FacktAddrCell5 = 9;
    public static final int ArrticleCell = 10;
    public static final int DatePCell = 11;
    public static final int DatePostCell = 15;
    public static final int DateZakCell = 16;
    public static final int NakazCell = 17;
    public static final int ProtokolNCell = 12;
    public static final int VodUdCell = 13;

    private Connection connection;
    private Connection connection2;

    public ReadGibdd() {
        connection = DbConnectGIBDD.getConnection();
        connection2=DbConnectGIBDD.getConnection();
    }

    public List<ApGIBDD> ReadExel(String path) throws IOException {
        List<ApGIBDD> listapGIBDD = new ArrayList<ApGIBDD>();
        File file = new File(path);
        POIFSFileSystem fs = new POIFSFileSystem(file);
        HSSFWorkbook workBook = new HSSFWorkbook(fs);
        HSSFSheet sheet = workBook.getSheetAt(0);
        Iterator<Row> rows = sheet.rowIterator();
        if (rows.hasNext()) {
            rows.next();
        }
        int i = 0;
        while (rows.hasNext()) {
            HSSFRow row = (HSSFRow) rows.next();
            if((!(row.getCell(FirstNameCell).getStringCellValue()).equals("НЕУСТАНОВЛЕНО") &&  !(row.getCell(LastNameCell).getStringCellValue()).equals("НЕУСТАНОВЛЕНО") && !(row.getCell(MiddleNameCell).getStringCellValue()).equals("НЕУСТАНОВЛЕНО")) || (!(row.getCell(FirstNameCell).getStringCellValue()).equals("") &&  !(row.getCell(LastNameCell).getStringCellValue()).equals("") && !(row.getCell(MiddleNameCell).getStringCellValue()).equals(""))  ) {
                ApGIBDD apGIBDD = new ApGIBDD();
                apGIBDD.setFirstName((row.getCell(FirstNameCell).getStringCellValue()));
                apGIBDD.setProtokolN(( row.getCell(ProtokolNCell).getStringCellValue()));
                System.out.println(apGIBDD.getFirstName());
                apGIBDD.setLastName(row.getCell(LastNameCell).getStringCellValue());
                apGIBDD.setMiddleName(row.getCell(MiddleNameCell).getStringCellValue());

                 String nakaz = "";
          try {
              int admVid = (int) (row.getCell(NakazCell).getNumericCellValue());
              {

                  switch (admVid) {
                      case 1:
                          nakaz = "Предупреждение";
                          break;
                      case 2:
                          nakaz = "Штраф";
                          break;
                      case 3:
                          nakaz = "Штраф+конфискация";
                          break;
                      case 4:
                          nakaz = "Лишение прав";
                          break;
                      case 5:
                          nakaz = "Адм. арест";
                          break;
                      case 6:
                          nakaz = "Лишение прав+штраф";
                          break;
                      case 7:
                          nakaz = "Лишение прав+ конфискация";
                          break;
                      case 8:
                          nakaz = "Дисквалификация";
                          break;
                  }
              }
          }
              catch(java.lang.IllegalStateException e)
              {

              }
                    apGIBDD.setNakaz(nakaz);


                try {
                    apGIBDD.setVodUd(row.getCell(VodUdCell).getStringCellValue());
                    System.out.println(apGIBDD.getVodUd());
                } catch (NullPointerException e) {
                    System.out.print("rrr");
                }

                int dateBirthDayCell = row.getCell(BirthDayCell).getCellType();
                if (dateBirthDayCell == 1) {
                    String sBirthDay = row.getCell(BirthDayCell).getStringCellValue();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                    try {
                        Date BirthDay = sdf.parse(sBirthDay);
                        apGIBDD.setBirthday(BirthDay);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                }
                int datePType = row.getCell(DatePCell).getCellType();
                if (datePType == 1) {
                    String sDateP = row.getCell(DatePCell).getStringCellValue();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                    try {
                        Date DateP = sdf.parse(sDateP);
                        apGIBDD.setDateP(DateP);
                        System.out.println(DateP);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }

                int datePostType = row.getCell(DatePostCell).getCellType();
                if (datePostType == 1) {
                    String sDatePost = row.getCell(DatePostCell).getStringCellValue();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                    try {
                        Date DatePost = sdf.parse(sDatePost);
                        apGIBDD.setDatePost(DatePost);
                        System.out.println(DatePost);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                }

                int dateZakType = row.getCell(DateZakCell).getCellType();
                if (datePostType == 1) {
                    String sDateZaK = row.getCell(DateZakCell).getStringCellValue();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                    try {
                        Date DateZak = sdf.parse(sDateZaK);
                        apGIBDD.setDateZak(DateZak);
                        System.out.println(DateZak);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                }

                String SS = "";
                try {
                    String s = row.getCell(FacktAddrCell).getStringCellValue();
                    SS = SS + "," + s;
                } catch (NullPointerException e) {

                }
                try {
                    String s1 = row.getCell(FacktAddrCell1).getStringCellValue();
                    SS = SS + "," + s1;
                } catch (NullPointerException e) {

                }
                try {
                    String s2 = row.getCell(FacktAddrCell2).getStringCellValue();
                    SS = SS + "," + s2;
                } catch (NullPointerException e) {

                }
                try {
                    String s3 = row.getCell(FacktAddrCell3).getStringCellValue();
                    SS = SS + "," + s3;
                } catch (NullPointerException e) {

                }
                try {
                    String s4 = row.getCell(FacktAddrCell4).getStringCellValue();
                    SS = SS + "," + s4;
                } catch (NullPointerException e) {
                }
                try {
                    String s5 = row.getCell(FacktAddrCell5).getStringCellValue();
                    SS = SS + "," + s5;
                } catch (NullPointerException e) {
                }
                apGIBDD.setFacktAddr(SS);
                String article = "";
                String chact = " ";
                String arS = row.getCell(ArrticleCell).getStringCellValue();
                boolean flag_4 = false;
                for (int y = 0; y < arS.length(); y++) {

                    if (arS.charAt(y) == 'ч' || arS.charAt(y) == 'Ч') {
                        for (int q = 0; q < y; q++) {
                            article = article + arS.charAt(q);
                            System.out.println(article);
                        }

                        for (int w = y + 2; w < arS.length(); w++) {
                            chact = chact + arS.charAt(w);
                        }
                        flag_4 = true;
                        System.out.println(article);
                        apGIBDD.setArticle(article);
                        break;
                    }

                }
                if (!flag_4) {
                    apGIBDD.setArticle(arS);
                }

                if (!chact.equals("")) {
                    apGIBDD.setCact(chact);
                }


                listapGIBDD.add(apGIBDD);
            }
                i++;

        }
        System.out.println(i);
        fs.close();
        return listapGIBDD;
    }

    public int WriteToBD(List<ApGIBDD> apGIBDDList) {

        PreparedStatement ps = null;

        int j = 0;
        for (int i = 0; i < apGIBDDList.size(); i++) {


            try {
                ps = connection.prepareStatement("insert into ap_gibdd(firstname,lastname,middlename, facktaddr, article,cact, birthday, datep, vodud, protokoln, nakaz, datezak, datepost) values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
                ps.setString(1, toUpperCase(apGIBDDList.get(i).getFirstName()));
                ps.setString(2, toUpperCase(apGIBDDList.get(i).getLastName()));
                ps.setString(3, toUpperCase(apGIBDDList.get(i).getMiddleName()));
                ps.setString(4,toUpperCase(apGIBDDList.get(i).getFacktAddr()));
                ps.setString(5, apGIBDDList.get(i).getArticle());
                ps.setString(6, apGIBDDList.get(i).getCact());


                if (apGIBDDList.get(i).getBirthDay() != null) {
                    ps.setDate(7, new java.sql.Date(apGIBDDList.get(i).getBirthDay().getTime()));
                } else {
                    ps.setNull(7, Types.DATE);
                }

                if (apGIBDDList.get(i).getDateP() != null) {
                    ps.setDate(8, new java.sql.Date(apGIBDDList.get(i).getDateP().getTime()));
                } else {
                    ps.setNull(8, Types.DATE);
                }
                ps.setString(9, apGIBDDList.get(i).getVodUd());
                ps.setString(10, apGIBDDList.get(i).getProtokolN());
                ps.setString(11, apGIBDDList.get(i).getNakaz());

                if (apGIBDDList.get(i).getDateZak() != null) {
                    ps.setDate(12, new java.sql.Date(apGIBDDList.get(i).getDateZak().getTime()));
                } else {
                    ps.setNull(12, Types.DATE);
                }

                if (apGIBDDList.get(i).getDatePost() != null) {
                    ps.setDate(13, new java.sql.Date(apGIBDDList.get(i).getDatePost().getTime()));
                } else {
                    ps.setNull(13, Types.DATE);
                }

                ps.executeUpdate();

                if(true)
                {
                    if (apGIBDDList.get(i).getArticle().equals("12.8") || apGIBDDList.get(i).getArticle().equals("12.26")  ) {
                        ps = connection.prepareStatement("insert into st_12_8_st_12_6 (lastname,firstname,middlename,facktaddr,article,cact,birthday, datep, vodud, protokoln, nakaz, datezak, datepost ) values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    }
                    else  if (apGIBDDList.get(i).getArticle().equals("6.1.1")  ) {
                        ps = connection.prepareStatement("insert into st_6_1_1 (lastname,firstname,middlename,facktaddr,article,cact,birthday, datep, vodud, protokoln, nakaz, datezak, datepost ) values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    }
                    else if (apGIBDDList.get(i).getArticle().equals("14.16") && apGIBDDList.get(i).getCact().equals("2.1")) {
                        ps = connection.prepareStatement("insert into st_14_16 (lastname,firstname,middlename,facktaddr,article,cact,birthday, datep, vodud, protokoln, nakaz, datezak, datepost ) values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    }
                    else if (apGIBDDList.get(i).getArticle().equals("5.35.1")) {
                        ps = connection.prepareStatement("insert into st_5_35_1(lastname,firstname,middlename,facktaddr,article,cact,birthday, datep, vodud, protokoln, nakaz, datezak, datepost )values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    }
                    else if (apGIBDDList.get(i).getArticle().equals("7.27") && apGIBDDList.get(i).getCact().equals("2")) {
                        ps = connection.prepareStatement("insert into st_7_27(lastname,firstname,middlename,facktaddr,article,cact,birthday, datep, vodud, protokoln, nakaz, datezak, datepost ) values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    }
                    else  if (apGIBDDList.get(i).getArticle().equals("14.17.1")) {
                        ps = connection.prepareStatement("insert into st_14_17_1(lastname,firstname,middlename,facktaddr,article,cact,birthday, datep, vodud, protokoln, nakaz, datezak, datepost ) values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    }
                    else if (apGIBDDList.get(i).getArticle().equals("20.2")) {
                        ps = connection.prepareStatement("insert into st_20_2(lastname,firstname,middlename,facktaddr,article,cact,birthday, datep, vodud, protokoln, nakaz, datezak, datepost )values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    }
                    else if (apGIBDDList.get(i).getArticle().equals("20.17")) {
                        ps = connection.prepareStatement("insert into st_20_17(lastname,firstname,middlename,facktaddr,article,cact,birthday, datep, vodud, protokoln, nakaz, datezak, datepost )values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    }
                    else  if (apGIBDDList.get(i).getArticle().equals("20.33")) {
                        ps = connection.prepareStatement("insert into st_20_33(lastname,firstname,middlename,facktaddr,article,cact,birthday, datep, vodud, protokoln, nakaz, datezak, datepost ) values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    }
                    else
                    {
                        continue;
                    }

                    ps.setString(1, toUpperCase(apGIBDDList.get(i).getLastName()));
                    ps.setString(2, toUpperCase(apGIBDDList.get(i).getFirstName()));
                    ps.setString(3, toUpperCase(apGIBDDList.get(i).getMiddleName()));
                    ps.setString(4,toUpperCase(apGIBDDList.get(i).getFacktAddr()));
                    ps.setString(5, apGIBDDList.get(i).getArticle());
                    ps.setString(6, apGIBDDList.get(i).getCact());


                    if (apGIBDDList.get(i).getBirthDay() != null) {
                        ps.setDate(7, new java.sql.Date(apGIBDDList.get(i).getBirthDay().getTime()));
                    } else {
                        ps.setNull(7, Types.DATE);
                    }

                    if (apGIBDDList.get(i).getDateP() != null) {
                        ps.setDate(8, new java.sql.Date(apGIBDDList.get(i).getDateP().getTime()));
                    } else {
                        ps.setNull(8, Types.DATE);
                    }
                    ps.setString(9, apGIBDDList.get(i).getVodUd());
                    ps.setString(10, apGIBDDList.get(i).getProtokolN());
                    ps.setString(11, apGIBDDList.get(i).getNakaz());

                    if (apGIBDDList.get(i).getDateZak() != null) {
                        ps.setDate(12, new java.sql.Date(apGIBDDList.get(i).getDateZak().getTime()));
                    } else {
                        ps.setNull(12, Types.DATE);
                    }

                    if (apGIBDDList.get(i).getDatePost() != null) {
                        ps.setDate(13, new java.sql.Date(apGIBDDList.get(i).getDatePost().getTime()));
                    } else {
                        ps.setNull(13, Types.DATE);
                    }

                    ps.executeUpdate();

                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (ps != null) {
                    try {
                        ps.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        DbConnect.close(connection);
        return j;
    }

    /**
     * Created by кирюха on 19.11.2017.
     */
    public static class StatResedivPrist {


        private Connection connection;

        private static final int threadCount = 3;

        public List<ApPristStat> FilterStat(String article, java.sql.Date d1, java.sql.Date d2, String sorts, String interval, String cact, String regionMask) {

            long curr = System.currentTimeMillis();

            connection = DbConnectFSSP.getConnection();

            List<ApPristStat> apPristStats = new ArrayList<ApPristStat>();
            PreparedStatement statement = null;
            ResultSet rs = null;

            try {
                if (interval.equals("found")) {
                    if (article == null) {
                        statement = connection.prepareStatement("select   cact,  count(id) as kol, max(facktaddr) as facktaddr,lastname, firstname, birthday, middlename, article, max(datep) as md , max(datep) - INTERVAL '365 day' as md2 from ap_prist where facktaddr LIKE ? and datep BETWEEN  ? and ?  group by lastname, firstname,cact, middlename, birthday, article    order by kol DESC ;");
                        statement.setString(1, regionMask);
                        statement.setDate(2, d1);
                        statement.setDate(3, d2);
                    }

                    if (article != null) {
                        statement = connection.prepareStatement("select count(id) as kol,cact, max(facktaddr) as facktaddr, lastname, firstname, birthday, middlename, article , max(datep) as md ,  max(datep) - INTERVAL '365 day' as md2 from ap_prist WHERE facktaddr LIKE ? and  cact like ? and datep BETWEEN  ? and ? and article =?  group by lastname, cact, firstname, middlename, birthday, article  ;");

                        statement.setString(1, regionMask);
                        statement.setString(2, cact);
                        System.out.println("ghg");
                        System.out.println(cact);
                        statement.setDate(3, d1);
                        statement.setDate(4, d2);
                        statement.setString(5, article);
                    }
                }

                if (interval.equals("year")) {
                    if (article == null) {
                        statement = connection.prepareStatement("select count(id) as kol, cact,max(facktaddr) as facktaddr, lastname, firstname, birthday, middlename, articlen max(datep) as md , max(datep) - INTERVAL '365 day' as md2 from ap_prist where EXTRACT (YEAR from datep)= EXTRACT (YEAR FROM now())  group by lastname,cact, firstname, middlename, birthday, article  ;");

                    }
                    if (article != null) {
                        statement = connection.prepareStatement("select count(id) as kol,cact, max(facktaddr) as facktaddr, lastname,  firstname, birthday, middlename, article , max(datep) as md ,  max(datep) - INTERVAL '365 day' as md2 from ap_prist where EXTRACT (YEAR from datep)= EXTRACT (YEAR FROM now()) and article=? group by cact,lastname, firstname, middlename, birthday, article ;");
                        statement.setString(1, article);

                    }
                }
                if (interval.equals("month")) {
                    if (article == null) {
                        statement = connection.prepareStatement("select count(id) as kol, cact, max(facktaddr) as facktaddr, lastname, firstname, birthday, middlename, article max(datep) as md , max(datep) - INTERVAL '365 day' as md2 from ap_prist where EXTRACT (MONTH from datep)= EXTRACT (MONTH FROM now())  group by lastname,cact, firstname, middlename, birthday, article    ;");

                    }
                    if (article != null) {
                        statement = connection.prepareStatement("select count(id) as kol, cact,max(facktaddr) as facktaddr,  lastname, firstname, birthday, middlename, article , max(datep) as md ,  max(datep) - INTERVAL '365 day' as md2 from ap_prist WHERE EXTRACT (MONTH from datep)= EXTRACT (MONTH FROM now()) and article=? group by cact, lastname, firstname, middlename, birthday, article ;");
                        statement.setString(1, article);

                    }
                }
                if (interval.equals("lastload")) {

                    if (article == null) {
                        statement = connection.prepareStatement("select count(id) as kol,cact, max(facktaddr) as facktaddr, lastname, firstname, birthday, middlename, article , max(datep) as md , max(datep) - INTERVAL '365 day' as md2 from ap_prist where datecreate=(select max(datecreate) from ap_gibdd)  group by lastname, firstname, cact,middlename, birthday, article   ;");

                    }
                    if (article != null) {
                        statement = connection.prepareStatement("select count(id) as kol, cact, max(facktaddr) as facktaddr,   lastname, firstname, birthday, middlename, article , max(datep) as md ,  max(datep) - INTERVAL '365 day' as md2 from ap_prist WHERE datecreate=(select max(datecreate) from ap_gibdd)  and article=? group by cact,  lastname, firstname, middlename, birthday, article    ;");
                        statement.setString(1, article);

                    }
                }

                rs = statement.executeQuery();
                while (rs.next()) {

                    ApPristStat apPristStat = new ApPristStat();
                    apPristStat.setLastName(toUpperCase(rs.getString("lastname")));
                    apPristStat.setFirstName(toUpperCase(rs.getString("firstname")));
                    apPristStat.setMiddleName(toUpperCase(rs.getString("middlename")));
                    apPristStat.setBirthday(rs.getDate("birthday"));
                    apPristStat.setKol(rs.getInt("kol"));
                    apPristStat.setCact(rs.getString("cact"));
                    apPristStat.setFacktAddr(rs.getString("facktaddr"));
                    apPristStat.setArticle(rs.getString("article"));
                    apPristStat.setDateP(rs.getDate("md"));
                    apPristStat.setDateP2(rs.getDate("md2"));
                    apPristStats.add(apPristStat);
                    System.out.println(apPristStats.size());
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

            CountDownLatch countDownLatch = new CountDownLatch(threadCount);


            DbConnect.close(connection);

            ThreadOne[] threadPool = new ThreadOne[threadCount];

            for (int i = 0; i < threadCount; i++) {
                threadPool[i] = new ThreadOne(apPristStats, i, threadCount, countDownLatch);
                threadPool[i].start();
            }
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            List<ApPristStat> result = new ArrayList<ApPristStat>();

            for (ThreadOne threadOne : threadPool) {
                result.addAll(threadOne.getResultList());
            }

            System.out.println("Total time ms: " + (System.currentTimeMillis() - curr));


            if (sorts.equals("datep")) {
                Collections.sort(result, CompDateP1);
            } else if (sorts.equals("lastname")) {
                Collections.sort(result, CompLastName1);
                System.out.print("77777777777");
            } else if (sorts.equals("kol")) {
                Collections.sort(result, CompKol1);
            } else {
                Collections.sort(result, CompArticle1);
            }

            return result;
        }


        class ThreadOne extends Thread {
            private List<ApPristStat> apPrist;
            private volatile List<ApPristStat> ResultList;
            private int StartInd;
            private int increment;
            private CountDownLatch latch;

            ThreadOne(List<ApPristStat> apPristStats, int StartInd, int increment, CountDownLatch latch) {

                this.apPrist = apPristStats;
                this.StartInd = StartInd;
                this.increment = increment;
                this.latch = latch;
            }

            @Override
            public void run() {

                List<ApPristStat> apPristStats = new ArrayList<ApPristStat>();
                connection = DbConnectFSSP.getConnection();

                PreparedStatement statement2 = null;
                ResultSet rs2 = null;
                try {
                    statement2 = connection.prepareStatement("select count(id) as kol, lastname, firstname, birthday, middlename, article, cact  from ap_prist WHERE  datep BETWEEN ? and ? and article =?  and cact=? and lastname=? and firstname=? and middlename=? and birthday=? group by cact, lastname, firstname, middlename, birthday, article HAVING count(id)>= 2 order by kol dESC ;");
                } catch (SQLException e) {
                    e.printStackTrace();
                    return;
                }
                for (int i = StartInd; i < apPrist.size(); i += increment) {
                    System.out.println(i);
                    try {


                        statement2.setDate(1, (java.sql.Date) apPrist.get(i).getDateP2());
                        statement2.setDate(2, (java.sql.Date) apPrist.get(i).getDateP());
                        statement2.setString(3, apPrist.get(i).getArticle());
                        statement2.setString(4, apPrist.get(i).getCact());
                        statement2.setString(5, apPrist.get(i).getLastName());
                        statement2.setString(6, apPrist.get(i).getFirstName());
                        statement2.setString(7, apPrist.get(i).getMiddleName());
                        statement2.setDate(8, (java.sql.Date) apPrist.get(i).getBirthDay());
                        rs2 = statement2.executeQuery();
                        System.out.println(apPrist.get(i).getDateP2());
                        System.out.println(apPrist.get(i).getDateP());
                        while (rs2.next()) {
                            ApPristStat apPristStat = new ApPristStat();
                            apPristStat.setLastName(toUpperCase(rs2.getString("lastname")));
                            apPristStat.setFirstName(toUpperCase(rs2.getString("firstname")));
                            apPristStat.setMiddleName(toUpperCase(rs2.getString("middlename")));
                            apPristStat.setBirthday(rs2.getDate("birthday"));
                            apPristStat.setKol(rs2.getInt("kol"));
                            apPristStat.setDateP(apPrist.get(i).getDateP());
                            apPristStat.setFacktAddr(apPrist.get(i).getFacktAddr());
                            apPristStat.setArticle(rs2.getString("article"));
                            apPristStat.setCact(rs2.getString("cact"));
                            System.out.println(rs2.getString("lastname"));


                            apPristStats.add(apPristStat);
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

                }
                if (statement2 != null) {
                    try {
                        statement2.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                DbConnect.close(connection);
                ResultList = apPristStats;
                latch.countDown();
            }

            public List<ApPristStat> getResultList() {
                return ResultList;
            }
        }


        public int KolNarush(String article, String mask, java.sql.Date d1, java.sql.Date d2, boolean flag) {

            connection = DbConnectFSSP.getConnection();
            int kol = 0;

            PreparedStatement statement = null;
            ResultSet rs = null;

            try {
                if (article == null && flag == false) {
                    statement = connection.prepareStatement("select count(id) as kol from ap_prist where facktaddr like ? and datep BETWEEN  ? and ?   ;");
                    statement.setString(1, mask);
                    statement.setDate(2, d1);
                    statement.setDate(3, d2);

                }
                if (article != null && flag == false) {
                    statement = connection.prepareStatement("select count(id) as kol from ap_prist WHERE facktaddr like ? and datep BETWEEN  ? and ? and article =? ;");
                    statement.setString(1, mask);
                    statement.setDate(2, d1);
                    statement.setDate(3, d2);
                    statement.setString(4, article);
                }
                if (article == null && flag == true) {
                    statement = connection.prepareStatement("select count(id) as kol from ap_prist where EXTRACT (YEAR from datep)= EXTRACT (YEAR FROM now())   ;");


                }
                if (article != null && flag == true) {
                    statement = connection.prepareStatement("select count(id) as kolfrom ap_prist where EXTRACT (YEAR from datep)= EXTRACT (YEAR FROM now())and article =?  ;");
                    statement.setString(1, article);


                }
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

            connection = DbConnectFSSP.getConnection();
            int kf = 0;

            PreparedStatement statement = null;
            ResultSet rs = null;

            try {
                if (article == null && flag == false) {
                    statement = connection.prepareStatement("select count(DISTINCT(lastname,firstname,middlename,birthday)) as kf from ap_prist where facktaddr like ? and datep BETWEEN  ? and ?   ;");
                    statement.setString(1, mask);
                    statement.setDate(2, d1);
                    statement.setDate(3, d2);

                }
                if (article != null && flag == false) {
                    statement = connection.prepareStatement("select count(DISTINCT(lastname,firstname,middlename,birthday)) as kf from ap_prist WHERE facktaddr like ? and  datep BETWEEN  ? and ? and article =? ;");
                    statement.setString(1, mask);
                    statement.setDate(2, d1);
                    statement.setDate(3, d2);
                    statement.setString(4, article);
                }
                if (article == null && flag == true) {
                    statement = connection.prepareStatement("select count(DISTINCT(lastname,firstname,middlename,birthday)) as kf from ap_prist where EXTRACT (YEAR from datep)= EXTRACT (YEAR FROM now())   ;");


                }
                if (article != null && flag == true) {
                    statement = connection.prepareStatement("select count(DISTINCT(lastname,firstname,middlename,birthday)) as kf ap_prist where EXTRACT (YEAR from datep)= EXTRACT (YEAR FROM now())and article =?  ;");
                    statement.setString(1, article);
                }
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
}