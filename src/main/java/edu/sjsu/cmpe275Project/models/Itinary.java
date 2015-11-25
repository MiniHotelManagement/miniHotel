package edu.sjsu.cmpe275Project.models;



import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * Created by dexterwei on 11/18/15.
 */
@Entity
@Table(name="Itinary")
public class Itinary implements Serializable{
    private static final long serialVersionUID = 20L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ITINARYID", nullable = false)
    private long itinaryID;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="guestId", nullable = false)
    private long guestID;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itinaryID")
    private Collection<Occupation> occupations;

    private double payment;
    private double discount;
    private Date paymentDate;

    public long getItinaryID() {
        return itinaryID;
    }

    public void setItinaryID(long itinaryID) {
        this.itinaryID = itinaryID;
    }

    public long getGuestID() {
        return guestID;
    }

    public void setGuestID(long guestID) {
        this.guestID = guestID;
    }

    public Collection<Occupation> getOccupations() {
        return occupations;
    }

    public void setOccupations(Collection<Occupation> occupations) {
        this.occupations = occupations;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
}
