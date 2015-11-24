package edu.sjsu.cmpe275Project.dao;


import edu.sjsu.cmpe275Project.models.Guest;

/**
 * Created by emy on 11/18/15.
 */

public interface guestDAO {
    public Guest create(Guest guest);
    public Guest update(Long id, Guest guest);
    public void delete(Long id);
    Guest findById(Long id);
}

