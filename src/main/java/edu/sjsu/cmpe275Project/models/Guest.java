package edu.sjsu.cmpe275Project.models;


import javax.persistence.*;

/**
 * Created by emy on 11/15/15.
 */

@Entity
@Table(name="guest")
public class Guest implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="guestId", nullable = false)
    private long id;

    @Column(name="FirstName", nullable = false, length = 20)
    private String firstName;

    @Column(name="LastName", nullable = false, length=20)
    private String lastName;

    @Column(name="email", nullable = false, length=30)
    private String email;

    @Column(name="d_License", nullable = false, length=10)
    private String driversLicense;

    @Embedded
    private Address address;

    public Guest() {}

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDriversLicense() {
        return driversLicense;
    }

    public void setDriversLicense(String driversLicense) {
        this.driversLicense = driversLicense;
    }
}
