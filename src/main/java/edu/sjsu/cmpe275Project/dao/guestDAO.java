package edu.sjsu.cmpe275Project.dao;


import edu.sjsu.cmpe275Project.models.Guest;

/**
 * Created by emy on 11/18/15.
 */

public interface guestDAO {
    public Guest create(Long id);
    public Guest update(Long id);
    public void delete(Long id);
    Guest findById(Long id);
}

