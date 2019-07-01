package source.systemAP;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import source.DbConnect;
import source.systemAP.model.ApRPN;

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


public class ReadApRPN {
    public static final int FIOCell = 6;
    public static final int FacktAddrCell = 8;
    public static final int ArrticleCell = 10;
    public static final int DatePCell = 5;
    public static final int DateZakCell = 12;
    public static final int NakazCell = 13;
    public static final int ProtocolCell = 11;

    private Connection connection;

    public ReadApRPN() {
        connection = DbConnect.getConnection();
    }

    public List<ApRPN> ReadExel(String path) throws IOException {
        List<ApRPN> listap = new ArrayList<ApRPN>();
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


            ApRPN apRPN = new ApRPN();
            try {
                apRPN.setFIO((row.getCell(FIOCell).getStringCellValue()));
            } catch (java.lang.NullPointerException e) {
                System.out.print("null_fio");
            }

            try {
                apRPN.setProtocolN((row.getCell(ProtocolCell).getStringCellValue()));
            } catch (java.lang.NullPointerException e) {
                System.out.print("null_prot");
            }

            try {
            if (row.getCell(NakazCell).getCellType() == HSSFCell.CELL_TYPE_STRING) {
                apRPN.setNakaz(row.getCell(NakazCell).getStringCellValue());
            }
            if (row.getCell(NakazCell).getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                apRPN.setNakaz(String.valueOf(row.getCell(NakazCell).getNumericCellValue()));
            }
            }catch (java.lang.NullPointerException e ){
                System.out.print("null_nakaz");
            }

            try {
                int DateType = row.getCell(DatePCell).getCellType();
                if (DateType == 0) {
                    Date DateSTR = row.getCell(DatePCell).getDateCellValue();
                    apRPN.setDateP(DateSTR);
                }
            } catch (java.lang.NullPointerException e) {
                System.out.print("null_datep");
            }

            try {
                int DateZakType = row.getCell(DateZakCell).getCellType();
                if (DateZakType == 0) {
                    Date dateZak = row.getCell(DateZakCell).getDateCellValue();
                    System.out.println(dateZak);
                    apRPN.setDateZak(dateZak);
                }
            } catch (java.lang.NullPointerException e) {
                System.out.print("null_zak");
            }
            try {
                apRPN.setFacktAddr(row.getCell(FacktAddrCell).getStringCellValue());
            } catch (java.lang.NullPointerException e) {
                System.out.print("null_arrd");
            }
            try {
                apRPN.setArticle(row.getCell(ArrticleCell).getStringCellValue());

            } catch (java.lang.NullPointerException e) {
                System.out.print("null_article ");
            }
            listap.add(apRPN);

            i++;
        }
        System.out.println(i);
        fs.close();
        return listap;
    }

    public int WriteToBD(List<ApRPN> apRPNList) {

        PreparedStatement ps = null;

        int j = 0;
        for (int i = 0; i < apRPNList.size(); i++) {
            j++;
            try {
                try {
                    ps = connection.prepareStatement("insert into ap_rpn(fio,facktaddr,article, datep, datezak,protocoln,nakaz ) values (?,?,?,?,?,?,?)");
                    ps.setString(1, toUpperCase(apRPNList.get(i).getFIO()));
                    ps.setString(2, toUpperCase(apRPNList.get(i).getFacktAddr()));
                    ps.setString(3, toUpperCase(apRPNList.get(i).getArticle()));

                    if (apRPNList.get(i).getDateP() != null) {
                        ps.setDate(4, new java.sql.Date(apRPNList.get(i).getDateP().getTime()));
                    } else {
                        ps.setNull(4, Types.DATE);
                    }

                    if (apRPNList.get(i).getDateZak() != null) {
                        ps.setDate(5, new java.sql.Date(apRPNList.get(i).getDateZak().getTime()));
                    } else {
                        ps.setNull(5, Types.DATE);
                    }

                    ps.setString(6, apRPNList.get(i).getProtocolN());
                    ps.setString(7, apRPNList.get(i).getNakaz());

                    ps.executeUpdate();
                } catch (java.lang.NullPointerException e)
                {
                    e.printStackTrace();
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