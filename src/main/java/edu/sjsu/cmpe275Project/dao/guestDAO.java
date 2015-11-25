package edu.sjsu.cmpe275Project.dao;


import edu.sjsu.cmpe275Project.models.Guest;

/**
 * Created by emy on 11/18/15.
 */

public interface guestDAO {
    Guest create(Guest guest);
    Guest update(Long id, Guest guest);
    void delete(Long id);
    Guest findById(Long id);
}

