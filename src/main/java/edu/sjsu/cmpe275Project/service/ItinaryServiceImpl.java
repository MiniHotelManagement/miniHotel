package edu.sjsu.cmpe275Project.service;

import edu.sjsu.cmpe275Project.dao.ItinaryDAO;
import edu.sjsu.cmpe275Project.dao.roomDAO;
import edu.sjsu.cmpe275Project.models.Guest;
import edu.sjsu.cmpe275Project.models.Itinary;
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
import java.util.Collection;
import java.util.List;

/**
 * Created by dexterwei on 11/26/15.
 */
@Transactional
@Service("itinaryservice")
public class ItinaryServiceImpl implements ItinaryService{
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ItinaryDAO itidao;


    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Itinary createItinary(long guestId, double discont, double payment, Date payDate) {
        Itinary iti = new Itinary();
        iti.setGuestID((Guest)getSession().get(Guest.class,guestId));
        iti.setDiscount(discont);
        iti.setPayment(payment);
        iti.setPaymentDate(payDate);
        itidao.create(iti);
        return iti;
    }

    @Override
    public Itinary findItinary(long itiId) {
        return itidao.findById(itiId);
    }

//    @Override
//    public Itinary addOccToItinary(long itiId, Occupancy newOcc) {
//        Itinary iti = findItinary(itiId);
//        iti.getOccupancies().add(newOcc);
//        itidao.update(itiId,iti);
//        return iti;
//    }
}
