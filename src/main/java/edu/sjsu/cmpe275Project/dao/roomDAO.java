package edu.sjsu.cmpe275Project.dao;

import edu.sjsu.cmpe275Project.models.Room;

/**
 * Created by emy on 11/19/15.
 */
public interface roomDAO {

    Room create(Room room);
    Room update(Long id, Room room);
    void delete(Long id);
    Room findById(Long id);
}
