package com.zhaojm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StartContoller {
    
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    
    @RequestMapping("/index")
    public String index(){
        return "admin_index";
    }
    
    @RequestMapping("/admin_user_management")
    public String adminUser(){
        return "admin_user_management";
    }
    @RequestMapping("/admin_medicine_management")
    public String adminMedicine(){
        return "admin_medicine_management";
    }
    @RequestMapping("/admin_diseases_management")
    public String adminDisease(){
        return "admin_diseases_management";
    }
    @RequestMapping("/admin_role_management")
    public String adminRole(){
        return "admin_role_management";
    }
    @RequestMapping("/welcome")
    public String main(){
        return "welcome";
    }
    //admin_user_add
    @RequestMapping("/admin_user_add")
    public String userAdd() {
        return "admin_user_add";
    }


}
