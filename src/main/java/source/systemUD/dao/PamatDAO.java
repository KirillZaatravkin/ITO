package source.systemUD.dao;

import org.springframework.stereotype.Repository;
import source.DbConnectUD;
import source.systemUD.model.PamatModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by кирюха on 16.05.2019.
 */
@Repository
public class PamatDAO {

    public void addPamat(PamatModel pamat1Model) {
        Connection connection = DbConnectUD.getConnection();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("insert into pamat (delo, s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16,s17,s18,s19,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19, types) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, pamat1Model.getDelo());
            ps.setInt(2, pamat1Model.getS1());
            ps.setInt(3, pamat1Model.getS2());
            ps.setInt(4, pamat1Model.getS3());
            ps.setInt(5, pamat1Model.getS4());
            ps.setInt(6, pamat1Model.getS5());
            ps.setInt(7, pamat1Model.getS6());
            ps.setInt(8, pamat1Model.getS7());
            ps.setInt(9, pamat1Model.getS8());
            ps.setInt(10, pamat1Model.getS9());
            ps.setInt(11, pamat1Model.getS10());
            ps.setInt(12, pamat1Model.getS11());
            ps.setInt(13, pamat1Model.getS12());
            ps.setInt(14, pamat1Model.getS13());
            ps.setInt(15, pamat1Model.getS14());
            ps.setInt(16, pamat1Model.getS15());
            ps.setInt(17, pamat1Model.getS16());
            ps.setInt(18, pamat1Model.getS17());
            ps.setInt(19, pamat1Model.getS18());
            ps.setInt(20, pamat1Model.getS19());
            ps.setString(21, pamat1Model.getT1());
            ps.setString(22, pamat1Model.getT2());
            ps.setString(23, pamat1Model.getT3());
            ps.setString(24, pamat1Model.getT4());
            ps.setString(25, pamat1Model.getT5());
            ps.setString(26, pamat1Model.getT6());
            ps.setString(27, pamat1Model.getT7());
            ps.setString(28, pamat1Model.getT8());
            ps.setString(29, pamat1Model.getT9());
            ps.setString(30, pamat1Model.getT10());
            ps.setString(31, pamat1Model.getT11());
            ps.setString(32, pamat1Model.getT12());
            ps.setString(33, pamat1Model.getT13());
            ps.setString(34, pamat1Model.getT14());
            ps.setString(35, pamat1Model.getT15());
            ps.setString(36, pamat1Model.getT16());
            ps.setString(37, pamat1Model.getT17());
            ps.setString(38, pamat1Model.getT18());
            ps.setString(39, pamat1Model.getT19());
            ps.setInt(40, pamat1Model.getType());
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


    public PamatModel setPamatModel( int delo, int s1,int s2,int s3,int s4,int s5,int s6,int s7,int s8,int s9,int s10,int s11,int s12,int s13,int s14,int s15,int s16,int s17,int s18,int s19, String t1,String t2,String t3,String t4,String t5,String t6,String t7,String t8,String t9,String t10,String t11,String t12,String t13,String t14,String t15,String t16,String t17,String t18,String t19, int type) {

        PamatModel pamat1Model =new PamatModel();
        pamat1Model.setType(type);
        pamat1Model.setDelo(delo);
        pamat1Model.setS1(s1);
        pamat1Model.setS2(s2);
        pamat1Model.setS3(s3);
        pamat1Model.setS4(s4);
        pamat1Model.setS5(s5);
        pamat1Model.setS6(s6);
        pamat1Model.setS7(s7);
        pamat1Model.setS8(s8);
        pamat1Model.setS9(s9);
        pamat1Model.setS10(s10);
        pamat1Model.setS11(s11);
        pamat1Model.setS12(s12);
        pamat1Model.setS13(s13);
        pamat1Model.setS14(s14);
        pamat1Model.setS15(s15);
        pamat1Model.setS16(s16);
        pamat1Model.setS17(s17);
        pamat1Model.setS18(s18);
        pamat1Model.setS19(s19);
        pamat1Model.setT1(t1);
        pamat1Model.setT2(t2);
        pamat1Model.setT3(t3);
        pamat1Model.setT4(t4);
        pamat1Model.setT5(t5);
        pamat1Model.setT6(t6);
        pamat1Model.setT7(t7);
        pamat1Model.setT8(t8);
        pamat1Model.setT9(t9);
        pamat1Model.setT10(t10);
        pamat1Model.setT11(t11);
        pamat1Model.setT12(t12);
        pamat1Model.setT13(t13);
        pamat1Model.setT14(t14);
        pamat1Model.setT15(t15);
        pamat1Model.setT16(t16);
        pamat1Model.setT17(t17);
        pamat1Model.setT18(t18);
        pamat1Model.setT19(t19);
        return pamat1Model;
    }


    public PamatModel getPamat (int id) {
        Connection connection = DbConnectUD.getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        PamatModel pamat1Model = new PamatModel();
        try {
            statement = connection.prepareStatement("select * from pamat where id=? limit 1");
            statement.setInt(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                pamat1Model.setS1(rs.getInt("s1"));
                pamat1Model.setS2(rs.getInt("s2"));
                pamat1Model.setS3(rs.getInt("s3"));
                pamat1Model.setS4(rs.getInt("s4"));
                pamat1Model.setS5(rs.getInt("s5"));
                pamat1Model.setS6(rs.getInt("s6"));
                pamat1Model.setS7(rs.getInt("s7"));
                pamat1Model.setS8(rs.getInt("s8"));
                pamat1Model.setS9(rs.getInt("s9"));
                pamat1Model.setS10(rs.getInt("s10"));
                pamat1Model.setS11(rs.getInt("s11"));
                pamat1Model.setS12(rs.getInt("s12"));
                pamat1Model.setS13(rs.getInt("s13"));
                pamat1Model.setS14(rs.getInt("s14"));
                pamat1Model.setS15(rs.getInt("s15"));
                pamat1Model.setS16(rs.getInt("s16"));
                pamat1Model.setS17(rs.getInt("s17"));
                pamat1Model.setS18(rs.getInt("s18"));
                pamat1Model.setS19(rs.getInt("s19"));

                pamat1Model.setT1(rs.getString("t1"));
                pamat1Model.setT2(rs.getString("t2"));
                pamat1Model.setT3(rs.getString("t3"));
                pamat1Model.setT4(rs.getString("t4"));
                pamat1Model.setT5(rs.getString("t5"));
                pamat1Model.setT6(rs.getString("t6"));
                pamat1Model.setT7(rs.getString("t7"));
                pamat1Model.setT8(rs.getString("t8"));
                pamat1Model.setT9(rs.getString("t9"));
                pamat1Model.setT10(rs.getString("t10"));
                pamat1Model.setT11(rs.getString("t11"));
                pamat1Model.setT12(rs.getString("t12"));
                pamat1Model.setT13(rs.getString("t13"));
                pamat1Model.setT14(rs.getString("t14"));
                pamat1Model.setT15(rs.getString("t15"));
                pamat1Model.setT16(rs.getString("t16"));
                pamat1Model.setT17(rs.getString("t17"));
                pamat1Model.setT18(rs.getString("t18"));
                pamat1Model.setT19(rs.getString("t19"));
                pamat1Model.setDelo(rs.getInt("delo"));
                pamat1Model.setType(rs.getInt("types"));

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
        DbConnectUD.close(connection);
        return pamat1Model;
    }



    public  ArrayList<Integer> getPamatUD(int delo, int type) {
        Connection connection = DbConnectUD.getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        ArrayList<Integer> integerArrayList =new ArrayList<Integer>();
        try {
            statement = connection.prepareStatement("select * from pamat where delo=? and types=?");
            statement.setInt(1, delo);
            statement.setInt(2, type);
            rs = statement.executeQuery();
            while (rs.next()) {
               integerArrayList.add(rs.getInt("id"));
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
        DbConnectUD.close(connection);
        return integerArrayList;
    }
}
