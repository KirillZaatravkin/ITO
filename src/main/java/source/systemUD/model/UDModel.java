package source.systemUD.model;


import java.sql.Date;

/**
 * Created by кирюха on 07.01.2019.
 */
public class UDModel {
    int id;
    int userId;
    String numberUD;
    Date dataCreate;
    String owner;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getNumberUD() {
        return numberUD;
    }

    public void setNumberUD(String numberUD) {
        this.numberUD = numberUD;
    }

    public Date getDataCreate() {
        return dataCreate;
    }

    public void setDataCreate(Date dataCreate) {
        this.dataCreate = dataCreate;
    }
}
