package com.zhaojm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/***
 * 页面跳转的控制台
 * @author matte
 *
 */
@Controller
public class StartContoller {
    
    //登陆系统
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    //管理员主页
    @RequestMapping("/index")
    public String index(){
        return "admin_index";
    }
    //管理员-用户管理
    @RequestMapping("/admin_user_management")
    public String adminUser(){
        return "admin_user_management";
    }
    //管理员-药品管理
    @RequestMapping("/admin_medicine_management")
    public String adminMedicine(){
        return "admin_medicine_management";
    }
    //管理员-疾病库管理
    @RequestMapping("/admin_diseases_management")
    public String adminDisease(){
        return "admin_diseases_management";
    }
    //欢迎页面
    @RequestMapping("/welcome")
    public String main(){
        return "welcome";
    }
    
    //admin_user_add 新增用户
    @RequestMapping("/admin_user_add")
    public String userAdd() {
        return "admin_user_add";
    }
    //管理员-查看编辑用户
    @RequestMapping("/admin_user_edit")
    public String userModfiy() {
        return "admin_user_edit";
    }
    //管理员-查看编辑医生用户
    @RequestMapping("/admin_doctor_edit")
    public String doctorModfiy() {
        return "admin_doctor_edit";
    }
    //管理员-查看编辑病人用户
    @RequestMapping("/admin_patient_edit")
    public String patientModfiy() {
        return "admin_patient_edit";
    }
    //
    @RequestMapping("/admin_diseases_edit")
    public String diseasesModfiy() {
        return "admin_diseases_edit";
    }
    @RequestMapping("/admin_medicine_edit")
    public String medicineModify() {
        return "admin_medicine_edit";
    }
    @RequestMapping("/case_table")
    public String caseTable() {
        return "case_table";
    }
    @RequestMapping("/doctor_index")
    public String doctorIndex() {
        return "doctor_index";
    }

}
