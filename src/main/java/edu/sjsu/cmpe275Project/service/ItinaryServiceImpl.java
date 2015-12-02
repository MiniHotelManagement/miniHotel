package edu.sjsu.cmpe275Project.service;

import edu.sjsu.cmpe275Project.dao.ItinaryDAO;
import edu.sjsu.cmpe275Project.models.Guest;
import edu.sjsu.cmpe275Project.models.Itinary;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

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
        iti.setGuest((Guest) getSession().get(Guest.class, guestId));
        iti.setDiscount(discont);
        iti.setPayment(payment);
        iti.setPaymentDate(payDate);
        itidao.create(iti);
        return iti;
    }

    @Override
    public Itinary createItinary(Itinary i) {
        Itinary iti = new Itinary();
        System.out.println("gestID is "+ i.getGuest().getId());
        iti.setGuest((Guest) getSession().get(Guest.class, i.getGuest().getId()));
        iti.setDiscount(i.getDiscount());
        iti.setPayment(i.getPayment());
        iti.setPaymentDate(i.getPaymentDate());
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
