package edu.sjsu.cmpe275Project.service;

import edu.sjsu.cmpe275Project.models.Itinary;

import java.sql.Date;


/**
 * Created by dexterwei on 11/26/15.
 */
public interface ItinaryService {
    Itinary createItinary( long guestId,
                                    double discont,
                                    double payment,
                                    Date payDate);
    //Itinary addOccToItinary(long itiId, Occupancy newOcc);

    Itinary findItinary( long itiId );
    Itinary createItinary(Itinary iti);
}
