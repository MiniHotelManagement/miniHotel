package edu.sjsu.cmpe275Project.models;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by dexterwei on 11/18/15.
 */


@Entity
@Table(name="Occupancy")
public class Occupancy implements Serializable {
    private static final long serialVersionUID = 15L;

    public Occupancy() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="OCCUPANCYID", nullable = false)
    private long occupancyID;


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="itinaryID")
    private Itinary itinary;

    @ManyToOne
    @JoinColumn(name = "roomNumber", referencedColumnName = "roomID")
    private Room room;

    private int NunOfPerson;


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

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getNunOfPerson() {
        return NunOfPerson;
    }

    public void setNunOfPerson(int nunOfPerson) {
        NunOfPerson = nunOfPerson;
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
