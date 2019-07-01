package source.systemUD.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import source.systemUD.dao.SettingsDAO;
import source.systemUD.dao.UDDAO;
import source.systemUD.model.Settings;
import source.systemUD.model.UDModel;

import java.util.List;

/**
 * Created by кирюха on 07.01.2019.
 */
@Service
public class UDService {
    @Autowired
    private UDDAO udDao;

    @Autowired
    private SettingsDAO sDao;


    public void createUD (UDModel udModel)
    {
        udDao.createUD(udModel);
    }

    public UDModel SetUD (String numberUD)
    {
      return udDao.setUD(numberUD);
    }

    public List<UDModel> getAllUD()
    {
        return udDao.getAllUD();
    }

    public UDModel getUD (int id ){ return  udDao.getUD(id);}

    public   Settings getSetting(int id) {return sDao.getSetting(id);}

}
