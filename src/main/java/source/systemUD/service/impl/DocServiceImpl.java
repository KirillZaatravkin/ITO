package source.systemUD.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import source.systemUD.dao.DocDAO;
import source.systemUD.model.DocGroups;
import source.systemUD.model.UDDoc;
import source.systemUD.service.DocService;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by кирюха on 13.01.2019.
 */

@Service
public class DocServiceImpl implements DocService {
    @Autowired
    private DocDAO docDAO;

    public ArrayList<UDDoc> udDocs(int idUD) {
        return docDAO.getUDDoc(idUD);
    }

    public ArrayList<DocGroups> docGroup(int groupID) {
        return docDAO.docGroup(groupID);
    }

    public void uploadDoc(String patch, int type, int udID, String originalName) {
        docDAO.uploadDoc(patch, type, udID, originalName);
    }

    public boolean deleteDoc(String path,int id) {
        File file = new File(path);
        if ( docDAO.delecteDocBD(id))
        {
            System.out.println(" файл удален");
            if (file.delete() )
            {
                System.out.println(" запись удалена");
            }
        } else System.out.println("Файла не обнаружено");
        return file.delete();
    }
}
