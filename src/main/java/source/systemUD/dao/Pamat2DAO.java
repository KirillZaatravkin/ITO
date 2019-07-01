package source.systemUD.dao;

import org.springframework.stereotype.Repository;
import source.DbConnectUD;
import source.systemUD.model.Pamat1Model;
import source.systemUD.model.Pamat2Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by кирюха on 11.02.2019.
 */
@Repository
public class Pamat2DAO {

    public void addPamat2(Pamat2Model pamat1Model) {
        Connection connection = DbConnectUD.getConnection();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("insert into pamat2 (  delo,face, kusp, sroki, datapost, povod, upk, prok, uved, st147, otvod, prest, dataprest, mesto, sposob, har, kval, mat,inst, ord,ud, st447, podsled, sroku, prig, inyi, facet, kuspt, srokit, datapostt, povodt, upkt, prokt, uvedt, st147t, otvodt, prestt, dataprestt, mestot, sposobt, hart, kvalt, matt,instt, ordt,udt, st447t, podsledt, srokut, prigt, inyit) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, pamat1Model.getDelo());
            ps.setInt(2, pamat1Model.getFace());
            ps.setInt(3, pamat1Model.getKusp());
            ps.setInt(4, pamat1Model.getSroki());
            ps.setInt(5, pamat1Model.getDatapost());
            ps.setInt(6, pamat1Model.getPovod());
            ps.setInt(7, pamat1Model.getUpk());
            ps.setInt(8, pamat1Model.getProk());
            ps.setInt(9, pamat1Model.getUved());
            ps.setInt(10, pamat1Model.getSt147());
            ps.setInt(11, pamat1Model.getOtvod());
            ps.setInt(12, pamat1Model.getPrest());
            ps.setInt(13, pamat1Model.getDataprest());
            ps.setInt(14, pamat1Model.getMesto());
            ps.setInt(15, pamat1Model.getSposob());
            ps.setInt(16, pamat1Model.getHar());
            ps.setInt(17, pamat1Model.getKval());
            ps.setInt(18, pamat1Model.getMat());
            ps.setInt(19, pamat1Model.getInst());
            ps.setInt(20, pamat1Model.getOrd());
            ps.setInt(21, pamat1Model.getUd());
            ps.setInt(22, pamat1Model.getSt447());
            ps.setInt(23, pamat1Model.getPodsled());
            ps.setInt(24, pamat1Model.getSroku());
            ps.setInt(25, pamat1Model.getPrig());
            ps.setInt(26, pamat1Model.getInyi());
            ps.setString(27, pamat1Model.getFacet());
            ps.setString(28, pamat1Model.getKuspt());
            ps.setString(29, pamat1Model.getSrokit());
            ps.setString(30, pamat1Model.getDatapostt());
            ps.setString(31, pamat1Model.getPovodt());
            ps.setString(32, pamat1Model.getUpkt());
            ps.setString(33, pamat1Model.getProkt());
            ps.setString(34, pamat1Model.getUvedt());
            ps.setString(35, pamat1Model.getSt147t());
            ps.setString(36, pamat1Model.getOtvodt());
            ps.setString(37, pamat1Model.getPrestt());
            ps.setString(38, pamat1Model.getDataprestt());
            ps.setString(39, pamat1Model.getMestot());
            ps.setString(40, pamat1Model.getSposobt());
            ps.setString(41, pamat1Model.getHart());
            ps.setString(42, pamat1Model.getKvalt());
            ps.setString(43, pamat1Model.getMatt());
            ps.setString(44, pamat1Model.getInstt());
            ps.setString(45, pamat1Model.getOrdt());
            ps.setString(46, pamat1Model.getUdt());
            ps.setString(47, pamat1Model.getSt447t());
            ps.setString(48, pamat1Model.getPodsledt());
            ps.setString(49, pamat1Model.getSrokut());
            ps.setString(50, pamat1Model.getPrigt());
            ps.setString(51, pamat1Model.getInyit());
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


    public Pamat2Model setPamat2Model(int delo, int face, int kusp, int sroki, int datapost, int povod, int upk, int prok, int uved, int st147, int otvod, int prest, int dataprest, int mesto, int sposob, int har, int kval, int mat, int inst, int ord, int ud, int st447, int podsled, int sroku, int prig, int inyi, String facet, String kuspt, String srokit, String datapostt, String povodt, String upkt, String prokt, String uvedt, String st147t, String otvodt, String prestt, String dataprestt, String mestot, String sposobt, String hart, String kvalt, String matt, String instt, String ordt, String udt, String st447t, String podsledt, String srokut, String prigt, String inyit) {

        Pamat2Model pamat1Model = new Pamat2Model();
        pamat1Model.setFace(face);
        pamat1Model.setKusp(kusp);
        pamat1Model.setSroki(sroki);
        pamat1Model.setDatapost(datapost);
        pamat1Model.setPovod(povod);
        pamat1Model.setUpk(upk);
        pamat1Model.setProk(prok);
        pamat1Model.setUved(uved);
        pamat1Model.setSt147(st147);
        pamat1Model.setOtvod(otvod);
        pamat1Model.setPrest(prest);
        pamat1Model.setDataprest(dataprest);
        pamat1Model.setMesto(mesto);
        pamat1Model.setSposob(sposob);
        pamat1Model.setHar(har);
        pamat1Model.setKval(kval);
        pamat1Model.setMat(mat);
        pamat1Model.setInst(inst);
        pamat1Model.setOrd(ord);
        pamat1Model.setUd(ud);
        pamat1Model.setSt447(st447);
        pamat1Model.setPodsled(podsled);
        pamat1Model.setSroku(sroku);
        pamat1Model.setPrig(prig);
        pamat1Model.setInyi(inyi);
        pamat1Model.setDelo(delo);
        pamat1Model.setFacet(facet);
        pamat1Model.setKuspt(kuspt);
        pamat1Model.setSrokit(srokit);
        pamat1Model.setDatapostt(datapostt);
        pamat1Model.setPovodt(povodt);
        pamat1Model.setUpkt(upkt);
        pamat1Model.setProkt(prokt);
        pamat1Model.setUvedt(uvedt);
        pamat1Model.setSt147t(st147t);
        pamat1Model.setOtvodt(otvodt);
        pamat1Model.setPrestt(prestt);
        pamat1Model.setDataprestt(dataprestt);
        pamat1Model.setMestot(mestot);
        pamat1Model.setSposobt(sposobt);
        pamat1Model.setHart(hart);
        pamat1Model.setKvalt(kvalt);
        pamat1Model.setMatt(matt);
        pamat1Model.setInstt(instt);
        pamat1Model.setOrdt(ordt);
        pamat1Model.setUdt(udt);
        pamat1Model.setSt447t(st447t);
        pamat1Model.setPodsledt(podsledt);
        pamat1Model.setSrokut(srokut);
        pamat1Model.setPrigt(prigt);
        pamat1Model.setInyit(inyit);

        return pamat1Model;
    }


    public Pamat2Model getPamat2(int id) {
        Connection connection = DbConnectUD.getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        Pamat2Model pamat1Model = new Pamat2Model();
        try {
            statement = connection.prepareStatement("select * from pamat2 where id=? limit 1");
            statement.setInt(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                pamat1Model.setFace(rs.getInt("face"));
                pamat1Model.setKusp(rs.getInt("kusp"));
                pamat1Model.setSroki(rs.getInt("sroki"));
                pamat1Model.setDatapost((rs.getInt("datapost")));
                pamat1Model.setPovod(((rs.getInt("povod"))));
                pamat1Model.setUpk((rs.getInt("upk")));
                pamat1Model.setProk((rs.getInt("prok")));
                pamat1Model.setUved((rs.getInt("uved")));
                pamat1Model.setSt147(rs.getInt("st147"));
                pamat1Model.setOtvod(rs.getInt("otvod"));
                pamat1Model.setPrest(rs.getInt("prest"));
                pamat1Model.setDataprest(rs.getInt("dataprest"));
                pamat1Model.setMesto(rs.getInt("mesto"));
                pamat1Model.setSposob(rs.getInt("sposob"));
                pamat1Model.setHar(rs.getInt("har"));
                pamat1Model.setKval(rs.getInt("kval"));
                pamat1Model.setMat(rs.getInt("mat"));
                pamat1Model.setInst((rs.getInt("inst")));
                pamat1Model.setOrd((rs.getInt("ord")));
                pamat1Model.setUd((rs.getInt("ud")));
                pamat1Model.setSt447((rs.getInt("st447")));
                pamat1Model.setPodsled(rs.getInt("podsled"));
                pamat1Model.setSroku(rs.getInt("sroku"));
                pamat1Model.setPrig(rs.getInt("prig"));
                pamat1Model.setInyi((rs.getInt("inyi")));
                pamat1Model.setDelo((rs.getInt("delo")));

                pamat1Model.setFace(rs.getInt("face"));
                pamat1Model.setKusp(rs.getInt("kusp"));
                pamat1Model.setSroki(rs.getInt("sroki"));
                pamat1Model.setDatapost((rs.getInt("datapost")));
                pamat1Model.setPovod(((rs.getInt("povod"))));
                pamat1Model.setUpk((rs.getInt("upk")));
                pamat1Model.setProk((rs.getInt("prok")));
                pamat1Model.setUved((rs.getInt("uved")));
                pamat1Model.setSt147(rs.getInt("st147"));
                pamat1Model.setOtvod(rs.getInt("otvod"));
                pamat1Model.setPrest(rs.getInt("prest"));
                pamat1Model.setDataprest(rs.getInt("dataprest"));
                pamat1Model.setMesto(rs.getInt("mesto"));
                pamat1Model.setSposob(rs.getInt("sposob"));
                pamat1Model.setHar(rs.getInt("har"));
                pamat1Model.setKval(rs.getInt("kval"));
                pamat1Model.setMat(rs.getInt("mat"));
                pamat1Model.setInst((rs.getInt("inst")));
                pamat1Model.setOrd((rs.getInt("ord")));
                pamat1Model.setUd((rs.getInt("ud")));
                pamat1Model.setSt447((rs.getInt("st447")));
                pamat1Model.setPodsled(rs.getInt("podsled"));
                pamat1Model.setSroku(rs.getInt("sroku"));
                pamat1Model.setPrig(rs.getInt("prig"));
                pamat1Model.setInyi((rs.getInt("inyi")));
                pamat1Model.setDelo((rs.getInt("delo")));
                pamat1Model.setFacet(rs.getString("facet"));
                pamat1Model.setKuspt(rs.getString("kuspt"));
                pamat1Model.setSrokit(rs.getString("srokit"));
                pamat1Model.setDatapostt((rs.getString("datapostt")));
                pamat1Model.setPovodt(((rs.getString("povodt"))));
                pamat1Model.setUpkt((rs.getString("upkt")));
                pamat1Model.setProkt((rs.getString("prokt")));
                pamat1Model.setUvedt((rs.getString("uvedt")));
                pamat1Model.setSt147t(rs.getString("st147t"));
                pamat1Model.setOtvodt(rs.getString("otvodt"));
                pamat1Model.setPrestt(rs.getString("prestt"));
                pamat1Model.setDataprestt(rs.getString("dataprestt"));
                pamat1Model.setMestot(rs.getString("mestot"));
                pamat1Model.setSposobt(rs.getString("sposobt"));
                pamat1Model.setHart(rs.getString("hart"));
                pamat1Model.setKvalt(rs.getString("kvalt"));
                pamat1Model.setMatt(rs.getString("matt"));
                pamat1Model.setInstt((rs.getString("instt")));
                pamat1Model.setOrdt((rs.getString("ordt")));
                pamat1Model.setUdt((rs.getString("udt")));
                pamat1Model.setSt447t((rs.getString("st447t")));
                pamat1Model.setPodsledt(rs.getString("podsledt"));
                pamat1Model.setSrokut(rs.getString("srokut"));
                pamat1Model.setPrigt(rs.getString("prigt"));
                pamat1Model.setInyit((rs.getString("inyit")));


                pamat1Model.setDelo(rs.getInt("delo"));

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


    public ArrayList<Integer> getPamat2UD(int delo) {
        Connection connection = DbConnectUD.getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        ArrayList<Integer> integerArrayList = new ArrayList<Integer>();
        try {
            statement = connection.prepareStatement("select * from pamat2 where delo=?");
            statement.setInt(1, delo);
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
