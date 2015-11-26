package edu.sjsu.cmpe275Project.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * Created by dexterwei on 11/18/15.
 */


@Entity
@Table(name="Occupancy")
public class Occupancy implements Serializable {
    private static final long serialVersionUID = 15L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="OCCUPANCYID", nullable = false)
    private long occupancyID;


    @ManyToOne
    @JoinColumn(name="itinaryID")
    private Itinary itinary;

    @ManyToOne
    @JoinColumn(name = "roomNumber", referencedColumnName = "roomID")
    private Room room;

    @ManyToMany
    @JoinColumn(name = "guestIDs")
    private Collection<Guest> guestsIDs;

    private Date checkInDate;
    private Date checkOutDate;


    public long getOccupancyID() {
        return occupancyID;
    }

    public Itinary getItinary() {
        return itinary;
    }

    public void setItinary(Itinary itinary) {
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
