package edu.sjsu.cmpe275Project.dao;

import edu.sjsu.cmpe275Project.models.Guest;
import edu.sjsu.cmpe275Project.models.Reservation;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by emy on 11/24/15.
 */
@Repository("reservationdao")
@Transactional
public class reservationDAOImpl implements reservationDAO {

    @Autowired
    private SessionFactory sessionFactory;
    private guestDAO guestdao;

    @Autowired
    public void setRoomdao(guestDAO guestdao) {
        this.guestdao = guestdao;
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    @Override
    public Reservation create(Reservation reservation) {

        Session session = sessionFactory.openSession();
        try {
            Guest guest = reservation.getGuest();
            guestdao.create(guest);
            session.save(reservation);
        }
        catch(HibernateException ex){
            throw new RuntimeException(ex);
        }
        finally{
            if(session!=null) {
                try{
                    session.close();
                }
                catch(HibernateException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }

        return reservation;
    }

    @Override
    public Reservation update(Long Id, Reservation reservation) {

        Reservation newReservation = (Reservation)getSession().get(Reservation.class, Id);
        newReservation.setRoomProperties(reservation.getRoomProperties());
        newReservation.setCheckInDate(reservation.getCheckInDate());
        newReservation.setCheckOutDate(reservation.getCheckOutDate());
        newReservation.setGuest(reservation.getGuest());
        newReservation.setNo_of_rooms(reservation.getNo_of_rooms());
        guestdao.update(reservation.getGuest().getId(), reservation.getGuest());
        getSession().saveOrUpdate(newReservation);
        return newReservation;
    }

    @Override
    public void delete(Long Id) {
        Reservation reservation = findById(Id);
        if(reservation!=null) {
            getSession().delete(reservation);
        }
        else{
            //do nothing...
        }

    }

    @Override
    public Reservation findById(Long Id) {
        Reservation reservation = (Reservation)getSession().get(Reservation.class, Id);
        return reservation;
    }
}
