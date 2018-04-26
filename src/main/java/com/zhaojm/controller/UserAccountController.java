package com.zhaojm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.zhaojm.bean.PageRequestDTO;
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
    
    @RequestMapping(value="/sys/login",method=RequestMethod.POST)
    public ResultDTO<UseraccountDTO> getLoginUser(@RequestBody @ApiParam("登陆用户") UseraccountDTO loginUser,HttpSession session) throws Exception{
        
        UseraccountDTO user = useraccountService.verificationLoginUser(loginUser);
        if(null == user)
            return ResultDTO.valueOfError("账户或密码错误！");
        else {
            session.setAttribute("logUser", user);
            return ResultDTO.valueOfSuccess(user);
        }
    }
    
    @RequestMapping(value="/sys/getUserList",method=RequestMethod.POST)
    public ResultDTO<PageInfo<UseraccountDTO>> getUserList(@RequestBody PageRequestDTO<UseraccountDTO> queryUser){
        return ResultDTO.valueOfSuccess(useraccountService.queryUserList(queryUser));
    }
    
    //1存在 0不存在
    @RequestMapping(value="/sys/verfiy",method=RequestMethod.POST)
    public ResultDTO<Integer> verfiyName(@RequestBody UseraccountDTO user) {
        int isCave = useraccountService.verfiy(user);
        if(isCave>0) {
            return ResultDTO.valueOfSuccess();
        }else {
            return ResultDTO.valueOfError("error");
        }
    }
    @RequestMapping(value="/sys/creatUser",method=RequestMethod.POST)
    public ResultDTO<Integer> creatUser(@RequestBody UseraccountDTO user){
        int isSave = useraccountService.creadUseraccount(user);
        if(isSave>0)
            return ResultDTO.valueOfSuccess();
        else
            return ResultDTO.valueOfError("添加未成功！");
    }
    
    @RequestMapping(value="/sys/update",method=RequestMethod.POST)
    public ResultDTO<Integer> updateUser(@RequestBody UseraccountDTO user){
        UseraccountDTO isSave = useraccountService.updateUser(user);
        if(null != isSave)
            return ResultDTO.valueOfSuccess();
        else
            return ResultDTO.valueOfError("操作失败！");
    }
    
    
}
