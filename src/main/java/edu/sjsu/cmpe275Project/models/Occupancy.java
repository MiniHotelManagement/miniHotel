package edu.sjsu.cmpe275Project.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by emy on 11/25/15.
 */
@Entity
@Table(name="occupancy")
public class Occupancy implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="occupancyId", nullable = false)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="reservationId", nullable = false)
    private Reservation reservation;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name="Occupancy_Room", joinColumns = @JoinColumn(name="occupancyId"),
//    inverseJoinColumns = @JoinColumn(name="roomId"))
//    private Collection<Room> roomCollection = new ArrayList<>();


    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
