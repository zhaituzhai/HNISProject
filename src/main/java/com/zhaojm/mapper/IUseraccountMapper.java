package com.zhaojm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.zhaojm.bean.UseraccountDTO;

@Mapper
public interface IUseraccountMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(UseraccountDTO record);

    int insertSelective(UseraccountDTO record);

    UseraccountDTO selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UseraccountDTO record);

    int updateByPrimaryKey(UseraccountDTO record);

    UseraccountDTO selectByAccount(String loginName);
}