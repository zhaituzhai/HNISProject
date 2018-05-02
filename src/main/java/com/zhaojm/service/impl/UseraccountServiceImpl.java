package com.zhaojm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhaojm.bean.DoctorDTO;
import com.zhaojm.bean.PageRequestDTO;
import com.zhaojm.bean.PatientDTO;
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
            String type = exiseUser.getUserType();
            if(type == UserTypeEnum.USER_TYPE_DOCTOR.getMessage()){
                exiseUser.setDoctor(doctorMapper.selectByPrimaryKey(exiseUser.getUserId()));
            }else if(type == UserTypeEnum.USER_TYPR_PATIENT.getMessage()) {
                exiseUser.setPatient(patientMapper.selectByPrimaryKey(exiseUser.getUserId()));
            }
            return exiseUser;
        }  
    }

    /**
     * 创建user 0->name错误  -1 -> 未知错误  >0 添加成功
     */
    @Override
    public int creadUseraccount(UseraccountDTO user) {
        
        String phoneRegex = "[0-9]{11}";
        if(!user.getUserPhone().matches(phoneRegex))
            return 0;
        else if(useraccountMapper.insertSelective(user)>0)
            return 1;
        else
            return -1;
    }

    /**
     * 分页查询出 按要求 查出的list
     */
    @Override
    public PageInfo<UseraccountDTO> queryUserList(PageRequestDTO<UseraccountDTO> pageUser) {
        
        PageHelper.startPage(pageUser.getPageNum(),pageUser.getPageSize());
        
        List<UseraccountDTO> list = useraccountMapper.queryUserList(pageUser.getParam());
        
        return new PageInfo<UseraccountDTO>(list);
    }

    
    /**
     * 更改信息 返回 更改后的信息
     */
    @Override
    public UseraccountDTO updateUser(UseraccountDTO user) {
        int isUpdate = useraccountMapper.updateByPrimaryKeySelective(user);
        if(isUpdate < 0) 
            return null;
        else
            return useraccountMapper.selectByPrimaryKey(user.getUserId());
    }
    
    @Override
    public UseraccountDTO getUserFull(Integer userId) {
        UseraccountDTO user = useraccountMapper.selectByPrimaryKey(userId);
        if("2".equals(user.getUserType())) {
            user.setDoctor(doctorMapper.selectByUserId(userId));
            return user;
        }else if("3".equals(user.getUserType())) {
            user.setPatient(patientMapper.selectByUserId(userId));
            return user;
        }else {
            return null;
        }
    }

    @Override
    public DoctorDTO queryDoctorById(Integer id) {
        
        return doctorMapper.selectByPrimaryKey(id);
    }

    @Override
    public PatientDTO queryPatientById(Integer id) {
        
        return patientMapper.selectByUserId(id);
    }

    @Override
    public int verfiy(UseraccountDTO user) {
        if(null != useraccountMapper.selectByNamePhone(user))
            return 1;
        else
            return 0;
    }

    @Override
    public List<PatientDTO> queryPatientName(PatientDTO patient) {
        
        return patientMapper.queryPatientList(patient);
    }

}
