package source.systemUD.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import source.systemUD.dao.Pamat1DAO;
import source.systemUD.model.Pamat1Model;

import java.util.ArrayList;

/**
 * Created by кирюха on 12.02.2019.
 */
@Service
public class Pamat1Service {
    @Autowired
    private Pamat1DAO pamat1DAO;

    public void addPamat1(Pamat1Model pamat1Model) {
        pamat1DAO.addPamat1(pamat1Model);
    }

    public Pamat1Model setPamat1Model(int face, int st150, int st140, int osnov, int st306, int poruc, int inst776, int ord, int kusp, int prodl, int st144, int stoki, int zayv, int obysnen, int doc, int pismmer, int pismprov, int datavyn, int upk, int st24, int kval, int donos, int smi, int organ, int soglas, int prokuror, int yasno, int osnova, int srokidavn, int otmena, int pervich, int delo, String owner,  String facet, String st150t, String st140t, String osnovt, String st306t, String poruct, String inst776t, String ordt, String kuspt, String prodlt, String st144t, String stokit, String zayvt, String obysnent, String doct, String pismmert, String pismprovt, String datavynt, String upkt, String st24t, String kvalt, String donost, String smit, String organt, String soglast, String prokurort, String yasnot, String osnovat, String srokidavnt, String otmenat, String pervicht) {
        return pamat1DAO.setPamat1Model(face, st150, st140, osnov, st306, poruc, inst776, ord, kusp, prodl, st144, stoki, zayv, obysnen, doc, pismmer, pismprov, datavyn, upk, st24, kval, donos, smi, organ, soglas, prokuror, yasno, osnova, srokidavn, otmena, pervich, delo, owner, facet, st150t, st140t, osnovt, st306t, poruct, inst776t, ordt, kuspt, prodlt, st144t, stokit, zayvt, obysnent, doct, pismmert, pismprovt,datavynt,upkt,st24t, kvalt, donost, smit, organt, soglast, prokurort, yasnot, osnovat, srokidavnt, otmenat, pervicht);

    }

    public Pamat1Model getPamat1 (int id){
        return pamat1DAO.getPamat1(id);
    }

    public ArrayList<Integer> getPamat1UD (int delo){
        return pamat1DAO.getPamat1UD(delo);
    }

}
