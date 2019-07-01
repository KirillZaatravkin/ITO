package source.systemAP.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import source.systemAP.service.SettingsService;

/**
 * Created by кирюха on 25.02.2018.
 */
@Controller
public class SettingsController {

    @Autowired
    private SettingsService settingsService;

    @RequestMapping( value = "/settingssee")
    public String settingssee(Model model)
    {
        model.addAttribute( "settingsList",settingsService.getAllSettings());
        return "ap/settingssee";
    }

    @RequestMapping(value = "/settingsupdate", method = {RequestMethod.GET,RequestMethod.POST})
    public String settingsupdate (Model model, @RequestParam(value = "id") int id, @RequestParam(value= "settings", required = false) String settings, @RequestParam(value = "settingname", required = false) String settingname)

    {
        if(settings==null)
        {
            model.addAttribute("setting1",settingsService.getSetting(id));
            return "ap/settingsupdate";
        }
        else if(settings!=null )
        {
            settingsService.updateSettings(settingsService.newSetting(id, settings, settingname));
            return "redirect:/settingssee";
        }
        return "redirect:/settingssee";

    }
}
