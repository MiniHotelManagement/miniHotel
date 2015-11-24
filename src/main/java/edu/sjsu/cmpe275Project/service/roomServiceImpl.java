package edu.sjsu.cmpe275Project.service;

import edu.sjsu.cmpe275Project.dao.roomDAO;
import edu.sjsu.cmpe275Project.models.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by emy on 11/23/15.
 */
@Service("roomservice")
public class roomServiceImpl implements roomService {
    @Autowired
    private roomDAO roomdao;
    @Override
    public Room create(Room room) {
        Room room1 = roomdao.create(room);
        return room1;
    }
}
