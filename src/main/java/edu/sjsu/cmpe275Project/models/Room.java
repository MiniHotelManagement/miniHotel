package edu.sjsu.cmpe275Project.models;

import javax.persistence.*;

/**
 * Created by emy on 11/15/15.
 */
@Entity
@Table(name="room")
public class Room implements java.io.Serializable {

    private static final long serialVersionUID = 10L;

    @Id
    @GeneratedValue
    private long id;
    @Column(name="roomNumber", length = 4, nullable = false) //room number with max length of 4 digits
    private String roomNumber;
    @Column(name="type", nullable = false, length=10) //queen or king
    private String roomType;
    @Column(name="properties", nullable = false, length=15) //smoking or non-smoking
    private String roomProperties;
    @Column(name="price", columnDefinition = "DECIMAL(10,2)", nullable = false) //sets the precision of price to 2 decimal places
    private double price;

    public Room() {}

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomProperties() {
        return roomProperties;
    }

    public void setRoomProperties(String roomProperties) {
        this.roomProperties = roomProperties;
    }
}
