package source.systemUD.service;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.springframework.stereotype.Service;
import source.systemUD.model.ParagraphCompare;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ParseDOCXService {

    public List<ParagraphCompare> parseCompare(XWPFDocument docxFile, XWPFDocument docxFile2) {

        List<ParagraphCompare> paragraphCompares = new ArrayList<ParagraphCompare>();
        try {

            int i = 0;

            //разбивка на абзацы
            List<XWPFParagraph> paragraphs1 = docxFile.getParagraphs();
            List<ParagraphCompare> paragrap1 = new ArrayList<ParagraphCompare>();
            for (XWPFParagraph p : paragraphs1) {
                ParagraphCompare pc1 = new ParagraphCompare();
                pc1.setN(i);
                pc1.setPs(p.getText());
                pc1.setK(1);
                pc1.setFlagCompare(false);
                paragrap1.add(pc1);
                i++;
            }

            List<XWPFParagraph> paragraphs2 = docxFile2.getParagraphs();
            List<ParagraphCompare> paragrap2 = new ArrayList<ParagraphCompare>();
            i = 0;
            for (XWPFParagraph p2 : paragraphs2) {
                ParagraphCompare pc2 = new ParagraphCompare();
                pc2.setN(i);
                pc2.setPs(p2.getText());
                pc2.setK(2);
                pc2.setFlagCompare(false);
                paragrap2.add(pc2);
                i++;
            }

            for (ParagraphCompare p1 : paragrap1) {
                for (ParagraphCompare p2 : paragrap2) {
                    if (p1.getPs().equals(p2.getPs())) {
                        p1.setFlagCompare(true);
                        p2.setFlagCompare(true);

                    }
                }
            }


            for (ParagraphCompare p1 : paragrap2) {
                for (ParagraphCompare p2 : paragrap1) {
                    if (p1.getPs().equals(p2.getPs())) {
                        p1.setFlagCompare(true);
                        p2.setFlagCompare(true);
                        System.out.println(p1.getPs());

                    }
                }
            }

            //разбивка на предлжодения
            String[] strings;
            List<ParagraphCompare> paragrap1Temp = new ArrayList<ParagraphCompare>();
            for (ParagraphCompare aParagrap1 : paragrap1) {
                int p = aParagrap1.getN();
                strings = aParagrap1.getPs().split("(?<=[а-я])\\.\\s+");
                int h = 0;
                for (String string : strings) {
                    ParagraphCompare pc1 = new ParagraphCompare();
                    pc1.setN(p);//номер абзаца
                    pc1.setPn(h);// номер предложения
                    pc1.setPs(string + ".");
                    pc1.setK(1);
                    if (aParagrap1.isFlagCompare()) {
                        pc1.setFlagCompare(true);
                    } else {
                        pc1.setFlagCompare(false);
                    }
                    paragrap1Temp.add(pc1);
                    h++;
                }
            }

            String[] strings2;
            List<ParagraphCompare> paragrap2Temp = new ArrayList<ParagraphCompare>();
            for (ParagraphCompare aParagrap2 : paragrap2) {
                int d = aParagrap2.getN();
                strings2 = aParagrap2.getPs().split("(?<=[а-я])\\.\\s+");
                int j = 0;
                for (String aStrings2 : strings2) {
                    ParagraphCompare pc2 = new ParagraphCompare();
                    pc2.setN(d);
                    pc2.setPn(j);
                    pc2.setPs(aStrings2 + ".");
                    pc2.setK(2);
                    if (aParagrap2.isFlagCompare()) {
                        pc2.setFlagCompare(true);
                    } else {
                        pc2.setFlagCompare(false);
                    }
                    paragrap2Temp.add(pc2);
                    j++;
                }
            }

            //сравнить предложения3
            System.out.println("*********************");
            for (ParagraphCompare p1 : paragrap1Temp) {
                if (!p1.isFlagCompare()) {
                    for (ParagraphCompare p2 : paragrap2Temp) {
                        if (!p2.isFlagCompare()) {
                            if (p1.getPs().equals(p2.getPs())) {
                                p1.setFlagCompare(true);
                                p2.setFlagCompare(true);
                                System.out.println(p1.getPs());
                            }
                        }
                    }
                }
            }
            for (ParagraphCompare p2 : paragrap2Temp) {
                if (!p2.isFlagCompare()) {
                    for (ParagraphCompare p1 : paragrap1Temp) {
                        if (!p1.isFlagCompare()) {
                            if (p1.getPs().equals(p2.getPs())) {
                                p1.setFlagCompare(true);
                                p2.setFlagCompare(true);
                            }
                        }
                    }
                }
            }

/*
                //разбивкуа на запятыt
                String[] stringZap;
                List<ParagraphCompare> paragrapZap = new ArrayList<ParagraphCompare>();
                for (ParagraphCompare aParagrap1 : paragrap1Temp) {
                    stringZap = aParagrap1.getPs().split("(?<=[а-я])\\,\\s+");
                    int pn = aParagrap1.getPn();
                    for (String string : stringZap) {
                        ParagraphCompare pcZap = new ParagraphCompare();
                        pcZap.setPn(pn);
                        pcZap.setPs(string + ",");
                        pcZap.setPs(pcZap.getPs().replace(".,", ""));
                        pcZap.setK(1);
                        if(aParagrap1.isFlagCompare())
                        {
                            pcZap.setFlagCompare(true);
                        }
                        else
                        {
                            pcZap.setFlagCompare(false);
                        }
                        paragrapZap.add(pcZap);
                    }
                }

                String[] stringZap2;
                List<ParagraphCompare> paragrapZap2 = new ArrayList<ParagraphCompare>();
                for (ParagraphCompare aParagrap1 : paragrap2Temp) {
                    stringZap2 = aParagrap1.getPs().split("(?<=[а-я])\\,\\s+");
                    int pn = aParagrap1.getPn();
                    for (String string : stringZap2) {
                        ParagraphCompare pcZap = new ParagraphCompare();
                        pcZap.setPn(pn);
                        pcZap.setPs(string + ",");
                        pcZap.setPs(pcZap.getPs().replace(".,", ""));
                        pcZap.setK(2);
                        if(aParagrap1.isFlagCompare())
                        {
                            pcZap.setFlagCompare(true);
                        }
                        else
                        {
                            pcZap.setFlagCompare(false);
                        }

                        paragrapZap2.add(pcZap);
                    }

                }

                System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                for (ParagraphCompare aParagrap1Temp : paragrapZap) {
                    if (!aParagrap1Temp.isFlagCompare()) {
                        for (ParagraphCompare aParagrap2Temp : paragrapZap2) {
                            if (!aParagrap2Temp.isFlagCompare()) {
                                if (aParagrap1Temp.getPs().equals(aParagrap2Temp.getPs()))
                                {
                                    aParagrap1Temp.setFlagCompare(true);
                                    aParagrap2Temp.setFlagCompare(true);
                                    System.out.println(aParagrap1Temp.getPs());
                                }
                            }
                        }
                    }
                }
            for (ParagraphCompare aParagrap1Temp : paragrapZap2) {
                if (!aParagrap1Temp.isFlagCompare()) {
                    for (ParagraphCompare aParagrap2Temp : paragrapZap) {
                        if (!aParagrap2Temp.isFlagCompare()) {
                            if (aParagrap1Temp.getPs().equals(aParagrap2Temp.getPs()))
                            {
                                aParagrap1Temp.setFlagCompare(true);
                                aParagrap2Temp.setFlagCompare(true);
                            }
                        }
                    }
                }
            }
            */

            paragraphCompares.addAll(paragrap2Temp);
            paragraphCompares.addAll(paragrap1Temp);

            //     paragraphCompares.addAll(paragrap1);
            //   paragraphCompares.addAll(paragrap2);
        } catch (
                Exception e)

        {
            e.printStackTrace();
        }

        return paragraphCompares;
    }

}
