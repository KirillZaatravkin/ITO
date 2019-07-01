package source.systemUD.model;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;

/**
 * Created by кирюха on 20.12.2018.
 */
public class ParagraphCompare {
    private XWPFParagraph p;
    private int n;
    private String ps;
    private int k;
    private boolean flagCompare;
    private int pz;

    public int getPz() {
        return pz;
    }

    public void setPz(int pz) {
        this.pz = pz;
    }

    public int getPn() {
        return pn;
    }

    public void setPn(int pn) {
        this.pn = pn;
    }

    private int pn;


    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }


    public int getN() {
        return n;
    }

    public boolean isFlagCompare() {
        return flagCompare;
    }

    public XWPFParagraph getP() {
        return p;
    }

    public void setP(XWPFParagraph p) {
        this.p = p;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setFlagCompare(boolean flagCompare) {
        this.flagCompare = flagCompare;
    }


}
