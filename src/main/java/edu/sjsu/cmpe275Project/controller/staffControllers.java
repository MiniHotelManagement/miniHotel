package edu.sjsu.cmpe275Project.controller;


import edu.sjsu.cmpe275Project.models.Room;
import edu.sjsu.cmpe275Project.service.roomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by emy on 11/18/15.
 */
@Controller
public class staffControllers {

    private roomService roomservice;

    @Autowired
    public void setRoomservice(roomService roomservice) {
        this.roomservice = roomservice;
    }

    @RequestMapping(value = "/staff/room", method = RequestMethod.POST)
    @ResponseBody
    public Room create(@RequestBody Room room) {
        Room room1 = roomservice.create(room);
        return room1;
    }

    @RequestMapping(value = "/staff/room/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Room updateRoom(@PathVariable("id") Long id, @RequestBody Room room) {
        Room room1 = roomservice.update(id, room);
        return room1;
    }

    @RequestMapping(value = "/staff/room/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteRoom(@PathVariable("id")Long id ) {
        roomservice.delete(id);
    }

    @RequestMapping(value = "/staff/room/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Room findRoom(@PathVariable("id")Long id) {
        Room room1 = roomservice.findById(id);
        return room1;
    }
}
