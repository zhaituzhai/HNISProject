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
    
    @RequestMapping("/getLoginUser")
    public ResultDTO<UseraccountDTO> getLoginUser(@RequestBody @ApiParam("登陆用户") UseraccountDTO loginUser) throws Exception{
        
        UseraccountDTO user = useraccountService.verificationLoginUser(loginUser);
        if(null == user)
            return ResultDTO.valueOfError("账户或密码错误！");
        else
            return ResultDTO.valueOfSuccess(user);
    }
    

}
