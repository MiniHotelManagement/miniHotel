package edu.sjsu.cmpe275Project.controller;


import edu.sjsu.cmpe275Project.models.Room;
import edu.sjsu.cmpe275Project.service.roomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping(value = "/room", method = RequestMethod.POST)
    @ResponseBody
    public Room create(@RequestBody Room room) {
        Room room1 = roomservice.create(room);
        return room1;
    }
}
