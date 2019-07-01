package source.systemUD.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import source.systemAP.dao.UserDao;

/**
 * Created by кирюха on 07.02.2019.
 */
@Service
public class SettingService {
    @Autowired
    private UserDao userDao;

    public String getCurUser() {return userDao.getCurrentUser();}
}
