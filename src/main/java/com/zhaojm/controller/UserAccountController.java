package com.zhaojm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.zhaojm.bean.DoctorDTO;
import com.zhaojm.bean.PageRequestDTO;
import com.zhaojm.bean.PatientDTO;
import com.zhaojm.bean.UseraccountDTO;
import com.zhaojm.service.IDoctorService;
import com.zhaojm.service.IPatientService;
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
    
    @Autowired
    IPatientService patientService;
    
    @Autowired
    IDoctorService doctorService;
    
    @RequestMapping(value="/sys/login",method=RequestMethod.POST)
    public ResultDTO<UseraccountDTO> getLoginUser(@RequestBody @ApiParam("登陆用户") UseraccountDTO loginUser,HttpSession session) throws Exception{
        
        UseraccountDTO user = useraccountService.verificationLoginUser(loginUser);
        if(null == user) {
            return ResultDTO.valueOfError("账户或密码错误！");
        }else if(user.getAccountType() == 0) {
            return ResultDTO.valueOfError("账户已被禁用！");
        }else
        session.setAttribute("logUser", user);
        return ResultDTO.valueOfSuccess(user);
    }
    
    @RequestMapping(value="/sys/getUser/{userId}",method=RequestMethod.POST)
    public ResultDTO<UseraccountDTO> getUser(@PathVariable("userId") Integer userId){
        UseraccountDTO user = useraccountService.getUserFull(userId);
        if(null != user) {
            return ResultDTO.valueOfSuccess(user);
        }else {
            return ResultDTO.valueOfError("无法查看管理员信息");
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
    
    @RequestMapping(value="/sys/updateUser",method=RequestMethod.POST)
    public ResultDTO<Integer> updateUser(@RequestBody UseraccountDTO user){
        UseraccountDTO isSave = useraccountService.updateUser(user);
        if(null != isSave)
            return ResultDTO.valueOfSuccess();
        else
            return ResultDTO.valueOfError("操作失败！");
    }
    
    
    @RequestMapping(value="/sys/updatePatient",method=RequestMethod.POST)
    public ResultDTO<Integer> updatePatient(@RequestBody PatientDTO patient){
        PatientDTO isSave = patientService.updatePatient(patient);
        if(null != isSave)
            return ResultDTO.valueOfSuccess();
        else
            return ResultDTO.valueOfError("操作失败！");
    }
    
    @RequestMapping(value="/sys/updateDoctor",method=RequestMethod.POST)
    public ResultDTO<Integer> updateDoctor(@RequestBody DoctorDTO doctor){
        DoctorDTO isSave = doctorService.updateDoctor(doctor);
        if(null != isSave)
            return ResultDTO.valueOfSuccess();
        else
            return ResultDTO.valueOfError("操作失败！");
    }
    
    @RequestMapping(value="/sys/getPatientName",method=RequestMethod.POST)
    public ResultDTO<List<PatientDTO>> getPatientName(@RequestBody PatientDTO patient){
        List<PatientDTO> list = useraccountService.queryPatientName(patient);
        
        return ResultDTO.valueOfSuccess(list);
    }
    
    
}
