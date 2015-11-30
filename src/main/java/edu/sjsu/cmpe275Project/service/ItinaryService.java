package edu.sjsu.cmpe275Project.service;

import edu.sjsu.cmpe275Project.models.Itinary;
import edu.sjsu.cmpe275Project.models.Room;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.Collection;


/**
 * Created by dexterwei on 11/26/15.
 */
public interface ItinaryService {
    Itinary createItinary( long guestId,
                                    double discont,
                                    double payment,
                                    Date payDate);
    Itinary findItinary( long itiId );
}
