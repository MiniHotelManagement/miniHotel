package edu.sjsu.cmpe275Project.controller;

import edu.sjsu.cmpe275Project.service.ItinaryService;
import edu.sjsu.cmpe275Project.service.occupancyService;
import edu.sjsu.cmpe275Project.service.roomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

/**
 * Created by dexterwei on 11/29/15.
 */


@Controller
public class ServiceController {
    @Autowired
    private roomService roomservice;
    @Autowired
    private occupancyService occupancyservice;
    @Autowired
    private ItinaryService itinaryservice;

    //try this http://localhost:8080/room/search?checkinDate=2015-11-24&checkoutDate=2015-11-25&roomType=K&roomProp=SMK
    @RequestMapping(value = "/room/search", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity<?> SearchRoom(
            @RequestParam(value = "checkinDate", required = true) Date checkindate,
            @RequestParam(value = "checkoutDate", required = true) Date checkoutdate,
            @RequestParam(value = "roomType", required = true) String roomType,
            @RequestParam(value = "roomProp", required = true) String roomProp
    ){
        return new ResponseEntity<>(occupancyservice.searchAvlRoom(checkindate,checkoutdate,roomType,roomProp), HttpStatus.OK);
    }

    //create a guest first
    //then try http://localhost:8080/room/itinary?guestId=1&discount=0&payment=0&paymentDate=2015-11-27
    @RequestMapping(value = "/room/itinary", method = RequestMethod.POST)
     public
     @ResponseBody
     ResponseEntity<?> createItinary(
                    @RequestParam(value = "guestId", required = true) long guestId,
                    @RequestParam(value = "discount", required = true) double discont,
                    @RequestParam(value = "payment", required = true) double payment,
                    @RequestParam(value = "paymentDate", required = false) Date payDate
            ){
        return new ResponseEntity<>(itinaryservice.createItinary(guestId,discont,payment,payDate), HttpStatus.OK);
    }

    @RequestMapping(value = "/room/itinary/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity<?> getItinary(@PathVariable("id") long id){
        return new ResponseEntity<>(itinaryservice.findItinary(id), HttpStatus.OK);
    }


    //create a guest and an itinary first
    //then try http://localhost:8080/room/occupancy?guestId=1&itinaryId=1&roomId=3&checkinDate=2015-11-22&checkoutDate=2015-11-24
    @RequestMapping(value = "/room/occupancy", method = RequestMethod.POST)
    public
    @ResponseBody
    ResponseEntity<?> createOcc(
            @RequestParam(value = "guestId", required = true) long guestId,
            @RequestParam(value = "itinaryId", required = true) long itiId,
            @RequestParam(value = "roomId", required = true) long roomId,
            @RequestParam(value = "checkinDate", required = true) Date inDate,
            @RequestParam(value = "checkoutDate", required = true) Date outDate
    ){
        return new ResponseEntity<>(occupancyservice.createOccupancy(guestId,itiId,roomId,inDate,outDate), HttpStatus.OK);
    }

    @RequestMapping(value = "/room/occupancy/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity<?> getOcc(@PathVariable("id") long id){
        return new ResponseEntity<>(occupancyservice.findItinary(id), HttpStatus.OK);
    }


}
