package source.systemAP;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import source.DbConnect;
import source.DbConnectOVD;
import source.systemAP.model.ApOVD;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import static jdk.nashorn.internal.objects.NativeString.toUpperCase;


public class ReadApOVD_old {
 /*   public static final int FirstNameCell = 5;
    public static final int LastNameCell = 6;
    public static final int MiddleNameCell = 7;
    public static final int BirthDayCell = 8;
    public static final int FacktAddrCell = 11;
    public static final int ArrticleCell = 12;
    public static final int CactCell = 13;
    public static final int DatePCell = 0;
    public static final int DatePostCell = 1;
    public static final int DateZakCell = 2;
    public static final int OrganCell = 2;
    public static final int PasportSCell = 9;
    public static final int PasportNCell = 10;
    public static final int NakazCell = 14;
    public static final int ProtocolCell = 4;
    */

    public static final int FirstNameCell = 0;
    public static final int LastNameCell = 1;
    public static final int MiddleNameCell = 2;
    public static final int BirthDayCell = 3;
    public static final int FacktAddrCell = 9;
    public static final int ArrticleCell = 5;
    public static final int DatePCell = 4;
    public static final int DatePostCell = 19;
    public static final int DateZakCell = 22;
    public static final int PasportSCell = 16;
    public static final int PasportNCell = 17;
    public static final int NakazCell = 6;
    public static final int ProtocolCell = 21;

    private Connection connection;

