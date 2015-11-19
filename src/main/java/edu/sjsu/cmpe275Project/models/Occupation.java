package edu.sjsu.cmpe275Project.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * Created by dexterwei on 11/18/15.
 */
public class Occupation implements Serializable {
    private static final long serialVersionUID = 15L;
    private long roomNumber;
    private Collection<Guest> guestsIDs;
    private Date checkInDate;
    private Date checkOutDate;


    public long getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(long roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Collection<Guest> getGuestsIDs() {
        return guestsIDs;
    }

    public void setGuestsIDs(Collection<Guest> guestsIDs) {
        this.guestsIDs = guestsIDs;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }




}
