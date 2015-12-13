package edu.sjsu.cmpe275Project.service;

import edu.sjsu.cmpe275Project.dao.roomDAO;
import edu.sjsu.cmpe275Project.models.Occupancy;
import edu.sjsu.cmpe275Project.models.Room;

import java.util.Collection;
import java.sql.Date;
import java.util.List;

/**
 * Created by dexterwei on 11/26/15.
 */
public interface occupancyService {
    public Collection<Room> searchAvlRoom(Occupancy occ);
    public Collection<List<Room>> RoomStatus(Date date);

    public Occupancy createOccupancy(Occupancy occ);
    Occupancy findItinary( long occId );

}
