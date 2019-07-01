package source.systemAP.model;

import java.util.Date;

/**
 * Created by кирюха on 09.07.2018.
 */
public class ApOVD {

    String LastName, FirstName, MiddleName, FacktAddr, ResAddr, Article, Cact, Organ;
    Date BirthDay, DateCreate, DateP, DateZak, DatePost;
    String PasportS, PasportN, Nakaz, ProtocolN;


    public void setFirstName(String FirstName) {
        this.FirstName = (FirstName);
    }

    public void setCact(String Cact) {
        this.Cact = Cact;
    }

    public void setOrgan(String Organ) {
        this.Organ = Organ;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public void setMiddleName(String MiddleName) {
        this.MiddleName = MiddleName;
    }

    public void setFacktAddr(String FacktAddr) {
        this.FacktAddr = FacktAddr;
    }

    public void setBirthDay(Date birthDay) {
        BirthDay = birthDay;
    }

    public void setDateCreate(Date dateCreate) {
        DateCreate = dateCreate;
    }

    public void setDatePost(Date datePost) {
        DatePost = datePost;
    }

    public void setNakaz(String nakaz) {
        Nakaz = nakaz;
    }

    public void setProtocolN(String protocolN) {
        ProtocolN = protocolN;
    }

    public Date getDatePost() {

        return DatePost;
    }

    public String getNakaz() {
        return Nakaz;
    }

    public String getProtocolN() {
        return ProtocolN;
    }

    public void setResAddr(String ResAddr) {
        this.ResAddr = ResAddr;
    }

    public void setArticle(String Article) {
        this.Article = Article;
    }

    public void setBirthday(Date BirthDay) {
        this.BirthDay = BirthDay;
    }

    public String getPasportS() {
        return PasportS;
    }

    public String getPasportN() {
        return PasportN;
    }

    public String getCact() {
        return Cact;
    }

    public String getOrgan() {
        return Organ;
    }

    public void setPasportS(String pasportS) {
        PasportS = pasportS;
    }

    public void setPasportN(String pasportN) {
        PasportN = pasportN;
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

    public String getResAddr() {
        return ResAddr;
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

    public Date getDateZak() {
        return DateZak;
    }
}