package edu.sjsu.cmpe275Project.dao;

import edu.sjsu.cmpe275Project.models.Room;

/**
 * Created by emy on 11/19/15.
 */
public interface roomDAO {

    public void create(Long id);
    public void update(Long id);
    public void delete(Long id);
    Room findById(Long id);
}
