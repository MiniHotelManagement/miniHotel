package edu.sjsu.cmpe275Project.service;

import edu.sjsu.cmpe275Project.dao.guestDAO;
import edu.sjsu.cmpe275Project.models.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by emy on 11/19/15.
 */
@Service("guestservice")
public class guestServiceImpl implements guestService {

    @Autowired
    private guestDAO guestdao;


    @Override
    public Guest create(Guest guest) {
         Guest newGuest = guestdao.create(guest);
         return newGuest;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Guest update(Long id, Guest guest) {
        Guest guest1 = guestdao.update(id, guest);
        return guest1;

    }

    @Override
    public Guest findById(Long id) {
        Guest guest = guestdao.findById(id);
        return guest;
    }
}
