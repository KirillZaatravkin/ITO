package source.systemAP;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import source.DbConnectFSSP;
import source.DbConnectGIBDD;
import source.DbConnectOVD;
import source.systemAP.model.Spisok;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import static jdk.nashorn.internal.objects.NativeString.toUpperCase;


public class ReadSpiski {
    public static final int FirstNameCell = 1;
    public static final int LastNameCell = 0;
    public static final int MiddleNameCell = 2;
    public static final int BirthDayCell = 3;


    private Connection connectionOVD;
    private Connection connectionGIBDD;
    private Connection connectionFSSP;



    public List<Spisok> ReadExel(String path) throws IOException {


        List<Spisok> listS = new ArrayList<Spisok>();
        File file = new File(path);
        System.out.println(path);
        POIFSFileSystem fs = new POIFSFileSystem(file);
        HSSFWorkbook workBook = new HSSFWorkbook(fs);
        HSSFSheet sheet = workBook.getSheetAt(0);
        Iterator<Row> rows = sheet.rowIterator();
        if (rows.hasNext()) {
            rows.next();
        }
        int i = 1;
        while (rows.hasNext()) {
            System.out.println(i++);
            HSSFRow row = (HSSFRow) rows.next();
            Spisok ls = new Spisok();
            String FIO = (row.getCell(LastNameCell).getStringCellValue());
            String[] splitFIO = FIO.split(" ");
            if (splitFIO.length == 4) {


                SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
                try {
                    Date d1 = format.parse(splitFIO[3]);
                    ls.setBirthday(d1);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                ls.setMiddleName(splitFIO[2]);
                ls.setFirstName(splitFIO[1]);
                ls.setLastName(splitFIO[0]);
                listS.add(ls);
            } else {
                continue;
            }
        }
        fs.close();

        List <Spisok> result= Find(listS);
        return result;
    }

    public List<Spisok> ReadExelStandart(String path) throws IOException {


        List<Spisok> listS = new ArrayList<Spisok>();
        File file = new File(path);
        System.out.println(path);
        POIFSFileSystem fs = new POIFSFileSystem(file);
        HSSFWorkbook workBook = new HSSFWorkbook(fs);
        HSSFSheet sheet = workBook.getSheetAt(0);
        Iterator<Row> rows = sheet.rowIterator();
        if (rows.hasNext()) {
            rows.next();
        }

        while (rows.hasNext()) {
            HSSFRow row = (HSSFRow) rows.next();
            Spisok ls = new Spisok();
            ls.setLastName(row.getCell(LastNameCell).getStringCellValue());
            ls.setFirstName(row.getCell(FirstNameCell).getStringCellValue());
            ls.setMiddleName(row.getCell(MiddleNameCell).getStringCellValue());
            int birthDayType = row.getCell(BirthDayCell).getCellType();
            if (birthDayType == 0) {
                Date birthDaySTR = row.getCell(BirthDayCell).getDateCellValue();
                System.out.println(birthDaySTR);
                ls.setBirthday(birthDaySTR );
            }
            listS.add(ls);
        }

        fs.close();
        List <Spisok> result= Find(listS);
        return result;
    }

    public List<Spisok> Find(List<Spisok> listS) {

        connectionOVD = DbConnectOVD.getConnection();
        connectionGIBDD = DbConnectGIBDD.getConnection();
        connectionFSSP = DbConnectFSSP.getConnection();;

        PreparedStatement statement = null;
        ResultSet rs = null;

        List<Spisok> result = new ArrayList<Spisok>();


        for (int i = 0; i < listS.size(); i++) {


            String queryOVD = "select * from ap_ovd where lastname=? and firstname=? and middlename=? and  birthday=?;  ";
            String queryGIBDD = "select * from ap_gibdd where lastname=? and firstname=? and middlename=? and  birthday=?;  ";
            String queryPrist = "select * from ap_prist where lastname=? and firstname=? and middlename=? and  birthday=?;  ";

            try {
                statement = connectionOVD.prepareStatement(queryOVD);
                statement.setString(1, toUpperCase(listS.get(i).getLastName()));
                statement.setString(2, toUpperCase(listS.get(i).getFirstName()));
                statement.setString(3, toUpperCase(listS.get(i).getMiddleName()));
                statement.setDate(4, new java.sql.Date(listS.get(i).getBirthDay().getTime()));
                rs = statement.executeQuery();

            try {
                while (rs.next()) {

                    Spisok Apprist = new Spisok();
                    Apprist.setLastName(toUpperCase(rs.getString("lastname")));
                    Apprist.setFirstName(toUpperCase(rs.getString("firstname")));
                    Apprist.setMiddleName(toUpperCase(rs.getString("middlename")));
                    System.out.println("jj");
                    Apprist.setCact(rs.getString("cact"));
                    Apprist.setArticle(rs.getString("article"));
                    Apprist.setBirthday(rs.getDate("birthday"));
                    Apprist.setDateP(rs.getDate("datep"));
                    Apprist.setDateZak(rs.getDate("datezak"));
                    Apprist.setNakaz(rs.getString("nakaz"));
                    Apprist.setDaterCreate(rs.getDate("datecreate"));
                    result.add(Apprist);
                }
            }catch (java.lang.NullPointerException e ) {
                e.printStackTrace();
            }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                statement = connectionGIBDD.prepareStatement(queryGIBDD);
                statement.setString(1, toUpperCase(listS.get(i).getLastName()));
                statement.setString(2, toUpperCase(listS.get(i).getFirstName()));
                statement.setString(3, toUpperCase(listS.get(i).getMiddleName()));
                statement.setDate(4, new java.sql.Date(listS.get(i).getBirthDay().getTime()));
                rs = statement.executeQuery();
              try {
                while (rs.next()) {
                    Spisok Apprist = new Spisok();
                    Apprist.setLastName(toUpperCase(rs.getString("lastname")));
                    Apprist.setFirstName(toUpperCase(rs.getString("firstname")));
                    Apprist.setMiddleName(toUpperCase(rs.getString("middlename")));
                    Apprist.setFacktAddr(rs.getString("facktaddr"));
                    Apprist.setCact(rs.getString("cact"));
                    Apprist.setArticle(rs.getString("article"));
                    Apprist.setBirthday(rs.getDate("birthday"));
                    Apprist.setDateP(rs.getDate("datep"));
                    Apprist.setDateZak(rs.getDate("datezak"));
                    Apprist.setNakaz(rs.getString("nakaz"));
                    Apprist.setDaterCreate(rs.getDate("datecreate"));
                    result.add(Apprist);
                }
            }catch (java.lang.NullPointerException e )
            {
                e.printStackTrace();
            }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                statement = connectionFSSP.prepareStatement(queryPrist);
                statement.setString(1, toUpperCase(listS.get(i).getLastName()));
                statement.setString(2, toUpperCase(listS.get(i).getFirstName()));
                statement.setString(3, toUpperCase(listS.get(i).getMiddleName()));
                statement.setDate(4, new java.sql.Date(listS.get(i).getBirthDay().getTime()));
                rs = statement.executeQuery();
             try {
                 while (rs.next()) {
                     Spisok Apprist = new Spisok();
                     Apprist.setLastName(toUpperCase(rs.getString("lastname")));
                     Apprist.setFirstName(toUpperCase(rs.getString("firstname")));
                     Apprist.setMiddleName(toUpperCase(rs.getString("middlename")));
                     Apprist.setFacktAddr(rs.getString("facktaddr"));
                     Apprist.setCact(rs.getString("cact"));
                     Apprist.setArticle(rs.getString("article"));
                     Apprist.setBirthday(rs.getDate("birthday"));
                     Apprist.setDateP(rs.getDate("datep"));
                     Apprist.setDateZak(rs.getDate("datezak"));
                     Apprist.setNakaz(rs.getString("nakaz"));
                     Apprist.setDaterCreate(rs.getDate("datecreate"));
                     result.add(Apprist);
                 }
             }catch (java.lang.NullPointerException e)
             {
                 e.printStackTrace();
             }
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}