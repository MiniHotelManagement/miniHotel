package edu.sjsu.cmpe275Project.dao;

import edu.sjsu.cmpe275Project.models.Itinary;
import edu.sjsu.cmpe275Project.models.Occupancy;

/**
 * Created by dexterwei on 11/25/15.
 */
public interface ItinaryDAO {
    Itinary create(Itinary occ);
    Itinary update(Long id, Itinary occ);
    void delete(Long id);
    Itinary findById(Long id);
}
