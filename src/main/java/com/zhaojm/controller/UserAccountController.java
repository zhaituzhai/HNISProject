package com.zhaojm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhaojm.bean.UseraccountDTO;
import com.zhaojm.service.IUseraccountService;
import com.zhaojm.util.ResultDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;

@Api(value = "登陆注册", tags = {"登陆注册"})
@RestController
@RequestMapping
public class UserAccountController {
    
    @Autowired
    IUseraccountService useraccountService;
    
    public ResultDTO<UseraccountDTO> getLoginUser(@RequestBody @ApiParam("登陆用户") UseraccountDTO loginUser) throws Exception{
        
        useraccountService.verificationLoginUser(loginUser);
        ResultDTO.valueOfError("");
        
        return null;
    }
    

}
