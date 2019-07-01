package source.systemUD.model;

/**
 * Created by кирюха on 14.01.2019.
 */
public class Settings {
    String settings, settingname;
    int id;

    public String getSettings ()
    {
        return settings;
    }

    public String getSettingname()
    {
        return settingname;
    }

    public int getId()
    {
        return id;
    }

    public String setSettings(String settings)
    {
        this.settings=settings;
        return settings;
    }

    public String setSetting_name(String setting_name)
    {
        this.settingname =setting_name;
        return setting_name;
    }

    public int setId(int id)
    {
        this.id=id;
        return id;



    }
}
