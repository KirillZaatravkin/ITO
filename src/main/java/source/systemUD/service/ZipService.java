package source.systemUD.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import source.systemUD.dao.ZipDAO;

import java.io.IOException;

/**
 * Created by кирюха on 13.03.2019.
 */
@Service
public class ZipService {

    @Autowired
    ZipDAO zipDAO;

    public void creataZip(int UD) throws IOException {zipDAO.createZip(UD); }
}
