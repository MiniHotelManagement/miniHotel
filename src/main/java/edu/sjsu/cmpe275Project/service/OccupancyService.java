package edu.sjsu.cmpe275Project.service;

import edu.sjsu.cmpe275Project.dao.roomDAO;
import edu.sjsu.cmpe275Project.models.Occupancy;
import edu.sjsu.cmpe275Project.models.Room;

import java.util.Collection;
import java.sql.Date;

/**
 * Created by dexterwei on 11/26/15.
 */
public interface occupancyService {
    Collection<Room> searchAvlRoom(Date checkinD, Date checkoutD, String roomType, String roomProp);

    Occupancy createOccupancy( long guestId,
                           long itiId,
                           long roomId,
                               int numPerson,
                           Date checkInDate,
                            Date checkOutDate
    );
    Occupancy findItinary( long occId );

}
