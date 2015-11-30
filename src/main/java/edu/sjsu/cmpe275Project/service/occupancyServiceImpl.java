package edu.sjsu.cmpe275Project.service;

import edu.sjsu.cmpe275Project.dao.OccupancyDAO;
import edu.sjsu.cmpe275Project.models.Room;
import org.hibernate.*;
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
        String sql = "SELECT * " +
                "FROM Room " +
                "WHERE type LIKE \"" + roomType + "\" AND properties LIKE \"" + roomProp + "\" AND NOT EXISTS(" +
                "SELECT roomId " +
                "FROM Occupancy " +
                "WHERE checkInDate <= \""+checkinD.toString()+"\" and checkOutDate >= \"" + checkoutD.toString() +
                "\" and occupancy.roomNumber=room.roomId" +
                ")";
        System.out.println(sql);
        SQLQuery query = session.createSQLQuery(sql);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List results = query.list();

//        String hql = "SELECT roomId " +
//                "FROM Room " +
//                "WHERE NOT EXISTS(" +
//                "SELECT room " +
//                "FROM Occupancy " +
//                "WHERE checkInDate <= \'"+checkinD.toString()+"\' and checkOutDate >= \'" + checkoutD.toString() +"\' and room=room" +
//                ")";
//
//        Query query = session.createQuery(hql);
//        List results = query.list();
        return results;
    }
}
