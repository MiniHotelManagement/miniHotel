package edu.sjsu.cmpe275Project.dao;

import edu.sjsu.cmpe275Project.models.Reservation;

/**
 * Created by emy on 11/24/15.
 */
public interface reservationDAO {

    Reservation create(Reservation reservation);
    Reservation update(Long Id, Reservation reservation);
    void delete(Long Id);
    Reservation findById(Long Id);
}
