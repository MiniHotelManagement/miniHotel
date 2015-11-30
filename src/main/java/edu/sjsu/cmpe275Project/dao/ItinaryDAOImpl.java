package edu.sjsu.cmpe275Project.dao;

import edu.sjsu.cmpe275Project.models.Itinary;
import edu.sjsu.cmpe275Project.models.Occupancy;
import edu.sjsu.cmpe275Project.util.ResourceNotFoundException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by dexterwei on 11/25/15.
 */
@Repository("itidao")
@Transactional
public class ItinaryDAOImpl implements ItinaryDAO {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Itinary create(Itinary iti) {
        Session session = sessionFactory.openSession();
        try{
            session.save(iti);
        }
        catch(HibernateException ex) {
            throw new RuntimeException(ex);
        }

        finally{
            if(session!=null)
                try{
                    session.close();
                }
                catch(HibernateException ex) {
                    throw new RuntimeException(ex);
                }
        }
        return iti;
    }

    @Override
    public Itinary update(Long id, Itinary iti) throws ResourceNotFoundException{
        Session session = getSession();
        Itinary curr_iti = (Itinary)session.get(Itinary.class, id);
        if(curr_iti == null){
            throw new ResourceNotFoundException();
        }
        curr_iti.setGuestID(iti.getGuestID());
        curr_iti.setOccupancies(iti.getOccupancies());
        curr_iti.setPayment(iti.getPayment());
        curr_iti.setDiscount(iti.getDiscount());
        curr_iti.setPaymentDate(iti.getPaymentDate());
        session.saveOrUpdate(curr_iti);
        session.close();
        return curr_iti;
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException{
        Itinary curr_iti = (Itinary)getSession().get(Itinary.class, id);
        if(curr_iti == null){
            throw new ResourceNotFoundException();
        }
        getSession().delete(curr_iti);
    }

    @Override
    public Itinary findById(Long id) throws ResourceNotFoundException{
        Itinary curr_iti = (Itinary)getSession().get(Itinary.class, id);
        if(curr_iti == null){
            throw new ResourceNotFoundException();
        }
        return curr_iti;
    }
}
