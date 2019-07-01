package source.systemUD.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import source.systemUD.dao.Pamat1DAO;
import source.systemUD.dao.Pamat2DAO;
import source.systemUD.model.Pamat1Model;
import source.systemUD.model.Pamat2Model;

import java.util.ArrayList;

/**
 * Created by кирюха on 12.02.2019.
 */
@Service
public class Pamat2Service {
    @Autowired
    private Pamat2DAO pamat2DAO;

    public void addPamat2(Pamat2Model pamat2Model) {
        pamat2DAO.addPamat2(pamat2Model);
    }

    public Pamat2Model setPamat2Model(int delo, int face, int kusp, int sroki, int datapost, int povod, int upk, int prok, int uved, int st147, int otvod, int prest, int dataprest, int mesto, int sposob, int har, int kval, int mat, int inst, int ord, int ud, int st447, int podsled, int sroku, int prig, int inyi, String facet, String kuspt, String srokit, String datapostt, String povodt, String upkt, String prokt, String uvedt, String st147t, String otvodt, String prestt, String dataprestt, String mestot, String sposobt, String hart, String kvalt, String matt, String instt, String ordt, String udt, String st447t, String podsledt, String srokut, String prigt, String inyit) {
        return pamat2DAO.setPamat2Model(delo, face, kusp, sroki, datapost, povod, upk, prok, uved, st147, otvod, prest, dataprest, mesto, sposob, har, kval, mat, inst, ord, ud, st447, podsled, sroku, prig, inyi, facet, kuspt, srokit, datapostt, povodt, upkt, prokt, uvedt, st147t, otvodt, prestt, dataprestt, mestot, sposobt, hart, kvalt, matt, instt, ordt, udt, st447t, podsledt, srokut, prigt, inyit);

    }

    public Pamat2Model getPamat2(int id) {
        return pamat2DAO.getPamat2(id);
    }

    public ArrayList<Integer> getPamat2UD(int delo) {
        return pamat2DAO.getPamat2UD(delo);
    }

}
