package edu.sjsu.cmpe275Project.dao;

import edu.sjsu.cmpe275Project.models.Guest;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by emy on 11/19/15.
 */
@Repository("guestdao")
@Transactional
public class guestDAOimpl implements guestDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Guest update(Long id) {

        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Guest create(Guest guest) {
        Session session = sessionFactory.openSession();
        try{
            session.save(guest);
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
          return guest;
    }

    @Override
    public Guest findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Guest guest = (Guest)session.get(Guest.class, id);
        return guest;
    }
}
