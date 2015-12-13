package edu.sjsu.cmpe275Project.controller;

import edu.sjsu.cmpe275Project.models.Guest;
import edu.sjsu.cmpe275Project.service.guestService;
import edu.sjsu.cmpe275Project.util.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by emy on 11/18/15.
 */
@Controller
public class guestController {
    @Autowired
    private guestService guestservice;

    @RequestMapping(value={"/", "/welcome"}, method = RequestMethod.GET)
    public String homePage() {
        return "index";
    }

    @RequestMapping(value="/guest" , method = RequestMethod.GET)
    public String search() {
        return "guest";
    }

    @RequestMapping(value = "/guest", method = RequestMethod.POST)
    public
    @ResponseBody
    ResponseEntity<?> createGuest(
            @RequestBody Guest gst
    ){
        return new ResponseEntity<>(guestservice.create(gst), HttpStatus.OK);
    }

    @RequestMapping(value = "/guest/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity<?> findGuestByID(
            @PathVariable("id") long id
    ){
        return new ResponseEntity<>(guestservice.findById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/guest/license/{num}", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity<?> findGuestByDLic(
            @PathVariable("num") String num
    ){
            Collection<Guest> rst = guestservice.findByLicense(num);
      //      return new ResponseEntity<>(rst, HttpStatus.OK);

            return new ResponseEntity(rst,HttpStatus.OK);

    }
}
