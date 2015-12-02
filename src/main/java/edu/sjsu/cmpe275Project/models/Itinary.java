package edu.sjsu.cmpe275Project.models;



import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

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
    private Guest guest;

//    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    private Collection<Occupancy> occupancies = new ArrayList<Occupancy>();

    private double payment;
    private double discount;
    private Date paymentDate;

    public long getItinaryID() {
        return itinaryID;
    }

    public void setItinaryID(long itinaryID) {
        this.itinaryID = itinaryID;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

//    public Collection<Occupancy> getOccupancies() {
//        return occupancies;
//    }
//
//    public void setOccupancies(Collection<Occupancy> occupancies) {
//        this.occupancies = occupancies;
//    }

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
