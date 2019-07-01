package source.systemUD.dao;

import org.springframework.stereotype.Repository;
import source.DbConnectUD;
import source.systemUD.model.DocGroups;
import source.systemUD.model.UDDoc;

import java.sql.*;
import java.util.ArrayList;

import static org.springframework.util.ObjectUtils.isEmpty;

/**
 * Created by кирюха on 13.01.2019.
 */
@Repository
public class DocDAO {

    public ArrayList<UDDoc> getUDDoc(int id) {
        Connection connection = DbConnectUD.getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        ArrayList<UDDoc> udDocs = new ArrayList<UDDoc>();

        try {

            statement = connection.prepareStatement("select d.original_name as or_name, d.patch as patch, d.id as id, d.date_create as date_create,d.type_id as type_id , g.title as gtitle,t.title as ttitle,  g.id as gid from documets as d join doc_type as t on  d.type_id=t.id join doc_group as g on g.id=t.group_id  where ud_id=? order by g.id, t.id");
            statement.setInt(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                UDDoc ud = new UDDoc();
                ud.setPath(rs.getString("patch"));
                ud.setId(rs.getInt("id"));
                ud.setOriginalName(rs.getString("or_name"));
                String str = ud.getOriginalName();
                if (!"".equals(str) && str != null) {
                    int index = str.lastIndexOf(".DOCX");
                    if (index == -1) {
                        ud.setDocx(false);
                    } else {
                        ud.setDocx(true);
                    }
                }
                ud.setCreatedate(rs.getDate("date_create"));
                ud.setType(rs.getInt("type_id"));
                ud.setGroupDocTitle(rs.getString("gtitle"));
                ud.setTypeDocTitle(rs.getString("ttitle"));
                ud.setIdGroup(rs.getInt("gid"));
                udDocs.add(ud);
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
        return udDocs;
    }


    public ArrayList<DocGroups> docGroup(int groupID) {

        Connection connection = DbConnectUD.getConnection();
        PreparedStatement statement = null;
        ArrayList<DocGroups> docGroupsList = new ArrayList<DocGroups>();
        ResultSet rs = null;

        try {

            statement = connection.prepareStatement("SELECT  * FROM doc_type  WHERE  group_id=? order by id;");
            statement.setInt(1, groupID);
            rs = statement.executeQuery();

            while (rs.next()) {
                DocGroups docGroup = new DocGroups();
                docGroup.setId(rs.getInt("id"));
                docGroup.setTitle(rs.getString("title"));
                docGroupsList.add(docGroup);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return docGroupsList;
    }

    public void uploadDoc(String patch, int type, int udID, String originalName) {
        Connection connection = DbConnectUD.getConnection();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("insert into documets (patch, type_id, ud_id, original_name) values (?,?,?,?)");
            ps.setString(1, patch);
            ps.setInt(2, type);
            ps.setInt(3, udID);
            ps.setString(4, originalName);
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

    public boolean delecteDocBD (int id)
    {
        Connection connection = DbConnectUD.getConnection();
        PreparedStatement statement = null;
        ArrayList<DocGroups> docGroupsList = new ArrayList<DocGroups>();
        ResultSet rs = null;

        try {

            statement = connection.prepareStatement("  DELETE FROM documets  WHERE id=? ;");
            statement.setInt(1, id);
            rs = statement.executeQuery();

        } catch (SQLException e) {

            e.printStackTrace();
        }finally {
            if (statement  != null) {
                try {
                    statement .close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }


}