    public ReadApOVD_old() {
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


            DateFormat formatter;
            Date date;
            String datestr;
            formatter = new SimpleDateFormat("dd.MM.yyyy");

            try {
                datestr = row.getCell(BirthDayCell).getStringCellValue();
                date = formatter.parse(datestr);
                apOVD.setBirthday(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }


            datestr = row.getCell(DatePCell).getStringCellValue();
            try {
                date = formatter.parse(datestr);
                apOVD.setDateP(date);

            } catch (ParseException e) {

            }


            datestr = row.getCell(DatePostCell).getStringCellValue();
            try {
                date = formatter.parse(datestr);
                apOVD.setDatePost(date);
            } catch (ParseException e) {

            }


            datestr = row.getCell(DateZakCell).getStringCellValue();
            try {
                date = formatter.parse(datestr);
                apOVD.setDateZak(date);

            } catch (ParseException e) {

            }


            String SS = "";
            try {
                String s = row.getCell(FacktAddrCell).getStringCellValue();
                SS = s;
            } catch (NullPointerException e) {

            }
            try {
                String s1 = row.getCell(FacktAddrCell + 1).getStringCellValue();
                SS = SS + "," + s1;
            } catch (NullPointerException e) {

            }
            try {
                String s2 = row.getCell(FacktAddrCell + 2).getStringCellValue();
                SS = SS + "," + s2;
            } catch (NullPointerException e) {

            }
            try {
                String s3 = row.getCell(FacktAddrCell + 3).getStringCellValue();
                SS = SS + "," + s3;
            } catch (NullPointerException e) {

            }
            try {
                String s4 = row.getCell(FacktAddrCell + 4).getStringCellValue();
                SS = SS + "," + s4;
            } catch (NullPointerException e) {
            }
            try {
                String s5 = row.getCell(FacktAddrCell + 5).getStringCellValue();
                SS = SS + "," + s5;
            } catch (NullPointerException e) {
            }
            try {
                String s6 = row.getCell(FacktAddrCell + 6).getStringCellValue();
                SS = SS + "," + s6;
            } catch (NullPointerException e) {
            }
            apOVD.setFacktAddr(SS);


            apOVD.setArticle(row.getCell(ArrticleCell).getStringCellValue());
            try {
                apOVD.setPasportS(row.getCell(PasportSCell).getStringCellValue());
                apOVD.setPasportN(row.getCell(PasportNCell).getStringCellValue());
            } catch (NullPointerException e) {

            }
            String art = row.getCell(ArrticleCell).getStringCellValue();
            System.out.println(art);
            String article = "";
            String cact = "";
            String pattern = "\\.";
            String[] articleSplit = art.split(pattern);
            System.out.println(articleSplit.length);
            if (articleSplit.length > 0) {
                for (int k = 0; k < articleSplit.length; k++) {
                    if (articleSplit[k].equals("Ч") || articleSplit[k].equals("Ч1") || articleSplit[k].equals("Ч2") || articleSplit[k].equals("Ч3") || articleSplit[k].equals("Ч4") || articleSplit[k].equals("Ч5") || articleSplit[k].equals("Ч6")) {
                        article = "";
                        if (articleSplit[k].equals("Ч")) {
                            cact = articleSplit[k + 1];
                        } else {
                            cact = String.valueOf(articleSplit[k].charAt(1));
                        }

                        article = articleSplit[0] + "." + articleSplit[1];

                        break;
                    } else {
                        article = articleSplit[0] + "." + articleSplit[1];
                    }
                }
            }
            apOVD.setArticle(article);
            apOVD.setCact(cact);
            listapOVD.add(apOVD);
            i++;
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
                ps = connection.prepareStatement("insert into ap_ovd(lastname,firstname,middlename,facktaddr,article,birthday, datep,pasports,pasportn,cact,organ,datezak, datepost,protocoln,nakaz ) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
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
                ps.setString(10, apOVDList.get(i).getCact());
                ps.setString(11, apOVDList.get(i).getOrgan());

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
                ps.setString(14, apOVDList.get(i).getProtocolN());
                ps.setString(15, apOVDList.get(i).getNakaz());

                ps.executeUpdate();


                if (true) {

                    if (apOVDList.get(i).getArticle().equals("12.8") || apOVDList.get(i).getArticle().equals("12.26")) {
                        ps = connection.prepareStatement("insert into st_12_8_st_12_6 (lastname,firstname,middlename,facktaddr,article,birthday, datep,pasports,pasportn,cact,organ,datezak, datepost,protokoln, nakaz ) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    } else if (apOVDList.get(i).getArticle().equals("6.1.1")) {
                        ps = connection.prepareStatement("insert into st_6_1_1 (lastname,firstname,middlename,facktaddr,article,birthday, datep,pasports,pasportn,cact,organ,datezak,datepost,protokoln, nakaz ) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    } else if (apOVDList.get(i).getArticle().equals("14.16") && apOVDList.get(i).getCact().equals("2.1")) {
                        ps = connection.prepareStatement("insert into st_14_16 (lastname,firstname,middlename,facktaddr,article,birthday, datep,pasports,pasportn,cact,organ,datezak,  datepost,protokoln, nakaz ) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    } else if (apOVDList.get(i).getArticle().equals("5.35.1") || apOVDList.get(i).getArticle().equals("5.35")) {
                        ps = connection.prepareStatement("insert into st_5_35_1(lastname,firstname,middlename,facktaddr,article,birthday, datep,pasports,pasportn,cact,organ,datezak,  datepost,protokoln, nakaz ) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    } else if (apOVDList.get(i).getArticle().equals("7.27")) {
                        ps = connection.prepareStatement("insert into st_7_27(lastname,firstname,middlename,facktaddr,article,birthday, datep,pasports,pasportn,cact,organ,datezak , datepost,protokoln, nakaz ) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    } else if (apOVDList.get(i).getArticle().equals("14.17.1")) {
                        ps = connection.prepareStatement("insert into st_14_17_1(lastname,firstname,middlename,facktaddr,article,birthday, datep,pasports,pasportn,cact,organ,datezak ,  datepost,protokoln, nakaz ) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    } else if (apOVDList.get(i).getArticle().equals("20.2")) {
                        ps = connection.prepareStatement("insert into st_20_2(lastname,firstname,middlename,facktaddr,article,birthday, datep,pasports,pasportn,cact,organ,datezak ,  datepost,protokoln, nakaz ) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    } else if (apOVDList.get(i).getArticle().equals("20.17")) {
                        ps = connection.prepareStatement("insert into st_20_17(lastname,firstname,middlename,facktaddr,article,birthday, datep,pasports,pasportn,cact,organ,datezak ,   datepost,protokoln, nakaz ) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    } else if (apOVDList.get(i).getArticle().equals("20.33")) {
                        ps = connection.prepareStatement("insert into st_20_33(lastname,firstname,middlename,facktaddr,article,birthday, datep,pasports,pasportn,cact,organ,datezak , datepost,protokoln, nakaz ) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    } else {
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
                    ps.setString(10, apOVDList.get(i).getCact());
                    ps.setString(11, apOVDList.get(i).getOrgan());

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
                    ps.setString(14, apOVDList.get(i).getProtocolN());
                    ps.setString(15, apOVDList.get(i).getNakaz());
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