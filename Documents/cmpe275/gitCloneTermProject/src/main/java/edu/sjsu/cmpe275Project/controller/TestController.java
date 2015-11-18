package edu.sjsu.cmpe275Project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by emy on 11/15/15.
 */
@Controller
public class TestController {

    @RequestMapping(value="/person")
    //@ResponseBody
    public String intro(){
        System.out.println("HH");
        return "index";
    }
}
