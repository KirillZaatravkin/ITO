package source.systemUD.dao;

import org.springframework.stereotype.Repository;
import source.DbConnectUD;
import source.systemUD.model.Pamat1Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by кирюха on 11.02.2019.
 */
@Repository
public class Pamat1DAO {

    public void addPamat1(Pamat1Model pamat1Model) {
        Connection connection = DbConnectUD.getConnection();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("insert into pamat1 (face, st150, st140, osnov, st306, poruc, inst776, ord, kusp, prodl, st144, sroki, zayv, obysnen, doc, pismmer, pismprov, datavyn,upk,st24, kval, donos, smi, organ, soglas, prokuror, yasno, osnova, srokidavn, otmena, pervich,delo, owners,facet, st150t, st140t, osnovt, st306t, poruct, inst776t, ordt, kuspt, prodlt, st144t, srokit, zayvt, obysnent, doct, pismmert, pismprovt,datavynt,upkt,st24t, kvalt, donost, smit, organt, soglast, prokurort, yasnot, osnovat, srokidavnt, otmenat, pervicht) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, pamat1Model.getFace());
            ps.setInt(2, pamat1Model.getSt150());
            ps.setInt(3, pamat1Model.getSt140());
            ps.setInt(4, pamat1Model.getOsnov());
            ps.setInt(5, pamat1Model.getSt306());
            ps.setInt(6, pamat1Model.getPoruc());
            ps.setInt(7, pamat1Model.getInst776());
            ps.setInt(8, pamat1Model.getOrd());
            ps.setInt(9, pamat1Model.getKusp());
            ps.setInt(10, pamat1Model.getProdl());
            ps.setInt(11, pamat1Model.getSt144());
            ps.setInt(12, pamat1Model.getStoki());
            ps.setInt(13, pamat1Model.getZayv());
            ps.setInt(14, pamat1Model.getObysnen());
            ps.setInt(15, pamat1Model.getDoc());
            ps.setInt(16, pamat1Model.getPismmer());
            ps.setInt(17, pamat1Model.getPismprov());
            ps.setInt(18, pamat1Model.getDatavyn());
            ps.setInt(19, pamat1Model.getUpk());
            ps.setInt(20, pamat1Model.getSt24());
            ps.setInt(21, pamat1Model.getKval());
            ps.setInt(22, pamat1Model.getDonos());
            ps.setInt(23, pamat1Model.getSmi());
            ps.setInt(24, pamat1Model.getOrgan());
            ps.setInt(25, pamat1Model.getSoglas());
            ps.setInt(26, pamat1Model.getProkuror());
            ps.setInt(27, pamat1Model.getYasno());
            ps.setInt(28, pamat1Model.getOsnova());
            ps.setInt(29, pamat1Model.getSrokidavn());
            ps.setInt(30, pamat1Model.getOtmena());
            ps.setInt(31, pamat1Model.getPervich());
            ps.setInt(32, pamat1Model.getDelo());
            ps.setString(33, pamat1Model.getOwner());
            ps.setString(34, pamat1Model.getFacet());
            ps.setString(35, pamat1Model.getSt150t());
            ps.setString(36, pamat1Model.getSt140t());
            ps.setString(37, pamat1Model.getOsnovt());
            ps.setString(38, pamat1Model.getSt306t());
            ps.setString(39, pamat1Model.getPoruct());
            ps.setString(40, pamat1Model.getInst776t());
            ps.setString(41, pamat1Model.getOrdt());
            ps.setString(42, pamat1Model.getKuspt());
            ps.setString(43, pamat1Model.getProdlt());
            ps.setString(44, pamat1Model.getSt144t());
            ps.setString(45, pamat1Model.getStokit());
            ps.setString(46, pamat1Model.getZayvt());
            ps.setString(47, pamat1Model.getObysnent());
            ps.setString(48, pamat1Model.getDoct());
            ps.setString(49, pamat1Model.getPismmert());
            ps.setString(50, pamat1Model.getPismprovt());
            ps.setString(51, pamat1Model.getDatavynt());
            ps.setString(52, pamat1Model.getUpkt());
            ps.setString(53, pamat1Model.getSt24t());
            ps.setString(54, pamat1Model.getKvalt());
            ps.setString(55, pamat1Model.getDonost());
            ps.setString(56, pamat1Model.getSmit());
            ps.setString(57, pamat1Model.getOrgant());
            ps.setString(58, pamat1Model.getSoglast());
            ps.setString(59, pamat1Model.getProkurort());
            ps.setString(60, pamat1Model.getYasnot());
            ps.setString(61, pamat1Model.getOsnovat());
            ps.setString(62, pamat1Model.getSrokidavnt());
            ps.setString(63, pamat1Model.getOtmenat());
            ps.setString(64, pamat1Model.getPervicht());
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


    public Pamat1Model setPamat1Model( int face, int st150, int st140, int osnov, int st306, int poruc, int inst776, int ord, int kusp, int prodl, int st144, int stoki, int zayv, int obysnen, int doc, int pismmer, int pismprov, int datavyn, int upk, int st24, int kval, int donos, int smi, int organ, int soglas, int prokuror, int yasno, int osnova, int srokidavn, int otmena, int pervich, int delo, String owner, String facet, String st150t, String st140t, String osnovt, String st306t, String poruct, String inst776t, String ordt, String kuspt, String prodlt, String st144t, String stokit, String zayvt, String obysnent, String doct, String pismmert, String pismprovt, String datavynt, String upkt, String st24t, String kvalt, String donost, String smit, String organt, String soglast, String prokurort, String yasnot, String osnovat, String srokidavnt, String otmenat, String pervicht) {

        Pamat1Model pamat1Model =new Pamat1Model();
        pamat1Model.setFace(face);
        pamat1Model.setSt150(st150);
        pamat1Model.setSt140(st140);
        pamat1Model.setOsnov(osnov);
        pamat1Model.setSt306(st306);
        pamat1Model.setPoruc(poruc);
        pamat1Model.setInst776(inst776);
        pamat1Model.setOrd(ord);
        pamat1Model.setKusp(kusp);
        pamat1Model.setProdl(prodl);
        pamat1Model.setSt144(st144);
        pamat1Model.setStoki(stoki);
        pamat1Model.setZayv(zayv);
        pamat1Model.setObysnen(obysnen);
        pamat1Model.setDoc(doc);
        pamat1Model.setPismmer(pismmer);
        pamat1Model.setPismprov(pismprov);
        pamat1Model.setDatavyn(datavyn);
        pamat1Model.setUpk(upk);
        pamat1Model.setSt24(st24);
        pamat1Model.setKval(kval);
        pamat1Model.setDonos(donos);
        pamat1Model.setSmi(smi);
        pamat1Model.setOrgan(organ);
        pamat1Model.setSoglas(soglas);
        pamat1Model.setProkuror(prokuror);
        pamat1Model.setYasno(yasno);
        pamat1Model.setOsnova(osnova);
        pamat1Model.setSrokidavn(srokidavn);
        pamat1Model.setOtmena(otmena);
        pamat1Model.setPervich(pervich);
        pamat1Model.setDelo(delo);
        pamat1Model.setOwner(owner);

        pamat1Model.setFacet(facet);
        pamat1Model.setSt150t(st150t);
        pamat1Model.setSt140t(st140t);
        pamat1Model.setOsnovt(osnovt);
        pamat1Model.setSt306t(st306t);
        pamat1Model.setPoruct(poruct);
        pamat1Model.setInst776t(inst776t);
        pamat1Model.setOrdt(ordt);
        pamat1Model.setKuspt(kuspt);
        pamat1Model.setProdlt(prodlt);
        pamat1Model.setSt144t(st144t);
        pamat1Model.setStokit(stokit);
        pamat1Model.setZayvt(zayvt);
        pamat1Model.setObysnent(obysnent);
        pamat1Model.setDoct(doct);
        pamat1Model.setPismmert(pismmert);
        pamat1Model.setPismprovt(pismprovt);
        pamat1Model.setDatavynt(datavynt);
        pamat1Model.setUpkt(upkt);
        pamat1Model.setSt24t(st24t);
        pamat1Model.setKvalt(kvalt);
        pamat1Model.setDonost(donost);
        pamat1Model.setSmit(smit);
        pamat1Model.setOrgant(organt);
        pamat1Model.setSoglast(soglast);
        pamat1Model.setProkurort(prokurort);
        pamat1Model.setYasnot(yasnot);
        pamat1Model.setOsnovat(osnovat);
        pamat1Model.setSrokidavnt(srokidavnt);
        pamat1Model.setOtmenat(otmenat);
        pamat1Model.setPervicht(pervicht);

        return pamat1Model;
    }


    public Pamat1Model getPamat1(int id) {
        Connection connection = DbConnectUD.getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        Pamat1Model pamat1Model = new Pamat1Model();
        try {
            statement = connection.prepareStatement("select * from pamat1 where id=? limit 1");
            statement.setInt(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                pamat1Model.setFace(rs.getInt("face"));
                pamat1Model.setSt150(rs.getInt("st150"));
                pamat1Model.setSt140(rs.getInt("st140"));
                pamat1Model.setOsnov(rs.getInt("osnov"));
                pamat1Model.setSt306(rs.getInt("st306"));
                pamat1Model.setPoruc(rs.getInt("poruc"));
                pamat1Model.setInst776(rs.getInt("inst776"));
                pamat1Model.setOrd(rs.getInt("ord"));
                pamat1Model.setKusp(rs.getInt("kusp"));
                pamat1Model.setProdl(rs.getInt("prodl"));
                pamat1Model.setSt144(rs.getInt("st144"));
                pamat1Model.setStoki(rs.getInt("sroki"));
                pamat1Model.setZayv(rs.getInt("zayv"));
                pamat1Model.setObysnen(rs.getInt("obysnen"));
                pamat1Model.setDoc(rs.getInt("doc"));
                pamat1Model.setPismmer(rs.getInt("pismmer"));
                pamat1Model.setPismprov(rs.getInt("pismprov"));
                pamat1Model.setDatavyn(rs.getInt("datavyn"));
                pamat1Model.setUpk(rs.getInt("upk"));
                pamat1Model.setSt24(rs.getInt("st24"));
                pamat1Model.setKval(rs.getInt("kval"));
                pamat1Model.setDonos(rs.getInt("donos"));
                pamat1Model.setSmi(rs.getInt("smi"));
                pamat1Model.setOrgan(rs.getInt("organ"));
                pamat1Model.setSoglas(rs.getInt("soglas"));
                pamat1Model.setProkuror(rs.getInt("prokuror"));
                pamat1Model.setYasno(rs.getInt("yasno"));
                pamat1Model.setOsnova(rs.getInt("osnova"));
                pamat1Model.setSrokidavn(rs.getInt("srokidavn"));
                pamat1Model.setOtmena(rs.getInt("otmena"));
                pamat1Model.setPervich(rs.getInt("pervich"));
                pamat1Model.setFacet(rs.getString("facet"));
                pamat1Model.setSt150t(rs.getString("st150t"));
                pamat1Model.setSt140t(rs.getString("st140t"));
                pamat1Model.setOsnovt(rs.getString("osnovt"));
                pamat1Model.setSt306t(rs.getString("st306t"));
                pamat1Model.setPoruct(rs.getString("poruct"));
                pamat1Model.setInst776t(rs.getString("inst776t"));
                pamat1Model.setOrdt(rs.getString("ordt"));
                pamat1Model.setKuspt(rs.getString("kuspt"));
                pamat1Model.setProdlt(rs.getString("prodlt"));
                pamat1Model.setSt144t(rs.getString("st144t"));
                pamat1Model.setStokit(rs.getString("srokit"));
                pamat1Model.setZayvt(rs.getString("zayvt"));
                pamat1Model.setObysnent(rs.getString("obysnent"));
                pamat1Model.setDoct(rs.getString("doct"));
                pamat1Model.setPismmert(rs.getString("pismmert"));
                pamat1Model.setPismprovt(rs.getString("pismprovt"));
                pamat1Model.setDatavynt(rs.getString("datavynt"));
                pamat1Model.setUpkt(rs.getString("upkt"));
                pamat1Model.setSt24t(rs.getString("st24t"));
                pamat1Model.setKvalt(rs.getString("kvalt"));
                pamat1Model.setDonost(rs.getString("donost"));
                pamat1Model.setSmit(rs.getString("smit"));
                pamat1Model.setOrgant(rs.getString("organt"));
                pamat1Model.setSoglast(rs.getString("soglast"));
                pamat1Model.setProkurort(rs.getString("prokurort"));
                pamat1Model.setYasnot(rs.getString("yasnot"));
                pamat1Model.setOsnovat(rs.getString("osnovat"));
                pamat1Model.setSrokidavnt(rs.getString("srokidavnt"));
                pamat1Model.setOtmenat(rs.getString("otmenat"));
                pamat1Model.setPervicht(rs.getString("pervicht"));
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



    public  ArrayList<Integer> getPamat1UD(int delo) {
        Connection connection = DbConnectUD.getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        ArrayList<Integer> integerArrayList =new ArrayList<Integer>();
        try {
            statement = connection.prepareStatement("select * from pamat1 where delo=?");
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
