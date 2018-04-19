package com.zhaojm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhaojm.bean.UseraccountDTO;
import com.zhaojm.enums.UserTypeEnum;
import com.zhaojm.mapper.IDoctorMapper;
import com.zhaojm.mapper.IPatientMapper;
import com.zhaojm.mapper.IUseraccountMapper;
import com.zhaojm.service.IUseraccountService;

@Service
public class UseraccountServiceImpl implements IUseraccountService {

    @Autowired
    IUseraccountMapper useraccountMapper;
    
    @Autowired
    IDoctorMapper doctorMapper;
    
    @Autowired
    IPatientMapper patientMapper;

    @Override
    public UseraccountDTO verificationLoginUser(UseraccountDTO loginUser) throws Exception {
        String loginName = loginUser.getUserName();
        UseraccountDTO exiseUser = useraccountMapper.selectByAccount(loginName);
        if(exiseUser == null || !(exiseUser.getPassword().equals(loginUser.getPassword())) ) {
            return null;
        }else {
            int type = exiseUser.getUserType();
            if(type == UserTypeEnum.USER_TYPE_DOCTOR.getTypeCode()){
                exiseUser.setDoctor(doctorMapper.selectByPrimaryKey(exiseUser.getUserId()));
            }else if(type == UserTypeEnum.USER_TYPR_PATIENT.getTypeCode()) {
                exiseUser.setPatient(patientMapper.selectByPrimaryKey(exiseUser.getUserId()));
            }
            return exiseUser;
        }  
    }

    @Override
    public int creadUseraccount(UseraccountDTO user) {
        
        String regex = "[0-9]{11}";
        if(user.getUserPhone().matches(regex)){
            
        }
        
        
        
        return useraccountMapper.insert(user);
    }    

}
