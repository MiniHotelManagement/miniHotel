package edu.sjsu.cmpe275Project.dao;

import edu.sjsu.cmpe275Project.models.Occupancy;

/**
 * Created by dexterwei on 11/25/15.
 */
public interface OccupancyDAO {
    Occupancy create(Occupancy occ);
    Occupancy update(Long id, Occupancy occ);
    void delete(Long id);
    Occupancy findById(Long id);
}
