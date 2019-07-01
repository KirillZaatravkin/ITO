package source.systemAP.model;

import java.util.Date;

/**
 * Created by кирюха on 17.05.2018.
 */
public class ApGIBDD {
    String LastName, FirstName, MiddleName, FacktAddr, Article, Cact, ProtokolN, Nakaz;
    Date BirthDay, DateCreate, DateP, DatePost,DateZak;
    String VodUd;


    public void setFirstName(String FirstName) {
        this.FirstName = (FirstName);
    }

    public void setCact(String Cact) {
        this.Cact = Cact;
    }

    public void setNakaz(String Nakaz) {
        this.Nakaz = Nakaz;
    }


    public void setVodUd(String VodUd) {   this.VodUd = VodUd; }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public void setProtokolN(String ProtokolN) {
        this.ProtokolN = ProtokolN;
    }

    public void setMiddleName(String MiddleName) {
        this.MiddleName = MiddleName;
    }

    public void setFacktAddr(String FacktAddr) {
        this.FacktAddr = FacktAddr;
    }

    public void setArticle(String Article) {
        this.Article = Article;
    }

    public void setBirthday(Date BirthDay) {
        this.BirthDay = BirthDay;
    }

    public void setDateZak(Date DateZak) {
        this.DateZak = DateZak;
    }

    public void setDatePost(Date DatePost) {
        this.DatePost = DatePost;
    }

    public String getVodUd() {
        return VodUd;
    }

    public String getCact() {
        return Cact;
    }

    public String getNakaz() {
        return Nakaz;
    }

    public String getProtokolN() { return ProtokolN;
    }


    public void setDaterCreate(Date DateCreate) {
        this.DateCreate = DateCreate;
    }

    public void setDateP(Date DateP) {
        this.DateP = DateP;
    }

    public String getLastName() {
        return LastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public String getFacktAddr() {
        return FacktAddr;
    }

    public String getArticle() {
        return Article;
    }

    public Date getBirthDay() {
        return BirthDay;
    }

    public Date getDateCreate() {
        return DateCreate;
    }

    public Date getDateP() {
        return DateP;
    }

    public Date getDatePost() {
        return DatePost;
    }

    public Date getDateZak() {
        return DateZak;
    }
}
