package edu.sjsu.cmpe275Project.dao;

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
@Repository("occdao")
@Transactional
public class OccupancyDAOImpl implements OccupancyDAO {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Occupancy create(Occupancy occ) {
        Session session = sessionFactory.openSession();
        try{
            session.save(occ);
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
        return occ;
    }

    @Override
    public Occupancy update(Long id, Occupancy occ) throws ResourceNotFoundException{
        Occupancy curr_occ = (Occupancy)getSession().get(Occupancy.class, id);
        if(curr_occ == null){
            throw new ResourceNotFoundException();
        }
        curr_occ.setCheckInDate(occ.getCheckInDate());
        curr_occ.setCheckOutDate(occ.getCheckOutDate());
        curr_occ.setRoomNumber(occ.getRoomNumber());
        curr_occ.setGuestsIDs(occ.getGuestsIDs());
        getSession().saveOrUpdate(curr_occ);
        return curr_occ;
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException{
        Occupancy curr_occ = (Occupancy)getSession().get(Occupancy.class, id);
        if(curr_occ == null){
            throw new ResourceNotFoundException();
        }
        getSession().delete(curr_occ);
    }

    @Override
    public Occupancy findById(Long id) throws ResourceNotFoundException{
        Occupancy curr_occ = (Occupancy)getSession().get(Occupancy.class, id);
        if(curr_occ == null){
            throw new ResourceNotFoundException();
        }
        return curr_occ;
    }
}
