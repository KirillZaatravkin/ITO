package source.systemAP.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import source.systemAP.service.UserService;

/**
 * Created by кирюха on 24.02.2018.
 */
@Controller

public class UserControler
{
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/userssee")
    public String userssee(Model model)
    {
        model.addAttribute("usersList",userService.getAllUsers());
        return "ap/userssee";
    }

    @RequestMapping(value = "/useradd", method = {RequestMethod.POST, RequestMethod.GET})
    public String useradd (Model model, @RequestParam(value="fio",required = false) String fio, @RequestParam(value="logins", required = false) String logins, @RequestParam(value="password", required = false) String password, @RequestParam(value="groups", required = false) String groups)
    {
        if (fio!=null && logins !=null && password!=null && groups!=null) {

            userService.addUser(userService.newUser(password, logins, groups, fio, 0));
            return "redirect:/userssee";       }
        else
            {
            return "ap/useradd";
            }
    }

    @RequestMapping(value = "/userupdate", method = {RequestMethod.POST, RequestMethod.GET})
    public String userupdate (Model model, @RequestParam(value="fio",required = false) String fio, @RequestParam(value="login", required = false) String login, @RequestParam(value="password", required = false) String password, @RequestParam(value="groups", required = false) String groups, @RequestParam(value="id", required = false) String id)
    {
        if (fio!=null && login !=null && password!=null && groups!=null && id!=null) {

            userService.updateUser(userService.newUser(password, login, groups, fio, Integer.parseInt(id)));
            return "redirect:/userssee";       }
        else if (id!=null)
        {   model.addAttribute("fio", userService.getUser(Integer.parseInt(id)).getFio());
            model.addAttribute("login", userService.getUser(Integer.parseInt(id)).getLogin());
            model.addAttribute("password", userService.getUser(Integer.parseInt(id)).getPassword());
            model.addAttribute("groups", userService.getUser(Integer.parseInt(id)).getGroups());
            model.addAttribute("id",id);

            return "ap/userupdate";
        }
        else {
            return "redirect:/useradd";
        }
    }

}
