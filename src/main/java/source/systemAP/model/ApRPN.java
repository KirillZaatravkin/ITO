package source.systemAP.model;

import java.util.Date;


public class ApRPN {

    String FIO, FacktAddr, Article, Cact;
    Date DateCreate, DateP, DateZak;
    String Nakaz, ProtocolN;

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }
    public String getFIO() {

        return FIO;
    }

    public void setCact(String Cact) {
        this.Cact = Cact;
    }

    public void setFacktAddr(String FacktAddr) {
        this.FacktAddr = FacktAddr;
    }

    public void setDateCreate(Date dateCreate) {
        DateCreate = dateCreate;
    }

    public void setNakaz(String nakaz) {
        Nakaz = nakaz;
    }

    public void setProtocolN(String protocolN) {
        ProtocolN = protocolN;
    }

    public String getNakaz() {
        return Nakaz;
    }

    public String getProtocolN() {
        return ProtocolN;
    }

    public void setArticle(String Article) {
        this.Article = Article;
    }

    public String getCact() {
        return Cact;
    }

    public void setDaterCreate(Date DateCreate) {
        this.DateCreate = DateCreate;
    }

    public void setDateP(Date DateP) {
        this.DateP = DateP;
    }

    public void setDateZak(Date DateZak) {
        this.DateZak = DateZak;
    }

    public String getFacktAddr() {
        return FacktAddr;
    }

    public String getArticle() {
        return Article;
    }

    public Date getDateCreate() {
        return DateCreate;
    }

    public Date getDateP() {
        return DateP;
    }

    public Date getDateZak() {
        return DateZak;
    }
}