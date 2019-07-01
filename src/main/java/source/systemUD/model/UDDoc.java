package source.systemUD.model;

import java.sql.Date;

/**
 * Created by кирюха on 13.01.2019.
 */
public class UDDoc {
    private int id;
    private int idGroup;
    private int udId;
    private int type;
    private String path;
    private Date Createdate;
    private String GroupDocTitle;
    private String TypeDocTitle;
    private String originalName;
    private  String owner;
    private boolean docx;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }




    public boolean isDocx() {
        return docx;
    }

    public void setDocx(boolean docx) {
        this.docx = docx;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }

    public String getTypeDocTitle() {
        return TypeDocTitle;
    }

    public void setTypeDocTitle(String typeDocTitle) {
        TypeDocTitle = typeDocTitle;
    }

    public String getGroupDocTitle() {
        return GroupDocTitle;
    }

    public void setGroupDocTitle(String groupDocTitle) {
        GroupDocTitle = groupDocTitle;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUdId() {
        return udId;
    }

    public void setUdId(int udId) {
        this.udId = udId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getCreatedate() {
        return Createdate;
    }

    public void setCreatedate(Date createdate) {
        Createdate = createdate;
    }
}
