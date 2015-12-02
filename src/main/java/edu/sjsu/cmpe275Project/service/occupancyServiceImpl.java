package edu.sjsu.cmpe275Project.service;

import edu.sjsu.cmpe275Project.dao.OccupancyDAO;
import edu.sjsu.cmpe275Project.models.Guest;
import edu.sjsu.cmpe275Project.models.Itinary;
import edu.sjsu.cmpe275Project.models.Occupancy;
import edu.sjsu.cmpe275Project.models.Room;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.sql.Date;
import java.util.List;

/**
 * Created by dexterwei on 11/26/15.
 */
@Transactional
@Service("occupancyservice")
public class occupancyServiceImpl implements occupancyService{
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private guestService gstService;
    @Autowired
    private roomService rmService;
    @Autowired
    private ItinaryService itiService;
    @Autowired
    private OccupancyDAO occdao;

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

    @Override
    public Occupancy createOccupancy(long guestId, long itiId, long roomId, int numPerson, Date checkInDate, Date checkOutDate) {
        Occupancy new_occ = new Occupancy();
        Collection<Guest> gstlst = new ArrayList<Guest>();
        gstlst.add(gstService.findById(guestId));
        new_occ.setNunOfPerson(numPerson);
        new_occ.setRoomNumber(rmService.findById(roomId));
        new_occ.setItinary(itiService.findItinary(itiId));
        new_occ.setCheckInDate(checkInDate);
        new_occ.setCheckOutDate(checkOutDate);
        occdao.create(new_occ);
        //Itinary iti = itiService.findItinary(itiId);
        //iti.getOccupancies().add(new_occ);
        //itiService.addOccToItinary(itiId,new_occ);
        return new_occ;
    }

    @Override
    public Occupancy findItinary(long occId) {
        Occupancy occ = occdao.findById(occId);
        return occ;
    }
}
