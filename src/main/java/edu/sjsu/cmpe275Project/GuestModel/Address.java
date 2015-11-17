package edu.sjsu.cmpe275Project.GuestModel;

/**
 * Created by emy on 11/15/15.
 */
public class Address implements java.io.Serializable {

    private static final long serialVersionUID = 5L;

    private String street;
    private String city;
    private String zipCode;
    private String state;

    public Address() {}

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
