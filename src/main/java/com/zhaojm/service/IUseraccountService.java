package com.zhaojm.service;

import com.zhaojm.bean.UseraccountDTO;

public interface IUseraccountService {
    
    /**
     * 检查登陆的人的密码 并返回登陆信息
     * @param account
     * @return
     * @throws Exception
     */
    UseraccountDTO verificationLoginUser(UseraccountDTO loginUser) throws Exception;

}
