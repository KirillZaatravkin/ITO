package source.systemAP.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import source.systemAP.service.IndexService;

/**
 * Created by кирюха on 23.02.2018.
 */
@Controller
public class IndexController {

    @Autowired
    private IndexService indexService;

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "/header")
    public String header(Model model) {
        return "ap/header";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/index")
    public String indexmenu(Model model) {

        return "/index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String index5(Model model) {

        return "/index";
    }
}
