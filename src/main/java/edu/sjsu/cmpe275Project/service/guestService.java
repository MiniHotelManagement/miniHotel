package edu.sjsu.cmpe275Project.service;

import edu.sjsu.cmpe275Project.models.Guest;

import java.util.Collection;
import java.util.List;

/**
 * Created by emy on 11/19/15.
 */
public interface guestService {
    Guest create(Guest guest);
    void delete(Long id);
    Guest update(Long id, Guest guest);
    Guest findById(Long id);
    Collection<Guest> findByLicense(String l_id);
}
