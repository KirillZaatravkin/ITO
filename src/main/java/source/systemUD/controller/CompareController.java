package source.systemUD.controller;

/**
 * Created by кирюха on 21.12.2018.
 */

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import source.systemUD.model.ParagraphCompare;
import source.systemUD.service.DocService;
import source.systemUD.service.ParseDOCXService;


import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.io.*;
import java.util.List;


@Controller
public class CompareController {
    @Autowired
    private ParseDOCXService parseDOCXService;


    @RequestMapping(value = "/compare", method = RequestMethod.GET)
    public String compare(Model model) {
        return "compare/compare";
    }

    @RequestMapping(value = "/compare", method = {RequestMethod.POST})
    public String handleFileUpload(@RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2, Model model) {

        if (file1 != null && file2 != null) {
            try {
                byte[] f1 = file1.getBytes();
                byte[] f2 = file2.getBytes();
                XWPFDocument docxFile = new XWPFDocument(OPCPackage.open(new ByteArrayInputStream(f1)));
                XWPFDocument docxFile2 = new XWPFDocument(OPCPackage.open(new ByteArrayInputStream(f2)));
                List<ParagraphCompare> paragraphCompares = parseDOCXService.parseCompare(docxFile, docxFile2);
                model.addAttribute("parList", paragraphCompares);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InvalidFormatException e) {
                e.printStackTrace();
            }
        }
        return "compare/compare";
    }

    @RequestMapping(value = "/compareselect", method = {RequestMethod.POST, RequestMethod.GET})
    public String compareSelect(HttpSession session, Model model) {
        String path1 = (String) session.getAttribute("doc1");
        session.setAttribute("doc1", null);
        String path2 = (String) session.getAttribute("doc2");
        session.setAttribute("doc2", null);
        try {

            FileInputStream fs = new FileInputStream(path1);
            FileInputStream fs2 = new FileInputStream(path2);
            XWPFDocument docxFile = new XWPFDocument(fs);
            XWPFDocument docxFile2 = new XWPFDocument(fs2);
            List<ParagraphCompare> paragraphCompares = parseDOCXService.parseCompare(docxFile, docxFile2);
            model.addAttribute("parList", paragraphCompares);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "compare/compareselect";
    }


}