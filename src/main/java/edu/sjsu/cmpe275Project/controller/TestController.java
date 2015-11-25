package edu.sjsu.cmpe275Project.controller;

import edu.sjsu.cmpe275Project.models.Guest;
import edu.sjsu.cmpe275Project.models.Reservation;
import edu.sjsu.cmpe275Project.service.guestService;
import edu.sjsu.cmpe275Project.service.guestServiceImpl;
import edu.sjsu.cmpe275Project.service.reservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by emy on 11/15/15.
 */
//dummy controller for now...
    //All this methods will be put in guestController
    //for now just to test in postman and verifies it works
@Controller
public class TestController {

    /*private guestService guestservice;

    @Autowired
    public void setGuestService(guestService guestservice) {
        this.guestservice = guestservice;
    }

//    @RequestMapping(value="/yoyo")
//    //@ResponseBody
//    public String intro(){
//        System.out.println("HH");
//        return "index";
//    }
//    @RequestMapping(value="/guest")
//    //@ResponseBody
//    public String next(){
//        System.out.println("HH");
//        return "guest";
//    }
    //example and works
    @RequestMapping(value="/person", method = RequestMethod.POST)
    @ResponseBody
    public Guest meme(@RequestBody Guest guest){
       Guest guest1 = guestservice.create(guest);
        return guest1;
    }

    //example
    @RequestMapping(value="/person/{id}")
    @ResponseBody
    public Guest findGuest(@PathVariable("id")Long id) {
        Guest guest = guestservice.findById(id);
        return guest;
    }

    @RequestMapping(value="/person/{id}", method=RequestMethod.POST)
    @ResponseBody
    public Guest update(@PathVariable("id")Long id, @RequestBody Guest guest){
        Guest guest1 = guestservice.update(id, guest);
        return guest1;
    }*/
    private reservationService reservationservice;

    @Autowired
    public void setReservationservice(reservationService reservationservice) {
        this.reservationservice = reservationservice;
    }

    @RequestMapping(value="/reservation", method = RequestMethod.POST)
    @ResponseBody
    public Reservation create(@RequestBody Reservation reservation){
        return reservationservice.create(reservation);
    }
}
