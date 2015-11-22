package edu.sjsu.cmpe275Project.service;

import edu.sjsu.cmpe275Project.models.Guest;

import java.util.List;

/**
 * Created by emy on 11/19/15.
 */
public interface guestService {
    Guest create(Guest guest);
    void delete(Long id);
    void update(Long id);
    Guest findById(Long id);
    //List<Guest> findAll();
}
