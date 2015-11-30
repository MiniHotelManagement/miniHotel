package edu.sjsu.cmpe275Project.controller;

import edu.sjsu.cmpe275Project.dao.guestDAO;
import edu.sjsu.cmpe275Project.models.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

/**
 * Created by emy on 11/18/15.
 */
@Controller
public class guestController {
    @Autowired
    private guestDAO guestdao;

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
            @RequestParam(value = "fname", required = true) String fname,
            @RequestParam(value = "lname", required = true) String lname,
            @RequestParam(value = "license", required = true) String license,
            @RequestParam(value = "email", required = true) String email
    ){
        Guest gst = new Guest();
        gst.setFirstName(fname);
        gst.setLastName(lname);
        gst.setDriversLicense(license);
        gst.setEmail(email);
        return new ResponseEntity<>(guestdao.create(gst), HttpStatus.OK);
    }

    @RequestMapping(value = "/guest/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity<?> findGuest(
            @PathVariable("id") long id
    ){
        return new ResponseEntity<>(guestdao.findById(id), HttpStatus.OK);
    }
}
