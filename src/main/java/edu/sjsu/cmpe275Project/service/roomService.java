package edu.sjsu.cmpe275Project.service;

import edu.sjsu.cmpe275Project.models.Room;

/**
 * Created by yingzhu on 11/23/15.
 */

public interface roomService {
    Room create(Room room);
    void delete(Long id);
    void update(Room room);
    Room findById(Long id);

}
