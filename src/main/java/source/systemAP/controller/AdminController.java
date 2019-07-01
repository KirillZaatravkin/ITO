package source.systemAP.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by кирюха on 12.07.2018.
 */

@Controller
public class AdminController {
    @RequestMapping(value = "/admin/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        return "admin/admin";
    }
}
