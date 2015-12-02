package edu.sjsu.cmpe275Project.service;

import edu.sjsu.cmpe275Project.models.Occupancy;
import edu.sjsu.cmpe275Project.models.Room;

import java.util.Collection;

/**
 * Created by yingzhu on 12/1/15.
 */
public interface occupancyService {

    //Collection<Room> searchAvlRoom(Date checkinD, Date checkoutD, String roomType, String roomProp);
    //Occupancy createOccupancy(long guestId, long itiId, long roomId, Date checkInDate, Date checkOutDate);
    Collection<Room> searchAvlRoom(Occupancy o);
    Occupancy createOccupancy(Occupancy occupancy);
    Occupancy findItinary(long occId);
}
