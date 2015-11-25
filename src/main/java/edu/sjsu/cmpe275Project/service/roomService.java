package edu.sjsu.cmpe275Project.service;

import edu.sjsu.cmpe275Project.models.Room;

/**
 * Created by emy on 11/23/15.
 */
public interface roomService {

    Room create(Room room);
    Room update(Long id, Room room);
    void delete(Long id);
    Room findById(Long id);

}
