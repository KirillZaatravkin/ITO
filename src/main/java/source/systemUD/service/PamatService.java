package source.systemUD.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import source.systemUD.dao.PamatDAO;
import source.systemUD.model.PamatModel;

import java.util.ArrayList;

/**
 *
 */
@Service
public class PamatService {
    @Autowired
    private PamatDAO pamatDAO;

    public void addPamat1(PamatModel pamatModel) {
        pamatDAO.addPamat(pamatModel);
    }

    public PamatModel setPamatModel(int delo, int s1,int s2,int s3,int s4,int s5,int s6,int s7,int s8,int s9,int s10,int s11,int s12,int s13,int s14,int s15,int s16,int s17,int s18,int s19, String t1,String t2,String t3,String t4,String t5,String t6,String t7,String t8,String t9,String t10,String t11,String t12,String t13,String t14,String t15,String t16,String t17,String t18,String t19, int type) {
        return pamatDAO.setPamatModel(delo, s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16, s17, s18, s19, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19,type);

    }

    public PamatModel getPamat (int id){
        return pamatDAO.getPamat(id);
    }

    public ArrayList<Integer> getPamatUD (int delo,int type){
        return pamatDAO.getPamatUD(delo,type);
    }

}
