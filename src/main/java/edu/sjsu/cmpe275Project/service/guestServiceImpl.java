package edu.sjsu.cmpe275Project.service;

import edu.sjsu.cmpe275Project.dao.guestDAO;
import edu.sjsu.cmpe275Project.models.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by emy on 11/19/15.
 */
@Service("guestService")
public class guestServiceImpl implements guestService {

    private guestDAO guest;

    @Autowired
    public void setGuest(guestDAO guest) {
        this.guest = guest;
    }

    @Override
    public void create(Long id) {
       // guest.create(id);

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Long id) {

    }

    @Override
    public Guest findById(Long id) {
        return null;
    }
}
