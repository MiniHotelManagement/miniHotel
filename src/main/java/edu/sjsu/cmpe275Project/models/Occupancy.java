package edu.sjsu.cmpe275Project.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * Created by dexterwei on 11/18/15.
 */
public class Occupancy implements Serializable {
    private static final long serialVersionUID = 15L;

    @ManyToOne
    @JoinColumn(name="itinaryID")
    private Itinary itinary;

    @ManyToOne
    @JoinColumn(name = "roomNumber", referencedColumnName = "roomID")
    private Room room;

    @OneToMany
    @JoinColumn(name = "guestIDs")
    private Collection<Guest> guestsIDs;

    private Date checkInDate;
    private Date checkOutDate;

    public Itinary getItinaryID() {
        return itinary;
    }

    public void setItinaryID(Itinary itinary) {
        this.itinary = itinary;
    }

    public Room getRoomNumber() {
        return room;
    }

    public void setRoomNumber(Room room) {
        this.room = room;
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
