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

    private roomDAO roomdao;

    @Autowired
    public void setRoomdao(roomDAO roomdao) {
        this.roomdao = roomdao;
    }

    @Override
    public Room create(Room room) {
        Room newRoom = roomdao.create(room);
        return newRoom;
    }

    @Override
    public Room update(Long id, Room room) {
        Room newRoom = roomdao.update(id,room);
        return newRoom;
    }

    @Override
    public void delete(Long id) {
        roomdao.delete(id);
    }

    @Override
    public Room findById(Long id) {
        Room newRoom = roomdao.findById(id);
        return newRoom;
    }

}
