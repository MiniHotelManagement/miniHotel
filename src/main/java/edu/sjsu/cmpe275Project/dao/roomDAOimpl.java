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
        Session session = sessionFactory.getCurrentSession();
        try{
            //save or update
            session.saveOrUpdate(room);

        }
        catch(HibernateException ex) {
            throw new RuntimeException(ex);
        }

        finally{
            if(session!=null)
                try{

                }
                catch(HibernateException ex) {
                    throw new RuntimeException(ex);
                }
        }
        return room;

    }

    @Override
    public void update(Room room) {
        create(room);

    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Room room = (Room)session.get(Room.class, id);
        if(room!=null)
        {
            session.delete(room);
        }

        try{

        }catch(RuntimeException ex)
        {

            throw ex;
        }

    }

    @Override
    public Room findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Room room;

        try{
            room = (Room) session.get(Room.class, id);

            System.out.println("find the room!");

            if(room == null){
                /*
                throw new RuntimeException(ex);
                */
                System.out.println("cannot find the room ...");
            }
        }catch(RuntimeException ex){

            throw ex;
        }

        return room;

    }
}