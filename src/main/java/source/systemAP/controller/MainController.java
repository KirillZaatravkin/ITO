package source.systemAP.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by кирюха on 26.02.2018.
 */
@Controller
public class MainController {


    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST},value = "/apovd")
    public String apovd (Model model)
    {

        return "ap/apovd";
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST},value= "/aprpn")
    public String aprpn (Model model)
    {

        return "ap/aprpn";
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST},value = "/apovd_old")
    public String apovd_old (Model model)
    {

        return "ap/apovd_old";
    }
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST},value= "/gibdd")
    public String gibdd (Model model)
    {

        return "ap/gibdd";
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST},value = "/prist")
    public String prist (Model model)
    {

        return "ap/prist";
    }

    @RequestMapping(value = "/createword")
    public String createword (Model model)
    {

        return "ap/createword";
    }

    @RequestMapping(value = "/echofilter")
    public String echofilter (Model model)
    {

        return "ap/echofilter";
    }

    @RequestMapping(value = "/findface")
    public String findface (Model model)
    {

        return "ap/findface";
    }

    @RequestMapping(value= "/preloader")
    public String preloader (Model model)
    {

        return "ap/preloader";
    }

    @RequestMapping(value = "/statresediv")
    public String statresediv (Model model)
    {

        return "ap/statresediv";
    }

    @RequestMapping(value = "/resediv")
    public String resediv (Model model)
    {

        return "ap/resediv";
    }

    @RequestMapping(value = "/spisok")
    public String spisok (Model model)
    {

        return "ap/spisok";
    }


    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST},value = "/analiz")
    public String analiz (Model model)
    {

        return "ap/analiz";
    }
}
