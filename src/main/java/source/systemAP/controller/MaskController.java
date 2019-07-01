package source.systemAP.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import source.systemAP.service.MaskService;

/**
 * Created by кирюха on 29.03.2018.
 */

@Controller
public class MaskController
{
@Autowired
private MaskService maskService;


@RequestMapping(value="/masksee")
    public String masksee(Model model)
{
    model.addAttribute("maskList", maskService.getAllMask());
    return "ap/masksee";
}

@RequestMapping(value= "/maskadd", method = {RequestMethod.POST, RequestMethod.GET})
    public String maskadd(Model model, @RequestParam(value="mask",required = false) String mask, @RequestParam(value="title", required = false) String title)
    {
        if (mask!=null && title !=null ) {

            maskService.addMask(maskService.newMask(mask, title,0));
            return "redirect:/masksee";       }
        else
        {
            return "ap/maskadd";
        }
}

@RequestMapping(value = "/maskupdate", method = {RequestMethod.POST, RequestMethod.GET})
    public String maskUpdate (Model model, @RequestParam(value="mask",required = false) String mask, @RequestParam(value="title", required = false) String title, @RequestParam(value="id", required = false) String id) {
    if (mask != null && title != null && id != null) {

        maskService.updateMask(maskService.newMask(mask, title, Integer.parseInt(id)));
        return "redirect:/masksee";
    } else if (id != null) {
        model.addAttribute("mask", maskService.getMask(Integer.parseInt(id)).getMask());
        model.addAttribute("title", maskService.getMask(Integer.parseInt(id)).getTitle());
        model.addAttribute("id", id);

        return "ap/maskupdate";
    } else {
        return "redirect:/maskadd";
    }
}
}
