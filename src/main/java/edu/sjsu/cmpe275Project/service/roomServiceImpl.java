package edu.sjsu.cmpe275Project.service;

import edu.sjsu.cmpe275Project.dao.roomDAO;
import edu.sjsu.cmpe275Project.models.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yingzhu on 11/23/15.
 */
@Service("roomservice")
public class roomServiceImpl implements roomService {

    @Autowired
    private roomDAO roomdao;

    @Override
    public Room create(Room room) {
        roomdao.create(room);
        return room;
    }

    @Override
    public void delete(Long id) {
        roomdao.delete(id);

    }

    @Override
    public void update(Room room) {
        roomdao.update(room);

    }

    @Override
    public Room findById(Long id) {
        Room room = roomdao.findById(id);
        return room;
    }
}
