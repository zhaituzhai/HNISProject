package com.zhaojm.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zhaojm.bean.DoctorDTO;
import com.zhaojm.bean.PageRequestDTO;
import com.zhaojm.bean.PatientDTO;
import com.zhaojm.bean.UseraccountDTO;

public interface IUseraccountService {
    
    /**
     * 检查登陆的人的密码 并返回登陆信息
     * @param account
     * @return
     * @throws Exception
     */
    UseraccountDTO verificationLoginUser(UseraccountDTO loginUser) throws Exception;
    
    int creadUseraccount(UseraccountDTO user);
    /**
     * 根据user查询条件分页查出list
     * @param user
     * @return
     */
    PageInfo<UseraccountDTO> queryUserList(PageRequestDTO<UseraccountDTO> user);
    
    UseraccountDTO updateUser(UseraccountDTO user);
    
    UseraccountDTO getUserFull(Integer userId);
    
    DoctorDTO queryDoctorById(Integer id);
    
    PatientDTO queryPatientById(Integer id);

    int verfiy(UseraccountDTO user);
    
    List<PatientDTO> queryPatientName(PatientDTO patient);

}
