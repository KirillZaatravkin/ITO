package source.systemUD.dao;

import org.springframework.stereotype.Repository;
import source.DbConnectUD;
import source.systemUD.model.Settings;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by кирюха on 14.01.2019.
 */
@Repository
public class SettingsDAO {
    public Settings getSetting(int id) {
        Connection connection = DbConnectUD.getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        Settings setting = new Settings();
        try {
            statement = connection.prepareStatement("select * from settings where id=?");
            statement.setInt(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                setting.setSettings(rs.getString("sett"));
                setting.setSetting_name(rs.getString("sett_name"));
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
        return setting;
    }

}
