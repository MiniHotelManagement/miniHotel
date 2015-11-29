package edu.sjsu.cmpe275Project.service;

import edu.sjsu.cmpe275Project.dao.OccupancyDAO;
import edu.sjsu.cmpe275Project.models.Room;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by dexterwei on 11/26/15.
 */
@Transactional
@Service("occupancyservice")
public class occupancyServiceImpl implements occupancyService{
    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    @Override
    public Collection<Room> searchAvlRoom(Date checkinD, Date checkoutD, String roomType, String roomProp) {
        Session session = getSession();
        String hql = "SELECT roomId " +
                "FROM Room " +
                "WHERE NOT EXISTS(" +
                "SELECT room " +
                "FROM Occupancy " +
                "WHERE checkInDate <= \'"+checkinD.toString()+"\' and checkOutDate >= \'" + checkoutD.toString() +"\' and room=room" +
                ")";

        Query query = session.createQuery(hql);
        List results = query.list();
        return results;
    }
}
