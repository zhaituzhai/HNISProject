package com.zhaojm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StartContoller {
    
    @RequestMapping("/index")
    public String login(){
        return "login";
    }

}
