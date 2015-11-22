package edu.sjsu.cmpe275Project.controller;

import edu.sjsu.cmpe275Project.models.Guest;
import edu.sjsu.cmpe275Project.service.guestService;
import edu.sjsu.cmpe275Project.service.guestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by emy on 11/15/15.
 */
//dummy controller for now...
@Controller
public class TestController {

   // @Autowired
    private guestService guestservice;

    @Autowired
    public void setGuestService(guestService guestservice) {
        this.guestservice = guestservice;
    }

    @RequestMapping(value="/yoyo")
    //@ResponseBody
    public String intro(){
        System.out.println("HH");
        return "index";
    }
    @RequestMapping(value="/person", method = RequestMethod.POST)
    @ResponseBody
    public Guest meme(@RequestBody Guest guest){
        System.out.println("LL");
       Guest guest1 = guestservice.create(guest);
        return guest1;
    }
}
