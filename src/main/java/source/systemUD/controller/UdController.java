package source.systemUD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import source.systemUD.service.*;
import source.systemUD.service.impl.DocServiceImpl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by кирюха on 09.01.2019.
 */
@Controller
public class UdController {

    @Autowired
    private UDService udService;
    @Autowired
    private FolderService folderService;
    @Autowired
    private DocService docService;
    @Autowired
    private SettingService settingService;
    @Autowired
    private Pamat1Service pamat1Service;
    @Autowired
    private Pamat2Service pamat2Service;
    @Autowired
    private ZipService zipService;
    @Autowired
    private PamatService pamatService;




    @RequestMapping(value = "/createud", method = {RequestMethod.POST, RequestMethod.GET})
    public String createUd(Model model, @RequestParam(value = "numberUD", required = false) String numberud) {
        if (numberud != null) {
            udService.createUD(udService.SetUD(numberud));
            folderService.createFolder(numberud);
            return "redirect:/viewall";
        }
        return "ud/create";
    }



    @RequestMapping(value = "/viewall")
    public String viewAll(Model model) {
        model.addAttribute("udsList", udService.getAllUD());
        model.addAttribute("curUser", settingService.getCurUser());
        return "ud/viewall";
    }



    @RequestMapping(value = "/editud", method = {RequestMethod.POST, RequestMethod.GET})
    public String editUd(Model model, @RequestParam(value = "id", required = false) int id) {
        model.addAttribute("sett", udService.getSetting(2).getSettings());
        model.addAttribute("ud", udService.getUD(id));
        model.addAttribute("docList", docService.udDocs(id));
        model.addAttribute("docGroup", docService.docGroup(1));
        model.addAttribute("docGroup2", docService.docGroup(2));
        model.addAttribute("docGroup3", docService.docGroup(3));
        model.addAttribute("docGroup4", docService.docGroup(4));
        model.addAttribute("docGroup5", docService.docGroup(5));
        model.addAttribute("docGroup6", docService.docGroup(6));
        model.addAttribute("docGroup7", docService.docGroup(7));
        model.addAttribute("docGroup8", docService.docGroup(8));
        model.addAttribute("docGroup9", docService.docGroup(9));
        model.addAttribute("docGroup10", docService.docGroup(10));
        model.addAttribute("docGroup11", docService.docGroup(11));
        model.addAttribute("docGroup12", docService.docGroup(12));
        model.addAttribute("docGroup13", docService.docGroup(13));
        model.addAttribute("docGroup14", docService.docGroup(14));
        model.addAttribute("docGroup15", docService.docGroup(15));
        model.addAttribute("docGroup16", docService.docGroup(16));
        model.addAttribute("pamat1", pamat1Service.getPamat1UD(id));
        model.addAttribute("pamat2", pamat2Service.getPamat2UD(id));
        model.addAttribute("pamat3", pamatService.getPamatUD(id,3));


        return "ud/edit";
    }

    @RequestMapping(value = "/createzip",  method = {RequestMethod.POST, RequestMethod.GET})
    public  String  createZip (Model model, @RequestParam(value  = "UD", required = false) int UD) throws IOException {
        zipService.creataZip(UD);
        return "ud/createzip";
    }



    @RequestMapping(value = "/menupamat", method = {RequestMethod.POST, RequestMethod.GET})
    public String menupamat(Model model) {
        return "ud/menupamat";
    }
}
