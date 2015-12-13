package edu.sjsu.cmpe275Project.controller;

import edu.sjsu.cmpe275Project.models.Itinary;
import edu.sjsu.cmpe275Project.models.Occupancy;
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
    @RequestMapping(value = "/guest/search", method = RequestMethod.POST)
    public
    @ResponseBody
    ResponseEntity<?> SearchRoom(
            @RequestBody Occupancy occupancy
    ){

        System.out.println("Get room type is "+ occupancy.getRoom());
        return new ResponseEntity<>(occupancyservice.searchAvlRoom(occupancy), HttpStatus.OK);
    }

    //try this http://localhost:8080/room/report?date=2015-11-24
    @RequestMapping(value = "/staff/report", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity<?> SearchRoom(
            @RequestParam(value = "date", required = true) Date date

    ){
        return new ResponseEntity<>(occupancyservice.RoomStatus(date), HttpStatus.OK);
    }
    //create a guest first
    //then try http://localhost:8080/staff/itinary?guestId=1&discount=0&payment=0&paymentDate=2015-11-27
    @RequestMapping(value = "/staff/itinary", method = RequestMethod.POST)
     public
     @ResponseBody
     ResponseEntity<?> createItinary(
            @RequestBody Itinary iti
            ){
        //return new ResponseEntity<>(itinaryservice.createItinary(guestId,discont,payment,payDate), HttpStatus.OK);
        return new ResponseEntity<>(itinaryservice.createItinary(iti), HttpStatus.OK);
    }

    @RequestMapping(value = "/staff/itinary/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity<?> getItinary(@PathVariable("id") long id){
        return new ResponseEntity<>(itinaryservice.findItinary(id), HttpStatus.OK);
    }


    //create a guest and an itinary first
    //then try http://localhost:8080/staff/occupancy?guestId=1&itinaryId=1&roomId=3&checkinDate=2015-11-22&checkoutDate=2015-11-24
    @RequestMapping(value = "/staff/occupancy", method = RequestMethod.POST)
    public
    @ResponseBody
    ResponseEntity<?> createOcc(
            @RequestBody Occupancy occ
    ){
        //return new ResponseEntity<>(occupancyservice.createOccupancy(guestId,itiId,roomId,num, inDate,outDate), HttpStatus.OK);}
        return new ResponseEntity<>(occupancyservice.createOccupancy(occ), HttpStatus.OK);
     }

    @RequestMapping(value = "/staff/occupancy/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity<?> getOcc(@PathVariable("id") long id){
        return new ResponseEntity<>(occupancyservice.findItinary(id), HttpStatus.OK);
    }


}
