package source.systemAP.dao;

import org.springframework.stereotype.Service;
import source.DbConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by кирюха on 18.07.2018.
 */

@Service
public class LoginDao {


    public String getUserPasswordHash(String username) {

        String sql = "select * from users where username=?;";
        Connection conn = null;

        try {

            conn = DbConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {

                              return rs.getString("password");
            }
            rs.close();
            ps.close();

        } catch (Exception e){
            e.printStackTrace();


        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {}
            }
        }

        return null;
    }


    public String getUserRole(String username) {

        String roleName = "";

        String sql = "select groups from users where username=?;";
        Connection conn = null;

        try {
            conn = DbConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                roleName = rs.getString("groups");
            }
            rs.close();
            ps.close();

        } catch (Exception e) {

        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                }
            }
        }

        return roleName;
    }
}
