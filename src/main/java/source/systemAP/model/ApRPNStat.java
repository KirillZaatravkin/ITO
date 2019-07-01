package source.systemAP.model;

import java.util.Date;


public class ApRPNStat {

    String FIO, FacktAddr, Article, Cact;
    Date DateP, DateP2;
    Integer kol;

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public void setKol(Integer kol) {
        this.kol = kol;
    }

    public String getFIO() {

        return FIO;
    }

    public Integer getKol() {
        return kol;
    }

    public void setCact(String Cact) {
        this.Cact = Cact;
    }

    public void setFacktAddr(String FacktAddr) {
        this.FacktAddr = FacktAddr;
    }

    public void setArticle(String Article) {
        this.Article = Article;
    }

    public String getCact() {
        return Cact;
    }

    public void setDateP(Date DateP) {
        this.DateP = DateP;
    }

    public void setDateP2(Date DateZak) {
        this.DateP2 = DateZak;
    }

    public String getFacktAddr() {
        return FacktAddr;
    }

    public String getArticle() {
        return Article;
    }

    public Date getDateP() {
        return DateP;
    }

    public Date getDateP2() {
        return DateP2;
    }
}