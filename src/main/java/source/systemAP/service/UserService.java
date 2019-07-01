package source.systemAP.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import source.systemAP.dao.UserDao;
import source.systemAP.model.User;

import java.util.List;

/**
 * Created by кирюха on 24.02.2018.
 */

@Service
public class UserService
{
    @Autowired
    private UserDao userDao;

    public List<User> getAllUsers()
    {
        return userDao.getAllUsers();
    }

    public User getUser(int id)
    {
        return userDao.getUser(id);
    }

    public void addUser (User user)
    {
        userDao.addUser(user);
    }

    public void updateUser(User user)
    {
        userDao.updateUser(user);
    }
    public User newUser (String password, String login, String groups, String fio, int id)
    {
        return  userDao.newUser(password,login,fio,groups,id);
    }

}
