package source.systemUD.controller;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.FileUtils;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.*;

import java.util.Date;

/**
 * Created by кирюха on 13.01.2019.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import source.systemUD.model.Settings;
import source.systemUD.service.DocService;
import source.systemUD.service.TranslitService;
import source.systemUD.service.UDService;

import javax.servlet.http.HttpSession;

import static jdk.nashorn.internal.objects.NativeString.toUpperCase;


@Controller

public class DocController {

    @Autowired
    private DocService docService;

    @Autowired
    private TranslitService translitService;

    @Autowired
    private UDService udService;

    @RequestMapping(value = "/uploidfile", method = {RequestMethod.GET})
    public String upload(Model model) {
        return "ud/uploidfile";
    }

    @RequestMapping(value = "/uploidfile", method = {RequestMethod.POST})
    public String handleFileUpload(@RequestParam("file") MultipartFile file, @RequestParam("patch") String patch, @RequestParam("type") int type, @RequestParam("udId") int udId) {

        if (!file.isEmpty()) {

            try {

                Date date = new Date();

                byte[] fileBytes = file.getBytes();
                String ps=toUpperCase(translitService.trans(file.getOriginalFilename()));
                String fullPath = patch + "\\" + ps;

                // String rootPath = System.getProperty("catalina.home");

                File newFile = new File(fullPath);
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(newFile));
                stream.write(fileBytes);
                stream.close();


                docService.uploadDoc(fullPath, type, udId, ps);
                System.out.println("File is saved under");

                return "ud/uploidfile";

            } catch (Exception e) {
                e.printStackTrace();
                return "ud/uploidfile";
            }
        } else {
            return "ud/uploidfile";
        }
    }


    @RequestMapping(value = "/filedown", method = {RequestMethod.POST})
    public String dowDoc(@RequestParam("file") String filePath) {


        File source = new File(filePath);
        Settings sett = udService.getSetting(2);
        String setti=sett.getSettings();
        File dest = new File(setti+source.getName());
        try {
            FileUtils.copyFile(source, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ud/filedown";
    }

    @RequestMapping(value = "/selectdoc", method = {RequestMethod.POST})
    public String selectDoc(Model model, @RequestParam("path") String path, HttpSession session) {
        if (session.getAttribute("doc1")==null) {
            session.setAttribute("doc1", path);
        } else{
            session.setAttribute("doc2", path);
            return  "redirect:/compareselect";
        }
        return "ud/selectdoc";
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.POST, RequestMethod.GET})
    public String deleteDoc(Model model, @RequestParam(value = "path", required = false) String path, @RequestParam(value = "id", required = false) int id) {
        boolean result= docService.deleteDoc(path, id);
        return "ud/delete";
    }


}
