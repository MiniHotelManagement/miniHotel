package edu.sjsu.cmpe275Project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by emy on 11/18/15.
 */
@Controller
public class guestController {

    @RequestMapping(value={"/", "/welcome"}, method = RequestMethod.GET)
    public String homePage() {
        return "index";
    }
}
