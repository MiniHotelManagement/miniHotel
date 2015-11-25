package edu.sjsu.cmpe275Project.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by emy on 11/24/15.
 */
@Entity
@Table(name="reservation")
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="reservationId", nullable = false)
    private long id;

    private String checkInDate;

    private String checkOutDate;

    @Column(name="no_of_rooms")
    private int no_of_rooms;
    private String roomProperties;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="guestId", nullable = false)
    private Guest guest;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="Occupied_rooms", joinColumns = @JoinColumn(name="reservationId"),
    inverseJoinColumns = @JoinColumn(name="roomId"))
    private Collection<Room> roomCollection = new ArrayList<>();

    public Collection<Room> getRoomCollection() {
        return roomCollection;
    }

    public void setRoomCollection(Collection<Room> roomCollection) {
        this.roomCollection = roomCollection;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public int getNo_of_rooms() {
        return no_of_rooms;
    }

    public void setNo_of_rooms(int no_of_rooms) {
        this.no_of_rooms = no_of_rooms;
    }

    public String getRoomProperties() {
        return roomProperties;
    }

    public void setRoomProperties(String roomProperties) {
        this.roomProperties = roomProperties;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }
}
