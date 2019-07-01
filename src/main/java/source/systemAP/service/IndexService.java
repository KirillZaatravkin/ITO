package source.systemAP.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import source.systemAP.dao.CurrentDate;

/**
 * Created by кирюха on 23.02.2018.
 */

   @Service
public class IndexService {

    @Autowired
    private CurrentDate currentDate;

    public String CurYear()
    {
        return currentDate.CurYear();
    }

    public String CurMonth()
    {
        return  currentDate.CurMonth();
    }

    public String LastLoad()
    {
        return  currentDate.LastLoad();
    }

}

