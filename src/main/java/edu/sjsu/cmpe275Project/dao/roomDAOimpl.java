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

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

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
        /*return room;*/
       /* Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(room);*/
        return room;
    }

    @Override
    public Room update(Long id, Room room) {

        Room room1 = (Room)getSession().get(Room.class, id);
        room1.setRoomNumber(room.getRoomNumber());
        room1.setPrice(room.getPrice());
        room1.setRoomProperties(room.getRoomProperties());
        room1.setRoomType(room.getRoomType());
        getSession().saveOrUpdate(room1);
        return room1;
    }

    @Override
    public void delete(Long id) {
        //Session session = sessionFactory.getCurrentSession();
        Room room = findById(id);
        getSession().delete(room);
    }

    @Override
    public Room findById(Long id) {
        /*Session session = sessionFactory.getCurrentSession();
        Room room = (Room)session.get(Room.class, id);*/
        Room room = (Room)getSession().get(Room.class, id);
        return room;
    }
}
