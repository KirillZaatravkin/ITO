package source.systemUD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import source.systemUD.model.Pamat1Model;
import source.systemUD.model.Pamat2Model;
import source.systemUD.model.PamatModel;
import source.systemUD.service.Pamat1Service;
import source.systemUD.service.Pamat2Service;
import source.systemUD.service.PamatService;

/**
 * Created by кирюха on 11.02.2019.
 */

@Controller
public class PamatController {
    @Autowired
    private Pamat1Service pamat1Service;
    @Autowired
    private PamatService pamatService;

    @Autowired
    private Pamat2Service pamat2Service;

    @RequestMapping(value = "/pamat1", method = {RequestMethod.GET})
    public String pamat1(Model model) {
        return "ud/pamat1";
    }

    @RequestMapping(value = "/pamat1", method = {RequestMethod.POST})
    public String pamat1Post(Model model, @RequestParam("face") int face, @RequestParam("st150") int st150, @RequestParam("st140") int st140, @RequestParam("osnov") int osnov, @RequestParam("st306") int st306,
                             @RequestParam("poruc") int poruc, @RequestParam("inst776") int inst776, @RequestParam("ord") int ord, @RequestParam("kusp") int kusp, @RequestParam("prodl") int prodl, @RequestParam("st144") int st144,
                             @RequestParam("sroki") int sroki, @RequestParam("zayv") int zayv, @RequestParam("obysnen") int obysnen, @RequestParam("doc") int doc, @RequestParam("pismmer") int pismmer, @RequestParam("pismprov") int pismprov,
                             @RequestParam("datavyn") int datavyn, @RequestParam("upk") int upk, @RequestParam("st24") int st24, @RequestParam("kval") int kval, @RequestParam("donos") int donos, @RequestParam("smi") int smi,
                             @RequestParam("organ") int organ, @RequestParam("soglas") int soglas, @RequestParam("prokuror") int prokuror, @RequestParam("yasno") int yasno, @RequestParam("osnova") int osnova, @RequestParam("srokidavn") int srokidavn,
                             @RequestParam("otmena") int otmena, @RequestParam("pervich") int pervich, @RequestParam("delo") int delo, @RequestParam("facet") String facet, @RequestParam("st150t") String st150t, @RequestParam("st140t") String st140t, @RequestParam("osnovt") String osnovt, @RequestParam("st306t") String st306t,
                             @RequestParam("poruct") String poruct, @RequestParam("inst776t") String inst776t, @RequestParam("ordt") String ordt, @RequestParam("kuspt") String kuspt, @RequestParam("prodlt") String prodlt, @RequestParam("st144t") String st144t,
                             @RequestParam("srokit") String stokit, @RequestParam("zayvt") String zayvt, @RequestParam("obysnent") String obysnent, @RequestParam("doct") String doct, @RequestParam("pismmert") String pismmert, @RequestParam("pismprovt") String pismprovt,
                             @RequestParam("datavynt") String datavynt, @RequestParam("upkt") String upkt, @RequestParam("st24t") String st24t, @RequestParam("kvalt") String kvalt, @RequestParam("donost") String donost, @RequestParam("smit") String smit,
                             @RequestParam("organt") String organt, @RequestParam("soglast") String soglast, @RequestParam("prokurort") String prokurort, @RequestParam("yasnot") String yasnot, @RequestParam("osnovat") String osnovat, @RequestParam("srokidavnt") String srokidavnt,
                             @RequestParam("otmenat") String otmenat, @RequestParam("pervicht") String pervicht) {


        Pamat1Model pamat1Model = pamat1Service.setPamat1Model(face, st150, st140, osnov, st306, poruc, inst776, ord, kusp, prodl, st144, sroki, zayv, obysnen, doc, pismmer, pismprov, datavyn, upk, st24, kval, donos, smi, organ, soglas, prokuror, yasno, osnova, srokidavn, otmena, pervich, delo, "1", facet, st150t, st140t, osnovt, st306t, poruct, inst776t, ordt, kuspt, prodlt, st144t, stokit, zayvt, obysnent, doct, pismmert, pismprovt, datavynt, upkt, st24t, kvalt, donost, smit, organt, soglast, prokurort, yasnot, osnovat, srokidavnt, otmenat, pervicht);
        pamat1Service.addPamat1(pamat1Model);
        return "redirect:/viewall";
    }

    @RequestMapping(value = "/pamat1view", method = {RequestMethod.GET})
    public String pamat1view(Model model, @RequestParam("id") int id) {

        model.addAttribute("pamat1", pamat1Service.getPamat1(id));
        return "ud/pamat1view";
    }


    @RequestMapping(value = "/pamat2", method = {RequestMethod.GET})
    public String pamat2(Model model) {
        return "ud/pamat2";
    }

