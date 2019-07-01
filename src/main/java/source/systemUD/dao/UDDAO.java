package source.systemUD.dao;

import org.springframework.stereotype.Repository;
import source.DbConnectUD;
import source.systemAP.dao.UserDao;
import source.systemUD.model.UDModel;


import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by кирюха on 07.01.2019.
 */

@Repository
public class UDDAO {

    public void createUD(UDModel ud) {
        Connection connection = DbConnectUD.getConnection();
        PreparedStatement ps = null;
        UserDao userDao= new UserDao();
        try {
            ps = connection.prepareStatement("insert into case_ud(numberud, owners) values (?,?)");
            ps.setString(1, ud.getNumberUD());
            ps.setString(2, userDao.getCurrentUser());
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

    public UDModel setUD(String numberUd) {
        UDModel udModel = new UDModel();
        udModel.setNumberUD(numberUd);
        return udModel;
    }


    public List<UDModel> getAllUD() {
        Connection connection = DbConnectUD.getConnection();

        List<UDModel> UDs = new ArrayList<UDModel>();
        UserDao userDao =new UserDao();
        String owner=  userDao.getCurrentUser();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {

            statement = connection.prepareStatement("select * from case_ud WHERE owners=? order by date_create");
            statement.setString(1,owner);
            rs = statement.executeQuery();

            while (rs.next()) {
                UDModel ud = new UDModel();
                ud.setNumberUD(rs.getString("numberud"));
                ud.setId(rs.getInt("id"));
                ud.setDataCreate(rs.getDate("date_create"));
                ud.setOwner(rs.getString("owners"));


                UDs.add(ud);
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
        return UDs;
    }


    public void editUD(UDModel ud) {
        Connection connection = DbConnectUD.getConnection();
        PreparedStatement ps = null;
        //TODO
    }

    public UDModel getUD(int id) {
        Connection connection = DbConnectUD.getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;

        UDModel ud = new UDModel();
        try {

            statement = connection.prepareStatement("select * from case_ud where id=? limit 1");
            statement.setInt(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                ud.setNumberUD(rs.getString("numberud"));
                ud.setId(rs.getInt("id"));
                // ud.setDataCreate(rs.getDate("date_create"));
                ud.setOwner(rs.getString("owners"));
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
        return ud;
    }


}
