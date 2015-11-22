package edu.sjsu.cmpe275Project.dao;

import edu.sjsu.cmpe275Project.models.Room;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by emy on 11/19/15.
 */
@Repository("roomdao")
@Transactional
public class roomDAOimpl implements roomDAO {


    @Override
    public void create(Long id) {

    }

    @Override
    public void update(Long id) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Room findById(Long id) {
        return null;
    }
}
