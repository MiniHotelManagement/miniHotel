package edu.sjsu.cmpe275Project.service;

import edu.sjsu.cmpe275Project.dao.guestDAO;
import edu.sjsu.cmpe275Project.models.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by emy on 11/19/15.
 */
@Transactional
@Service("guestservice")
public class guestServiceImpl implements guestService {

    private guestDAO guestdao;

    @Autowired
    public void setGuestdao(guestDAO guestdao) {
        this.guestdao = guestdao;
    }

    @Override
    public Guest create(Guest guest) {
         Guest newGuest = guestdao.create(guest);
         return newGuest;
    }

    @Override
    public void delete(Long id) {
        guestdao.delete(id);

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
