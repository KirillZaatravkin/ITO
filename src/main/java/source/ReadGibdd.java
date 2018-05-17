package source;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import static jdk.nashorn.internal.objects.NativeString.toUpperCase;


public class ReadGibdd {
    public static final int FirstNameCell = 0;
    public static final int LastNameCell = 1;
    public static final int MiddleNameCell = 2;
    public static final int BirthDayCell = 3;
    public static final int FacktAddrCell = 4;
    public static final int ResAddrCell = 5;
    public static final int ArrticleCell = 6;
    public static final int CactCell = 7;
    public static final int DatePCell = 16;
    public static final int PasportSCell = 10;
    public static final int PasportNCell = 11;
    private Connection connection;

    public ReadGibdd() {
        connection = DbConnect.getConnection();
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
            //System.out.println(apOVD.FirstName);
            apOVD.setLastName(row.getCell(LastNameCell).getStringCellValue());
            apOVD.setMiddleName(row.getCell(MiddleNameCell).getStringCellValue());
            int birthDayType = row.getCell(BirthDayCell).getCellType();
            if (birthDayType == 0) {
                Date birthDaySTR = row.getCell(BirthDayCell).getDateCellValue();
                //Locale local = new Locale("ru", "RU");
                // DateFormat df = DateFormat.getDateInstance(DateFormat.DEFAULT, local);
                // System.out.println(df.format(birthDaySTR));
                apOVD.setBirthday(birthDaySTR);
                System.out.println(birthDaySTR);
            }
            int datePType = row.getCell(DatePCell).getCellType();
            if (datePType == 0) {
                Date datePSTR = row.getCell(DatePCell).getDateCellValue();
                //Locale local = new Locale("ru", "RU");
                // DateFormat df = DateFormat.getDateInstance(DateFormat.DEFAULT, local);
                // System.out.println(df.format(birthDaySTR));
                apOVD.setDateP(datePSTR);
                System.out.println(datePSTR);

            }
            apOVD.setFacktAddr(row.getCell(FacktAddrCell).getStringCellValue());
            apOVD.setResAddr(row.getCell(ResAddrCell).getStringCellValue());
            apOVD.setArticle(row.getCell(ArrticleCell).getStringCellValue());
            try{
            {   apOVD.setPasportS(row.getCell(PasportSCell).getStringCellValue());
                apOVD.setPasportN(row.getCell(PasportNCell).getStringCellValue());
            }

            }
            catch (NullPointerException e)
            {
System.out.println("j");
            }
            try{
                {
                    apOVD.setCact(row.getCell(CactCell).getStringCellValue());
                }

            }
            catch (NullPointerException e)
            {
                System.out.println("j");
            }

            listapOVD.add(apOVD);
            i++;
        }
        System.out.println(i);
        return listapOVD;
    }

    public int WriteToBD(List<ApOVD> apOVDList) {

        PreparedStatement ps = null;

        int j = 0;
        for (int i = 0; i < apOVDList.size(); i++) {
            j++;
            try {
                ps = connection.prepareStatement("insert into ap_ovd(lastname,firstname,middlename,facktaddr,resaddr,article,birthday, datep,pasports,pasportn,cact) values (?,?,?,?,?,?,?,?,?,?,?)");
                ps.setString(1, toUpperCase(apOVDList.get(i).getFirstName()));
                ps.setString(2, toUpperCase(apOVDList.get(i).getLastName()));
                ps.setString(3, toUpperCase(apOVDList.get(i).getMiddleName()));
                ps.setString(4, apOVDList.get(i).getFacktAddr());
                ps.setString(5, apOVDList.get(i).getResAddr());
                ps.setString(6, apOVDList.get(i).getArticle());


                if (apOVDList.get(i).getBirthDay() != null) {
                    ps.setDate(7, new java.sql.Date(apOVDList.get(i).getBirthDay().getTime()));
                } else {
                    ps.setNull(7, Types.DATE);
                }
                //   java.util.Date udate= new java.util.Date();
                //  java.sql.Date sdate=new java.sql.Date(udate.getTime());
                // ps.setDate(7,sdate);

                if (apOVDList.get(i).getDateP() != null) {
                    ps.setDate(8, new java.sql.Date(apOVDList.get(i).getDateP().getTime()));
                } else {
                    ps.setNull(8, Types.DATE);
                }
                ps.setString(9, apOVDList.get(i).getPasportS());
                ps.setString(10, apOVDList.get(i).getPasportN());
                ps.setString(11,apOVDList.get(i).getCact());
                ps.executeUpdate();

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