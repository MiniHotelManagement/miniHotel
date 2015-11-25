package edu.sjsu.cmpe275Project.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by emy on 11/25/15.
 */
@Entity
@Table(name="booking")
public class Booking implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="bookingId", nullable = false)
    private long Id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="Booking_Rooms", joinColumns = @JoinColumn(name="bookingId"),
    inverseJoinColumns = @JoinColumn(name="roomId"))
    private Collection<Room> roomCollection = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="reservationId", nullable = false)
    private Reservation reservation;

//    @Column(name="availability", columnDefinition = "varchar(3) default No")
//    @Enumerated(EnumType.STRING)
//    private Availability availability;

    @Column(name="availability", columnDefinition = "int default 0")
    private int avaliabitiy;

    public int getAvaliabitiy() {
        return avaliabitiy;
    }

    public void setAvaliabitiy(int avaliabitiy) {
        this.avaliabitiy = avaliabitiy;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public Collection<Room> getRoomCollection() {
        return roomCollection;
    }

    public void setRoomCollection(Collection<Room> roomCollection) {
        this.roomCollection = roomCollection;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
