package edu.sjsu.cmpe275Project.models;

/**
 * Created by emy on 11/15/15.
 */
public class Room implements java.io.Serializable {

    private static final long serialVersionUID = 10L;

    private long id;
    private int roomNumber;
    private String roomType;
    private String roomProperties;
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

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
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
