package edu.sjsu.cmpe275Project.service;

import edu.sjsu.cmpe275Project.dao.guestDAO;
import edu.sjsu.cmpe275Project.models.Guest;
import edu.sjsu.cmpe275Project.util.ResourceNotFoundException;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * Created by emy on 11/19/15.
 */
@Transactional
@Service("guestservice")
public class guestServiceImpl implements guestService {

    private guestDAO guestdao;

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    public void setGuestdao(guestDAO guestdao) {
        this.guestdao = guestdao;
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }



    @Override
    public Guest create(Guest guest) {
         Guest newGuest = guestdao.create(guest);
         return newGuest;
    }

    @Override
    public void delete(Long id) {
        guestdao.delete(id);

    }

    @Override
    public Guest update(Long id, Guest guest) {
        Guest guest1 = guestdao.update(id, guest);
        return guest1;

    }

    @Override
    public Guest findById(Long id) {
        Guest guest = guestdao.findById(id);
        return guest;
    }

    @Override
    public Collection<Guest> findByLicense(String l_id) {

        Session session = getSession();
        String sql = "SELECT * " +
                "FROM Guest " +
                "WHERE d_License LIKE \"" + l_id + "\"";
        System.out.println(sql);
        SQLQuery query = session.createSQLQuery(sql);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List results = query.list();
        //System.out.println(results.get(0));
        if(results.isEmpty())
            throw new ResourceNotFoundException();
        return results;
    }
}
