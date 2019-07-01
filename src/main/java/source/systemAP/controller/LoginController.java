package source.systemAP.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by кирюха on 12.07.2018.
 */
@Controller
public class LoginController {

    private final String ERROR_MESSAGE = "Неправильные имя/пароль";



    @RequestMapping(value = "/login1", method = {RequestMethod.GET})
    public String login1(Model model) {
        return "ap/login1";
    }

    @RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
    public String loginerror(ModelMap model) {
        model.addAttribute("error", ERROR_MESSAGE);
        return "ap/login1";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(Model model) {
        return "ap/login1";
    }



}