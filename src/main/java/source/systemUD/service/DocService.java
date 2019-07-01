package source.systemUD.service;

import source.systemUD.model.DocGroups;
import source.systemUD.model.UDDoc;

import java.util.ArrayList;

/**
 * Created by кирюха on 13.01.2019.
 */
public interface DocService {
    /**
     * gjb iuh kh
     * @param idUD
     * @return
     */
    ArrayList<UDDoc> udDocs(int idUD);
    void uploadDoc(String patch, int type, int udID, String originalName);
    ArrayList <DocGroups> docGroup(int groupID);
    boolean deleteDoc (String path, int id);
}
