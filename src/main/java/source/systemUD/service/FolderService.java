package source.systemUD.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import source.systemUD.model.Settings;
import source.systemUD.dao.SettingsDAO;

import java.io.File;


/**
 * Created by кирюха on 07.01.2019.
 */

@Service
public class FolderService {


    public int createFolder(String numberUd) {
        SettingsDAO settingsDAO = new SettingsDAO();
        Settings sett = settingsDAO.getSetting(1);
        String path = sett.getSettings() + numberUd;
        System.out.println(path);
        File myPath = new File(path);
        myPath.mkdirs();
        return 1;
    }


}
