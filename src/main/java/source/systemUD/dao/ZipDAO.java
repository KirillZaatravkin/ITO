package source.systemUD.dao;

/**
 * Created by кирюха on 13.03.2019.
 */


import org.springframework.stereotype.Repository;
import source.systemUD.model.Settings;
import source.systemUD.model.UDDoc;

import java.io.*;
import java.util.ArrayList;
import java.util.zip.*;

@Repository
public class ZipDAO {


    public void createZip(int UD) throws IOException {

        SettingsDAO settingsDAO= new SettingsDAO();
        Settings settings= settingsDAO.getSetting(1);
        String sett=settings.getSettings();


        ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(sett+"output.zip"));
        DocDAO docDAO = new DocDAO();

        try {
            ArrayList<UDDoc> udDocs = docDAO.getUDDoc(UD);
            for (UDDoc u : udDocs) {
                String patch = u.getPath();
                String title=u.getOriginalName();
                FileInputStream fis = new FileInputStream(patch);
                ZipEntry entry1 = new ZipEntry(title);
                zout.putNextEntry(entry1);
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                zout.write(buffer);
                zout.closeEntry();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            zout.close();
        }

    }
}
