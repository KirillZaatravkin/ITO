package source.systemAP;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import source.DbConnect;
import source.DbConnectOVD;
import source.systemAP.model.ApOVD;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.Date;

import static jdk.nashorn.internal.objects.NativeString.toUpperCase;


public class ReadApOVD {
    public static final int FirstNameCell = 0;
    public static final int LastNameCell = 1;
    public static final int MiddleNameCell = 2;
    public static final int BirthDayCell = 3;
    public static final int FacktAddrCell = 4;
    public static final int ArrticleCell = 11;
    public static final int CactCell = 12;
    public static final int DatePCell = 8;
    public static final int DatePostCell = 9;
    public static final int DateZakCell = 10;
    public static final int OrganCell = 2;
    public static final int PasportSCell = 6;
    public static final int PasportNCell = 7;
    public static final int NakazCell = 13;
    public static final int ProtocolCell = 5;

    private Connection connection;

    public ReadApOVD() {
        connection = DbConnectOVD.getConnection();
    }

    public List<ApOVD> ReadExel(String path) throws IOException {
        List<ApOVD> listapOVD = new ArrayList<ApOVD>();
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
            ApOVD apOVD = new ApOVD();
            apOVD.setFirstName((row.getCell(FirstNameCell).getStringCellValue()));
            apOVD.setLastName(row.getCell(LastNameCell).getStringCellValue());
            apOVD.setMiddleName(row.getCell(MiddleNameCell).getStringCellValue());
            apOVD.setProtocolN(row.getCell(ProtocolCell).getStringCellValue());
            apOVD.setNakaz(row.getCell(NakazCell).getStringCellValue());

            int birthDayType = row.getCell(BirthDayCell).getCellType();
            if (birthDayType == 0) {
                Date birthDaySTR = row.getCell(BirthDayCell).getDateCellValue();
                apOVD.setBirthday(birthDaySTR );
            }

            int DateType = row.getCell(DatePostCell).getCellType();
            if (DateType == 0) {
                Date DateSTR = row.getCell(DatePostCell).getDateCellValue();
                apOVD.setDatePost(DateSTR);
            }


            int DateZakType = row.getCell(DateZakCell).getCellType();
            if (DateZakType == 0) {
                Date dateZak = row.getCell(DateZakCell).getDateCellValue();
                System.out.println(dateZak);
                apOVD.setDateZak(dateZak);
            }

            int datePType = row.getCell(DatePCell).getCellType();
            if (datePType == 0) {
                Date datePSTR = row.getCell(DatePCell).getDateCellValue();
                apOVD.setDateP(datePSTR);
            }
            apOVD.setFacktAddr(row.getCell(FacktAddrCell).getStringCellValue());
            apOVD.setResAddr(row.getCell(FacktAddrCell).getStringCellValue());


            apOVD.setArticle(row.getCell(ArrticleCell).getStringCellValue());
            try{
              apOVD.setPasportS(row.getCell(PasportSCell).getStringCellValue());

           }
           catch (Exception e)
            {

            }

            try{

                apOVD.setPasportN(row.getCell(PasportNCell).getStringCellValue());

            }
            catch (Exception e)
            {

            }


            try{
                {
                    apOVD.setCact(row.getCell(CactCell).getStringCellValue());
                }

            }
            catch (java.lang.NullPointerException e)
            {

            }

            listapOVD.add(apOVD);
            i++;
            System.out.println(i);
        }
        System.out.println(i);
        fs.close();
        return listapOVD;
    }

    public int WriteToBD(List<ApOVD> apOVDList) {

        PreparedStatement ps = null;

        int j = 0;
        for (int i = 0; i < apOVDList.size(); i++) {
            j++;
            try {
                ps = connection.prepareStatement("insert into ap_ovd(lastname,firstname,middlename,facktaddr,resaddr,article,birthday, datep,pasports,pasportn,cact,organ,datezak, datepost,protocoln,nakaz ) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                ps.setString(1, toUpperCase(apOVDList.get(i).getFirstName()));
                ps.setString(2, toUpperCase(apOVDList.get(i).getLastName()));
                ps.setString(3, toUpperCase(apOVDList.get(i).getMiddleName()));
                ps.setString(4, toUpperCase(apOVDList.get(i).getFacktAddr()));
                ps.setString(5, toUpperCase(apOVDList.get(i).getResAddr()));
                ps.setString(6, apOVDList.get(i).getArticle());


                if (apOVDList.get(i).getBirthDay() != null) {
                    ps.setDate(7, new java.sql.Date(apOVDList.get(i).getBirthDay().getTime()));
                } else {
                    ps.setNull(7, Types.DATE);
                }
               if (apOVDList.get(i).getDateP() != null) {
                    ps.setDate(8, new java.sql.Date(apOVDList.get(i).getDateP().getTime()));
                } else {
                    ps.setNull(8, Types.DATE);
                }
                ps.setString(9, apOVDList.get(i).getPasportS());
                ps.setString(10, apOVDList.get(i).getPasportN());
                ps.setString(11,apOVDList.get(i).getCact());
                ps.setString(12,apOVDList.get(i).getOrgan());

                if (apOVDList.get(i).getDateZak() != null) {
                    ps.setDate(13, new java.sql.Date(apOVDList.get(i).getDateZak().getTime()));
                } else {
                    ps.setNull(13, Types.DATE);
                }
                if (apOVDList.get(i).getDatePost() != null) {
                    ps.setDate(14, new java.sql.Date(apOVDList.get(i).getDatePost().getTime()));
                } else {
                    ps.setNull(14, Types.DATE);
                }
                ps.setString(15,apOVDList.get(i).getProtocolN());
                ps.setString(16,apOVDList.get(i).getNakaz());

                ps.executeUpdate();


                if(true) {

                    if (apOVDList.get(i).getArticle().equals("12.8") || apOVDList.get(i).getArticle().equals("12.26")  ) {
                        ps = connection.prepareStatement("insert into st_12_8_st_12_6 (lastname,firstname,middlename,facktaddr,article,birthday, datep,pasports,pasportn,cact,organ,datezak, datepost,protokoln, nakaz ) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    }
                    else  if (apOVDList.get(i).getArticle().equals("6.1.1")  ) {
                        ps = connection.prepareStatement("insert into st_6_1_1 (lastname,firstname,middlename,facktaddr,article,birthday, datep,pasports,pasportn,cact,organ,datezak,datepost,protokoln, nakaz ) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    }
                    else if (apOVDList.get(i).getArticle().equals("14.16") && apOVDList.get(i).getCact().equals("2.1")) {
                        ps = connection.prepareStatement("insert into st_14_16 (lastname,firstname,middlename,facktaddr,article,birthday, datep,pasports,pasportn,cact,organ,datezak,  datepost,protokoln, nakaz ) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    }
                    else if (apOVDList.get(i).getArticle().equals("5.35.1")) {
                        ps = connection.prepareStatement("insert into st_5_35_1(lastname,firstname,middlename,facktaddr,article,birthday, datep,pasports,pasportn,cact,organ,datezak,  datepost,protokoln, nakaz ) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    }
                    else if (apOVDList.get(i).getArticle().equals("7.27") && apOVDList.get(i).getCact().equals("2")) {
                        ps = connection.prepareStatement("insert into st_7_27(lastname,firstname,middlename,facktaddr,article,birthday, datep,pasports,pasportn,cact,organ,datezak , datepost,protokoln, nakaz ) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    }
                   else  if (apOVDList.get(i).getArticle().equals("14.17.1")) {
                        ps = connection.prepareStatement("insert into st_14_17_1(lastname,firstname,middlename,facktaddr,article,birthday, datep,pasports,pasportn,cact,organ,datezak ,  datepost,protokoln, nakaz ) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    }
                    else if (apOVDList.get(i).getArticle().equals("20.2")) {
                        ps = connection.prepareStatement("insert into st_20_2(lastname,firstname,middlename,facktaddr,article,birthday, datep,pasports,pasportn,cact,organ,datezak ,  datepost,protokoln, nakaz ) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    }
                    else if (apOVDList.get(i).getArticle().equals("20.17")) {
                        ps = connection.prepareStatement("insert into st_20_17(lastname,firstname,middlename,facktaddr,article,birthday, datep,pasports,pasportn,cact,organ,datezak ,   datepost,protokoln, nakaz ) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    }
                   else  if (apOVDList.get(i).getArticle().equals("20.33")) {
                        ps = connection.prepareStatement("insert into st_20_33(lastname,firstname,middlename,facktaddr,article,birthday, datep,pasports,pasportn,cact,organ,datezak , datepost,protokoln, nakaz ) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    }
                    else
                    {
                        continue;
                    }

                    ps.setString(1, toUpperCase(apOVDList.get(i).getFirstName()));
                    ps.setString(2, toUpperCase(apOVDList.get(i).getLastName()));
                    ps.setString(3, toUpperCase(apOVDList.get(i).getMiddleName()));
                    ps.setString(4, toUpperCase(apOVDList.get(i).getFacktAddr()));
                    ps.setString(5, apOVDList.get(i).getArticle());


                    if (apOVDList.get(i).getBirthDay() != null) {
                        ps.setDate(6, new java.sql.Date(apOVDList.get(i).getBirthDay().getTime()));
                    } else {
                        ps.setNull(6, Types.DATE);
                    }
                    if (apOVDList.get(i).getDateP() != null) {
                        ps.setDate(7, new java.sql.Date(apOVDList.get(i).getDateP().getTime()));
                    } else {
                        ps.setNull(7, Types.DATE);
                    }
                    ps.setString(8, apOVDList.get(i).getPasportS());
                    ps.setString(9, apOVDList.get(i).getPasportN());
                    ps.setString(10,apOVDList.get(i).getCact());
                    ps.setString(11,apOVDList.get(i).getOrgan());

                    if (apOVDList.get(i).getDateZak() != null) {
                        ps.setDate(12, new java.sql.Date(apOVDList.get(i).getDateZak().getTime()));
                    } else {
                        ps.setNull(12, Types.DATE);
                    }
                    if (apOVDList.get(i).getDatePost() != null) {
                        ps.setDate(13, new java.sql.Date(apOVDList.get(i).getDatePost().getTime()));
                    } else {
                        ps.setNull(13, Types.DATE);
                    }
                    ps.setString(14,apOVDList.get(i).getProtocolN());
                    ps.setString(15,apOVDList.get(i).getNakaz());
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
}