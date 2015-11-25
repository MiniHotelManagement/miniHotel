package edu.sjsu.cmpe275Project.service;

import edu.sjsu.cmpe275Project.dao.reservationDAO;
import edu.sjsu.cmpe275Project.models.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by emy on 11/24/15.
 */
@Service("reservationservice")
public class reservationServiceImpl implements reservationService {

    private reservationDAO reservationdao;

    @Autowired
    public void setReservationservice(reservationDAO reservationdao) {
        this.reservationdao = reservationdao;
    }

    @Override
    public Reservation create(Reservation reservation) {
        return reservationdao.create(reservation);
       // return null;
    }

    @Override
    public Reservation update(Long Id, Reservation reservation)
    {
        return reservationdao.update(Id, reservation);
    }

    @Override
    public void delete(Long Id) {
        reservationdao.delete(Id);
    }

    @Override
    public Reservation findById(Long Id) {
        return reservationdao.findById(Id);
    }
}