    @RequestMapping(value = "/pamat2", method = {RequestMethod.POST})
    public String pamat2Post(Model model, @RequestParam("face") int face, @RequestParam("kusp") int kusp, @RequestParam("sroki") int sroki, @RequestParam("datapost") int datapost, @RequestParam("povod") int povod,
                             @RequestParam("upk") int upk, @RequestParam("prok") int prok, @RequestParam("uved") int uved, @RequestParam("st147") int st147, @RequestParam("otvod") int otvod, @RequestParam("prest") int prest,
                             @RequestParam("dataprest") int dataprest, @RequestParam("mesto") int mesto, @RequestParam("sposob") int sposob, @RequestParam("har") int har, @RequestParam("kval") int kval, @RequestParam("mat") int mat,
                             @RequestParam("inst") int inst, @RequestParam("ord") int ord, @RequestParam("ud") int ud, @RequestParam("st447") int st447, @RequestParam("podsled") int podsled, @RequestParam("sroku") int sroku,
                             @RequestParam("prig") int prig, @RequestParam("inyi") int inyi, @RequestParam("delo") int delo, @RequestParam("facet") String facet, @RequestParam("kuspt") String kuspt, @RequestParam("srokit") String srokit,
                             @RequestParam("datapostt") String datapostt, @RequestParam("povodt") String povodt,
                             @RequestParam("upkt") String upkt, @RequestParam("prokt") String prokt, @RequestParam("uvedt") String uvedt, @RequestParam("st147t") String st147t, @RequestParam("otvodt") String otvodt, @RequestParam("prestt") String prestt,
                             @RequestParam("dataprestt") String dataprestt, @RequestParam("mestot") String mestot, @RequestParam("sposobt") String sposobt, @RequestParam("hart") String hart, @RequestParam("kvalt") String kvalt, @RequestParam("matt") String matt,
                             @RequestParam("instt") String instt, @RequestParam("ordt") String ordt, @RequestParam("udt") String udt, @RequestParam("st447t") String st447t, @RequestParam("podsledt") String podsledt, @RequestParam("srokut") String srokut,
                             @RequestParam("prigt") String prigt, @RequestParam("inyit") String iniyt) {
        Pamat2Model pamat2Model = pamat2Service.setPamat2Model(delo, face, kusp, sroki, datapost, povod, upk, prok, uved, st147, otvod, prest, dataprest, mesto, sposob, har, kval, mat, inst, ord, ud, st447, podsled, sroku, prig, inyi, facet, kuspt, srokit, datapostt, povodt, upkt, prokt, uvedt, st147t, otvodt, prestt, dataprestt, mestot, sposobt, hart, kvalt, matt, instt, ordt, udt, st447t, podsledt, srokut, prigt, iniyt);

        pamat2Service.addPamat2(pamat2Model);
        return "redirect:/viewall";
    }

    @RequestMapping(value = "/pamat2view", method = {RequestMethod.GET})
    public String pamat2view(Model model, @RequestParam("id") int id) {

        model.addAttribute("pamat1", pamat2Service.getPamat2(id));
        return "ud/pamat2view";
    }






    @RequestMapping(value = "/pamat3", method = {RequestMethod.GET})
    public String pamat3(Model model) {
        return "ud/pamat3";
    }

    @RequestMapping(value = "/pamat3", method = {RequestMethod.POST})
    public String pamat3Post(Model model, @RequestParam("delo") int delo, @RequestParam("type") int type, @RequestParam("s1") int s1,@RequestParam("s2") int s2,@RequestParam("s3") int s3,@RequestParam("s4") int s4, @RequestParam("s5") int s5,@RequestParam("s6") int s6,@RequestParam("s7") int s7,
                             @RequestParam("s8") int s8,@RequestParam("s9") int s9,@RequestParam("s10") int s10,@RequestParam("s11") int s11,
                             @RequestParam("s12") int s12, @RequestParam("s13") int s13, @RequestParam("s14") int s14, @RequestParam("s15") int s15,
                             @RequestParam("s16") int s16, @RequestParam("s17") int s17, @RequestParam("s18") int s18, @RequestParam("s19") int s19,
                             @RequestParam("t1") String t1, @RequestParam("t2") String  t2,  @RequestParam("t3") String  t3, @RequestParam("t4") String  t4,
                             @RequestParam("t5") String  t5, @RequestParam("t6") String  t6, @RequestParam("t7") String  t7, @RequestParam("t8") String t8,
                             @RequestParam("t9") String  t9, @RequestParam("t10")String  t10, @RequestParam("t11") String  t11, @RequestParam("t12")String  t12,
                             @RequestParam("t13") String  t13, @RequestParam("t14") String  t14,  @RequestParam("t15") String  t15, @RequestParam("t16") String  t16,
                             @RequestParam("t17") String  t17, @RequestParam("t18") String  t18, @RequestParam("t19") String  t19)

    {


        PamatModel pamatModel = pamatService.setPamatModel(delo,s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16, s17, s18, s19, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, type);
        pamatService.addPamat1(pamatModel);
        return "redirect:/viewall";
    }


    @RequestMapping(value = "/pamat3view", method = {RequestMethod.GET})
    public String pamat3view(Model model, @RequestParam("id") int id) {

        model.addAttribute("pamat3", pamatService.getPamat(id));
        return "ud/pamat3view";
    }



}
