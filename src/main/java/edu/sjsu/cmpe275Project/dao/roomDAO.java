package edu.sjsu.cmpe275Project.dao;

import edu.sjsu.cmpe275Project.models.Room;

/**
 * Created by emy on 11/19/15.
 */
public interface roomDAO {

    public Room create(Room room);
    public void update(Room room);
    public void delete(Long id);
    Room findById(Long id);
}
