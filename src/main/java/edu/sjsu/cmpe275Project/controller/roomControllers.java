package edu.sjsu.cmpe275Project.controller;

import edu.sjsu.cmpe275Project.models.Room;
import edu.sjsu.cmpe275Project.service.occupancyService;
import edu.sjsu.cmpe275Project.service.roomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by yingzhu on 11/23/15.
 */

@Controller
public class roomControllers {

//    @Autowired
//    private roomService roomservice;
//
//    @RequestMapping(value="/room", method = RequestMethod.POST)
//    @ResponseBody
//    public Room addRoom(@RequestBody Room room){
//        Room room1 = roomservice.create(room);
//        return room1;
//    }
//
//    @RequestMapping(value="/testroom")
//    //@ResponseBody
//    public void test(){
//        System.out.print("POST is allowed here");
//    }
//
//
//    @RequestMapping(value="/room/update/{id}", method = RequestMethod.POST)
//    @ResponseBody
//    public Room updateRoom(@Valid @PathVariable("id") long id, @RequestBody Room room){
//        Room room1 = roomservice.findById(id);
//        if(room1!=null) {
//            room.setId(id);
//            roomservice.update(id, room);
//        }
//        room1 = roomservice.findById(id);
//        return room1;
//    }
//
//    @RequestMapping(value="/room/{id}", method = RequestMethod.GET)
//    @ResponseBody
//    public Room getRoom(@Valid @PathVariable("id") long id){
//        Room room1 = roomservice.findById(id);
//        return room1;
//    }
//
//
//    @RequestMapping(value="/room/{id}", method = RequestMethod.DELETE)
//    @ResponseBody
//    public void deleteRoom(@Valid @PathVariable("id") long id){
//        roomservice.delete(id);
//    }

}
