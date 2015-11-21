package edu.sjsu.cmpe275Project.dao;

import edu.sjsu.cmpe275Project.models.Guest;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by emy on 11/19/15.
 */
@Repository("guestDAO")
@Transactional
public class guestDAOimpl implements guestDAO {

    @Override
    public Guest update(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Guest create(Long id) {
        return null;
    }

    @Override
    public Guest findById(Long id) {
        return null;
    }
}
