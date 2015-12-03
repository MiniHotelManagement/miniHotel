package edu.sjsu.cmpe275Project.service;

import edu.sjsu.cmpe275Project.dao.OccupancyDAO;
import edu.sjsu.cmpe275Project.models.Occupancy;
import edu.sjsu.cmpe275Project.models.Room;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
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
    public Collection<Room> searchAvlRoom(Occupancy occ) {

        System.out.println("roomType is " +occ.getRoom().getRoomType());
        String roomType = occ.getRoom().getRoomType();
        String roomProp = occ.getRoom().getRoomProperties();
        Date checkinD = occ.getCheckInDate();
        Date checkoutD = occ.getCheckOutDate();

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
        return results;
    }

    @Override
    public Collection<List<Room>> RoomStatus(Date date) {
        ArrayList<List<Room> > rst= new ArrayList<List<Room>>() ;
        Session session = getSession();
        String sql = "SELECT * " +
                "FROM Room " +
                "WHERE NOT EXISTS(" +
                "SELECT roomId " +
                "FROM Occupancy " +
                "WHERE checkInDate <= \""+date.toString()+"\" and checkOutDate > \"" + date.toString() +
                "\" and occupancy.roomNumber=room.roomId" +
                ")";
        SQLQuery query = session.createSQLQuery(sql);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List results = query.list();
        rst.add(results);

        sql = "SELECT * " +
                "FROM Room " +
                "WHERE EXISTS(" +
                "SELECT roomId " +
                "FROM Occupancy " +
                "WHERE checkInDate <= \""+date.toString()+"\" and checkOutDate > \"" + date.toString() +
                "\" and occupancy.roomNumber=room.roomId" +
                ")";
        query = session.createSQLQuery(sql);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List results2 = query.list();
        rst.add(results2);
        return rst;
    }

    @Override
    public Occupancy createOccupancy(Occupancy occ){
        Occupancy new_occ = new Occupancy();
        new_occ.setNunOfPerson(occ.getNunOfPerson());
        new_occ.setRoom(rmService.findById(occ.getRoom().getId()));
        new_occ.setItinary(itiService.findItinary(occ.getItinary().getItinaryID()));
        new_occ.setCheckInDate(occ.getCheckInDate());
        new_occ.setCheckOutDate(occ.getCheckOutDate());
        new_occ.setStatus(occ.getStatus());
        occdao.create(new_occ);
        return new_occ;
    }

    @Override
    public Occupancy findItinary(long occId) {
        Occupancy occ = occdao.findById(occId);
        return occ;
    }
}
