package edu.sjsu.cmpe275Project.dao;

import edu.sjsu.cmpe275Project.models.Room;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by emy on 11/19/15.
 */
@Repository("roomdao")
@Transactional
public class roomDAOimpl implements roomDAO {

    @Autowired
    private SessionFactory sessionFactory;



    @Override
    public Room create(Room room) {
        Session session = sessionFactory.openSession();
        try{
            session.save(room);
        }
        catch(HibernateException ex) {
            throw new RuntimeException(ex);
        }

        finally{
            if(session!=null)
                try{
                    session.close();
                }
                catch(HibernateException ex) {
                    throw new RuntimeException(ex);
                }
        }
        return room;

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
